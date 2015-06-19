package fr.scarex.coinsmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import fr.scarex.coinsmod.item.CoinsModItems;

/**
 * @author SCAREX
 *
 */
@Mod(modid = CoinsMod.MODID, name = CoinsMod.NAME, version = CoinsMod.VERSION)
public class CoinsMod
{
	public static final String MODID = "coinsmod";
	public static final String NAME = "Coins Mod";
	public static final String VERSION = "1.0.0";
	
	@Mod.Instance(MODID)
	public static CoinsMod INSTANCE;
	
	@SidedProxy(serverSide = "fr.scarex.coinsmod.CommonProxy", clientSide = "fr.scarex.coinsmod.client.ClientProxy")
	public static CommonProxy PROXY;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		CoinsModItems.initItems();
		CoinsModItems.initItemsCrafts();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, PROXY);
	}
}
