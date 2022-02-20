// ModItems.java
//  This class handles all the registering events for the items in the mod.
//  Other files will be used in order to generate the items based on strain data.

package net.lilricky.hempcraft.item;

import net.lilricky.hempcraft.HempCraft;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems 
{

    // Status Effects
    static StatusEffectInstance Heal1 = new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1);
    static StatusEffectInstance Heal2 = new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 2);
    static StatusEffectInstance Heal3 = new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 3);


    public static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(HempCraft.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        // Empty Shells
        registerItem("joint_paper", new Item(HempCraft.default_item_settings));
        registerItem("empty_cone", new Item(HempCraft.default_item_settings));
        registerItem("empty_blunt", new Item(HempCraft.default_item_settings));

        // GRADE A
        new HC_Strain("yard_trimmings").A();
        new HC_Strain("chem_fruit").A();
        new HC_Strain("trainwreck").A();

        // GRADE AA
        // new HC_Strain("purple_kush").AA(StatusEffects.INSTANT_HEALTH, StatusEffects.REGENERATION);
        // new HC_Strain("skywalker_og").AA(StatusEffects.INSTANT_HEALTH, StatusEffects.SLOW_FALLING);
        // new HC_Strain("platinum_cookies").AA(StatusEffects.INSTANT_HEALTH, StatusEffects.JUMP_BOOST);
        // new HC_Strain("laughing_buddha").AA(StatusEffects.SPEED, StatusEffects.JUMP_BOOST);
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
