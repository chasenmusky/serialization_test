
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
public class BabySitter extends Employee{
    double hours;
    double hourlyWage;
    double pay;
    
    public BabySitter() {        
        Scanner input = new Scanner(System.in);
        System.out.println("How many hours did they work?");
        this.hours = input.nextDouble();
        System.out.println("What is the hourly wage?");
        this.hourlyWage = input.nextDouble();
        //either write to file here
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getPay() {
        return pay;
    }

    @Override
    public double calculatePay() throws PayException{//telling it that it might throw
        pay = hours * hourlyWage;
        if(pay > 1000){
            throw( new PayException());
        }
        setPayAmount(pay);
        return pay;
    }
    
    
    
}
