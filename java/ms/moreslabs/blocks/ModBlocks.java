package ms.moreslabs.blocks;

import ms.moreslabs.MoreSlabsMain;
import ms.moreslabs.items.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block DIRT_SLAB = registerBlock("dirt_slab",
            new CustomDirtBlock(FabricBlockSettings.copyOf(Blocks.DIRT).strength(0.5f,0.5f)), ModItemGroup.MORE_SLABS);

    public static final Block SAND_SLAB = registerBlock("sand_slab",
            new CustomSandBlock(FabricBlockSettings.copyOf(Blocks.SAND).strength(0.5f,0.5f)), ModItemGroup.MORE_SLABS);

    public static final Block SAND_LAYER = registerBlock("sand_layer",
            new CustomSandLayersBlock(FabricBlockSettings.copyOf(Blocks.SAND).strength(0.5f,0.5f)), ModItemGroup.MORE_SLABS);

    public static final Block DIRT_LAYER = registerBlock("dirt_layer",
            new CustomSandLayersBlock(FabricBlockSettings.copyOf(Blocks.DIRT).strength(0.5f,0.5f)), ModItemGroup.MORE_SLABS);




    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(MoreSlabsMain.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(MoreSlabsMain.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(MoreSlabsMain.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Block block){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));


    }
    public static void addItemsToItemGroup(){

        addToItemGroup(ModItemGroup.MORE_SLABS, ModBlocks.DIRT_SLAB);
        addToItemGroup(ModItemGroup.MORE_SLABS, ModBlocks.SAND_SLAB);
        addToItemGroup(ModItemGroup.MORE_SLABS, ModBlocks.SAND_LAYER);
        addToItemGroup(ModItemGroup.MORE_SLABS, ModBlocks.DIRT_LAYER);




    }
    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));

    }

    public static void registerModBlocks() {
        MoreSlabsMain.LOGGER.info("registering Mod Blocks for " + MoreSlabsMain.MOD_ID);
        addItemsToItemGroup();
    }




}


