package net.kuro.recrafted.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.block.ModBlocks;
import net.kuro.recrafted.item.custom.SuperheatedItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COPPER_INGOT = registerItem("copper_ingot",
            new Item(new FabricItemSettings()));
    public static final Item COPPER_NUGGET = registerItem("copper_nugget",
            new Item(new FabricItemSettings()));
    public static final Item NATIVE_COPPER = registerItem("native_copper",
            new Item(new FabricItemSettings()));
    public static final Item MALACHITE = registerItem("malachite",
            new Item(new FabricItemSettings()));
    public static final Item TETRAHEDRITE = registerItem("tetrahedrite",
            new Item(new FabricItemSettings()));
    public static final Item TIN_INGOT = registerItem("tin_ingot",
            new Item(new FabricItemSettings()));
    public static final Item TIN_NUGGET = registerItem("tin_nugget",
            new Item(new FabricItemSettings()));
    public static final Item CASSITERITE = registerItem("cassiterite",
            new Item(new FabricItemSettings()));
    public static final Item ZINC_INGOT = registerItem("zinc_ingot",
            new Item(new FabricItemSettings()));
    public static final Item ZINC_NUGGET = registerItem("zinc_nugget",
            new Item(new FabricItemSettings()));
    public static final Item SPHALERITE = registerItem("sphalerite",
            new Item(new FabricItemSettings()));
    public static final Item ALUMINIUM_INGOT = registerItem("aluminium_ingot",
            new Item(new FabricItemSettings()));
    public static final Item ALUMINIUM_NUGGET = registerItem("aluminium_nugget",
            new Item(new FabricItemSettings()));
    public static final Item BAUXITE = registerItem("bauxite",
            new Item(new FabricItemSettings()));
    public static final Item BISMUTH_INGOT = registerItem("bismuth_ingot",
            new Item(new FabricItemSettings()));
    public static final Item BISMUTH_NUGGET = registerItem("bismuth_nugget",
            new Item(new FabricItemSettings()));
    public static final Item BISMUTHINITE = registerItem("bismuthinite",
            new Item(new FabricItemSettings()));
    public static final Item NICKEL_INGOT = registerItem("nickel_ingot",
            new Item(new FabricItemSettings()));
    public static final Item NICKEL_NUGGET = registerItem("nickel_nugget",
            new Item(new FabricItemSettings()));
    public static final Item SERPENTINITE = registerItem("serpentinite",
            new Item(new FabricItemSettings()));
    public static final Item GARNIERITE = registerItem("garnierite",
            new Item(new FabricItemSettings()));
    public static final Item SILVER_INGOT = registerItem("silver_ingot",
            new Item(new FabricItemSettings()));
    public static final Item SILVER_NUGGET = registerItem("silver_nugget",
            new Item(new FabricItemSettings()));
    public static final Item NATIVE_SILVER = registerItem("native_silver",
            new Item(new FabricItemSettings()));
    public static final Item ARGENTITE = registerItem("argentite",
            new Item(new FabricItemSettings()));
    public static final Item GOLD_INGOT = registerItem("gold_ingot",
            new Item(new FabricItemSettings()));
    public static final Item GOLD_NUGGET = registerItem("gold_nugget",
            new Item(new FabricItemSettings()));
    public static final Item NATIVE_GOLD = registerItem("native_gold",
            new Item(new FabricItemSettings()));
    public static final Item LEAD_INGOT = registerItem("lead_ingot",
            new Item(new FabricItemSettings()));
    public static final Item LEAD_NUGGET = registerItem("lead_nugget",
            new Item(new FabricItemSettings()));
    public static final Item GALENA = registerItem("galena",
            new Item(new FabricItemSettings()));
    public static final Item IRON_INGOT = registerItem("iron_ingot",
            new Item(new FabricItemSettings()));
    public static final Item IRON_NUGGET = registerItem("iron_nugget",
            new Item(new FabricItemSettings()));
    public static final Item HEMATITE = registerItem("hematite",
            new Item(new FabricItemSettings()));
    public static final Item MAGNETITE = registerItem("magnetite",
            new Item(new FabricItemSettings()));
    public static final Item LIMONITE = registerItem("limonite",
            new Item(new FabricItemSettings()));
    public static final Item COBALT_INGOT = registerItem("cobalt_ingot",
            new Item(new FabricItemSettings()));
    public static final Item COBALT_NUGGET = registerItem("cobalt_nugget",
            new Item(new FabricItemSettings()));
    public static final Item COBALTITE = registerItem("cobaltite",
            new Item(new FabricItemSettings()));
    public static final Item PLATINUM_INGOT = registerItem("platinum_ingot",
            new Item(new FabricItemSettings()));
    public static final Item PLATINUM_NUGGET = registerItem("platinum_nugget",
            new Item(new FabricItemSettings()));
    public static final Item NATIVE_PLATINUM = registerItem("native_platinum",
            new Item(new FabricItemSettings()));
    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot",
            new Item(new FabricItemSettings()));
    public static final Item TITANIUM_NUGGET = registerItem("titanium_nugget",
            new Item(new FabricItemSettings()));
    public static final Item ILMENITE = registerItem("ilmenite",
            new Item(new FabricItemSettings()));
    public static final Item RUTILE = registerItem("rutile",
            new Item(new FabricItemSettings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot",
            new Item(new FabricItemSettings()));
    public static final Item BISMUTH_BRONZE_INGOT = registerItem("bismuth_bronze_ingot",
            new Item(new FabricItemSettings()));
    public static final Item BLACK_BRONZE_INGOT = registerItem("black_bronze_ingot",
            new Item(new FabricItemSettings()));
    public static final Item WHITE_BRONZE_INGOT = registerItem("white_bronze_ingot",
            new Item(new FabricItemSettings()));
    public static final Item BRASS_INGOT = registerItem("brass_ingot",
            new Item(new FabricItemSettings()));
    public static final Item ELECTRUM_INGOT = registerItem("electrum_ingot",
            new Item(new FabricItemSettings()));
    public static final Item STERLING_SILVER_INGOT = registerItem("sterling_silver_ingot",
            new Item(new FabricItemSettings()));
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
            new Item(new FabricItemSettings()));
    public static final Item GUNMETAL_INGOT = registerItem("gunmetal_ingot",
            new Item(new FabricItemSettings()));
    public static final Item PEWTER_INGOT = registerItem("pewter_ingot",
            new Item(new FabricItemSettings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot",
            new Item(new FabricItemSettings()));

    public static final Item ROUGH_OPAL = registerItem("rough_opal",
            new Item(new FabricItemSettings()));
    public static final Item OPAL = registerItem("opal",
            new Item(new FabricItemSettings()));

    public static final Item SUPERHEATED_COPPER_INGOT = registerItem("superheated_copper_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.COPPER_INGOT));
    public static final Item SUPERHEATED_TIN_INGOT = registerItem("superheated_tin_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.TIN_INGOT));
    public static final Item SUPERHEATED_ZINC_INGOT = registerItem("superheated_zinc_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.ZINC_INGOT));
    public static final Item SUPERHEATED_ALUMINIUM_INGOT = registerItem("superheated_aluminium_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.ALUMINIUM_INGOT));
    public static final Item SUPERHEATED_BISMUTH_INGOT = registerItem("superheated_bismuth_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.BISMUTH_INGOT));
    public static final Item SUPERHEATED_NICKEL_INGOT = registerItem("superheated_nickel_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.NICKEL_INGOT));
    public static final Item SUPERHEATED_SILVER_INGOT = registerItem("superheated_silver_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.SILVER_INGOT));
    public static final Item SUPERHEATED_GOLD_INGOT = registerItem("superheated_gold_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.GOLD_INGOT));
    public static final Item SUPERHEATED_LEAD_INGOT = registerItem("superheated_lead_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.LEAD_INGOT));
    public static final Item SUPERHEATED_IRON_INGOT = registerItem("superheated_iron_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.IRON_INGOT));
    public static final Item SUPERHEATED_COBALT_INGOT = registerItem("superheated_cobalt_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.COBALT_INGOT));
    public static final Item SUPERHEATED_PLATINUM_INGOT = registerItem("superheated_platinum_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.PLATINUM_INGOT));
    public static final Item SUPERHEATED_TITANIUM_INGOT = registerItem("superheated_titanium_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.TITANIUM_INGOT));
    public static final Item SUPERHEATED_BRONZE_INGOT = registerItem("superheated_bronze_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.BRONZE_INGOT));
    public static final Item SUPERHEATED_BISMUTH_BRONZE_INGOT = registerItem("superheated_bismuth_bronze_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.BISMUTH_BRONZE_INGOT));
    public static final Item SUPERHEATED_BLACK_BRONZE_INGOT = registerItem("superheated_black_bronze_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.BLACK_BRONZE_INGOT));
    public static final Item SUPERHEATED_WHITE_BRONZE_INGOT = registerItem("superheated_white_bronze_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.WHITE_BRONZE_INGOT));
    public static final Item SUPERHEATED_BRASS_INGOT = registerItem("superheated_brass_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.BRASS_INGOT));
    public static final Item SUPERHEATED_ELECTRUM_INGOT = registerItem("superheated_electrum_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.ELECTRUM_INGOT));
    public static final Item SUPERHEATED_STERLING_SILVER_INGOT = registerItem("superheated_sterling_silver_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.STERLING_SILVER_INGOT));
    public static final Item SUPERHEATED_ROSE_GOLD_INGOT = registerItem("superheated_rose_gold_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.ROSE_GOLD_INGOT));
    public static final Item SUPERHEATED_GUNMETAL_INGOT = registerItem("superheated_gunmetal_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.GUNMETAL_INGOT));
    public static final Item SUPERHEATED_PEWTER_INGOT = registerItem("superheated_pewter_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.PEWTER_INGOT));
    public static final Item SUPERHEATED_STEEL_INGOT = registerItem("superheated_steel_ingot",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 200, ModItems.STEEL_INGOT));

    public static final Item SUPERHEATED_COPPER_PICKAXE_HEAD = registerItem("superheated_copper_pickaxe_head",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 300, Items.AIR));
    public static final Item SUPERHEATED_COPPER_AXE_HEAD = registerItem("superheated_copper_axe_head",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 300, Items.AIR));
    public static final Item SUPERHEATED_COPPER_SHOVEL_HEAD = registerItem("superheated_copper_shovel_head",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 300, Items.AIR));
    public static final Item SUPERHEATED_COPPER_HOE_HEAD = registerItem("superheated_copper_hoe_head",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 300, Items.AIR));
    public static final Item SUPERHEATED_COPPER_BROADSWORD_BLADE = registerItem("superheated_copper_broadsword_blade",
            new SuperheatedItem(new FabricItemSettings().maxCount(1), 300, Items.AIR));

    public static final Item COPPER_PICKAXE_HEAD = registerItem("copper_pickaxe_head",
            new Item(new FabricItemSettings().maxCount(1)));
    public static final Item COPPER_AXE_HEAD = registerItem("copper_axe_head",
            new Item(new FabricItemSettings().maxCount(1)));
    public static final Item COPPER_SHOVEL_HEAD = registerItem("copper_shovel_head",
            new Item(new FabricItemSettings().maxCount(1)));
    public static final Item COPPER_HOE_HEAD = registerItem("copper_hoe_head",
            new Item(new FabricItemSettings().maxCount(1)));
    public static final Item COPPER_BROADSWORD_BLADE = registerItem("copper_broadsword_blade",
            new Item(new FabricItemSettings().maxCount(1)));

    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterial.COPPER, 1, -2.8f, new FabricItemSettings()));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterial.COPPER, 6.0f, -3.2f, new FabricItemSettings()));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterial.COPPER, 1.5f, -3.0f, new FabricItemSettings()));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterial.COPPER, 0, -3.0f, new FabricItemSettings()));
    public static final Item COPPER_BROADSWORD = registerItem("copper_broadsword",
            new SwordItem(ModToolMaterial.COPPER, 3, -2.4f, new FabricItemSettings()));
    public static final Item COPPER_HAMMER = registerItem("copper_hammer",
            new SwordItem(ModToolMaterial.COPPER, 4, -2.8f, new FabricItemSettings()));

    public static final Item BRONZE_HAMMER = registerItem("bronze_hammer",
            new SwordItem(ModToolMaterial.BRONZE, 4, -2.8f, new FabricItemSettings()));
    public static final Item BISMUTH_BRONZE_HAMMER = registerItem("bismuth_bronze_hammer",
            new SwordItem(ModToolMaterial.BISMUTH_BRONZE, 4, -2.8f, new FabricItemSettings()));
    public static final Item BLACK_BRONZE_HAMMER = registerItem("black_bronze_hammer",
            new SwordItem(ModToolMaterial.BLACK_BRONZE, 4, -2.8f, new FabricItemSettings()));
    public static final Item WHITE_BRONZE_HAMMER = registerItem("white_bronze_hammer",
            new SwordItem(ModToolMaterial.WHITE_BRONZE, 4, -2.8f, new FabricItemSettings()));
    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new SwordItem(ModToolMaterial.IRON, 4, -2.8f, new FabricItemSettings()));
    public static final Item STEEL_HAMMER = registerItem("steel_hammer",
            new SwordItem(ModToolMaterial.STEEL, 4, -2.8f, new FabricItemSettings()));

    public static final Item SPRUCE_BARREL = Items.register(ModBlocks.SPRUCE_BARREL, ModBlocks.SPRUCE_WATER_BARREL);
    public static final Item BIRCH_BARREL = Items.register(ModBlocks.BIRCH_BARREL, ModBlocks.BIRCH_WATER_BARREL);


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Recrafted.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Recrafted.LOGGER.info("Registering Mod Items for " + Recrafted.MOD_ID);
    }
}
