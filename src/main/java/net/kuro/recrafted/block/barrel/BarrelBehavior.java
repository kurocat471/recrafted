package net.kuro.recrafted.block.barrel;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.block.ModBlocks;
import net.kuro.recrafted.block.custom.BarrelBlock;
import net.kuro.recrafted.block.custom.LeveledBarrelBlock;
import net.minecraft.block.*;
import net.minecraft.block.entity.BannerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Map;
import java.util.function.Predicate;

public interface BarrelBehavior {
    /**
     * The barrel behaviors for empty barrels.
     *
     * @see #createMap
     */
    public static final Map<Item, BarrelBehavior> EMPTY_BARREL_BEHAVIOR = BarrelBehavior.createMap();
    /**
     * The barrel behaviors for water barrels.
     *
     * @see #createMap
     */
    public static final Map<Item, BarrelBehavior> WATER_BARREL_BEHAVIOR = BarrelBehavior.createMap();
    /**
     * A behavior that fills barrels with water.
     *
     * @see #fillBarrel
     */
    public static final BarrelBehavior FILL_WITH_WATER = (state, world, pos, player, hand, stack) -> {
        if (state.getBlock().getClass() != LeveledBarrelBlock.class && state.getBlock().getClass() != BarrelBlock.class) {
            return ActionResult.PASS;
        }
        if (state.getBlock().getClass() == LeveledBarrelBlock.class) {
            BarrelBehavior.fillBarrel(world, pos, player, hand, stack, state.with(LeveledBarrelBlock.LEVEL, 3), SoundEvents.ITEM_BUCKET_EMPTY);
        } else if (state.getBlock().getClass() == BarrelBlock.class) {
            BarrelBehavior.fillBarrel(world, pos, player, hand, stack, ((BarrelBlock) state.getBlock()).filledBlock.getDefaultState().with(LeveledBarrelBlock.LEVEL, 3), SoundEvents.ITEM_BUCKET_EMPTY);
        }
        return ActionResult.success(world.isClient);
    };
    /**
     * A behavior that cleans dyed shulker boxes.
     */
    public static final BarrelBehavior CLEAN_SHULKER_BOX = (state, world, pos, player, hand, stack) -> {
        Block block = Block.getBlockFromItem(stack.getItem());
        if (!(block instanceof ShulkerBoxBlock)) {
            return ActionResult.PASS;
        }
        if (!world.isClient) {
            ItemStack itemStack = new ItemStack(Blocks.SHULKER_BOX);
            if (stack.hasNbt()) {
                itemStack.setNbt(stack.getNbt().copy());
            }
            player.setStackInHand(hand, itemStack);
            player.incrementStat(Stats.CLEAN_SHULKER_BOX);
            Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
            LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
        }
        return ActionResult.success(world.isClient);
    };
    /**
     * A behavior that cleans banners with patterns.
     */
    public static final BarrelBehavior CLEAN_BANNER = (state, world, pos, player, hand, stack) -> {
        if (BannerBlockEntity.getPatternCount(stack) <= 0) {
            return ActionResult.PASS;
        }
        if (!world.isClient) {
            ItemStack itemStack = stack.copyWithCount(1);
            BannerBlockEntity.loadFromItemStack(itemStack);
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }
            if (stack.isEmpty()) {
                player.setStackInHand(hand, itemStack);
            } else if (player.getInventory().insertStack(itemStack)) {
                player.playerScreenHandler.syncState();
            } else {
                player.dropItem(itemStack, false);
            }
            player.incrementStat(Stats.CLEAN_BANNER);
            Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
            LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
        }
        return ActionResult.success(world.isClient);
    };
    /**
     * A behavior that cleans {@linkplain net.minecraft.item.DyeableItem dyeable items}.
     */
    public static final BarrelBehavior CLEAN_DYEABLE_ITEM = (state, world, pos, player, hand, stack) -> {
        Item item = stack.getItem();
        if (!(item instanceof DyeableItem)) {
            return ActionResult.PASS;
        }
        DyeableItem dyeableItem = (DyeableItem)((Object)item);
        if (!dyeableItem.hasColor(stack)) {
            return ActionResult.PASS;
        }
        if (!world.isClient) {
            dyeableItem.removeColor(stack);
            player.incrementStat(Stats.CLEAN_ARMOR);
            Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
            LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
        }
        return ActionResult.success(world.isClient);
    };

    /**
     * Creates a mutable map from {@linkplain Item items} to their
     * corresponding barrel behaviors.
     *
     * <p>The default return value in the map is a barrel behavior
     * that returns {@link ActionResult#PASS} for all items.
     *
     * @return the created map
     */
    public static Object2ObjectOpenHashMap<Item, BarrelBehavior> createMap() {
        Object2ObjectOpenHashMap<Item, BarrelBehavior> map = new Object2ObjectOpenHashMap<>();
        map.defaultReturnValue((state, world, pos, player, hand, stack) -> ActionResult.PASS);
        return map;
    }

    /**
     * Called when a player interacts with a barrel.
     *
     * @return a {@linkplain ActionResult#isAccepted successful} action result if this behavior succeeds,
     * {@link ActionResult#PASS} otherwise
     *
     * {@param state} the current barrel block state
     * {@param player} the interacting player
     * {@param hand} the hand interacting with the barrel
     * {@param world} the world where the barrel is located
     * {@param pos} the barrel's position
     * {@param stack} the stack in the player's hand
     */
    public ActionResult interact(BlockState var1, World var2, BlockPos var3, PlayerEntity var4, Hand var5, ItemStack var6);

    /**
     * Registers the vanilla barrel behaviors.
     */
    public static void registerBehavior() {
        Recrafted.LOGGER.info("Registering Barrel Behavior for " + Recrafted.MOD_ID);

        BarrelBehavior.registerBucketBehavior(EMPTY_BARREL_BEHAVIOR);
        EMPTY_BARREL_BEHAVIOR.put(Items.POTION, (state, world, pos, player, hand, stack) -> {
            if (PotionUtil.getPotion(stack) != Potions.WATER) {
                return ActionResult.PASS;
            }
            if (!world.isClient) {
                BlockState filledState = ((BarrelBlock) state.getBlock()).filledBlock.getDefaultState();
                Item item = stack.getItem();
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                player.incrementStat(Stats.USE_CAULDRON);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, filledState);
                world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
            }
            return ActionResult.success(world.isClient);
        });
        BarrelBehavior.registerBucketBehavior(WATER_BARREL_BEHAVIOR);
        WATER_BARREL_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> BarrelBehavior.emptyBarrel(state, world, pos, player, hand, stack, new ItemStack(Items.WATER_BUCKET), statex -> statex.get(LeveledBarrelBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL));
        WATER_BARREL_BEHAVIOR.put(Items.GLASS_BOTTLE, (state, world, pos, player, hand, stack) -> {
            if (!world.isClient) {
                Item item = stack.getItem();
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER)));
                player.incrementStat(Stats.USE_CAULDRON);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
            }
            return ActionResult.success(world.isClient);
        });
        WATER_BARREL_BEHAVIOR.put(Items.POTION, (state, world, pos, player, hand, stack) -> {
            if (state.get(LeveledBarrelBlock.LEVEL) == 3 || PotionUtil.getPotion(stack) != Potions.WATER) {
                return ActionResult.PASS;
            }
            if (!world.isClient) {
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                player.incrementStat(Stats.USE_CAULDRON);
                player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
                world.setBlockState(pos, (BlockState)state.cycle(LeveledBarrelBlock.LEVEL));
                world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
            }
            return ActionResult.success(world.isClient);
        });
        WATER_BARREL_BEHAVIOR.put(Items.LEATHER_BOOTS, CLEAN_DYEABLE_ITEM);
        WATER_BARREL_BEHAVIOR.put(Items.LEATHER_LEGGINGS, CLEAN_DYEABLE_ITEM);
        WATER_BARREL_BEHAVIOR.put(Items.LEATHER_CHESTPLATE, CLEAN_DYEABLE_ITEM);
        WATER_BARREL_BEHAVIOR.put(Items.LEATHER_HELMET, CLEAN_DYEABLE_ITEM);
        WATER_BARREL_BEHAVIOR.put(Items.LEATHER_HORSE_ARMOR, CLEAN_DYEABLE_ITEM);
        WATER_BARREL_BEHAVIOR.put(Items.WHITE_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.GRAY_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.BLACK_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.BLUE_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.BROWN_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.CYAN_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.GREEN_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.LIGHT_BLUE_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.LIGHT_GRAY_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.LIME_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.MAGENTA_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.ORANGE_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.PINK_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.PURPLE_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.RED_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.YELLOW_BANNER, CLEAN_BANNER);
        WATER_BARREL_BEHAVIOR.put(Items.WHITE_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.GRAY_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.BLACK_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.BLUE_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.BROWN_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.CYAN_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.GREEN_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.LIGHT_BLUE_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.LIGHT_GRAY_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.LIME_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.MAGENTA_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.ORANGE_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.PINK_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.PURPLE_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.RED_SHULKER_BOX, CLEAN_SHULKER_BOX);
        WATER_BARREL_BEHAVIOR.put(Items.YELLOW_SHULKER_BOX, CLEAN_SHULKER_BOX);
    }

    /**
     * Registers the behavior for filled buckets in the specified behavior map.
     */
    public static void registerBucketBehavior(Map<Item, BarrelBehavior> behavior) {
        behavior.put(Items.WATER_BUCKET, FILL_WITH_WATER);
    }

    /**
     * Empties a barrel if it's full.
     *
     * @return a {@linkplain ActionResult#isAccepted successful} action result if emptied, {@link ActionResult#PASS} otherwise
     *
     * @param soundEvent the sound produced by emptying
     * @param fullPredicate a predicate used to check if the barrel can be emptied into the output stack
     * @param output the item stack that replaces the interaction stack when the barrel is emptied
     * @param stack the stack in the player's hand
     * @param hand the hand interacting with the barrel
     * @param player the interacting player
     * @param pos the barrel's position
     * @param world the world where the barrel is located
     * @param state the barrel block state
     */
    public static ActionResult emptyBarrel(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack, ItemStack output, Predicate<BlockState> fullPredicate, SoundEvent soundEvent) {
        if (!fullPredicate.test(state)) {
            return ActionResult.PASS;
        }
        if (!world.isClient) {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, output));
            player.incrementStat(Stats.USE_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            BlockState emptyState = ((LeveledBarrelBlock) state.getBlock()).emptyBlock.getDefaultState();
            world.setBlockState(pos, emptyState);
            world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
        }
        return ActionResult.success(world.isClient);
    }

    /**
     * Fills a barrel from a bucket stack.
     *
     * <p>The filled bucket stack will be replaced by an empty bucket in the player's
     * inventory.
     *
     * @return a {@linkplain ActionResult#isAccepted successful} action result
     *
     * @param pos the barrel's position
     * @param world the world where the barrel is located
     * @param soundEvent the sound produced by filling
     * @param hand the hand interacting with the barrel
     * @param player the interacting player
     * @param state the filled barrel state
     * @param stack the filled bucket stack in the player's hand
     */
    public static ActionResult fillBarrel(World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack, BlockState state, SoundEvent soundEvent) {
        if (!world.isClient) {
            Item item = stack.getItem();
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.BUCKET)));
            player.incrementStat(Stats.FILL_CAULDRON);
            player.incrementStat(Stats.USED.getOrCreateStat(item));
            world.setBlockState(pos, state);
            world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
        }
        return ActionResult.success(world.isClient);
    }
}


