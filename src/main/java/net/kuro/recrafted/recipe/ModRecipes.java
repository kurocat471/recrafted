package net.kuro.recrafted.recipe;

import net.kuro.recrafted.Recrafted;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Recrafted.MOD_ID, AnvilRecipe.Serializer.ID),
                AnvilRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Recrafted.MOD_ID, AnvilRecipe.Type.ID),
                AnvilRecipe.Type.INSTANCE);

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Recrafted.MOD_ID, AnvilRecipeShapeless.Serializer.ID),
                AnvilRecipeShapeless.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Recrafted.MOD_ID, AnvilRecipeShapeless.Type.ID),
                AnvilRecipeShapeless.Type.INSTANCE);
    }
}
