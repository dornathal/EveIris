package de.dornathal.eve.live.map;

import de.dornathal.eve.live.Faction;
import de.dornathal.eve.live.database.MapRegions;

import javax.persistence.*;

@Entity
@Table(name = MapRegions.TABLE)
public class Region {
	@Id
	@Column(name = MapRegions.REGION_ID)
	private int regionId;
	@Column(name = MapRegions.REGION_NAME)
	private String name;
	@Embedded
	private CelestialArea celestialArea;
	@OneToOne
	@JoinColumn(name = MapRegions.FACTION_ID)
	private Faction faction;

	public Faction getFaction() {
		return faction;
	}

	public int getRegionId() {
		return regionId;
	}

	public String getName() {
		return name;
	}

	public CelestialArea getCelestialArea() {
		return celestialArea;
	}
}
