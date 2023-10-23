package net.kuro.recrafted.block.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.block.entity.WaterCauldronBlockEntity;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public class WaterCauldronBlockEntityRenderer implements BlockEntityRenderer<WaterCauldronBlockEntity>
{
    private static final float[] FLUID_HEIGHT = { 0, 0.5625f, 0.75f, 0.9375f };
    private static final SpriteIdentifier WATER_MATERIAL = new SpriteIdentifier(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, new Identifier("block/water_still"));

    public WaterCauldronBlockEntityRenderer(BlockEntityRendererFactory.Context ignored) {

    }

    @Override
    public void render(WaterCauldronBlockEntity entity, float partialTick, MatrixStack poseStack, VertexConsumerProvider buffer, int packedLight, int packedOverlay) {
        int liquidLevel = entity.getCachedState().get(LeveledCauldronBlock.LEVEL);
        if (liquidLevel == 0)
            return;

        int color = BiomeColors.getWaterColor(Objects.requireNonNull(entity.getWorld()), entity.getPos());
        int red = color >> 16 & 255;
        int green = color >> 8 & 255;
        int blue = color & 255;
        int alpha = 255;

        Sprite water = WATER_MATERIAL.getSprite();

        poseStack.push();
        poseStack.translate(0, FLUID_HEIGHT[liquidLevel], 0);

        VertexConsumer consumer = buffer.getBuffer(RenderLayer.getTranslucentMovingBlock());
        Matrix4f matrix = poseStack.peek().getPositionMatrix();

        float sizeFactor = 0.125f;
        float minV = (water.getMaxV() - water.getMinV()) * sizeFactor;
        float maxV = (water.getMaxV() - water.getMinV()) * (1 - sizeFactor);
        float minU = (water.getMaxU() - water.getMinU()) * sizeFactor;
        float maxU = (water.getMaxU() - water.getMinU()) * (1 - sizeFactor);

        consumer.vertex(matrix, sizeFactor, 0, 1 - sizeFactor).color(red, green, blue, alpha).texture(water.getMinU() + minU, water.getMinV() + maxV).light(packedLight).overlay(packedOverlay).normal(1, 1, 1).next();
        consumer.vertex(matrix, 1 - sizeFactor, 0, 1 - sizeFactor).color(red, green, blue, alpha).texture(water.getMinU() + maxU, water.getMinV() + maxV).light(packedLight).overlay(packedOverlay).normal(1, 1, 1).next();
        consumer.vertex(matrix, 1 - sizeFactor, 0, sizeFactor).color(red, green, blue, alpha).texture(water.getMinU() + maxU, water.getMinV() + minV).light(packedLight).overlay(packedOverlay).normal(1, 1, 1).next();
        consumer.vertex(matrix, sizeFactor, 0, sizeFactor).color(red, green, blue, alpha).texture(water.getMinU() + minU, water.getMinV() + minV).light(packedLight).overlay(packedOverlay).normal(1, 1, 1).next();

        poseStack.pop();
    }
}
