// HC_Strains.java
//  This class will be used to define all strains, and then build them according to what they do.
package net.lilricky.hempcraft.item;

import net.minecraft.entity.effect.StatusEffect;

public class HC_Strain
{  
    // Automate creation of the strain
    public HC_Strain(String name, StatusEffect effect1, StatusEffect effect2, StatusEffect effect3)
    {
        new HC_Smokeables(name, effect1, effect2, effect3);
    }

}
