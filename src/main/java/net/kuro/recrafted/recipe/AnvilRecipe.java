package net.kuro.recrafted.recipe;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.*;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
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
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;
import org.apache.commons.lang3.NotImplementedException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class AnvilRecipe implements Recipe<SimpleInventory> {
    final int width;
    final int height;
    final DefaultedList<Ingredient> input;
    final ItemStack output;
    final int tier;

    public AnvilRecipe(int width, int height, DefaultedList<Ingredient> input, ItemStack output, int tier) {
        this.width = width;
        this.height = height;
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
        return width >= this.width && height >= this.height;
    }

    @Override
    public boolean matches(SimpleInventory inv, World world) {
        for (int i = 0; i <= 3 - this.width; ++i) {
            for (int j = 0; j <= 3 - this.height; ++j) {
                if (this.matchesPattern(inv, i, j, true)) {
                    return true;
                }
                if (!this.matchesPattern(inv, i, j, false)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean matchesPattern(SimpleInventory inv, int offsetX, int offsetY, boolean flipped) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int k = i - offsetX;
                int l = j - offsetY;
                Ingredient ingredient = Ingredient.EMPTY;
                if (k >= 0 && l >= 0 && k < this.width && l < this.height) {
                    ingredient = flipped ? this.input.get(this.width - k - 1 + l * this.width) : this.input.get(k + l * this.width);
                }
                if (ingredient.test(inv.getStack(i + j * 3))) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager dynamicRegistryManager) {
        return this.getResult(dynamicRegistryManager).copy();
    }

    //public int getWidth() {
    //    return this.width;
    //}
//
    //public int getHeight() {
    //    return this.height;
    //}

    static String[] removePadding(List<String> pattern) {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;
        for (int m = 0; m < pattern.size(); ++m) {
            String string = pattern.get(m);
            i = Math.min(i, AnvilRecipe.findFirstSymbol(string));
            int n = AnvilRecipe.findLastSymbol(string);
            j = Math.max(j, n);
            if (n < 0) {
                if (k == m) {
                    ++k;
                }
                ++l;
                continue;
            }
            l = 0;
        }
        if (pattern.size() == l) {
            return new String[0];
        }
        String[] strings = new String[pattern.size() - l - k];
        for (int o = 0; o < strings.length; ++o) {
            strings[o] = pattern.get(o + k).substring(i, j + 1);
        }
        return strings;
    }

    @Override
    public boolean isEmpty() {
        DefaultedList<Ingredient> defaultedList = this.getIngredients();
        return defaultedList.isEmpty() || defaultedList.stream().filter(ingredient -> !ingredient.isEmpty()).anyMatch(ingredient -> ingredient.getMatchingStacks().length == 0);
    }

    private static int findFirstSymbol(String line) {
        int i;
        for (i = 0; i < line.length() && line.charAt(i) == ' '; ++i) {
        }
        return i;
    }

    private static int findLastSymbol(String pattern) {
        int i;
        for (i = pattern.length() - 1; i >= 0 && pattern.charAt(i) == ' '; --i) {
        }
        return i;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<AnvilRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "anvil";
    }

    //static DefaultedList<Ingredient> createPatternMatrix(String[] pattern, Map<String, Ingredient> symbols, int width, int height) {
    //    DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(width * height, Ingredient.EMPTY);
    //    HashSet<String> set = Sets.newHashSet(symbols.keySet());
    //    set.remove(" ");
    //    for (int i = 0; i < pattern.length; ++i) {
    //        for (int j = 0; j < pattern[i].length(); ++j) {
    //            String string = pattern[i].substring(j, j + 1);
    //            Ingredient ingredient = symbols.get(string);
    //            if (ingredient == null) {
    //                throw new JsonSyntaxException("Pattern references symbol '" + string + "' but it's not defined in the key");
    //            }
    //            set.remove(string);
    //            defaultedList.set(j + width * i, ingredient);
    //        }
    //    }
    //    if (!set.isEmpty()) {
    //        throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
    //    }
    //    return defaultedList;
    //}
//
    //static String[] getPattern(JsonArray json) {
    //    String[] strings = new String[json.size()];
    //    if (strings.length > 3) {
    //        throw new JsonSyntaxException("Invalid pattern: too many rows, 3 is maximum");
    //    }
    //    if (strings.length == 0) {
    //        throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
    //    }
    //    for (int i = 0; i < strings.length; ++i) {
    //        String string = JsonHelper.asString(json.get(i), "pattern[" + i + "]");
    //        if (string.length() > 3) {
    //            throw new JsonSyntaxException("Invalid pattern: too many columns, 3 is maximum");
    //        }
    //        if (i > 0 && strings[0].length() != string.length()) {
    //            throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
    //        }
    //        strings[i] = string;
    //    }
    //    return strings;
    //}
//
    //static Map<String, Ingredient> readSymbols(JsonObject json) {
    //    HashMap<String, Ingredient> map = Maps.newHashMap();
    //    for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
    //        if (entry.getKey().length() != 1) {
    //            throw new JsonSyntaxException("Invalid key entry: '" + entry.getKey() + "' is an invalid symbol (must be 1 character only).");
    //        }
    //        if (" ".equals(entry.getKey())) {
    //            throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
    //        }
    //        map.put(entry.getKey(), Ingredient.fromJson(entry.getValue(), false));
    //    }
    //    map.put(" ", Ingredient.EMPTY);
    //    return map;
    //}
//
    //public static ItemStack outputFromJson(JsonObject json) {
    //    Item item = AnvilRecipe.getItem(json);
    //    if (json.has("data")) {
    //        throw new JsonParseException("Disallowed data tag found");
    //    }
    //    int i = JsonHelper.getInt(json, "count", 1);
    //    if (i < 1) {
    //        throw new JsonSyntaxException("Invalid output count: " + i);
    //    }
    //    return new ItemStack(item, i);
    //}
//
    //public static Item getItem(JsonObject json) {
    //    String string = JsonHelper.getString(json, "item");
    //    Item item = (Item)Registries.ITEM.getOrEmpty(Identifier.tryParse(string)).orElseThrow(() -> new JsonSyntaxException("Unknown item '" + string + "'"));
    //    if (item == Items.AIR) {
    //        throw new JsonSyntaxException("Empty ingredient not allowed here");
    //    }
    //    return item;
    //}

    public static class Serializer implements RecipeSerializer<AnvilRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "anvil";

        static final Codec<List<String>> PATTERN_CODEC = Codec.STRING.listOf().flatXmap(rows -> {
            if (rows.size() > 3) {
                return DataResult.error(() -> "Invalid pattern: too many rows, 3 is maximum");
            }
            if (rows.isEmpty()) {
                return DataResult.error(() -> "Invalid pattern: empty pattern not allowed");
            }
            int i = ((String)rows.get(0)).length();
            for (String string : rows) {
                if (string.length() > 3) {
                    return DataResult.error(() -> "Invalid pattern: too many columns, 3 is maximum");
                }
                if (i == string.length()) continue;
                return DataResult.error(() -> "Invalid pattern: each row must be the same width");
            }
            return DataResult.success(rows);
        }, DataResult::success);

        static final Codec<String> KEY_ENTRY_CODEC = Codec.STRING.flatXmap(keyEntry -> {
            if (keyEntry.length() != 1) {
                return DataResult.error(() -> "Invalid key entry: '" + keyEntry + "' is an invalid symbol (must be 1 character only).");
            }
            if (" ".equals(keyEntry)) {
                return DataResult.error(() -> "Invalid key entry: ' ' is a reserved symbol.");
            }
            return DataResult.success(keyEntry);
        }, DataResult::success);

        private static final Codec<AnvilRecipe> CODEC = AnvilRecipe.Serializer.RawAnvilRecipe.CODEC.flatXmap(recipe -> {
            String[] strings = AnvilRecipe.removePadding(recipe.pattern);
            int i = strings[0].length();
            int j = strings.length;
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i * j, Ingredient.EMPTY);
            HashSet<String> set = Sets.newHashSet(recipe.key.keySet());
            for (int k = 0; k < strings.length; ++k) {
                String string = strings[k];
                for (int l = 0; l < string.length(); ++l) {
                    Ingredient ingredient;
                    String string2 = string.substring(l, l + 1);
                    Ingredient ingredient2 = ingredient = string2.equals(" ") ? Ingredient.EMPTY : recipe.key.get(string2);
                    if (ingredient == null) {
                        return DataResult.error(() -> "Pattern references symbol '" + string2 + "' but it's not defined in the key");
                    }
                    set.remove(string2);
                    defaultedList.set(l + i * k, ingredient);
                }
            }
            if (!set.isEmpty()) {
                return DataResult.error(() -> "Key defines symbols that aren't used in pattern: " + set);
            }
            AnvilRecipe anvilRecipe = new AnvilRecipe(i, j, defaultedList, recipe.output, recipe.tier);
            return DataResult.success(anvilRecipe);
        }, recipe -> {
            throw new NotImplementedException("Serializing AnvilRecipe is not implemented yet.");
        });

        @Override
        public Codec<AnvilRecipe> codec() {
            return CODEC;
        }

        @Override
        public AnvilRecipe read(PacketByteBuf packetByteBuf) {
            int i = packetByteBuf.readVarInt();
            int j = packetByteBuf.readVarInt();
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i * j, Ingredient.EMPTY);
            for (int k = 0; k < defaultedList.size(); ++k) {
                defaultedList.set(k, Ingredient.fromPacket(packetByteBuf));
            }
            ItemStack itemStack = packetByteBuf.readItemStack();
            int k = packetByteBuf.readVarInt();
            return new AnvilRecipe(i, j, defaultedList, itemStack, k);
        }

        @Override
        public void write(PacketByteBuf packetByteBuf, AnvilRecipe anvilRecipe) {
            packetByteBuf.writeVarInt(anvilRecipe.width);
            packetByteBuf.writeVarInt(anvilRecipe.height);
            for (Ingredient ingredient : anvilRecipe.input) {
                ingredient.write(packetByteBuf);
            }
            packetByteBuf.writeItemStack(anvilRecipe.output);
            packetByteBuf.writeVarInt(anvilRecipe.tier);
        }

        record RawAnvilRecipe(Map<String, Ingredient> key, List<String> pattern, ItemStack output, int tier) {
            public static final Codec<AnvilRecipe.Serializer.RawAnvilRecipe> CODEC = RecordCodecBuilder.create(instance ->
                    instance.group(
                            Codecs.strictUnboundedMap(KEY_ENTRY_CODEC, Ingredient.DISALLOW_EMPTY_CODEC).fieldOf("key").forGetter(recipe -> recipe.key),
                            (PATTERN_CODEC.fieldOf("pattern")).forGetter(recipe -> recipe.pattern),
                            (RecipeCodecs.CRAFTING_RESULT.fieldOf("result")).forGetter(recipe -> recipe.output),
                            Codecs.createStrictOptionalFieldCodec(Codec.INT, "tier", 1).forGetter(recipe -> recipe.tier)
                    ).apply(instance, RawAnvilRecipe::new));
        }
    }
    
    
    //public static class Serializer implements RecipeSerializer<AnvilRecipe> {
    //    public static final Serializer INSTANCE = new Serializer();
    //    public static final String ID = "anvil";
    //    // this is the name given in the json file
//
    //    @Override
    //    public AnvilRecipe read(Identifier id, JsonObject json) {
    //        Map<String, Ingredient> map = AnvilRecipe.readSymbols(JsonHelper.getObject(json, "key"));
    //        String[] strings = AnvilRecipe.removePadding(AnvilRecipe.getPattern(JsonHelper.getArray(json, "pattern")));
    //        int i = strings[0].length();
    //        int j = strings.length;
    //        DefaultedList<Ingredient> defaultedList = AnvilRecipe.createPatternMatrix(strings, map, i, j);
    //        ItemStack itemStack = AnvilRecipe.outputFromJson(JsonHelper.getObject(json, "result"));
    //        int k = JsonHelper.getInt(json, "tier");
    //        return new AnvilRecipe(id, i, j, defaultedList, itemStack, k);
    //    }
//
    //    @Override
    //    public AnvilRecipe read(Identifier id, PacketByteBuf buf) {
    //        int i = buf.readVarInt();
    //        int j = buf.readVarInt();
    //        DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i * j, Ingredient.EMPTY);
    //        for (int k = 0; k < defaultedList.size(); ++k) {
    //            defaultedList.set(k, Ingredient.fromPacket(buf));
    //        }
    //        ItemStack itemStack = buf.readItemStack();
    //        int k = buf.readVarInt();
    //        return new AnvilRecipe(id, i, j, defaultedList, itemStack, k);
    //    }
//
    //    @Override
    //    public void write(PacketByteBuf buf, AnvilRecipe recipe) {
    //        buf.writeVarInt(recipe.width);
    //        buf.writeVarInt(recipe.height);
    //        for (Ingredient ingredient : recipe.input) {
    //            ingredient.write(buf);
    //        }
    //        buf.writeItemStack(recipe.output);
    //        buf.writeVarInt(recipe.tier);
    //    }
    //}
}
