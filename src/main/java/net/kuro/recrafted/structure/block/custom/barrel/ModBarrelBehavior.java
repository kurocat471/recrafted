package net.kuro.recrafted.structure.block.custom.barrel;

import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.sound.ModSoundEvents;
import net.kuro.recrafted.structure.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

public interface ModBarrelBehavior extends BarrelBehavior {

    public static void registerBehavior() {
        Recrafted.LOGGER.info("Registering Barrel Behavior for " + Recrafted.MOD_ID);

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_COPPER_INGOT,
            (state, world, pos, player, hand, stack) -> {
                if (!stack.isOf(ModItems.SUPERHEATED_COPPER_INGOT)) {
                    return ActionResult.PASS;
                }
                if (!world.isClient) {
                    ItemStack itemStack = new ItemStack(ModItems.COPPER_INGOT, stack.getCount());
                    player.setStackInHand(hand, itemStack);
                    Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                    LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                    world.playSound(
                            null,
                            pos,
                            ModSoundEvents.ITEM_COOLS,
                            SoundCategory.BLOCKS,
                            0.5f,
                            2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                    );
                }
                return ActionResult.success(world.isClient);
            }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_TIN_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_TIN_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.TIN_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_ZINC_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_ZINC_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.ZINC_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_ALUMINIUM_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_ALUMINIUM_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.ALUMINIUM_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_BISMUTH_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_BISMUTH_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.BISMUTH_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_NICKEL_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_NICKEL_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.NICKEL_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_SILVER_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_SILVER_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.SILVER_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_GOLD_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_GOLD_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.GOLD_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_LEAD_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_LEAD_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.LEAD_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_IRON_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_IRON_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.IRON_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_COBALT_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_COBALT_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.COBALT_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_PLATINUM_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_PLATINUM_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.PLATINUM_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_TITANIUM_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_TITANIUM_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.TITANIUM_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_BRONZE_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_BRONZE_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.BRONZE_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_BISMUTH_BRONZE_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_BISMUTH_BRONZE_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.BISMUTH_BRONZE_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_BLACK_BRONZE_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_BLACK_BRONZE_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.BLACK_BRONZE_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_WHITE_BRONZE_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_WHITE_BRONZE_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.WHITE_BRONZE_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_BRASS_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_BRASS_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.BRASS_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_ELECTRUM_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_ELECTRUM_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.ELECTRUM_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_STERLING_SILVER_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_STERLING_SILVER_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.STERLING_SILVER_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_ROSE_GOLD_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_ROSE_GOLD_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.ROSE_GOLD_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_GUNMETAL_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_GUNMETAL_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.GUNMETAL_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_PEWTER_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_PEWTER_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.PEWTER_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_STEEL_INGOT,
                (state, world, pos, player, hand, stack) -> {
                    if (!stack.isOf(ModItems.SUPERHEATED_STEEL_INGOT)) {
                        return ActionResult.PASS;
                    }
                    if (!world.isClient) {
                        ItemStack itemStack = new ItemStack(ModItems.STEEL_INGOT, stack.getCount());
                        player.setStackInHand(hand, itemStack);
                        Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                        LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                        world.playSound(
                                null,
                                pos,
                                ModSoundEvents.ITEM_COOLS,
                                SoundCategory.BLOCKS,
                                0.5f,
                                2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                        );
                    }
                    return ActionResult.success(world.isClient);
                }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_COPPER_PICKAXE_HEAD,
            (state, world, pos, player, hand, stack) -> {
                if (!stack.isOf(ModItems.SUPERHEATED_COPPER_PICKAXE_HEAD)) {
                    return ActionResult.PASS;
                }
                if (!world.isClient) {
                    ItemStack itemStack = new ItemStack(ModItems.COPPER_PICKAXE_HEAD, stack.getCount());
                    player.setStackInHand(hand, itemStack);
                    Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                    LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                    world.playSound(
                            null,
                            pos,
                            ModSoundEvents.ITEM_COOLS,
                            SoundCategory.BLOCKS,
                            0.5f,
                            2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                    );
                }
                return ActionResult.success(world.isClient);
            }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_COPPER_AXE_HEAD,
            (state, world, pos, player, hand, stack) -> {
                if (!stack.isOf(ModItems.SUPERHEATED_COPPER_AXE_HEAD)) {
                    return ActionResult.PASS;
                }
                if (!world.isClient) {
                    ItemStack itemStack = new ItemStack(ModItems.COPPER_AXE_HEAD, stack.getCount());
                    player.setStackInHand(hand, itemStack);
                    Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                    LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                    world.playSound(
                            null,
                            pos,
                            ModSoundEvents.ITEM_COOLS,
                            SoundCategory.BLOCKS,
                            0.5f,
                            2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                    );
                }
                return ActionResult.success(world.isClient);
            }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_COPPER_SHOVEL_HEAD,
            (state, world, pos, player, hand, stack) -> {
                if (!stack.isOf(ModItems.SUPERHEATED_COPPER_SHOVEL_HEAD)) {
                    return ActionResult.PASS;
                }
                if (!world.isClient) {
                    ItemStack itemStack = new ItemStack(ModItems.COPPER_SHOVEL_HEAD, stack.getCount());
                    player.setStackInHand(hand, itemStack);
                    Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                    LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                    world.playSound(
                            null,
                            pos,
                            ModSoundEvents.ITEM_COOLS,
                            SoundCategory.BLOCKS,
                            0.5f,
                            2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                    );
                }
                return ActionResult.success(world.isClient);
            }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_COPPER_HOE_HEAD,
            (state, world, pos, player, hand, stack) -> {
                if (!stack.isOf(ModItems.SUPERHEATED_COPPER_HOE_HEAD)) {
                    return ActionResult.PASS;
                }
                if (!world.isClient) {
                    ItemStack itemStack = new ItemStack(ModItems.COPPER_HOE_HEAD, stack.getCount());
                    player.setStackInHand(hand, itemStack);
                    Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                    LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                    world.playSound(
                            null,
                            pos,
                            ModSoundEvents.ITEM_COOLS,
                            SoundCategory.BLOCKS,
                            0.5f,
                            2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                    );
                }
                return ActionResult.success(world.isClient);
            }
        );

        BarrelBehavior.WATER_BARREL_BEHAVIOR.put(ModItems.SUPERHEATED_COPPER_BROADSWORD_BLADE,
            (state, world, pos, player, hand, stack) -> {
                if (!stack.isOf(ModItems.SUPERHEATED_COPPER_BROADSWORD_BLADE)) {
                    return ActionResult.PASS;
                }
                if (!world.isClient) {
                    ItemStack itemStack = new ItemStack(ModItems.COPPER_BROADSWORD_BLADE, stack.getCount());
                    player.setStackInHand(hand, itemStack);
                    Block emptyBlock = ((LeveledBarrelBlock) state.getBlock()).emptyBlock;
                    LeveledBarrelBlock.decrementFluidLevel(state, world, pos, emptyBlock);
                    world.playSound(
                            null,
                            pos,
                            ModSoundEvents.ITEM_COOLS,
                            SoundCategory.BLOCKS,
                            0.5f,
                            2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f
                    );
                }
                return ActionResult.success(world.isClient);
            }
        );
    }
}
