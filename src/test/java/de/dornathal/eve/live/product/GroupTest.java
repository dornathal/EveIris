package de.dornathal.eve.live.product;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GroupTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		Group staticObject = (Group) session.get(Group.class, id);

		assertEquals(staticObject.getGroupId(), values[0], "Mapped wrong: marketGroupId");
		assertEquals(staticObject.getCategory().getCategoryId(), values[1], "Mapped wrong: categoryId");
		assertEquals(staticObject.getName(), values[2], "Mapped wrong: name");
		assertEquals(staticObject.getDescription(), values[3], "Mapped wrong: description");
		//assertEquals(staticObject.getIcon().getIconId(), values[3], "Mapped wrong: description");
		assertEquals(staticObject.usesBasePrice(), (Integer) values[5] == 1, "Mapped wrong: basePrice");
		assertEquals(staticObject.allowsManufacture(), (Integer) values[6] == 1, "Mapped wrong: allowsManufacture");
		assertEquals(staticObject.allowsRecycle(), (Integer) values[7] == 1, "Mapped wrong: allowsRecycle");
		assertEquals(staticObject.isAnchored(), (Integer) values[8] == 1, "Mapped wrong: anchored");
		assertEquals(staticObject.isAnchorable(), (Integer) values[9] == 1, "Mapped wrong: anchorable");
		assertEquals(staticObject.isFittableNonSingleton(), (Integer) values[10] == 1, "Mapped wrong: fittableNonSingleton");
		assertEquals(staticObject.isPublished(), (Integer) values[11] == 1, "Mapped wrong: published");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 0, 0, "#System", "", null, 0, 1, 1, 0, 0, 0, 0 } }, { new Object[]{ 225, 7, "Cheat Module Group", "For limited distribution.  Speed up testing.", 0, 0, 1, 1, 0, 0, 0, 0 } }, };
	}
}
