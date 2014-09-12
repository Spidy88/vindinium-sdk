package vindinium;

import vindinium.config.Config;
import vindinium.config.InvalidConfigurationException;

public class Console {
	public static void main(String[] args) throws InvalidConfigurationException {
		if ( args.length % 2 != 0 ) {
			printHelp();
			return;
		}
		
		// Parse arguments and create configuration
		Config config = new Config();
		for( int i = 0; i < args.length; i += 2 ) {
			parseConfig(config, args[i], args[i+1]);
		}
		config.validateConfiguration();
		
		Client client = new Client(config);
	}
	
	private static void parseConfig(Config config, String option, String value) {
		if( "-k".equals(option) ) {
			config.setKey(value);
		} else if( "-m".equals(option) ) {
			config.setGameMode(GameMode.valueOf(value));
		} else if( "-t".equals(option) ) {
			try {
				config.setTurns(Integer.parseInt(value));
			} catch( NumberFormatException e ) {
				System.err.println(String.format("Unable to parse number of turns option: %1$s\n", value));
			}
		} else if( "-i".equals(option) ) {
			config.setMapId(value);
		} else if( "-d".equals(option) ) {
			config.setBaseUrl(value);
		} else {
			System.err.println(String.format("Unknown option: %1$s\n", option));
			printHelp();
		}
	}
	
	private static void printHelp() {
		System.out.println("Welcome to the Vindinium client. Here are you options.");
		System.out.println("======================================================");
		System.out.println("-k {string}\t\tSecret key (required)");
		System.out.println("-m {training|arena}\tGame mode (training|arena)");
		System.out.println("-t {int}\t\tNumber of turns");
		System.out.println("-i {string}\t\tMap id");
		System.out.println("-d {string}\t\tServer api url");
		System.out.println("-h\t\t\tHelp (you obviously already know this one)\n");
	}
}
