package de.dornathal.eve.live.map;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OperationTest extends DatabaseConnectionTest {
	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[1];

		Operation staticObject = (Operation) session.get(Operation.class, id);

		assertEquals(staticObject.getActivity().getValue(), values[0], "Mapped wrong: activity");
		assertEquals(staticObject.getOperationId(), id, "Mapped wrong: operationId");
		assertEquals(staticObject.getName(), values[2], "Mapped wrong: name");
		assertEquals(staticObject.getDescription(), values[3], "Mapped wrong: description");

		assertEquals(staticObject.getFringe(), values[4], "Mapped wrong: fringe");
		assertEquals(staticObject.getCorridor(), values[5], "Mapped wrong: corridor");
		assertEquals(staticObject.getHub(), values[6], "Mapped wrong: hub");
		assertEquals(staticObject.getBorder(), values[7], "Mapped wrong: border");
		assertEquals(staticObject.getRatio(), values[8], "Mapped wrong: ratio");

		assertEquals(staticObject.getCaldariStationType().getProductTypeId(), values[9], "Mapped wrong: sunType");
		assertEquals(staticObject.getMinmatarStationType().getProductTypeId(), values[10], "Mapped wrong: sunType");
		assertEquals(staticObject.getAmarrStationType().getProductTypeId(), values[11], "Mapped wrong: sunType");
		assertEquals(staticObject.getGallenteStationType().getProductTypeId(), values[12], "Mapped wrong: sunType");
		assertEquals(staticObject.getJoveStationType().getProductTypeId(), values[13], "Mapped wrong: sunType");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 10, 26, "Storage", "Stores cargo for other corps before shipping it to retailers.", 25, 25, 25, 25, 100, 1531, 2501, 1929, 3870, 3865 } }, };
	}
}
