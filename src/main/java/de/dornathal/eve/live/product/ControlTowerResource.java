package de.dornathal.eve.live.product;

import de.dornathal.eve.live.Faction;
import de.dornathal.eve.live.database.InvControlTowerResources;

import javax.persistence.*;

@Entity
@Table(name = InvControlTowerResources.TABLE)
public class ControlTowerResource {
	@Id
	@Column(name = InvControlTowerResources.RESOURCE_TYPE_ID)
	private int resourceTypeId;
	@Transient
	//@JoinColumn(name = InvControlTowerResources.CONTROL_TOWER_TYPE_ID)
	private ControlTower controlTower;
	@OneToOne
	@JoinColumn(name = InvControlTowerResources.FACTION_ID)
	private Faction faction;
	@Column(name = InvControlTowerResources.MIN_SECURITY_LEVEL)
	private double minSecurityLevel;
	@Enumerated
	@Column(name = InvControlTowerResources.PURPOSE, columnDefinition = "TINYINT")
	private ControlTowerResourcePurpose purpose;
	@Column(name = InvControlTowerResources.QUANTITY)
	private int quantity;
	@Transient
	//@JoinColumn(name = InvControlTowerResources.RESOURCE_TYPE_ID)
	private ProductType requiredResource;

	public ControlTower getControlTower() {
		return controlTower;
	}

	public Faction getFaction() {
		return faction;
	}

	public double getMinSecurityLevel() {
		return minSecurityLevel;
	}

	public ControlTowerResourcePurpose getPurpose() {
		return purpose;
	}

	public int getQuantity() {
		return quantity;
	}

	public ProductType getRequiredResource() {
		return requiredResource;
	}

	public int getResourceTypeId() {
		return resourceTypeId;
	}

}
