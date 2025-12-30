package net.tatomilden.mythologicalages.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tatomilden.mythologicalages.MythologicalAges;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MythologicalAges.MOD_ID);

    public static final Supplier<CreativeModeTab> MYTHOLOGICAL_FOODS_TAB = CREATIVE_MODE_TAB.register("mythological_foods_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack((ModItems.MEAD.get())))
                    .title(Component.translatable("creativetab.mythologicalages.mythological_foods"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAGWEED);
                        output.accept(ModItems.MEAD);
                        output.accept(ModItems.WINE);
                        output.accept(ModItems.BERSERK_MUSHROOM);
                        output.accept(ModItems.EMPTY_WINE_BOTTLE);
                        output.accept(ModItems.EMPTY_JUG);
                        output.accept(ModItems.CELESTIAL_BRONZE);
                    })
                    .build());
    public static final Supplier<CreativeModeTab> MYTHOLOGICAL_WEAPONS_TAB = CREATIVE_MODE_TAB.register("mythological_weapons_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack((ModItems.GLADIUS.get())))
                    .title(Component.translatable("creativetab.mythologicalages.mythological_weapons"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModItems.GLADIUS);
                        output.accept(ModItems.XIFOS);
                        output.accept(ModItems.ONE_HANDED_AXE);
                        output.accept(ModItems.GREEK_HELMET);
                        output.accept(ModItems.GREEK_CHESTPLATE);
                        output.accept(ModItems.GREEK_LEGGINGS);
                        output.accept(ModItems.GREEK_BOOTS);
                    }).build());


    public static void register (IEventBus eventBus){ CREATIVE_MODE_TAB.register(eventBus);}
}
