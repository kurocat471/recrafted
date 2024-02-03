package net.kuro.recrafted;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.kuro.recrafted.datagen.*;

public class RecraftedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();


		pack.addProvider(ModBlockLootTableGenerator::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider((FabricDataGenerator.Pack.Factory<ConnectedTexturesModelProvider>) generator -> new ConnectedTexturesModelProvider(Recrafted.MOD_ID, generator));
		pack.addProvider((FabricDataGenerator.Pack.Factory<ConnectedTexturesTextureProvider>) generator -> new ConnectedTexturesTextureProvider(Recrafted.MOD_ID, generator));
	}
}
