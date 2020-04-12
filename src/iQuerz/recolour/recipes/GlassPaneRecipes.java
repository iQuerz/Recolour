package iQuerz.recolour.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import iQuerz.recolour.main.Recolour;

public class GlassPaneRecipes {

	Recolour main;
	public GlassPaneRecipes(Recolour main) {
		this.main = main;
		loadRecipes();
	}
	
	void loadRecipes() {
		
		Material[] glasspane = {Material.BLACK_STAINED_GLASS_PANE, Material.BLUE_STAINED_GLASS_PANE, Material.BROWN_STAINED_GLASS_PANE, Material.CYAN_STAINED_GLASS_PANE, Material.GRAY_STAINED_GLASS_PANE, Material.GREEN_STAINED_GLASS_PANE, Material.LIGHT_BLUE_STAINED_GLASS_PANE, Material.LIGHT_GRAY_STAINED_GLASS_PANE, Material.LIME_STAINED_GLASS_PANE, Material.MAGENTA_STAINED_GLASS_PANE, Material.ORANGE_STAINED_GLASS_PANE, Material.PINK_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS_PANE, Material.RED_STAINED_GLASS_PANE, Material.WHITE_STAINED_GLASS_PANE, Material.YELLOW_STAINED_GLASS_PANE};
		for(Material material : glasspane) {
			for(Material ingredient : glasspane) {
				NamespacedKey key = new NamespacedKey(main, material.name() + "_from_" + ingredient.name());
				ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(material,8));
				recipe.shape("GGG","GDG","GGG");
				String dyeName = material.name().replaceAll("STAINED_GLASS_PANE", "DYE");
				recipe.setIngredient('D', Material.getMaterial(dyeName));
				if(ingredient.name().equals(material.name()))
					continue;
				recipe.setIngredient('G', ingredient);
				Bukkit.addRecipe(recipe);
			}
		}
	}
}
