package net.lilricky.hempcraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lilricky.hempcraft.block.ModBlocks;
import net.lilricky.hempcraft.item.ModItems;
import net.minecraft.client.render.RenderLayer;
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
	public static ItemGroup HC_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier("hempcraft", "general"), () -> new ItemStack(Items.GOLD_NUGGET));
	public static FabricItemSettings default_item_settings = new FabricItemSettings().group(HempCraft.HC_ITEM_GROUP);

	// Start Point
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("HempCraft Loaded!");
	}


}
