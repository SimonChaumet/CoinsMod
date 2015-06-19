package fr.scarex.coinsmod.item;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.scarex.coinsmod.CoinsMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * @author SCAREX
 *
 */
public class ItemCoin extends Item
{
	public static final String NAME = "coin";
	protected static final String[] names = new String[] {"iron", "gold", "emerald", "diamond"};
	protected static IIcon[] icons = new IIcon[names.length];
	
	public ItemCoin() {
		this.setUnlocalizedName(CoinsMod.MODID + "_" + NAME);
		this.setCreativeTab(CreativeTabs.tabTools);
		
		this.setHasSubtypes(true);
		
		this.register();
	}
	
	protected void register() {
		GameRegistry.registerItem(this, NAME);
	}

	@Override
	public IIcon getIconFromDamage(int meta) {
		return this.icons[meta];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "_" + this.names[stack.getItemDamage()];
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < names.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public void registerIcons(IIconRegister register) {
		for (int i = 0; i < icons.length; i++) {
			this.icons[i] = register.registerIcon(CoinsMod.MODID + ":" + NAME + "_" + this.names[i]);
		}
	}
}
