package net.lilricky.hempcraft.block.custom;

import net.lilricky.hempcraft.HempCraft;
import net.lilricky.hempcraft.block.Plants;
import net.lilricky.hempcraft.item.HC_Strain;
import net.minecraft.block.CropBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;

public class Plant extends CropBlock
{

    String Name;

    public Plant(Settings settings, String name) 
    {        
        super(settings);
        Name = name;
        HempCraft.LOGGER.info("Plant.java: Plant(): " + name);
    }

    @Override
    protected ItemConvertible getSeedsItem() 
    {
        return Plants.Seed;
    }
}
