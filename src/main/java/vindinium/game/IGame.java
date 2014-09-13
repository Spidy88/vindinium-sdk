package vindinium.game;

import vindinium.IHero;
import vindinium.board.IBoard;

public interface IGame {
	public String getId();
	public int getTurn();
	public int getMaxTurns();
	public IHero[] getHeroes();
	public IBoard getBoard();
	public boolean isFinished();
}
