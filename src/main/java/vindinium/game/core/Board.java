package vindinium.game.core;

import vindinium.game.IBoard;

/**
 * A simple implementation of a Vindinium board to help
 * query and interact with the game board.
 * 
 * @author Nick Ferraro
 *
 */
public class Board implements IBoard {
	private int mSize = 1;
	private String mTiles = null;

	public Board() { }
	
	/**
	 * Get the size of the board (all boards are square)
	 */
	public int getSize() {
		return mSize;
	}
	
	/**
	 * Set the size of the board (all boards are square)
	 * @param size The size of one dimension of the board
	 * @throws IllegalArgumentException Thrown if the size is less than 1
	 */
	public void setSize(int size) {
		// Validate the size parameter
		if( size < 1 ) {
			throw new IllegalArgumentException("A game board cannot have a grid size smaller than 1");
		}
		
		mSize = size;
	}

	/**
	 * Get the string representation of all tiles on this board
	 */
	public String getTiles() {
		return mTiles;
	}
	
	/**
	 * Set the string representation of the tiles on this board
	 * 
	 * @param tiles The tiles on this board as a string
	 * @throws IllegalArgumentException Thrown if the tiles are null or not the correct length
	 */
	public void setTiles(String tiles) {
		if( tiles == null || (tiles.length() !=  (mSize * mSize * 2)) ) {
			throw new IllegalArgumentException("Game board tiles cannot be null and must have a length of the board size squared x2");
		}
		
		mTiles = tiles;
	}
}
