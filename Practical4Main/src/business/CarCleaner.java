
package business;

import base.Employee;
import java.util.Scanner;

/**
 *
 * @author Roger Myers
 * Date: April 23, 2014
 * Purpose: Create car cleaner employee.
 */
public class CarCleaner extends Employee {

    Scanner input = new Scanner(System.in);
    //Class variables and Constants.
    private final double CAR_RATE = 20.0;
    private final double WAX_RATE = 50.0;
    private int carsWashed;
    private int carsWaxed;

    //Constructor that calls the super and throws exception.
    public CarCleaner() throws Exception {
        super();
        System.out.println("How many cars cleaned?");
        carsWashed = input.nextInt();
        System.out.println("How many cars waxed?");
        carsWaxed = input.nextInt();
        calculatePay();


    }

    @Override
    //Pay is on how many cars washed at a rate and how many cars waxed at a rate added together.
    public double calculatePay() {
        setPayAmount((carsWashed * CAR_RATE) + (carsWaxed * WAX_RATE));
        return getPayAmount();
    }

    @Override
    //Overridding the toString to add the extra attributes.
    public String toString() {
        return super.toString() + "\nNumber of washes: " + carsWashed + "\nNumber of Waxes: " + carsWaxed;
    }
}
