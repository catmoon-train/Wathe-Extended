package cat.rezelyn.watheextended.block;

import cat.rezelyn.watheextended.index.WatheExtendedBlockEntities;
import cat.rezelyn.watheextended.index.WatheExtendedSounds;
import dev.doctor4t.ratatouille.index.RatatouilleSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class IshPlushBlock extends dev.doctor4t.ratatouille.block.PlushBlock {

    public IshPlushBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        return use(state, world, pos, player, hit);
    }

    protected InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        world.playSound(player, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, RatatouilleSounds.BLOCK_RAT_MAID_PLUSH_HONK, SoundSource.BLOCKS, 0.5f, 1.0f);
        world.playSound(player, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, WatheExtendedSounds.ISH_PLUSH, SoundSource.BLOCKS, 2.0f, 1.0f);
        if (!world.isClientSide()) {
            BlockEntity block = world.getBlockEntity(pos);
            if (block instanceof IshPlushBlockEntity plushBE) {
                plushBE.squish(1);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void attack(BlockState state, Level world, BlockPos pos, Player player) {
        if (!world.isClientSide()) {
            BlockEntity block = world.getBlockEntity(pos);
            if (block instanceof IshPlushBlockEntity plushBE) {
                plushBE.squish(24);
            }
        }
    }

    @Override
    protected void spawnDestroyParticles(Level world, Player player, BlockPos pos, BlockState state) {
        BlockEntity block = world.getBlockEntity(pos);
        if (block instanceof IshPlushBlockEntity plushBE) {
            plushBE.squish(4);
        }
        super.spawnDestroyParticles(world, player, pos, state);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new IshPlushBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, WatheExtendedBlockEntities.ISH_PLUSH, IshPlushBlockEntity::tick);
    }
}
