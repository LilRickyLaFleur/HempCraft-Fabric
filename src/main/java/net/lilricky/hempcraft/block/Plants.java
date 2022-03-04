package net.lilricky.hempcraft.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lilricky.hempcraft.HempCraft;
import net.lilricky.hempcraft.block.custom.Plant;
import net.lilricky.hempcraft.item.ModItems;
import net.lilricky.hempcraft.util.ModRenderHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;

// Generate the plants
public class Plants {

        public static Block Plant;
        public static Item Seed;

        // Create Tobacco Seeds and Plants
        public static Block Tobacco_Plant = ModBlocks.registerBlockWithoutBlockItem("tobacco_plant",
                        new Plant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision(), "tobacco_plant"));
        public static Item Tobacco_Seed = ModItems.registerItem("tobacco_seed",
                        new AliasedBlockItem(Tobacco_Plant, HempCraft.default_item_settings));

        public Plants(String name) {
                HempCraft.LOGGER.info("Plants.java: Creating plant and seed: " + name);

                // Creates and registers the strains Plant block.
                Plant = ModBlocks.registerBlockWithoutBlockItem("plant/" + name,
                                new Plant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision(), name));

                // Creates and registers the seed item for the plant for the strain. Links them
                // together.
                Seed = ModItems.registerItem("seed/" + name,
                                new AliasedBlockItem(Plant, HempCraft.default_item_settings));

                // Sends plants to the render helper.
                ModRenderHelper.Plants_To_Render.push(Plant);
                ModRenderHelper.Plants_To_Render.push(Tobacco_Plant);

        }

}
