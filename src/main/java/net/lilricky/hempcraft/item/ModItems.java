// ModItems.java
//  This class handles all the registering events for the items in the mod.
//  Other files will be used in order to generate the items based on strain data.

package net.lilricky.hempcraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lilricky.hempcraft.HempCraft;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
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
        new HC_Strain("og_kush", StatusEffects.INSTANT_HEALTH, null, null);
        HempCraft.LOGGER.info("Registering Mod Items for " + HempCraft.MOD_ID);
    }
}
