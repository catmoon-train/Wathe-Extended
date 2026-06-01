package cat.rezelyn.watheextended.client.render;

import cat.rezelyn.watheextended.block.GreyiferPlushBlockEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockState;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;

public class GreyiferPlushBlockEntityRenderer implements BlockEntityRenderer<GreyiferPlushBlockEntity> {
    private final BlockRenderDispatcher renderManager;

    public GreyiferPlushBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.renderManager = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(GreyiferPlushBlockEntity entity, float tickDelta, PoseStack matrices, MultiBufferSource consumers, int light, int overlay) {
        matrices.pushPose();

        double squash = entity.squash;
        double previousSquash = squash * 3.0D;
        float squeeze = (float) Math.pow(1.0D - 1.0D / (1.0D + Mth.lerp(tickDelta, previousSquash, squash)), 2.0D);

        matrices.scale(1.0F, 1.0F - squeeze, 1.0F);
        matrices.translate(0.5D, 0.0D, 0.5D);
        matrices.scale(1.0F + squeeze / 2.0F, 1.0F, 1.0F + squeeze / 2.0F);
        matrices.translate(-0.5D, 0.0D, -0.5D);

        BlockState state = entity.getBlockState();
        this.renderManager.getModelRenderer().renderModel(
            matrices.last(), consumers.getBuffer(RenderType.cutout()), state,
            this.renderManager.getBlockModel(state), 1.0F, 1.0F, 1.0F, light, overlay
        );

        matrices.popPose();
    }
}
