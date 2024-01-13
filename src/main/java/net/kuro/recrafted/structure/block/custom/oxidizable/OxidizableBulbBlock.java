package net.kuro.recrafted.structure.block.custom.oxidizable;

import net.kuro.recrafted.structure.block.custom.bulb.BulbBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizableBulbBlock extends BulbBlock implements Oxidizable {
    private final Oxidizable.OxidationLevel oxidationLevel;

    public OxidizableBulbBlock(Oxidizable.OxidationLevel oxidationLevel, AbstractBlock.Settings settings) {
        super(settings);
        this.oxidationLevel = oxidationLevel;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
