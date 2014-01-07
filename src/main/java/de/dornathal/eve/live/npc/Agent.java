package de.dornathal.eve.live.npc;

import de.dornathal.eve.live.DataCore;
import de.dornathal.eve.live.core.UniqueName;
import de.dornathal.eve.live.database.AgtAgents;
import de.dornathal.eve.live.map.SolarSystem;
import de.dornathal.eve.live.map.Station;
import de.dornathal.eve.live.product.ProductType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = AgtAgents.TABLE)
public class Agent {

	@Id
	@Column(name = AgtAgents.AGENT_ID)
	private int agentId;
	@OneToOne
	@JoinColumn(name = AgtAgents.CORPORATION_ID)
	private NpcCorporation corporation;
	@Enumerated
	@Column(name = AgtAgents.DIVISION_ID, columnDefinition = "TINYINT")
	private Division division;
	@OneToOne
	@JoinColumn(name = AgtAgents.AGENT_ID)
	private UniqueName uniqueName;
	@Column(name = AgtAgents.QUALITY, columnDefinition = "SMALLINT")
	private int quality;
	@Column(name = AgtAgents.LEVEL, columnDefinition = "TINYINT")
	private int level;
	@Column(name = AgtAgents.IS_LOCATOR)
	private boolean isLocator;
	@Transient
	private List<ProductType> researchFields;
	@Column(name = AgtAgents.LOCATION_ID)
	private int locationId;
	@Column(name = AgtAgents.AGENT_TYPE_ID)
	@Enumerated()
	private AgentType agentType;

	public int getAgentId() {
		return agentId;
	}

	public NpcCorporation getCorporation() {
		return corporation;
	}

	UniqueName getUniqueName() {
		return uniqueName;
	}

	public String getName() {
		return uniqueName.getName();
	}

	public int getQuality() {
		return quality;
	}

	public List<ProductType> getResearchFields() {
		return researchFields;
	}

	public SolarSystem getSolarSystem() {
		if( locationId < 40000000 ) return DataCore.getInstance().findSolarSystem(locationId);
		return getStation().getSolarSystem();
	}

	public Station getStation() {

		if( locationId > 60000000 ) return DataCore.getInstance().findStation(locationId);
		return null;

	}

	public AgentType getAgentType() {
		return agentType;
	}

	public int getLevel() {
		return level;
	}

	public boolean isLocator() {
		return isLocator;
	}

	public Division getDivision() {
		return division;
	}
}
