package fr.scarex.coinsmod.item;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author SCAREX
 *
 */
public class CoinsModItems
{
	public static Item ITEM_COIN, ITEM_PURSE;
	
	public static final void initItems() {
		ITEM_COIN = new ItemCoin();
		ITEM_PURSE = new ItemPurse();
	}
	
	public static final void initItemsCrafts() {
		GameRegistry.addRecipe(new ItemStack(ITEM_PURSE), "S#S", "# #", "###", 'S', Items.string, '#', Items.leather);
		GameRegistry.addRecipe(new ItemStack(ITEM_PURSE, 1, 1), "S#S", "L L", "###", 'S', Items.string, '#', Blocks.wool, 'L', Items.leather);
	}
}
