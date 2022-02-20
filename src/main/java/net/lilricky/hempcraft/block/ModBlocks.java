package net.lilricky.hempcraft.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lilricky.hempcraft.HempCraft;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks 
{

    public static final Block TEST_PLANT = registerBlock("plant", new Block(FabricBlockSettings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)), HempCraft.HC_ITEM_GROUP);

    private static Block registerBlock(String name, Block block, ItemGroup group)
    {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(HempCraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group)
    {
        return Registry.register(Registry.ITEM, new Identifier(HempCraft.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks()
    {
        // registerBlock("plant", CUSTOM_CROP_BLOCK, HempCraft.HC_ITEM_GROUP);
        
        // HempCraft.LOGGER.info("GENERATED CUSTOM CROP BLOCk");

        
        HempCraft.LOGGER.info("Registering ModBlocks for " + HempCraft.MOD_ID);
    }
}
