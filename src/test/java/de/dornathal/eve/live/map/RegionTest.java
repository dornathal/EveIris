package de.dornathal.eve.live.map;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegionTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		Region staticObject = (Region) session.get(Region.class, id);

		assertEquals(staticObject.getRegionId(), values[0], "Mapped wrong: region_id");
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

		if( values[11] == null ) assertEquals(staticObject.getFaction(), null, "Mapped wrong: factionId");
		else assertEquals(staticObject.getFaction().getFactionId(), values[11], "Mapped wrong: factionId");

		assertEquals(staticObject.getCelestialArea().getRadius(), values[12], "Mapped wrong: radius");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 10000001, "Derelik", -7.736195192277693e16, 5.087803266430193e16, -6.44331012661154e16, -1.0554998756384811e17, -4.917391628170574e16, 2.7128553877044016e16, 7.462751145155984e16, 2.642336051102867e16, 1.0244284202120213e17, 500007, 3.800974075508673e16 } }, { new Object[]{ 10000002, "The Forge", -9.642032966461757e16, 6.40270758377404e16, 1.125398171329042e17, -1.4364565469828213e17, -4.919500463095301e16, 3.5154556396755124e16, 9.289959527872566e16, -1.4445260316175862e17, -8.062703110404978e16, 500001, 4.722532503366456e16 } },

		};
	}
}
