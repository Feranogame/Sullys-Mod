package com.uraneptus.sullysmod.client.model;

import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.common.entities.Tortoise;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class TortoiseModel <T extends Tortoise> extends AnimatedGeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T object) {
        return SullysMod.modPrefix("geo/tortoise.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T object) {
        return SullysMod.modPrefix("textures/entity/tortoise/tortoise.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return SullysMod.modPrefix("animations/tortoise.animation.json");
    }


    @SuppressWarnings({ "unchecked", "unused"})
    @Override
    public void setCustomAnimations(T animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}
