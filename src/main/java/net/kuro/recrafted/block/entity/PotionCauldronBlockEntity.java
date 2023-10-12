package net.kuro.recrafted.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PotionCauldronBlockEntity extends BlockEntity
{
    private Potion potion;
    private String potionType;

    public BlockState getBlockState() {
        assert world != null;
        return world.getBlockState(pos);
    }

    public PotionCauldronBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(ModBlockEntities.POTION_CAULDRON_BE, blockPos, blockState);

        potion = Potions.EMPTY;
        potionType = Registries.ITEM.getId(Items.POTION).toString();
    }

    public @NotNull Potion getPotion() {
        return potion; }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    public @NotNull String getPotionType() {
        return potionType;
    }

    public void setPotionType(String potionType) {
        this.potionType = potionType;
    }

    @Override
    public void readNbt(NbtCompound nbt)
    {
        potion = Registries.POTION.get(Identifier.tryParse(nbt.getString("PotionName")));

        potionType = nbt.getString("PotionType");
    }

    @Override
    protected void writeNbt(NbtCompound nbt)
    {
        if (potion == null)
            return;

        Identifier potionResource = Registries.POTION.getId(potion);
        String potionName = potionResource.toString();

        nbt.putString("PotionName", potionName);
        nbt.putString("PotionType", potionType);
    }

    @Override
    @Nullable
    public Packet<ClientPlayPacketListener> toUpdatePacket()
    {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    @NotNull
    public NbtCompound toInitialChunkDataNbt() {
        return createNbtWithIdentifyingData();
    }
}
