
package base;

import exception.PayException;

/**
 * @author Ryan Forrester
 * @since April 20, 2014
 * 
 * Purpose
 * This class is used in all of the employee classes
 */
public interface Payable {
    public double calculatePay() throws PayException;
}
