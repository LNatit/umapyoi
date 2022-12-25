package net.tracen.umapyoi.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tracen.umapyoi.Umapyoi;
import net.tracen.umapyoi.block.BlockRegistry;

public class UmapyoiBlockTagProvider extends BlockTagsProvider {

    public UmapyoiBlockTagProvider(DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
        super(pGenerator, Umapyoi.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(BlockRegistry.THREE_GODDESS.get())
            .add(BlockRegistry.TRAINING_FACILITY.get());
    }
}
