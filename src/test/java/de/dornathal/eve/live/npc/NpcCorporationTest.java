package de.dornathal.eve.live.npc;

import de.dornathal.eve.live.DatabaseConnectionTest;
import de.dornathal.eve.live.product.ProductType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class NpcCorporationTest extends DatabaseConnectionTest {


	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		NpcCorporation staticObject = (NpcCorporation) session.get(NpcCorporation.class, id);

		assertEquals(staticObject.getNpcCorporationId(), values[0], "Mapped wrong: npcCorporationId");
		assertEquals(staticObject.getSize(), values[1], "Mapped wrong: size");
		assertEquals(staticObject.getExtent(), values[2], "Mapped wrong: extent");
		assertEquals(staticObject.getSolarSystem().getSolarSystemId(), values[3], "Mapped wrong: solarSystem");

		assertEquals(staticObject.getFriendCorporation().getNpcCorporationId(), values[12], "Mapped wrong: friendCorporation");
		assertEquals(staticObject.getEnemyCorporation().getNpcCorporationId(), values[13], "Mapped wrong: enemyCorporation");

		assertEquals(staticObject.getFaction().getFactionId(), values[22], "Mapped wrong: FactionId");
		assertEquals(staticObject.getSizeFactor(), values[23], "Mapped wrong: sizeFactor");
		assertEquals(staticObject.getStationCount(), values[24], "Mapped wrong: stationCount");
		assertEquals(staticObject.getStationSystemCount(), values[25], "Mapped wrong: stationSystemCount");
		assertEquals(staticObject.getDescription(), values[26], "Mapped wrong: description");
		assertEquals(staticObject.getIcon().getIconId(), values[27], "Mapped wrong: iconId");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 1000002, NpcCorporationSize.Huge, Extent.G, 30002780, 1000002, 42, null, 35, 1000013, 14, 1000006, 9, 1000006, 1000005, 0, 47, 0, 1, 4, 3, 2, 4, 500001, 1.75, 90, 56, "The CBD Corporation is one of the biggest exporters/importers in Caldari space. The corporation has established trade links far and wide, with a huge amount of goods in constant fluctuation.", 1465 } },

		};
	}

	@Test(dataProvider = "tradeProducts")
	public void ChildGroups(int npcCorporationid, int[] tradeProductsId) {

		final int id = npcCorporationid;

		Comparator<ProductType> comparator = new Comparator<ProductType>() {
			@Override
			public int compare(final ProductType o1, final ProductType o2) {
				if( o1.getProductTypeId() == o2.getProductTypeId() ) return 0;
				return (o1.getProductTypeId() > o2.getProductTypeId()) ? 1 : -1;
			}
		};

		NpcCorporation staticObject = (NpcCorporation) session.get(NpcCorporation.class, id);

		int i = 0;
		final List<ProductType> tradeProducts = new ArrayList<ProductType>(staticObject.getTradeProducts());
		Collections.sort(tradeProducts, comparator);
		assertEquals(tradeProducts.size(), tradeProductsId.length, "Wrong amount of products in TradeProducts");
		for( ProductType group : tradeProducts ){
			assertEquals(group.getProductTypeId(), tradeProductsId[i++], "Wrong product in TradeProducts at Index " + i);
		}

	}

	//This function will provide the parameter data
	@DataProvider(name = "tradeProducts")
	public Object[][] TradeProductsProvider() {
		return new Object[][]{ { 1000022, new int[]{ 672, 967, 1802 } }, { 1000025, new int[]{ 223, 224, 672, 786, 967, 1010, 1112, 1116, 1121, 1130, 1133, 1138, 1139, 1141, 1876, 3830, 11855 } }, };
	}

}
