package vindinium.board;

public class Board implements IBoard {
	private int mSize = -1;
	private Tile[][] mTiles = null;

	public Board() { }
	
	public int getSize() {
		return mSize;
	}
	
	public void setSize(int size) {
		mSize = size;
	}

	public Tile getTile(int x, int y) {
		return mTiles[y][x];
	}
	
	public void setTile(Tile tile, int x, int y) {
		mTiles[y][x] = tile;
	}
	
	public Tile[][] getTiles() {
		return mTiles;
	}
	
	public void setTiles(Tile[][] tiles) {
		mTiles = tiles;
	}
}
