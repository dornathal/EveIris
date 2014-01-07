package de.dornathal.eve.live.core;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UniqueNameTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		UniqueName staticObject = (UniqueName) session.get(UniqueName.class, id);

		assertEquals(staticObject.getItemId(), id, "Mapped wrong: uniquNameId");
		assertEquals(staticObject.getName(), values[1], "Mapped wrong: name");
		assertEquals(staticObject.getGroup().getGroupId(), values[2], "Mapped wrong: groupId");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 500009, "The Syndicate", 19 } }, };
	}
}
