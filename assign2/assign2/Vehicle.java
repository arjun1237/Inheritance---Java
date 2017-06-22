
/**
 * A Vehicle.
 * Vehicles have a unique ID and a location and their status can be given when asked.
 * 
 * @author Arjun Krishna Prasad
 * @version 2017.1.13
 */
public class Vehicle
{
    // A unique ID for this vehicle.
    private String id;
    // The destination or the next rote of this vehicle.
    private String destination;
    // The current location of this vehicle.
    private String location;
    
    /**
     * Constructor for objects of class Vehicle.
     * @param id This vehicle's unique id.
     */
    public Vehicle(String id)
    {        
        this.id = id;
    }    
    
    /**
     * Return the status of this vehicle.
     * @return The status.
     */
    public String getStatus()
    {
        if(destination != null){
            return id + " at " + location + " headed for " +
                   destination;
        }
        else{
            return id + " is at " + location + " (available for booking).";
        }
    }
    
    /**
     * Return the ID of the vehicle.
     * @return The ID of the vehicle.
     */
    public String getID()
    {
        return id;
    }
    
    /**
     * Return the location of the vehicle.
     * @return The location of the vehicle.
     */
    public String getLocation()
    {
        return location;
    }
    
    /**
     * Return the destination of the vehicle.
     * @return The destination of the vehicle.
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * Set the intented or the final destination of the vehicle.
     * @param destination The intended destination.
     */
    protected void setDestination(String destination)
    {
        this.destination = destination;
    }

    /**
     * Set the current location of the vehicle.
     * @param location The current location.
     */
    protected void setLocation(String location)
    {
        if(location != null){
            this.location = location;
        }
    }
    
    /**
     * Indicate that this taxi has arrived at its destination.
     * As a result, it will be free.
     */
    public void arrived()
    {
        location = getDestination();
    }    
    
}
