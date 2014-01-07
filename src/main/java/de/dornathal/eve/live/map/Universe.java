package de.dornathal.eve.live.map;

import de.dornathal.eve.live.database.MapUniverse;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = MapUniverse.TABLE)
public class Universe {

	@Id
	@Column(name = MapUniverse.UNIVERSE_ID)
	private int universeId;
	@Column(name = MapUniverse.UNIVERSE_NAME)
	private String name;
	@Embedded
	private CelestialArea celestialArea;
	@Transient
	private Collection<Region> regions;

	public Collection<Region> getRegions() {
		return regions;
	}

	public int getUniverseId() {
		return universeId;
	}

	public CelestialArea getCelestialArea() {
		return celestialArea;
	}

	public String getName() {
		return name;
	}
}
