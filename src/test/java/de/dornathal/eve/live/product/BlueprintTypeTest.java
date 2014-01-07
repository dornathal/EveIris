package de.dornathal.eve.live.product;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class BlueprintTypeTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		BlueprintType staticObject = (BlueprintType) session.get(BlueprintType.class, id);

		assertEquals(staticObject.getBlueprintTypeId(), values[0], "Mapped wrong: blueprintTypeId");
		if( values[1] == null ) assertNull(staticObject.getParentBlueprint(), "Mapped wrong: parentBlueprintId");
		else
			assertEquals(staticObject.getParentBlueprint().getBlueprintTypeId(), values[1], "Mapped wrong: parentBlueprintId");
		assertEquals(staticObject.getProduct().getProductTypeId(), values[2], "Mapped wrong: ProductionType");
		assertEquals(staticObject.getProductionTime().getSeconds(), values[3], "Mapped wrong: productionTime");
		assertEquals(staticObject.getTechLevel(), values[4], "Mapped wrong: techLevel");
		assertEquals(staticObject.getResearchProductivityTime().getSeconds(), values[5], "Mapped wrong: researchProductivityTime");
		assertEquals(staticObject.getResearchMaterialTime().getSeconds(), values[6], "Mapped wrong: ResearchMaterialTime");
		assertEquals(staticObject.getResearchCopyTime().getSeconds(), values[7], "Mapped wrong: ResearchCopyTime");
		assertEquals(staticObject.getResearchTechTime().getSeconds(), values[8], "Mapped wrong: ResearchTechTime");
		assertEquals(staticObject.getProductivityModifier(), values[9], "Mapped wrong: ProductivityModifier");
		assertEquals(staticObject.getMaterialModifier(), values[10], "Mapped wrong: MaterialModifier");
		assertEquals(staticObject.getWasteFactor(), values[11], "Mapped wrong: WasteFactor");
		assertEquals(staticObject.getMaxProductionLimit(), values[12], "Mapped wrong: ProductionLimit");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 681, 986, 165, 600, (short) 1, 12000, 12000, 12000, 120000, 120.0, 5.0, (short) 10, 300 } }, { new Object[]{ 810, null, 209, 300, (short) 1, 6000, 6000, 6000, 4500, 60.0, 5.0, (short) 10, 1500 } }, };
	}

}
