package net.kuro.recrafted.structure.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.sound.ModBlockSetType;
import net.kuro.recrafted.sound.ModBlockSoundGroup;
import net.kuro.recrafted.structure.block.custom.barrel.BarrelBehavior;
import net.kuro.recrafted.structure.block.custom.anvil.AnvilBlock;
import net.kuro.recrafted.structure.block.custom.barrel.BarrelBlock;
import net.kuro.recrafted.structure.block.custom.barrel.LeveledBarrelBlock;
import net.kuro.recrafted.structure.block.custom.bulb.BulbBlock;
import net.kuro.recrafted.structure.block.custom.grate.GrateBlock;
import net.kuro.recrafted.structure.block.custom.oxidizable.*;
import net.kuro.recrafted.structure.block.custom.patinafire.PatinaFireBlock;
import net.kuro.recrafted.structure.block.custom.potioncauldron.PotionCauldronBehavior;
import net.kuro.recrafted.structure.block.custom.potioncauldron.PotionCauldronBlock;
import net.kuro.recrafted.structure.block.custom.resistor.ResistorBlock;
import net.kuro.recrafted.structure.particle.ModParticleTypes;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.Set;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

public class ModBlocks {
    public static final Block RHYOLITE;

    public static final OxidizableBlock COPPER_BLOCK;
    public static final OxidizableBlock EXPOSED_COPPER_BLOCK;
    public static final OxidizableBlock WEATHERED_COPPER_BLOCK;
    public static final OxidizableBlock OXIDIZED_COPPER_BLOCK;
    public static final Block WAXED_COPPER_BLOCK;
    public static final Block WAXED_EXPOSED_COPPER_BLOCK;
    public static final Block WAXED_WEATHERED_COPPER_BLOCK;
    public static final Block WAXED_OXIDIZED_COPPER_BLOCK;

    public static final OxidizableBlock CHISELED_COPPER;
    public static final OxidizableBlock EXPOSED_CHISELED_COPPER;
    public static final OxidizableBlock WEATHERED_CHISELED_COPPER;
    public static final OxidizableBlock OXIDIZED_CHISELED_COPPER;
    public static final Block WAXED_CHISELED_COPPER;
    public static final Block WAXED_EXPOSED_CHISELED_COPPER;
    public static final Block WAXED_WEATHERED_CHISELED_COPPER;
    public static final Block WAXED_OXIDIZED_CHISELED_COPPER;

    public static final OxidizableGrateBlock COPPER_GRATE;
    public static final OxidizableGrateBlock EXPOSED_COPPER_GRATE;
    public static final OxidizableGrateBlock WEATHERED_COPPER_GRATE;
    public static final OxidizableGrateBlock OXIDIZED_COPPER_GRATE;
    public static final GrateBlock WAXED_COPPER_GRATE;
    public static final GrateBlock WAXED_EXPOSED_COPPER_GRATE;
    public static final GrateBlock WAXED_WEATHERED_COPPER_GRATE;
    public static final GrateBlock WAXED_OXIDIZED_COPPER_GRATE;

    public static final OxidizableBlock CUT_COPPER;
    public static final OxidizableBlock EXPOSED_CUT_COPPER;
    public static final OxidizableBlock WEATHERED_CUT_COPPER;
    public static final OxidizableBlock OXIDIZED_CUT_COPPER;
    public static final Block WAXED_CUT_COPPER;
    public static final Block WAXED_EXPOSED_CUT_COPPER;
    public static final Block WAXED_WEATHERED_CUT_COPPER;
    public static final Block WAXED_OXIDIZED_CUT_COPPER;

    public static final OxidizableStairsBlock CUT_COPPER_STAIRS;
    public static final OxidizableStairsBlock EXPOSED_CUT_COPPER_STAIRS;
    public static final OxidizableStairsBlock WEATHERED_CUT_COPPER_STAIRS;
    public static final OxidizableStairsBlock OXIDIZED_CUT_COPPER_STAIRS;
    public static final StairsBlock WAXED_CUT_COPPER_STAIRS;
    public static final StairsBlock WAXED_EXPOSED_CUT_COPPER_STAIRS;
    public static final StairsBlock WAXED_WEATHERED_CUT_COPPER_STAIRS;
    public static final StairsBlock WAXED_OXIDIZED_CUT_COPPER_STAIRS;

    public static final OxidizableSlabBlock CUT_COPPER_SLAB;
    public static final OxidizableSlabBlock EXPOSED_CUT_COPPER_SLAB;
    public static final OxidizableSlabBlock WEATHERED_CUT_COPPER_SLAB;
    public static final OxidizableSlabBlock OXIDIZED_CUT_COPPER_SLAB;
    public static final SlabBlock WAXED_CUT_COPPER_SLAB;
    public static final SlabBlock WAXED_EXPOSED_CUT_COPPER_SLAB;
    public static final SlabBlock WAXED_WEATHERED_CUT_COPPER_SLAB;
    public static final SlabBlock WAXED_OXIDIZED_CUT_COPPER_SLAB;

    public static final OxidizableDoorBlock COPPER_DOOR;
    public static final OxidizableDoorBlock EXPOSED_COPPER_DOOR;
    public static final OxidizableDoorBlock WEATHERED_COPPER_DOOR;
    public static final OxidizableDoorBlock OXIDIZED_COPPER_DOOR;
    public static final DoorBlock WAXED_COPPER_DOOR;
    public static final DoorBlock WAXED_EXPOSED_COPPER_DOOR;
    public static final DoorBlock WAXED_WEATHERED_COPPER_DOOR;
    public static final DoorBlock WAXED_OXIDIZED_COPPER_DOOR;

    public static final OxidizableTrapdoorBlock COPPER_TRAPDOOR;
    public static final OxidizableTrapdoorBlock EXPOSED_COPPER_TRAPDOOR;
    public static final OxidizableTrapdoorBlock WEATHERED_COPPER_TRAPDOOR;
    public static final OxidizableTrapdoorBlock OXIDIZED_COPPER_TRAPDOOR;
    public static final TrapdoorBlock WAXED_COPPER_TRAPDOOR;
    public static final TrapdoorBlock WAXED_EXPOSED_COPPER_TRAPDOOR;
    public static final TrapdoorBlock WAXED_WEATHERED_COPPER_TRAPDOOR;
    public static final TrapdoorBlock WAXED_OXIDIZED_COPPER_TRAPDOOR;

    public static final OxidizableBulbBlock COPPER_BULB;
    public static final OxidizableBulbBlock EXPOSED_COPPER_BULB;
    public static final OxidizableBulbBlock WEATHERED_COPPER_BULB;
    public static final OxidizableBulbBlock OXIDIZED_COPPER_BULB;
    public static final BulbBlock WAXED_COPPER_BULB;
    public static final BulbBlock WAXED_EXPOSED_COPPER_BULB;
    public static final BulbBlock WAXED_WEATHERED_COPPER_BULB;
    public static final BulbBlock WAXED_OXIDIZED_COPPER_BULB;

    public static final LightningRodBlock COPPER_LIGHTNING_ROD;
    public static final LightningRodBlock EXPOSED_COPPER_LIGHTNING_ROD;
    public static final LightningRodBlock WEATHERED_COPPER_LIGHTNING_ROD;
    public static final LightningRodBlock OXIDIZED_COPPER_LIGHTNING_ROD;
    public static final LightningRodBlock WAXED_COPPER_LIGHTNING_ROD;
    public static final LightningRodBlock WAXED_EXPOSED_COPPER_LIGHTNING_ROD;
    public static final LightningRodBlock WAXED_WEATHERED_COPPER_LIGHTNING_ROD;
    public static final LightningRodBlock WAXED_OXIDIZED_COPPER_LIGHTNING_ROD;

    public static final OxidizableAnvilBlock COPPER_ANVIL;
    public static final OxidizableAnvilBlock EXPOSED_COPPER_ANVIL;
    public static final OxidizableAnvilBlock WEATHERED_COPPER_ANVIL;
    public static final OxidizableAnvilBlock OXIDIZED_COPPER_ANVIL;
    public static final AnvilBlock WAXED_COPPER_ANVIL;
    public static final AnvilBlock WAXED_EXPOSED_COPPER_ANVIL;
    public static final AnvilBlock WAXED_WEATHERED_COPPER_ANVIL;
    public static final AnvilBlock WAXED_OXIDIZED_COPPER_ANVIL;

    public static final OxidizableResistorBlock RESISTOR;
    public static final OxidizableResistorBlock EXPOSED_RESISTOR;
    public static final OxidizableResistorBlock WEATHERED_RESISTOR;
    public static final OxidizableResistorBlock OXIDIZED_RESISTOR;
    public static final ResistorBlock WAXED_RESISTOR;
    public static final ResistorBlock WAXED_EXPOSED_RESISTOR;
    public static final ResistorBlock WAXED_WEATHERED_RESISTOR;
    public static final ResistorBlock WAXED_OXIDIZED_RESISTOR;

    public static final SandBlock PATINA_BLOCK;

    public static final PatinaFireBlock PATINA_FIRE;
    public static final TorchBlock PATINA_TORCH;
    public static final WallTorchBlock PATINA_WALL_TORCH;
    public static final LanternBlock PATINA_LANTERN;
    public static final CampfireBlock PATINA_CAMPFIRE;

    public static final Block NATIVE_COPPER_BLOCK;
    public static final Block MALACHITE_BLOCK;
    public static final Block TETRAHEDRITE_BLOCK;

    public static final Block TIN_BLOCK;
    public static final Block CASSITERITE_BLOCK;
    public static final Block ZINC_BLOCK;
    public static final Block SPHALERITE_BLOCK;
    public static final Block ALUMINIUM_BLOCK;
    public static final Block BAUXITE_BLOCK;
    public static final Block BISMUTH_BLOCK;
    public static final Block BISMUTHINITE_BLOCK;
    public static final Block NICKEL_BLOCK;
    public static final Block SERPENTINITE_BLOCK;
    public static final Block GARNIERITE_BLOCK;
    public static final Block SILVER_BLOCK;
    public static final Block NATIVE_SILVER_BLOCK;
    public static final Block ARGENTITE_BLOCK;
    public static final Block GOLD_BLOCK;
    public static final Block NATIVE_GOLD_BLOCK;
    public static final Block LEAD_BLOCK;
    public static final Block GALENA_BLOCK;
    public static final Block IRON_BLOCK;
    public static final Block HEMATITE_BLOCK;
    public static final Block MAGNETITE_BLOCK;
    public static final Block LIMONITE_BLOCK;
    public static final Block COBALT_BLOCK;
    public static final Block COBALTITE_BLOCK;
    public static final Block PLATINUM_BLOCK;
    public static final Block NATIVE_PLATINUM_BLOCK;
    public static final Block TITANIUM_BLOCK;
    public static final Block ILMENITE_BLOCK;
    public static final Block RUTILE_BLOCK;
    public static final Block BRONZE_BLOCK;
    public static final Block BISMUTH_BRONZE_BLOCK;
    public static final Block BLACK_BRONZE_BLOCK;
    public static final Block WHITE_BRONZE_BLOCK;
    public static final Block BRASS_BLOCK;
    public static final Block ELECTRUM_BLOCK;
    public static final Block STERLING_SILVER_BLOCK;
    public static final Block ROSE_GOLD_BLOCK;
    public static final Block GUNMETAL_BLOCK;
    public static final Block PEWTER_BLOCK;
    public static final Block STEEL_BLOCK;
    public static final Block OPAL_BLOCK;
    public static final AnvilBlock BRONZE_ANVIL;
    public static final AnvilBlock BISMUTH_BRONZE_ANVIL;
    public static final AnvilBlock BLACK_BRONZE_ANVIL;
    public static final AnvilBlock WHITE_BRONZE_ANVIL;
    public static final AnvilBlock IRON_ANVIL;
    public static final AnvilBlock STEEL_ANVIL;
    public static final BarrelBlock SPRUCE_BARREL;
    public static final LeveledBarrelBlock SPRUCE_WATER_BARREL;
    public static final BarrelBlock BIRCH_BARREL;
    public static final LeveledBarrelBlock BIRCH_WATER_BARREL;
    public static final PotionCauldronBlock POTION_CAULDRON;

    public static final Set<BlockState> LIGHTNING_RODS;
    public static final Block[] CAMPFIRE_BLOCKS;

    public static void initializeBarrelProperties() {
        Recrafted.LOGGER.info("Initializing Barrel Properties for " + Recrafted.MOD_ID);
        ((BarrelBlock) SPRUCE_BARREL).setFilledBlock(SPRUCE_WATER_BARREL);
        ((BarrelBlock) BIRCH_BARREL).setFilledBlock(BIRCH_WATER_BARREL);
    }

    public static void registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        Registry.register(Registries.BLOCK, new Identifier(Recrafted.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Recrafted.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static void registerBlockNoItem(String name, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(Recrafted.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        Recrafted.LOGGER.info("Registering Mod Blocks for " + Recrafted.MOD_ID);

        registerBlock("rhyolite", RHYOLITE);
        registerBlock("copper_block", COPPER_BLOCK);
        registerBlock("exposed_copper_block", EXPOSED_COPPER_BLOCK);
        registerBlock("weathered_copper_block", WEATHERED_COPPER_BLOCK);
        registerBlock("oxidized_copper_block", OXIDIZED_COPPER_BLOCK);
        registerBlock("waxed_copper_block", WAXED_COPPER_BLOCK);
        registerBlock("waxed_exposed_copper_block", WAXED_EXPOSED_COPPER_BLOCK);
        registerBlock("waxed_weathered_copper_block", WAXED_WEATHERED_COPPER_BLOCK);
        registerBlock("waxed_oxidized_copper_block", WAXED_OXIDIZED_COPPER_BLOCK);
        registerBlock("copper_grate", COPPER_GRATE);
        registerBlock("exposed_copper_grate", EXPOSED_COPPER_GRATE);
        registerBlock("weathered_copper_grate", WEATHERED_COPPER_GRATE);
        registerBlock("oxidized_copper_grate", OXIDIZED_COPPER_GRATE);
        registerBlock("waxed_copper_grate", WAXED_COPPER_GRATE);
        registerBlock("waxed_exposed_copper_grate", WAXED_EXPOSED_COPPER_GRATE);
        registerBlock("waxed_weathered_copper_grate", WAXED_WEATHERED_COPPER_GRATE);
        registerBlock("waxed_oxidized_copper_grate", WAXED_OXIDIZED_COPPER_GRATE);
        registerBlock("chiseled_copper", CHISELED_COPPER);
        registerBlock("exposed_chiseled_copper", EXPOSED_CHISELED_COPPER);
        registerBlock("weathered_chiseled_copper", WEATHERED_CHISELED_COPPER);
        registerBlock("oxidized_chiseled_copper", OXIDIZED_CHISELED_COPPER);
        registerBlock("waxed_chiseled_copper", WAXED_CHISELED_COPPER);
        registerBlock("waxed_exposed_chiseled_copper", WAXED_EXPOSED_CHISELED_COPPER);
        registerBlock("waxed_weathered_chiseled_copper", WAXED_WEATHERED_CHISELED_COPPER);
        registerBlock("waxed_oxidized_chiseled_copper", WAXED_OXIDIZED_CHISELED_COPPER);
        registerBlock("cut_copper", CUT_COPPER);
        registerBlock("exposed_cut_copper", EXPOSED_CUT_COPPER);
        registerBlock("weathered_cut_copper", WEATHERED_CUT_COPPER);
        registerBlock("oxidized_cut_copper", OXIDIZED_CUT_COPPER);
        registerBlock("waxed_cut_copper", WAXED_CUT_COPPER);
        registerBlock("waxed_exposed_cut_copper", WAXED_EXPOSED_CUT_COPPER);
        registerBlock("waxed_weathered_cut_copper", WAXED_WEATHERED_CUT_COPPER);
        registerBlock("waxed_oxidized_cut_copper", WAXED_OXIDIZED_CUT_COPPER);
        registerBlock("cut_copper_stairs", CUT_COPPER_STAIRS);
        registerBlock("exposed_cut_copper_stairs", EXPOSED_CUT_COPPER_STAIRS);
        registerBlock("weathered_cut_copper_stairs", WEATHERED_CUT_COPPER_STAIRS);
        registerBlock("oxidized_cut_copper_stairs", OXIDIZED_CUT_COPPER_STAIRS);
        registerBlock("waxed_cut_copper_stairs", WAXED_CUT_COPPER_STAIRS);
        registerBlock("waxed_exposed_cut_copper_stairs", WAXED_EXPOSED_CUT_COPPER_STAIRS);
        registerBlock("waxed_weathered_cut_copper_stairs", WAXED_WEATHERED_CUT_COPPER_STAIRS);
        registerBlock("waxed_oxidized_cut_copper_stairs", WAXED_OXIDIZED_CUT_COPPER_STAIRS);
        registerBlock("cut_copper_slab", CUT_COPPER_SLAB);
        registerBlock("exposed_cut_copper_slab", EXPOSED_CUT_COPPER_SLAB);
        registerBlock("weathered_cut_copper_slab", WEATHERED_CUT_COPPER_SLAB);
        registerBlock("oxidized_cut_copper_slab", OXIDIZED_CUT_COPPER_SLAB);
        registerBlock("waxed_cut_copper_slab", WAXED_CUT_COPPER_SLAB);
        registerBlock("waxed_exposed_cut_copper_slab", WAXED_EXPOSED_CUT_COPPER_SLAB);
        registerBlock("waxed_weathered_cut_copper_slab", WAXED_WEATHERED_CUT_COPPER_SLAB);
        registerBlock("waxed_oxidized_cut_copper_slab", WAXED_OXIDIZED_CUT_COPPER_SLAB);
        registerBlock("copper_door", COPPER_DOOR);
        registerBlock("exposed_copper_door", EXPOSED_COPPER_DOOR);
        registerBlock("weathered_copper_door", WEATHERED_COPPER_DOOR);
        registerBlock("oxidized_copper_door", OXIDIZED_COPPER_DOOR);
        registerBlock("waxed_copper_door", WAXED_COPPER_DOOR);
        registerBlock("waxed_exposed_copper_door", WAXED_EXPOSED_COPPER_DOOR);
        registerBlock("waxed_weathered_copper_door", WAXED_WEATHERED_COPPER_DOOR);
        registerBlock("waxed_oxidized_copper_door", WAXED_OXIDIZED_COPPER_DOOR);
        registerBlock("copper_trapdoor", COPPER_TRAPDOOR);
        registerBlock("exposed_copper_trapdoor", EXPOSED_COPPER_TRAPDOOR);
        registerBlock("weathered_copper_trapdoor", WEATHERED_COPPER_TRAPDOOR);
        registerBlock("oxidized_copper_trapdoor", OXIDIZED_COPPER_TRAPDOOR);
        registerBlock("waxed_copper_trapdoor", WAXED_COPPER_TRAPDOOR);
        registerBlock("waxed_exposed_copper_trapdoor", WAXED_EXPOSED_COPPER_TRAPDOOR);
        registerBlock("waxed_weathered_copper_trapdoor", WAXED_WEATHERED_COPPER_TRAPDOOR);
        registerBlock("waxed_oxidized_copper_trapdoor", WAXED_OXIDIZED_COPPER_TRAPDOOR);
        registerBlock("copper_bulb", COPPER_BULB);
        registerBlock("exposed_copper_bulb", EXPOSED_COPPER_BULB);
        registerBlock("weathered_copper_bulb", WEATHERED_COPPER_BULB);
        registerBlock("oxidized_copper_bulb", OXIDIZED_COPPER_BULB);
        registerBlock("waxed_copper_bulb", WAXED_COPPER_BULB);
        registerBlock("waxed_exposed_copper_bulb", WAXED_EXPOSED_COPPER_BULB);
        registerBlock("waxed_weathered_copper_bulb", WAXED_WEATHERED_COPPER_BULB);
        registerBlock("waxed_oxidized_copper_bulb", WAXED_OXIDIZED_COPPER_BULB);
        registerBlock("copper_lightning_rod", COPPER_LIGHTNING_ROD);
        registerBlock("exposed_copper_lightning_rod", EXPOSED_COPPER_LIGHTNING_ROD);
        registerBlock("weathered_copper_lightning_rod", WEATHERED_COPPER_LIGHTNING_ROD);
        registerBlock("oxidized_copper_lightning_rod", OXIDIZED_COPPER_LIGHTNING_ROD);
        registerBlock("waxed_copper_lightning_rod", WAXED_COPPER_LIGHTNING_ROD);
        registerBlock("waxed_exposed_copper_lightning_rod", WAXED_EXPOSED_COPPER_LIGHTNING_ROD);
        registerBlock("waxed_weathered_copper_lightning_rod", WAXED_WEATHERED_COPPER_LIGHTNING_ROD);
        registerBlock("waxed_oxidized_copper_lightning_rod", WAXED_OXIDIZED_COPPER_LIGHTNING_ROD);
        registerBlock("copper_anvil", COPPER_ANVIL);
        registerBlock("exposed_copper_anvil", EXPOSED_COPPER_ANVIL);
        registerBlock("weathered_copper_anvil", WEATHERED_COPPER_ANVIL);
        registerBlock("oxidized_copper_anvil", OXIDIZED_COPPER_ANVIL);
        registerBlock("waxed_copper_anvil", WAXED_COPPER_ANVIL);
        registerBlock("waxed_exposed_copper_anvil", WAXED_EXPOSED_COPPER_ANVIL);
        registerBlock("waxed_weathered_copper_anvil", WAXED_WEATHERED_COPPER_ANVIL);
        registerBlock("waxed_oxidized_copper_anvil", WAXED_OXIDIZED_COPPER_ANVIL);
        registerBlock("resistor", RESISTOR);
        registerBlock("exposed_resistor", EXPOSED_RESISTOR);
        registerBlock("weathered_resistor", WEATHERED_RESISTOR);
        registerBlock("oxidized_resistor", OXIDIZED_RESISTOR);
        registerBlock("waxed_resistor", WAXED_RESISTOR);
        registerBlock("waxed_exposed_resistor", WAXED_EXPOSED_RESISTOR);
        registerBlock("waxed_weathered_resistor", WAXED_WEATHERED_RESISTOR);
        registerBlock("waxed_oxidized_resistor", WAXED_OXIDIZED_RESISTOR);
        registerBlock("patina_block", PATINA_BLOCK);
        registerBlockNoItem("patina_fire", PATINA_FIRE);
        registerBlockNoItem("patina_torch", PATINA_TORCH);
        registerBlockNoItem("patina_wall_torch", PATINA_WALL_TORCH);
        registerBlock("patina_lantern", PATINA_LANTERN);
        registerBlock("patina_campfire", PATINA_CAMPFIRE);
        registerBlock("native_copper_block", NATIVE_COPPER_BLOCK);
        registerBlock("malachite_block", MALACHITE_BLOCK);
        registerBlock("tetrahedrite_block", TETRAHEDRITE_BLOCK);
        registerBlock("tin_block", TIN_BLOCK);
        registerBlock("cassiterite_block", CASSITERITE_BLOCK);
        registerBlock("zinc_block", ZINC_BLOCK);
        registerBlock("sphalerite_block", SPHALERITE_BLOCK);
        registerBlock("aluminium_block", ALUMINIUM_BLOCK);
        registerBlock("bauxite_block", BAUXITE_BLOCK);
        registerBlock("bismuth_block", BISMUTH_BLOCK);
        registerBlock("bismuthinite_block", BISMUTHINITE_BLOCK);
        registerBlock("nickel_block", NICKEL_BLOCK);
        registerBlock("serpentinite_block", SERPENTINITE_BLOCK);
        registerBlock("garnierite_block", GARNIERITE_BLOCK);
        registerBlock("silver_block", SILVER_BLOCK);
        registerBlock("native_silver_block", NATIVE_SILVER_BLOCK);
        registerBlock("argentite_block", ARGENTITE_BLOCK);
        registerBlock("gold_block", GOLD_BLOCK);
        registerBlock("native_gold_block", NATIVE_GOLD_BLOCK);
        registerBlock("lead_block", LEAD_BLOCK);
        registerBlock("galena_block", GALENA_BLOCK);
        registerBlock("iron_block", IRON_BLOCK);
        registerBlock("hematite_block", HEMATITE_BLOCK);
        registerBlock("magnetite_block", MAGNETITE_BLOCK);
        registerBlock("limonite_block", LIMONITE_BLOCK);
        registerBlock("cobalt_block", COBALT_BLOCK);
        registerBlock("cobaltite_block", COBALTITE_BLOCK);
        registerBlock("platinum_block", PLATINUM_BLOCK);
        registerBlock("native_platinum_block", NATIVE_PLATINUM_BLOCK);
        registerBlock("titanium_block", TITANIUM_BLOCK);
        registerBlock("ilmenite_block", ILMENITE_BLOCK);
        registerBlock("rutile_block", RUTILE_BLOCK);
        registerBlock("bronze_block", BRONZE_BLOCK);
        registerBlock("bismuth_bronze_block", BISMUTH_BRONZE_BLOCK);
        registerBlock("black_bronze_block", BLACK_BRONZE_BLOCK);
        registerBlock("white_bronze_block", WHITE_BRONZE_BLOCK);
        registerBlock("brass_block", BRASS_BLOCK);
        registerBlock("electrum_block", ELECTRUM_BLOCK);
        registerBlock("sterling_silver_block", STERLING_SILVER_BLOCK);
        registerBlock("rose_gold_block", ROSE_GOLD_BLOCK);
        registerBlock("gunmetal_block", GUNMETAL_BLOCK);
        registerBlock("pewter_block", PEWTER_BLOCK);
        registerBlock("steel_block", STEEL_BLOCK);
        registerBlock("opal_block", OPAL_BLOCK);
        registerBlock("bronze_anvil", BRONZE_ANVIL);
        registerBlock("bismuth_bronze_anvil", BISMUTH_BRONZE_ANVIL);
        registerBlock("black_bronze_anvil", BLACK_BRONZE_ANVIL);
        registerBlock("white_bronze_anvil", WHITE_BRONZE_ANVIL);
        registerBlock("iron_anvil", IRON_ANVIL);
        registerBlock("steel_anvil", STEEL_ANVIL);
        registerBlockNoItem("spruce_barrel", SPRUCE_BARREL);
        registerBlockNoItem("spruce_water_barrel", SPRUCE_WATER_BARREL);
        registerBlockNoItem("birch_barrel", BIRCH_BARREL);
        registerBlockNoItem("birch_water_barrel", BIRCH_WATER_BARREL);
        registerBlockNoItem("potion_cauldron", POTION_CAULDRON);
    }

    static {
        RHYOLITE = new Block(FabricBlockSettings.copyOf(Blocks.STONE));

        COPPER_BLOCK = new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        EXPOSED_COPPER_BLOCK = new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WEATHERED_COPPER_BLOCK = new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        OXIDIZED_COPPER_BLOCK = new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));

        WAXED_COPPER_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_EXPOSED_COPPER_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_WEATHERED_COPPER_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_OXIDIZED_COPPER_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));

        COPPER_GRATE = new OxidizableGrateBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque());
        EXPOSED_COPPER_GRATE = new OxidizableGrateBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque());
        WEATHERED_COPPER_GRATE = new OxidizableGrateBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque());
        OXIDIZED_COPPER_GRATE = new OxidizableGrateBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque());

        WAXED_COPPER_GRATE = new GrateBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque());
        WAXED_EXPOSED_COPPER_GRATE = new GrateBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque());
        WAXED_WEATHERED_COPPER_GRATE = new GrateBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque());
        WAXED_OXIDIZED_COPPER_GRATE = new GrateBlock(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque());

        CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        EXPOSED_CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WEATHERED_CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        OXIDIZED_CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));

        WAXED_CHISELED_COPPER = new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_EXPOSED_CHISELED_COPPER = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_WEATHERED_CHISELED_COPPER = new Block(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_OXIDIZED_CHISELED_COPPER = new Block(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));

        CUT_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        EXPOSED_CUT_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WEATHERED_CUT_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        OXIDIZED_CUT_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));

        WAXED_CUT_COPPER = new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_EXPOSED_CUT_COPPER = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_WEATHERED_CUT_COPPER = new Block(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_OXIDIZED_CUT_COPPER = new Block(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));

        CUT_COPPER_STAIRS = new OxidizableStairsBlock(Oxidizable.OxidationLevel.UNAFFECTED, ModBlocks.CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        EXPOSED_CUT_COPPER_STAIRS = new OxidizableStairsBlock(Oxidizable.OxidationLevel.EXPOSED, ModBlocks.EXPOSED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WEATHERED_CUT_COPPER_STAIRS = new OxidizableStairsBlock(Oxidizable.OxidationLevel.WEATHERED, ModBlocks.WEATHERED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        OXIDIZED_CUT_COPPER_STAIRS = new OxidizableStairsBlock(Oxidizable.OxidationLevel.OXIDIZED, ModBlocks.OXIDIZED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));

        WAXED_CUT_COPPER_STAIRS = new StairsBlock(ModBlocks.WAXED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_EXPOSED_CUT_COPPER_STAIRS = new StairsBlock(ModBlocks.WAXED_EXPOSED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_WEATHERED_CUT_COPPER_STAIRS = new StairsBlock(ModBlocks.WAXED_WEATHERED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_OXIDIZED_CUT_COPPER_STAIRS = new StairsBlock(ModBlocks.WAXED_OXIDIZED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));

        CUT_COPPER_SLAB = new OxidizableSlabBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        EXPOSED_CUT_COPPER_SLAB = new OxidizableSlabBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WEATHERED_CUT_COPPER_SLAB = new OxidizableSlabBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        OXIDIZED_CUT_COPPER_SLAB = new OxidizableSlabBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));

        WAXED_CUT_COPPER_SLAB = new SlabBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_EXPOSED_CUT_COPPER_SLAB = new SlabBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_WEATHERED_CUT_COPPER_SLAB = new SlabBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WAXED_OXIDIZED_CUT_COPPER_SLAB = new SlabBlock(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER));

        COPPER_DOOR = new OxidizableDoorBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);
        EXPOSED_COPPER_DOOR = new OxidizableDoorBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);
        WEATHERED_COPPER_DOOR = new OxidizableDoorBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);
        OXIDIZED_COPPER_DOOR = new OxidizableDoorBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);

        WAXED_COPPER_DOOR = new DoorBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);
        WAXED_EXPOSED_COPPER_DOOR = new DoorBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);
        WAXED_WEATHERED_COPPER_DOOR = new DoorBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);
        WAXED_OXIDIZED_COPPER_DOOR = new DoorBlock(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);

        COPPER_TRAPDOOR = new OxidizableTrapdoorBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);
        EXPOSED_COPPER_TRAPDOOR = new OxidizableTrapdoorBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);
        WEATHERED_COPPER_TRAPDOOR = new OxidizableTrapdoorBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);
        OXIDIZED_COPPER_TRAPDOOR = new OxidizableTrapdoorBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);

        WAXED_COPPER_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);
        WAXED_EXPOSED_COPPER_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);
        WAXED_WEATHERED_COPPER_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);
        WAXED_OXIDIZED_COPPER_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER);

        COPPER_BULB = new OxidizableBulbBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(15)));
        EXPOSED_COPPER_BULB = new OxidizableBulbBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(12)));
        WEATHERED_COPPER_BULB = new OxidizableBulbBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(8)));
        OXIDIZED_COPPER_BULB = new OxidizableBulbBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(4)));

        WAXED_COPPER_BULB = new BulbBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(15)));
        WAXED_EXPOSED_COPPER_BULB = new BulbBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(12)));
        WAXED_WEATHERED_COPPER_BULB = new BulbBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(8)));
        WAXED_OXIDIZED_COPPER_BULB = new BulbBlock(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(4)));

        COPPER_LIGHTNING_ROD = new OxidizableLightningRodBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());
        EXPOSED_COPPER_LIGHTNING_ROD = new OxidizableLightningRodBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());
        WEATHERED_COPPER_LIGHTNING_ROD = new OxidizableLightningRodBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());
        OXIDIZED_COPPER_LIGHTNING_ROD = new OxidizableLightningRodBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());

        WAXED_COPPER_LIGHTNING_ROD = new LightningRodBlock(FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());
        WAXED_EXPOSED_COPPER_LIGHTNING_ROD = new LightningRodBlock(FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());
        WAXED_WEATHERED_COPPER_LIGHTNING_ROD = new LightningRodBlock(FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());
        WAXED_OXIDIZED_COPPER_LIGHTNING_ROD = new LightningRodBlock(FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());

        COPPER_ANVIL = new OxidizableAnvilBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1);
        EXPOSED_COPPER_ANVIL = new OxidizableAnvilBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().solid().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1);
        WEATHERED_COPPER_ANVIL = new OxidizableAnvilBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().solid().mapColor(MapColor.DARK_AQUA).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1);
        OXIDIZED_COPPER_ANVIL = new OxidizableAnvilBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().solid().mapColor(MapColor.TEAL).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1);

        WAXED_COPPER_ANVIL = new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1);
        WAXED_EXPOSED_COPPER_ANVIL = new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1);
        WAXED_WEATHERED_COPPER_ANVIL = new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.DARK_AQUA).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1);
        WAXED_OXIDIZED_COPPER_ANVIL = new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.TEAL).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1);


        RESISTOR = new OxidizableResistorBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 12);
        EXPOSED_RESISTOR = new OxidizableResistorBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 9);
        WEATHERED_RESISTOR = new OxidizableResistorBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 6);
        OXIDIZED_RESISTOR = new OxidizableResistorBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 3);

        WAXED_RESISTOR = new ResistorBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 12);
        WAXED_EXPOSED_RESISTOR = new ResistorBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 9);
        WAXED_WEATHERED_RESISTOR = new ResistorBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 6);
        WAXED_OXIDIZED_RESISTOR = new ResistorBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 3);


        PATINA_BLOCK = new SandBlock(6273934, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.SNARE).strength(0.5f).sounds(BlockSoundGroup.SAND));

        PATINA_FIRE = new PatinaFireBlock(FabricBlockSettings.create().mapColor(MapColor.TEAL).replaceable().noCollision().breakInstantly().luminance(state -> 13).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY));
        PATINA_TORCH = new TorchBlock(FabricBlockSettings.create().noCollision().breakInstantly().luminance(state -> 13).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY), ModParticleTypes.PATINA_FIRE_FLAME);
        PATINA_WALL_TORCH = new WallTorchBlock(FabricBlockSettings.create().noCollision().breakInstantly().luminance(state -> 13).sounds(BlockSoundGroup.WOOD).dropsLike(PATINA_TORCH).pistonBehavior(PistonBehavior.DESTROY), ModParticleTypes.PATINA_FIRE_FLAME);
        PATINA_LANTERN = new LanternBlock(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).solid().requiresTool().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance(state -> 13).nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
        PATINA_CAMPFIRE = new CampfireBlock(false, 1, FabricBlockSettings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(Instrument.BASS).strength(2.0f).sounds(BlockSoundGroup.WOOD).luminance(Blocks.createLightLevelFromLitBlockState(13)).nonOpaque().burnable());


        NATIVE_COPPER_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.BASALT));
        MALACHITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.BASALT));
        TETRAHEDRITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.BASALT));



        TIN_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
        CASSITERITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF));
        ZINC_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_CYAN).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
        SPHALERITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_CYAN).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF));
        ALUMINIUM_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.WHITE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
        BAUXITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.WHITE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF));
        BISMUTH_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_CYAN).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
        BISMUTHINITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_CYAN).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF));
        NICKEL_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIME).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
        SERPENTINITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIME).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF));
        GARNIERITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIME).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF));
        SILVER_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.DIAMOND_BLUE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
        NATIVE_SILVER_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.DIAMOND_BLUE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF));
        ARGENTITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.DIAMOND_BLUE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF));
        GOLD_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.GOLD).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
        NATIVE_GOLD_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.GOLD).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF));
        LEAD_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_BLUE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE));
        GALENA_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_BLUE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS));
        IRON_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
        HEMATITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF));
        MAGNETITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF));
        LIMONITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF));
        COBALT_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.LIGHT_BLUE).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        COBALTITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.LIGHT_BLUE).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.BASALT));
        PLATINUM_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_MAGENTA).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE));
        NATIVE_PLATINUM_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_MAGENTA).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS));
        TITANIUM_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.PALE_PURPLE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE));
        ILMENITE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.PALE_PURPLE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS));
        RUTILE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.PALE_PURPLE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS));
        BRONZE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        BISMUTH_BRONZE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_GREEN).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        BLACK_BRONZE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_BLUE).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        WHITE_BRONZE_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.RAW_IRON_PINK).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        BRASS_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.YELLOW).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
        ELECTRUM_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_YELLOW).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        STERLING_SILVER_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.DIAMOND_BLUE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
        ROSE_GOLD_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_MAGENTA).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER));
        GUNMETAL_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_BLUE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE));
        PEWTER_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE));
        STEEL_BLOCK = new Block(FabricBlockSettings.create().mapColor(MapColor.DEEPSLATE_GRAY).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE));

        OPAL_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK));

        BRONZE_ANVIL = new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.SPRUCE_BROWN).nonOpaque().requiresTool().strength(5.0f, 1200.0f).sounds(BlockSoundGroup.ANVIL).pistonBehavior(PistonBehavior.BLOCK), "bronze", 2);
        BISMUTH_BRONZE_ANVIL = new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.TERRACOTTA_GREEN).nonOpaque().requiresTool().strength(5.0f, 1200.0f).sounds(BlockSoundGroup.ANVIL).pistonBehavior(PistonBehavior.BLOCK), "bismuth_bronze", 2);
        BLACK_BRONZE_ANVIL = new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.TERRACOTTA_BLUE).nonOpaque().requiresTool().strength(5.0f, 1200.0f).sounds(BlockSoundGroup.ANVIL).pistonBehavior(PistonBehavior.BLOCK), "black_bronze", 2);
        WHITE_BRONZE_ANVIL = new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.RAW_IRON_PINK).nonOpaque().requiresTool().strength(5.0f, 1200.0f).sounds(BlockSoundGroup.ANVIL).pistonBehavior(PistonBehavior.BLOCK), "white_bronze", 2);
        IRON_ANVIL = new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.IRON_GRAY).nonOpaque().requiresTool().strength(5.0f, 1200.0f).sounds(BlockSoundGroup.ANVIL).pistonBehavior(PistonBehavior.BLOCK), "iron", 3);
        STEEL_ANVIL = new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.DEEPSLATE_GRAY).nonOpaque().requiresTool().strength(5.0f, 1200.0f).sounds(BlockSoundGroup.ANVIL).pistonBehavior(PistonBehavior.BLOCK), "steel", 4);

        SPRUCE_BARREL = new BarrelBlock(FabricBlockSettings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(Instrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable(), null);
        SPRUCE_WATER_BARREL = new LeveledBarrelBlock(FabricBlockSettings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(Instrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD), ModBlocks.SPRUCE_BARREL, LeveledBarrelBlock.RAIN_PREDICATE, BarrelBehavior.WATER_BARREL_BEHAVIOR);
        BIRCH_BARREL =  new BarrelBlock(FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable(), null);
        BIRCH_WATER_BARREL = new LeveledBarrelBlock(FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD), ModBlocks.BIRCH_BARREL, LeveledBarrelBlock.RAIN_PREDICATE, BarrelBehavior.WATER_BARREL_BEHAVIOR);

        POTION_CAULDRON = new PotionCauldronBlock(FabricBlockSettings.copyOf(Blocks.CAULDRON), PotionCauldronBehavior.MAP);


        LIGHTNING_RODS = ImmutableList.of(
                Blocks.LIGHTNING_ROD,
                COPPER_LIGHTNING_ROD,
                EXPOSED_COPPER_LIGHTNING_ROD,
                WEATHERED_COPPER_LIGHTNING_ROD,
                OXIDIZED_COPPER_LIGHTNING_ROD,
                WAXED_COPPER_LIGHTNING_ROD,
                WAXED_EXPOSED_COPPER_LIGHTNING_ROD,
                WAXED_WEATHERED_COPPER_LIGHTNING_ROD,
                WAXED_OXIDIZED_COPPER_LIGHTNING_ROD
        ).stream().flatMap(block -> block.getStateManager().getStates().stream()).collect(ImmutableSet.toImmutableSet());

        CAMPFIRE_BLOCKS = new Block[]{PATINA_CAMPFIRE};

    }
}
