package net.kuro.recrafted.structure.block.entity.custom;

import net.kuro.recrafted.structure.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class WaterCauldronBlockEntity extends BlockEntity {
    public WaterCauldronBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.WATER_CAULDRON_BE, blockPos, blockState);
    }
}
