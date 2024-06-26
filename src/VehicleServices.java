import java.util.ArrayList;
import java.util.List;

public class VehicleServices
{

    private List<Vehicle> vehicles= new ArrayList<>();

    public void addVehicle(Vehicle vehicle)
    {
        vehicles.add(vehicle);
    }
    public List<Vehicle> getAvailableVehicles()
    {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for(Vehicle vehicle : vehicles)
        {
            if(!vehicle.isRented())
            {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public Vehicle getVehicleById(String id)
    {
        for(Vehicle vehicle : vehicles)
        {
            if(vehicle.getId().equals(id))
            {
                return vehicle ;
            }
        }
        return null;
    }

}