package net.kuro.recrafted.structure.particle;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.kuro.recrafted.Recrafted;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticleTypes {

    public static void registerParticleTypes() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Recrafted.MOD_ID, "patina_flame"), PATINA_FIRE_FLAME);
    }

    public static final DefaultParticleType PATINA_FIRE_FLAME = FabricParticleTypes.simple();

    public static void registerParticleTypesClientSide() {
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.PATINA_FIRE_FLAME, FlameParticle.Factory::new);
    }

}
