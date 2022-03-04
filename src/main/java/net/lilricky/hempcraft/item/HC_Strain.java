// The strain interface
//      This class automates the creation of the strains by calling everything it needs to
// for generation of the items / blocks.
package net.lilricky.hempcraft.item;

import java.util.Arrays;
import java.util.Stack;
import java.util.List;

import javax.annotation.Nullable;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lilricky.hempcraft.HempCraft;
import net.lilricky.hempcraft.block.Plants;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

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

    public StatusEffect[] strainEffect;
    public final Grade grade;

    // Constructor
    HC_Strain(StatusEffect... effects) {
        this.strainEffect = effects;
        // Effects of length 0 will be grade A, <=2 will be AA, >2 will be AAA
        this.grade = (effects.length == 0) ? Grade.A : (effects.length <= 2) ? Grade.AA : Grade.AAA;
        if (effects.length == 0) {
            this.strainEffect = new StatusEffect[] {
                    StatusEffects.INSTANT_HEALTH,
                    StatusEffects.SLOWNESS
            };
        }

        HempCraft.LOGGER.info("New Strain: " + this.toString() + ", " + this.grade);
        // Generates a Bud (crafting item)
        ModItems.registerItem("bud/" + this.toString(), new Item(HempCraft.default_item_settings));
        new Plants(this.toString());
        // Plant = ModBlocks.registerBlockWithoutBlockItem("plant/" + Name, new
        // Plant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision(), Name,
        // ModItems.registerItem("seed/" + Name, new AliasedBlockItem(Plant,
        // HempCraft.default_item_settings))));
    }

    // toLowerCase-ing the enum name, to end up with "yard_trimmings" when queried.
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    // Builds all Smokable Objects, to be called in the mod initialization.
    public static void BuildAll() {
        for (HC_Strain strain : HC_Strain.values()) {
            for (RollType rollType : RollType.values()) {
                Build(strain, rollType);
            }
        }
    }

    // Builds the objects with a stupid amount of logic.
    private static void Build(HC_Strain strain, RollType rollType) {
        // Overriding Effect Duration if an effect is INSTANT_HEALTH
        // Generate Tooltips
        Stack<String> tooltips = new Stack<String>();

        FoodComponent.Builder builder = new FoodComponent.Builder();
        for (StatusEffect effect : strain.strainEffect) {
            tooltips.push(effect.getTranslationKey());
            int duration = (effect == StatusEffects.INSTANT_HEALTH) ? rollType.InstantDuration
                    : rollType.EffectDuration;
            builder.statusEffect(new StatusEffectInstance(effect, duration), 1.0f);
        }
        builder.hunger(0)
                .alwaysEdible()
                .saturationModifier(0.2f);

        FoodComponent fc = builder.build();

        String arr[] = Arrays.copyOf(tooltips.toArray(), tooltips.size(), String[].class);
        HempCraft.LOGGER.info("Tooltips Generated: " + tooltips.toString());

        // Registers Item generated into the registry.
        ModItems.registerItem(rollType + "/" + strain, new Item(new FabricItemSettings().rarity(strain.grade.rarity)
                .food(fc).group(ModItemGroup.HempCraft_Item_Group)) {
            @Override
            public UseAction getUseAction(ItemStack stack) {
                return UseAction.BOW;
            }

            @Override
            public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip,
                    TooltipContext context) {
                if (Screen.hasShiftDown()) {
                    tooltip.add(new TranslatableText("Effects:").formatted(Formatting.ITALIC, Formatting.GOLD));

                    for (int i = 0; i < arr.length; i++) {
                        tooltip.add(new TranslatableText(arr[i]));
                    }

                    tooltip.add(new TranslatableText("Duration: " + (rollType.EffectDuration / 20) + " seconds")
                            .formatted(Formatting.ITALIC, Formatting.GRAY));

                } else {
                    tooltip.add(new TranslatableText("HempCraft").formatted(Formatting.ITALIC, Formatting.GOLD));
                }
            }

        });

        HempCraft.LOGGER.info("Generated: " + rollType + ": " + strain);
    }

}
