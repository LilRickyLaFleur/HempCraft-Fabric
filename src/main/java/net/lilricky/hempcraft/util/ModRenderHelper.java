package net.lilricky.hempcraft.util;

import java.util.Stack;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class ModRenderHelper implements ClientModInitializer {
    public static Stack<Block> Plants_To_Render = new Stack<Block>();

    @Environment(EnvType.CLIENT)
    private void Render(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
    }

    // Generates Client Side Models
    @Environment(EnvType.CLIENT)
    @Override
    public void onInitializeClient() {
        for (int i = 0; i < Plants_To_Render.size(); i++) {
            Render(Plants_To_Render.get(i));
        }
    }

}
