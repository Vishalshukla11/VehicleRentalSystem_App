package com.Vehicle.rental.entities;
public class Bike extends Vehicle
{
    private String type;

    public Bike(String id, String make, String model, int year, double rentalRate,String type) {
        super(id, make, model, year, rentalRate);
        this.type=type;
    }
public String getType()
{
    return type;
}
    @Override
    public String getVehicleType() {
       return "Bike";
    }

}