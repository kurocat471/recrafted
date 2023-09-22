package net.kuro.recrafted.recipe;

import com.google.gson.*;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class AnvilRecipeShapeless implements Recipe<SimpleInventory> {
    final DefaultedList<Ingredient> input;
    final ItemStack output;
    private final Identifier id;
    final int tier;

    public AnvilRecipeShapeless(Identifier id, DefaultedList<Ingredient> input, ItemStack output, int tier) {
        this.id = id;
        this.input = input;
        this.output = output;
        this.tier = tier;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializer.SHAPED;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return this.output;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return this.input;
    }

    public int getTier() {
        return this.tier;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= this.input.size();
    }


    @Override
    public boolean matches(SimpleInventory inv, World world) {
        RecipeMatcher recipeMatcher = new RecipeMatcher();
        int i = 0;
        for (int j = 0; j < inv.size(); ++j) {
            ItemStack itemStack = inv.getStack(j);
            if (itemStack.isEmpty()) continue;
            ++i;
            recipeMatcher.addInput(itemStack, 1);
        }
        return i == this.input.size() && recipeMatcher.match(this, null);
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager dynamicRegistryManager) {
        return this.getOutput(dynamicRegistryManager).copy();
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<AnvilRecipeShapeless> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "anvil_shapeless";
    }

    @Override
    public boolean isEmpty() {
        DefaultedList<Ingredient> defaultedList = this.getIngredients();
        return defaultedList.isEmpty() || defaultedList.stream().filter(ingredient -> !ingredient.isEmpty()).anyMatch(ingredient -> ingredient.getMatchingStacks().length == 0);
    }

    public static ItemStack outputFromJson(JsonObject json) {
        Item item = AnvilRecipeShapeless.getItem(json);
        if (json.has("data")) {
            throw new JsonParseException("Disallowed data tag found");
        }
        int i = JsonHelper.getInt(json, "count", 1);
        if (i < 1) {
            throw new JsonSyntaxException("Invalid output count: " + i);
        }
        return new ItemStack(item, i);
    }

    public static Item getItem(JsonObject json) {
        String string = JsonHelper.getString(json, "item");
        Item item = (Item)Registries.ITEM.getOrEmpty(Identifier.tryParse(string)).orElseThrow(() -> new JsonSyntaxException("Unknown item '" + string + "'"));
        if (item == Items.AIR) {
            throw new JsonSyntaxException("Empty ingredient not allowed here");
        }
        return item;
    }

    public static class Serializer implements RecipeSerializer<AnvilRecipeShapeless> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "anvil_shapeless";
        // this is the name given in the json file

        @Override
        public AnvilRecipeShapeless read(Identifier id, JsonObject json) {
            String string = JsonHelper.getString(json, "group", "");
            CraftingRecipeCategory craftingRecipeCategory = CraftingRecipeCategory.CODEC.byId(JsonHelper.getString(json, "category", null), CraftingRecipeCategory.MISC);
            DefaultedList<Ingredient> defaultedList = AnvilRecipeShapeless.Serializer.getIngredients(JsonHelper.getArray(json, "ingredients"));
            if (defaultedList.isEmpty()) {
                throw new JsonParseException("No ingredients for shapeless recipe");
            }
            if (defaultedList.size() > 9) {
                throw new JsonParseException("Too many ingredients for shapeless recipe");
            }
            ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));
            int k = JsonHelper.getInt(json, "tier");
            return new AnvilRecipeShapeless(id, defaultedList, itemStack, k);
        }

        private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
            DefaultedList<Ingredient> defaultedList = DefaultedList.of();
            for (int i = 0; i < json.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(json.get(i), false);
                if (ingredient.isEmpty()) continue;
                defaultedList.add(ingredient);
            }
            return defaultedList;
        }

        @Override
        public AnvilRecipeShapeless read(Identifier id, PacketByteBuf buf) {
            int i = buf.readVarInt();
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i, Ingredient.EMPTY);
            for (int j = 0; j < defaultedList.size(); ++j) {
                defaultedList.set(j, Ingredient.fromPacket(buf));
            }
            ItemStack itemStack = buf.readItemStack();
            int k = buf.readVarInt();
            return new AnvilRecipeShapeless(id, defaultedList, itemStack, k);
        }

        @Override
        public void write(PacketByteBuf buf, AnvilRecipeShapeless recipe) {
            buf.writeVarInt(recipe.input.size());
            for (Ingredient ingredient : recipe.input) {
                ingredient.write(buf);
            }
            buf.writeItemStack(recipe.output);
            buf.writeVarInt(recipe.tier);
        }
    }
}
