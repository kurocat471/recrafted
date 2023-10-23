package net.kuro.recrafted.mixin;

import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.fluid.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(AbstractCauldronBlock.class)
public interface AbstractCauldronBlockInvoker {
    @Invoker("canBeFilledByDripstone")
    public abstract boolean invokeCanBeFilledByDripstone(Fluid fluid);
}
