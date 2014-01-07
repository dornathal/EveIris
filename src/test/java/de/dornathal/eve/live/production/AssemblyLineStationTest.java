package de.dornathal.eve.live.production;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AssemblyLineStationTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		AssemblyLineStation staticObject = (AssemblyLineStation) session.get(AssemblyLineStation.class, id);

		assertEquals(staticObject.getStationId(), values[0], "Mapped wrong: stationId");
		assertEquals(staticObject.getStation().getStationId(), values[0], "Mapped wrong: station");
		assertEquals(staticObject.getAssemblyLineType().getAssemblyLineTypeId(), values[1], "Mapped wrong: assemblyLineType");
		assertEquals(staticObject.getAssemblyLinesCount(), values[2], "Mapped wrong: assemblyLinesCount");
		assertEquals(staticObject.getStationType().getProductTypeId(), values[3], "Mapped wrong: stationType");
		assertEquals(staticObject.getSolarSystem().getSolarSystemId(), values[5], "Mapped wrong: solarSystem");
		assertEquals(staticObject.getRegion().getRegionId(), values[6], "Mapped wrong: region");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 60000976, 35, 50, 4024, 1000010, 30001401, 10000016 } }, { new Object[]{ 60002983, 35, 50, 1529, 1000026, 30001360, 10000016 } }, };
	}
}
