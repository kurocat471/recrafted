package net.kuro.recrafted.structure.block.custom.patinafire;

import net.kuro.recrafted.util.ModTags;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class PatinaFireBlock
        extends AbstractFireBlock {
    public PatinaFireBlock(AbstractBlock.Settings settings) {
        super(settings, 0.5f);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (this.canPlaceAt(state, world, pos)) {
            return this.getDefaultState();
        }
        return Blocks.AIR.getDefaultState();
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return PatinaFireBlock.isPatinaBase(world.getBlockState(pos.down()));
    }

    public static boolean isPatinaBase(BlockState state) {
        return state.isIn(ModTags.Blocks.PATINA_FIRE_BASE_BLOCKS);
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }
}
