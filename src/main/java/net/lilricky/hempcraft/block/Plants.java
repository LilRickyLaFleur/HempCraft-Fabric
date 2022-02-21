package net.lilricky.hempcraft.block;

import java.util.jar.Attributes.Name;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lilricky.hempcraft.HempCraft;
import net.lilricky.hempcraft.block.custom.Plant;
import net.lilricky.hempcraft.item.HC_Strain;
import net.lilricky.hempcraft.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;

// Generate the plants
public class Plants 
{

    // Generate the Plant
    // public static final Block Plant = ModBlocks.registerBlockWithoutBlockItem(Name, new Plant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision(), Name));
    // Generate the Seed
    // public static final Item Seed = ModItems.registerItem(Name, new AliasedBlockItem(Plant, HempCraft.default_item_settings));

    

    public Plants(String name)
    {
        // TODO: Find a way to generate the plant objects.
        //! HC_STRAIN Will call this shit
        // ? Its similar to src\main\java\net\lilricky\hempcraft\item\HC_Strain.java

        

    }

}
