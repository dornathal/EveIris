package de.dornathal.eve.live.map;

import de.dornathal.eve.live.database.MapConstellations;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Coordinate {

	@Column(name = MapConstellations.X)
	protected double x;
	@Column(name = MapConstellations.Y)
	protected double y;
	@Column(name = MapConstellations.Z)
	protected double z;

	public Coordinate() {

	}

	public Coordinate(final float x, final float y, final float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

}
