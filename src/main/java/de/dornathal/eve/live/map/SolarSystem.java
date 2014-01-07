package de.dornathal.eve.live.map;

import de.dornathal.eve.live.Faction;
import de.dornathal.eve.live.database.MapSolarSystems;
import de.dornathal.eve.live.product.ProductType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = MapSolarSystems.TABLE)
public class SolarSystem {
	@Id
	@Column(name = MapSolarSystems.SOLAR_SYSTEM_ID)
	private int solarSystemId;
	@OneToOne
	@JoinColumn(name = MapSolarSystems.CONSTELLATION_ID)
	private Constellation constellation;
	@OneToOne
	@JoinColumn(name = MapSolarSystems.REGION_ID)
	private Region region;
	@Column(name = MapSolarSystems.SOLAR_SYSTEM_NAME)
	private String name;
	@Transient //ToDo SolarSystemJumps
	private List<SolarSystem> jumps;
	@Column(name = MapSolarSystems.SECURITY)
	private double security;
	@Embedded
	private CelestialArea celestialArea;
	@Column(name = MapSolarSystems.LUMINOSITY)
	private double luminosity;
	@Column(name = MapSolarSystems.BORDER)
	private boolean border;
	@Column(name = MapSolarSystems.FRINGE)
	private boolean fringe;
	@Column(name = MapSolarSystems.CORRIDOR)
	private boolean corridor;
	@Column(name = MapSolarSystems.HUB)
	private boolean hub;
	@Column(name = MapSolarSystems.INTERNATIONAL)
	private boolean international;
	@Column(name = MapSolarSystems.REGIONAL)
	private boolean regional;
	@Column(name = MapSolarSystems.CONSTELLATION)
	private boolean isConstellation;
	@OneToOne
	@JoinColumn(name = MapSolarSystems.SUN_TYPE_ID)
	private ProductType sunType;
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = MapSolarSystems.SECURITY_CLASS)
	private SecurityClass securityClass;
	@OneToOne
	@JoinColumn(name = MapSolarSystems.FACTION_ID)
	private Faction faction;

	public Faction getFaction() {
		return faction;
	}

	public Constellation getConstellation() {
		return constellation;
	}

	public List<SolarSystem> getJumps() {
		return jumps;
	}

	public double getSecurity() {
		return security;
	}

	public int getSolarSystemId() {
		return solarSystemId;
	}

	public Region getRegion() {
		return region;
	}

	public String getName() {
		return name;
	}

	public CelestialArea getCelestialArea() {
		return celestialArea;
	}

	public double getLuminosity() {
		return luminosity;
	}

	public boolean isBorder() {
		return border;
	}

	public boolean isFringe() {
		return fringe;
	}

	public boolean isCorridor() {
		return corridor;
	}

	public boolean isHub() {
		return hub;
	}

	public boolean isInternational() {
		return international;
	}

	public boolean isRegional() {
		return regional;
	}

	public boolean isConstellation() {
		return isConstellation;
	}

	public ProductType getSunType() {
		return sunType;
	}

	public SecurityClass getSecurityClass() {
		return (securityClass != null) ? securityClass : SecurityClass.Unspecified;
	}
}
