package de.dornathal.eve.live.map;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class SolarSystemTest extends DatabaseConnectionTest {
	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[2];

		SolarSystem staticObject = (SolarSystem) session.get(SolarSystem.class, id);

		assertEquals(staticObject.getRegion().getRegionId(), values[0], "Mapped wrong: region_id");
		assertEquals(staticObject.getConstellation().getConstellationId(), values[1], "Mapped wrong: constellation_id");
		assertEquals(staticObject.getSolarSystemId(), id, "Mapped wrong: solarSystemId");
		assertEquals(staticObject.getName(), values[3], "Mapped wrong: name");

		assertEquals(staticObject.getCelestialArea().getLocation().getX(), values[4], "Mapped wrong: Location - X");
		assertEquals(staticObject.getCelestialArea().getLocation().getY(), values[5], "Mapped wrong: Location - Y");
		assertEquals(staticObject.getCelestialArea().getLocation().getZ(), values[6], "Mapped wrong: Location - Z");

		assertEquals(staticObject.getCelestialArea().getArea().minLocation.getX(), values[7], "Mapped wrong: Area - minX");
		assertEquals(staticObject.getCelestialArea().getArea().maxLocation.getX(), values[8], "Mapped wrong: Area - maxX");
		assertEquals(staticObject.getCelestialArea().getArea().minLocation.getY(), values[9], "Mapped wrong: Area - minY");
		assertEquals(staticObject.getCelestialArea().getArea().maxLocation.getY(), values[10], "Mapped wrong: Area - maxY");
		assertEquals(staticObject.getCelestialArea().getArea().minLocation.getZ(), values[11], "Mapped wrong: Area - maxZ");
		assertEquals(staticObject.getCelestialArea().getArea().maxLocation.getZ(), values[12], "Mapped wrong: Area - minZ");

		assertEquals(staticObject.getLuminosity(), values[13], "Mapped wrong: luminosity");
		assertEquals(staticObject.isBorder(), (Integer) values[14] == 1, "Mapped wrong: border");
		assertEquals(staticObject.isFringe(), (Integer) values[15] == 1, "Mapped wrong: fringe");
		assertEquals(staticObject.isCorridor(), (Integer) values[16] == 1, "Mapped wrong: corridor");
		assertEquals(staticObject.isHub(), (Integer) values[17] == 1, "Mapped wrong: hub");
		assertEquals(staticObject.isInternational(), (Integer) values[18] == 1, "Mapped wrong: international");
		assertEquals(staticObject.isRegional(), (Integer) values[19] == 1, "Mapped wrong: regional");
		assertEquals(staticObject.isConstellation(), (Integer) values[20] == 1, "Mapped wrong: constellation");
		assertEquals(staticObject.getSecurity(), values[21], "Mapped wrong: security");

		if( values[22] == null ) assertNull(staticObject.getFaction(), "Mapped wrong: factionId");
		else assertEquals(staticObject.getFaction().getFactionId(), values[22], "Mapped wrong: factionId");

		assertEquals(staticObject.getCelestialArea().getRadius(), values[23], "Mapped wrong: radius");
		assertEquals(staticObject.getSunType().getProductTypeId(), values[24], "Mapped wrong: sunType");
		assertEquals(staticObject.getSecurityClass(), values[25], "Mapped wrong: securityClass");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 10000001, 20000001, 30000001, "Tanoo", -8.851079259998058e16, 4.236944396687888e16, -4.451352534647966e16, -8.85119031484906e16, -8.850925647176062e16, 4.236929792748907e16, 4.236964574926392e16, 4.451303635589282e16, 4.451411168978288e16, 0.01575, 1, 0, 0, 1, 1, 1, 1, 0.8583240688484681, null, 1.323338364984e12, 3802, SecurityClass.B } }, { new Object[]{ 10000004, 20000058, 30000402, "6F3-TK", 9.635434167064571e16, 8.164208168808389e16, 3.147808353071941e17, 9.635301252130138e16, 9.635942803975613e16, 8.164185806621283e16, 8.16429374396255e16, -3.1478251984256346e17, -3.147802933196971e17, 0.1928, 1, 0, 0, 1, 0, 0, 1, -0.00009376677181416326, null, 3.207759227376e12, 3798, SecurityClass.Unspecified } },

		};
	}
}
