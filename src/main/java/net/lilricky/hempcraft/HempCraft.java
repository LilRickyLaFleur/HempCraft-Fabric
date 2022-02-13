package net.lilricky.hempcraft;

import net.fabricmc.api.ModInitializer;
import net.lilricky.hempcraft.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HempCraft implements ModInitializer {

	// MOD ID for the mod
	public static final String MOD_ID = "hempcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerModItems();

		LOGGER.info("HempCraft Loaded!");
	}
}
