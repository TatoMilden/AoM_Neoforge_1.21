package net.tatomilden.mythologicalages.datagen;

import net.minecraft.tags.ItemTags;
import net.neoforged.fml.common.Mod;
import net.tatomilden.mythologicalages.MythologicalAges;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.tatomilden.mythologicalages.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {


    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MythologicalAges.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.SWORDS)
                .add(ModItems.GLADIUS.get())
                .add(ModItems.XIFOS.get());
        tag(ItemTags.AXES)
                .add(ModItems.ONE_HANDED_AXE.get());
    }
}
