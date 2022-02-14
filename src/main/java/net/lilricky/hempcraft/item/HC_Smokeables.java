package net.lilricky.hempcraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lilricky.hempcraft.HempCraft;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;

public class HC_Smokeables 
{

    private String Name;
    private FoodComponent fc;

    private StatusEffect Effect1;
    private int effect1_duration = -1;
    
    private StatusEffect Effect2;
    private int effect2_duration = -1;

    private StatusEffect Effect3;
    private int effect3_duration = -1;

    private StatusEffect Effect4;
    private int effect4_duration = -1;


    static private StatusEffectInstance Heal1 = new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1);
    static private StatusEffectInstance Slow = new StatusEffectInstance(StatusEffects.SLOWNESS, 15);


    // Builds All Smokeable Items from Strain List.
    public HC_Smokeables(String name)
    {
        Name = name;

        HempCraft.LOGGER.info("Creating New Smokable Objects: " + Name);
    }

    public void A()
    {
        Effect1 = StatusEffects.INSTANT_HEALTH;
        Effect2 = StatusEffects.SLOWNESS;
        
        HempCraft.LOGGER.info("Creating Strain A");

        BuildAll();
    }

    public void AA(StatusEffect effect1, StatusEffect effect2)
    {
        Effect1 = effect1;
        Effect2 = effect2;

        HempCraft.LOGGER.info("Creating Strain AA");
        BuildAll();
    }

    public void AAA(StatusEffect effect1, StatusEffect effect2, StatusEffect effect3)
    {
        Effect1 = effect1;
        Effect2 = effect2;
        Effect3 = effect3;

        HempCraft.LOGGER.info("Creating Strain AAA");
        BuildAll();
    }

    private void BuildAll()
    {
        Build("joint");
        Build("cone");
        Build("blunt");
    }

    private void Build(String ID)
    {
        HempCraft.LOGGER.info("Building: " + ID);

        // Setting the Duration of all effects for proper smokable object
        if(ID == "joint")
        {
            effect1_duration = 15*20;
            effect2_duration = 15*20;
            effect3_duration = 15*20;
            effect4_duration = 15*20;
        }

        if(ID == "cone")
        {
            effect1_duration = 45*20;
            effect2_duration = 45*20;
            effect3_duration = 45*20;
            effect4_duration = 45*20;
        }

        if(ID == "blunt")
        {
            effect1_duration = 135*20;
            effect2_duration = 135*20;
            effect3_duration = 135*20;
            effect4_duration = 135*20;
        }

        // Set duration of effect for instant health
        if(Effect1 == StatusEffects.INSTANT_HEALTH)
        {
            HempCraft.LOGGER.info("Effect 1 set to INSTANT_HEALTH");

            if(ID == "joint") { effect1_duration = 1; }
            if(ID == "cone") { effect1_duration = 2; }
            if(ID == "blunt") { effect1_duration = 3; }
        }

        if(Effect2 == StatusEffects.INSTANT_HEALTH)
        {
            HempCraft.LOGGER.info("Effect 2 set to INSTANT_HEALTH");

            if(ID == "joint") { effect2_duration = 1; }
            if(ID == "cone") { effect2_duration = 2; }
            if(ID == "blunt") { effect2_duration = 3; }
        }

        if(Effect3 == StatusEffects.INSTANT_HEALTH)
        {
            HempCraft.LOGGER.info("Effect 3 set to INSTANT_HEALTH");

            if(ID == "joint") { effect3_duration = 1; }
            if(ID == "cone") { effect3_duration = 2; }
            if(ID == "blunt") { effect3_duration = 3; }
        }

        if(Effect4 == StatusEffects.INSTANT_HEALTH)
        {
            HempCraft.LOGGER.info("Effect 4 set to INSTANT_HEALTH");

            if(ID == "joint") { effect4_duration = 1; }
            if(ID == "cone") { effect4_duration = 2; }
            if(ID == "blunt") { effect4_duration = 3; }
        }

        // TODO: Optimize the food component builder
        if(Effect4 != null)
        {
            HempCraft.LOGGER.info("Effect 4 Exists");

            fc = new FoodComponent.Builder()
            .hunger(0)
            .statusEffect(new StatusEffectInstance(Effect1, effect1_duration), 1.0f)
            .statusEffect(new StatusEffectInstance(Effect2, effect2_duration), 1.0f)
            .statusEffect(new StatusEffectInstance(Effect3, effect3_duration), 1.0f)
            .statusEffect(new StatusEffectInstance(Effect4, effect4_duration), 1.0f)
            .alwaysEdible()
            .saturationModifier(0.2f)
            .build();
        }
        else if(Effect3 != null)
        {
            HempCraft.LOGGER.info("Effect 3 Exists");

            fc = new FoodComponent.Builder()
            .hunger(0)
            .statusEffect(new StatusEffectInstance(Effect1, effect1_duration), 1.0f)
            .statusEffect(new StatusEffectInstance(Effect2, effect2_duration), 1.0f)
            .statusEffect(new StatusEffectInstance(Effect3, effect3_duration), 1.0f)
            .alwaysEdible()
            .saturationModifier(0.2f)
            .build();
        }
        else if(Effect2 != null)
        {
            HempCraft.LOGGER.info("Effect 2 Exists");
            
            fc = new FoodComponent.Builder()
            .hunger(0)
            .statusEffect(new StatusEffectInstance(Effect1, effect1_duration), 1.0f)
            .statusEffect(new StatusEffectInstance(Effect2, effect2_duration), 1.0f)
            .alwaysEdible()
            .saturationModifier(0.2f)
            .build();
        }
        else if(Effect1 != null)
        {
            HempCraft.LOGGER.info("Effect 1 Exists");

            fc = new FoodComponent.Builder()
            .hunger(0)
            .statusEffect(new StatusEffectInstance(Effect1, effect1_duration), 1.0f)
            .alwaysEdible()
            .saturationModifier(0.2f)
            .build();
        }


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
