package de.dornathal.eve.live.map;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UniverseTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		Universe staticObject = (Universe) session.get(Universe.class, id);

		assertEquals(staticObject.getUniverseId(), values[0], "Mapped wrong: region_id");
		assertEquals(staticObject.getName(), values[1], "Mapped wrong: name");

		assertEquals(staticObject.getCelestialArea().getLocation().getX(), values[2], "Mapped wrong: Location - X");
		assertEquals(staticObject.getCelestialArea().getLocation().getY(), values[3], "Mapped wrong: Location - Y");
		assertEquals(staticObject.getCelestialArea().getLocation().getZ(), values[4], "Mapped wrong: Location - Z");

		assertEquals(staticObject.getCelestialArea().getArea().minLocation.getX(), values[5], "Mapped wrong: Area - minX");
		assertEquals(staticObject.getCelestialArea().getArea().maxLocation.getX(), values[6], "Mapped wrong: Area - maxX");
		assertEquals(staticObject.getCelestialArea().getArea().minLocation.getY(), values[7], "Mapped wrong: Area - minY");
		assertEquals(staticObject.getCelestialArea().getArea().maxLocation.getY(), values[8], "Mapped wrong: Area - maxY");
		assertEquals(staticObject.getCelestialArea().getArea().minLocation.getZ(), values[9], "Mapped wrong: Area - maxZ");
		assertEquals(staticObject.getCelestialArea().getArea().maxLocation.getZ(), values[10], "Mapped wrong: Area - minZ");

		assertEquals(staticObject.getCelestialArea().getRadius(), values[11], "Mapped wrong: radius");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 9, "", -7.8414612025763e16, 4.000683824544035e16, -1.879111335347789e16, -4.4901358960648845e17, 2.921843655549624e17, -3.1391501876004684e16, 1.1140517836688538e17, -4.336024461078487e17, 4.711846728148045e17, 4.523935594613266e17 } }, { new Object[]{ 9000001, "EVE Wormhole Universe", 7.704163917169471e18, 1.539371980795786e18, -9.519055862041336e18, 7.251770357708145e18, 8.156557476630798e18, 1.0869784213344594e18, 1.9917655402571126e18, 9.066662302580009e18, 9.971449421502663e18, 4.523935594613266e17

		} },

		};
	}

}
