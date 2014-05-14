
package base;

import java.util.Scanner;

/**
 *
 * @author Roger Myers
 * Date: April 23, 2014
 * Purpose: Create an abstract class that will be extended by all types of employees
 */
public abstract class Employee implements Payable {

    Scanner input = new Scanner(System.in);
    //Declaring abstract variables.
    private String name;
    private String phoneNumber;
    private double payAmount;

    //Throwing exception that will be caught later.
    public Employee() throws Exception {
        System.out.println("Please enter your name: ");
        name = input.nextLine();
        System.out.println("Enter your phone number: ");
        phoneNumber = input.nextLine();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    @Override
    //Overriding the toString to add the extra attributes.
    public String toString() {
        return "\n\nName: " + name + "\nPhone: " + phoneNumber + "\nPay: $" + payAmount;
    }

    @Override
    public double calculatePay() {
        return payAmount;
    }
}
