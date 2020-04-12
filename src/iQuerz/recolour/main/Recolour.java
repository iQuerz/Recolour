package iQuerz.recolour.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import iQuerz.recolour.recipes.CarpetRecipes;
import iQuerz.recolour.recipes.GlassPaneRecipes;
import iQuerz.recolour.recipes.GlassRecipes;
import iQuerz.recolour.recipes.TerracottaRecipes;
import iQuerz.recolour.recipes.WoolRecipes;

public class Recolour extends JavaPlugin{

	TerracottaRecipes terracottaRecipes;
	WoolRecipes woolRecipes;
	GlassRecipes glassRecipes;
	GlassPaneRecipes glassPaneRecipes;
	CarpetRecipes carpetRecipes;
	//
	
	@Override
	public void onEnable() {
		terracottaRecipes = new TerracottaRecipes(this);
		woolRecipes = new WoolRecipes(this);
		glassRecipes = new GlassRecipes(this);
		glassPaneRecipes = new GlassPaneRecipes(this);
		carpetRecipes = new CarpetRecipes(this);
		Bukkit.getServer().getLogger().info("Enabled " + getDescription().getName() + " v" + getDescription().getVersion() +".");
		
	}
	@Override
	public void onDisable() {
		Bukkit.getServer().getLogger().info("Disabled " + getDescription().getName() + " v" + getDescription().getVersion() +".");
	}
}
