package de.dornathal.eve.live.map;


import de.dornathal.eve.live.database.StaStations;
import de.dornathal.eve.live.npc.NpcCorporation;
import de.dornathal.eve.live.product.ProductType;
import de.dornathal.eve.live.spacestation.StationServices;

import javax.persistence.*;

@Entity
@Table(name = StaStations.TABLE)
public class Station {
	@Id
	@Column(name = StaStations.STATION_ID)
	private int stationId;
	@Embedded
	private Coordinate location;
	@Column(name = StaStations.STATION_NAME)
	private String Name;
	@OneToOne
	@JoinColumn(name = StaStations.CORPORATION_ID)
	private NpcCorporation npcCorporation;
	@Column(name = StaStations.REPROCESSING_EFFICIENCY)
	private double reprocessingEfficiency;
	@Column(name = StaStations.REPROCESSING_STATIONS_TAKE)
	private double reprocessingStationsTake;
	@Enumerated
	@Transient
	private StationServices services;
	@OneToOne
	@JoinColumn(name = StaStations.SOLAR_SYSTEM_ID)
	private SolarSystem solarSystem;
	@OneToOne
	@JoinColumn(name = StaStations.CONSTELLATION_ID)
	private Constellation constellation;
	@OneToOne
	@JoinColumn(name = StaStations.REGION_ID)
	private Region region;
	@OneToOne
	@JoinColumn(name = StaStations.STATION_TYPE_ID)
	private ProductType stationType;

	@Column(name = StaStations.SECURITY, columnDefinition = "SMALLINT")
	private int security;
	@Column(name = StaStations.DOCKING_COST_PER_VOLUME)
	private double dockingCostPerVolume;
	@Column(name = StaStations.MAX_SHIP_VOLUME_DOCKABLE)
	private double maxShipVolumeDockable;
	@Column(name = StaStations.OFFICE_RENTAL_COST)
	private int officeRentalCost;
	@OneToOne
	@JoinColumn(name = StaStations.OPERATION_ID, columnDefinition = "TINYINT")
	private Operation operation;

	public Station() {}

	public Coordinate getLocation() {
		return location;
	}

	public String getName() {
		return Name;
	}

	public NpcCorporation getNpcCorporation() {
		return npcCorporation;
	}

	public double getReprocessingEfficiency() {
		return reprocessingEfficiency;
	}

	public double getReprocessingStationsTake() {
		return reprocessingStationsTake;
	}

	public StationServices getServices() {
		return services;
	}

	public SolarSystem getSolarSystem() {
		return solarSystem;
	}

	public ProductType getStationType() {
		return stationType;
	}

	public int getStationId() {
		return stationId;
	}

	public Constellation getConstellation() {
		return constellation;
	}

	public Region getRegion() {
		return region;
	}

	public int getSecurity() {
		return security;
	}

	public double getDockingCostPerVolume() {
		return dockingCostPerVolume;
	}

	public double getMaxShipVolumeDockable() {
		return maxShipVolumeDockable;
	}

	public int getOfficeRentalCost() {
		return officeRentalCost;
	}

	public Operation getOperation() {
		return operation;
	}
}
