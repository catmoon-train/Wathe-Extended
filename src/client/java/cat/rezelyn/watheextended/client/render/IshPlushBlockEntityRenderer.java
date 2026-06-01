package cat.rezelyn.watheextended.client.render;

import cat.rezelyn.watheextended.block.IshPlushBlockEntity;
import dev.doctor4t.ratatouille.mixin.client.BlockRenderManagerAccessor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;

public class IshPlushBlockEntityRenderer<T extends BlockEntity> implements BlockEntityRenderer<T> {
    private final BlockRenderDispatcher renderManager;

    public IshPlushBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.renderManager = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(T entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        matrices.pushPose();

        double squash = 0.0;
        if (entity instanceof IshPlushBlockEntity plushBE) squash = plushBE.squash;

        double prevSquash = squash * 3.0;
        double lerpVal = Mth.lerp(tickDelta, prevSquash, squash);
        float squashF = (float) Math.pow(1.0 - 1.0 / (1.0 + lerpVal), 2.0);

        matrices.scale(1.0f, 1.0f - squashF, 1.0f);
        matrices.translate(0.5, 0.0, 0.5);
        matrices.scale(1.0f + squashF / 2.0f, 1.0f, 1.0f + squashF / 2.0f);
        matrices.translate(-0.5, 0.0, -0.5);

        BlockState state = entity.getBlockState();
        var model = renderManager.getBlockModel(state);
        var modelRenderer = ((BlockRenderManagerAccessor) renderManager).getModelRenderer();
        VertexConsumer buffer = vertexConsumers.getBuffer(RenderType.cutout());
        modelRenderer.renderModel(matrices.last(), buffer, state, model, 1.0f, 1.0f, 1.0f, light, overlay);

        matrices.popPose();
    }
}
