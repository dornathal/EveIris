package de.dornathal.eve.live;

import de.dornathal.eve.live.attributes.AttributeType;
import de.dornathal.eve.live.map.*;
import de.dornathal.eve.live.npc.Agent;
import de.dornathal.eve.live.npc.NpcCorporation;
import de.dornathal.eve.live.planetary.Schematic;
import de.dornathal.eve.live.product.*;
import de.dornathal.eve.live.production.AssemblyLineGroup;
import de.dornathal.eve.live.production.AssemblyLineType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Collection;
import java.util.List;

public class DataCore {
	private static DataCore dataCore;
	private final SessionFactory sessionFactory;
	private Collection<Agent> agents;
	private Collection<AssemblyLineGroup> assemblyLines;
	private Collection<AssemblyLineType> assemblyLineTypes;
	private Collection<Attribute> attributes;
	private Collection<AttributeType> attributeTypes;
	private Collection<Category> categories;
	private Collection<Celestial> celestials;
	private Collection<Constellation> constellations;
	private Collection<Contraband> contrabands;
	private Collection<ControlTower> controlTowers;
	private Collection<Faction> factions;
	private Collection<Graphic> graphics;
	private Collection<Group> groups;
	private Collection<Icon> icons;
	private Collection<MarketGroup> marketGroups;
	private Collection<NpcCorporation> npcCorporations;
	private Collection<NpcCorporation> npcCorporationsManager;
	private Collection<ProductType> productTypes;
	private Collection<Race> races;
	private Collection<Region> regions;
	private Collection<Schematic> schematics;
	private Collection<SolarSystem> solarSystems;
	private Collection<Station> stations;
	private Collection<Unit> units;
	private Collection<Universe> universes;

	private DataCore() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static DataCore getInstance() {
		if( dataCore == null ){
			dataCore = new DataCore();
		}
		return dataCore;
	}

	public void deleteReferenceTables() {
		throw new UnsupportedOperationException();
	}

	public Agent findAgent(int id) {
		Session session = sessionFactory.openSession();
		Agent agent = (Agent) session.get(Agent.class, id);
		session.close();
		return agent;
	}

	public AssemblyLineGroup findAssemblyLineGroup(int id) {
		Session session = sessionFactory.openSession();
		AssemblyLineGroup assemblyLineGroup = (AssemblyLineGroup) session.get(AssemblyLineGroup.class, id);
		session.close();
		return assemblyLineGroup;
	}

	public AssemblyLineType findAssemblyLineType(int id) {
		Session session = sessionFactory.openSession();
		AssemblyLineType assemblyLineType = (AssemblyLineType) session.get(AssemblyLineType.class, id);
		session.close();
		return assemblyLineType;
	}

	public AttributeType findAttributeType(int id) {
		Session session = sessionFactory.openSession();
		AttributeType attributeType = (AttributeType) session.get(AttributeType.class, id);
		session.close();
		return attributeType;
	}

	public Category findCategory(int id) {
		Session session = sessionFactory.openSession();
		Category category = (Category) session.get(Category.class, id);
		session.close();
		return category;
	}

	public Celestial findCelestial(int id) {
		Session session = sessionFactory.openSession();
		Celestial celestial = (Celestial) session.get(Celestial.class, id);
		session.close();
		return celestial;
	}

	public Constellation findConstellation(final int id) {
		Session session = sessionFactory.openSession();
		Constellation constellation = (Constellation) session.get(Constellation.class, id);
		session.close();
		return constellation;
	}

	public ControlTower findControlTower(int id) {
		Session session = sessionFactory.openSession();
		ControlTower controlTower = (ControlTower) session.get(ControlTower.class, id);
		session.close();
		return controlTower;
	}

	public Faction findFaction(int id) {
		Session session = sessionFactory.openSession();
		Faction faction = (Faction) session.get(Faction.class, id);
		session.close();
		return faction;
	}

	public Graphic findGraphic(int id) {
		Session session = sessionFactory.openSession();
		Graphic graphic = (Graphic) session.get(Graphic.class, id);
		session.close();
		return graphic;
	}

	public Group findGroup(int id) {
		Session session = sessionFactory.openSession();
		Group group = (Group) session.get(Group.class, id);
		session.close();
		return group;
	}

	public Icon findIcon(int id) {
		Session session = sessionFactory.openSession();
		Icon icon = (Icon) session.get(Icon.class, id);
		session.close();
		return icon;
	}

	public NpcCorporation findNpcCorporation(final int id) {
		Session session = sessionFactory.openSession();
		NpcCorporation npcCorporation = (NpcCorporation) session.get(NpcCorporation.class, id);
		session.close();
		return npcCorporation;
	}

	public BlueprintType findBlueprintType(final int id) {
		Session session = sessionFactory.openSession();
		BlueprintType blueprintType = (BlueprintType) session.get(BlueprintType.class, id);
		session.close();
		return blueprintType;

	}

	public ProductType findProductType(int id) {
		Session session = sessionFactory.openSession();
		ProductType productType = (ProductType) session.get(ProductType.class, id);
		session.close();
		return productType;
	}

	public Race findRace(int id) {
		Session session = sessionFactory.openSession();
		Race race = (Race) session.get(Race.class, id);
		session.close();
		return race;
	}

	public Region findRegion(int id) {
		Session session = sessionFactory.openSession();
		Region region = (Region) session.get(Region.class, id);
		session.close();
		return region;
	}

	public Schematic findSchematic(int id) {
		Session session = sessionFactory.openSession();
		Schematic schematic = (Schematic) session.get(Schematic.class, id);
		session.close();
		return schematic;
	}

	public SolarSystem findSolarSystem(int id) {
		Session session = sessionFactory.openSession();
		SolarSystem solarSystem = (SolarSystem) session.get(SolarSystem.class, id);
		session.close();
		return solarSystem;
	}

	public Station findStation(int id) {
		Session session = sessionFactory.openSession();
		Station station = (Station) session.get(Station.class, id);
		session.close();
		return station;
	}

	public Unit findUnit(int id) {
		Session session = sessionFactory.openSession();
		Unit agent = (Unit) session.get(Unit.class, id);
		session.close();
		return agent;
	}


	public List<MarketGroup> getMarketGroupChildren(MarketGroup parent) {
		return null;
	}

	public List<ProductType> getMarketGroupProductTypes(MarketGroup parent) {
		return null;
	}

	public void OptimizeMemory() {

	}

}
