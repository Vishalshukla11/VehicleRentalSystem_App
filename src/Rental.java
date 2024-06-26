import java.util.Date;
public class Rental
{
private String rentalId;
private Vehicle vehicle;
private String customerName;
private Date rentalStartDate;
private Date rentalEndDate;
private boolean isReturned ;

public boolean isReturned()
{
    return isReturned;
}
public Rental(String rentalId,Vehicle vehicle,String customerName,Date rentalStartDate)
{
    this.rentalId=rentalId;
    this.vehicle=vehicle;
    this.customerName=customerName;
    this.rentalStartDate=rentalStartDate;
    this.isReturned=false;
}
public String getRentalId()
{
    return rentalId ;
}
public Vehicle getVehicle()
{
    return vehicle ;
}
public String getCustomerName()
{
    return customerName;
}
public Date getRentalStartDate()
{
    return rentalStartDate;
}
public Date getRentalEndDate()
{
    return rentalEndDate;
}

public void returnVehicle(Date rentalEnDate)
{
    this.rentalEndDate=rentalEnDate;
    this.isReturned=true;
    this.vehicle.setRented(false);
}
public double calculateRentalCharges()
{/*Math.abs(...) is used to ensure that the difference is positive, regardless of the order of rentalEndDate
     and rentalStartDate. This is because the number of milliseconds between two dates should always be a positive
      value, and Math.abs() ensures that.
 */
    long diffInMillies=Math.abs(rentalEndDate.getTime()-rentalStartDate.getTime());
    long diff =diffInMillies/(1000*60*60*24);//converts the difference from milliseconds to days.
    return diff*vehicle.getRrentalRate();
}
}