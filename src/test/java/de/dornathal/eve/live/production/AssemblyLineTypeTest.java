package de.dornathal.eve.live.production;

import de.dornathal.eve.live.DatabaseConnectionTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AssemblyLineTypeTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		AssemblyLineType staticObject = (AssemblyLineType) session.get(AssemblyLineType.class, id);

		assertEquals(staticObject.getAssemblyLineTypeId(), id, "Mapped wrong: assemblyLineTypeId");
		assertEquals(staticObject.getName(), values[1], "Mapped wrong: Name");
		assertEquals(staticObject.getDescription(), values[2], "Mapped wrong: Description");
		assertEquals(staticObject.getBaseTimeMultiplier(), values[3], "Mapped wrong: BaseTimeMultiplier");
		assertEquals(staticObject.getBaseMaterialMultiplier(), values[4], "Mapped wrong: BaseMaterialMultiplier");
		assertEquals(staticObject.getVolume(), values[5], "Mapped wrong: Volume");
		assertEquals(staticObject.getActivity(), values[6], "Mapped wrong: Activity");
		assertEquals(staticObject.getMinimumCostPerHour(), values[7], "Mapped wrong: MinimumCostPerHour");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 18, "Advanced Small Ship Assembly Array", "Advanced Small Ship Assembly Array\r\n", 0.75, 1.1, 1.0, Activity.Manufacturing, null } },
				//{ new Object[]{ 131661, 7, 60014912, null, 0, 25000F, 2500F, 0, 1.5F, 0F, 5F, -10F, 5F, 10F, 10F, 1000135, 4 } },
		};
	}
}
