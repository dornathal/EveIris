package de.dornathal.eve.live.map;

import de.dornathal.eve.live.Faction;
import de.dornathal.eve.live.database.MapConstellations;

import javax.persistence.*;

@Entity
@Table(name = MapConstellations.TABLE)
public class Constellation {

	@Id
	@Column(name = MapConstellations.CONSTELLATION_ID)
	private int constellationId;
	@OneToOne
	@JoinColumn(name = MapConstellations.REGION_ID)
	private Region region;
	@Column(name = MapConstellations.CONSTELLATION_NAME)
	private String name;
	@Embedded
	private CelestialArea celestialArea;
	@OneToOne
	@JoinColumn(name = MapConstellations.FACTION_ID)
	private Faction faction;

	public Faction getFaction() {
		return faction;
	}

	public Region getRegion() {
		return region;
	}

	public int getConstellationId() {
		return constellationId;
	}

	public String getName() {
		return name;
	}

	public CelestialArea getCelestialArea() {
		return celestialArea;
	}
}
