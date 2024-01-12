package net.kuro.recrafted.structure.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {

    /*
    STONE TYPES GO HERE LATER
    */

    FLINT(MiningLevels.WOOD, 32, 1.2f, 0.0f, 1, () -> Ingredient.ofItems(Items.FLINT)),

    //ALUMINIUM(MiningLevels.STONE, 151, 2.0f, 0.5f, 2, () -> Ingredient.ofItems(ModItems.ALUMINIUM_INGOT)),
    //TIN(MiningLevels.STONE, 299, 3.0f, 0.8f, 4, () -> Ingredient.ofItems(ModItems.TIN_INGOT)),
    COPPER(MiningLevels.STONE, 404, 4.0f, 1.0f, 5, () -> Ingredient.ofItems(ModItems.COPPER_INGOT)),
    //ZINC(MiningLevels.STONE, 538, 4.5f, 1.7f, 2, () -> Ingredient.ofItems(ModItems.ZINC_INGOT)),
    //BISMUTH(MiningLevels.STONE, 777, 4.8f, 1.5f, 3, () -> Ingredient.ofItems(ModItems.BISMUTH_INGOT)),
    //NICKEL(MiningLevels.STONE, 928, 5.0f, 1.2f, 6, () -> Ingredient.ofItems(ModItems.NICKEL_INGOT)),
    //SILVER(MiningLevels.STONE, 1250, 5.5f, 2.2f, 4, () -> Ingredient.ofItems(ModItems.SILVER_INGOT)),
    //GOLD(MiningLevels.STONE, 1124, 5.5f, 2.0f, 30, () -> Ingredient.ofItems(ModItems.GOLD_INGOT)),
    //STERLING_SILVER(MiningLevels.IRON, 1350, 6.0f, 2.5f, 11, () -> Ingredient.ofItems(ModItems.STERLING_SILVER_INGOT)),
    //ELECTRUM(MiningLevels.IRON, 1717, 6.5f, 2.5f, 12, () -> Ingredient.ofItems(ModItems.ELECTRUM_INGOT)),
    //BRASS(MiningLevels.IRON, 865, 6.8f, 2.8f, 19, () -> Ingredient.ofItems(ModItems.BRASS_INGOT)),
    WHITE_BRONZE(MiningLevels.IRON, 1441, 7.0f, 3.2f, 14, () -> Ingredient.ofItems(ModItems.WHITE_BRONZE_INGOT)),
    BISMUTH_BRONZE(MiningLevels.IRON, 1450, 7.2f, 2.5f, 15, () -> Ingredient.ofItems(ModItems.BISMUTH_BRONZE_INGOT)),
    //LEAD(MiningLevels.IRON, 1511, 7.5f, 3.5f, 13, () -> Ingredient.ofItems(ModItems.LEAD_INGOT)),
    BRONZE(MiningLevels.IRON, 1602, 7.8f, 3.0f, 15, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT)),
    BLACK_BRONZE(MiningLevels.IRON, 1656, 8.0f, 2.8f, 14, () -> Ingredient.ofItems(ModItems.BLACK_BRONZE_INGOT)),
    //PEWTER(MiningLevels.DIAMOND, 2151, 8.5f, 4.0f, 17, () -> Ingredient.ofItems(ModItems.PEWTER_INGOT)),
    //ROSE_GOLD(MiningLevels.DIAMOND, 1850, 9.0f, 4.5f, 35, () -> Ingredient.ofItems(ModItems.ROSE_GOLD_INGOT)),
    //COBALT(MiningLevels.DIAMOND, 1903, 9.2f, 4.3f, 18, () -> Ingredient.ofItems(ModItems.COBALT_INGOT)),
    IRON(MiningLevels.DIAMOND, 2003, 9.5f, 4.8f, 14, () -> Ingredient.ofItems(ModItems.IRON_INGOT)),
    //GUNMETAL(MiningLevels.DIAMOND, 1751, 10.0f, 5.0f, 21, () -> Ingredient.ofItems(ModItems.GUNMETAL_INGOT)),
    //PLATINUM(MiningLevels.DIAMOND, 2202, 10.5f, 4.5f, 22, () -> Ingredient.ofItems(ModItems.PLATINUM_INGOT)),
    //TITANIUM(MiningLevels.DIAMOND, 2415, 11.0f, 5.5f, 20, () -> Ingredient.ofItems(ModItems.TITANIUM_INGOT)),
    STEEL(MiningLevels.NETHERITE, 2567, 12.0f, 6.0f, 25, () -> Ingredient.ofItems(ModItems.STEEL_INGOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

