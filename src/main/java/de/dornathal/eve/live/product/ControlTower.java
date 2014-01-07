package de.dornathal.eve.live.product;

import de.dornathal.eve.live.database.InvTypes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = InvTypes.TABLE)
@DiscriminatorColumn(name = InvTypes.GROUP_ID, discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("365")
public class ControlTower extends ProductType {

	//@OneToMany(mappedBy="controlTower")
	@Transient
	private List<ControlTowerResource> resourcesNeeded;

	public List<ControlTowerResource> getResourcesNeeded() {
		return resourcesNeeded;
	}

	public void setResourcesNeeded(final List<ControlTowerResource> resourcesNeeded) {
		this.resourcesNeeded = resourcesNeeded;
	}
}
