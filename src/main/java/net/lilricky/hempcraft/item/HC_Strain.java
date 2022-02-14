// The strain interface
//      This class automates the creation of the strains by calling everything it needs to
// for generation of the items / blocks.
package net.lilricky.hempcraft.item;

import net.lilricky.hempcraft.HempCraft;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;

public class HC_Strain
{  
    String Name;

    // Constructor
    public HC_Strain(String name)
    {
        this.Name = name;
        bud(name);
        seed(name);
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
    private void bud(String name)
    {
        ModItems.registerItem("bud/" + name, new Item(HempCraft.default_item_settings));
    }

    // Generates a Seed (farming item)
    private void seed(String name)
    {
        ModItems.registerItem("seed/" + name, new Item(HempCraft.default_item_settings));
    }
}
