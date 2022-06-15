package me.ez.candyland.Client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import me.ez.candyland.Common.Block.CandyTnt.Entity.CandyPrimedTnt;
import me.ez.candyland.Init.Blockinit;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.TntMinecartRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CandyTntEntityRenderer extends net.minecraft.client.renderer.entity.EntityRenderer<CandyPrimedTnt> {

    public CandyTntEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(CandyPrimedTnt tnt, float i1, float i2, PoseStack stack, MultiBufferSource bufferSource, int i3) {
        stack.pushPose();
        stack.translate(0.0D, 0.5D, 0.0D);
        int i = tnt.getFuse();
        if ((float)i - i2 + 1.0F < 10.0F) {
            float f = 1.0F - ((float)i - i2 + 1.0F) / 10.0F;
            f = Mth.clamp(f, 0.0F, 1.0F);
            f *= f;
            f *= f;
            float f1 = 1.0F + f * 0.3F;
            stack.scale(f1, f1, f1);
        }

        stack.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
        stack.translate(-0.5D, -0.5D, 0.5D);
        stack.mulPose(Vector3f.YP.rotationDegrees(90.0F));
        TntMinecartRenderer.renderWhiteSolidBlock(Blockinit.CANDY_TNT.get().defaultBlockState(), stack, bufferSource, i3, i / 5 % 2 == 0);
        stack.popPose();
        super.render(tnt, i1, i2, stack, bufferSource, i3);
    }

    @Override
    public ResourceLocation getTextureLocation(CandyPrimedTnt tnt) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
