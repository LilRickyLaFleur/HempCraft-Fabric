package net.lilricky.hempcraft.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.lilricky.hempcraft.HempCraft;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup HempCraft_Item_Group = FabricItemGroupBuilder.build(
            new Identifier(HempCraft.MOD_ID, "hempcraft"),
            () -> new ItemStack(ModItems.Hemp_Leaf));
}
