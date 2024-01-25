package net.kuro.recrafted.mixin;

import net.kuro.recrafted.structure.item.ModItems;
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
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GrindstoneScreenHandler.class)
public abstract class GrindstoneScreenHandlerMixin extends ScreenHandler {
    @Shadow @Final Inventory input;

    protected GrindstoneScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
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
        return instance.isOf(Items.ENCHANTED_BOOK) ||
                instance.isOf(ModItems.ROUGH_OPAL);
    }

    @Redirect(method = "updateResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 1))
    private boolean redirectIsEnchantedBook2(ItemStack instance, Item item) {
        return instance.isOf(Items.ENCHANTED_BOOK) ||
                instance.isOf(ModItems.ROUGH_OPAL);
    }

    @Mixin(targets = "net.minecraft.screen.GrindstoneScreenHandler$2")
    public static class GrindstoneScreenHandlerSlot1Mixin {
        @Inject(method = "canInsert", at = @At("RETURN"), cancellable = true)
        private void canInsert(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
            if (stack.isOf(ModItems.ROUGH_OPAL)) {
                cir.setReturnValue(true);
            }
        }
    }

    @Mixin(targets = "net.minecraft.screen.GrindstoneScreenHandler$3")
    public static class GrindstoneScreenHandlerSlot2Mixin {
        @Inject(method = "canInsert", at = @At("RETURN"), cancellable = true)
        private void canInsert(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
            if (stack.isOf(ModItems.ROUGH_OPAL)) {
                cir.setReturnValue(true);
            }
        }
    }

    @Mixin(targets = "net.minecraft.screen.GrindstoneScreenHandler$4")
    public static class GrindstoneExperienceMixin {
        @Inject(method = "getExperience(Lnet/minecraft/item/ItemStack;)I", at = @At("RETURN"), cancellable = true)
        private void setExperience(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
            if (stack.isOf(ModItems.ROUGH_OPAL)) {
                cir.setReturnValue(stack.getCount());
            }
        }
    }
}
