package de.dornathal.eve.live;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RaceTest extends DatabaseConnectionTest {
	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		Race staticObject = (Race) session.get(Race.class, id);

		assertEquals(staticObject.getRaceId(), id, "Mapped wrong: raceId");
		assertEquals(staticObject.getName(), values[1], "Mapped wrong: name");
		assertEquals(staticObject.getDescription(), values[2], "Mapped wrong: description");
		assertEquals(staticObject.getIcon(), values[3], "Mapped wrong: iconId");
		assertEquals(staticObject.getShortDescription(), values[4], "Mapped wrong: shortDescription");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 1, "Caldari", "Founded on the tenets of patriotism and hard work that carried its ancestors through hardships on an inhospitable homeworld, the Caldari State is today a corporate dictatorship, led by rulers who are determined to see it return to the meritocratic ideals of old. Ruthless and efficient in the boardroom as well as on the battlefield, the Caldari are living emblems of strength, persistence, and dignity.", 1439, "The Caldari State is the epitome of civic duty and ruthless efficiency." } }, };
	}
}
