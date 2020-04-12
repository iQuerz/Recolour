package iQuerz.recolour.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import iQuerz.recolour.main.Recolour;

public class CarpetRecipes {

	Recolour main;
	public CarpetRecipes(Recolour main){
		this.main = main;
		loadRecipes();
	}
	
	void loadRecipes() {
		
		Material[] carpet = {Material.BLACK_CARPET, Material.BLUE_CARPET, Material.BROWN_CARPET, Material.CYAN_CARPET, Material.GRAY_CARPET, Material.GREEN_CARPET, Material.LIGHT_BLUE_CARPET, Material.LIGHT_GRAY_CARPET, Material.LIME_CARPET, Material.MAGENTA_CARPET, Material.ORANGE_CARPET, Material.PINK_CARPET, Material.PURPLE_CARPET, Material.RED_CARPET, Material.WHITE_CARPET, Material.YELLOW_CARPET};
		for(Material material : carpet) {
			for(Material ingredient : carpet) {
				NamespacedKey key = new NamespacedKey(main, material.name() + "_from_" + ingredient.name());
				ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(material,8));
				recipe.shape("CCC","CDC","CCC");
				String dyeName = material.name().replaceAll("CARPET", "DYE");
				recipe.setIngredient('D', Material.getMaterial(dyeName));
				if(ingredient.name().equals(material.name()))
					continue;
				recipe.setIngredient('C', ingredient);
				Bukkit.addRecipe(recipe);
			}
		}
	}
}
