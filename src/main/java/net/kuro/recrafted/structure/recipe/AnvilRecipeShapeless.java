package net.kuro.recrafted.structure.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

public class AnvilRecipeShapeless implements Recipe<SimpleInventory> {
    final DefaultedList<Ingredient> input;
    final ItemStack output;
    final int tier;

    public AnvilRecipeShapeless(DefaultedList<Ingredient> input, ItemStack output, int tier) {
        this.input = input;
        this.output = output;
        this.tier = tier;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager) {
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
    public boolean isEmpty() {
        DefaultedList<Ingredient> defaultedList = this.getIngredients();
        return defaultedList.isEmpty() || defaultedList.stream().filter(ingredient -> !ingredient.isEmpty()).anyMatch(ingredient -> ingredient.getMatchingStacks().length == 0);
    }
    
    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager dynamicRegistryManager) {
        return this.getResult(dynamicRegistryManager).copy();
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<AnvilRecipeShapeless> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "anvil_shapeless";
    }

    public static class Serializer implements RecipeSerializer<AnvilRecipeShapeless> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "anvil_shapeless";

        private static final Codec<AnvilRecipeShapeless> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        (Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients")).flatXmap(ingredients ->
                        {
                            Ingredient[] ingredients2 = ingredients.stream().filter(ingredient -> !ingredient.isEmpty()).toArray(Ingredient[]::new);
                            if (ingredients2.length == 0) {
                                return DataResult.error(() -> "No ingredients for shapeless recipe");
                            }
                            if (ingredients2.length > 9) {
                                return DataResult.error(() -> "Too many ingredients for shapeless recipe");
                            }
                            return DataResult.success(DefaultedList.copyOf(Ingredient.EMPTY, ingredients2));},
                                DataResult::success).forGetter(recipe -> recipe.input),
                            (RecipeCodecs.CRAFTING_RESULT.fieldOf("result")).forGetter(recipe -> recipe.output),
                Codecs.createStrictOptionalFieldCodec(Codec.INT, "tier", 1).forGetter(recipe -> recipe.tier)
                ).apply(instance, AnvilRecipeShapeless::new));

        @Override
        public Codec<AnvilRecipeShapeless> codec() {
            return CODEC;
        }

        @Override
        public AnvilRecipeShapeless read(PacketByteBuf packetByteBuf) {
            int i = packetByteBuf.readVarInt();
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i, Ingredient.EMPTY);
            defaultedList.replaceAll(ignored -> Ingredient.fromPacket(packetByteBuf));
            ItemStack itemStack = packetByteBuf.readItemStack();
            int k = packetByteBuf.readVarInt();
            return new AnvilRecipeShapeless(defaultedList, itemStack, k);
        }

        @Override
        public void write(PacketByteBuf packetByteBuf, AnvilRecipeShapeless anvilRecipeShapeless) {
            packetByteBuf.writeVarInt(anvilRecipeShapeless.input.size());
            for (Ingredient ingredient : anvilRecipeShapeless.input) {
                ingredient.write(packetByteBuf);
            }
            packetByteBuf.writeItemStack(anvilRecipeShapeless.output);
            packetByteBuf.writeVarInt(anvilRecipeShapeless.tier);
        }
    }
}
