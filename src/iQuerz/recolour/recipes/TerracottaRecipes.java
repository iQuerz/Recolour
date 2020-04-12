package iQuerz.recolour.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import iQuerz.recolour.main.Recolour;

public class TerracottaRecipes {
	
	Recolour main;
	public TerracottaRecipes (Recolour main) {
		this.main = main;
		loadRecipes();
	}
	
	void loadRecipes() {
		
		Material[] terracotta = {Material.BLACK_TERRACOTTA, Material.RED_TERRACOTTA, Material.GREEN_TERRACOTTA, Material.BROWN_TERRACOTTA, Material.CYAN_TERRACOTTA, Material.BLUE_TERRACOTTA, Material.GRAY_TERRACOTTA, Material.LIGHT_BLUE_TERRACOTTA, Material.LIGHT_GRAY_TERRACOTTA, Material.LIME_TERRACOTTA, Material.MAGENTA_TERRACOTTA, Material.ORANGE_TERRACOTTA, Material.PINK_TERRACOTTA,Material.PURPLE_TERRACOTTA, Material.WHITE_TERRACOTTA, Material.YELLOW_TERRACOTTA};
		for(Material material : terracotta) {
			for(Material ingredient : terracotta) {
				NamespacedKey key = new NamespacedKey(main,material.name()+"_from_"+ingredient.name());
				ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(material,8));
				recipe.shape("TTT","TDT","TTT");
				String dyeName = material.name().replaceAll("TERRACOTTA", "DYE");
				recipe.setIngredient('D', Material.getMaterial(dyeName));
				if(ingredient.name().equals(material.name()))
					continue;
				recipe.setIngredient('T', ingredient);
				Bukkit.addRecipe(recipe);
			}
		}
		
	}
	
}
