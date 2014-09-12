package vindinium.game;

import javax.swing.text.Position;

import org.json.JSONArray;
import org.json.JSONObject;

import vindinium.Hero;
import vindinium.IHero;

public class GameResponseParser {
	public static final String KEY_GAME = "game";
	public static final String KEY_HERO = "hero";
	public static final String KEY_TOKEN = "token";
	public static final String KEY_VIEW_URL = "viewUrl";
	public static final String KEY_PLAY_URL = "playUrl";
	public static final String KEY_ID = "id";
	public static final String KEY_TURN = "turn";
	public static final String KEY_MAX_TURNS = "maxTurns";
	public static final String KEY_HEROES = "heroes";
	public static final String KEY_MAP = "map";
	public static final String KEY_IS_FINISHED = "isFinished";
	public static final String KEY_NAME = "name";
	public static final String KEY_USER_ID = "userId";
	public static final String KEY_ELO = "elo";
	public static final String KEY_LIFE = "life";
	public static final String KEY_GOLD = "gold";
	public static final String KEY_MINE_COUNT = "mineCount";
	public static final String KEY_IS_CRASHED = "isCrashed";
	public static final String KEY_POSITION = "position";
	public static final String KEY_SPAWN_POSITION = "spawnPosition";
	public static final String KEY_POSITION_X = "x";
	public static final String KEY_POSITION_Y = "y";
	
	public IGame parseResponseJson(JSONObject response) {
		Game parsedGame = new Game();
		
		String token = response.getString(KEY_TOKEN);
		String viewUrl = response.getString(KEY_VIEW_URL);
		String playUrl = response.getString(KEY_PLAY_URL);
		
		JSONObject gameObject = response.getJSONObject(KEY_GAME);
		String id = gameObject.getString(KEY_ID);
		int turn = gameObject.getInt(KEY_TURN);
		int maxTurns = gameObject.getInt(KEY_MAX_TURNS);
		boolean isFinished = gameObject.getBoolean(KEY_IS_FINISHED);
		
		JSONArray heroesArray = gameObject.getJSONArray(KEY_HEROES);
		IHero[] heroes = new IHero[heroesArray.length()];
		for( int i = 0; i < heroesArray.length(); ++i ) {
			JSONObject heroObject = heroesArray.getJSONObject(i);
			heroes[i] = parseHero(heroObject);
		}
		
		JSONObject mapObject = gameObject.getJSONObject(KEY_MAP);
		
		JSONObject heroObject = response.getJSONObject(KEY_HERO);
		IHero hero = parseHero(heroObject);
		
		return parsedGame;
	}
	
	public IHero parseHero(JSONObject heroObject) {
		Hero parsedHero = new Hero();
		
		int id = heroObject.getInt(KEY_ID);
		String name = heroObject.getString(KEY_NAME);
		String userId = heroObject.getString(KEY_USER_ID);
		int elo = heroObject.getInt(KEY_ELO);
		int life = heroObject.getInt(KEY_LIFE);
		int gold = heroObject.getInt(KEY_GOLD);
		int mineCount = heroObject.getInt(KEY_MINE_COUNT);
		boolean isCrashed = heroObject.getBoolean(KEY_IS_CRASHED);
		
		JSONObject positionObject = heroObject.getJSONObject(KEY_POSITION);
		int positionX = positionObject.getInt(KEY_POSITION_X);
		int positionY = positionObject.getInt(KEY_POSITION_Y);
		
		JSONObject spawnPositionObject = heroObject.getJSONObject(KEY_SPAWN_POSITION);
		int spawnPositionX = spawnPositionObject.getInt(KEY_POSITION_X);
		int spawnPositionY = spawnPositionObject.getInt(KEY_POSITION_Y);
		
		return parsedHero;
	}
}
