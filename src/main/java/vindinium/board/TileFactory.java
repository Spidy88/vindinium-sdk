package vindinium.board;

import vindinium.board.tile.AirTile;
import vindinium.board.tile.HeroTile;
import vindinium.board.tile.MineTile;
import vindinium.board.tile.TavernTile;
import vindinium.board.tile.UnknownTile;
import vindinium.board.tile.WoodsTile;

public class TileFactory {
	private static final String AIR_SYMBOL = "  ";
	private static final String WOODS_SYMBOL = "##";
	private static final String TAVERN_SYMBOL = "[]";
	private static final String HERO_SYMBOL = "@";
	private static final String MINE_SYMBOL = "$";
	private static final String MINE_OWNER_NONE = "-";
	
	public static Tile tileFor(String tileStr) {
		if( AIR_SYMBOL.equals(tileStr) ) {
			return new AirTile();
		} 

		if( WOODS_SYMBOL.equals(tileStr) ) {
			return new WoodsTile();
		} 

		if( TAVERN_SYMBOL.equals(tileStr) ) {
			return new TavernTile();
		} 

		if( tileStr.startsWith(HERO_SYMBOL) ) {
			return new HeroTile(Integer.parseInt(tileStr.substring(1)));
		} 

		if( MINE_SYMBOL.equals(tileStr) ) {
			String mineOwner = tileStr.substring(1);
			if( MINE_OWNER_NONE.equals(mineOwner) ) {
				return new MineTile();
			}
			
			return new MineTile(Integer.parseInt(mineOwner));
		}
		
		return new UnknownTile();
	}
}
