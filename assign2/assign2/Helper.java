/**
 * The test class Helper.
 * Provides the beginning of a set of tests for program development.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Helper extends junit.framework.TestCase
{
	private TaxiCo taxiCo1;

    /**
     * Default constructor for test class Helper
     */
    public Helper()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
		taxiCo1 = new TaxiCo("djb's cars");
		taxiCo1.addTaxi();
		taxiCo1.addTaxi();
		taxiCo1.addShuttle();
	}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

    /**
     * Test whether we can book a taxi.
     */
	public void testBook()
	{
		Taxi taxi1 = (Taxi) taxiCo1.lookup("Car #1");
		assertNotNull(taxi1);
		taxi1.book("ASDA");
		assertEquals("ASDA", taxi1.getDestination());
	}

	/**
	 * Test the status of a taxi after it has arrived.
	 */
	public void testArrived()
	{
		Taxi taxi1 = (Taxi) taxiCo1.lookup("Car #1");
		assertNotNull(taxi1);
		taxi1.book("ASDA");
		taxi1.arrived();
		assertNull(taxi1.getDestination());
		assertEquals("ASDA", taxi1.getLocation());
	}

    public void testGetVehicle()
    {
        taxiCo1.showStatus();
        assertNotNull(taxiCo1.getVehicle("whitstable"));
    }
}







