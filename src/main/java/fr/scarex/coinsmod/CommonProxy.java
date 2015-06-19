package fr.scarex.coinsmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import fr.scarex.coinsmod.client.gui.inventory.GuiPurse;
import fr.scarex.coinsmod.inventory.InventoryPurse;
import fr.scarex.coinsmod.inventory.container.ContainerPurse;

/**
 * @author SCAREX
 * 
 */
public class CommonProxy implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case 0:
			return new ContainerPurse(player.inventory, new InventoryPurse(player.getHeldItem(), player.getHeldItem().getItemDamage() == 0 ? 3 : 2));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case 0:
			return new GuiPurse(player.inventory, new InventoryPurse(player.getHeldItem(), player.getHeldItem().getItemDamage() == 0 ? 3 : 2));
		}
		return null;
	}
}
