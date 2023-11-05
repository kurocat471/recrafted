package net.kuro.recrafted.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kuro.recrafted.block.ModBlocks;
import net.kuro.recrafted.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
       /* offerSmelting(exporter, List.of(ModItems.TIN_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_TIN_INGOT, 0.0f, 200, "superheated_tin_ingot");
        offerBlasting(exporter, List.of(ModItems.TIN_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_TIN_INGOT, 0.0f, 100, "superheated_tin_ingot");
        offerSmelting(exporter, List.of(ModItems.ZINC_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_ZINC_INGOT, 0.0f, 200, "superheated_zinc_ingot");
        offerBlasting(exporter, List.of(ModItems.ZINC_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_ZINC_INGOT, 0.0f, 100, "superheated_zinc_ingot");
        offerSmelting(exporter, List.of(ModItems.ALUMINIUM_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_ALUMINIUM_INGOT, 0.0f, 200, "superheated_aluminium_ingot");
        offerBlasting(exporter, List.of(ModItems.ALUMINIUM_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_ALUMINIUM_INGOT, 0.0f, 100, "superheated_aluminium_ingot");
        offerSmelting(exporter, List.of(ModItems.BISMUTH_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_BISMUTH_INGOT, 0.0f, 200, "superheated_bismuth_ingot");
        offerBlasting(exporter, List.of(ModItems.BISMUTH_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_BISMUTH_INGOT, 0.0f, 100, "superheated_bismuth_ingot");
        offerSmelting(exporter, List.of(ModItems.NICKEL_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_NICKEL_INGOT, 0.0f, 200, "superheated_nickel_ingot");
        offerBlasting(exporter, List.of(ModItems.NICKEL_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_NICKEL_INGOT, 0.0f, 100, "superheated_nickel_ingot");
        offerSmelting(exporter, List.of(ModItems.SILVER_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_SILVER_INGOT, 0.0f, 200, "superheated_silver_ingot");
        offerBlasting(exporter, List.of(ModItems.SILVER_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_SILVER_INGOT, 0.0f, 100, "superheated_silver_ingot");
        offerSmelting(exporter, List.of(ModItems.GOLD_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_GOLD_INGOT, 0.0f, 200, "superheated_gold_ingot");
        offerBlasting(exporter, List.of(ModItems.GOLD_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_GOLD_INGOT, 0.0f, 100, "superheated_gold_ingot");
        offerSmelting(exporter, List.of(ModItems.LEAD_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_LEAD_INGOT, 0.0f, 200, "superheated_lead_ingot");
        offerBlasting(exporter, List.of(ModItems.LEAD_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_LEAD_INGOT, 0.0f, 100, "superheated_lead_ingot");
        offerSmelting(exporter, List.of(ModItems.COBALT_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_COBALT_INGOT, 0.0f, 200, "superheated_cobalt_ingot");
        offerBlasting(exporter, List.of(ModItems.COBALT_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_COBALT_INGOT, 0.0f, 100, "superheated_cobalt_ingot");
        offerSmelting(exporter, List.of(ModItems.PLATINUM_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_PLATINUM_INGOT, 0.0f, 200, "superheated_platinum_ingot");
        offerBlasting(exporter, List.of(ModItems.PLATINUM_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_PLATINUM_INGOT, 0.0f, 100, "superheated_platinum_ingot");
        offerSmelting(exporter, List.of(ModItems.TITANIUM_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_TITANIUM_INGOT, 0.0f, 200, "superheated_titanium_ingot");
        offerBlasting(exporter, List.of(ModItems.TITANIUM_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_TITANIUM_INGOT, 0.0f, 100, "superheated_titanium_ingot");
        offerSmelting(exporter, List.of(ModItems.BRONZE_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_BRONZE_INGOT, 0.0f, 200, "superheated_bronze_ingot");
        offerBlasting(exporter, List.of(ModItems.BRONZE_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_BRONZE_INGOT, 0.0f, 100, "superheated_bronze_ingot");
        offerSmelting(exporter, List.of(ModItems.BISMUTH_BRONZE_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_BISMUTH_BRONZE_INGOT, 0.0f, 200, "superheated_bismuth_bronze_ingot");
        offerBlasting(exporter, List.of(ModItems.BISMUTH_BRONZE_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_BISMUTH_BRONZE_INGOT, 0.0f, 100, "superheated_bismuth_bronze_ingot");
        offerSmelting(exporter, List.of(ModItems.BLACK_BRONZE_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_BLACK_BRONZE_INGOT, 0.0f, 200, "superheated_black_bronze_ingot");
        offerBlasting(exporter, List.of(ModItems.BLACK_BRONZE_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_BLACK_BRONZE_INGOT, 0.0f, 100, "superheated_black_bronze_ingot");
        offerSmelting(exporter, List.of(ModItems.WHITE_BRONZE_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_WHITE_BRONZE_INGOT, 0.0f, 200, "superheated_white_bronze_ingot");
        offerBlasting(exporter, List.of(ModItems.WHITE_BRONZE_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_WHITE_BRONZE_INGOT, 0.0f, 100, "superheated_white_bronze_ingot");
        offerSmelting(exporter, List.of(ModItems.BRASS_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_BRASS_INGOT, 0.0f, 200, "superheated_brass_ingot");
        offerBlasting(exporter, List.of(ModItems.BRASS_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_BRASS_INGOT, 0.0f, 100, "superheated_brass_ingot");
        offerSmelting(exporter, List.of(ModItems.ELECTRUM_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_ELECTRUM_INGOT, 0.0f, 200, "superheated_electrum_ingot");
        offerBlasting(exporter, List.of(ModItems.ELECTRUM_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_ELECTRUM_INGOT, 0.0f, 100, "superheated_electrum_ingot");
        offerSmelting(exporter, List.of(ModItems.STERLING_SILVER_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_STERLING_SILVER_INGOT, 0.0f, 200, "superheated_sterling_silver_ingot");
        offerBlasting(exporter, List.of(ModItems.STERLING_SILVER_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_STERLING_SILVER_INGOT, 0.0f, 100, "superheated_sterling_silver_ingot");
        offerSmelting(exporter, List.of(ModItems.ROSE_GOLD_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_ROSE_GOLD_INGOT, 0.0f, 200, "superheated_rose_gold_ingot");
        offerBlasting(exporter, List.of(ModItems.ROSE_GOLD_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_ROSE_GOLD_INGOT, 0.0f, 100, "superheated_rose_gold_ingot");
        offerSmelting(exporter, List.of(ModItems.GUNMETAL_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_GUNMETAL_INGOT, 0.0f, 200, "superheated_gunmetal_ingot");
        offerBlasting(exporter, List.of(ModItems.GUNMETAL_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_GUNMETAL_INGOT, 0.0f, 100, "superheated_gunmetal_ingot");
        offerSmelting(exporter, List.of(ModItems.PEWTER_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_PEWTER_INGOT, 0.0f, 200, "superheated_pewter_ingot");
        offerBlasting(exporter, List.of(ModItems.PEWTER_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_PEWTER_INGOT, 0.0f, 100, "superheated_pewter_ingot");
        offerSmelting(exporter, List.of(ModItems.STEEL_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_STEEL_INGOT, 0.0f, 200, "superheated_steel_ingot");
        offerBlasting(exporter, List.of(ModItems.STEEL_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_STEEL_INGOT, 0.0f, 100, "superheated_steel_ingot");


        /*ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_AXE)
                .input(ModItems.COPPER_AXE_HEAD)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.COPPER_INGOT), conditionsFromItem(ModItems.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COPPER_AXE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE)
                .input(ModItems.COPPER_PICKAXE_HEAD)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.COPPER_INGOT), conditionsFromItem(ModItems.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COPPER_PICKAXE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL)
                .input(ModItems.COPPER_SHOVEL_HEAD)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.COPPER_INGOT), conditionsFromItem(ModItems.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COPPER_SHOVEL)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE)
                .input(ModItems.COPPER_HOE_HEAD)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.COPPER_INGOT), conditionsFromItem(ModItems.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COPPER_HOE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_BROADSWORD)
                .input(ModItems.COPPER_BROADSWORD_BLADE)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.COPPER_INGOT), conditionsFromItem(ModItems.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COPPER_BROADSWORD)));*/

        /*ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COPPER_ANVIL)
                .pattern("III")
                .pattern(" i ")
                .pattern("iii")
                .input('I', ModBlocks.COPPER_BLOCK)
                .input('i', ModItems.COPPER_INGOT)
                .criterion(hasItem(ModBlocks.COPPER_BLOCK), conditionsFromItem(ModBlocks.COPPER_BLOCK))
                .criterion(hasItem(ModItems.COPPER_INGOT), conditionsFromItem(ModItems.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COPPER_ANVIL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BRONZE_ANVIL)
                .pattern("III")
                .pattern(" i ")
                .pattern("iii")
                .input('I', ModBlocks.BRONZE_BLOCK)
                .input('i', ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModBlocks.BRONZE_BLOCK), conditionsFromItem(ModBlocks.BRONZE_BLOCK))
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRONZE_ANVIL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BISMUTH_BRONZE_ANVIL)
                .pattern("III")
                .pattern(" i ")
                .pattern("iii")
                .input('I', ModBlocks.BISMUTH_BRONZE_BLOCK)
                .input('i', ModItems.BISMUTH_BRONZE_INGOT)
                .criterion(hasItem(ModBlocks.BISMUTH_BRONZE_BLOCK), conditionsFromItem(ModBlocks.BISMUTH_BRONZE_BLOCK))
                .criterion(hasItem(ModItems.BISMUTH_BRONZE_INGOT), conditionsFromItem(ModItems.BISMUTH_BRONZE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BISMUTH_BRONZE_ANVIL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BLACK_BRONZE_ANVIL)
                .pattern("III")
                .pattern(" i ")
                .pattern("iii")
                .input('I', ModBlocks.BLACK_BRONZE_BLOCK)
                .input('i', ModItems.BLACK_BRONZE_INGOT)
                .criterion(hasItem(ModBlocks.BLACK_BRONZE_BLOCK), conditionsFromItem(ModBlocks.BLACK_BRONZE_BLOCK))
                .criterion(hasItem(ModItems.BLACK_BRONZE_INGOT), conditionsFromItem(ModItems.BLACK_BRONZE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BLACK_BRONZE_ANVIL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WHITE_BRONZE_ANVIL)
                .pattern("III")
                .pattern(" i ")
                .pattern("iii")
                .input('I', ModBlocks.WHITE_BRONZE_BLOCK)
                .input('i', ModItems.WHITE_BRONZE_INGOT)
                .criterion(hasItem(ModBlocks.WHITE_BRONZE_BLOCK), conditionsFromItem(ModBlocks.WHITE_BRONZE_BLOCK))
                .criterion(hasItem(ModItems.WHITE_BRONZE_INGOT), conditionsFromItem(ModItems.WHITE_BRONZE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.WHITE_BRONZE_ANVIL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.IRON_ANVIL)
                .pattern("III")
                .pattern(" i ")
                .pattern("iii")
                .input('I', ModBlocks.IRON_BLOCK)
                .input('i', ModItems.IRON_INGOT)
                .criterion(hasItem(ModBlocks.IRON_BLOCK), conditionsFromItem(ModBlocks.IRON_BLOCK))
                .criterion(hasItem(ModItems.IRON_INGOT), conditionsFromItem(ModItems.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.IRON_ANVIL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STEEL_ANVIL)
                .pattern("III")
                .pattern(" i ")
                .pattern("iii")
                .input('I', ModBlocks.STEEL_BLOCK)
                .input('i', ModItems.STEEL_INGOT)
                .criterion(hasItem(ModBlocks.STEEL_BLOCK), conditionsFromItem(ModBlocks.STEEL_BLOCK))
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.STEEL_ANVIL)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HAMMER)
                .input(ModItems.COPPER_INGOT)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.COPPER_INGOT), conditionsFromItem(ModItems.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COPPER_HAMMER)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_HAMMER)
                .input(ModItems.BRONZE_INGOT)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BRONZE_HAMMER)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BISMUTH_BRONZE_HAMMER)
                .input(ModItems.BISMUTH_BRONZE_INGOT)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.BISMUTH_BRONZE_INGOT), conditionsFromItem(ModItems.BISMUTH_BRONZE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BISMUTH_BRONZE_HAMMER)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BLACK_BRONZE_HAMMER)
                .input(ModItems.BLACK_BRONZE_INGOT)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.BLACK_BRONZE_INGOT), conditionsFromItem(ModItems.BLACK_BRONZE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLACK_BRONZE_HAMMER)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.WHITE_BRONZE_HAMMER)
                .input(ModItems.WHITE_BRONZE_INGOT)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.WHITE_BRONZE_INGOT), conditionsFromItem(ModItems.WHITE_BRONZE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WHITE_BRONZE_HAMMER)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.IRON_HAMMER)
                .input(ModItems.IRON_INGOT)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.IRON_INGOT), conditionsFromItem(ModItems.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IRON_HAMMER)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STEEL_HAMMER)
                .input(ModItems.STEEL_INGOT)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_HAMMER)));

        offerSmelting(exporter, List.of(ModItems.COPPER_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_COPPER_INGOT, 0.0f, 500, "superheated_copper_ingot");
        offerBlasting(exporter, List.of(ModItems.COPPER_INGOT), RecipeCategory.MISC,
                ModItems.SUPERHEATED_COPPER_INGOT, 0.0f, 300, "superheated_copper_ingot");*/
    }
}
