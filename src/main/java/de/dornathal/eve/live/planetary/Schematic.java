package de.dornathal.eve.live.planetary;


import de.dornathal.eve.live.core.TimeFactory;
import de.dornathal.eve.live.database.PlanetSchematics;
import de.dornathal.eve.live.database.PlanetSchematicsPinMap;
import de.dornathal.eve.live.database.PlanetSchematicsTypeMap;
import de.dornathal.eve.live.product.ProductType;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.xml.datatype.Duration;
import java.util.List;

@Entity
@Table(name = PlanetSchematics.TABLE)
public class Schematic {
	@Id
	@Column(name = PlanetSchematics.SCHEMATIC_ID, columnDefinition = "SMALLINT")
	private int schematicId;
	@Column(name = PlanetSchematics.CYCLE_TIME)
	private int cycleTime;
	@OneToMany(mappedBy = "embeddedId.schematicId")
	@Where(clause = PlanetSchematicsTypeMap.IS_INPUT + "=1")
	private List<ResourceSet> input;
	@OneToMany(mappedBy = "embeddedId.schematicId")
	@Where(clause = PlanetSchematicsTypeMap.IS_INPUT + "=0")
	private List<ResourceSet> output;
	@Column(name = PlanetSchematics.SCHEMATIC_NAME)
	private String name;
	@ManyToMany
	@JoinTable(name = PlanetSchematicsPinMap.TABLE,
			inverseJoinColumns = @JoinColumn(name = PlanetSchematicsPinMap.PIN_TYPE_ID),
			joinColumns = @JoinColumn(name = PlanetSchematicsPinMap.SCHEMATIC_ID, columnDefinition = "SMALLINT"))
	private List<ProductType> pins;

	public Duration getCycleTime() {
		return TimeFactory.getDuration(cycleTime);
	}

	public List<ResourceSet> getInput() {
		return input;
	}

	public List<ResourceSet> getOutput() {
		return output;
	}

	public String getName() {
		return name;
	}

	public List<ProductType> getPins() {
		return pins;
	}

	public int getSchematicId() {
		return schematicId;
	}

}
