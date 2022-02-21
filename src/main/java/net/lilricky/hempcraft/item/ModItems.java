// ModItems.java
//  This class handles all the registering events for the items in the mod.
//  Other files will be used in order to generate the items based on strain data.

package net.lilricky.hempcraft.item;

import net.lilricky.hempcraft.HempCraft;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems 
{

    public static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(HempCraft.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        // Empty Shells
        ModItems.registerItem("joint_paper", new Item(HempCraft.default_item_settings));
        ModItems.registerItem("empty_cone", new Item(HempCraft.default_item_settings));
        ModItems.registerItem("empty_blunt", new Item(HempCraft.default_item_settings));
    }
}
