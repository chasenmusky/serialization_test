
package exception;

/**
 *
 * @author Roger Myers
 * Date: April 23, 2014
 * Purpose: Create exception class that will execute when over pay amount.
 */
public class PayException extends Exception {

    public PayException(String message) {
        super(message);
    }
}
