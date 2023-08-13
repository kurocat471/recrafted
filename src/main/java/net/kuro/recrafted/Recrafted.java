package net.kuro.recrafted;

import net.fabricmc.api.ModInitializer;

import net.kuro.recrafted.block.ModBlocks;
import net.kuro.recrafted.item.ModItemGroup;
import net.kuro.recrafted.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Recrafted implements ModInitializer {
	public static final String MOD_ID = "mc-recrafted";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}