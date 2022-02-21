# This script will use a list of strains in order to generate the model files for the strains.
# All files generated will be put into the "out" directory in the main application.

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


# THIS WILL OVERWRITE ANY FILES IN THE DIRECTORY WITH THE SAME NAME
# IF YOU ARE OK WITH THIS, RUN THE SCRIPT
dir_item_models = "out/item/"
dir_blockstates = "out/blockstates/"
dir_loottables = "out/loot_tables/blocks/"


# TODO: Seperate the Block generation with the item generation
# Block generation files
# - src\main\resources\assets\hempcraft\blockstates\plant\          #? Blockstates for plants
# - src\main\resources\data\hempcraft\loot_tables\blocks\plant\     #? Loot Tables for plant

# Creates a Directory if non exists
def createDir(path):
    if not os.path.exists(path):
        os.makedirs(path)
        print("Created Directory: " + path)


def writeJSON(dir, type, name, data):
    with open(dir + type + "/" + name + ".json", 'w') as f:
        json.dump(data, f)
        print("Generated: " + dir + type + ":" + name)
    f.close

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

print("Creating Dirs")
createDir(dir_item_models)
createDir(dir_blockstates + "plant/")
createDir(dir_loottables + "plant/")
createDir(dir_item_models + "seed/")
createDir(dir_item_models + "bud/")
createDir(dir_item_models + "joint/")
createDir(dir_item_models + "cone/")
createDir(dir_item_models + "blunt/")


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
            "model": "hempcraft:block/plant_0"
        },
        "age=1": {
            "model": "hempcraft:block/plant_1"
        },
        "age=2": {
            "model": "hempcraft:block/plant_2"
        },
        "age=3": {
            "model": "hempcraft:block/plant_3"
        },
        "age=4": {
            "model": "hempcraft:block/plant_4"
        },
        "age=5": {
            "model": "hempcraft:block/plant_5"
        },
        "age=6": {
            "model": "hempcraft:block/plant_6"
        },
        "age=7": {
            "model": "hempcraft:block/plant_7"
        }
    }
}


print("Writing Files")


# Writes files from objects
for x in strains:
    writeJSON(dir_item_models, "seed", x, item_seeds)
    writeJSON(dir_item_models, "bud", x, item_buds)
    writeJSON(dir_item_models, "joint", x, item_joints)
    writeJSON(dir_item_models, "cone", x, item_cones)
    writeJSON(dir_item_models, "blunt", x, item_blunts)
    writeJSON(dir_blockstates, "plant", x, blockstate_plant)

    writeJSON(dir_loottables, "plant", x, generateLootTable(x))




