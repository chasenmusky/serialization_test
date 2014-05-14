package business;

import base.Employee;
import exception.PayException;
import java.util.Scanner;

/**
 * @author Ryan Forrester
 * @since April 20, 2014
 * 
 * Purpose
 * child class of Employee
 */
public class CarCleaner extends Employee{
    double clean;
    double wax;
    double CLEAN_RATE = 20.00;
    double WAX_RATE = 50.00;
    public CarCleaner() {
        
        Scanner input = new Scanner(System.in);
        System.out.println("How many cars were cleaned?");
        this.clean = input.nextDouble();
        System.out.println("How many cars were waxed?");
        this.wax = input.nextDouble();
    }

    @Override
    public double calculatePay() throws PayException{
        double pay = (clean * CLEAN_RATE) + (wax * WAX_RATE);// calculate the pay
        if(pay > 1000){
            throw( new PayException());
        }
        setPayAmount(pay);
        return pay;
    }
    
}
