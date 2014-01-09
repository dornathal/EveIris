package de.dornathal.eve.live;

import de.dornathal.eve.live.database.ChrRaces;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = ChrRaces.TABLE)
public class Race {
	@Id
	@Column(name = ChrRaces.RACE_ID, columnDefinition = "TINYINT")
	private int raceId;
	@Column(name = ChrRaces.RACE_NAME)
	private String name;
	@Column(name = ChrRaces.DESCRIPTION)
	private String description;
	@Column(name = ChrRaces.ICON_ID)
	private int iconId;
	@Column(name = ChrRaces.SHORT_DESCRIPTION)
	private String shortDescription;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getIcon() {
		return iconId;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public int getRaceId() {
		return raceId;
	}

}
