package de.dornathal.eve.live.production;

import de.dornathal.eve.live.database.RamAssemblyLines;

import javax.persistence.*;

@Entity
@Table(name = RamAssemblyLines.TABLE)
public class AssemblyLineGroup {

	@Id
	@Column(name = RamAssemblyLines.ASSEMBLY_LINE_ID)
	private int assemblyLineGroupId;
	@Column(name = RamAssemblyLines.COST_INSTALL, columnDefinition = "DOUBLE")
	private float costInstall;
	@Column(name = RamAssemblyLines.COST_PER_HOUR, columnDefinition = "DOUBLE")
	private float costPerHour;
	@Column(name = RamAssemblyLines.DISCOUNT_PER_GOOD_STANDING, columnDefinition = "DOUBLE")
	private float discountPerGoodStandingPoint;
	@Column(name = RamAssemblyLines.MAXIMUM_CHAR_SECURITY, columnDefinition = "DOUBLE")
	private float maximumCharacterSecurity;
	@Column(name = RamAssemblyLines.MAXIMUM_CORP_SECURITY, columnDefinition = "DOUBLE")
	private float maximumCorporationSecurity;
	@Column(name = RamAssemblyLines.MINIMUM_CHAR_SECURITY, columnDefinition = "DOUBLE")
	private float minimumCharacterSecurity;
	@Column(name = RamAssemblyLines.MINIMUM_CORP_SECURITY, columnDefinition = "DOUBLE")
	private float minimumCorporationSecurity;
	@Column(name = RamAssemblyLines.MINIMUM_STANDING, columnDefinition = "DOUBLE")
	private float minimumStanding;
	@Column(name = RamAssemblyLines.SURCHARGE_PER_BAD_STANDING_POINT, columnDefinition = "DOUBLE")
	private float surchargePerBadStandingPoint;
	@OneToOne
	@JoinColumn(name = RamAssemblyLines.ASSEMBLY_LINE_TYPE_ID, columnDefinition = "TINYINT")
	private AssemblyLineType lineType;
	@OneToOne
	@JoinColumn(name = RamAssemblyLines.CONTAINER_ID, columnDefinition = "TINYINT")
	private AssemblyLineStation station;

	public float getCostInstall() {
		return costInstall;
	}

	public float getCostPerHour() {
		return costPerHour;
	}

	public float getDiscountPerGoodStandingPoint() {
		return discountPerGoodStandingPoint;
	}

	public float getMaximumCharacterSecurity() {
		return maximumCharacterSecurity;
	}

	public float getMaximumCorporationSecurity() {
		return maximumCorporationSecurity;
	}

	public float getMinimumCharacterSecurity() {
		return minimumCharacterSecurity;
	}

	public float getMinimumCorporationSecurity() {
		return minimumCorporationSecurity;
	}

	public float getMinimumStanding() {
		return minimumStanding;
	}

	public float getSurchargePerBadStandingPoint() {
		return surchargePerBadStandingPoint;
	}

	public AssemblyLineType getAssemblyLineType() {
		return lineType;
	}

	public AssemblyLineStation getStation() {
		return station;
	}

	public int getAssemblyLineGroupId() {
		return assemblyLineGroupId;
	}

}
