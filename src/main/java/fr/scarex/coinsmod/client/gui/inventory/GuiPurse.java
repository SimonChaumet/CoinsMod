package fr.scarex.coinsmod.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.scarex.coinsmod.CoinsMod;
import fr.scarex.coinsmod.inventory.InventoryPurse;
import fr.scarex.coinsmod.inventory.container.ContainerPurse;

/**
 * @author SCAREX
 * 
 */
public class GuiPurse extends GuiContainer
{
	public static ResourceLocation[] textures = new ResourceLocation[] {
			new ResourceLocation(CoinsMod.MODID, "textures/gui/container/purse.png"),
			new ResourceLocation(CoinsMod.MODID, "textures/gui/container/purse_small.png") };
	protected InventoryPurse inv;
	protected InventoryPlayer playerInv;

	public GuiPurse(InventoryPlayer playerInv, InventoryPurse inv) {
		super(new ContainerPurse(playerInv, inv));
		this.playerInv = playerInv;
		this.inv = inv;
		this.allowUserInput = false;
		this.ySize = 120;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float prt, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(textures[inv.getSizeInventory() == 3 ? 0 : 1]);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}
