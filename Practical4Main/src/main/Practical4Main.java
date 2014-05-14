package main;

import base.Employee;

import business.BabySitter;
import business.CarCleaner;
import business.YardWorker;
import exception.PayException;
import java.util.ArrayList;
import java.util.Scanner;

public class Practical4Main {

    /**
     * This is the main method for the practical#4 for CIS1232.
     *
     * @author: CIS1232 Roger Myers
     * @since: 2014-04-15
     *  Create employee paying program.
     * @param args the command line arguments
     */
    public static Scanner input = new Scanner(System.in);
    //This is the menu to be displayed to the user.
    public static final String menu =
            "\n------------------------------------------------------------\n"
            + "Add employees using one of the following options\n"
            + "1) add a babysitter\n"
            + "2) add a yard worker\n"
            + "3) add a car cleaner\n"
            + "X) exit and show details\nchoice:";

    public static void main(String[] args) throws PayException {

        boolean finished = false;
        ArrayList<Employee> allWorkers = new ArrayList();
        double total = 0.0;


        //************************************************************************
        // Allow the user to add as many employees as they desire.  The can indicate they
        // are finished by entering x.
        //************************************************************************
        while (!finished) {
            Employee newEmployee = null;
            System.out.println(menu);
            String userOption = input.nextLine();
            try {

                switch (userOption) {
                    case "1":  //Add new babysitter
                        newEmployee = new BabySitter();

                        //Throwing exception to be caught below
                        if (newEmployee.getPayAmount() > 1000) {
                            throw new PayException("Pay too high");
                        }
                        break;
                    case "2":  //Add new yard worker
                        newEmployee = new YardWorker();
                        if (newEmployee.getPayAmount() > 1000) {
                            //Throwing exception to be caught below
                            throw new PayException("Pay too high");
                        }
                        break;
                    case "3":  //Add new car cleaner
                        newEmployee = new CarCleaner();
                        if (newEmployee.getPayAmount() > 1000) {
                            //Throwing exception to be caught below
                            throw new PayException("Pay too high");
                        }
                        break;
                    case "X":
                    case "x":
                        System.out.println("Finished adding employees");
                        finished = true;
                        break;
                    default:
                        System.out.println("Invalid option");

                }

                //If not finished then add the new employee to the List of employees.
                if (!finished) {
                    allWorkers.add(newEmployee);
                }
            } catch (PayException pe) //Catch the PayException
            {
                System.out.println("Error:" + pe.getMessage());


            } catch (Exception ex) {//Catching all exceptions. 
                System.err.println("Error: There was a data entry problem");
            }

        }
        //Will loop through the array list and add up all the totals
        for (int x = 0; x < allWorkers.size(); ++x) {
            total = total + allWorkers.get(x).getPayAmount();
        }
        //After all employees are added, display their information back to the user.  
        for (Employee nextEmployee : allWorkers) {
            System.out.println(nextEmployee);
        }
        System.out.println("\n\nTotal: $" + total);



    }
}
