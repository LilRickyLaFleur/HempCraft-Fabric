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

public enum HC_Strain {
    YARD_TRIMMINGS(),
    CHEM_FRUIT(),
    TRAINWRECK(),
    // GRADE AA
    MINERS_DELIGHT(StatusEffects.NIGHT_VISION, StatusEffects.HASTE),
    GREEN_GOLEM(StatusEffects.INSTANT_HEALTH, StatusEffects.HEALTH_BOOST),
    OG_HUNTER(StatusEffects.INVISIBILITY, StatusEffects.SPEED),
    DOLPHIN_DAYDREAM(StatusEffects.DOLPHINS_GRACE, StatusEffects.WATER_BREATHING),
    // GRADE AAA
    SOUR_BUDDA(StatusEffects.INSTANT_HEALTH, StatusEffects.REGENERATION, StatusEffects.FIRE_RESISTANCE),
    BLUE_WIDOW(StatusEffects.INSTANT_HEALTH, StatusEffects.STRENGTH, StatusEffects.NIGHT_VISION),
    HOLY_GRAIN(StatusEffects.INSTANT_HEALTH, StatusEffects.SPEED, StatusEffects.SLOW_FALLING),
    SCOUT_MASTER(StatusEffects.JUMP_BOOST, StatusEffects.SPEED, StatusEffects.LUCK);


    public final StatusEffects[] strainEffects;
    public final Grade grade;
    
    //Instantiated after init
    private FoodComponent fc;

    // Constructor
    HC_Strain(StatusEffects... effects)
    {
        this.strainEffects = effects;
        // Effects of length 0 will be grade A, <=2 will be AA, >2 will be AAA
        this.grade = (effects.length == 0) ? Grade.A : (effects.length <= 2) ? Grade.AA : Grade.AAA;
        if(effects.length == 0) {
            this.strainEffects = new StatusEffects[2]{
                StatusEffects.INSTANT_HEALTH,
                StatusEffects.SLOWNESS 
            }
        }

        HempCraft.LOGGER.info("New Strain: " + this.toString() + ", " + this.grade);
          // Generates a Bud (crafting item)
        ModItems.registerItem("bud/" + this.toString(), new Item(HempCraft.default_item_settings));
        new Plants(this.toString());
        // Plant = ModBlocks.registerBlockWithoutBlockItem("plant/" + Name, new Plant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision(), Name, ModItems.registerItem("seed/" + Name, new AliasedBlockItem(Plant, HempCraft.default_item_settings))));
    }

    // toLowerCase-ing the enum name, to end up with "yard_trimmings" when queried.
    @Override
    public String toString() {
        return super.toString().toLowerCase()
    }

    // Builds all Smokable Objects, to be called in the mod initialization.
    public static void BuildAll() {
        for(HC_Strain strain : HC_Strain.values()) {
            for(RollType rollType : RollType.values()) {
                Build(strain, rollType)
            }
        }
    }

 // Builds the objects with a stupid amount of logic.
 private static void Build(HC_Strain strain, RollType rollType) {
     // Overriding Effect Duration if an effect is INSTANT_HEALTH
     // Generate Tooltips
    Stack<String> tooltips = new Stack<String>();

    FoodComponent.Builder builder = new FoodComponent.Builder()
    for(StatusEffect effect : strain.strainEffects) {
        tooltips.push(effect.getTranslationKey())
        int duration = (effect == StatusEffects.INSTANT_HEALTH) ? rollType.InstantDuration : rollType.EffectDuration;
        builder.statusEffect(new StatusEffectInstance(effect, duration), 1.0f)
    }
    builder.hunger(0)
    .alwaysEdible()
    .saturationModifier(0.2f)
    
    FoodComponent fc = builder.build();
    }
     
    String arr[] = Arrays.copyOf(tooltips.toArray(), tooltips.size(), String[].class);
    HempCraft.LOGGER.info("Tooltips Generated: " + tooltips.toString());      

    int largest_duration = HempCraft.findLargestInt(strain.strainEffects);

    // Registers Item generated into the registry.
    ModItems.registerItem(rollType + "/" + strain, new Item(new FabricItemSettings().rarity(strain.grade.rarity).food(fc).group(ModItemGroup.HempCraft_Item_Group))
    {
         @Override
         public UseAction getUseAction(ItemStack stack)
         {
             return UseAction.BOW;
         }

         @Override
         public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
         {
             if(Screen.hasShiftDown())
             {
                 tooltip.add(new TranslatableText("Effects:").formatted(Formatting.ITALIC, Formatting.GOLD));
                 
                 for(int i = 0; i < arr.length; i++)
                 {
                     tooltip.add(new TranslatableText(arr[i]));
                 }

                 tooltip.add(new TranslatableText("Duration: " + (largest_duration / 20) + " seconds").formatted(Formatting.ITALIC, Formatting.GRAY));

             }
             else
             {
                 tooltip.add(new TranslatableText("HempCraft").formatted(Formatting.ITALIC, Formatting.GOLD));
             }
         }

     });

     HempCraft.LOGGER.info("Generated: " + ID + ": " + Name);
 }

}
