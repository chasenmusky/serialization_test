package exception;
/**
 * @author Ryan Forrester
 * @since April 20, 2014
 * 
 * Purpose
 * If pay is higher than 1000 this exception is thrown
 */
public class PayException extends Exception{
    public PayException(){
        super("Pay to high");
    }
}
