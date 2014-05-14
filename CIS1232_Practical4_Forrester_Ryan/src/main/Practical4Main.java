package main;

import base.Employee;
import business.*;
import exception.PayException;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.*;

public class Practical4Main {

    /**
     * This is the main method for the practical#4 for CIS1232.
     *
     * @author: CIS1232
     * @since: 2014-04-15
     *
     * @param args the command line arguments
     */
    /**
     * @author Ryan Forrester
     * @since April 20, 2014
     *
     * Purpose This class is designed to use the employee class and all its
     * child classes
     */
    static Scanner input = new Scanner(System.in);
    static Path empFile = Paths.get("C:\\test\\employees.txt");
    static Path serFile = Paths.get("C:\\test\\Employee.ser");
    static String record = createStringFormat();
    public static final int REC_SIZE = record.length();
    static ArrayList<Employee> allWorkers = new ArrayList();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //This is the menu to be displayed to the user.
        final String menu = "\n------------------------------------------------------------\n"
                + "Add employees using one of the following options:\n"
                + "1) add a babysitter\n"
                + "2) add a yard worker\n"
                + "3) add a car cleaner\n"
                + "X) exit and show details\nchoice:";
        try {
            if (Files.notExists(empFile) || Files.notExists(serFile)) {
                String path = "C:" + File.separator + "test" + File.separator + "employees.txt";
                String path2 = "C:" + File.separator + "test" + File.separator + "Employee.ser";
                File f = new File(path);
                File f2 = new File(path2);
                f.getParentFile().mkdirs();
                f.createNewFile();
                f2.createNewFile();
                createEmptyFile(empFile, record);
            }
            openFile();
            displayEmployees();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e);
        }

        boolean finished = false;
        String name;
        String phoneNum;
        FileChannel fc = null;
        //************************************************************************
        // Allow the user to add as many employees as they desire.  The can indicate they
        // are finished by entering x.
        //************************************************************************
        try {
            fc = (FileChannel) Files.newByteChannel(empFile, READ, WRITE);
            while (!finished) {
                try {
                    Employee newEmployee = null;
                    System.out.println(menu);
                    String userOption = input.nextLine();

                    switch (userOption) {
                        case "1":  //Add new babysitter
                            newEmployee = new BabySitter();
                            newEmployee.setPayAmount(newEmployee.calculatePay());
                            saveRecord(newEmployee, fc);
                            break;
                        case "2":  //Add new yard worker
                            newEmployee = new YardWorker();
                            newEmployee.setPayAmount(newEmployee.calculatePay());
                            saveRecord(newEmployee, fc);
                            break;
                        case "3":  //Add new car cleaner
                            newEmployee = new CarCleaner();
                            newEmployee.setPayAmount(newEmployee.calculatePay());
                            saveRecord(newEmployee, fc);
                            break;
                        case "X":
                        case "x":
                            System.out.println("Finished adding employees");
                            saveAllRecords(allWorkers);
                            displayEmployees();
                            finished = true;
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                    //If not finished then add the new employee to the List of employees.
                    if (!finished) {
                        allWorkers.add(newEmployee);
                    }
                } catch (IOException io) {
                    System.out.println("Error:" + io);
                } catch (ClassNotFoundException cnfe) {
                    System.out.println("Error: " + cnfe);
                } catch (PayException pe) {
                    System.out.println("Error:" + pe.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: There was a data entry error!");
                }
            }
            double totalPay = 0.0;
            for (Employee nextEmployee : allWorkers) {
                totalPay += nextEmployee.getPayAmount();
            }
            System.out.println("\nThe total amount owed is: " + totalPay);
            fc.close();
        } catch (IOException io) {
            System.out.println("Error:" + io);
        }
    }

  

   
    public static void saveAllRecords(ArrayList<Employee> emp) throws IOException {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\test\\Employee.ser"));
            oos.writeObject(emp);
            oos.close();
        } catch (IOException io) {
            System.out.println("Error: " + io);
        }
    }

    public static void displayEmployees() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\test\\Employee.ser"));
            ArrayList<Employee> empRestore = (ArrayList<Employee>) is.readObject();
            allWorkers = empRestore;

            EmployeeCompare employeeCompare = new EmployeeCompare();
            Collections.sort(allWorkers, employeeCompare);

            for (Employee nextEmployee : allWorkers) {
                System.out.println(nextEmployee);
            }
        } catch (EOFException eofe) {
            System.out.println("No data in file yet!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errofdfsdfr: " + e);
        }
    }

   
    static class EmployeeCompare implements Comparator<Employee> {

        @Override
        public int compare(Employee e1, Employee e2) {
            // write comparison logic here like below , it's just a sample
            if (e1.getIntEmployeeNumber() < e2.getIntEmployeeNumber()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
