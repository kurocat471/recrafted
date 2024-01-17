package net.kuro.recrafted;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kuro.recrafted.structure.block.ModBlocks;
import net.kuro.recrafted.structure.block.custom.barrel.BarrelBehavior;
import net.kuro.recrafted.structure.block.custom.barrel.ModBarrelBehavior;
import net.kuro.recrafted.structure.block.custom.cauldron.ModCauldronBehavior;
import net.kuro.recrafted.structure.block.custom.oxidizable.OxidizableLightningRodBlock;
import net.kuro.recrafted.structure.block.entity.ModBlockEntities;
import net.kuro.recrafted.structure.block.custom.potioncauldron.PotionCauldronBehavior;
import net.kuro.recrafted.structure.item.ModItemGroups;
import net.kuro.recrafted.structure.item.ModItems;
import net.kuro.recrafted.networking.ServerNetworking;
import net.kuro.recrafted.structure.particle.ModParticleTypes;
import net.kuro.recrafted.structure.recipe.ModRecipes;
import net.kuro.recrafted.structure.screen.ModScreenHandlers;
import net.kuro.recrafted.sound.ModSoundEvents;
import net.kuro.recrafted.util.ModRegistries;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

import static net.kuro.recrafted.structure.block.ModBlocks.*;

public class Recrafted implements ModInitializer {
	public static final String MOD_ID = "mc-recrafted";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final LightningRodBlock COPPER_LIGHTNING_ROD;
	public static final LightningRodBlock EXPOSED_COPPER_LIGHTNING_ROD;
	public static final LightningRodBlock WEATHERED_COPPER_LIGHTNING_ROD;
	public static final LightningRodBlock OXIDIZED_COPPER_LIGHTNING_ROD;
	public static final LightningRodBlock WAXED_COPPER_LIGHTNING_ROD;
	public static final LightningRodBlock WAXED_EXPOSED_COPPER_LIGHTNING_ROD;
	public static final LightningRodBlock WAXED_WEATHERED_COPPER_LIGHTNING_ROD;
	public static final LightningRodBlock WAXED_OXIDIZED_COPPER_LIGHTNING_ROD;
	public static final Set<BlockState> LIGHTNING_RODS;

	public static final Identifier PARTICLES_CHANNEL = new Identifier(Recrafted.MOD_ID, "particles_channel");

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModCauldronBehavior.registerBehavior();
		ModBarrelBehavior.registerBehavior();
		BarrelBehavior.registerBehavior();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandler();
		ModRecipes.registerRecipes();
		ModBlocks.initializeBarrelProperties();
		ServerNetworking.registerEvents();
		PotionCauldronBehavior.bootstrap();
		ModSoundEvents.registerModSoundEvents();
		ModRegistries.registerModRegistries();
		registerLightningRodBlocks();
		ModParticleTypes.registerParticleTypes();
	}

	private static void registerLightningRodBlocks() {
		registerBlock("copper_lightning_rod", COPPER_LIGHTNING_ROD);
		registerBlock("exposed_copper_lightning_rod", EXPOSED_COPPER_LIGHTNING_ROD);
		registerBlock("weathered_copper_lightning_rod", WEATHERED_COPPER_LIGHTNING_ROD);
		registerBlock("oxidized_copper_lightning_rod", OXIDIZED_COPPER_LIGHTNING_ROD);
		registerBlock("waxed_copper_lightning_rod", WAXED_COPPER_LIGHTNING_ROD);
		registerBlock("waxed_exposed_copper_lightning_rod", WAXED_EXPOSED_COPPER_LIGHTNING_ROD);
		registerBlock("waxed_weathered_copper_lightning_rod", WAXED_WEATHERED_COPPER_LIGHTNING_ROD);
		registerBlock("waxed_oxidized_copper_lightning_rod", WAXED_OXIDIZED_COPPER_LIGHTNING_ROD);
	}

	static {

		COPPER_LIGHTNING_ROD = new OxidizableLightningRodBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());
		EXPOSED_COPPER_LIGHTNING_ROD = new OxidizableLightningRodBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());
		WEATHERED_COPPER_LIGHTNING_ROD = new OxidizableLightningRodBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());
		OXIDIZED_COPPER_LIGHTNING_ROD = new OxidizableLightningRodBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());

		WAXED_COPPER_LIGHTNING_ROD = new LightningRodBlock(FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());
		WAXED_EXPOSED_COPPER_LIGHTNING_ROD = new LightningRodBlock(FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());
		WAXED_WEATHERED_COPPER_LIGHTNING_ROD = new LightningRodBlock(FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());
		WAXED_OXIDIZED_COPPER_LIGHTNING_ROD = new LightningRodBlock(FabricBlockSettings.create().solid().mapColor(MapColor.ORANGE).instrument(Instrument.XYLOPHONE).requiresTool().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque());

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

	}

}