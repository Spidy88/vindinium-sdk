package vindinium.config;

import vindinium.GameMode;

public class Config implements IConfig {
	public static final GameMode DEFAULT_GAME_MODE = GameMode.ARENA;
	public static final String DEFAULT_BASE_URL = "http://vindinium.org/api";
	
	private String mKey = null;
	private String mBaseUrl = DEFAULT_BASE_URL;
	private GameMode mGameMode = DEFAULT_GAME_MODE;
	private Integer mTurns = null;
	private String mMapId = null;
	
	public String getKey() {
		return mKey;
	}
	public void setKey(String key) {
		mKey = key;
	}
	public String getBaseUrl() {
		return mBaseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		mBaseUrl = baseUrl;
	}
	public GameMode getGameMode() {
		return mGameMode;
	}
	public void setGameMode(GameMode gameMode) {
		mGameMode = gameMode;
	}
	public Integer getTurns() {
		return mTurns;
	}
	public void setTurns(Integer turns) {
		mTurns = turns;
	}
	public String getMapId() {
		return mMapId;
	}
	public void setMapId(String mapId) {
		mMapId = mapId;
	}
	
	public void validateConfiguration() throws InvalidConfigurationException {
		if( mKey == null ) {
			throw new InvalidConfigurationException("No key provided in configuration");
		}
		
		if( mBaseUrl == null ) {
			throw new InvalidConfigurationException("Base url cannot be null");
		}
		
		if( mGameMode == null ) {
			throw new InvalidConfigurationException("Game mode cannot be null");
		}
		
		if( mTurns != null && mTurns < 1 ) {
			throw new InvalidConfigurationException("Turns cannot be less than 1");
		}
	}
}
