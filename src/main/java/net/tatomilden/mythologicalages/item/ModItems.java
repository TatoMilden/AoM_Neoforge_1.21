package net.tatomilden.mythologicalages.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tatomilden.mythologicalages.effect.MadnessEffect;
import net.tatomilden.mythologicalages.item.custom.BerserkMushroomItem;
import net.tatomilden.mythologicalages.item.custom.MeadItem;
import net.tatomilden.mythologicalages.MythologicalAges;
import net.tatomilden.mythologicalages.item.custom.WineItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MythologicalAges.MOD_ID);

    //              MATERIALS
    public static final DeferredItem<Item> CELESTIAL_BRONZE = ITEMS.register("celestial_bronze",
            () ->  new Item(new Item.Properties()){
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.mythologicalages.celestial_bronze"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> EMPTY_JUG = ITEMS.register("empty_jug",
            () ->  new Item(new Item.Properties()));
    public static final DeferredItem<Item> EMPTY_WINE_BOTTLE = ITEMS.register("empty_wine_bottle",
            () ->  new Item(new Item.Properties()));

    //              FOODS
    public static final DeferredItem<Item> MEAD = ITEMS.register("mead",
            () ->  new MeadItem(new Item.Properties().food(MeadItem.MEAD)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.mythologicalages.mead"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> RAGWEED = ITEMS.register("ragweed",
            () ->  new Item(new Item.Properties().food(ModFoodProperties.RAGWEED)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.mythologicalages.ragweed"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> WINE = ITEMS.register("wine",
            () ->  new WineItem(new Item.Properties().food(WineItem.WINE)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.mythologicalages.wine"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> BERSERK_MUSHROOM = ITEMS.register("berserk_mushroom",
            () ->  new BerserkMushroomItem(new Item.Properties().food(BerserkMushroomItem.BERSERK_MUSHROOM) ){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.mythologicalages.berserk_mushroom"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    //              WEAPONS
    public static final DeferredItem<SwordItem> GLADIUS = ITEMS.register("gladius",
            () ->  new SwordItem(Tiers.IRON, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.IRON,2.0f,-2.0f))));
    public static final DeferredItem<SwordItem> XIFOS = ITEMS.register("xifos",
            () ->  new SwordItem(Tiers.IRON, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.IRON,2.5f,-2.4f))));
    public static final DeferredItem<AxeItem> ONE_HANDED_AXE = ITEMS.register("one_handed_axe",
            () ->  new AxeItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(AxeItem.createAttributes(Tiers.DIAMOND,3.5f,-2.8f))));

    //              ARMOR
    public static final DeferredItem<ArmorItem> GREEK_HELMET = ITEMS.register("greek_helmet",
            () -> new ArmorItem(ModArmorMaterials.CELESTIAL_BRONZE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(22))));
    public static final DeferredItem<ArmorItem> GREEK_CHESTPLATE = ITEMS.register("greek_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CELESTIAL_BRONZE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(32))));
    public static final DeferredItem<ArmorItem> GREEK_LEGGINGS = ITEMS.register("greek_leggings",
            () -> new ArmorItem(ModArmorMaterials.CELESTIAL_BRONZE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(30))));
    public static final DeferredItem<ArmorItem> GREEK_BOOTS = ITEMS.register("greek_boots",
            () -> new ArmorItem(ModArmorMaterials.CELESTIAL_BRONZE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(26))));


    public static void register (IEventBus eventBus){ITEMS.register(eventBus);}
}
