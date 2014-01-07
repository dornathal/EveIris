package de.dornathal.eve.live.planetary;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ResourceSetTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		ResourceSet.ResourceSetId id = new ResourceSet.ResourceSetId((Integer) values[0], (Integer) values[1]);

		ResourceSet staticObject = (ResourceSet) session.get(ResourceSet.class, id);

		assertEquals(staticObject.getSchematicId(), values[0], "Mapped wrong: schematicId");
		assertEquals(staticObject.getProductType().getProductTypeId(), values[1], "Mapped wrong: typeId");
		assertEquals(staticObject.getQuantity(), values[2], "Mapped wrong: quantity");
		assertEquals(staticObject.isInput(), (Integer) values[3] == 1, "Mapped wrong: input");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 65, 2389, 40, 1 } }, { new Object[]{ 67, 9830, 5, 0 } }, };
	}

}
