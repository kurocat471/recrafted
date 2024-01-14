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

public class Recrafted implements ModInitializer {
	public static final String MOD_ID = "mc-recrafted";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

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


	}

}