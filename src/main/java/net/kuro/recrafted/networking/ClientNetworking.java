package net.kuro.recrafted.networking;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.event.client.player.ClientPickBlockGatherCallback;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.structure.block.custom.potioncauldron.PotionCauldronBlock;
import net.kuro.recrafted.networking.packet.ParticlePacket;
import net.kuro.recrafted.util.ParticleUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;

@Environment(EnvType.CLIENT)
public class ClientNetworking
{
    public static void registerEvents()
    {
        ClientPlayNetworking.registerGlobalReceiver(Recrafted.PARTICLES_CHANNEL, ClientNetworking::receiveParticlesFromServer);

        ClientPickBlockGatherCallback.EVENT.register(PotionCauldronBlock::pickedWithPickBlock);
    }

    public static void receiveParticlesFromServer(MinecraftClient client, ClientPlayNetworkHandler ignoredHandler, PacketByteBuf buf, PacketSender ignoredResponseSender)
    {
        ParticlePacket particleInfo = ParticlePacket.fromPacket(buf);
        ParticleEffect particleType = particleInfo.getParticleType();

        if (particleType == ParticleTypes.EFFECT)
            ParticleUtils.generatePotionParticles(client.world, particleInfo.getBlockPos(), particleInfo.getColor(), particleInfo.shouldGenerateMultiple());
        else if (particleType == ParticleTypes.POOF)
            ParticleUtils.generateEvaporationParticles(client.world, particleInfo.getBlockPos());
    }

}
