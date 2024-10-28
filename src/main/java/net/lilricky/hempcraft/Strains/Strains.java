package net.lilricky.hempcraft.Strains;

import net.lilricky.hempcraft.HempCraft;
import net.lilricky.hempcraft.item.HC_Strain;
import net.minecraft.entity.effect.StatusEffects;

// All the god damn strains you could ever want
public class Strains 
{
    public Strains()
    {
        // GRADE A
        new HC_Strain("yard_trimmings").A();
        new HC_Strain("chem_fruit").A();
        new HC_Strain("trainwreck").A();

        // GRADE AA
        new HC_Strain("miners_delight").AA(StatusEffects.NIGHT_VISION, StatusEffects.HASTE);
        new HC_Strain("green_golem").AA(StatusEffects.INSTANT_HEALTH, StatusEffects.HEALTH_BOOST);
        new HC_Strain("og_hunter").AA(StatusEffects.INVISIBILITY, StatusEffects.SPEED);
        new HC_Strain("dolphin_daydream").AA(StatusEffects.DOLPHINS_GRACE, StatusEffects.WATER_BREATHING);
        

        // GRADE AAA
        new HC_Strain("sour_budda").AAA(StatusEffects.INSTANT_HEALTH, StatusEffects.REGENERATION, StatusEffects.FIRE_RESISTANCE);
        new HC_Strain("blue_widow").AAA(StatusEffects.INSTANT_HEALTH, StatusEffects.STRENGTH, StatusEffects.NIGHT_VISION);
        new HC_Strain("holy_grain").AAA(StatusEffects.INSTANT_HEALTH, StatusEffects.SPEED, StatusEffects.SLOW_FALLING);
        new HC_Strain("scout_master").AAA(StatusEffects.JUMP_BOOST, StatusEffects.SPEED, StatusEffects.LUCK);

        HempCraft.LOGGER.info("Registering Mod Items for " + HempCraft.MOD_ID);
    }
}
