package net.kuro.recrafted.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kuro.recrafted.structure.block.ModBlocks;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.COPPER_BLOCK);
        addDrop(ModBlocks.EXPOSED_COPPER_BLOCK);
        addDrop(ModBlocks.WEATHERED_COPPER_BLOCK);
        addDrop(ModBlocks.OXIDIZED_COPPER_BLOCK);
        addDrop(ModBlocks.WAXED_COPPER_BLOCK);
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_BLOCK);
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_BLOCK);
        addDrop(ModBlocks.WAXED_OXIDIZED_COPPER_BLOCK);

        addDrop(ModBlocks.COPPER_GRATE);
        addDrop(ModBlocks.EXPOSED_COPPER_GRATE);
        addDrop(ModBlocks.WEATHERED_COPPER_GRATE);
        addDrop(ModBlocks.OXIDIZED_COPPER_GRATE);
        addDrop(ModBlocks.WAXED_COPPER_GRATE);
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_GRATE);
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_GRATE);
        addDrop(ModBlocks.WAXED_OXIDIZED_COPPER_GRATE);

        addDrop(ModBlocks.CHISELED_COPPER);
        addDrop(ModBlocks.EXPOSED_CHISELED_COPPER);
        addDrop(ModBlocks.WEATHERED_CHISELED_COPPER);
        addDrop(ModBlocks.OXIDIZED_CHISELED_COPPER);
        addDrop(ModBlocks.WAXED_CHISELED_COPPER);
        addDrop(ModBlocks.WAXED_EXPOSED_CHISELED_COPPER);
        addDrop(ModBlocks.WAXED_WEATHERED_CHISELED_COPPER);
        addDrop(ModBlocks.WAXED_OXIDIZED_CHISELED_COPPER);

        addDrop(ModBlocks.CUT_COPPER);
        addDrop(ModBlocks.EXPOSED_CUT_COPPER);
        addDrop(ModBlocks.WEATHERED_CUT_COPPER);
        addDrop(ModBlocks.OXIDIZED_CUT_COPPER);
        addDrop(ModBlocks.WAXED_CUT_COPPER);
        addDrop(ModBlocks.WAXED_EXPOSED_CUT_COPPER);
        addDrop(ModBlocks.WAXED_WEATHERED_CUT_COPPER);
        addDrop(ModBlocks.WAXED_OXIDIZED_CUT_COPPER);

        addDrop(ModBlocks.CUT_COPPER_STAIRS);
        addDrop(ModBlocks.EXPOSED_CUT_COPPER_STAIRS);
        addDrop(ModBlocks.WEATHERED_CUT_COPPER_STAIRS);
        addDrop(ModBlocks.OXIDIZED_CUT_COPPER_STAIRS);
        addDrop(ModBlocks.WAXED_CUT_COPPER_STAIRS);
        addDrop(ModBlocks.WAXED_EXPOSED_CUT_COPPER_STAIRS);
        addDrop(ModBlocks.WAXED_WEATHERED_CUT_COPPER_STAIRS);
        addDrop(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS);

        addDrop(ModBlocks.CUT_COPPER_SLAB, slabDrops(ModBlocks.CUT_COPPER_SLAB));
        addDrop(ModBlocks.EXPOSED_CUT_COPPER_SLAB, slabDrops(ModBlocks.EXPOSED_CUT_COPPER_SLAB));
        addDrop(ModBlocks.WEATHERED_CUT_COPPER_SLAB, slabDrops(ModBlocks.WEATHERED_CUT_COPPER_SLAB));
        addDrop(ModBlocks.OXIDIZED_CUT_COPPER_SLAB, slabDrops(ModBlocks.OXIDIZED_CUT_COPPER_SLAB));
        addDrop(ModBlocks.WAXED_CUT_COPPER_SLAB, slabDrops(ModBlocks.WAXED_CUT_COPPER_SLAB));
        addDrop(ModBlocks.WAXED_EXPOSED_CUT_COPPER_SLAB, slabDrops(ModBlocks.WAXED_EXPOSED_CUT_COPPER_SLAB));
        addDrop(ModBlocks.WAXED_WEATHERED_CUT_COPPER_SLAB, slabDrops(ModBlocks.WAXED_WEATHERED_CUT_COPPER_SLAB));
        addDrop(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_SLAB, slabDrops(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_SLAB));

        addDrop(ModBlocks.COPPER_DOOR, doorDrops(ModBlocks.COPPER_DOOR));
        addDrop(ModBlocks.EXPOSED_COPPER_DOOR, doorDrops(ModBlocks.EXPOSED_COPPER_DOOR));
        addDrop(ModBlocks.WEATHERED_COPPER_DOOR, doorDrops(ModBlocks.WEATHERED_COPPER_DOOR));
        addDrop(ModBlocks.OXIDIZED_COPPER_DOOR, doorDrops(ModBlocks.OXIDIZED_COPPER_DOOR));
        addDrop(ModBlocks.WAXED_COPPER_DOOR, doorDrops(ModBlocks.WAXED_COPPER_DOOR));
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_DOOR, doorDrops(ModBlocks.WAXED_EXPOSED_COPPER_DOOR));
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_DOOR, doorDrops(ModBlocks.WAXED_WEATHERED_COPPER_DOOR));
        addDrop(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR, doorDrops(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR));

        addDrop(ModBlocks.COPPER_TRAPDOOR);
        addDrop(ModBlocks.EXPOSED_COPPER_TRAPDOOR);
        addDrop(ModBlocks.WEATHERED_COPPER_TRAPDOOR);
        addDrop(ModBlocks.OXIDIZED_COPPER_TRAPDOOR);
        addDrop(ModBlocks.WAXED_COPPER_TRAPDOOR);
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
        addDrop(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);

        addDrop(ModBlocks.COPPER_BULB);
        addDrop(ModBlocks.EXPOSED_COPPER_BULB);
        addDrop(ModBlocks.WEATHERED_COPPER_BULB);
        addDrop(ModBlocks.OXIDIZED_COPPER_BULB);
        addDrop(ModBlocks.WAXED_COPPER_BULB);
        addDrop(ModBlocks.WAXED_EXPOSED_COPPER_BULB);
        addDrop(ModBlocks.WAXED_WEATHERED_COPPER_BULB);
        addDrop(ModBlocks.WAXED_OXIDIZED_COPPER_BULB);
    }
}
