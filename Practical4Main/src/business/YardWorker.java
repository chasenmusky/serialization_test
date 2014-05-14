
package business;

import java.util.Scanner;
import base.Employee;

/**
 *
 * @author Roger Myers
 * Date: April 23, 2014
 * Purpose: Create Yard worker class.
 */
public class YardWorker extends Employee {

    Scanner input = new Scanner(System.in);
    //Class variables
    private double cutAmount;
    private final double CUT_AMOUNT = 40.0;

    //Construct that calls super constructor and throws exception.
    public YardWorker() throws Exception {
        super();
        System.out.println("How many time have you cut the grass?");
        cutAmount = input.nextInt();
        calculatePay();

    }

    public double getCutAmount() {
        return cutAmount;
    }

    @Override
    //Pay is a rate per cut * by how many cuts.
    public double calculatePay() {
        setPayAmount(cutAmount * CUT_AMOUNT);
        return getPayAmount();
    }

    @Override
    //Overriding to add extra attributes.
    public String toString() {
        return super.toString() + "\nNumber of cuts: " + cutAmount + "\nCut Rate" + CUT_AMOUNT;
    }
}
