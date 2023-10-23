package net.kuro.recrafted.block.custom;

import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.block.ModBlocks;
import net.kuro.recrafted.block.barrel.BarrelBehavior;
import net.kuro.recrafted.block.entity.WaterBarrelBlockEntity;
import net.kuro.recrafted.block.entity.WaterCauldronBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Predicate;

/**
 * A cauldron with a varying level of contents.
 * This includes water cauldrons.
 *
 * <p>The amount of stored substance is controlled with the {@link #LEVEL}
 * block state property which can take values between {@value #MIN_LEVEL} and
 * {@value #MAX_LEVEL} (inclusive).
 */
public class LeveledBarrelBlock extends AbstractBarrelBlock implements BlockEntityProvider{
    public static final int MIN_LEVEL = 1;
    public static final int MAX_LEVEL = 3;
    public static final IntProperty LEVEL = Properties.LEVEL_3;
    private static final int BASE_FLUID_HEIGHT = 7;
    private static final double FLUID_HEIGHT_PER_LEVEL = 4.0;

    public final Block emptyBlock;

    /**
     * A precipitation predicate that allows {@link Biome.Precipitation#RAIN}.
     */
    public static final Predicate<Biome.Precipitation> RAIN_PREDICATE = precipitation -> precipitation == Biome.Precipitation.RAIN;
    private final Predicate<Biome.Precipitation> precipitationPredicate;

    /**
     * Constructs a leveled cauldron block.
     *
     * @apiNote The precipitation predicates are compared using identity comparisons in some cases,
     // so callers should typically use {@link #RAIN_PREDICATE} if applicable.
     *
     * @param behaviorMap the map containing cauldron behaviors for each item
     * @param precipitationPredicate a predicate that checks what type of precipitation can fill this cauldron
     */
    public LeveledBarrelBlock(AbstractBlock.Settings settings, Block emptyBlock, Predicate<Biome.Precipitation> precipitationPredicate, Map<Item, BarrelBehavior> behaviorMap) {
        super(settings, behaviorMap);
        this.emptyBlock = emptyBlock;
        this.precipitationPredicate = precipitationPredicate;
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(LEVEL, 1));
    }

    @Override
    public boolean isFull(BlockState state) {
        return state.get(LEVEL) == 3;
    }

    @Override
    public boolean canBeFilledByDripstone(Fluid fluid) {
        return fluid == Fluids.WATER && this.precipitationPredicate == RAIN_PREDICATE;
    }

    @Override
    protected double getFluidHeight(BlockState state) {
        return (BASE_FLUID_HEIGHT + (double)state.get(LEVEL).intValue() * FLUID_HEIGHT_PER_LEVEL) / 16.0;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity.isOnFire() && this.isEntityTouchingFluid(state, pos, entity)) {
            entity.extinguish();
            if (entity.canModifyAt(world, pos)) {
                this.onFireCollision(state, world, pos);
            }
        }
    }

    protected void onFireCollision(BlockState state, World world, BlockPos pos) {
        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, this.emptyBlock);
    }

    public static void decrementFluidLevel(BlockState state, World world, BlockPos pos, Block emptyBlock) {
        int i = state.get(LEVEL) - 1;
        BlockState emptyState = emptyBlock.getDefaultState();
        BlockState blockState = i == 0 ? emptyState : (BlockState)state.with(LEVEL, i);
        world.setBlockState(pos, blockState);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
    }

    @Override
    public void precipitationTick(BlockState state, World world, BlockPos pos, Biome.Precipitation precipitation) {
        if (!BarrelBlock.canFillWithPrecipitation(world, precipitation) || state.get(LEVEL) == 3 || !this.precipitationPredicate.test(precipitation)) {
            return;
        }
        BlockState blockState = (BlockState)state.cycle(LEVEL);
        world.setBlockState(pos, blockState);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.get(LEVEL);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }

    @Override
    protected void fillFromDripstone(BlockState state, World world, BlockPos pos, Fluid fluid) {
        if (this.isFull(state)) {
            return;
        }
        BlockState blockState = (BlockState)state.with(LEVEL, state.get(LEVEL) + 1);
        world.setBlockState(pos, blockState);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
        world.syncWorldEvent(WorldEvents.POINTED_DRIPSTONE_DRIPS_WATER_INTO_CAULDRON, pos, 0);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WaterBarrelBlockEntity(pos, state);
    }
}

