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
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {

    public static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(HempCraft.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registries.ITEM, new Identifier(HempCraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(HempCraft.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        // TODO: PLANTS | Create plant groupings
        // ! Use the code from ModeItems.java. DO IT.

        HempCraft.LOGGER.info("Registering ModBlocks for " + HempCraft.MOD_ID);
    }
}
