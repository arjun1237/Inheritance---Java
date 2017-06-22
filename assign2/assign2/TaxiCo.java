import java.util.*;

/**
 * A Taxi Company manages a fleet of taxis and shuttles.
 * Taxis move between single destinations.
 * Shuttles move around circular routes.
 * 
 * @author David J. Barnes 
 * @version 2016.12.03
 */
public class TaxiCo
{
    // The name of this company.
    private String companyName;
    // The name of the company's base.
    private final String base;    
    // The fleet of vehicles.
    private ArrayList<Vehicle> fleet;
    // A value for allocating taxi ids.
    private int nextID;
    // A list of available destinations for shuttles.
    private ArrayList<String> destinations;

    /**
     * Constructor for objects of class TaxiCo.
     * @param name The name of this company.
     */
    public TaxiCo(String name)
    {
        companyName = name;
        base = "base";
        fleet = new ArrayList<Vehicle>();
        nextID = 1;
        destinations = new ArrayList<String>();
        fillDestinations();
    }
    
    /**
     * Record that we have a new vehicle.
     * A unique ID will be allocated.
     */
    public void addTaxi()
    {
        Vehicle vehicle = new Taxi(base, "Car #" + nextID);
        fleet.add(vehicle);
        // Increment the ID for the next one.
        nextID++;
    }
    
    public void addShuttle(){
        // Sanity warning:
        // The following is a thoroughly contrived way to create a route!
         
        // Create a random list of destinations for its route.
        Collections.shuffle(destinations);
        ArrayList<String> route = new ArrayList<String>();
        // The starting point is always the base.
        route.add(base);
        // Decide on an (arbitrary) length for all routes.
        final int ROUTE_LENGTH = 3;
        for(int i = 0; i < ROUTE_LENGTH; i++) {
            route.add(destinations.get(i));
        }
        
        Vehicle vehicle = new Shuttle("Shuttle #" + nextID, route);
        fleet.add(vehicle);
        // Increment the ID for the next one.
        nextID++;
    }
    
    /**
     * Return the vechile with the given id if its a taxi.
     * @param id The id of the vechile to be returned.
     * @return The matching vechile, or null if no match is found.
     */
    public Vehicle lookup(String id)
    {
        boolean found = false;
        Vehicle vehicle = null;
        Iterator<Vehicle> it = fleet.iterator();
        while(!found && it.hasNext()) {
            vehicle = it.next();
            if(id.equals(vehicle.getID())) {
                found = true;
            }
        }
        if(found) {
            return vehicle;
        }
        else{
            return null;
        }
    }

    /**
     * Show the status of the fleet of vechiles. 
     */
    public void showStatus()
    {
        System.out.println("Current status of the " + companyName + " fleet");        
        System.out.println("-----------------------------------------------");
        if(fleet.isEmpty()){
            System.out.println("---No Availability---");
        }
        for(Vehicle vehicle : fleet) {
            System.out.println(vehicle.getStatus());
        } 
        System.out.println();
    }
    
    /**
     * Put all the possible shuttle destinations in a list.
     */
    private void fillDestinations()
    {
        destinations.add("Canterbury West");
        destinations.add("Canterbury East");
        destinations.add("The University");
        destinations.add("Whitstable");
        destinations.add("Herne Bay");
        destinations.add("Sainsbury's");
        destinations.add("Darwin");
    }
    
    /**
     * Get information on available vehicle.
     * @param destination The destination to where the user is headed.
     */
    public Vehicle getVehicle(String destination)
    {
        destination = destination.toLowerCase();
        Vehicle availableVehicle = null;
        String vehicleID = "---No Availability---";
        System.out.print("Vehicle to \"" + destination + "\": ");
        for(Vehicle vehicle : fleet){
            if(vehicle instanceof Taxi){
                if(vehicle.getDestination() == null && vehicleID.equals("---No Availability---")){
                    availableVehicle = vehicle;
                    vehicleID = vehicle.getID();
                }
            }
            if(vehicle instanceof Shuttle){
                if(destination.equals(vehicle.getDestination().toLowerCase())){
                    System.out.println(vehicle.getID() + ".");
                    System.out.println();
                    return vehicle;
                }
            }
        }
        System.out.println(vehicleID + ".");
        System.out.println();
        return availableVehicle;
    }
}
