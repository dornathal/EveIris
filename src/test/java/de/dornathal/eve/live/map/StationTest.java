package de.dornathal.eve.live.map;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StationTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		Station staticObject = (Station) session.get(Station.class, id);

		assertEquals(staticObject.getStationId(), values[0], "Mapped wrong: stationId");
		assertEquals(staticObject.getSecurity(), values[1], "Mapped wrong: security");
		assertEquals(staticObject.getDockingCostPerVolume(), values[2], "Mapped wrong: dockingCostPerVolume");
		assertEquals(staticObject.getMaxShipVolumeDockable(), values[3], "Mapped wrong: name");

		assertEquals(staticObject.getOfficeRentalCost(), values[4], "Mapped wrong: officeRentalCost");
		assertEquals(staticObject.getOperation().getOperationId(), values[5], "Mapped wrong: operationId");
		assertEquals(staticObject.getStationType().getProductTypeId(), values[6], "Mapped wrong: stationTypeId");

		assertEquals(staticObject.getNpcCorporation().getNpcCorporationId(), values[7], "Mapped wrong: npcCorporation");

		assertEquals(staticObject.getSolarSystem().getSolarSystemId(), values[8], "Mapped wrong: solarSystemId");
		assertEquals(staticObject.getConstellation().getConstellationId(), values[9], "Mapped wrong: constellationId");
		assertEquals(staticObject.getRegion().getRegionId(), values[10], "Mapped wrong: regionId");

		assertEquals(staticObject.getName(), values[11], "Mapped wrong: stationName");

		assertEquals(staticObject.getLocation().getX(), values[12], "Mapped wrong: Location - X");
		assertEquals(staticObject.getLocation().getY(), values[13], "Mapped wrong: Location - Y");
		assertEquals(staticObject.getLocation().getZ(), values[14], "Mapped wrong: Location - Z");

		assertEquals(staticObject.getReprocessingEfficiency(), values[15], "Mapped wrong: ReprocessingEfficiency");
		assertEquals(staticObject.getReprocessingStationsTake(), values[16], "Mapped wrong: ReprocessingStationsTake");
		//assertEquals(staticObject.getReprocessingHangar(), values[14], "Mapped wrong: Location - Z");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 60000004, 0, 0.0, 5.0e7, 10000, 26, 1531, 1000002, 30002780, 20000407, 10000033, "Muvolailen X - Moon 3 - CBD Corporation Storage", 1.723680890880e12, 2.56414064640e11, -6.0755435520e10, 0.5, 0.05, 4 } }, };
	}

}
