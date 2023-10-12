package net.kuro.recrafted.networking.packet;

import com.google.gson.Gson;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import java.nio.charset.StandardCharsets;

public class ParticlePacket
{
    private final String particleType;
    private final BlockPos blockPos;
    private final int color;
    private final boolean generateMultiple;

    public ParticlePacket(ParticleEffect particleType, BlockPos blockPos)
    {
        this(particleType, blockPos, 0, false);
    }

    public ParticlePacket(ParticleEffect particleType, BlockPos blockPos, int color, boolean generateMultiple)
    {
        this.particleType = particleType.asString();
        this.blockPos = blockPos;
        this.color = color;
        this.generateMultiple = generateMultiple;
    }

    public ParticleEffect getParticleType() { return (ParticleEffect) Registries.PARTICLE_TYPE.get(new Identifier(particleType)); }

    public BlockPos getBlockPos() { return blockPos; }

    public int getColor() { return color; }

    public boolean shouldGenerateMultiple() { return generateMultiple; }

    public PacketByteBuf asPacket()
    {
        PacketByteBuf buf = PacketByteBufs.create();

        String json = new Gson().toJson(this, ParticlePacket.class);
        buf.writeByteArray(json.getBytes(StandardCharsets.UTF_8));

        return buf;
    }

    public static ParticlePacket fromPacket(PacketByteBuf buf)
    {
        String json = new String(buf.readByteArray());
        return new Gson().fromJson(json, ParticlePacket.class);
    }
}
