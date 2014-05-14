
package business;

import base.Employee;
import java.util.Scanner;

/**
 *
 * @author Roger Myers
 * Date: April 23, 2014
 * Purpose: Create babysitter class.
 */
public class BabySitter extends Employee {

    Scanner input = new Scanner(System.in);
    //Baby Sitter class variables.
    private double hoursWorked;
    private double hourlyWage;

    //Constructor calling the employee super to get employee info
    //Throws exception that should handle all exceptions.
    public BabySitter() throws Exception {
        super();
        System.out.println("How many hours worked?");
        hoursWorked = input.nextInt();
        System.out.println("What is the hourly wage?");
        hourlyWage = input.nextInt();
        calculatePay();

    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    @Override
    //Pay is hours worked by the hourly wage.
    public double calculatePay() {
        setPayAmount(hoursWorked * hourlyWage);
        return getPayAmount();
    }

    @Override
    //Overriding to add the extra attributes.
    public String toString() {
        return super.toString() + "\nNumber of hours worked: " + hoursWorked + "\nHourly Rate: " + hourlyWage;
    }
}
