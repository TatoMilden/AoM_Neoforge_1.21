package net.tatomilden.mythologicalages.datagen;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.tatomilden.mythologicalages.MythologicalAges;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.tatomilden.mythologicalages.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
       ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.EMPTY_JUG.get(),3)
               .pattern("MX")
               .define('M', ItemTags.PLANKS).define('X', Items.IRON_INGOT)
               .unlockedBy("has_planks",has(ItemTags.PLANKS)).unlockedBy("has_iron_ingot",has(Items.IRON_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GREEK_HELMET.get())
                .pattern("MMM")
                .pattern("M M")
                .define('M',ModItems.CELESTIAL_BRONZE)
                .unlockedBy("has_celestial_bronze",has(ModItems.CELESTIAL_BRONZE)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GREEK_CHESTPLATE.get())
                .pattern("M M")
                .pattern("MMM")
                .pattern("MMM")
                .define('M',ModItems.CELESTIAL_BRONZE)
                .unlockedBy("has_celestial_bronze",has(ModItems.CELESTIAL_BRONZE)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GREEK_LEGGINGS.get())
                .pattern("MMM")
                .pattern("M M")
                .pattern("M M")
                .define('M',ModItems.CELESTIAL_BRONZE)
                .unlockedBy("has_celestial_bronze",has(ModItems.CELESTIAL_BRONZE)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GREEK_BOOTS.get())
                .pattern("M M")
                .pattern("M M")
                .define('M',ModItems.CELESTIAL_BRONZE)
                .unlockedBy("has_celestial_bronze",has(ModItems.CELESTIAL_BRONZE)).save(recipeOutput);
    }



    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, MythologicalAges.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}

