package de.dornathal.eve.live.product;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CategoryTest extends DatabaseConnectionTest {
	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		Category staticObject = (Category) session.get(Category.class, id);

		assertEquals(staticObject.getCategoryId(), values[0], "Mapped wrong: categoryId");
		assertEquals(staticObject.getName(), values[1], "Mapped wrong: name");
		assertEquals(staticObject.getDescription(), values[2], "Mapped wrong: description");
		//assertEquals(staticObject.getIcon(), values[3], "Mapped wrong: iconId");
		assertEquals(staticObject.isPublished(), (Integer) values[4] == 1, "Mapped wrong: published");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 0, "#System", "", null, 0 } }, { new Object[]{ 5, "Accessories", "", 33, 1 } }, };
	}
}
