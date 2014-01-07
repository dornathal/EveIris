package de.dornathal.eve.live.planetary;

import de.dornathal.eve.live.DatabaseConnectionTest;
import de.dornathal.eve.live.product.ProductType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collection;

import static org.testng.Assert.assertEquals;

public class SchematicTest extends DatabaseConnectionTest {

	@Test(dataProvider = "Sets")
	public void LoadEntity(Object[] values) {

		int id = (Integer) values[0];

		Schematic staticObject = (Schematic) session.get(Schematic.class, id);

		assertEquals(staticObject.getSchematicId(), values[0], "Mapped wrong: schematicId");
		assertEquals(staticObject.getName(), values[1], "Mapped wrong: schematicName");
		assertEquals(staticObject.getCycleTime().getSeconds(), values[2], "Mapped wrong: cycleTime");
	}

	//This function will provide the parameter data
	@DataProvider(name = "Sets")
	public Object[][] parameterIntTestProvider() {
		return new Object[][]{ { new Object[]{ 65, "Superconductors", 3600 } }, { new Object[]{ 127, "Precious Metals", 1800 } }, };
	}

	@Test(dataProvider = "Pins")
	public void CheckPins(int id, int[] expectedIndexes) {

		Schematic staticObject = (Schematic) session.get(Schematic.class, id);

		Collection<ProductType> pins = staticObject.getPins();

		assertEquals(pins.size(), expectedIndexes.length, "Wrong amount of pins");
		int i = 0;
		for( ProductType pin : pins ){
			assertEquals(pin.getProductTypeId(), expectedIndexes[i++], "ProductType " + i + " has wrong id");
		}
	}

	//This function will provide the parameter data
	@DataProvider(name = "Pins")
	public Object[][] pins() {
		return new Object[][]{ { 65, new int[]{ 2470, 2472, 2474, 2480, 2484, 2485, 2491, 2494 } }, { 127, new int[]{ 2469, 2471, 2473, 2481, 2483, 2490, 2492, 2493 } }, };
	}

	@Test(dataProvider = "I/O")
	public void CheckInputOutput(int id, int[] expectedInputs, int[] expectedOutputs) {

		Schematic staticObject = (Schematic) session.get(Schematic.class, id);

		testResources(staticObject.getInput(), expectedInputs, "input", true);
		testResources(staticObject.getOutput(), expectedOutputs, "output", false);
	}

	private void testResources(final Collection<ResourceSet> resourceSets, final int[] expectedIndexes, final String type, final boolean isInput) {
		int i = 0;
		assertEquals(resourceSets.size(), expectedIndexes.length, "Wrong amount of " + type + "s");
		for( ResourceSet resourceSet : resourceSets ){
			assertEquals(resourceSet.isInput(), isInput, "ResourceSet " + i + " not " + type);
			assertEquals(resourceSet.getProductType().getProductTypeId(), expectedIndexes[i++], "ResourceSet " + i + " has wrong id");
		}
	}

	//This function will provide the parameter data
	@DataProvider(name = "I/O")
	public Object[][] IO() {
		return new Object[][]{ { 65, new int[]{ 2389, 3645 }, new int[]{ 9838 } }, { 127, new int[]{ 2270 }, new int[]{ 2399 } }, };
	}
}
