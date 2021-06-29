package svenhjol.charm.module;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import svenhjol.charm.Charm;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.handler.ModuleHandler;
import svenhjol.charm.base.iface.Config;
import svenhjol.charm.base.iface.Module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Module(mod = Charm.MOD_ID, description = "Lightweight armor is invisible and does not increase mob awareness when drinking Potion of Invisibility.")
public class ArmorInvisibility extends CharmModule {
    public static List<Item> invisibleItems = new ArrayList<>();
    @Config(name = "Valid armor", description = "Additional armor that should be invisible.")
    public static List<String> configValidItems = new ArrayList<>();

    public static boolean shouldArmorBeInvisible(Entity entity, ItemStack stack) {
        if (stack.isEmpty())
            return true; // air is invisible!

        if (ModuleHandler.enabled(ArmorInvisibility.class) && entity instanceof LivingEntity) {
            if (((LivingEntity) entity).getActivePotionEffect(Effects.INVISIBILITY) != null)
                return invisibleItems.contains(stack.getItem());
        }

        return false;
    }

    @Override
    public void onCommonSetup(FMLCommonSetupEvent event) {
        invisibleItems.addAll(Arrays.asList(
                Items.LEATHER_HELMET,
                Items.LEATHER_CHESTPLATE,
                Items.LEATHER_LEGGINGS,
                Items.LEATHER_BOOTS,
                Items.CHAINMAIL_HELMET,
                Items.CHAINMAIL_CHESTPLATE,
                Items.CHAINMAIL_LEGGINGS,
                Items.CHAINMAIL_BOOTS
        ));
        configValidItems.forEach(string -> {
            Item item = Registry.ITEM.getOrDefault(new ResourceLocation(string));
            invisibleItems.add(item);
        });
    }

    @Override
    public void init() {
        invisibleItems.addAll(Arrays.asList(
                Items.LEATHER_HELMET,
                Items.LEATHER_CHESTPLATE,
                Items.LEATHER_LEGGINGS,
                Items.LEATHER_BOOTS,
                Items.CHAINMAIL_HELMET,
                Items.CHAINMAIL_CHESTPLATE,
                Items.CHAINMAIL_LEGGINGS,
                Items.CHAINMAIL_BOOTS
        ));
    }
}
