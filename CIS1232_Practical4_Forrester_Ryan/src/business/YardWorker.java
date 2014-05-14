/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class YardWorker extends Employee{
    
    double grass;
    double RATE = 40.00; 
    public YardWorker() {
        
        Scanner input = new Scanner(System.in);
        System.out.println("How many times have they cut the grass?");
        this.grass = input.nextDouble();
    }

    @Override
    public double calculatePay() throws PayException{
        double pay = grass * RATE;
        if(pay > 1000){
            throw( new PayException());
        }
        setPayAmount(pay);
        return pay;
    }
    
}
