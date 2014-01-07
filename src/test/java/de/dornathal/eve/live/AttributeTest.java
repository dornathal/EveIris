package de.dornathal.eve.live;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AttributeTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		Attribute staticObject = (Attribute) session.get(Attribute.class, id);
		assertEquals(staticObject.getAttributeId(), values[0], "Mapped wrong: attributeId");
		assertEquals(staticObject.getName(), values[1], "Mapped wrong: name");
		assertEquals(staticObject.getDescription(), values[2], "Mapped wrong: description");
		assertEquals(staticObject.getShortDescription(), values[4], "Mapped wrong: shortDescription");
		assertEquals(staticObject.getNotes(), values[5], "Mapped wrong: notes");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 1, "Intelligence", "<b>Intelligence is a measure of a pilot\'s capacity for learning, reasoning, and understanding.</b> It is also an aptitude indicator for cognitive abilities such as logical reasoning and abstract thinking. In the EVE universe, pilots with a high intelligence score possess an innate mastery of core academic disciplines such as mathematics and physics.\r\n\r\n<b>Skill categories</b> such as <b>Electronics, Engineering, Navigation, and Science all require direct application of these disciplines</b> and build extensively on them throughout the pilot\'s skill advancement, irrespective of career choice. Additionally, advanced starship technologies such as <b>Electronic Warfare, Shield Operation, and Cloaking</b> will require a high Intelligence score to master quickly.\r\n\r\nThis attribute is secondary for numerous <b>social and industrial skills</b> as well. ", 1380, "A measure of individual capacity for learning, reasoning, abstract thinking, and overall cognitive aptitude.", "Intelligence does not increase the chance of achieving success during the application of skills, only how quickly the skills that depend on it are trained." } }, };
	}
}
