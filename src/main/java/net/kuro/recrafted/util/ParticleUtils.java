package net.kuro.recrafted.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.ParticlesMode;
import net.minecraft.client.particle.Particle;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
@SuppressWarnings("DataFlowIssue")
public class ParticleUtils
{
    public static void generatePotionParticles(World world, BlockPos pos, int color, boolean generateMultiple)
    {
        ParticlesMode particleStatus = MinecraftClient.getInstance().options.getParticles().getValue();
        if (particleStatus == ParticlesMode.MINIMAL)
            return;

        BlockState stateOfBlockAbove = world.getBlockState(pos.up());
        if (stateOfBlockAbove.isOpaque())
            return;

        Random random = Random.create();
        int multiplier, numberOfParticles = 1;

        if (generateMultiple)
        {
            multiplier = particleStatus == ParticlesMode.DECREASED ? 1 : 2;
            numberOfParticles = random.nextBetweenExclusive(3 * multiplier, 5 * multiplier);
        }
        else
        {
            if (particleStatus == ParticlesMode.DECREASED && random.nextInt(10) % 5 != 0)
                return;
            else if (random.nextInt(10) % 3 != 0)
                return;
        }

        float red = (color >> 16 & 255) / 255.0f;
        float green = (color >> 8 & 255) / 255.0f;
        float blue = (color & 255) / 255.0f;

        for (int i = 1; i <= numberOfParticles; i++)
        {
            Particle particle = MinecraftClient.getInstance().particleManager.addParticle(
                    ParticleTypes.EFFECT,
                    pos.getX() + 0.45 + random.nextDouble() * 0.2,
                    pos.getY() + 1.0,
                    pos.getZ() + 0.45 + random.nextDouble() * 0.2,
                    0.7,
                    1.3,
                    0.7
            );

            particle.setColor(red, green, blue);
        }
    }

    public static void generateEvaporationParticles(World level, BlockPos pos)
    {
        ParticlesMode particleStatus = MinecraftClient.getInstance().options.getParticles().getValue();
        if (particleStatus == ParticlesMode.MINIMAL)
            return;

        BlockState stateOfBlockAbove = level.getBlockState(pos.up());
        if (stateOfBlockAbove.isOpaque())
            return;

        int maxParticles = particleStatus == ParticlesMode.DECREASED ? 5 : 10;

        for (int i = 1; i <= maxParticles; i++)
        {
            MinecraftClient.getInstance().particleManager.addParticle(
                    ParticleTypes.POOF,
                    pos.getX() + 0.45,
                    pos.getY() + 1.0,
                    pos.getZ() + 0.45,
                    0,
                    0.02,
                    0
            );
        }
    }
}

