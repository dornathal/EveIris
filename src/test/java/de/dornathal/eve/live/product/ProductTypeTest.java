package de.dornathal.eve.live.product;

import de.dornathal.eve.live.DatabaseConnectionTest;
import de.dornathal.eve.live.Race;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductTypeTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		ProductType staticObject = (ProductType) session.get(ProductType.class, id);

		assertEquals(staticObject.getProductTypeId(), id, "Mapped wrong: productTypeId");
		assertEquals(staticObject.getGroup().getGroupId(), values[1], "Mapped wrong: group");
		assertEquals(staticObject.getName(), values[2], "Mapped wrong: name");
		assertEquals(staticObject.getDescription(), values[3], "Mapped wrong: description");
		assertEquals(staticObject.getMass(), values[4], "Mapped wrong: mass");
		assertEquals(staticObject.getVolume(), values[5], "Mapped wrong: volume");
		assertEquals(staticObject.getCapacity(), values[6], "Mapped wrong: capacity");
		assertEquals(staticObject.getPortionSize(), values[7], "Mapped wrong: portionSize");
		if( values[8] != null ) assertEquals(staticObject.getRace().getRaceId(), values[8], "Mapped wrong: Race");
		else assertNull(staticObject.getRace(), "Mapped wrong: Race");
		assertEquals(staticObject.getBasePrice(), values[9], "Mapped wrong: basePrice");
		assertEquals(staticObject.isPublished(), (Integer) values[10] == 1, "Mapped wrong: published");
		assertEquals(staticObject.getMarketGroup().getMarketGroupId(), values[11], "Mapped wrong: marketGroup");
		assertEquals(staticObject.getChanceOfDuplicating(), values[12], "Mapped wrong: chanceOfDuplicating");
	}

	private void assertNull(final Race race, final String s) {}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 34, 18, "Tritanium", "The main building block in space structures. A very hard, yet bendable metal. Cannot be used in human habitats due to its instability at atmospheric temperatures. Very common throughout the universe.", 0.0, 0.01, 0.0, 1, null, 2.0000, 1, 18, 0.0 } }, { new Object[]{ 602, 25, "Kestrel", "The Kestrel is a Combat Frigate designed for frontline fighting.\r\n<br><font size=\"14\"><b>Traits</b></font>\r\n<b><a href=showinfo:3330>Caldari Frigate</a> skill bonus per level:</b>\r\n5% bonus to Light Missile and Rocket damage\r\n10% bonus to Missile velocity\r\n<br><font size=\"14\"><b>Development</b></font>\r\nThe Kestrel is a heavy missile boat with one of the most sophisticated sensor arrays around. Interestingly enough, it has been used by both the Caldari Navy and several wealthy trade corporations as a cargo-hauling vessel. It is one of few trading vessels with good punching power, making it ideal for solo trade-runs in dangerous areas. The Kestrel was designed so that it could take up to four missile launchers but as a result it can not be equipped with turret weapons nor with mining lasers.", 1163000.0, 19700.0, 160.0, 1, 1, 225000.0000, 1, 61, 0.07 } }, };
	}

}
