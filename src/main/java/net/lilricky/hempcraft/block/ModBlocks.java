package net.lilricky.hempcraft.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lilricky.hempcraft.HempCraft;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks 
{

    public static Block registerBlock(String name, Block block, ItemGroup group)
    {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(HempCraft.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block, ItemGroup group)
    {
        return Registry.register(Registry.ITEM, new Identifier(HempCraft.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static Block registerBlockWithoutBlockItem(String name, Block block)
    {
        return Registry.register(Registry.BLOCK, new Identifier(HempCraft.MOD_ID, name), block);
    }

    public static void registerModBlocks()
    {
        // TODO: PLANTS | Create plant groupings
        //! Use the code from ModeItems.java. DO IT.


        
        HempCraft.LOGGER.info("Registering ModBlocks for " + HempCraft.MOD_ID);
    }
}
