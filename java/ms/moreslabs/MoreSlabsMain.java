package ms.moreslabs;

import ms.moreslabs.blocks.ModBlocks;
import ms.moreslabs.items.ModItemGroup;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreSlabsMain implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("moreslabs");
	public static final String MOD_ID = "moreslabs";

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();
		ModBlocks.addItemsToItemGroup();

		ModItemGroup.registerItemGroups();


		LOGGER.info("Hello Fabric world!");
	}
}