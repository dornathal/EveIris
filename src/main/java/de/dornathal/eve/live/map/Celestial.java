package de.dornathal.eve.live.map;

import de.dornathal.eve.live.database.MapCelestialStatistics;
import de.dornathal.eve.live.product.ProductType;

import javax.persistence.*;

@Entity
@Table(name = MapCelestialStatistics.TABLE)
public class Celestial {
	@Id
	@Column(name = MapCelestialStatistics.ITEM_ID)
	private int celestialId;
	@Embedded
	private Coordinate location;
	@Column(name = MapCelestialStatistics.ITEM_NAME)
	private String name;
	@Column(name = MapCelestialStatistics.RADIUS)
	private double radius;
	@Transient
	private SolarSystem solarSystem;
	@Column(name = MapCelestialStatistics.ITEM_ID)
	private ProductType productType;

	public Coordinate getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public double getRadius() {
		return radius;
	}

	public SolarSystem getSolarSystem() {
		return solarSystem;
	}

	public ProductType getProductType() {
		return productType;
	}

	public int getCelestialId() {
		return celestialId;
	}

}
