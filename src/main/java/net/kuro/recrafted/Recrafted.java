package net.kuro.recrafted;

import net.fabricmc.api.ModInitializer;

import net.kuro.recrafted.block.ModBlocks;
import net.kuro.recrafted.block.barrel.BarrelBehavior;
import net.kuro.recrafted.block.barrel.ModBarrelBehavior;
import net.kuro.recrafted.block.cauldron.ModCauldronBehavior;
import net.kuro.recrafted.block.entity.ModBlockEntities;
import net.kuro.recrafted.block.potioncauldron.PotionCauldronBehavior;
import net.kuro.recrafted.item.ModItemGroup;
import net.kuro.recrafted.item.ModItems;
import net.kuro.recrafted.networking.ServerNetworking;
import net.kuro.recrafted.recipe.ModRecipes;
import net.kuro.recrafted.screen.ModScreenHandlers;
import net.kuro.recrafted.sound.ModSoundEvents;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Recrafted implements ModInitializer {
	public static final String MOD_ID = "mc-recrafted";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Identifier PARTICLES_CHANNEL = new Identifier(Recrafted.MOD_ID, "particles_channel");

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
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
	}
}