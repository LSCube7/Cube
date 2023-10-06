package top.lsc7.cube.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import top.lsc7.cube.Cube;

public class ModItems {
    public static final Item CUBE = registerItem("cube",
            new Item(new FabricItemSettings()));
    public static final Item MAGIC_CUBE = registerItem("magic_cube",
            new Item(new FabricItemSettings()));
    public static Item registerItem(String name, Item item, RegistryKey<ItemGroup>... itemGroups) {
        Item registeredItem = Registry.register(Registries.ITEM, new Identifier(Cube.MOD_ID,name), item);
        for (RegistryKey<ItemGroup> itemGroup: itemGroups) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(registeredItem));
        }
        return registeredItem;
    }
    public static void registerModItems() {
        Cube.LOGGER.debug("Registering mod items for" + Cube.MOD_ID);
    }
}
