package net.kuro.recrafted;

import net.fabricmc.api.ModInitializer;

import net.kuro.recrafted.structure.block.ModBlocks;
import net.kuro.recrafted.structure.block.custom.barrel.BarrelBehavior;
import net.kuro.recrafted.structure.block.custom.barrel.ModBarrelBehavior;
import net.kuro.recrafted.structure.block.custom.cauldron.ModCauldronBehavior;
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
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Recrafted implements ModInitializer {
	public static final String MOD_ID = "mc-recrafted";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Identifier PARTICLES_CHANNEL = new Identifier(Recrafted.MOD_ID, "particles_channel");

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
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
		ModParticleTypes.registerParticleTypes();
	}

}