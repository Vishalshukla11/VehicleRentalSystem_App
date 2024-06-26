public abstract class Vehicle
{
    private String id;
    private String make;
    private String model;
    private int year;
    private double rentalRate;
    private boolean isRented;

    public Vehicle(String id,String make,String model,int year,double rentalRate)
    {
        this.id=id;
        this.make=make;
        this.model=model;
        this.year=year;
        this.rentalRate=rentalRate;
        this.isRented=false;
    }
    public boolean isRented()
    {
        return isRented;
    }
public void setRented(boolean Rented)
{
    isRented=Rented;
}
    public double getRrentalRate()
    {
        return rentalRate;
    }
    public void setRentalrate(double rentalRate)
    {
        this.rentalRate=rentalRate;
    }
    public int getyear()
    {
        return year;
    }
    public void  setyear(int year)
    {
        this.year=year;
    }
    public String getModel()
    {
        return model;
    }
    public void setmodel(String model)
    {
        this.model=model;
    }
    public String getMake()
    {
        return make;
    }
    public void setMake(String make)
    {
        this.make=make;
    }
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public abstract String getVehicleType();
    public String getVehicleInfor()
    {
        return getVehicleType() + "[ id= " + id  + " , make= "+ make + " , model= "+ model + " , year= "+ year + " rentalRate=  " + rentalRate + "]" ;
    }
}