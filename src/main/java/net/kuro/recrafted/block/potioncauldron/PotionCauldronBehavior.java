package net.kuro.recrafted.block.potioncauldron;

import java.util.HashMap;
import java.util.Map;

import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.block.ModBlocks;
import net.kuro.recrafted.block.custom.PotionCauldronBlock;
import net.kuro.recrafted.block.entity.PotionCauldronBlockEntity;
import net.kuro.recrafted.networking.ServerNetworking;
import net.kuro.recrafted.networking.packet.ParticlePacket;
import net.kuro.recrafted.sound.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

@SuppressWarnings({ "DataFlowIssue", "DuplicatedCode" })
public class PotionCauldronBehavior
{
    public static final Map<Item, CauldronBehavior> MAP = CauldronBehavior.createMap();

    public static void bootstrap()
    {
        CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR.put(Items.SPLASH_POTION, PotionCauldronBehavior::fillEmptyCauldronWithPotion);
        CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR.put(Items.LINGERING_POTION, PotionCauldronBehavior::fillEmptyCauldronWithPotion);

        MAP.put(Items.POTION, PotionCauldronBehavior::fillPotionCauldronWithPotion);
        MAP.put(Items.SPLASH_POTION, PotionCauldronBehavior::fillPotionCauldronWithPotion);
        MAP.put(Items.LINGERING_POTION, PotionCauldronBehavior::fillPotionCauldronWithPotion);

        MAP.put(Items.GLASS_BOTTLE, PotionCauldronBehavior::fillBottleFromPotionCauldron);
        MAP.put(Items.ARROW, PotionCauldronBehavior::createTippedArrowsFromPotionCauldron);
    }

    public static ActionResult fillEmptyCauldronWithPotion(BlockState ignored, World level, BlockPos blockPos, PlayerEntity player, Hand interactionHand, ItemStack itemStack) {
        Identifier potionTypeResource = Identifier.tryParse(itemStack.getItem().toString());
        if (potionTypeResource == null) {
            return ActionResult.PASS;
        }

        Potion potion = PotionUtil.getPotion(itemStack);
        String potionType = potionTypeResource.toString();

        if (potion == Potions.EMPTY || potion == Potions.WATER/* || potion == Potions.AWKWARD || potion == Potions.MUNDANE || potion == Potions.THICK*/)
            return ActionResult.PASS;

        level.setBlockState(blockPos, ModBlocks.POTION_CAULDRON.getDefaultState());

        PotionCauldronBlockEntity blockEntity = (PotionCauldronBlockEntity) level.getBlockEntity(blockPos);
        blockEntity.setPotion(potion);
        blockEntity.setPotionType(potionType);

        if (level.isClient)
            return ActionResult.success(true);

        ServerNetworking.sendParticlesToClients(new ParticlePacket(ParticleTypes.EFFECT, blockPos, PotionUtil.getColor(potion), true));

        player.setStackInHand(interactionHand, ItemUsage.exchangeStack(itemStack, player, new ItemStack(Items.GLASS_BOTTLE)));
        level.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
        level.emitGameEvent(null, GameEvent.FLUID_PLACE, blockPos);

        return ActionResult.success(false);
    }

    private static ActionResult fillPotionCauldronWithPotion(BlockState blockState, World level, BlockPos blockPos, PlayerEntity player, Hand interactionHand, ItemStack itemStack)
    {
        Identifier potionTypeResource = Identifier.tryParse(itemStack.getItem().toString());
        if (potionTypeResource == null) {
            return ActionResult.PASS;
        }

        Potion potionInHand = PotionUtil.getPotion(itemStack);
        String potionTypeInHand = potionTypeResource.toString();

        if (potionInHand == Potions.EMPTY || potionInHand == Potions.WATER)
            return ActionResult.PASS;

        PotionCauldronBlockEntity blockEntity = (PotionCauldronBlockEntity) level.getBlockEntity(blockPos);
        Potion potionInCauldron = blockEntity.getPotion();
        String potionTypeInCauldron = blockEntity.getPotionType();

        if (blockState.get(LeveledCauldronBlock.LEVEL) == 3) {
            if  (potionInCauldron != potionInHand)
                return handlePotionMixing(level, blockPos, player, interactionHand, itemStack);
            return ActionResult.PASS;
        }

        if (potionInCauldron != potionInHand)
            return handlePotionMixing(level, blockPos, player, interactionHand, itemStack);

        if (!potionTypeInCauldron.equals(potionTypeInHand))
        {
            blockEntity.setPotionType(potionTypeInHand);
        }

        if (level.isClient)
            return ActionResult.success(true);

        level.setBlockState(blockPos, blockState.cycle(LeveledCauldronBlock.LEVEL));
        ServerNetworking.sendParticlesToClients(new ParticlePacket(ParticleTypes.EFFECT, blockPos, PotionUtil.getColor(potionInCauldron), true));

        player.setStackInHand(interactionHand, ItemUsage.exchangeStack(itemStack, player, new ItemStack(Items.GLASS_BOTTLE)));
        level.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
        level.emitGameEvent(null, GameEvent.FLUID_PLACE, blockPos);

        return ActionResult.success(false);
    }

    private static ActionResult fillBottleFromPotionCauldron(BlockState blockState, World level, BlockPos blockPos, PlayerEntity player, Hand interactionHand, ItemStack itemStack)
    {
        if (blockState.get(LeveledCauldronBlock.LEVEL) == 0)
            return ActionResult.PASS;

        PotionCauldronBlockEntity blockEntity = (PotionCauldronBlockEntity) level.getBlockEntity(blockPos);
        if (blockEntity == null)
            return ActionResult.PASS;

        Potion potion = blockEntity.getPotion();
        if (potion == Potions.EMPTY)
            return ActionResult.PASS;

        Identifier potionTypeResourceLocation = Identifier.tryParse(blockEntity.getPotionType());
        if (potionTypeResourceLocation == null)
            return ActionResult.PASS;

        if (level.isClient)
            return ActionResult.success(true);

        ServerNetworking.sendParticlesToClients(new ParticlePacket(ParticleTypes.EFFECT, blockPos, PotionUtil.getColor(potion), true));

        Item potionType = Registries.ITEM.get(potionTypeResourceLocation);

        player.setStackInHand(interactionHand, ItemUsage.exchangeStack(itemStack, player, PotionUtil.setPotion(new ItemStack(potionType), potion)));
        LeveledCauldronBlock.decrementFluidLevel(blockState, level, blockPos);

        level.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
        level.emitGameEvent(null, GameEvent.FLUID_PICKUP, blockPos);

        return ActionResult.success(false);
    }

    private static ActionResult createTippedArrowsFromPotionCauldron(BlockState blockState, World level, BlockPos blockPos, PlayerEntity player, Hand ignored, ItemStack stack)
    {
        if (blockState.get(LeveledCauldronBlock.LEVEL) == 0)
            return ActionResult.PASS;

        if (level.isClient)
            return ActionResult.success(true);

        HashMap<Integer, Integer> cauldronLevelToArrows = new HashMap<>();
        cauldronLevelToArrows.put(1, 16);
        cauldronLevelToArrows.put(2, 32);
        cauldronLevelToArrows.put(3, 64);


        int currentCauldronLevel = blockState.get(LeveledCauldronBlock.LEVEL);
        int maxTippedArrowCount = cauldronLevelToArrows.get(currentCauldronLevel);
        int tippedArrowCount = Math.min(stack.getCount(), maxTippedArrowCount);

        int usedCauldronLevels = -1;
        for (var item : cauldronLevelToArrows.entrySet())
        {
            if (tippedArrowCount <= item.getValue())
            {
                usedCauldronLevels = item.getKey();
                break;
            }
        }
        int remainingCauldronLevels = currentCauldronLevel - usedCauldronLevels;

        PotionCauldronBlockEntity blockEntity = (PotionCauldronBlockEntity) level.getBlockEntity(blockPos);
        Potion potion = blockEntity.getPotion();

        ItemStack tippedArrows = new ItemStack(Items.TIPPED_ARROW);
        tippedArrows.setCount(tippedArrowCount);
        PotionUtil.setPotion(tippedArrows, potion);

        ServerNetworking.sendParticlesToClients(new ParticlePacket(ParticleTypes.EFFECT, blockPos, PotionUtil.getColor(potion), true));
        level.setBlockState(blockPos, remainingCauldronLevels == 0 ? Blocks.CAULDRON.getDefaultState() : blockState.with(PotionCauldronBlock.LEVEL, remainingCauldronLevels));

        if (!player.isCreative())
            stack.decrement(tippedArrowCount);

        PlayerInventory inventory = player.getInventory();
        if (!inventory.insertStack(tippedArrows))
            player.dropItem(tippedArrows, false);

        level.playSound(null, blockPos, SoundEvents.ENTITY_GENERIC_SPLASH, SoundCategory.BLOCKS, 1.0f, 1.0f);
        level.emitGameEvent(null, GameEvent.FLUID_PICKUP, blockPos);

        return ActionResult.success(false);
    }

    private static ActionResult handlePotionMixing(World level, BlockPos blockPos, PlayerEntity player, Hand interactionHand, ItemStack itemStack)
    {
        if (level.isClient)
            return ActionResult.success(true);

        ServerNetworking.sendParticlesToClients(new ParticlePacket(ParticleTypes.POOF, blockPos));
        level.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());

        player.setStackInHand(interactionHand, ItemUsage.exchangeStack(itemStack, player, new ItemStack(Items.GLASS_BOTTLE)));

        level.playSound(null, blockPos, ModSoundEvents.POTION_EVAPORATES, SoundCategory.BLOCKS, 1.0f, 1.0f);
        level.emitGameEvent(null, GameEvent.FLUID_PLACE, blockPos);

        return ActionResult.success(false);
    }
}
