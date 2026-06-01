package cat.rezelyn.watheextended.block;

import cat.rezelyn.watheextended.index.WatheExtendedBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GreyiferPlushBlockEntity extends BlockEntity {
    public double squash;

    public GreyiferPlushBlockEntity(BlockPos pos, BlockState state) {
        super(WatheExtendedBlockEntities.GREYIFER_PLUSH, pos, state);
    }

    public static void tick(Level world, BlockPos pos, BlockState state, GreyiferPlushBlockEntity entity) {
        if (entity.squash <= 0.0D) return;
        entity.squash /= 3.0D;
        if (entity.squash < 0.01D) {
            entity.squash = 0.0D;
            if (world != null) world.sendBlockUpdated(pos, state, state, Block.UPDATE_CLIENTS);
        }
    }

    public void squish(int amount) {
        this.squash += amount;
        if (this.level != null) this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_CLIENTS);
        this.setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt, net.minecraft.core.HolderLookup.Provider registries) {
        super.saveAdditional(nbt, registries);
        nbt.putDouble("squash", this.squash);
    }

    @Override
    protected void loadAdditional(CompoundTag nbt, net.minecraft.core.HolderLookup.Provider registries) {
        super.loadAdditional(nbt, registries);
        this.squash = nbt.getDouble("squash");
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(net.minecraft.core.HolderLookup.Provider registries) {
        return this.saveWithoutMetadata(registries);
    }
}
