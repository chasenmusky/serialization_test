package base;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Ryan Forrester
 * @since April 20, 2014
 *
 * Purpose creates the frame for its child classes
 */
public abstract class Employee implements Payable, Serializable {

    String name;
    String phoneNum;
    double payAmount;
    String employeeNumber;
    boolean isEmployeeNumberValid;

    public Employee() {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the employee number of this worker? (choose from 1-999)");
        employeeNumber = input.nextLine();

        while (!isEmployeeNumberValid) {
            if (isNumeric(employeeNumber)) {
               employeeNumber = employeeNumber.replaceFirst("^0+(?!$)", "");

                int empNumInt = Integer.parseInt(employeeNumber);

                if (empNumInt < 1000 && empNumInt > 0) {
                    if (empNumInt < 10) {
                        employeeNumber = "00" + employeeNumber;
                        isEmployeeNumberValid = true;
                        break;
                    } else if (empNumInt < 100 && empNumInt > 9) {
                        employeeNumber = "0" + employeeNumber;
                        isEmployeeNumberValid = true;
                        break;
                    } else {
                        isEmployeeNumberValid = true;
                        break;
                    }
                }
            }
            System.out.println("What is the employee number of this worker? (choose from 1-999)");
            employeeNumber = input.nextLine();
        }
        System.out.println("What is the name of this worker?");
        name = input.nextLine();
        System.out.println("What is their phone number?");
        phoneNum = input.nextLine();
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }
    
    public int getIntEmployeeNumber(){
        return Integer.parseInt(employeeNumber);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public String toString() {
        return "-----------------------------------------------\n"
                + "Employee Number: " + this.employeeNumber
                + "\nEmployee Name: " + this.name
                + "\nPhone Number: " + this.phoneNum
                + "\nPay: " + this.payAmount;
    }

    public String getStringRecord() {
        DecimalFormat df2 = new DecimalFormat("0000.00");
        String delimiter = ",";
        final String NAME_FORMAT = "          ";
        final String PHONE_FORMAT = "          ";
        final int NAME_LENGTH = NAME_FORMAT.length();
        final int PHONE_LENGTH = PHONE_FORMAT.length();
        StringBuilder sb1 = new StringBuilder(name);
        StringBuilder sb2 = new StringBuilder(phoneNum);
        sb1.setLength(NAME_LENGTH);
        sb2.setLength(PHONE_LENGTH);
        name = sb1.toString();
        phoneNum = sb2.toString();
        return employeeNumber + delimiter + name + delimiter + phoneNum + delimiter + df2.format(payAmount) + System.getProperty("line.separator");
    }

    /**
     * Simple isNumeric method that returns true if a parsable entry is passed.
     */
    public static boolean isNumeric(String str) {
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
