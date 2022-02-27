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
public class Plants 
{

    public static Block Plant;
    public static Item Seed;
    
    public Plants(String name)
    {
        // TODO: Find a way to generate the plant objects.
        //! HC_STRAIN Will call this shit
        // ? Its similar to src\main\java\net\lilricky\hempcraft\item\HC_Strain.java

        HempCraft.LOGGER.info("Plants.java: Creating plant and seed: " + name);

        Plant = ModBlocks.registerBlockWithoutBlockItem("plant/" + name, new Plant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision(), name));
        Seed = ModItems.registerItem("seed/" + name, new AliasedBlockItem(Plant, HempCraft.default_item_settings));

        HempCraft.LOGGER.info("Registed Plant: " + Plant.getTranslationKey());

        ModRenderHelper.Plants_To_Render.push(Plant);

        // new ModRenderHelper(Plant);
    }

}
