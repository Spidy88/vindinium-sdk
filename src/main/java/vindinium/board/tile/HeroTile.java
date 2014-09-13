package vindinium.board.tile;

import vindinium.board.Tile;

public class HeroTile extends Tile {
	private final int mHeroId;
	
	public HeroTile(int heroId) {
		mHeroId = heroId;
	}
	
	public int getHeroId() {
		return mHeroId;
	}
}
