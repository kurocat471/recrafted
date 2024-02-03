package net.kuro.recrafted.structure.block.connectedtextures.model.types.connecting;

import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh;
import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.SpriteFinder;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.kuro.recrafted.RecraftedClient;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionPredicate;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.DefaultTextureTypes;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.SpriteHelper;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ConnectingTextureData;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ConnectingTextureLayout;
import net.kuro.recrafted.structure.block.connectedtextures.model.WrappedBakedModel;
import net.kuro.recrafted.structure.block.connectedtextures.texture.types.connecting.ConnectingTextureLayoutHelper;
import net.kuro.recrafted.structure.block.connectedtextures.texture.types.connecting.ConnectingTextureSprite;
import net.kuro.recrafted.structure.block.connectedtextures.util.TextureAtlases;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.AffineTransformation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import java.util.Map;
import java.util.function.Supplier;

public class ConnectingBakedModel extends WrappedBakedModel {

    private final AffineTransformation modelRotation;
    private final Map<Identifier, ConnectionPredicate> predicates;
    // [cullface][hashcode * 6]
    private final IntObjectMap<Mesh> quadCache = new IntObjectHashMap<>();
    private final ThreadLocal<MeshBuilder> meshBuilder = ThreadLocal.withInitial(() -> RendererAccess.INSTANCE.getRenderer().meshBuilder());

    public ConnectingBakedModel(BakedModel original, AffineTransformation modelRotation, Map<Identifier,ConnectionPredicate> predicates){
        super(original);
        this.modelRotation = modelRotation;
        this.predicates = predicates;
    }

    @Override
    public void emitBlockQuads(BlockRenderView blockView, BlockState state, BlockPos pos, Supplier<Random> randomSupplier, RenderContext context){
        SurroundingBlockData data = blockView == null || pos == null ? null : this.getModelData(blockView, pos, state);
        int hashCode = data == null ? 0 : data.hashCode();

        // Get the quads from the cache
        Mesh quads;
        synchronized(this.quadCache){
            quads = this.quadCache.get(hashCode);
        }

        if(quads == null){
            // Capture the quads
            MeshBuilder meshBuilder = this.meshBuilder.get();
            QuadEmitter meshEmitter = meshBuilder.getEmitter();
            context.pushTransform(quad -> {
                meshEmitter.copyFrom(quad);
                meshEmitter.emit();
                return true;
            });

            // Transform the quads
            SpriteFinder spriteFinder = SpriteFinder.get(MinecraftClient.getInstance().getBakedModelManager().getAtlas(TextureAtlases.getBlocks()));
            context.pushTransform(quad -> this.remapQuad(quad, spriteFinder.find(quad), data));

            // Submit the original model
            this.original.emitBlockQuads(blockView, state, pos, randomSupplier, context);

            // Pop the transforms
            context.popTransform();
            context.popTransform();

            // Cache the collected quads
            quads = meshBuilder.build();
            synchronized(this.quadCache){
                this.quadCache.putIfAbsent(hashCode, quads);
            }
        }else{
            // Submit the quads
            quads.outputTo(context.getEmitter());
        }
    }

    @Override
    public void emitItemQuads(ItemStack stack, Supplier<Random> randomSupplier, RenderContext context){
        this.original.emitItemQuads(stack, randomSupplier, context);
    }

    protected boolean remapQuad(MutableQuadView quad, Sprite sprite, SurroundingBlockData surroundingBlocks){
        if(SpriteHelper.getTextureType(sprite) != DefaultTextureTypes.CONNECTING)
            return true;
        ConnectingTextureLayout layout = ((ConnectingTextureSprite)sprite).getLayout();

        // Mark the render type for the quad
        ConnectingTextureData.RenderType renderType = ((ConnectingTextureSprite)sprite).getRenderType();
        if(renderType != null)
            quad.material(RecraftedClient.getRenderTypeMaterial(renderType));

        // Adjust the uv
        Identifier spriteIdentifier = sprite.getContents() == null || sprite.getContents().getId() == null ? ConnectingModelType.DEFAULT_CONNECTION_KEY : sprite.getContents().getId();
        if(!this.predicates.containsKey(spriteIdentifier))
            spriteIdentifier = ConnectingModelType.DEFAULT_CONNECTION_KEY;
        SurroundingBlockData.SideConnections connections = surroundingBlocks.getConnections(spriteIdentifier, quad.nominalFace());
        int[] uv = ConnectingTextureLayoutHelper.getStatePosition(layout, connections);
        adjustVertexDataUV(quad, uv[0], uv[1], sprite);

        // Create a new quad
        return true;
    }

    private static void adjustVertexDataUV(MutableQuadView quad, int newU, int newV, Sprite sprite){
        for(int i = 0; i < 4; i++){
            float width = sprite.getMaxU() - sprite.getMinU();
            float u = quad.u(i) + width * newU;

            float height = sprite.getMaxV() - sprite.getMinV();
            float v = quad.v(i) + height * newV;
            quad.uv(i, u, v);
        }
    }

    public SurroundingBlockData getModelData(BlockRenderView level, BlockPos pos, BlockState state){
        return SurroundingBlockData.create(level, pos, this.modelRotation, this.predicates);
    }

    @Override
    public boolean isVanillaAdapter(){
        return false;
    }

    @Override
    public boolean isBuiltin(){
        return super.isBuiltin();
    }

    @Override
    public ModelTransformation getTransformation(){
        return super.getTransformation();
    }

    @Override
    public ModelOverrideList getOverrides(){
        return ModelOverrideList.EMPTY;
    }
}
