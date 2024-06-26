
public class Car extends Vehicle
{
    private int numDoors;
    private String fuelType;
    
    public Car(String id ,String make,String model,int year,double rentalRate,int numDoors,String fuleType)
    {
        super(id, make, model, year, rentalRate);
        this.numDoors=numDoors;
        this.fuelType=fuleType;

    }
    public int getNumDoors()
    {
        return numDoors;
    }
    public String getFuleType()
    {
        return fuelType;
    }
    
    @Override
    public String getVehicleType() {
        return "Car";
    }
    
}
