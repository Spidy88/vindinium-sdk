package vindinium.logger;

import vindinium.Action;
import vindinium.client.Response;

/**
 * A logger that doesn't log squat! Used by Vindinium to reduce null checks.
 * 
 * @author Nick Ferraro
 *
 */
public class NullLogger implements ILogger {

	public void logStart(Response response) { }

	public void logMove(Action move, Response response) { }

	public void logEnd(Response response) { }

}
