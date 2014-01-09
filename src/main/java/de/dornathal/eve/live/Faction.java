package de.dornathal.eve.live;

import de.dornathal.eve.live.database.ChrFactions;
import de.dornathal.eve.live.map.SolarSystem;
import de.dornathal.eve.live.npc.NpcCorporation;

import javax.persistence.*;

@Entity
@Table(name = ChrFactions.TABLE)
public class Faction {

	@Id
	@Column(name = ChrFactions.FACTION_ID)
	private int factionId;
	@OneToOne
	@JoinColumn(name = ChrFactions.CORPORATION_ID)
	private NpcCorporation corporation;
	@OneToOne
	@JoinColumn(name = ChrFactions.MILITIA_CORPORATION_ID)
	private NpcCorporation militiaCorporation;
	@Column(name = ChrFactions.FACTION_NAME)
	private String name;
	@Column(name = ChrFactions.DESCRIPTION)
	private String description;
	@Column(name = ChrFactions.ICON_ID)
	private int iconId;
	//@OneToOne
	//@JoinColumn(name = ChrFactions.RACE_IDS)
	@Transient
	private Race race = new Race();
	@Column(name = ChrFactions.SIZE_FACTOR)
	private double sizeFactor;
	@OneToOne
	@JoinColumn(name = ChrFactions.SOLAR_SYSTEM_ID)
	private SolarSystem solarSystem;
	@Column(name = ChrFactions.STATION_COUNT, columnDefinition = "SMALLINT")
	private int stationCount;
	@Column(name = ChrFactions.STATION_SYSTEM_COUNT, columnDefinition = "SMALLINT")
	private int stationSystemCount;

	public NpcCorporation getCorporation() {
		return corporation;
	}

	public NpcCorporation getMilitiaCorporation() {
		return militiaCorporation;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Icon getIcon() {
		return new Icon(Icon.IconType.Corporation, iconId);
	}

	public Race getRace() {
		return race;
	}

	public double getSizeFactor() {
		return sizeFactor;
	}

	public SolarSystem getSolarSystem() {
		return solarSystem;
	}

	public int getStationCount() {
		return stationCount;
	}

	public int getStationSystemCount() {
		return stationSystemCount;
	}

	public int getFactionId() {
		return factionId;
	}

}
