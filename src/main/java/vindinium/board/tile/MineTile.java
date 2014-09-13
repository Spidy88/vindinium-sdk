package vindinium.board.tile;

import vindinium.board.Tile;

public class MineTile extends Tile {
	private final int mHeroId;
	
	public MineTile() {
		this(-1);
	}
	public MineTile(int heroId) {
		mHeroId = heroId;
	}
	
	public int getHeroId() {
		return mHeroId;
	}
}
