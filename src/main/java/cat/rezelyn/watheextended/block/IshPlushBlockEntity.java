package cat.rezelyn.watheextended.block;

import cat.rezelyn.watheextended.index.WatheExtendedBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class IshPlushBlockEntity extends BlockEntity {
    public double squash = 0.0;

    public IshPlushBlockEntity(BlockPos pos, BlockState state) {
        super(WatheExtendedBlockEntities.ISH_PLUSH, pos, state);
    }

    public static void tick(Level world, BlockPos pos, BlockState state, IshPlushBlockEntity block) {
        if (block.squash > 0.0) {
            block.squash /= 3.0;
            if (block.squash < 0.01) {
                block.squash = 0.0;
                if (world != null) world.sendBlockUpdated(pos, state, state, 2);
            }
        }
    }

    public void squish(int amount) {
        this.squash += amount;
        if (this.level != null) this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 2);
        this.setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag, net.minecraft.core.HolderLookup.Provider registries) {
        tag.putDouble("squash", this.squash);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, net.minecraft.core.HolderLookup.Provider registries) {
        this.squash = tag.getDouble("squash");
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
