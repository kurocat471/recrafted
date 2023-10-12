package net.kuro.recrafted.block.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kuro.recrafted.block.custom.PotionCauldronBlock;
import net.kuro.recrafted.block.entity.PotionCauldronBlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public class PotionCauldronBlockEntityRenderer implements BlockEntityRenderer<PotionCauldronBlockEntity>
{
    private static final float[] FLUID_HEIGHT = { 0, 0.5625f, 0.75f, 0.9375f };
    private static final SpriteIdentifier WATER_MATERIAL = new SpriteIdentifier(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, new Identifier("block/water_still"));

    public PotionCauldronBlockEntityRenderer(BlockEntityRendererFactory.Context ignored)
    {

    }

    @Override
    public void render(PotionCauldronBlockEntity entity, float partialTick, MatrixStack poseStack, VertexConsumerProvider buffer, int packedLight, int packedOverlay) {
        int liquidLevel = entity.getCachedState().get(PotionCauldronBlock.LEVEL);
        if (liquidLevel == 0)
            return;

        Potion potion = entity.getPotion();

        int color = PotionUtil.getColor(potion);
        int red = color >> 16 & 255;
        int green = color >> 8 & 255;
        int blue = color & 255;
        int alpha = 190;

        Sprite water = WATER_MATERIAL.getSprite();

        poseStack.push();
        poseStack.translate(0, FLUID_HEIGHT[liquidLevel], 0);

        VertexConsumer consumer = buffer.getBuffer(RenderLayer.getTranslucentMovingBlock());
        Matrix4f matrix = poseStack.peek().getPositionMatrix();

        float sizeFactor = 0.125f;
        float maxV = (water.getMaxV() - water.getMinV()) * sizeFactor;
        float minV = (water.getMaxV() - water.getMinV()) * (1 - sizeFactor);

        consumer.vertex(matrix, sizeFactor, 0, 1 - sizeFactor).color(red, green, blue, alpha).texture(water.getMinU(), water.getMinV() + maxV).light(packedLight).overlay(packedOverlay).normal(1, 1, 1).next();
        consumer.vertex(matrix, 1 - sizeFactor, 0, 1 - sizeFactor).color(red, green, blue, alpha).texture(water.getMaxU(), water.getMinV() + maxV).light(packedLight).overlay(packedOverlay).normal(1, 1, 1).next();
        consumer.vertex(matrix, 1 - sizeFactor, 0, sizeFactor).color(red, green, blue, alpha).texture(water.getMaxU(), water.getMinV() + minV).light(packedLight).overlay(packedOverlay).normal(1, 1, 1).next();
        consumer.vertex(matrix, sizeFactor, 0, sizeFactor).color(red, green, blue, alpha).texture(water.getMinU(), water.getMinV() + minV).light(packedLight).overlay(packedOverlay).normal(1, 1, 1).next();

        poseStack.pop();
    }
}
