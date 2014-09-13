package vindinium.client;

import org.json.JSONArray;
import org.json.JSONObject;

import vindinium.Hero;
import vindinium.IHero;
import vindinium.Position;
import vindinium.board.Board;
import vindinium.board.IBoard;
import vindinium.board.Tile;
import vindinium.board.TileFactory;
import vindinium.game.Game;

public class ResponseParser {	
	public Response parseResponseJson(JSONObject response) {
		Game parsedGame = new Game();
		IHero parsedHero = null;
		
		// Parse first level attributes
		JSONObject gameObject = response.getJSONObject(JSON.GAME);
		JSONObject heroObject = response.getJSONObject(JSON.HERO);
		String token = response.getString(JSON.TOKEN);
		String viewUrl = response.getString(JSON.VIEW_URL);
		String playUrl = response.getString(JSON.PLAY_URL);
		// End first level attributes
		
		// Parse game level attributes
		parsedGame.setId( gameObject.getString(JSON.Game.ID) );
		parsedGame.setTurn( gameObject.getInt(JSON.Game.TURN) );
		parsedGame.setMaxTurns( gameObject.getInt(JSON.Game.MAX_TURNS) );
		parsedGame.setFinished( gameObject.getBoolean(JSON.Game.FINISHED) );
		
		// Parse heroes array
		JSONArray heroesArray = gameObject.getJSONArray(JSON.Game.HEROES);
		IHero[] heroes = new IHero[heroesArray.length()];
		for( int i = 0; i < heroesArray.length(); ++i ) {
			JSONObject currentHeroObject = heroesArray.getJSONObject(i);
			heroes[i] = parseHero(currentHeroObject);
		}
		parsedGame.setHeroes(heroes);
		// End parse heroes array
		
		// Parse board
		JSONObject boardObject = gameObject.getJSONObject(JSON.Game.BOARD);
		parsedGame.setBoard( parseBoard(boardObject) );
		// End parse board
		// End game level attributes
		
		// Parse hero level attributes
		parsedHero = parseHero(heroObject);
		// End hero level attributes
		
		return new Response(token, viewUrl, playUrl, parsedGame, parsedHero);
	}
	
	public IHero parseHero(JSONObject heroObject) {
		Hero parsedHero = new Hero();
		
		parsedHero.setId( heroObject.getInt(JSON.Hero.ID) );
		parsedHero.setName( heroObject.getString(JSON.Hero.NAME) );
		parsedHero.setUserId( heroObject.getString(JSON.Hero.USER_ID) );
		parsedHero.setELO( heroObject.getInt(JSON.Hero.ELO) );
		parsedHero.setLife( heroObject.getInt(JSON.Hero.LIFE) );
		parsedHero.setGold( heroObject.getInt(JSON.Hero.GOLD) );
		parsedHero.setMineCount( heroObject.getInt(JSON.Hero.MINE_COUNT) );
		parsedHero.setCrashed( heroObject.getBoolean(JSON.Hero.CRASHED) );
		
		JSONObject positionObject = heroObject.getJSONObject(JSON.Hero.POSITION);
		int positionX = positionObject.getInt(JSON.Hero.Position.X);
		int positionY = positionObject.getInt(JSON.Hero.Position.Y);
		parsedHero.setPosition(new Position(positionX, positionY));
		
		JSONObject spawnPositionObject = heroObject.getJSONObject(JSON.Hero.SPAWN_POSITION);
		int spawnPositionX = spawnPositionObject.getInt(JSON.Hero.Position.X);
		int spawnPositionY = spawnPositionObject.getInt(JSON.Hero.Position.Y);
		parsedHero.setSpawnPosition(new Position(spawnPositionX, spawnPositionY));
		
		return parsedHero;
	}
	
	public IBoard parseBoard(JSONObject boardObject) {
		Board parsedBoard = new Board();
		
		int size = boardObject.getInt(JSON.Game.Board.SIZE);
		Tile[][] tiles = new Tile[size][size];
		String tilesStr = boardObject.getString(JSON.Game.Board.TILES);
		
		for( int i = 0; i < size; ++i ) {
			int row = i / size;
			int col = i % size;
			
			String tileStr = tilesStr.substring(i*2, i*2+2);
			tiles[row][col] = TileFactory.tileFor(tileStr);
		}
			
		parsedBoard.setSize(size);
		parsedBoard.setTiles(tiles);
		return parsedBoard;
	}
}
