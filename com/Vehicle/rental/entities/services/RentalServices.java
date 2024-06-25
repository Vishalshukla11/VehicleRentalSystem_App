package com.Vehicle.rental.entities.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Vehicle.rental.entities.Rental;
import com.Vehicle.rental.entities.Vehicle;


public class RentalServices
{
  private List<Rental> rentals = new ArrayList<>();

  public void rentVehicle(String rentalId, Vehicle vehicle, String customerName,Date rentalStartDate)
  {
    if(!vehicle.isRented())
    {
        vehicle.setRented(true);
        Rental rental= new Rental(rentalId, vehicle, customerName, rentalStartDate);
        rentals.add(rental);
    }
    else
    {
        System.out.println("Vehicle is already rented. ");
    }

  }

  public void returnVehicle(String rentalId , Date rentalEndDate)
  {
    for(Rental rental : rentals)
    {
        if(rental.getRentalId().equals(rentalId) && !rental.isReturned())
        {
            rental.returnVehicle(rentalEndDate);
            break;

        }
    }
  }

  public double calculateRentalCharges(String rentalId)
  {
    for(Rental rental: rentals)
    {
        if(rental.getRentalId().equals(rentalId)&& rental.isReturned())
        {
            return rental.calculateRentalCharges() ;
        }
    }
    return 0;
  }

  public List<Rental> getAllRentals()
  {
    return rentals;
  }
}