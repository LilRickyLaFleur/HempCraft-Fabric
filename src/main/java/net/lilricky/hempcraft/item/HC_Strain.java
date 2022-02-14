// HC_Strains.java
//  This class will be used to define all strains, and then build them according to what they do.
package net.lilricky.hempcraft.item;

import net.minecraft.entity.effect.StatusEffect;

public class HC_Strain
{  
    String Name;
    // Automate creation of the strain
    public HC_Strain(String name)
    {
        this.Name = name;
        // new HC_Smokeables(name, effect1, effect2, effect3, effect4);
    }

    public void A()
    {
        new HC_Smokeables(Name).A();
    }
    
    public void AA(StatusEffect effect1, StatusEffect effect2)
    {
        new HC_Smokeables(Name).AA(effect1, effect2);
    }

    public void AAA(StatusEffect effect1, StatusEffect effect2, StatusEffect effect3)
    {
        new HC_Smokeables(Name).AAA(effect1, effect2, effect3);
    }
}
