// The strain interface
//      This class automates the creation of the strains by calling everything it needs to
// for generation of the items / blocks.
package net.lilricky.hempcraft.item;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lilricky.hempcraft.HempCraft;
import net.lilricky.hempcraft.block.ModBlocks;
import net.lilricky.hempcraft.block.Plants;
import net.lilricky.hempcraft.block.custom.Plant;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;

public class HC_Strain
{  
    public static String Name;

    public static Block Plant;

    // Constructor
    public HC_Strain(String name)
    {
        HempCraft.LOGGER.info("New Strain: " + name);
        this.Name = name;
        bud();
        new Plants(name);
        // Plant = ModBlocks.registerBlockWithoutBlockItem("plant/" + Name, new Plant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision(), Name, ModItems.registerItem("seed/" + Name, new AliasedBlockItem(Plant, HempCraft.default_item_settings))));

        
        // TODO: Implement the blocks for plants somehere here.
        
    }

    // Generates a Grade A Strain
    public void A()
    {
        new HC_Smokeables(Name).A();
    }
    
    // Generates a Grade AA Strain
    public void AA(StatusEffect effect1, StatusEffect effect2)
    {
        new HC_Smokeables(Name).AA(effect1, effect2);
    }

    // Generates a Grade AAA Strain
    public void AAA(StatusEffect effect1, StatusEffect effect2, StatusEffect effect3)
    {
        new HC_Smokeables(Name).AAA(effect1, effect2, effect3);
    }

    // Generates a Bud (crafting item)
    private void bud()
    {
        ModItems.registerItem("bud/" + Name, new Item(HempCraft.default_item_settings));
    }

}
