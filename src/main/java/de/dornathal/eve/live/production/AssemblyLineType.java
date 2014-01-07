package de.dornathal.eve.live.production;

import de.dornathal.eve.live.database.RamAssemblyLineTypes;

import javax.persistence.*;

@Entity
@Table(name = RamAssemblyLineTypes.TABLE)
public class AssemblyLineType {
	@Id
	@Column(name = RamAssemblyLineTypes.ASSEMBLY_LINE_TYPE_ID, columnDefinition = "TINYINT")
	private int assemblyLineTypeId;
	@Column(name = RamAssemblyLineTypes.ACTIVITY_ID, columnDefinition = "TINYINT")
	@Enumerated
	private Activity activity;
	@Column(name = RamAssemblyLineTypes.BASE_MATERIAL_MULTIPLIER)
	private double baseMaterialMultiplier;
	@Column(name = RamAssemblyLineTypes.BASE_TIME_MULTIPLIER)
	private double baseTimeMultiplier;
	@Column(name = RamAssemblyLineTypes.ASSEMBLY_LINE_TYPE_NAME)
	private String name;
	@Column(name = RamAssemblyLineTypes.DESCRIPTION)
	private String description;
	@Column(name = RamAssemblyLineTypes.MIN_COST_PER_HOUR)
	private Double minimumCostPerHour;
	@Column(name = RamAssemblyLineTypes.VOLUME)
	private double volume;

	public Activity getActivity() {
		return activity;
	}

	public double getBaseMaterialMultiplier() {
		return baseMaterialMultiplier;
	}

	public double getBaseTimeMultiplier() {
		return baseTimeMultiplier;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getMinimumCostPerHour() {
		return minimumCostPerHour;
	}

	public double getVolume() {
		return volume;
	}

	public int getAssemblyLineTypeId() {
		return assemblyLineTypeId;
	}

}
