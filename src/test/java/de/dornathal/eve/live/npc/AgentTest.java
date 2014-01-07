package de.dornathal.eve.live.npc;

import de.dornathal.eve.live.DatabaseConnectionTest;
import de.dornathal.eve.live.map.Station;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class AgentTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(String name, int[] values) {

		int id = values[0];

		Agent staticObject = (Agent) session.get(Agent.class, id);

		assertEquals(staticObject.getAgentId(), id, "Mapped wrong: id");
		assertEquals(staticObject.getName(), name, "Mapped wrong: name");
		assertEquals(staticObject.getDivision().getValue(), values[1], "Mapped wrong: division_id");
		assertEquals(staticObject.getCorporation().getNpcCorporationId(), values[2], "Mapped wrong: corporation_id");
		Station station = staticObject.getStation();
		if( station != null ){
			assertEquals(station.getStationId(), values[3], "Mapped wrong: locationId");
			assertEquals(staticObject.getSolarSystem().getSolarSystemId(), station.getSolarSystem().getSolarSystemId(), "Mapped wrong: SolarSystem of Station");
		}else{
			assertNull(staticObject.getStation(), "Mapped wrong: locationId");
			assertEquals(staticObject.getSolarSystem().getSolarSystemId(), values[3], "Mapped wrong: locationId");
		}
		assertEquals(staticObject.getLevel(), values[4], "Mapped wrong: level");
		assertEquals(staticObject.getQuality(), values[5], "Mapped wrong: quality");
		assertEquals(staticObject.getAgentType().getValue(), values[6], "Mapped wrong: agentType");
		assertEquals(staticObject.isLocator(), (values[7] != 0), "Mapped wrong: isLocator");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { "Antaken Kamola", new int[]{ 3008416, 22, 1000002, 60000004, 1, 20, 2, 0 } }, { "Hiva Shesha", new int[]{ 3019443, 24, 1000047, 30000001, 4, 20, 10, 0 } }, };
	}
}
