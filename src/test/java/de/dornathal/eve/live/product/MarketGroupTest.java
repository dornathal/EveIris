package de.dornathal.eve.live.product;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collection;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class MarketGroupTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		MarketGroup staticObject = (MarketGroup) session.get(MarketGroup.class, id);

		assertEquals(staticObject.getMarketGroupId(), id, "Mapped wrong: marketGroupId");
		if( values[1] == null ) assertNull(staticObject.getParentGroup(), "Mapped wrong: parentGroupId");
		else assertEquals(staticObject.getParentGroup().getMarketGroupId(), values[1], "Mapped wrong: parentGroupId");

		assertEquals(staticObject.getName(), values[2], "Mapped wrong: name");
		assertEquals(staticObject.getDescription(), values[3], "Mapped wrong: description");
		//assertEquals(staticObject.getIcon().getIconId(), values[4], "Mapped wrong: iconId");
		assertEquals(staticObject.hasTypes(), (Integer) values[5] == 1, "Mapped wrong: hasTypes");

	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 5, 1361, "Standard Frigates", "Small, fast vessels suited to a variety of purposes.", 1443, 0 } }, { new Object[]{ 4, null, "Ships", "Capsule-fitted vessels of all shapes and sizes, from frigate to battleship.", 1443, 0 } }, { new Object[]{ 18, 1031, "Minerals", "Minerals harvested from refined asteroid ore.", null, 1 } }, };
	}

	@Test(dataProvider = "childGroups")
	public void ChildGroups(int marketGroupId, int[] childGroupIds) {

		int id = marketGroupId;

		MarketGroup staticObject = (MarketGroup) session.get(MarketGroup.class, id);

		int i = 0;
		final Collection<MarketGroup> childGroups = staticObject.getChildGroups();
		assertEquals(childGroups.size(), childGroupIds.length, "Wrong amount of children in childGroups");
		for( MarketGroup group : childGroups ){
			assertEquals(group.getMarketGroupId(), childGroupIds[i++], "Wrong child in childGroups");
		}

	}

	//This function will provide the parameter data
	@DataProvider(name = "childGroups")
	public Object[][] ChildGroupsProvider() {
		return new Object[][]{ { 9, new int[]{ 10, 14, 52, 141, 404, 554, 655, 656, 657, 760, 779, 938, 1708, 1713 } }, { 553, new int[]{ 1692, 1693, 1694, 1695, 1696 } }, { 1715, new int[]{ } }, };
	}
}
