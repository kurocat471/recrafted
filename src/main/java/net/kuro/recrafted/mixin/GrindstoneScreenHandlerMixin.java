package net.kuro.recrafted.mixin;

import net.kuro.recrafted.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.GrindstoneScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GrindstoneScreenHandler.class)
public abstract class GrindstoneScreenHandlerMixin extends ScreenHandler {
    @Shadow @Final Inventory input;

    protected GrindstoneScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }


    /**
     * @author kurocat471
     * @reason allow quickMove with stackable items
     */
    @Overwrite
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot == 2) {
                if (!this.insertItem(itemStack2, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
                slot2.onQuickTransfer(itemStack2, itemStack);
            } else if (slot == 0 || slot == 1 ? !this.insertItem(itemStack2, 3, 39, false) : (!this.insertItem(itemStack2, 0, 2, false))) {
                return ItemStack.EMPTY;
            }
            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot2.onTakeItem(player, itemStack2);
        }
        return itemStack;
    }

    @Inject(method = "grind", at = @At("TAIL"), cancellable = true)
    public void registerCustomGrindingRecipes(ItemStack item, int damage, int amount, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack itemStack = item.copyWithCount(amount);
        if (itemStack.isOf(ModItems.ROUGH_OPAL)) {
            amount = input.getStack(0).getCount() + input.getStack(1).getCount();
            if (amount <= 64) {
                itemStack = new ItemStack(ModItems.OPAL);
                itemStack.setCount(amount);
                if (item.hasCustomName()) {
                    itemStack.setCustomName(item.getName());
                }
                cir.setReturnValue(itemStack);
            } else {
                itemStack = ItemStack.EMPTY;
                cir.setReturnValue(itemStack);
            }
        }
    }

    @Redirect(method = "updateResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getCount()I", ordinal = 0))
    private int redirectCount1(ItemStack instance) {
        return 0;
    }

    @Redirect(method = "updateResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getCount()I", ordinal = 1))
    private int redirectCount2(ItemStack instance) {
        return 0;
    }

    @Redirect(method = "updateResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;areEqual(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;)Z", ordinal = 0))
    private boolean areItemsEqualRedirect(ItemStack left, ItemStack right) {
        return left.getItem() == right.getItem();
    }

    @Redirect(method = "updateResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 0))
    private boolean redirectIsEnchantedBook1(ItemStack instance, Item item) {
        return instance.isOf(Items.ENCHANTED_BOOK) || instance.isOf(ModItems.ROUGH_OPAL);
    }

    @Redirect(method = "updateResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 1))
    private boolean redirectIsEnchantedBook2(ItemStack instance, Item item) {
        return instance.isOf(Items.ENCHANTED_BOOK) || instance.isOf(ModItems.ROUGH_OPAL);
    }

    @Mixin(targets = "net.minecraft.screen.GrindstoneScreenHandler$2")
    public static class GrindstoneScreenHandlerSlot1Mixin {
        @Inject(method = "canInsert", at = @At("RETURN"), cancellable = true)
        private void canInsert(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
            cir.setReturnValue(cir.getReturnValue() || stack.isOf(ModItems.ROUGH_OPAL));
        }
    }

    @Mixin(targets = "net.minecraft.screen.GrindstoneScreenHandler$3")
    public static class GrindstoneScreenHandlerSlot2Mixin {
        @Inject(method = "canInsert", at = @At("RETURN"), cancellable = true)
        private void canInsert(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
            cir.setReturnValue(cir.getReturnValue() || stack.isOf(ModItems.ROUGH_OPAL));
        }
    }
}
