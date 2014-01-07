package de.dornathal.eve.live;

import de.dornathal.eve.live.database.EveUnits;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = EveUnits.TABLE)
public class Unit {
	@Id
	@Column(name = EveUnits.UNIT_ID, columnDefinition = "TINYINT")
	private int unitId;
	@Column(name = EveUnits.DESCRIPTION)
	private String description;
	@Column(name = EveUnits.DISPLAY_NAME)
	private String displayName;
	@Column(name = EveUnits.UNIT_NAME)
	private String name;

	public String getDescription() {
		return description;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getName() {
		return name;
	}

	public int getUnitId() {
		return unitId;
	}

}
