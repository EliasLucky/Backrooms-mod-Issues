package com.skittle.backrooms.entity.model;

import com.skittle.backrooms.utils.Utils;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelDeathmoth extends ModelBase
{
    public ModelRenderer Head;
    public ModelRenderer torso;
    public ModelRenderer leftEar;
    public ModelRenderer rightEar;
    public ModelRenderer rightWing;
    public ModelRenderer leftWing;
    public ModelRenderer neck;
    public ModelRenderer torsoLower;
    public ModelRenderer leftArmUpper;
    public ModelRenderer rightArmUpper;
    public ModelRenderer leftArmMiddle;
    public ModelRenderer rightArmMiddle;
    public ModelRenderer rightWingChild;
    public ModelRenderer leftWingChild;
    public ModelRenderer leftArmLower;
    public ModelRenderer rightArmLower;
    public ModelRenderer leftArmLowerChild;
    public ModelRenderer rightArmLowerChild;
    public ModelRenderer leftArmUpperChild;
    public ModelRenderer rightArmUpperChild;
    public ModelRenderer leftArmMiddleChild;
    public ModelRenderer rightArmMiddleChild;

    public ModelDeathmoth() {
    	this.textureWidth = 64;
        this.textureHeight = 64;
        this.rightEar = new ModelRenderer(this, 24, 0);
        this.rightEar.mirror = true;
        this.rightEar.setRotationPoint(-2.0F, -1.0F, 1.0F);
        this.rightEar.addBox(2.0F, -8.0F, -1.0F, 3, 6, 0, 0.0F);
        this.setRotateAngle(rightEar, 0.0F, 0.0F, 0.4363323129985824F);
        this.rightArmMiddle = new ModelRenderer(this, 24, 7);
        this.rightArmMiddle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightArmMiddle.addBox(-6.0F, 9.0F, -1.5F, 4, 1, 0, 0.0F);
        this.setRotateAngle(rightArmMiddle, 0.0F, 0.5235987755982988F, 0.0F);
        this.leftWingChild = new ModelRenderer(this, 24, 16);
        this.leftWingChild.mirror = true;
        this.leftWingChild.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.leftWingChild.addBox(10.0F, -5.0F, 0.0F, 8, 12, 1, 0.0F);
        this.rightArmLower = new ModelRenderer(this, 24, 7);
        this.rightArmLower.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightArmLower.addBox(-2.8F, 13.5F, -6.0F, 4, 1, 0, 0.0F);
        this.setRotateAngle(rightArmLower, 0.0F, 0.5235987755982988F, 0.0F);
        this.rightArmLowerChild = new ModelRenderer(this, 32, 6);
        this.rightArmLowerChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightArmLowerChild.addBox(-9.4F, 13.5F, -3.8F, 4, 1, 0, 0.0F);
        this.setRotateAngle(rightArmLowerChild, 0.0F, -0.5235987755982988F, 0.0F);
        this.torso = new ModelRenderer(this, 0, 12);
        this.torso.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.torso.addBox(-3.0F, 4.0F, -3.0F, 6, 8, 6, 0.0F);
        this.setRotateAngle(torso, -0.33161255787892263F, 3.141592653589793F, 0.0F);
        this.rightArmUpperChild = new ModelRenderer(this, 32, 6);
        this.rightArmUpperChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightArmUpperChild.addBox(-9.9F, 5.0F, 1.7000000000000002F, 4, 1, 0, 0.0F);
        this.setRotateAngle(rightArmUpperChild, 0.0F, -0.5235987755982988F, 0.0F);
        this.leftArmMiddleChild = new ModelRenderer(this, 24, 6);
        this.leftArmMiddleChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftArmMiddleChild.addBox(5.9F, 9.0F, 1.7F, 4, 1, 0, 0.0F);
        this.setRotateAngle(leftArmMiddleChild, 0.0F, 0.5235987755982988F, 0.0F);
        this.torsoLower = new ModelRenderer(this, 0, 26);
        this.torsoLower.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.torsoLower.addBox(-2.0F, 10.5F, -8.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(torsoLower, 0.5061454830783556F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -1.0F, -2.5F);
        this.Head.addBox(-3.0F, -2.0F, -3.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(Head, 0.33161255787892263F, 0.0F, 0.0F);
        this.leftArmLowerChild = new ModelRenderer(this, 24, 6);
        this.leftArmLowerChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftArmLowerChild.addBox(5.4F, 13.5F, -3.8F, 4, 1, 0, 0.0F);
        this.setRotateAngle(leftArmLowerChild, 0.0F, 0.5235987755982988F, 0.0F);
        this.leftArmMiddle = new ModelRenderer(this, 24, 7);
        this.leftArmMiddle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftArmMiddle.addBox(2.0F, 9.0F, -1.5F, 4, 1, 0, 0.0F);
        this.setRotateAngle(leftArmMiddle, 0.0F, -0.5235987755982988F, 0.0F);
        this.leftArmLower = new ModelRenderer(this, 24, 7);
        this.leftArmLower.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftArmLower.addBox(-1.2F, 13.5F, -6.0F, 4, 1, 0, 0.0F);
        this.setRotateAngle(leftArmLower, 0.0F, -0.5235987755982988F, 0.0F);
        this.leftArmUpperChild = new ModelRenderer(this, 24, 6);
        this.leftArmUpperChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftArmUpperChild.addBox(5.9F, 5.0F, 1.7F, 4, 1, 0, 0.0F);
        this.setRotateAngle(leftArmUpperChild, 0.0F, 0.5235987755982988F, 0.0F);
        this.rightArmMiddleChild = new ModelRenderer(this, 32, 6);
        this.rightArmMiddleChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightArmMiddleChild.addBox(-9.9F, 9.0F, 1.7F, 4, 1, 0, 0.0F);
        this.setRotateAngle(rightArmMiddleChild, 0.0F, -0.5235987755982988F, 0.0F);
        this.neck = new ModelRenderer(this, 17, 29);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-4.0F, 1.0F, -4.0F, 8, 3, 8, 0.0F);
        this.rightWingChild = new ModelRenderer(this, 24, 16);
        this.rightWingChild.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rightWingChild.addBox(-18.0F, -5.0F, 0.0F, 8, 12, 1, 0.0F);
        this.rightWing = new ModelRenderer(this, 42, 0);
        this.rightWing.setRotationPoint(-2.0F, 5.0F, -3.5F);
        this.rightWing.addBox(-10.0F, -5.0F, 0.0F, 10, 16, 1, 0.0F);
        this.leftArmUpper = new ModelRenderer(this, 24, 7);
        this.leftArmUpper.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftArmUpper.addBox(2.0F, 5.0F, -1.5F, 4, 1, 0, 0.0F);
        this.setRotateAngle(leftArmUpper, 0.0F, -0.5235987755982988F, 0.0F);
        this.rightArmUpper = new ModelRenderer(this, 24, 7);
        this.rightArmUpper.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightArmUpper.addBox(-6.0F, 5.0F, -1.5F, 4, 1, 0, 0.0F);
        this.setRotateAngle(rightArmUpper, 0.0F, 0.5235987755982988F, 0.0F);
        this.leftWing = new ModelRenderer(this, 42, 0);
        this.leftWing.mirror = true;
        this.leftWing.setRotationPoint(2.0F, 5.0F, -3.5F);
        this.leftWing.addBox(0.0F, -5.0F, 0.0F, 10, 16, 1, 0.0F);
        this.leftEar = new ModelRenderer(this, 24, 0);
        this.leftEar.setRotationPoint(2.0F, -1.0F, 1.0F);
        this.leftEar.addBox(-5.0F, -8.0F, -1.0F, 3, 6, 0, 0.0F);
        this.setRotateAngle(leftEar, 0.0F, 0.0F, -0.4363323129985824F);
        this.Head.addChild(this.rightEar);
        this.torso.addChild(this.rightArmMiddle);
        this.leftWing.addChild(this.leftWingChild);
        this.torsoLower.addChild(this.rightArmLower);
        this.rightArmLower.addChild(this.rightArmLowerChild);
        this.rightArmUpper.addChild(this.rightArmUpperChild);
        this.leftArmMiddle.addChild(this.leftArmMiddleChild);
        this.torso.addChild(this.torsoLower);
        this.leftArmLower.addChild(this.leftArmLowerChild);
        this.torso.addChild(this.leftArmMiddle);
        this.torsoLower.addChild(this.leftArmLower);
        this.leftArmUpper.addChild(this.leftArmUpperChild);
        this.rightArmMiddle.addChild(this.rightArmMiddleChild);
        this.torso.addChild(this.neck);
        this.rightWing.addChild(this.rightWingChild);
        this.torso.addChild(this.rightWing);
        this.torso.addChild(this.leftArmUpper);
        this.torso.addChild(this.rightArmUpper);
        this.torso.addChild(this.leftWing);
        this.Head.addChild(this.leftEar);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	this.torso.render(f5);
        this.Head.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    	this.Head.rotateAngleY = Utils.getDefaultHeadYaw(netHeadYaw);
    	float f1 = 0.6F * MathHelper.sin(ageInTicks * 1.0F + 2.0F);
    	this.rightWing.rotateAngleY = f1;
    	this.leftWing.rotateAngleY = -1.0F * f1;
    }
}
