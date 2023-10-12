package net.kuro.recrafted.networking;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.networking.packet.ParticlePacket;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class ServerNetworking
{
    private static MinecraftServer server;

    public static void registerEvents()
    {
        ServerLifecycleEvents.SERVER_STARTING.register(ServerNetworking::serverStarting);
        ServerLifecycleEvents.SERVER_STOPPING.register(ServerNetworking::serverStopping);
    }

    private static void serverStarting(MinecraftServer minecraftServer)
    {
        server = minecraftServer;
    }

    private static void serverStopping(MinecraftServer ignored)
    {
        server = null;
    }

    public static void sendParticlesToClients(ParticlePacket particleInfo)
    {
        PacketByteBuf packet = particleInfo.asPacket();

        BlockPos particlePosition = particleInfo.getBlockPos();
        Vec3d position = new Vec3d(
                particlePosition.getX(),
                particlePosition.getY(),
                particlePosition.getZ()
        );

        for (ServerPlayerEntity player : PlayerLookup.all(server))
        {
            BlockPos playerPosition = player.getBlockPos();
            if (playerPosition.isWithinDistance(position, 32.0))
                ServerPlayNetworking.send(player, Recrafted.PARTICLES_CHANNEL, packet);
        }
    }
}
