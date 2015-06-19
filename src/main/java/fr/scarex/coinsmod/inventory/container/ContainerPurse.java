package fr.scarex.coinsmod.inventory.container;

import invtweaks.api.container.ChestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import fr.scarex.coinsmod.inventory.InventoryPurse;
import fr.scarex.coinsmod.inventory.slot.SlotPurse;
import fr.scarex.coinsmod.item.ItemCoin;

/**
 * @author SCAREX
 * 
 */
@ChestContainer
public class ContainerPurse extends Container
{
	public InventoryPurse invPurse;
	public boolean needsUpdate;

	public ContainerPurse(InventoryPlayer playerInv, InventoryPurse inv) {
		this.invPurse = inv;
		int j;
		int k;

		if (inv.getSizeInventory() == 2) {
			this.addSlotToContainer(new SlotPurse(inv, 0, 67, 12));
			this.addSlotToContainer(new SlotPurse(inv, 1, 94, 12));
		} else {
			this.addSlotToContainer(new SlotPurse(inv, 0, 62, 12));
			this.addSlotToContainer(new SlotPurse(inv, 1, 81, 12));
			this.addSlotToContainer(new SlotPurse(inv, 2, 100, 12));
		}

		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(playerInv, k + j * 9 + 9, 8 + k * 18, 38 + j * 18));
			}
		}

		for (j = 0; j < 9; ++j) {
			this.addSlotToContainer(new Slot(playerInv, j, 8 + j * 18, 96));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	public void writeToNBT(ItemStack stack) {
		if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		invPurse.writeToNBT(stack.getTagCompound());
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (!(itemstack.getItem() instanceof ItemCoin)) return null;

			if (index < this.invPurse.getSizeInventory()) {
				if (!this.mergeItemStack(itemstack1, this.invPurse.getSizeInventory(), this.inventorySlots.size(), true)) return null;
			} else if (!this.mergeItemStack(itemstack1, 0, this.invPurse.getSizeInventory(), false)) { return null; }

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
				this.needsUpdate = true;
			}
		}

		return itemstack;
	}

	@Override
	public ItemStack slotClick(int slotIndex, int buttonPressed, int flag, EntityPlayer player) {
		if (flag == 2 && buttonPressed == player.inventory.currentItem) return null;
		if (slotIndex - this.invPurse.getSizeInventory() - 27 == player.inventory.currentItem) return null;
		this.needsUpdate = true;
		return super.slotClick(slotIndex, buttonPressed, flag, player);
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		this.writeToNBT(player.getHeldItem());
		super.onContainerClosed(player);
	}
}
