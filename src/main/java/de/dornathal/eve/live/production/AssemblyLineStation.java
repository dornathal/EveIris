package de.dornathal.eve.live.production;

import de.dornathal.eve.live.database.RamAssemblyLineStations;
import de.dornathal.eve.live.map.Region;
import de.dornathal.eve.live.map.SolarSystem;
import de.dornathal.eve.live.map.Station;
import de.dornathal.eve.live.product.ProductType;

import javax.persistence.*;

@Entity
@Table(name = RamAssemblyLineStations.TABLE)
public class AssemblyLineStation {
	@Id
	@Column(name = RamAssemblyLineStations.STATION_ID)
	private int stationId;
	@OneToOne
	@JoinColumn(name = RamAssemblyLineStations.ASSEMBLY_LINE_TYPE_ID)
	private AssemblyLineType assemblyLineType;

	@OneToOne
	@JoinColumn(name = RamAssemblyLineStations.STATION_ID)
	private Station station;
	@OneToOne
	@JoinColumn(name = RamAssemblyLineStations.SOLAR_SYSTEM_ID)
	private SolarSystem solarSystem;
	@OneToOne
	@JoinColumn(name = RamAssemblyLineStations.STATION_TYPE_ID)
	private ProductType stationType;
	@OneToOne
	@JoinColumn(name = RamAssemblyLineStations.REGION_ID)
	private Region region;
	@Column(name = RamAssemblyLineStations.QUANTITY, columnDefinition = "TINYINT")
	private int assemblyLinesCount;

	public int getStationId() {
		return stationId;
	}

	public int getAssemblyLinesCount() {
		return assemblyLinesCount;
	}

	public Station getStation() {
		return station;
	}

	public AssemblyLineType getAssemblyLineType() {
		return assemblyLineType;
	}

	public SolarSystem getSolarSystem() {
		return solarSystem;
	}

	public Region getRegion() {
		return region;
	}

	public ProductType getStationType() {
		return stationType;
	}
}
