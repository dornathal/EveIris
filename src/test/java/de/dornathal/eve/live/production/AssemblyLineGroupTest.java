package de.dornathal.eve.live.production;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AssemblyLineGroupTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		AssemblyLineGroup staticObject = (AssemblyLineGroup) session.get(AssemblyLineGroup.class, id);

		assertEquals(staticObject.getAssemblyLineGroupId(), id, "Mapped wrong: assemblyLineId");
		assertEquals(staticObject.getAssemblyLineType().getAssemblyLineTypeId(), values[1], "Mapped wrong: assemblyLineType");
		assertEquals(staticObject.getStation().getStationId(), values[2], "Mapped wrong: stationId");
		assertEquals(staticObject.getCostInstall(), values[5], "Mapped wrong: costInstall");
		assertEquals(staticObject.getCostPerHour(), values[6], "Mapped wrong: costPerHour");
		assertEquals(staticObject.getDiscountPerGoodStandingPoint(), values[8], "Mapped wrong: DiscountPerGoodStanding");
		assertEquals(staticObject.getSurchargePerBadStandingPoint(), values[9], "Mapped wrong: SurchargePerBadStanding");
		assertEquals(staticObject.getMinimumStanding(), values[10], "Mapped wrong: MinimumStanding");
		assertEquals(staticObject.getMinimumCharacterSecurity(), values[11], "Mapped wrong: MinimumCharacterSecurity");
		assertEquals(staticObject.getMinimumCorporationSecurity(), values[12], "Mapped wrong: MinimumCorporationSecurity");
		assertEquals(staticObject.getMaximumCharacterSecurity(), values[13], "Mapped wrong: MaximumCharacterSecurity");
		assertEquals(staticObject.getMaximumCorporationSecurity(), values[14], "Mapped wrong: MaximumCorporationSecurity");
		//assertEquals(staticObject.getActivity().getActivityId(), values[16], "Mapped wrong: Activity");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 1, 35, 60000976, null, 0, 1000F, 333F, 0, 1.5F, 0.5F, -10F, -10F, -10F, 10F, 10F, 1000010, 1 } }, { new Object[]{ 131661, 7, 60014912, null, 0, 25000F, 2500F, 0, 1.5F, 0F, 5F, -10F, 5F, 10F, 10F, 1000135, 4 } }, };
	}
}
