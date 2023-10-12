package net.kuro.recrafted.block.custom;

import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.block.ModBlocks;
import net.kuro.recrafted.block.barrel.BarrelBehavior;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;

public class BarrelBlock
        extends AbstractBarrelBlock {

    private static final float FILL_WITH_RAIN_CHANCE = 0.05f;

    public Block filledBlock;

    public BarrelBlock(AbstractBlock.Settings settings, Block filledBlock) {
        super(settings, BarrelBehavior.EMPTY_BARREL_BEHAVIOR);
        this.filledBlock = filledBlock;
    }

    @Override
    public boolean isFull(BlockState state) {
        return false;
    }

    protected static boolean canFillWithPrecipitation(World world, Biome.Precipitation precipitation) {
        if (precipitation == Biome.Precipitation.RAIN) {
            return world.getRandom().nextFloat() < FILL_WITH_RAIN_CHANCE;
        }
        return false;
    }

    @Override
    public void precipitationTick(BlockState state, World world, BlockPos pos, Biome.Precipitation precipitation) {
        if (!BarrelBlock.canFillWithPrecipitation(world, precipitation)) {
            return;
        }
        if (precipitation == Biome.Precipitation.RAIN) {
            BlockState filledState = this.filledBlock.getDefaultState();
            world.setBlockState(pos, filledState);
            world.emitGameEvent(null, GameEvent.BLOCK_CHANGE, pos);
        }
    }

    @Override
    protected boolean canBeFilledByDripstone(Fluid fluid) {
        return true;
    }

    @Override
    protected void fillFromDripstone(BlockState state, World world, BlockPos pos, Fluid fluid) {
        if (fluid == Fluids.WATER) {
            BlockState filledState = this.filledBlock.getDefaultState();
            world.setBlockState(pos, filledState);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(filledState));
            world.syncWorldEvent(WorldEvents.POINTED_DRIPSTONE_DRIPS_WATER_INTO_CAULDRON, pos, 0);
        }
    }

    public void setFilledBlock(Block filledBlock) {
        this.filledBlock = filledBlock;
    }
}

