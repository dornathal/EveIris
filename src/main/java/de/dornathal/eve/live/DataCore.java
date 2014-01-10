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

public class DataCore {
	private static DataCore dataCore;
	private final Session session;

	private DataCore() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
	}

	public static DataCore getInstance() {
		if( dataCore == null ){
			dataCore = new DataCore();
		}
		return dataCore;
	}

	@Override
	protected void finalize() throws Throwable {
		session.close();
		super.finalize();
	}

	public void deleteReferenceTables() {
		throw new UnsupportedOperationException();
	}

	public Agent findAgent(int id) {
		return (Agent) session.get(Agent.class, id);
	}

	public AssemblyLineGroup findAssemblyLineGroup(int id) {
		return (AssemblyLineGroup) session.get(AssemblyLineGroup.class, id);
	}

	public AssemblyLineType findAssemblyLineType(int id) {
		return (AssemblyLineType) session.get(AssemblyLineType.class, id);
	}

	public AttributeType findAttributeType(int id) {
		return (AttributeType) session.get(AttributeType.class, id);
	}

	public Category findCategory(int id) {
		return (Category) session.get(Category.class, id);
	}

	public Celestial findCelestial(int id) {
		return (Celestial) session.get(Celestial.class, id);
	}

	public Constellation findConstellation(final int id) {
		return (Constellation) session.get(Constellation.class, id);
	}

	public ControlTower findControlTower(int id) {
		return (ControlTower) session.get(ControlTower.class, id);
	}

	public Faction findFaction(int id) {
		return (Faction) session.get(Faction.class, id);
	}

	public Graphic findGraphic(int id) {
		return (Graphic) session.get(Graphic.class, id);
	}

	public Group findGroup(int id) {
		return (Group) session.get(Group.class, id);
	}

	public NpcCorporation findNpcCorporation(final int id) {
		return (NpcCorporation) session.get(NpcCorporation.class, id);
	}

	public BlueprintType findBlueprintType(final int id) {
		return (BlueprintType) session.get(BlueprintType.class, id);
	}

	public ProductType findProductType(int id) {
		return (ProductType) session.get(ProductType.class, id);
	}

	public Race findRace(int id) {
		return (Race) session.get(Race.class, id);
	}

	public Region findRegion(int id) {
		return (Region) session.get(Region.class, id);
	}

	public Schematic findSchematic(int id) {
		return (Schematic) session.get(Schematic.class, id);
	}

	public SolarSystem findSolarSystem(int id) {
		return (SolarSystem) session.get(SolarSystem.class, id);
	}

	public Station findStation(int id) {
		return (Station) session.get(Station.class, id);
	}

	public Unit findUnit(int id) {
		return (Unit) session.get(Unit.class, id);
	}

}
