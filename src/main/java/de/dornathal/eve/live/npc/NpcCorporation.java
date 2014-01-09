package de.dornathal.eve.live.npc;

import de.dornathal.eve.live.Faction;
import de.dornathal.eve.live.Icon;
import de.dornathal.eve.live.database.CrpNPCCorporationTrades;
import de.dornathal.eve.live.database.CrpNPCCorporations;
import de.dornathal.eve.live.map.SolarSystem;
import de.dornathal.eve.live.product.ProductType;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = CrpNPCCorporations.TABLE)
public class NpcCorporation {

	@Id
	@Column(name = CrpNPCCorporations.CORPORATION_ID)
	private int npcCorporationId;
	@Enumerated(EnumType.STRING)
	@Column(name = CrpNPCCorporations.EXTENT, columnDefinition = "CHAR")
	private Extent extent;
	@Column(name = CrpNPCCorporations.DESCRIPTION)
	private String description;
	@OneToOne
	@JoinColumn(name = CrpNPCCorporations.FACTION_ID)
	private Faction faction;
	@OneToOne
	@JoinColumn(name = CrpNPCCorporations.FRIEND_ID)
	private NpcCorporation friendCorporation;
	@OneToOne
	@JoinColumn(name = CrpNPCCorporations.ENEMY_ID)
	private NpcCorporation enemyCorporation;
	@Column(name = CrpNPCCorporations.ICON_ID)
	private int iconId;
	@Column(name = CrpNPCCorporations.SIZE, columnDefinition = "CHAR")
	private char size;
	@Column(name = CrpNPCCorporations.SIZE_FACTOR)
	private double sizeFactor;
	@OneToOne
	@JoinColumn(name = CrpNPCCorporations.SOLAR_SYSTEM_ID)
	private SolarSystem solarSystem;
	@Column(name = CrpNPCCorporations.STATION_COUNT, columnDefinition = "SMALLINT")
	private int stationCount;
	@Column(name = CrpNPCCorporations.STATION_SYSTEM_COUNT, columnDefinition = "SMALLINT")
	private int stationSystemCount;
	@ManyToMany
	@JoinTable(name = CrpNPCCorporationTrades.TABLE,
			inverseJoinColumns = @JoinColumn(name = CrpNPCCorporationTrades.TYPE_ID),
			joinColumns = @JoinColumn(name = CrpNPCCorporationTrades.CORPORATION_ID))
	private Collection<ProductType> tradeProducts;

	public int getNpcCorporationId() {
		return npcCorporationId;
	}

	public String getDescription() {
		return description;
	}

	public Faction getFaction() {
		return faction;
	}

	public Icon getIcon() {
		return new Icon(Icon.IconType.Corporation, iconId);
	}

	public NpcCorporationSize getSize() {
		return NpcCorporationSize.getSize(size);
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

	public Extent getExtent() {
		return extent;
	}

	public NpcCorporation getFriendCorporation() {
		return friendCorporation;
	}

	public NpcCorporation getEnemyCorporation() {
		return enemyCorporation;
	}

	public Collection<ProductType> getTradeProducts() {
		return tradeProducts;
	}
}
