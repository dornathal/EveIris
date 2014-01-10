package de.dornathal.eve.live;

import de.dornathal.eve.live.attributes.AttributeType;
import de.dornathal.eve.live.map.*;
import de.dornathal.eve.live.npc.Agent;
import de.dornathal.eve.live.npc.NpcCorporation;
import de.dornathal.eve.live.planetary.Schematic;
import de.dornathal.eve.live.product.*;
import de.dornathal.eve.live.production.AssemblyLineGroup;
import de.dornathal.eve.live.production.AssemblyLineType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataCoreTest {

	DataCore dataCore;

	@BeforeMethod
	public void setUp() throws Exception {
		dataCore = DataCore.getInstance();
		//dataCore.reloadDatabase();
	}

	@Test
	public void findAgent_ValidId_ReturnsAttachedEntity() {
		int id = 3008416;

		Agent staticObject = dataCore.findAgent(id);

		assertEquals(staticObject.getAgentId(), id);
	}

	@Test
	public void findAssemblyLineGroup_ValidId_ReturnsAttachedEntity() {
		int id = 1;

		AssemblyLineGroup staticObject = dataCore.findAssemblyLineGroup(id);

		assertEquals(staticObject.getAssemblyLineGroupId(), id);
	}

	@Test
	public void findAssemblyLineType_ValidId_ReturnsAttachedEntity() {
		int id = 18;

		AssemblyLineType staticObject = dataCore.findAssemblyLineType(id);

		assertEquals(staticObject.getAssemblyLineTypeId(), id);
	}

	@Test
	public void findAttributeType_ValidId_ReturnsAttachedEntity() {
		int id = 6;

		AttributeType staticObject = dataCore.findAttributeType(id);

		assertEquals(staticObject.getAttributeTypeId(), id);
	}

	@Test
	public void findBlueprintType_ValidId_ReturnsAttachedEntity() {
		int blueprintTypeId = 681;

		BlueprintType region = dataCore.findBlueprintType(blueprintTypeId);

		assertEquals(blueprintTypeId, region.getBlueprintTypeId());
	}

	@Test
	public void findCategory_ValidId_ReturnsAttachedEntity() {
		int id = 1;

		Category staticObject = dataCore.findCategory(id);

		assertEquals(id, staticObject.getCategoryId());
	}

	@Test(enabled = false)
	public void findCelestial_ValidId_ReturnsAttachedEntity() {
		int id = 40000001;

		Celestial staticObject = dataCore.findCelestial(id);

		assertEquals(id, staticObject.getCelestialId());
	}

	@Test
	public void findConstellation_ValidId_ReturnsAttachedEntity() {
		int constellationId = 20000001;

		Constellation constellation = dataCore.findConstellation(constellationId);

		assertEquals(constellationId, constellation.getConstellationId());
	}

	@Test
	public void findControlTower_ValidId_ReturnsAttachedEntity() {
		int id = 12235;

		ControlTower staticObject = dataCore.findControlTower(id);

		assertEquals(id, staticObject.getProductTypeId());
	}

	@Test
	public void findFaction_ValidId_ReturnsAttachedEntity() {
		int id = 500001;

		Faction staticObject = dataCore.findFaction(id);

		assertEquals(id, staticObject.getFactionId());
	}

	@Test
	public void findGraphic_ValidId_ReturnsAttachedEntity() {
		int id = 5000001;

		Graphic staticObject = dataCore.findGraphic(id);

		assertEquals(id, staticObject.getGraphicId());
	}

	@Test
	public void findGroup_ValidId_ReturnsAttachedEntity() {
		int id = 1;

		Group staticObject = dataCore.findGroup(id);

		assertEquals(id, staticObject.getGroupId());
	}

	@Test
	public void findNpcCorporation_ValidId_ReturnsAttachedEntity() {
		int id = 1000002;

		NpcCorporation staticObject = dataCore.findNpcCorporation(id);

		assertEquals(id, staticObject.getNpcCorporationId());
	}

	@Test
	public void findProductType_ValidId_ReturnsAttachedEntity() {
		int productTypeId = 34;

		ProductType productType = dataCore.findProductType(productTypeId);
		productType.getMaterials();

		assertEquals(productTypeId, productType.getProductTypeId());
	}

	@Test
	public void findRace_ValidId_ReturnsAttachedEntity() {
		int id = 1;

		Race staticObject = dataCore.findRace(id);

		assertEquals(id, staticObject.getRaceId());
	}

	@Test
	public void findRegion_ValidId_ReturnsAttachedEntity() {
		int regionId = 10000002;

		Region region = dataCore.findRegion(regionId);

		assertEquals(regionId, region.getRegionId());
	}

	@Test
	public void findSchematic_ValidId_ReturnsAttachedEntity() {
		int id = 65;

		Schematic staticObject = dataCore.findSchematic(id);

		assertEquals(id, staticObject.getSchematicId());
	}

	@Test
	public void findSolarSystem_ValidId_ReturnsAttachedEntity() {
		int solarSystemId = 30001000;

		SolarSystem solarSystem = dataCore.findSolarSystem(solarSystemId);

		assertEquals(solarSystemId, solarSystem.getSolarSystemId());
	}

	@Test
	public void findStation_ValidId_ReturnsAttachedEntity() {
		int stationId = 60000004;

		Station solarSystem = dataCore.findStation(stationId);

		assertEquals(stationId, solarSystem.getStationId());
	}

	@Test
	public void findUnit_ValidId_ReturnsAttachedEntity() {

		Unit unit = dataCore.findUnit(1);

		assertEquals(1, unit.getUnitId());
	}
}
