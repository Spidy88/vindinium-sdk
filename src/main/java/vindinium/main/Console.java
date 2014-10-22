package vindinium.main;

import vindinium.Vindinium;
import vindinium.bot.core.RandoBot;
import vindinium.client.core.Config;

/**
 * An example console app that runs a Vindinium game with RandoBot.
 * 
 * This is how you would use the SDK to write your own bots. Setup
 * a configuration, create your bot, and start a game using the
 * Vindinium class.
 * 
 * @author Nick Ferraro
 *
 */
public class Console {
	private static final String SECRET_KEY = "";
	
	public static void main(String[] args) throws Exception {
		RandoBot bot = new RandoBot();
		
		Config config = new Config();
		config.setKey(SECRET_KEY);
		config.validateConfiguration();
		
		System.out.println(String.format("Starting game with configuration: %s", config.toString()));
		
		Vindinium vindinium = new Vindinium(config);
		vindinium.playGame(bot);
	}
}
