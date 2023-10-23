package net.kuro.recrafted.item.custom;

import net.kuro.recrafted.Recrafted;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SuperheatedItem extends Item {

    private final int maxAge;
    private final Item replacementItem;

    public SuperheatedItem(Settings settings, int maxAge, Item replacementItem) {
        super(settings);
        this.maxAge = maxAge;
        this.replacementItem = replacementItem;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        NbtCompound itemTag = stack.getNbt();
        if (itemTag != null) {
            if (itemTag.contains("expirationTime")) {
                int coolingTime = (int) (itemTag.getInt("expirationTime") - world.getTime());
                if (coolingTime >= (maxAge / 6) * 5) {
                    tooltip.add(Text.translatable("tooltip.mc-recrafted.cooling_0"));
                } else if (coolingTime >= (maxAge / 6) * 4) {
                    tooltip.add(Text.translatable("tooltip.mc-recrafted.cooling_1"));
                } else if (coolingTime >= (maxAge / 6) * 3) {
                    tooltip.add(Text.translatable("tooltip.mc-recrafted.cooling_2"));
                } else if (coolingTime >= (maxAge / 6) * 2) {
                    tooltip.add(Text.translatable("tooltip.mc-recrafted.cooling_3"));
                } else if (coolingTime >= maxAge / 6) {
                    tooltip.add(Text.translatable("tooltip.mc-recrafted.cooling_4"));
                } else {
                    tooltip.add(Text.translatable("tooltip.mc-recrafted.cooling_5"));
                }
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        NbtCompound itemTag = stack.getOrCreateNbt();

        if (!itemTag.contains("expirationTime")) {
            itemTag.putInt("expirationTime", (int) (world.getTime() + maxAge));
        } else {
            int age = itemTag.getInt("expirationTime");
            if (world.getTime() >= age) {
                if (replacementItem != null) {
                    ItemStack replacementStack = new ItemStack(replacementItem);
                    if ((entity instanceof PlayerEntity player)) {
                        Random random = world.random;
                        if (replacementStack.toString().equals(String.valueOf(new ItemStack(Items.AIR)))) {
                            world.playSoundFromEntity(
                                    null,
                                    player,
                                    SoundEvents.ENTITY_ITEM_BREAK,
                                    SoundCategory.BLOCKS,
                                    0.65f,
                                    0.8f + random.nextFloat() * 0.4f
                            );
                        }
                        world.playSoundFromEntity(
                                null,
                                player,
                                SoundEvents.BLOCK_LAVA_EXTINGUISH,
                                SoundCategory.BLOCKS,
                                0.35f,
                                2.6f + (random.nextFloat() - random.nextFloat()) * 0.8f
                        );
                        Inventory inventory = player.getInventory();
                        inventory.setStack(slot, replacementStack);
                    } else {
                        entity.dropStack(replacementStack);
                        stack.decrement(1);
                    }
                }
            }
        }
    }
}
