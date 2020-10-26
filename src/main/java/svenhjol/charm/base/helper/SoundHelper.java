package svenhjol.charm.base.helper;

import com.google.common.collect.Multimap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SoundEngine;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.SoundCategory;
import svenhjol.charm.mixin.accessor.SoundManagerAccessor;
import svenhjol.charm.mixin.accessor.SoundSystemAccessor;

public class SoundHelper {
    public static SoundHandler getSoundManager() {
        return Minecraft.getInstance().getSoundHandler();
    }

    public static Multimap<SoundCategory, ISound> getPlayingSounds() {
        SoundEngine soundSystem = ((SoundManagerAccessor) getSoundManager()).getSoundSystem();
        return ((SoundSystemAccessor)soundSystem).getSounds();
    }
}