package net.kuro.recrafted.structure.block.custom.potioncauldron;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kuro.recrafted.structure.block.entity.custom.PotionCauldronBlockEntity;
import net.kuro.recrafted.util.ParticleUtils;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Map;

public class PotionCauldronBlock extends LeveledCauldronBlock implements BlockEntityProvider {

    private final Map<Entity, Integer> affectedEntities = Maps.newHashMap();

    public static final String NAME = "potion_cauldron";

    public PotionCauldronBlock(Settings settings, Map<Item, CauldronBehavior> map)
    {
        super(settings, null, map);
    }

    @Override
    protected boolean canBeFilledByDripstone(Fluid fluid) {
        return false;
    }

    @Override
    public void precipitationTick(BlockState state, World world, BlockPos pos, Biome.Precipitation precipitation) {

    }

    @Override
    protected void fillFromDripstone(BlockState state, World world, BlockPos pos, Fluid fluid) {

    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return new PotionCauldronBlockEntity(pos, state);
    }


    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity)
    {
        if (world.isClient || !(entity instanceof LivingEntity livingEntity) || !this.isEntityTouchingFluid(state, pos, entity))
            return;

        if (livingEntity.isOnFire())
        {
            livingEntity.extinguish();
            if (livingEntity.canModifyAt(world, pos))
                this.onFireCollision(state, world, pos);
        }

        PotionCauldronBlockEntity blockEntity = (PotionCauldronBlockEntity) world.getBlockEntity(pos);
        if (blockEntity == null)
            return;

        Potion potion = blockEntity.getPotion();


        for (var ignored : potion.getEffects())
        {
            block20:
            {
                ArrayList<StatusEffectInstance> list;
                block21: {

                    if (world.getTime() % 5 != 0) break block20;

                    this.affectedEntities.entrySet().removeIf(entry -> world.getTime() >= (Integer) entry.getValue());

                    list = Lists.newArrayList();
                    for (StatusEffectInstance statusEffectInstance : potion.getEffects()) {
                        list.add(new StatusEffectInstance(statusEffectInstance.getEffectType(), statusEffectInstance.mapDuration(i -> i / 4), statusEffectInstance.getAmplifier(), statusEffectInstance.isAmbient(), statusEffectInstance.shouldShowParticles()));
                    }

                    if (!list.isEmpty()) break block21;

                    this.affectedEntities.clear();
                    break block20;
                }
                if (this.affectedEntities.containsKey(livingEntity) || !livingEntity.isAffectedBySplashPotions())
                    continue;
                int reapplicationDelay = 20;
                this.affectedEntities.put(livingEntity, (int) world.getTime() + reapplicationDelay);

                for (StatusEffectInstance statusEffectInstance2 : list) {
                    if (statusEffectInstance2.getEffectType().isInstant()) {
                        statusEffectInstance2.getEffectType().applyInstantEffect(null, null, livingEntity, statusEffectInstance2.getAmplifier(), 0.5);
                        continue;
                    }
                    livingEntity.addStatusEffect(new StatusEffectInstance(statusEffectInstance2));
                }
            }
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    @SuppressWarnings("DataFlowIssue")
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random)
    {
        PotionCauldronBlockEntity blockEntity = (PotionCauldronBlockEntity) world.getBlockEntity(pos);
        Potion potion = blockEntity.getPotion();
        ParticleUtils.generatePotionParticles(world, pos, PotionUtil.getColor(potion), false);
    }

    @Environment(EnvType.CLIENT)
    public static ItemStack pickedWithPickBlock(PlayerEntity player, HitResult result)
    {
        if (!(result instanceof BlockHitResult blockHitResult) || blockHitResult.getType() == HitResult.Type.MISS)
            return ItemStack.EMPTY;

        BlockPos pos = blockHitResult.getBlockPos();
        Block block = player.getWorld().getBlockState(pos).getBlock();

        if (!(block instanceof PotionCauldronBlock))
            return ItemStack.EMPTY;

        return new ItemStack(Items.CAULDRON);
    }


}
