package net.textilemc.examplemod.client;

import net.minecraft.class_183;
import net.minecraft.client.render.texture.DynamicTexture;
import net.minecraft.util.math.MathHelper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CustomDynamicTexture extends DynamicTexture {
    private int field_689 = 0;
    private int[] texturePixels = new int[1024];
    private int[] texturePixels2 = new int[1024];
    BufferedImage image;

    private int aba;

    public CustomDynamicTexture(int dimensions) {
        super(100);
        this.aba = (100 << 1) - 1;

        try {
            ImageIO.read(CustomDynamicTexture.class.getResource("/assets/modid/terrain.png")).getRGB(0, 0, dimensions, dimensions, this.texturePixels, 0, dimensions);
            ImageIO.read(CustomDynamicTexture.class.getResource("/assets/modid/terrain.png")).getRGB(0, 0, dimensions*2, dimensions*2, this.texturePixels2, 0, dimensions*2);
            this.image = ImageIO.read(CustomDynamicTexture.class.getResource("/assets/modid/terrain.png"));
            //this.texturePixels2 = texturePixels;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void method_478() {

        for(int var3 = 0; var3 < 16; ++var3) {
            for(int var4 = 0; var4 < 16; ++var4) {


                int var9 = var3 + (var4 << 4);

                this.field_684[var9 << 2] = (byte)(new Color(image.getRGB(var3, var4))).getRed();
                this.field_684[(var9 << 2) + 1] = (byte)(new Color(image.getRGB(var3, var4))).getGreen();
                this.field_684[(var9 << 2) + 2] = (byte)(new Color(image.getRGB(var3, var4))).getBlue();
                this.field_684[(var9 << 2) + 3] = (byte)(new Color(image.getRGB(var3, var4))).getAlpha();
            }
        }
        /*for (byte i = 0; i < this.field_684.length; i++) {
            try {
                this.field_684[i] = (byte) texturePixels[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                try {
                    this.field_684[i-256] = (byte) texturePixels[i];
                } catch (ArrayIndexOutOfBoundsException e1) {
                    try {
                        this.field_684[i-512] = (byte) texturePixels[i];
                    } catch (ArrayIndexOutOfBoundsException e2) {
                        try {
                            this.field_684[i-768] = (byte) texturePixels[i];
                        } catch (ArrayIndexOutOfBoundsException e3) {

                        }
                    }
                }
            }

        }*/

        /*this.field_689 = this.field_689 + this.aba & 63;
        float var1 = MathHelper.sin((float)this.field_689 / 64.0F * 3.1415927F * 2.0F);
        float var2 = MathHelper.cos((float)this.field_689 / 64.0F * 3.1415927F * 2.0F);

        for(int var3 = 0; var3 < 16; ++var3) {
            for(int var4 = 0; var4 < 16; ++var4) {
                float var5 = ((float)var3 / 15.0F - 0.5F) * 31.0F;
                float var6 = ((float)var4 / 15.0F - 0.5F) * 31.0F;
                float var7 = var2 * var5 - var1 * var6;
                var5 = var2 * var6 + var1 * var5;
                int var11 = (int)(var7 + 16.0F);
                int var10 = (int)(var5 + 16.0F);
                int var12 = 0;
                if (var11 >= 0 && var10 >= 0 && var11 < 32 && var10 < 32) {
                    var12 = this.texturePixels2[var11 + (var10 << 5)];
                    if ((var10 = this.texturePixels[var3 + (var4 << 4)]) >>> 24 > 128) {
                        var12 = var10;
                    }
                }

                var10 = var12 >> 16 & 255;
                var11 = var12 >> 8 & 255;
                int var8 = var12 & 255;
                var12 = var12 >>> 24 > 128 ? 255 : 0;
                int var9 = var3 + (var4 << 4);
                /*this.field_684[var9 << 2] = (byte)var10;
                this.field_684[(var9 << 2) + 1] = (byte)var11;
                this.field_684[(var9 << 2) + 2] = (byte)var8;
                this.field_684[(var9 << 2) + 3] = (byte)var12;*/
                /*this.field_684[var9 << 2] = (byte)255;
                this.field_684[(var9 << 2) + 1] = (byte)255;
                this.field_684[(var9 << 2) + 2] = (byte)255;
                this.field_684[(var9 << 2) + 3] = (byte)255;
            }
        }*/
        //super.method_478();
    }
}
