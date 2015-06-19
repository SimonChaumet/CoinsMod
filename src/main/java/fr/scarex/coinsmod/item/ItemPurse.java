package fr.scarex.coinsmod.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.scarex.coinsmod.CoinsMod;

/**
 * @author SCAREX
 *
 */
public class ItemPurse extends Item
{
	public static final String NAME = "purse";
	public static final IIcon[] icons = new IIcon[2];

	public ItemPurse() {
		this.setUnlocalizedName(CoinsMod.MODID + "_" + NAME);
		this.setTextureName(CoinsMod.MODID + ":" + NAME);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.maxStackSize = 1;
		this.setHasSubtypes(true);
		
		this.register();
	}

	protected final void register() {
		GameRegistry.registerItem(this, NAME);
	}

	@Override
	public IIcon getIconFromDamage(int meta) {
		return icons[meta];
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.openGui(CoinsMod.INSTANCE, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		return stack;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + (stack.getItemDamage() == 0 ? "" : "_small");
	}

	@Override
	public void registerIcons(IIconRegister register) {
		icons[0] = register.registerIcon(CoinsMod.MODID + ":" + NAME);
		icons[1] = register.registerIcon(CoinsMod.MODID + ":" + NAME + "_small");
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item));
		list.add(new ItemStack(item, 1, 1));
	}
}
