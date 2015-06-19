package fr.scarex.coinsmod.inventory.slot;

import fr.scarex.coinsmod.item.ItemCoin;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * @author SCAREX
 *
 */
public class SlotPurse extends Slot
{
	public SlotPurse(IInventory inv, int index, int x, int y) {
		super(inv, index, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.getItem() instanceof ItemCoin;
	}
}
