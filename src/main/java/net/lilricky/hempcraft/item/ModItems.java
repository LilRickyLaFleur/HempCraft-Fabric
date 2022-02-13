package net.lilricky.hempcraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lilricky.hempcraft.HempCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems 
{

    public static final Item MYTHRIL_INGOT = registerItem(
        "mythril_ingot",
        new Item(new FabricItemSettings().group(ItemGroup.MISC));
    );

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(HempCraft.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        HempCraft.LOGGER.info("Registering Mod Items for " + HempCraft.MOD_ID);
    }
}
