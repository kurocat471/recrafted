package net.kuro.recrafted.block.entity.renderer;

import net.kuro.recrafted.block.custom.AnvilBlock;
import net.kuro.recrafted.block.entity.AnvilBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class AnvilBlockEntityRenderer implements BlockEntityRenderer<AnvilBlockEntity> {
    public AnvilBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(AnvilBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack itemStackOutput = entity.getRenderStackOutput();
        ItemStack itemStackInput1 = entity.getRenderStackInput1();
        ItemStack itemStackInput2 = entity.getRenderStackInput2();
        MatrixStack defaultMatrices = matrices;
        matrices.push();
        if (entity.getCachedState().get(AnvilBlock.FACING) == Direction.NORTH) {
            matrices.translate(0.18f, 0.51171875f, 0.5f);
        } else if (entity.getCachedState().get(AnvilBlock.FACING) == Direction.SOUTH) {
            matrices.translate(0.82f, 0.51171875f, 0.5f);
        } else if (entity.getCachedState().get(AnvilBlock.FACING) == Direction.WEST) {
            matrices.translate(0.5f, 0.51171875f, 0.82f);
        } else {
            matrices.translate(0.5f, 0.51171875f, 0.18f);
        }
        matrices.scale(0.375f, 0.375f, 0.375f);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(entity.getCachedState().get(AnvilBlock.FACING).asRotation() + 15));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
        itemRenderer.renderItem(itemStackOutput, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);

        if (itemStackInput1 != null)  {
            matrices.pop();
            matrices = defaultMatrices;
            matrices.push();
            if (entity.getCachedState().get(AnvilBlock.FACING) == Direction.NORTH) {
                matrices.translate(0.65f, 0.51171875f, 0.5f);
            } else if (entity.getCachedState().get(AnvilBlock.FACING) == Direction.SOUTH) {
                matrices.translate(0.35f, 0.51171875f, 0.5f);
            } else if (entity.getCachedState().get(AnvilBlock.FACING) == Direction.WEST) {
                matrices.translate(0.5f, 0.51171875f, 0.35f);
            } else {
                matrices.translate(0.5f, 0.51171875f, 0.65f);
            }
            matrices.scale(0.375f, 0.375f, 0.375f);
            matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(entity.getCachedState().get(AnvilBlock.FACING).asRotation() - 40));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
            itemRenderer.renderItem(itemStackInput1, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                    entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        }
        
        if (itemStackInput2 != null)  {
            matrices.pop();
            matrices = defaultMatrices;
            matrices.push();
            if (entity.getCachedState().get(AnvilBlock.FACING) == Direction.NORTH) {
                matrices.translate(0.55f, 0.53515625f, 0.5f);
            } else if (entity.getCachedState().get(AnvilBlock.FACING) == Direction.SOUTH) {
                matrices.translate(0.45f, 0.53515625f, 0.5f);
            } else if (entity.getCachedState().get(AnvilBlock.FACING) == Direction.WEST) {
                matrices.translate(0.5f, 0.53515625f, 0.45f);
            } else {
                matrices.translate(0.5f, 0.53515625f, 0.55f);
            }
            matrices.scale(0.375f, 0.375f, 0.375f);
            matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(entity.getCachedState().get(AnvilBlock.FACING).asRotation() - 10));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
            itemRenderer.renderItem(itemStackInput2, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                    entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        }

        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
