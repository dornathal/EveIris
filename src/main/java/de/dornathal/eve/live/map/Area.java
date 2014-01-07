package de.dornathal.eve.live.map;

import de.dornathal.eve.live.database.MapArea;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Area {

	@AttributeOverrides({ @AttributeOverride(name = "x", column = @Column(name = MapArea.X_MIN)), @AttributeOverride(name = "y", column = @Column(name = MapArea.Y_MIN)), @AttributeOverride(name = "z", column = @Column(name = MapArea.Z_MIN)) })
	Coordinate minLocation;
	@AttributeOverrides({ @AttributeOverride(name = "x", column = @Column(name = MapArea.X_MAX)), @AttributeOverride(name = "y", column = @Column(name = MapArea.Y_MAX)), @AttributeOverride(name = "z", column = @Column(name = MapArea.Z_MAX)) })
	Coordinate maxLocation;

	public Area() {

	}

	public Area(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		this(new Coordinate(minX, minY, minZ), new Coordinate(maxX, maxY, maxZ));
	}

	public Area(Coordinate minLocation, Coordinate maxLocation) {
		this.maxLocation = maxLocation;
		this.minLocation = minLocation;
	}

	public double getSizeX() {
		return Math.abs(maxLocation.getX() - minLocation.getX());
	}

	public double getSizeY() {
		return Math.abs(maxLocation.getY() - minLocation.getY());
	}

	public double getSizeZ() {
		return Math.abs(maxLocation.getZ() - minLocation.getZ());
	}

	public boolean Contains(Area area) {
		throw new UnsupportedOperationException();
	}

	public boolean Contains(Coordinate coordinate) {
		throw new UnsupportedOperationException();
	}
}
