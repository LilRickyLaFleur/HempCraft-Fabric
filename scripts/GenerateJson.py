# This script will use a list of strains in order to generate the model files for the strains.
# All files generated will be put into the "out" directory in the main application.

import json
import os

# THIS WILL OVERWRITE ANY FILES IN THE DIRECTORY WITH THE SAME NAME
# IF YOU ARE OK WITH THIS, RUN THE SCRIPT
out = "src/main/resources/assets/hempcraft/models/item/"
dir_block_models = "src/main/resources/assets/hempcraft/models/block/"

# TODO: Seperate the Block generation with the item generation
# Block generation files
# - src\main\resources\assets\hempcraft\blockstates\plant\
# 

print("Creating Dirs")

# Make Directories if none exists
if not os.path.exists(out + "seed"):
    os.mkdir(out + "seed")
    print("Created: " + out + "seed")

if not os.path.exists(out + "bud"):
    os.mkdir(out + "bud")
    print("Created: " + out + "bud")

if not os.path.exists(dir_block_models + "plant"):
    os.mkdir(dir_block_models + "plant")
    print("Created: " + dir_block_models + "plant")

if not os.path.exists(out + "joint"):
    os.mkdir(out + "joint")
    print("Created: " + out + "joint")

if not os.path.exists(out + "cone"):
    os.mkdir(out + "cone")
    print("Created: " + out + "cone")

if not os.path.exists(out + "blunt"):
    os.mkdir(out + "blunt")
    print("Created: " + out + "blunt")

# LIST OF STRAINS
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

# List Of Objects
seeds = { "parent" : "hempcraft:item/seeds" }
buds = { "parent": "hempcraft:item/bud" }
plants = {"parent" : "hempcraft:block/plant" }
joints = { "parent": "hempcraft:item/joint" }
cones = { "parent": "hempcraft:item/cone" }
blunts = { "parent": "hempcraft:item/blunt" }

print("Writing Files")


# Writes files from objects
for x in strains:
    # Seeds
    with open(out + 'seed/' + x + ".json", 'w') as f:
        json.dump(seeds, f)
        print("Generated: " + out + "seed/" + x + ".json")
    f.close()

    # Buds
    with open(out + 'bud/' + x + ".json", 'w') as f:
        json.dump(buds, f)
        print("Generated: " + out + "bud/" + x + ".json")
    f.close()

    # Plants
    with open(dir_block_models + 'plant/' + x + ".json", 'w') as f:
        json.dump(plants, f)
        print("Generated: " + dir_block_models + "plant/" + x + ".json")
    f.close()

    # Joints
    with open(out + 'joint/' + x + ".json", 'w') as f:
        json.dump(joints, f)
        print("Generated: " + out + "joint/" + x + ".json")
    f.close()

    # Cones
    with open(out + 'cone/' + x + ".json", 'w') as f:
        json.dump(cones, f)
        print("Generated: " + out + "cone/" + x + ".json")
    f.close()

    # Blunts
    with open(out + 'blunt/' + x + ".json", 'w') as f:
        json.dump(blunts, f)
        print("Generated: " + out + "blunt/" + x + ".json")
    f.close()



