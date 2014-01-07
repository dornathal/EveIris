package de.dornathal.eve.live.product;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductMaterialTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		ProductMaterial.ProductMaterialId id = new ProductMaterial.ProductMaterialId((Integer) values[0], (Integer) values[1]);

		ProductMaterial staticObject = (ProductMaterial) session.get(ProductMaterial.class, id);

		assertEquals(staticObject.getProduct().getProductTypeId(), values[0], "Mapped wrong: marketGroupId");
		assertEquals(staticObject.getMaterial().getProductTypeId(), values[1], "Mapped wrong: productTypeId");
		assertEquals(staticObject.getQuantity(), values[2], "Mapped wrong: quantity");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 18, 36, 256 } }, { new Object[]{ 22, 34, 10000 } }, };
	}
}
