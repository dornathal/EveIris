package de.dornathal.eve.live;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactionTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		Faction staticObject = (Faction) session.get(Faction.class, id);

		assertEquals(staticObject.getFactionId(), id, "Mapped wrong: factionId");
		assertEquals(staticObject.getName(), values[1], "Mapped wrong: name");
		assertEquals(staticObject.getDescription(), values[2], "Mapped wrong: description");
		//assertEquals(staticObject.getRace().getRaceId(), values[3], "Mapped wrong: race");
		assertEquals(staticObject.getSolarSystem().getSolarSystemId(), values[4], "Mapped wrong: solarSystem");
		assertEquals(staticObject.getCorporation().getNpcCorporationId(), values[5], "Mapped wrong: corporation");
		assertEquals(staticObject.getSizeFactor(), values[6], "Mapped wrong: sizeFactor");
		assertEquals(staticObject.getStationCount(), values[7], "Mapped wrong: stationCount");
		assertEquals(staticObject.getStationSystemCount(), values[8], "Mapped wrong: stationSystemCount");
		assertEquals(staticObject.getMilitiaCorporation().getNpcCorporationId(), values[9], "Mapped wrong: militiaCorporationId");
		assertEquals(staticObject.getIcon().getIconId(), values[10], "Mapped wrong: iconId");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 500001, "Caldari State", "The Caldari State is ruled by several mega-corporations. There is no central government to speak of - all territories within the State are owned and ruled by corporations. Duty and discipline are required traits in Caldari citizens, plus unquestioning loyalty to the corporation they live to serve. The corporations compete aggressively amongst themselves and with companies outside the State, resulting in a highly capitalistic society.", 1, 30000145, 1000035, 5.0, 1503, 503, 1000180, 1439 } }, { new Object[]{ 500004, "Gallente Federation", "The Gallente Federation encompasses several races, the Gallenteans the largest by far. The Federation is democratic and very liberal in a world full of dictators and oligarchies. The Caldari State was once part of the Federation, but a severe dispute resulted in their departure and a long war between the Gallente Federation and the Caldari State. The Gallenteans are the masters of pleasure and entertainment and their rich trade empire has given the world many of its most glorious and extravagant sights.  ", 8, 30004993, 1000120, 5.0, 1051, 507, 1000181, 1441 } },

		};
	}
}
