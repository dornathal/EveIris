package de.dornathal.eve.live.map;

import de.dornathal.eve.live.database.MapRegions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class CelestialArea {
	@Embedded
	private Area area;

	@Embedded
	private Coordinate location;
	@Column(name = MapRegions.RADIUS)
	private double radius;

	public Area getArea() {
		return area;
	}


	public Coordinate getLocation() {
		return location;
	}

	public double getRadius() {
		return radius;
	}

}
