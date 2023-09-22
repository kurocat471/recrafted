package net.kuro.recrafted.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<AnvilBlockEntity> ANVIL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Recrafted.MOD_ID, "anvil_block_entity"),
                    FabricBlockEntityTypeBuilder.create(AnvilBlockEntity::new,
                            ModBlocks.COPPER_ANVIL, ModBlocks.BRONZE_ANVIL, ModBlocks.BISMUTH_BRONZE_ANVIL, ModBlocks.BLACK_BRONZE_ANVIL, ModBlocks.WHITE_BRONZE_ANVIL, ModBlocks.IRON_ANVIL, ModBlocks.STEEL_ANVIL).build(null));

    public static void registerBlockEntities() {
        Recrafted.LOGGER.info("Registering Block Entities for " + Recrafted.MOD_ID);
    }
}
