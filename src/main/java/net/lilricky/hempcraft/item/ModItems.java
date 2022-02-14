// ModItems.java
//  This class handles all the registering events for the items in the mod.
//  Other files will be used in order to generate the items based on strain data.

package net.lilricky.hempcraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lilricky.hempcraft.HempCraft;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems 
{

    // Status Effects
    static StatusEffectInstance Instant_Health = new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1);

    public static final FoodComponent test = new FoodComponent.Builder()
        .hunger(0)
        .statusEffect(Instant_Health, 1.0f)
        .alwaysEdible()
        .saturationModifier(0.2f)
        .build();
    
    // public static final Item og_kush_joint_test = registerItem("joints/og_kush", new Item(new FabricItemSettings().food(test).group(HempCraft.HC_ITEM_GROUP)));

    public static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(HempCraft.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        FabricItemSettings default_item_settings = new FabricItemSettings().group(HempCraft.HC_ITEM_GROUP);

        // Empty Shells
        registerItem("joint_paper", new Item(default_item_settings));
        registerItem("empty_cone", new Item(default_item_settings));
        registerItem("empty_blunt", new Item(default_item_settings));

        // GRADE A
        new HC_Strain("og_kush", StatusEffects.INSTANT_HEALTH, StatusEffects.SLOWNESS, null, null);
        new HC_Strain("chem_fruit", StatusEffects.INSTANT_HEALTH, StatusEffects.SLOWNESS, null, null);
        new HC_Strain("trainwreck", StatusEffects.INSTANT_HEALTH, StatusEffects.SLOWNESS, null, null);

        // GRADE AA
        new HC_Strain("purple_kush", StatusEffects.INSTANT_HEALTH, StatusEffects.REGENERATION, null, null);
        new HC_Strain("skywalker_og", StatusEffects.INSTANT_HEALTH, StatusEffects.SLOW_FALLING, null, null);
        new HC_Strain("platinum_cookies", StatusEffects.INSTANT_HEALTH, StatusEffects.JUMP_BOOST, null, null);
        new HC_Strain("laughing_buddha", StatusEffects.SPEED, StatusEffects.JUMP_BOOST, null, null);

        // GRADE AA
        new HC_Strain("sour_budda", StatusEffects.INSTANT_HEALTH, StatusEffects.REGENERATION, StatusEffects.FIRE_RESISTANCE, null);
        new HC_Strain("blue_widow", StatusEffects.INSTANT_HEALTH, StatusEffects.STRENGTH, StatusEffects.NIGHT_VISION, null);
        new HC_Strain("holy_grain", StatusEffects.INSTANT_HEALTH, StatusEffects.SPEED, StatusEffects.SLOW_FALLING, null);
        new HC_Strain("scout_master", StatusEffects.JUMP_BOOST, StatusEffects.SPEED, StatusEffects.LUCK, null);

        HempCraft.LOGGER.info("Registering Mod Items for " + HempCraft.MOD_ID);
    }
}
