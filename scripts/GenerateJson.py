# This script will use a list of strains in order to generate the model files for the strains.
# All files generated will be put into the "out" directory in the main application.

# Why? Generating the needed data outside of minecraft means less delay when loading the mod.
# I could do it all in the mod itself, but why do it that way, when python is better ;)

import json
import os


#! LIST OF STRAINS
# Master list of strains, change this to change names/values of generated files
strains = [
    "yard_trimmings",
    "chem_fruit",
    "trainwreck",
    "miners_delight",
    "green_golem",
    "og_hunter",
    "dolphin_daydream",
    "sour_budda",
    "blue_widow",
    "holy_grain",
    "scout_master",
    "rickys_special"
]
 

# Change out_dir to where you want the files to go. Include the last slash.
# out_dir = "out/"
out_dir = "src/main/resources/"
dir_item_models = out_dir + "assets/hempcraft/models/item/"
dir_blockstates = out_dir + "assets/hempcraft/blockstates/"
dir_loottables = out_dir + "data/hempcraft/loot_tables/"
dir_recipe = out_dir + "data/hempcraft/recipes/"
dir_advancements = out_dir + "/data/hempcraft/advancements/"


# Creates a Directory if non exists
def createDir(path):
    if not os.path.exists(path):
        os.makedirs(path)
        print("Created Directory: " + path)

# Writes JSON to a file of specific directory.
def writeJSON(dir, type, name, data):
    createDir(dir + type)
    with open(dir + type + "/" + name + ".json", 'w') as f:
        json.dump(data, f)
        print("Generated: " + dir + type + ":" + name)
    f.close

# Generates the loot table based off of JSON
def generateLootTable(name):
    return {
  "type": "minecraft:block",
  "pools": [
    {
      "rolls": 1.0,
      "bonus_rolls": 0.0,
      "entries": [
        {
          "type": "minecraft:alternatives",
          "children": [
            {
              "type": "minecraft:item",
              "conditions": [
                {
                  "condition": "minecraft:block_state_property",
                  "block": "hempcraft:plant/" + name,
                  "properties": {
                    "age": "7"
                  }
                }
              ],
              "name": "hempcraft:bud/" + name
            },
            {
              "type": "minecraft:item",
              "name": "hempcraft:seed/" + name
            },
            {
              "type": "minecraft:item",
              "name": "hempcraft:hemp_leaf"
            }
          ]
        }
      ]
    },
    {
      "rolls": 1.0,
      "bonus_rolls": 0.0,
      "entries": [
        {
          "type": "minecraft:item",
          "functions": [
            {
              "function": "minecraft:apply_bonus",
              "enchantment": "minecraft:fortune",
              "formula": "minecraft:binomial_with_bonus_count",
              "parameters": {
                "extra": 3,
                "probability": 0.5714286
              }
            }
          ],
          "name": "hempcraft:seed/" + name
        },
        {
          "type": "minecraft:item",
          "functions": [
            {
              "function": "minecraft:apply_bonus",
              "enchantment": "minecraft:fortune",
              "formula": "minecraft:binomial_with_bonus_count",
              "parameters": {
                "extra": 3,
                "probability": 0.5714286
              }
            }
          ],
          "name": "hempcraft:hemp_leaf"
        }
      ],
      "conditions": [
        {
          "condition": "minecraft:block_state_property",
          "block": "hempcraft:plant/" + name,
          "properties": {
            "age": "7"
          }
        }
      ]
    }
  ],
  "functions": [
    {
      "function": "minecraft:explosion_decay"
    }
  ]
}

def generateRecipe(name, type):

    wrapper = type
    if type == "joint":
        wrapper = "joint_paper"
    elif type == "cone":
        wrapper = "empty_cone"
    elif type == "blunt":
        wrapper = "empty_blunt"

    return {
    "type": "minecraft:crafting_shaped",
    "pattern": 
    [
        "W",
        "P"
    ],
    "key":
    {
        "P": { "item": "hempcraft:" + wrapper },
        "W": { "item": "hempcraft:bud/" + name }
    },
    "result":
    {
        "item": "hempcraft:" + type + "/" + name,
        "count": 1
    }
}

def generateAdvancements(name, type):
  return {
  "criteria": {
    "requirement": {
      "trigger": "minecraft:inventory_changed",
      "conditions": {
        "items": [
          {
            "items": [
              "hempcraft:bud/" + name
            ]
          }
        ]
      }
    }
  },
  "rewards": {
    "recipes": [
      "hempcraft:" + type + "/" + name
    ]
  }
}


# Model Objects for items
item_seeds = { "parent" : "hempcraft:item/seed" }
item_buds = { "parent": "hempcraft:item/bud" }
item_joints = { "parent": "hempcraft:item/joint" }
item_cones = { "parent": "hempcraft:item/cone" }
item_blunts = { "parent": "hempcraft:item/blunt" }

# BlockStates for Plant (JSON)
blockstate_plant = {
"variants": {
        "age=0": {
            "model": "hempcraft:block/strain/plant_0"
        },
        "age=1": {
            "model": "hempcraft:block/strain/plant_1"
        },
        "age=2": {
            "model": "hempcraft:block/strain/plant_2"
        },
        "age=3": {
            "model": "hempcraft:block/strain/plant_3"
        },
        "age=4": {
            "model": "hempcraft:block/strain/plant_4"
        },
        "age=5": {
            "model": "hempcraft:block/strain/plant_5"
        },
        "age=6": {
            "model": "hempcraft:block/strain/plant_6"
        },
        "age=7": {
            "model": "hempcraft:block/strain/plant_7"
        }
    }
}


print("Writing Files")


# The actual generation
# Goes through each strain, and uses the functions to write JSON files to their appropriate directories.
for x in strains:
    writeJSON(dir_item_models, "seed", x, item_seeds)
    writeJSON(dir_item_models, "bud", x, item_buds)
    writeJSON(dir_item_models, "joint", x, item_joints)
    writeJSON(dir_item_models, "cone", x, item_cones)
    writeJSON(dir_item_models, "blunt", x, item_blunts)
    writeJSON(dir_blockstates, "plant", x, blockstate_plant)
    writeJSON(dir_loottables + "blocks/", "plant", x, generateLootTable(x))
    writeJSON(dir_recipe, "joint", x, generateRecipe(x, "joint"))
    writeJSON(dir_recipe, "cone", x, generateRecipe(x, "cone"))
    writeJSON(dir_recipe, "blunt", x, generateRecipe(x, "blunt"))
    writeJSON(dir_advancements, "joint", x, generateAdvancements(x, "joint"))
    writeJSON(dir_advancements, "cone", x, generateAdvancements(x, "cone"))
    writeJSON(dir_advancements, "blunt", x, generateAdvancements(x, "blunt"))

