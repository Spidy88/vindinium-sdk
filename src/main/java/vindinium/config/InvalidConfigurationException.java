package vindinium.config;

/**
 * An exception that can be used to represent an invalid configuration.
 * 
 * @author Nick Ferraro
 *
 */
public class InvalidConfigurationException extends Exception {
	private static final long serialVersionUID = 1L;

	// Constructor to set the exception message
	public InvalidConfigurationException(String msg) {
		super(msg);
	}
}
