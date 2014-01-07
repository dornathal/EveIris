package de.dornathal.eve.live.attributes;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AttributeTypeTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		AttributeType staticObject = (AttributeType) session.get(AttributeType.class, id);

		assertEquals(staticObject.getAttributeTypeId(), id, "Wrong mapped: Id");
		assertEquals(staticObject.getName(), values[1], "Wrong mapped: StructureBonus");
		assertEquals(staticObject.getDescription(), values[2], "Wrong mapped: Description");
		//assertEquals(staticObject.getIcon(),"Wrong mapped: The amount of charge used from the capacitor for a module activation.");
		assertEquals(staticObject.getDefaultValue(), values[4], "Wrong mapped: DefaultValue");
		assertEquals(staticObject.isPublished(), (Integer) values[5] == 1, "Wrong mapped: IsPublished");
		assertEquals(staticObject.getDisplayName(), values[6], "Wrong mapped: DisplayName");
		if( values[7] == null ) assertEquals(staticObject.getUnit(), values[7], "Wrong mapped: Unit");
		else assertEquals(staticObject.getUnit().getUnitId(), values[7], "Wrong mapped: Unit");
		assertEquals(staticObject.isStackable(), (Integer) values[8] == 1, "Wrong mapped: IsStackable");
		assertEquals(staticObject.isHighGood(), (Integer) values[9] == 1, "Wrong mapped: HighIsGood");
		assertEquals(staticObject.getCategory(), values[10], "Wrong mapped: AttributeCategory");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 6, "capacitorNeed", "The amount of charge used from the capacitor for a module activation.", 1400, 0.0, 1, "activation cost", 114, 1, 1, AttributeCategory.Capacitor } }, { new Object[]{ 82, "structureBonus", "Modifier for the maximum structural strength.", null, 0.0, 0, null, null, 1, 1, AttributeCategory.OtherCategory } }, { new Object[]{ 84, "armorDamageAmount", "An amount to modify the armor damage by.", 80, 0.0, 1, "Armor hp Repaired", 113, 0, 1, AttributeCategory.Miscellaneous } }, };
	}
}
