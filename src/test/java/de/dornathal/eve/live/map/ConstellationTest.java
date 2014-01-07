package de.dornathal.eve.live.map;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConstellationTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[1];

		Constellation staticObject = (Constellation) session.get(Constellation.class, id);

		assertEquals(staticObject.getRegion().getRegionId(), values[0], "Mapped wrong: region_id");
		assertEquals(staticObject.getConstellationId(), id, "Mapped wrong: constellation_id");
		assertEquals(staticObject.getName(), values[2], "Mapped wrong: name");

		assertEquals(staticObject.getCelestialArea().getLocation().getX(), values[3], "Mapped wrong: Location - X");
		assertEquals(staticObject.getCelestialArea().getLocation().getY(), values[4], "Mapped wrong: Location - Y");
		assertEquals(staticObject.getCelestialArea().getLocation().getZ(), values[5], "Mapped wrong: Location - Z");

		assertEquals(staticObject.getCelestialArea().getArea().minLocation.getX(), values[6], "Mapped wrong: Area - minX");
		assertEquals(staticObject.getCelestialArea().getArea().maxLocation.getX(), values[7], "Mapped wrong: Area - maxX");
		assertEquals(staticObject.getCelestialArea().getArea().minLocation.getY(), values[8], "Mapped wrong: Area - minY");
		assertEquals(staticObject.getCelestialArea().getArea().maxLocation.getY(), values[9], "Mapped wrong: Area - maxY");
		assertEquals(staticObject.getCelestialArea().getArea().minLocation.getZ(), values[10], "Mapped wrong: Area - maxZ");
		assertEquals(staticObject.getCelestialArea().getArea().maxLocation.getZ(), values[11], "Mapped wrong: Area - minZ");

		if( values[12] == null ) assertEquals(staticObject.getFaction(), null, "Mapped wrong: factionId");
		else assertEquals(staticObject.getFaction().getFactionId(), values[12], "Mapped wrong: factionId");

		assertEquals(staticObject.getCelestialArea().getRadius(), values[13], "Mapped wrong: radius");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 10000001, 20000001, "San Matar", -9.404655970099134e16, 4.952015315379885e16, -4.273873181840197e16, -1.0330096826312646e17, -8.479215113885622e16, 4.1707503568269944e16, 5.733280273932774e16, 2.8403529106921656e16, 5.707393452988227e16, null, 1.4335202711480308e16 } }, { new Object[]{ 10000029, 20000356, "N-K4Q0", -3.0216693094609244e16, 7.814527084104272e16, 1.372619799901373e17, -4.048823655393147e16, -1.9945149635287016e16, 6.937792859097949e16, 8.691261309110595e16, -1.4051489741393653e17, -1.3400906256633806e17, 500017, 1.0271543459322228e16 } },

		};
	}

}
