package net.kuro.recrafted.mixin;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DoorBlock.class)
public class DoorBlockMixin extends Block {
    private static final BooleanProperty OPEN = Properties.OPEN;
    private static final BooleanProperty POWERED = Properties.POWERED;
    private static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;
    private final BlockSetType blockSetType;

    public DoorBlockMixin(Settings settings, BlockSetType blockSetType) {
        super(settings.sounds(blockSetType.soundType()));
        this.blockSetType = blockSetType;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf)state.get(HALF);
        if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
            return neighborState.getBlock() instanceof DoorBlock && neighborState.get(HALF) != doubleBlockHalf ? (BlockState)neighborState.with(HALF, doubleBlockHalf) : Blocks.AIR.getDefaultState();
        } else {
            return doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
        if (!this.getDefaultState().isOf(sourceBlock) && bl != (Boolean)state.get(POWERED)) {
            if (bl != (Boolean)state.get(OPEN)) {
                this.playOpenCloseSound((Entity)null, world, pos, bl);
                world.emitGameEvent((Entity)null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            }
            world.setBlockState(pos, (BlockState)((BlockState)state.with(POWERED, bl)).with(OPEN, bl), 2);
        }
    }

    private void playOpenCloseSound(@Nullable Entity entity, World world, BlockPos pos, boolean open) {
        world.playSound(entity, pos, open ? this.blockSetType.doorOpen() : this.blockSetType.doorClose(), SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
    }
}
