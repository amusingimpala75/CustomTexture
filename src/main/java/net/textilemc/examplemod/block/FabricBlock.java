package net.textilemc.examplemod.block;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.living.player.Player;
import net.minecraft.world.World;

import java.util.Random;

public class FabricBlock extends Block {

    //png file location
    public final String textureLocation;

    public FabricBlock(int id, Material material, String resourceLocation) {
        super(id, 100, material);
        this.method_83(1.0F);
        this.textureLocation = resourceLocation;

    }

    @Override
    public int getDrop(int i, Random random) {
        return this.id;
    }

    @Override
    public boolean isFullBlock() {
        return false;
    }

}
