package vindinium.board;

public interface IBoard {
	public int getSize();
	public Tile getTile(int x, int y);
	public Tile[][] getTiles();
}
