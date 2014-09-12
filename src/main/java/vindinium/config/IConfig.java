package vindinium.config;

import vindinium.GameMode;

public interface IConfig {
	public String getKey();
	public String getBaseUrl();
	public GameMode getGameMode();
	public Integer getTurns();
	public String getMapId();
}
