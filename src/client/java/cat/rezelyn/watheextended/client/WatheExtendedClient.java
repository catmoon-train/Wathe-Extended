package cat.rezelyn.watheextended.client;

import cat.rezelyn.watheextended.client.render.GreyiferPlushBlockEntityRenderer;
import cat.rezelyn.watheextended.client.render.IshPlushBlockEntityRenderer;
import cat.rezelyn.watheextended.index.WatheExtendedBlockEntities;
import cat.rezelyn.watheextended.index.WatheExtendedBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class WatheExtendedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(WatheExtendedBlockEntities.ISH_PLUSH, IshPlushBlockEntityRenderer::new);
        BlockEntityRenderers.register(WatheExtendedBlockEntities.GREYIFER_PLUSH, GreyiferPlushBlockEntityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                WatheExtendedBlocks.ANTHRACITE_STEEL_ORNAMENT,
                WatheExtendedBlocks.KHAKI_STEEL_ORNAMENT,
                WatheExtendedBlocks.MAROON_STEEL_ORNAMENT,
                WatheExtendedBlocks.MUNTZ_STEEL_ORNAMENT,
                WatheExtendedBlocks.NAVY_STEEL_ORNAMENT,
                WatheExtendedBlocks.SNOWY_OAK_LEAVES, WatheExtendedBlocks.SNOWY_SPRUCE_LEAVES,
                WatheExtendedBlocks.SNOWY_BIRCH_LEAVES, WatheExtendedBlocks.SNOWY_JUNGLE_LEAVES,
                WatheExtendedBlocks.SNOWY_ACACIA_LEAVES, WatheExtendedBlocks.SNOWY_DARK_OAK_LEAVES,
                WatheExtendedBlocks.SNOWY_MANGROVE_LEAVES, WatheExtendedBlocks.SNOWY_CHERRY_LEAVES,
                WatheExtendedBlocks.SNOWY_AZALEA_LEAVES, WatheExtendedBlocks.SNOWY_FLOWERING_AZALEA_LEAVES
        );
    }
}
