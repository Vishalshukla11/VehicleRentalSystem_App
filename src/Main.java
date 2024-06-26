// package com;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class Main
{
     private  static VehicleServices vehicleServices= new VehicleServices();
     private  static RentalServices rentalServices= new RentalServices();

   private static  Scanner sc= new Scanner(System.in);
    public static void main(String args[])
    {  
       while(true)
       {
        System.out.println("Welcome to vehicle rental service");
        System.out.println("1. car service ");
        System.out.println("2. Bike service");
        System.out.println("3. Exit ");
        System.out.println("please select a service: ");
        int Choice=sc.nextInt();
        sc.nextLine();//consume newxt line

        switch(Choice)
        {
            case 1 : 
            carServiceMenu();
            break;
            case 2 : 
            bikeServiceMenu();
            break;
            case 3 :
            System.out.println("Exiting the System . Thank you ");
            return;
            default :
            System.out.println("Invalid choive please try again");
        }
       }
    }

    private static void carServiceMenu()
    {
        while(true)
        {
            System.out.println("car service menu");
            System.out.println("1. add car");
            System.out.println("2. rent Car ");
            System.out.println("3. Return car ");
            System.out.println("4. calculate Rental charges ");
            System.out.println("5. Back to main menu ");
            System.out.print("please select an option ");
            int Choice=sc.nextInt();
            sc.nextLine();
            switch(Choice)
            {
                case 1 : 
                addCar();
                break;

                case 2 : 
                rentvehicle("car");
                break;

                case 3 :
                returnVehicle();
                break;

                case 4:
                calculateRentalCharges();
                break;

                case 5: 
                return;
                default:
                System.out.println("Invalid choice please try again ");

            }
        }
    }
    private static void bikeServiceMenu()
    {
        System.out.println("Bike Service Menu");
        System.out.println("1. add Bike ");
        System.out.println("2.Rent Bike ");
        System.out.println("3.Return Bike ");
        System.out.println("4.Calculate rental charge");
        System.out.println("5.Back to main menu");
        System.out.print("please select an option");
        int choice =sc.nextInt();
        sc.nextLine();
        switch(choice)
        {
            case 1 : 
            addBike();
            break;
            case 2 :
            rentvehicle("Bike");
            break;
            case 3 :
            returnVehicle();
            break;

            case 4 :
            calculateRentalCharges();
            break;
            case 5:
            return;
            default:
            System.out.println("Invalid choive please try again");
        }
    }

    private static void addCar()
    {
        VehicleServices vehicleServices= new VehicleServices();

        System.out.println("Enter carID:");
        String id=sc.nextLine();
        System.out.println("Enter Make:");
        String make=sc.nextLine();
        System.out.println("Enter Model:");
        String model=sc.nextLine();
        System.out.println("Enter Year:");
        int year=sc.nextInt();
        System.out.println("Enter Rental rate:");
        double rentalRate=sc.nextDouble();
        System.out.println("Enter Number of Doors:");
        int numDoors=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter fule Type: ");
        String fuelType=sc.nextLine();
        Vehicle car = new Car(id,make,model,year,rentalRate,numDoors,fuelType);
         vehicleServices.addVehicle(car);
         System.out.println("car added successFully");

    }

    private static void addBike()
    { VehicleServices vehicleServices= new VehicleServices() ;
        System.out.println("Enter Bike Id: ");
        String id=sc.nextLine() ;
        System.out.println("Enter Make :");
        String make=sc.nextLine();
        System.out.println("Enter model:");
        String model=sc.nextLine();
        System.out.println("Enter Year: ");
        int year=sc.nextInt();
        System.out.println("enter rental rate:");
        double rentalRate= sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter type :(e.g. , Mountain ,read)");
        String type=sc.nextLine();

        Vehicle bike = new Bike(id,make,model,year,rentalRate,type);
        vehicleServices. addVehicle(bike);
        System.out.println("Bike added successfully ");
    }


    private static void rentvehicle(String vehicleType)
    {
        //VehicleServices vehicleServices= new VehicleServices();

        System.out.println("Enter Vehicle Id:");
        String vehicleId=sc.nextLine();
         
        // Retrieve the vehicle from the vehicle service based on ID
        Vehicle vehicle = vehicleServices.getVehicleById(vehicleId);
            
        // Check if the vehicle exists, matches the specified type, and is not already rented
        if(vehicle !=null && vehicle.getVehicleType().equals(vehicleType)&&!vehicle.isRented())
        {
            System.out.println("Enter customer Name:");
            String customerName=sc.nextLine();

             // Prompt user for rental start date
            System.out.println("Enter rental start Date (yyyy-MM-dd):");
            String startDateStr=sc.nextLine();
            Date startdate=parseDate(startDateStr);// Parse the input date string

            // Generate a unique rental ID
            String rentalId=UUID.randomUUID().toString();

             // Rent the vehicle using the rental service
             rentalServices.rentVehicle(rentalId,vehicle,customerName,startdate);
             System.out.println(vehicleType + "rented successfully");
        }
        else{
            System.out.println("Vehicle not availabe for rent or Invalid Id");
        }
    }
     
     private static void returnVehicle()
     {
        System.out.println("Enter rental ID :");
        String rentalId=sc.nextLine();
        
        System.out.println("enter rental end date (yyy-mm-dd); ");
        String endDateStr=sc.nextLine();
        Date endDate=parseDate(endDateStr);//parse the input date string 

        //return the Vehicle using the rental service 
        rentalServices.returnVehicle(rentalId,endDate);
        System.out.println("Vehicle return successfully ");
     }

     private static void calculateRentalCharges()
     {
        String rentalId=sc.nextLine();
        double charges=rentalServices.calculateRentalCharges(rentalId);
        System.out.println("Rental charges :  " + charges);
     }

     // Utility method to parse date string into Date object
     private static Date parseDate(String dateStr)
     {
         try{
             return new SimpleDateFormat("yyyy-mm-dd").parse(dateStr);
         }
         catch(ParseException e)
         {
             System.out.println("Invalid date format. please use yyyy-mm-dd.");
             return null;
         }
     }


     
}