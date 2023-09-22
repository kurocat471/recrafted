package net.kuro.recrafted.block.custom;

import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.block.entity.AnvilBlockEntity;
import net.kuro.recrafted.block.entity.ModBlockEntities;
import net.kuro.recrafted.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class AnvilBlock extends BlockWithEntity implements BlockEntityProvider, LandingBlock {

    public final String material;
    public final int tier;

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private static final VoxelShape NORTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(2.0, 0.0, 4.0, 6.0, 2.0, 12.0),
            Block.createCuboidShape(10.0, 0.0, 4.0, 14.0, 2.0, 12.0),
            Block.createCuboidShape(6.0, 0.0, 5.0, 10.0, 1.0, 11.0),
            Block.createCuboidShape(4.0, 1.0, 6.0, 12.0, 5.0, 10.0),
            Block.createCuboidShape(0.0, 5.0, 5.0, 13.0, 8.0, 11.0),
            Block.createCuboidShape(13.0, 5.5, 6.0, 16.0, 7.5, 10.0));
    private static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(10.0, 0.0, 4.0, 14.0, 2.0, 12.0),
            Block.createCuboidShape(2.0, 0.0, 4.0, 6.0, 2.0, 12.0),
            Block.createCuboidShape(6.0, 0.0, 5.0, 10.0, 1.0, 11.0),
            Block.createCuboidShape(4.0, 1.0, 6.0, 12.0, 5.0, 10.0),
            Block.createCuboidShape(3.0, 5.0, 5.0, 16.0, 8.0, 11.0),
            Block.createCuboidShape(0.0, 5.5, 6.0, 3.0, 7.5, 10.0));
    private static final VoxelShape WEST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4.0, 0.0, 10.0, 12.0, 2.0, 14.0),
            Block.createCuboidShape(4.0, 0.0, 2.0, 12.0, 2.0, 6.0),
            Block.createCuboidShape(5.0, 0.0, 6.0, 11.0, 1.0, 10.0),
            Block.createCuboidShape(6.0, 1.0, 4.0, 10.0, 5.0, 12.0),
            Block.createCuboidShape(5.0, 5.0, 3.0, 11.0, 8.0, 16.0),
            Block.createCuboidShape(6.0, 5.5, 0.0, 10.0, 7.5, 3.0));
    private static final VoxelShape EAST_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4.0, 0.0, 2.0, 12.0, 2.0, 6.0),
            Block.createCuboidShape(4.0, 0.0, 10.0, 12.0, 2.0, 14.0),
            Block.createCuboidShape(5.0, 0.0, 6.0, 11.0, 1.0, 10.0),
            Block.createCuboidShape(6.0, 1.0, 4.0, 10.0, 5.0, 12.0),
            Block.createCuboidShape(5.0, 5.0, 0.0, 11.0, 8.0, 13.0),
            Block.createCuboidShape(6.0, 5.5, 13.0, 10.0, 7.5, 16.0));

    public AnvilBlock(Settings settings, String material, int tier) {
        super(settings);
        this.material = material;
        this.tier = tier;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        if (Objects.equals(String.valueOf(direction), "north")) {
            return NORTH_SHAPE;
        }
        if (Objects.equals(String.valueOf(direction), "south")) {
            return SOUTH_SHAPE;
        }
        if (Objects.equals(String.valueOf(direction), "west")) {
            return WEST_SHAPE;
        }
        return EAST_SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        if (!fallingBlockEntity.isSilent()) {
            world.syncWorldEvent(WorldEvents.ANVIL_LANDS, pos, 0);
        }
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.scheduleBlockTick(pos, this, this.getFallDelay());
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        world.scheduleBlockTick(pos, this, this.getFallDelay());
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!AnvilBlock.canFallThrough(world.getBlockState(pos.down())) || pos.getY() < world.getBottomY()) {
            return;
        }
        FallingBlockEntity fallingBlockEntity = FallingBlockEntity.spawnFromBlock(world, pos, state);
        this.configureFallingBlockEntity(fallingBlockEntity);
    }

    protected void configureFallingBlockEntity(FallingBlockEntity entity) {
        entity.setHurtEntities(2.0f, 40);
    }

    protected int getFallDelay() {
        return 2;
    }

    public static boolean canFallThrough(BlockState state) {
        return state.isAir() || state.isIn(BlockTags.FIRE) || state.isLiquid() || state.isReplaceable();
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        BlockPos blockPos;
        if (random.nextInt(16) == 0 && AnvilBlock.canFallThrough(world.getBlockState(blockPos = pos.down()))) {
            ParticleUtil.spawnParticle(world, pos, random, new BlockStateParticleEffect(ParticleTypes.FALLING_DUST, state));
        }
    }

    public int getColor(BlockState state, BlockView world, BlockPos pos) {
        return -16777216;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AnvilBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof AnvilBlockEntity) {
                ItemScatterer.spawn(world, pos, (AnvilBlockEntity)blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Boolean isCrafting = false;
        if (!world.isClient) {
            if(player.isSneaking()) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof AnvilBlockEntity) {
                    AnvilBlockEntity anvilBlockEntity = (AnvilBlockEntity) blockEntity;
                    ItemStack output = anvilBlockEntity.getRenderStackOutput();
                    ItemScatterer.spawn(world, pos.getX(), pos.getY() + 0.85, pos.getZ(), output);
                    world.updateComparators(pos, this);
                    anvilBlockEntity.markDirty();
                }
            } else {
                Recrafted.LOGGER.info(String.valueOf(hand));
                if (player.getMainHandStack().getItem() == ModItems.COPPER_HAMMER ||
                        player.getMainHandStack().getItem() == ModItems.BRONZE_HAMMER ||
                        player.getMainHandStack().getItem() == ModItems.BISMUTH_BRONZE_HAMMER ||
                        player.getMainHandStack().getItem() == ModItems.BLACK_BRONZE_HAMMER ||
                        player.getMainHandStack().getItem() == ModItems.WHITE_BRONZE_HAMMER ||
                        player.getMainHandStack().getItem() == ModItems.IRON_HAMMER ||
                        player.getMainHandStack().getItem() == ModItems.STEEL_HAMMER) {
                    ServerWorld serverWorld = (ServerWorld) world;
                    serverWorld.spawnParticles(ParticleTypes.CRIT, pos.getX() + 0.5, pos.getY() + 0.65, pos.getZ() + 0.5, 10, 0.1, 0.0, 0.1, 0.15);
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    if (blockEntity instanceof AnvilBlockEntity) {
                        if (Objects.equals(String.valueOf(player.getMainHandStack().getItem()), material + "_hammer")) {
                            if (((AnvilBlockEntity) blockEntity).canInsertIntoOutputSlot() && ((AnvilBlockEntity) blockEntity).hasRecipe()) {
                                ((AnvilBlockEntity) blockEntity).craftItem(player);
                                isCrafting = true;
                                blockEntity.markDirty();
                            }
                        }
                    }
                    if (!isCrafting) {
                        serverWorld.playSound(
                                null,
                                pos,
                                SoundEvents.BLOCK_ANVIL_PLACE,
                                SoundCategory.BLOCKS,
                                0.3f,
                                0.8f
                        );
                    }
                } else {
                    NamedScreenHandlerFactory screenHandlerFactory = ((AnvilBlockEntity) world.getBlockEntity(pos));

                    if (screenHandlerFactory != null) {
                        player.openHandledScreen(screenHandlerFactory);
                    }
                }
            }
            isCrafting = false;
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.ANVIL_BE, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
