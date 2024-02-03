package net.kuro.recrafted.structure.block.connectedtextures.model;

import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class WrappedBakedModel implements BakedModel, FabricBakedModel {

    protected final BakedModel original;

    public WrappedBakedModel(BakedModel original){
        this.original = original;
    }

    @Override
    public boolean isVanillaAdapter(){
        return ((FabricBakedModel)this.original).isVanillaAdapter();
    }

    @Override
    public void emitBlockQuads(BlockRenderView blockView, BlockState state, BlockPos pos, Supplier<Random> randomSupplier, RenderContext context){
        ((FabricBakedModel)this.original).emitBlockQuads(blockView, state, pos, randomSupplier, context);
    }

    @Override
    public void emitItemQuads(ItemStack stack, Supplier<Random> randomSupplier, RenderContext context){
        ((FabricBakedModel)this.original).emitItemQuads(stack, randomSupplier, context);
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction direction, Random random){
        return this.original.getQuads(state, direction, random);
    }

    @Override
    public boolean useAmbientOcclusion(){
        return this.original.useAmbientOcclusion();
    }

    @Override
    public boolean hasDepth(){
        return this.original.hasDepth();
    }

    @Override
    public boolean isSideLit(){
        return this.original.isSideLit();
    }

    @Override
    public boolean isBuiltin(){
        return this.original.isBuiltin();
    }

    @Override
    public Sprite getParticleSprite(){
        return this.original.getParticleSprite();
    }

    @Override
    public ModelTransformation getTransformation(){
        return this.original.getTransformation();
    }

    @Override
    public ModelOverrideList getOverrides(){
        return this.original.getOverrides();
    }
}
