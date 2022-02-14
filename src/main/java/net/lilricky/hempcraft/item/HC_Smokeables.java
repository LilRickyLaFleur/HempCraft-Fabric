package net.lilricky.hempcraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lilricky.hempcraft.HempCraft;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;

public class HC_Smokeables 
{

    private String Name;
    private StatusEffect Effect1;
    private StatusEffect Effect2;
    private StatusEffect Effect3;
    private StatusEffect Effect4;


    // Builds All Smokeable Items from Strain List.
    public HC_Smokeables(String name, StatusEffect effect1, StatusEffect effect2, StatusEffect effect3, StatusEffect effect4)
    {

        Name = name;
        Effect1 = effect1;
        Effect2 = effect2;
        Effect3 = effect3;
        Effect4 = effect4;

        BUILD("joint");
        BUILD("cone");
        BUILD("blunt");


    }

    // Constructs and registers Joint items
    private void BUILD(String ID)
    {
        FoodComponent fc = null;
        int duration = 0;

        if(ID == "joint")
        {
            duration = 1;
        }
        else if(ID == "cone")
        {
            duration = 2;
        }
        else if(ID == "blunt")
        {
            duration = 3;
            
        }

        if(Effect1 != null)
        {
            fc = new FoodComponent.Builder()
            .hunger(0)
            .statusEffect(new StatusEffectInstance(Effect1, duration), 1.0f)
            .alwaysEdible()
            .saturationModifier(0.2f)
            .build();
        }
        else if(Effect2 != null)
        {
            fc = new FoodComponent.Builder()
            .hunger(0)
            .statusEffect(new StatusEffectInstance(Effect1, duration), 1.0f)
            .statusEffect(new StatusEffectInstance(Effect2, duration), 1.0f)
            .alwaysEdible()
            .saturationModifier(0.2f)
            .build();
        }
        else if(Effect3 != null)
        {
            fc = new FoodComponent.Builder()
            .hunger(0)
            .statusEffect(new StatusEffectInstance(Effect1, duration), 1.0f)
            .statusEffect(new StatusEffectInstance(Effect2, duration), 1.0f)
            .statusEffect(new StatusEffectInstance(Effect3, duration), 1.0f)
            .alwaysEdible()
            .saturationModifier(0.2f)
            .build();
        }
        else if(Effect4 != null)
        {
            fc = new FoodComponent.Builder()
            .hunger(0)
            .statusEffect(new StatusEffectInstance(Effect1, duration), 1.0f)
            .statusEffect(new StatusEffectInstance(Effect2, duration), 1.0f)
            .statusEffect(new StatusEffectInstance(Effect3, duration), 1.0f)
            .statusEffect(new StatusEffectInstance(Effect4, duration), 1.0f)
            .alwaysEdible()
            .saturationModifier(0.2f)
            .build();
        }


        // Register Joints, Cones, and Blunt objects.
        ModItems.registerItem(ID + "/" + Name, new Item(new FabricItemSettings().food(fc).group(HempCraft.HC_ITEM_GROUP))
        {
            @Override
            public UseAction getUseAction(ItemStack stack)
            {
                return UseAction.BOW;
            }
        });

        HempCraft.LOGGER.info("Generated: " + ID + ": " + Name);
    }
}
