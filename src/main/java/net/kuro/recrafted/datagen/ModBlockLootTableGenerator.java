package net.kuro.recrafted.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.structure.block.ModBlocks;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(Recrafted.COPPER_LIGHTNING_ROD);
        addDrop(Recrafted.EXPOSED_COPPER_LIGHTNING_ROD);
        addDrop(Recrafted.WEATHERED_COPPER_LIGHTNING_ROD);
        addDrop(Recrafted.OXIDIZED_COPPER_LIGHTNING_ROD);
        addDrop(Recrafted.WAXED_COPPER_LIGHTNING_ROD);
        addDrop(Recrafted.WAXED_EXPOSED_COPPER_LIGHTNING_ROD);
        addDrop(Recrafted.WAXED_WEATHERED_COPPER_LIGHTNING_ROD);
        addDrop(Recrafted.WAXED_OXIDIZED_COPPER_LIGHTNING_ROD);
    }
}
