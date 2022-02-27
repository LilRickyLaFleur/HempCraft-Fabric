package net.lilricky.hempcraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lilricky.hempcraft.Strains.Strains;
import net.lilricky.hempcraft.block.ModBlocks;
import net.lilricky.hempcraft.item.ModItemGroup;
import net.lilricky.hempcraft.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HempCraft implements ModInitializer {

	// MOD ID for the mod
	public static final String MOD_ID = "hempcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static FabricItemSettings default_item_settings = new FabricItemSettings().group(ModItemGroup.HempCraft_Item_Group);

	// Start Point
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		HC_Strain.BuildAll()
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("HempCraft Loaded!");
	}

	// General Tools

	// Finds the largest integer in a array
	public static int findLargestInt(int[] Array)
	{
		int maxNum = Array[0];

		for (int j : Array)
		{
			if(j > maxNum)
			{
				maxNum = j;
			}
		}

		return maxNum;
		
	}


}
