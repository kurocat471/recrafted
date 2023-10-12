package net.kuro.recrafted.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.kuro.recrafted.Recrafted;
import net.kuro.recrafted.block.custom.AnvilBlock;
import net.kuro.recrafted.item.ModItems;
import net.kuro.recrafted.networking.ModMessages;
import net.kuro.recrafted.recipe.AnvilRecipe;
import net.kuro.recrafted.recipe.AnvilRecipeShapeless;
import net.kuro.recrafted.screen.AnvilScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.profiling.jfr.sample.NetworkIoStatistics;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import javax.swing.text.html.Option;
import java.util.Optional;

public class AnvilBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10, ItemStack.EMPTY);

    private static final int INPUT_SLOT_1 = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int INPUT_SLOT_3 = 2;
    private static final int INPUT_SLOT_4 = 3;
    private static final int INPUT_SLOT_5 = 4;
    private static final int INPUT_SLOT_6 = 5;
    private static final int INPUT_SLOT_7 = 6;
    private static final int INPUT_SLOT_8 = 7;
    private static final int INPUT_SLOT_9 = 8;
    private static final int OUTPUT_SLOT = 9;

    private final String material = ((AnvilBlock) getCachedState().getBlock()).material;
    private final int tier = ((AnvilBlock) getCachedState().getBlock()).tier;

    public AnvilBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ANVIL_BE, pos, state);
    }

    public ItemStack getRenderStackOutput() {
        return this.getStack(OUTPUT_SLOT);
    }

    public ItemStack getRenderStackInput1() {
        if(this.getStack(INPUT_SLOT_1).isEmpty()) {
            if(this.getStack(INPUT_SLOT_2).isEmpty()) {
                if(this.getStack(INPUT_SLOT_3).isEmpty()) {
                    if(this.getStack(INPUT_SLOT_4).isEmpty()) {
                        if(this.getStack(INPUT_SLOT_5).isEmpty()) {
                            if(this.getStack(INPUT_SLOT_6).isEmpty()) {
                                if(this.getStack(INPUT_SLOT_7).isEmpty()) {
                                    if(this.getStack(INPUT_SLOT_8).isEmpty()) {
                                        if(this.getStack(INPUT_SLOT_9).isEmpty()) {
                                            return null;
                                        } else {
                                            return this.getStack(INPUT_SLOT_9);
                                        }
                                    } else {
                                        return this.getStack(INPUT_SLOT_8);
                                    }
                                } else {
                                    return this.getStack(INPUT_SLOT_7);
                                }
                            } else {
                                return this.getStack(INPUT_SLOT_6);
                            }
                        } else {
                            return this.getStack(INPUT_SLOT_5);
                        }
                    } else {
                        return this.getStack(INPUT_SLOT_4);
                    }
                } else {
                    return this.getStack(INPUT_SLOT_3);
                }
            } else {
                return this.getStack(INPUT_SLOT_2);
            }
        } else {
            return this.getStack(INPUT_SLOT_1);
        }
    }

    public ItemStack getRenderStackInput2() {
        if(this.getStack(INPUT_SLOT_1).isEmpty()) {
            if(this.getStack(INPUT_SLOT_2).isEmpty()) {
                if(this.getStack(INPUT_SLOT_3).isEmpty()) {
                    if(this.getStack(INPUT_SLOT_4).isEmpty()) {
                        if(this.getStack(INPUT_SLOT_5).isEmpty()) {
                            if(this.getStack(INPUT_SLOT_6).isEmpty()) {
                                if(this.getStack(INPUT_SLOT_7).isEmpty()) {
                                    if(this.getStack(INPUT_SLOT_8).isEmpty()) {
                                        if(this.getStack(INPUT_SLOT_9).isEmpty()) {
                                            return null;
                                        } else {
                                            return null;
                                        }
                                    } else {
                                        if(this.getStack(INPUT_SLOT_9).isEmpty()) {
                                            return null;
                                        } else {
                                            if (this.getStack(INPUT_SLOT_8).getItem() != this.getStack(INPUT_SLOT_9).getItem()) {
                                                return this.getStack(INPUT_SLOT_9);
                                            } else {
                                                return null;
                                            }
                                        }
                                    }
                                } else {
                                    if(this.getStack(INPUT_SLOT_8).isEmpty()) {
                                        if(this.getStack(INPUT_SLOT_9).isEmpty()) {
                                            return null;
                                        } else {
                                            if (this.getStack(INPUT_SLOT_7).getItem() != this.getStack(INPUT_SLOT_9).getItem()) {
                                                return this.getStack(INPUT_SLOT_9);
                                            } else {
                                                return null;
                                            }
                                        }
                                    } else {
                                        if (this.getStack(INPUT_SLOT_7).getItem() != this.getStack(INPUT_SLOT_8).getItem()) {
                                            return this.getStack(INPUT_SLOT_8);
                                        } else {
                                            return null;
                                        }
                                    }
                                }
                            } else {
                                if (this.getStack(INPUT_SLOT_7).isEmpty()) {
                                    if (this.getStack(INPUT_SLOT_8).isEmpty()) {
                                        if (this.getStack(INPUT_SLOT_9).isEmpty()) {
                                            return null;
                                        } else {
                                            if (this.getStack(INPUT_SLOT_6).getItem() != this.getStack(INPUT_SLOT_9).getItem()) {
                                                return this.getStack(INPUT_SLOT_9);
                                            } else {
                                                return null;
                                            }
                                        }
                                    } else {
                                        if (this.getStack(INPUT_SLOT_6).getItem() != this.getStack(INPUT_SLOT_8).getItem()) {
                                            return this.getStack(INPUT_SLOT_8);
                                        } else {
                                            return null;
                                        }
                                    }
                                } else {
                                    if (this.getStack(INPUT_SLOT_6).getItem() != this.getStack(INPUT_SLOT_7).getItem()) {
                                        return this.getStack(INPUT_SLOT_7);
                                    } else {
                                        return null;
                                    }
                                }
                            }
                        } else {
                            if (this.getStack(INPUT_SLOT_6).isEmpty()) {
                                if (this.getStack(INPUT_SLOT_7).isEmpty()) {
                                    if (this.getStack(INPUT_SLOT_8).isEmpty()) {
                                        if (this.getStack(INPUT_SLOT_9).isEmpty()) {
                                            return null;
                                        } else {
                                            if (this.getStack(INPUT_SLOT_5).getItem() != this.getStack(INPUT_SLOT_9).getItem()) {
                                                return this.getStack(INPUT_SLOT_9);
                                            } else {
                                                return null;
                                            }
                                        }
                                    } else {
                                        if (this.getStack(INPUT_SLOT_5).getItem() != this.getStack(INPUT_SLOT_8).getItem()) {
                                            return this.getStack(INPUT_SLOT_8);
                                        } else {
                                            return null;
                                        }
                                    }
                                } else {
                                    if (this.getStack(INPUT_SLOT_5).getItem() != this.getStack(INPUT_SLOT_7).getItem()) {
                                        return this.getStack(INPUT_SLOT_7);
                                    } else {
                                        return null;
                                    }
                                }
                            } else {
                                if (this.getStack(INPUT_SLOT_5).getItem() != this.getStack(INPUT_SLOT_6).getItem()) {
                                    return this.getStack(INPUT_SLOT_6);
                                } else {
                                    return null;
                                }
                            }
                        }
                    } else {
                        if (this.getStack(INPUT_SLOT_5).isEmpty()) {
                            if (this.getStack(INPUT_SLOT_6).isEmpty()) {
                                if (this.getStack(INPUT_SLOT_7).isEmpty()) {
                                    if (this.getStack(INPUT_SLOT_8).isEmpty()) {
                                        if (this.getStack(INPUT_SLOT_9).isEmpty()) {
                                            return null;
                                        } else {
                                            if (this.getStack(INPUT_SLOT_4).getItem() != this.getStack(INPUT_SLOT_9).getItem()) {
                                                return this.getStack(INPUT_SLOT_9);
                                            } else {
                                                return null;
                                            }
                                        }
                                    } else {
                                        if (this.getStack(INPUT_SLOT_4).getItem() != this.getStack(INPUT_SLOT_8).getItem()) {
                                            return this.getStack(INPUT_SLOT_8);
                                        } else {
                                            return null;
                                        }
                                    }
                                } else {
                                    if (this.getStack(INPUT_SLOT_4).getItem() != this.getStack(INPUT_SLOT_7).getItem()) {
                                        return this.getStack(INPUT_SLOT_7);
                                    } else {
                                        return null;
                                    }
                                }
                            } else {
                                if (this.getStack(INPUT_SLOT_4).getItem() != this.getStack(INPUT_SLOT_6).getItem()) {
                                    return this.getStack(INPUT_SLOT_6);
                                } else {
                                    return null;
                                }
                            }
                        } else {
                            if (this.getStack(INPUT_SLOT_4).getItem() != this.getStack(INPUT_SLOT_5).getItem()) {
                                return this.getStack(INPUT_SLOT_5);
                            } else {
                                return null;
                            }
                        }
                    }
                } else {
                    if (this.getStack(INPUT_SLOT_4).isEmpty()) {
                        if (this.getStack(INPUT_SLOT_5).isEmpty()) {
                            if (this.getStack(INPUT_SLOT_6).isEmpty()) {
                                if (this.getStack(INPUT_SLOT_7).isEmpty()) {
                                    if (this.getStack(INPUT_SLOT_8).isEmpty()) {
                                        if (this.getStack(INPUT_SLOT_9).isEmpty()) {
                                            return null;
                                        } else {
                                            if (this.getStack(INPUT_SLOT_3).getItem() != this.getStack(INPUT_SLOT_9).getItem()) {
                                                return this.getStack(INPUT_SLOT_9);
                                            } else {
                                                return null;
                                            }
                                        }
                                    } else {
                                        if (this.getStack(INPUT_SLOT_3).getItem() != this.getStack(INPUT_SLOT_8).getItem()) {
                                            return this.getStack(INPUT_SLOT_8);
                                        } else {
                                            return null;
                                        }
                                    }
                                } else {
                                    if (this.getStack(INPUT_SLOT_3).getItem() != this.getStack(INPUT_SLOT_7).getItem()) {
                                        return this.getStack(INPUT_SLOT_7);
                                    } else {
                                        return null;
                                    }
                                }
                            } else {
                                if (this.getStack(INPUT_SLOT_3).getItem() != this.getStack(INPUT_SLOT_6).getItem()) {
                                    return this.getStack(INPUT_SLOT_6);
                                } else {
                                    return null;
                                }
                            }
                        } else {
                            if (this.getStack(INPUT_SLOT_3).getItem() != this.getStack(INPUT_SLOT_5).getItem()) {
                                return this.getStack(INPUT_SLOT_5);
                            } else {
                                return null;
                            }
                        }
                    } else {
                        if (this.getStack(INPUT_SLOT_3).getItem() != this.getStack(INPUT_SLOT_4).getItem()) {
                            return this.getStack(INPUT_SLOT_4);
                        } else {
                            return null;
                        }
                    }
                }
            } else {
                if (this.getStack(INPUT_SLOT_3).isEmpty()) {
                    if (this.getStack(INPUT_SLOT_4).isEmpty()) {
                        if (this.getStack(INPUT_SLOT_5).isEmpty()) {
                            if (this.getStack(INPUT_SLOT_6).isEmpty()) {
                                if (this.getStack(INPUT_SLOT_7).isEmpty()) {
                                    if (this.getStack(INPUT_SLOT_8).isEmpty()) {
                                        if (this.getStack(INPUT_SLOT_9).isEmpty()) {
                                            return null;
                                        } else {
                                            if (this.getStack(INPUT_SLOT_2).getItem() != this.getStack(INPUT_SLOT_9).getItem()) {
                                                return this.getStack(INPUT_SLOT_9);
                                            } else {
                                                return null;
                                            }
                                        }
                                    } else {
                                        if (this.getStack(INPUT_SLOT_2).getItem() != this.getStack(INPUT_SLOT_8).getItem()) {
                                            return this.getStack(INPUT_SLOT_8);
                                        } else {
                                            return null;
                                        }
                                    }
                                } else {
                                    if (this.getStack(INPUT_SLOT_2).getItem() != this.getStack(INPUT_SLOT_7).getItem()) {
                                        return this.getStack(INPUT_SLOT_7);
                                    } else {
                                        return null;
                                    }
                                }
                            } else {
                                if (this.getStack(INPUT_SLOT_2).getItem() != this.getStack(INPUT_SLOT_6).getItem()) {
                                    return this.getStack(INPUT_SLOT_6);
                                } else {
                                    return null;
                                }
                            }
                        } else {
                            if (this.getStack(INPUT_SLOT_2).getItem() != this.getStack(INPUT_SLOT_5).getItem()) {
                                return this.getStack(INPUT_SLOT_5);
                            } else {
                                return null;
                            }
                        }
                    } else {
                        if (this.getStack(INPUT_SLOT_2).getItem() != this.getStack(INPUT_SLOT_4).getItem()) {
                            return this.getStack(INPUT_SLOT_4);
                        } else {
                            return null;
                        }
                    }
                } else {
                    if (this.getStack(INPUT_SLOT_2).getItem() != this.getStack(INPUT_SLOT_3).getItem()) {
                        return this.getStack(INPUT_SLOT_3);
                    } else {
                        return null;
                    }
                }
            }
        } else {
            if (this.getStack(INPUT_SLOT_2).isEmpty()) {
                if (this.getStack(INPUT_SLOT_3).isEmpty()) {
                    if (this.getStack(INPUT_SLOT_4).isEmpty()) {
                        if (this.getStack(INPUT_SLOT_5).isEmpty()) {
                            if (this.getStack(INPUT_SLOT_6).isEmpty()) {
                                if (this.getStack(INPUT_SLOT_7).isEmpty()) {
                                    if (this.getStack(INPUT_SLOT_8).isEmpty()) {
                                        if (this.getStack(INPUT_SLOT_9).isEmpty()) {
                                            return null;
                                        } else {
                                            if (this.getStack(INPUT_SLOT_1).getItem() != this.getStack(INPUT_SLOT_9).getItem()) {
                                                return this.getStack(INPUT_SLOT_9);
                                            } else {
                                                return null;
                                            }
                                        }
                                    } else {
                                        if (this.getStack(INPUT_SLOT_1).getItem() != this.getStack(INPUT_SLOT_8).getItem()) {
                                            return this.getStack(INPUT_SLOT_8);
                                        } else {
                                            return null;
                                        }
                                    }
                                } else {
                                    if (this.getStack(INPUT_SLOT_1).getItem() != this.getStack(INPUT_SLOT_7).getItem()) {
                                        return this.getStack(INPUT_SLOT_7);
                                    } else {
                                        return null;
                                    }
                                }
                            } else {
                                if (this.getStack(INPUT_SLOT_1).getItem() != this.getStack(INPUT_SLOT_6).getItem()) {
                                    return this.getStack(INPUT_SLOT_6);
                                } else {
                                    return null;
                                }
                            }
                        } else {
                            if (this.getStack(INPUT_SLOT_1).getItem() != this.getStack(INPUT_SLOT_5).getItem()) {
                                return this.getStack(INPUT_SLOT_5);
                            } else {
                                return null;
                            }
                        }
                    } else {
                        if (this.getStack(INPUT_SLOT_1).getItem() != this.getStack(INPUT_SLOT_4).getItem()) {
                            return this.getStack(INPUT_SLOT_4);
                        } else {
                            return null;
                        }
                    }
                } else {
                    if (this.getStack(INPUT_SLOT_1).getItem() != this.getStack(INPUT_SLOT_3).getItem()) {
                        return this.getStack(INPUT_SLOT_3);
                    } else {
                        return null;
                    }
                }
            } else {
                if (this.getStack(INPUT_SLOT_1).getItem() != this.getStack(INPUT_SLOT_2).getItem()) {
                    return this.getStack(INPUT_SLOT_2);
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public void markDirty() {
        if(!world.isClient()) {
            PacketByteBuf data = PacketByteBufs.create();
            data.writeInt(inventory.size());
            for(int i = 0; i < inventory.size(); i++) {
                data.writeItemStack(inventory.get(i));
            }
            data.writeBlockPos(getPos());

            for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
                ServerPlayNetworking.send(player, ModMessages.ITEM_SYNC, data);
            }
        }

        super.markDirty();
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public void setInventory(DefaultedList<ItemStack> list) {
        for(int i = 0; i < list.size(); i++) {
            this.inventory.set(i, list.get(i));
        }
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(
                "block.mc-recrafted." + material + "_anvil"
        );
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AnvilScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
    }

    public void tick(World world, BlockPos pos, BlockState state) {

    }

    public void craftItem(PlayerEntity player) {
        Optional<AnvilRecipe> recipe = getCurrentRecipe();
        Optional<AnvilRecipeShapeless> recipeShapeless = getCurrentRecipeShapeless();
        if (recipe.isPresent()) {
            if (tier >= recipe.get().getTier()) {
                this.removeStack(INPUT_SLOT_1, 1);
                this.removeStack(INPUT_SLOT_2, 1);
                this.removeStack(INPUT_SLOT_3, 1);
                this.removeStack(INPUT_SLOT_4, 1);
                this.removeStack(INPUT_SLOT_5, 1);
                this.removeStack(INPUT_SLOT_6, 1);
                this.removeStack(INPUT_SLOT_7, 1);
                this.removeStack(INPUT_SLOT_8, 1);
                this.removeStack(INPUT_SLOT_9, 1);

                assert world != null;

                ((ServerWorld) world).playSound(
                        null,
                        pos,
                        SoundEvents.BLOCK_ANVIL_LAND,
                        SoundCategory.BLOCKS,
                        0.3f,
                        world.random.nextFloat() * 0.1f + 0.9f
                );

                ((ServerWorld) world).spawnParticles(
                        ParticleTypes.COMPOSTER,
                        pos.getX() + 0.5, pos.getY() + 0.65, pos.getZ() + 0.5,
                        4,
                        0.14, 0.05, 0.14,
                        0.15);

                ItemStack output = recipe.get().getOutput(null);
                player.getMainHandStack().damage(1, player, playerx -> playerx.sendToolBreakStatus(Hand.MAIN_HAND));
                this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                        this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
            } else {
                assert world != null;

                ((ServerWorld) world).playSound(
                        null,
                        pos,
                        SoundEvents.BLOCK_ANVIL_PLACE,
                        SoundCategory.BLOCKS,
                        0.3f,
                        0.8f
                );
            }
        } else if (recipeShapeless.isPresent()) {
            if (tier >= recipeShapeless.get().getTier()) {
                this.removeStack(INPUT_SLOT_1, 1);
                this.removeStack(INPUT_SLOT_2, 1);
                this.removeStack(INPUT_SLOT_3, 1);
                this.removeStack(INPUT_SLOT_4, 1);
                this.removeStack(INPUT_SLOT_5, 1);
                this.removeStack(INPUT_SLOT_6, 1);
                this.removeStack(INPUT_SLOT_7, 1);
                this.removeStack(INPUT_SLOT_8, 1);
                this.removeStack(INPUT_SLOT_9, 1);

                assert world != null;

                ((ServerWorld) world).playSound(
                        null,
                        pos,
                        SoundEvents.BLOCK_ANVIL_LAND,
                        SoundCategory.BLOCKS,
                        0.3f,
                        world.random.nextFloat() * 0.1f + 0.9f
                );

                ((ServerWorld) world).spawnParticles(
                        ParticleTypes.COMPOSTER,
                        pos.getX() + 0.5, pos.getY() + 0.65, pos.getZ() + 0.5,
                        4,
                        0.14, 0.05, 0.14,
                        0.15);

                ItemStack output = recipeShapeless.get().getOutput(null);

                player.getMainHandStack().damage(1, player, playerx -> playerx.sendToolBreakStatus(Hand.MAIN_HAND));
                this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                        this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
            } else {
                assert world != null;

                ((ServerWorld) world).playSound(
                        null,
                        pos,
                        SoundEvents.BLOCK_ANVIL_PLACE,
                        SoundCategory.BLOCKS,
                        0.3f,
                        0.8f
                );
            }
        } else {
            assert world != null;

            ((ServerWorld) world).playSound(
                    null,
                    pos,
                    SoundEvents.BLOCK_ANVIL_PLACE,
                    SoundCategory.BLOCKS,
                    0.3f,
                    0.8f
            );
        }
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        if (slot == OUTPUT_SLOT) {
            return false;
        } else {
            return ImplementedInventory.super.canInsert(slot, stack, side);
        }
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        return slot == OUTPUT_SLOT;
    }

    public boolean hasRecipe() {
        Optional<AnvilRecipe> recipe = getCurrentRecipe();
        Optional<AnvilRecipeShapeless> recipeShapeless = getCurrentRecipeShapeless();

        if (recipe.isEmpty() && recipeShapeless.isEmpty()) {
            return false;
        } else if (recipeShapeless.isEmpty()) {
            ItemStack output = recipe.get().getOutput(null);

            return canInsertAmountIntoOutputSlot(output.getCount())
                    && canInsertItemIntoOutputSlot(output);
        } else if (recipe.isEmpty()) {
            ItemStack output = recipeShapeless.get().getOutput(null);

            return canInsertAmountIntoOutputSlot(output.getCount())
                    && canInsertItemIntoOutputSlot(output);
        }
        ItemStack output = recipe.get().getOutput(null);

        return canInsertAmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getStack(OUTPUT_SLOT).getMaxCount() >= this.getStack(OUTPUT_SLOT).getCount() + count;
    }

    private Optional<AnvilRecipe> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory(this.size());
        for(int i = 0; i < this.size(); i++) {
            inventory.setStack(i, this.getStack(i));
        }

        return this.getWorld().getRecipeManager().getFirstMatch(AnvilRecipe.Type.INSTANCE, inventory, this.getWorld());
    }

    private Optional<AnvilRecipeShapeless> getCurrentRecipeShapeless() {
        SimpleInventory inventory = new SimpleInventory(this.size());
        for(int i = 0; i < this.size(); i++) {
            inventory.setStack(i, this.getStack(i));
        }

        return this.getWorld().getRecipeManager().getFirstMatch(AnvilRecipeShapeless.Type.INSTANCE, inventory, this.getWorld());
    }

    public boolean canInsertIntoOutputSlot() {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }

}
