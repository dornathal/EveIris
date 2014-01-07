package de.dornathal.eve.live.attributes;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AttributeValueTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		AttributeValue.EmbeddedAttributeId id = new AttributeValue.EmbeddedAttributeId((Integer) values[0], (Integer) values[1]);

		AttributeValue staticObject = (AttributeValue) session.get(AttributeValue.class, id);
		assertEquals(staticObject.getAttributeValueId().getTypeId(), values[0], "Mapped wrong: typeId");
		assertEquals(staticObject.getAttributeValueId().getAttributeId(), values[1], "Mapped wrong: attributeTypeId");
		assertEquals(staticObject.getAttribute().getAttributeTypeId(), values[1], "Mapped wrong: attribute");
		assertEquals(staticObject.getValueInt(), values[2], "Mapped wrong: intValue");
		assertEquals(staticObject.getValueFloat(), values[3], "Mapped wrong: floatValue");
		assertEquals(staticObject.getValue(), (values[2] == null) ? values[3] : (Integer) values[2] * 1.0, "Mapped wrong: Value");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 20, 182, 3386, null } }, { new Object[]{ 23, 552, null, 5000.0 } }, };
	}

}
