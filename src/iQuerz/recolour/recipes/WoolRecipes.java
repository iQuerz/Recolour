package iQuerz.recolour.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import iQuerz.recolour.main.Recolour;

public class WoolRecipes {

	Recolour main;
	
	public WoolRecipes(Recolour main) {
		this.main = main;
		loadRecipes();
		
	}
	void loadRecipes() {
		
		Material[] wool = {Material.BLACK_WOOL, Material.BLUE_WOOL, Material.BROWN_WOOL, Material.CYAN_WOOL, Material.GRAY_WOOL, Material.GREEN_WOOL, Material.LIGHT_BLUE_WOOL, Material.LIGHT_GRAY_WOOL, Material.LIME_WOOL, Material.MAGENTA_WOOL, Material.ORANGE_WOOL, Material.PINK_WOOL, Material.PURPLE_WOOL, Material.RED_WOOL, Material.YELLOW_WOOL};
		for(Material material : wool) {
			for(Material ingredient : wool) {
				NamespacedKey key = new NamespacedKey(main,material.name()+"_from_"+ingredient.name());
				ShapelessRecipe recipe = new ShapelessRecipe(key, new ItemStack(material));
				String dyeName = material.name().replaceAll("WOOL", "DYE");
				recipe.addIngredient(Material.getMaterial(dyeName));
				if(ingredient.name().equals(material.name()))
					continue;
				recipe.addIngredient(ingredient);
				Bukkit.addRecipe(recipe);
			}
		}
	}
}

