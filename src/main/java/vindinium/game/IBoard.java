package vindinium.game;

/**
 * An interface for Vindinium game board data
 * 
 * @author Nick Ferraro
 *
 */
public interface IBoard {
	/**
	 * Get the size of the board
	 * 
	 * @return The board's size
	 */
	public int getSize();
	
	/**
	 * Get the string representation of the board's tiles
	 * 
	 * @return The board's tiles as a string
	 */
	public String getTiles();
}
