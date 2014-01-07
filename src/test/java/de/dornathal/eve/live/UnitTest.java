package de.dornathal.eve.live;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UnitTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		Unit staticObject = (Unit) session.get(Unit.class, id);

		assertEquals(staticObject.getUnitId(), id, "Mapped wrong: factionId");
		assertEquals(staticObject.getName(), values[1], "Mapped wrong: name");
		assertEquals(staticObject.getDisplayName(), values[2], "Mapped wrong: displayName");
		assertEquals(staticObject.getDescription(), values[3], "Mapped wrong: description");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 1, "Length", "m", "Meter" } }, };
	}
}
