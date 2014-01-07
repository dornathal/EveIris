package de.dornathal.eve.live.product;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContrabandTest extends DatabaseConnectionTest {
	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		Contraband.EmbeddedContrabandId id = new Contraband.EmbeddedContrabandId((Integer) values[0], (Integer) values[1]);

		Contraband staticObject = (Contraband) session.get(Contraband.class, id);
		assertEquals(staticObject.getEmbeddedContrabandId().getFactionId(), values[0], "Mapped wrong: factionId");
		assertEquals(staticObject.getEmbeddedContrabandId().getProductTypeId(), values[1], "Mapped wrong: factionId");
		assertEquals(staticObject.getFaction().getFactionId(), values[0], "Mapped wrong: factionId");
		assertEquals(staticObject.getProduct().getProductTypeId(), values[1], "Mapped wrong: typeId");
		assertEquals(staticObject.getStandingLoss(), values[2], "Mapped wrong: standingLoss");
		assertEquals(staticObject.getConfiscateFromMinSecurity(), values[3], "Mapped wrong: confiscatedByMinSecurity");
		assertEquals(staticObject.getFineByValue(), values[4], "Mapped wrong: fineByValue");
		assertEquals(staticObject.getAttackFromMinSecurity(), values[5], "Mapped wrong: attackFromMinSecurity");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 500001, 3709, 0.15, 0.4, 3.0, 1.1 } }, { new Object[]{ 500001, 3824, 0.3, -1.0, 6.0, 1.1 } }, { new Object[]{ 500017, 3771, 0.15, -1.0, 2.5, 1.1 } }, };
	}

}
