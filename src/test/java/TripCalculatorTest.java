import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TripCalculatorTest 
{
	private static TripCalculator tripCalculator;
	
	@BeforeClass
	public static void setUp() 
	{
		TripParser tripParser = new TripParser();
		tripCalculator = new TripCalculator(tripParser);
	}
	
	// Test the distance method
	@Test
	public void testTotalDistanceAll() 
	{
		assertEquals(115.277, tripCalculator.getDistance("QEW", "Salem Road"), 0.001);
	}
	
	@Test
	public void testDistance1() 
	{
		assertEquals(53.59, tripCalculator.getDistance("Britannia Road", "Leslie Street"), 0.001);
	}
	
	@Test
	public void testDistance2() 
	{
		assertEquals(115.277, tripCalculator.getDistance("Salem Road", "QEW"), 0.001);
	}
	
	@Test
	public void testDistance3() 
	{
		assertEquals(14.062, tripCalculator.getDistance("QEW", "Bronte Road"), 0.001);
	}

	
	// Test the cost method
	@Test
	public void testTotalCostAll() 
	{
		assertEquals(28.8192, tripCalculator.getCost("QEW", "Salem Road"), 0.001);
	}
	
	@Test
	public void testCost1() 
	{
		assertEquals(13.397, tripCalculator.getCost("Britannia Road", "Leslie Street"), 0.001);
	}
	
	@Test
	public void testCost2() 
	{
		assertEquals(28.8192, tripCalculator.getCost("Salem Road", "QEW"), 0.001);
	}
	
	@Test
	public void testCost3() 
	{
		assertEquals(3.515, tripCalculator.getCost("QEW", "Bronte Road"), 0.001);
	}
}