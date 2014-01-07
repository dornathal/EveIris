package de.dornathal.eve.live.product;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ActivityUsageTest extends DatabaseConnectionTest {
	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		ActivityUsage staticObject = (ActivityUsage) session.get(ActivityUsage.class, id);

		assertEquals(staticObject.getActivityUsageTypeId(), values[0], "Mapped wrong: typeId");
		assertEquals(staticObject.getActivity().getValue(), values[1], "Mapped wrong: activity");
		assertEquals(staticObject.getRequiredType().getProductTypeId(), values[2], "Mapped wrong: requiredType");
		assertEquals(staticObject.getQuantity(), values[3], "Mapped wrong: quantity");
		assertEquals(staticObject.getDamagePerJob(), values[4], "Mapped wrong: damagePerJob");
		assertEquals(staticObject.isRecycling(), (Integer) values[5] == 1, "Mapped wrong: recycling");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 242, 6, 34, 3, 1.0, 1 } }, { new Object[]{ 599, 7, 11469, 1, 0.03, 0 } }, };
	}
}
