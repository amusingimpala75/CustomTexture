package net.textilemc.examplemod.mixin;

import net.minecraft.client.resource.TextureManager;
import net.minecraft.world.ClientWorldManager;
import net.textilemc.examplemod.ExampleMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorldManager.class)
public class ClientWorldManagerTextureMangerForPublicUseMixin {

    @Shadow private TextureManager textureManager;

    @Inject(at=@At("TAIL"), method = "<init>")
    public void registerManagerPublicly(CallbackInfo info) {
        ExampleMod.manager = this.textureManager;

        //This next part could be substituted as an event
        ExampleMod.manager.registerDynamicTexture(ExampleMod.tex);
    }
}
