package ms.moreslabs.items;

import ms.moreslabs.MoreSlabsMain;
import ms.moreslabs.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> MORE_SLABS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MoreSlabsMain.MOD_ID, "more_slabs"));



    public static void registerItemGroups() {

        Registry.register(Registries.ITEM_GROUP, MORE_SLABS, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModBlocks.DIRT_SLAB))
                .displayName(Text.literal("Slabs & Layers+"))
                .build());
    }





}

