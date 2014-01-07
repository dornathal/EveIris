package de.dornathal.eve.live.product;

import de.dornathal.eve.live.core.TimeFactory;
import de.dornathal.eve.live.database.InvBlueprintTypes;

import javax.persistence.*;
import javax.xml.datatype.Duration;
import java.util.List;

@Entity
@Table(name = InvBlueprintTypes.TABLE)
public class BlueprintType {

	@Id
	@Column(name = InvBlueprintTypes.BLUEPRINT_TYPE_ID)
	private int blueprintTypeId;
	@Transient //Todo ActivityUsage
	private List<ActivityUsage> activities;
	@Transient //Todo ActivityUsage
	private List<ActivityUsage> manufacturingAdvancedMaterials;
	@Transient //Todo ProductMaterial
	private List<ProductMaterial> manufacturingBaseMaterials;
	@Transient //Todo ProductMaterial
	private List<ProductMaterial> manufacturingBaseMaterialsAtBaseWasteFactor;
	@Column(name = InvBlueprintTypes.MATERIAL_MODIFIER, columnDefinition = "SMALLINT")
	private double materialModifier;
	@Column(name = InvBlueprintTypes.MAX_PRODUCTION_LIMIT)
	private int maxProductionLimit;
	@OneToOne
	@JoinColumn(name = InvBlueprintTypes.PRODUCT_TYPE_ID)
	private ProductType product;
	@OneToOne
	@JoinColumn(name = InvBlueprintTypes.PARENT_BLUEPRINT_TYPE_ID)
	private BlueprintType parentBlueprint;
	@Column(name = InvBlueprintTypes.PRODUCTION_TIME)
	private int productionTime;
	@Column(name = InvBlueprintTypes.PRODUCTIVITY_MODIFIER)
	private int productivityModifier;
	@Column(name = InvBlueprintTypes.RESEARCH_PRODUCTIVITY_TIME)
	private int researchProductivityTime;
	@Column(name = InvBlueprintTypes.RESEARCH_COPY_TIME)
	private int researchCopyTime;
	@Column(name = InvBlueprintTypes.RESEARCH_MATERIAL_TIME)
	private int researchMaterialTime;
	@Column(name = InvBlueprintTypes.RESEARCH_TECH_TIME)
	private int researchTechTime;
	@Column(name = InvBlueprintTypes.TECH_LEVEL)
	private short techLevel;
	@Column(name = InvBlueprintTypes.WASTE_FACTOR)
	private short wasteFactor;

	public List<ProductMaterial> manufacturingAddWaste(List<ProductMaterial> materialList, double wasteFactor) {
		throw new UnsupportedOperationException();
	}

	public List<ProductMaterial> manufacturingAddWaste(List<ProductMaterial> materialList, double baseWasteFactor, int materialLevel) {
		throw new UnsupportedOperationException();
	}

	public List<ProductMaterial> manufacturingAddWaste(List<ProductMaterial> materialList, double baseWasteFactor, int materialLevel, int productionEfficiemcy) {
		throw new UnsupportedOperationException();
	}

	public List<ActivityUsage> getActivities() {
		return activities;
	}

	public List<ActivityUsage> getManufacturingAdvancedMaterials() {
		return manufacturingAdvancedMaterials;
	}

	public List<ProductMaterial> getManufacturingBaseMaterials() {
		return manufacturingBaseMaterials;
	}

	public List<ProductMaterial> getManufacturingBaseMaterialsAtBaseWasteFactor() {
		return manufacturingBaseMaterialsAtBaseWasteFactor;
	}

	public double getMaterialModifier() {
		return materialModifier;
	}

	public int getMaxProductionLimit() {
		return maxProductionLimit;
	}

	public ProductType getProduct() {
		return product;
	}

	public Duration getProductionTime() {
		return TimeFactory.getDuration(productionTime);
	}


	public double getProductivityModifier() {
		return productivityModifier;
	}


	public Duration getResearchProductivityTime() {
		return TimeFactory.getDuration(researchProductivityTime);
	}

	public Duration getResearchCopyTime() {
		return TimeFactory.getDuration(researchCopyTime);
	}

	public Duration getResearchMaterialTime() {
		return TimeFactory.getDuration(researchMaterialTime);
	}

	public Duration getResearchTechTime() {
		return TimeFactory.getDuration(researchTechTime);
	}

	public short getTechLevel() {
		return techLevel;
	}

	public short getWasteFactor() {
		return wasteFactor;
	}

	public int getBlueprintTypeId() {
		return blueprintTypeId;
	}

	public BlueprintType getParentBlueprint() {
		return parentBlueprint;
	}
}
