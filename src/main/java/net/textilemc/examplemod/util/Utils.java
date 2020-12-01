package net.textilemc.examplemod.util;

import net.minecraft.block.Block;

public class Utils {
    public static Block getBlockFromId(int id) {
        for (int i = 0; i < Block.BLOCKS.length; i++) {
            if (i == id) {
                return Block.BLOCKS[i];
            }
        }
        return null;
    }
}
