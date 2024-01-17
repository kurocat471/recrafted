package net.kuro.recrafted.structure.block;

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
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

public class ModBlocks {
    public static final Block RHYOLITE = registerBlock("rhyolite",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block COPPER_BLOCK = registerBlock("copper_block",
            new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block EXPOSED_COPPER_BLOCK = registerBlock("exposed_copper_block",
            new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WEATHERED_COPPER_BLOCK = registerBlock("weathered_copper_block",
            new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block OXIDIZED_COPPER_BLOCK = registerBlock("oxidized_copper_block",
            new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));

    public static final Block WAXED_COPPER_BLOCK = registerBlock("waxed_copper_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_EXPOSED_COPPER_BLOCK = registerBlock("waxed_exposed_copper_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_WEATHERED_COPPER_BLOCK = registerBlock("waxed_weathered_copper_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_OXIDIZED_COPPER_BLOCK = registerBlock("waxed_oxidized_copper_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));

    public static final Block COPPER_GRATE = registerBlock("copper_grate",
            new OxidizableGrateBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block EXPOSED_COPPER_GRATE = registerBlock("exposed_copper_grate",
            new OxidizableGrateBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block WEATHERED_COPPER_GRATE = registerBlock("weathered_copper_grate",
            new OxidizableGrateBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block OXIDIZED_COPPER_GRATE = registerBlock("oxidized_copper_grate",
            new OxidizableGrateBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque()));

    public static final Block WAXED_COPPER_GRATE = registerBlock("waxed_copper_grate",
            new GrateBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block WAXED_EXPOSED_COPPER_GRATE = registerBlock("waxed_exposed_copper_grate",
            new GrateBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block WAXED_WEATHERED_COPPER_GRATE = registerBlock("waxed_weathered_copper_grate",
            new GrateBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque()));
    public static final Block WAXED_OXIDIZED_COPPER_GRATE = registerBlock("waxed_oxidized_copper_grate",
            new GrateBlock(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_GRATE).nonOpaque().solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never).allowsSpawning(Blocks::never).nonOpaque()));

    public static final Block CHISELED_COPPER = registerBlock("chiseled_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block EXPOSED_CHISELED_COPPER = registerBlock("exposed_chiseled_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WEATHERED_CHISELED_COPPER = registerBlock("weathered_chiseled_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block OXIDIZED_CHISELED_COPPER = registerBlock("oxidized_chiseled_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));

    public static final Block WAXED_CHISELED_COPPER = registerBlock("waxed_chiseled_copper",
            new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_EXPOSED_CHISELED_COPPER = registerBlock("waxed_exposed_chiseled_copper",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_WEATHERED_CHISELED_COPPER = registerBlock("waxed_weathered_chiseled_copper",
            new Block(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_OXIDIZED_CHISELED_COPPER = registerBlock("waxed_oxidized_chiseled_copper",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));

    public static final Block CUT_COPPER = registerBlock("cut_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block EXPOSED_CUT_COPPER = registerBlock("exposed_cut_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WEATHERED_CUT_COPPER = registerBlock("weathered_cut_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block OXIDIZED_CUT_COPPER = registerBlock("oxidized_cut_copper",
            new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));

    public static final Block WAXED_CUT_COPPER = registerBlock("waxed_cut_copper",
            new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_EXPOSED_CUT_COPPER = registerBlock("waxed_exposed_cut_copper",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_WEATHERED_CUT_COPPER = registerBlock("waxed_weathered_cut_copper",
            new Block(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_OXIDIZED_CUT_COPPER = registerBlock("waxed_oxidized_cut_copper",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));

    public static final Block CUT_COPPER_STAIRS = registerBlock("cut_copper_stairs",
            new OxidizableStairsBlock(Oxidizable.OxidationLevel.UNAFFECTED, ModBlocks.CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block EXPOSED_CUT_COPPER_STAIRS = registerBlock("exposed_cut_copper_stairs",
            new OxidizableStairsBlock(Oxidizable.OxidationLevel.EXPOSED, ModBlocks.EXPOSED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WEATHERED_CUT_COPPER_STAIRS = registerBlock("weathered_cut_copper_stairs",
            new OxidizableStairsBlock(Oxidizable.OxidationLevel.WEATHERED, ModBlocks.WEATHERED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block OXIDIZED_CUT_COPPER_STAIRS = registerBlock("oxidized_cut_copper_stairs",
            new OxidizableStairsBlock(Oxidizable.OxidationLevel.OXIDIZED, ModBlocks.OXIDIZED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));

    public static final Block WAXED_CUT_COPPER_STAIRS = registerBlock("waxed_cut_copper_stairs",
            new StairsBlock(ModBlocks.WAXED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_EXPOSED_CUT_COPPER_STAIRS = registerBlock("waxed_exposed_cut_copper_stairs",
            new StairsBlock(ModBlocks.WAXED_EXPOSED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_WEATHERED_CUT_COPPER_STAIRS = registerBlock("waxed_weathered_cut_copper_stairs",
            new StairsBlock(ModBlocks.WAXED_WEATHERED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_OXIDIZED_CUT_COPPER_STAIRS = registerBlock("waxed_oxidized_cut_copper_stairs",
            new StairsBlock(ModBlocks.WAXED_OXIDIZED_CUT_COPPER.getDefaultState(), FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));

    public static final Block CUT_COPPER_SLAB = registerBlock("cut_copper_slab",
            new OxidizableSlabBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block EXPOSED_CUT_COPPER_SLAB = registerBlock("exposed_cut_copper_slab",
            new OxidizableSlabBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WEATHERED_CUT_COPPER_SLAB = registerBlock("weathered_cut_copper_slab",
            new OxidizableSlabBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block OXIDIZED_CUT_COPPER_SLAB = registerBlock("oxidized_cut_copper_slab",
            new OxidizableSlabBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));

    public static final Block WAXED_CUT_COPPER_SLAB = registerBlock("waxed_cut_copper_slab",
            new SlabBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_EXPOSED_CUT_COPPER_SLAB = registerBlock("waxed_exposed_cut_copper_slab",
            new SlabBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_WEATHERED_CUT_COPPER_SLAB = registerBlock("waxed_weathered_cut_copper_slab",
            new SlabBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WAXED_OXIDIZED_CUT_COPPER_SLAB = registerBlock("waxed_oxidized_cut_copper_slab",
            new SlabBlock(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));

    public static final Block COPPER_DOOR = registerBlock("copper_door",
            new OxidizableDoorBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));
    public static final Block EXPOSED_COPPER_DOOR = registerBlock("exposed_copper_door",
            new OxidizableDoorBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));
    public static final Block WEATHERED_COPPER_DOOR = registerBlock("weathered_copper_door",
            new OxidizableDoorBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));
    public static final Block OXIDIZED_COPPER_DOOR = registerBlock("oxidized_copper_door",
            new OxidizableDoorBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));

    public static final Block WAXED_COPPER_DOOR = registerBlock("waxed_copper_door",
            new DoorBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));
    public static final Block WAXED_EXPOSED_COPPER_DOOR = registerBlock("waxed_exposed_copper_door",
            new DoorBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));
    public static final Block WAXED_WEATHERED_COPPER_DOOR = registerBlock("waxed_weathered_copper_door",
            new DoorBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));
    public static final Block WAXED_OXIDIZED_COPPER_DOOR = registerBlock("waxed_oxidized_copper_door",
            new DoorBlock(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));

    public static final Block COPPER_TRAPDOOR = registerBlock("copper_trapdoor",
            new OxidizableTrapdoorBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));
    public static final Block EXPOSED_COPPER_TRAPDOOR = registerBlock("exposed_copper_trapdoor",
            new OxidizableTrapdoorBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));
    public static final Block WEATHERED_COPPER_TRAPDOOR = registerBlock("weathered_copper_trapdoor",
            new OxidizableTrapdoorBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));
    public static final Block OXIDIZED_COPPER_TRAPDOOR = registerBlock("oxidized_copper_trapdoor",
            new OxidizableTrapdoorBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));

    public static final Block WAXED_COPPER_TRAPDOOR = registerBlock("waxed_copper_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));
    public static final Block WAXED_EXPOSED_COPPER_TRAPDOOR = registerBlock("waxed_exposed_copper_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));
    public static final Block WAXED_WEATHERED_COPPER_TRAPDOOR = registerBlock("waxed_weathered_copper_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));
    public static final Block WAXED_OXIDIZED_COPPER_TRAPDOOR = registerBlock("waxed_oxidized_copper_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque(), ModBlockSetType.COPPER));

    public static final Block COPPER_BULB = registerBlock("copper_bulb",
            new OxidizableBulbBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(15))));
    public static final Block EXPOSED_COPPER_BULB = registerBlock("exposed_copper_bulb",
            new OxidizableBulbBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(12))));
    public static final Block WEATHERED_COPPER_BULB = registerBlock("weathered_copper_bulb",
            new OxidizableBulbBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(8))));
    public static final Block OXIDIZED_COPPER_BULB = registerBlock("oxidized_copper_bulb",
            new OxidizableBulbBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(4))));

    public static final Block WAXED_COPPER_BULB = registerBlock("waxed_copper_bulb",
            new BulbBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(15))));
    public static final Block WAXED_EXPOSED_COPPER_BULB = registerBlock("waxed_exposed_copper_bulb",
            new BulbBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(12))));
    public static final Block WAXED_WEATHERED_COPPER_BULB = registerBlock("waxed_weathered_copper_bulb",
            new BulbBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(8))));
    public static final Block WAXED_OXIDIZED_COPPER_BULB = registerBlock("waxed_oxidized_copper_bulb",
            new BulbBlock(FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(ModBlockSoundGroup.COPPER_BULB).solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(4))));




    public static final Block COPPER_ANVIL = registerBlock("copper_anvil",
            new OxidizableAnvilBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1));
    public static final Block EXPOSED_COPPER_ANVIL = registerBlock("exposed_copper_anvil",
            new OxidizableAnvilBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().solid().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1));
    public static final Block WEATHERED_COPPER_ANVIL = registerBlock("weathered_copper_anvil",
            new OxidizableAnvilBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().solid().mapColor(MapColor.DARK_AQUA).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1));
    public static final Block OXIDIZED_COPPER_ANVIL = registerBlock("oxidized_copper_anvil",
            new OxidizableAnvilBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().solid().mapColor(MapColor.TEAL).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1));

    public static final Block WAXED_COPPER_ANVIL = registerBlock("waxed_copper_anvil",
            new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1));
    public static final Block WAXED_EXPOSED_COPPER_ANVIL = registerBlock("waxed_exposed_copper_anvil",
            new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1));
    public static final Block WAXED_WEATHERED_COPPER_ANVIL = registerBlock("waxed_weathered_copper_anvil",
            new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.DARK_AQUA).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1));
    public static final Block WAXED_OXIDIZED_COPPER_ANVIL = registerBlock("waxed_oxidized_copper_anvil",
            new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.TEAL).nonOpaque().requiresTool().strength(3.0f, 1200.0f).sounds(BlockSoundGroup.COPPER).pistonBehavior(PistonBehavior.BLOCK), "copper", 1));


    public static final Block RESISTOR = registerBlock("resistor",
            new OxidizableResistorBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 12));
    public static final Block EXPOSED_RESISTOR = registerBlock("exposed_resistor",
            new OxidizableResistorBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 9));
    public static final Block WEATHERED_RESISTOR = registerBlock("weathered_resistor",
            new OxidizableResistorBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 6));
    public static final Block OXIDIZED_RESISTOR = registerBlock("oxidized_resistor",
            new OxidizableResistorBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 3));

    public static final Block WAXED_RESISTOR = registerBlock("waxed_resistor",
            new ResistorBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 12));
    public static final Block WAXED_EXPOSED_RESISTOR = registerBlock("waxed_exposed_resistor",
            new ResistorBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 9));
    public static final Block WAXED_WEATHERED_RESISTOR = registerBlock("waxed_weathered_resistor",
            new ResistorBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 6));
    public static final Block WAXED_OXIDIZED_RESISTOR = registerBlock("waxed_oxidized_resistor",
            new ResistorBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.STONE).pistonBehavior(PistonBehavior.DESTROY), 3));


    public static final Block PATINA_BLOCK = registerBlock("patina_block",
            new SandBlock(6273934, FabricBlockSettings.create().mapColor(MapColor.TEAL).instrument(Instrument.SNARE).strength(0.5f).sounds(BlockSoundGroup.SAND)));

    public static final Block PATINA_FIRE = registerBlockNoItem("patina_fire",
            new PatinaFireBlock(FabricBlockSettings.create().mapColor(MapColor.TEAL).replaceable().noCollision().breakInstantly().luminance(state -> 13).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PATINA_TORCH = registerBlockNoItem("patina_torch",
            new TorchBlock(FabricBlockSettings.create().noCollision().breakInstantly().luminance(state -> 13).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY), ModParticleTypes.PATINA_FIRE_FLAME));
    public static final Block PATINA_WALL_TORCH = registerBlockNoItem("patina_wall_torch",
            new WallTorchBlock(FabricBlockSettings.create().noCollision().breakInstantly().luminance(state -> 13).sounds(BlockSoundGroup.WOOD).dropsLike(PATINA_TORCH).pistonBehavior(PistonBehavior.DESTROY), ModParticleTypes.PATINA_FIRE_FLAME));
    public static final Block PATINA_LANTERN = registerBlock("patina_lantern",
            new LanternBlock(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).solid().requiresTool().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance(state -> 13).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PATINA_CAMPFIRE = registerBlock("patina_campfire",
            new CampfireBlock(false, 1, FabricBlockSettings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(Instrument.BASS).strength(2.0f).sounds(BlockSoundGroup.WOOD).luminance(Blocks.createLightLevelFromLitBlockState(13)).nonOpaque().burnable()));

    public static final Block NATIVE_COPPER_BLOCK = registerBlock("native_copper_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.BASALT)));
    public static final Block MALACHITE_BLOCK = registerBlock("malachite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.BASALT)));
    public static final Block TETRAHEDRITE_BLOCK = registerBlock("tetrahedrite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.BASALT)));



    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block CASSITERITE_BLOCK = registerBlock("cassiterite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF)));
    public static final Block ZINC_BLOCK = registerBlock("zinc_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_CYAN).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block SPHALERITE_BLOCK = registerBlock("sphalerite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_CYAN).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF)));
    public static final Block ALUMINIUM_BLOCK = registerBlock("aluminium_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.WHITE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block BAUXITE_BLOCK = registerBlock("bauxite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.WHITE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF)));
    public static final Block BISMUTH_BLOCK = registerBlock("bismuth_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_CYAN).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block BISMUTHINITE_BLOCK = registerBlock("bismuthinite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_CYAN).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF)));
    public static final Block NICKEL_BLOCK = registerBlock("nickel_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIME).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block SERPENTINITE_BLOCK = registerBlock("serpentinite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIME).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF)));
    public static final Block GARNIERITE_BLOCK = registerBlock("garnierite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_LIME).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF)));
    public static final Block SILVER_BLOCK = registerBlock("silver_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.DIAMOND_BLUE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block NATIVE_SILVER_BLOCK = registerBlock("native_silver_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.DIAMOND_BLUE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF)));
    public static final Block ARGENTITE_BLOCK = registerBlock("argentite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.DIAMOND_BLUE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF)));
    public static final Block GOLD_BLOCK = registerBlock("gold_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.GOLD).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block NATIVE_GOLD_BLOCK = registerBlock("native_gold_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.GOLD).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF)));
    public static final Block LEAD_BLOCK = registerBlock("lead_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_BLUE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block GALENA_BLOCK = registerBlock("galena_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_BLUE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS)));
    public static final Block IRON_BLOCK = registerBlock("iron_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block HEMATITE_BLOCK = registerBlock("hematite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF)));
    public static final Block MAGNETITE_BLOCK = registerBlock("magnetite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF)));
    public static final Block LIMONITE_BLOCK = registerBlock("limonite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.TUFF)));
    public static final Block COBALT_BLOCK = registerBlock("cobalt_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.LIGHT_BLUE).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block COBALTITE_BLOCK = registerBlock("cobaltite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.LIGHT_BLUE).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.BASALT)));
    public static final Block PLATINUM_BLOCK = registerBlock("platinum_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_MAGENTA).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block NATIVE_PLATINUM_BLOCK = registerBlock("native_platinum_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_MAGENTA).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS)));
    public static final Block TITANIUM_BLOCK = registerBlock("titanium_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.PALE_PURPLE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block ILMENITE_BLOCK = registerBlock("ilmenite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.PALE_PURPLE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS)));
    public static final Block RUTILE_BLOCK = registerBlock("rutile_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.PALE_PURPLE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.ANCIENT_DEBRIS)));
    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block BISMUTH_BRONZE_BLOCK = registerBlock("bismuth_bronze_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_GREEN).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block BLACK_BRONZE_BLOCK = registerBlock("black_bronze_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_BLUE).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block WHITE_BRONZE_BLOCK = registerBlock("white_bronze_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.RAW_IRON_PINK).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block BRASS_BLOCK = registerBlock("brass_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.YELLOW).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block ELECTRUM_BLOCK = registerBlock("electrum_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_YELLOW).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block STERLING_SILVER_BLOCK = registerBlock("sterling_silver_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.DIAMOND_BLUE).instrument(Instrument.BELL).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_MAGENTA).instrument(Instrument.XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER)));
    public static final Block GUNMETAL_BLOCK = registerBlock("gunmetal_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_BLUE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block PEWTER_BLOCK = registerBlock("pewter_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.DEEPSLATE_GRAY).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.NETHERITE)));

    public static final Block OPAL_BLOCK = registerBlock("opal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));

    public static final Block BRONZE_ANVIL = registerBlock("bronze_anvil",
            new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.SPRUCE_BROWN).nonOpaque().requiresTool().strength(5.0f, 1200.0f).sounds(BlockSoundGroup.ANVIL).pistonBehavior(PistonBehavior.BLOCK), "bronze", 2));
    public static final Block BISMUTH_BRONZE_ANVIL = registerBlock("bismuth_bronze_anvil",
            new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.TERRACOTTA_GREEN).nonOpaque().requiresTool().strength(5.0f, 1200.0f).sounds(BlockSoundGroup.ANVIL).pistonBehavior(PistonBehavior.BLOCK), "bismuth_bronze", 2));
    public static final Block BLACK_BRONZE_ANVIL = registerBlock("black_bronze_anvil",
            new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.TERRACOTTA_BLUE).nonOpaque().requiresTool().strength(5.0f, 1200.0f).sounds(BlockSoundGroup.ANVIL).pistonBehavior(PistonBehavior.BLOCK), "black_bronze", 2));
    public static final Block WHITE_BRONZE_ANVIL = registerBlock("white_bronze_anvil",
            new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.RAW_IRON_PINK).nonOpaque().requiresTool().strength(5.0f, 1200.0f).sounds(BlockSoundGroup.ANVIL).pistonBehavior(PistonBehavior.BLOCK), "white_bronze", 2));
    public static final Block IRON_ANVIL = registerBlock("iron_anvil",
            new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.IRON_GRAY).nonOpaque().requiresTool().strength(5.0f, 1200.0f).sounds(BlockSoundGroup.ANVIL).pistonBehavior(PistonBehavior.BLOCK), "iron", 3));
    public static final Block STEEL_ANVIL = registerBlock("steel_anvil",
            new AnvilBlock(FabricBlockSettings.create().solid().mapColor(MapColor.DEEPSLATE_GRAY).nonOpaque().requiresTool().strength(5.0f, 1200.0f).sounds(BlockSoundGroup.ANVIL).pistonBehavior(PistonBehavior.BLOCK), "steel", 4));

    public static final Block SPRUCE_BARREL = registerBlockNoItem("spruce_barrel",
            new BarrelBlock(FabricBlockSettings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(Instrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable(), null));
    public static final Block SPRUCE_WATER_BARREL = registerBlockNoItem("spruce_water_barrel",
            new LeveledBarrelBlock(FabricBlockSettings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(Instrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD), ModBlocks.SPRUCE_BARREL, LeveledBarrelBlock.RAIN_PREDICATE, BarrelBehavior.WATER_BARREL_BEHAVIOR));
    public static final Block BIRCH_BARREL = registerBlockNoItem("birch_barrel",
            new BarrelBlock(FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable(), null));
    public static final Block BIRCH_WATER_BARREL = registerBlockNoItem("birch_water_barrel",
            new LeveledBarrelBlock(FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD), ModBlocks.BIRCH_BARREL, LeveledBarrelBlock.RAIN_PREDICATE, BarrelBehavior.WATER_BARREL_BEHAVIOR));

    public static final Block POTION_CAULDRON = registerBlockNoItem("potion_cauldron",
            new PotionCauldronBlock(FabricBlockSettings.copyOf(Blocks.CAULDRON), PotionCauldronBehavior.MAP));

    public static void initializeBarrelProperties() {
        Recrafted.LOGGER.info("Initializing Barrel Properties for " + Recrafted.MOD_ID);
        ((BarrelBlock) SPRUCE_BARREL).setFilledBlock(SPRUCE_WATER_BARREL);
        ((BarrelBlock) BIRCH_BARREL).setFilledBlock(BIRCH_WATER_BARREL);
    }

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Recrafted.MOD_ID, name), block);
    }

    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Recrafted.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Recrafted.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Recrafted.LOGGER.info("Registering Mod Blocks for " + Recrafted.MOD_ID);
    }
}
