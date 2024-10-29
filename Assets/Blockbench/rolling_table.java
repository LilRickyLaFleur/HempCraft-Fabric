// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class rolling_table extends EntityModel<rolling_table> {
	private final ModelPart Legs;
	private final ModelPart Struts;
	private final ModelPart Lips;
	private final ModelPart Skirts;
	private final ModelPart BudBottle;
	private final ModelPart Joint;
	private final ModelPart Joint2;
	private final ModelPart bb_main;
	public rolling_table(ModelPart root) {
		this.Legs = root.getChild("Legs");
		this.Struts = root.getChild("Struts");
		this.Lips = root.getChild("Lips");
		this.Skirts = root.getChild("Skirts");
		this.BudBottle = root.getChild("BudBottle");
		this.Joint = root.getChild("Joint");
		this.Joint2 = root.getChild("Joint2");
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Legs = modelPartData.addChild("Legs", ModelPartBuilder.create().uv(0, 18).cuboid(6.0F, -13.0F, -8.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F))
		.uv(8, 18).cuboid(-8.0F, -13.0F, -8.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F))
		.uv(16, 18).cuboid(-8.0F, -13.0F, 6.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F))
		.uv(24, 18).cuboid(6.0F, -13.0F, 6.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Struts = modelPartData.addChild("Struts", ModelPartBuilder.create().uv(0, 34).cuboid(-6.0F, -5.0F, -8.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 34).cuboid(-6.0F, -5.0F, 6.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Strut_r1 = Struts.addChild("Strut_r1", ModelPartBuilder.create().uv(0, 34).cuboid(-6.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -3.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData Strut_r2 = Struts.addChild("Strut_r2", ModelPartBuilder.create().uv(0, 34).cuboid(-6.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(7.0F, -3.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData Lips = modelPartData.addChild("Lips", ModelPartBuilder.create().uv(0, 38).cuboid(-8.0F, -16.0F, -8.0F, 16.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 38).cuboid(-8.0F, -16.0F, 7.0F, 16.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Lip_r1 = Lips.addChild("Lip_r1", ModelPartBuilder.create().uv(1, 38).cuboid(-7.0F, -1.0F, -1.0F, 14.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -15.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData Lip_r2 = Lips.addChild("Lip_r2", ModelPartBuilder.create().uv(1, 38).cuboid(-7.0F, -1.0F, -1.0F, 14.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -15.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData Skirts = modelPartData.addChild("Skirts", ModelPartBuilder.create().uv(0, 40).cuboid(7.0F, -13.0F, -6.0F, 1.0F, 8.0F, 12.0F, new Dilation(0.0F))
		.uv(0, 40).cuboid(-8.0F, -13.0F, -6.0F, 1.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData SkirtSide_r1 = Skirts.addChild("SkirtSide_r1", ModelPartBuilder.create().uv(0, 40).cuboid(0.0F, -7.0F, -6.0F, 1.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData SkirtSide_r2 = Skirts.addChild("SkirtSide_r2", ModelPartBuilder.create().uv(0, 40).cuboid(0.0F, -7.0F, -6.0F, 1.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, -7.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData BudBottle = modelPartData.addChild("BudBottle", ModelPartBuilder.create().uv(-3, -2).cuboid(16.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 7).cuboid(17.0F, -6.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 10).cuboid(17.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 10).cuboid(17.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 10).cuboid(18.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-19.0F, 18.0F, 0.0F));

		ModelPartData Joint = modelPartData.addChild("Joint", ModelPartBuilder.create().uv(0, 42).cuboid(13.0F, -1.0F, -1.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 40).cuboid(13.0F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-11.0F, 18.0F, -1.0F));

		ModelPartData Joint2 = modelPartData.addChild("Joint2", ModelPartBuilder.create().uv(0, 42).cuboid(13.0F, -1.0F, -1.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 40).cuboid(13.0F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-9.0F, 18.0F, -1.0F));

		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -15.0F, -8.0F, 16.0F, 2.0F, 16.0F, new Dilation(0.0F))
		.uv(10, 11).cuboid(-8.0F, -6.0F, -3.0F, 16.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(rolling_table entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Legs.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Struts.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Lips.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Skirts.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		BudBottle.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Joint.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Joint2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}