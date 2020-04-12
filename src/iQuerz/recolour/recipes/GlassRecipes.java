package iQuerz.recolour.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import iQuerz.recolour.main.Recolour;

public class GlassRecipes {

	Recolour main;
	
	public GlassRecipes(Recolour main) {
		this.main = main;
		loadRecipes();
	}
	
	void loadRecipes() {
		Material[] glass = {Material.BLACK_STAINED_GLASS, Material.BLUE_STAINED_GLASS, Material.BROWN_STAINED_GLASS, Material.CYAN_STAINED_GLASS, Material.GRAY_STAINED_GLASS, Material.GREEN_STAINED_GLASS, Material.LIGHT_BLUE_STAINED_GLASS, Material.LIGHT_GRAY_STAINED_GLASS, Material.LIME_STAINED_GLASS, Material.MAGENTA_STAINED_GLASS, Material.ORANGE_STAINED_GLASS, Material.PINK_STAINED_GLASS, Material.PURPLE_STAINED_GLASS, Material.RED_STAINED_GLASS, Material.WHITE_STAINED_GLASS, Material.YELLOW_STAINED_GLASS};
		for(Material material : glass) {
			for(Material ingredient : glass) {
				NamespacedKey key = new NamespacedKey(main, material.name() + "_from_" + ingredient.name());
				ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(material,8));
				recipe.shape("GGG","GDG","GGG");
				String dyeName = material.name().replaceAll("STAINED_GLASS", "DYE");
				recipe.setIngredient('D', Material.getMaterial(dyeName));
				if(ingredient.name().equals(material.name()))
					continue;
				recipe.setIngredient('G', ingredient);
				Bukkit.addRecipe(recipe);
			}
		}
	}
}
