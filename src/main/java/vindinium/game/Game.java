package vindinium.game;

import vindinium.IHero;
import vindinium.board.IBoard;

public class Game implements IGame {
	private String mId = null;
	private int mTurn = -1;
	private int mMaxTurns = -1;
	private IHero[] mHeroes = null;
	private IBoard mBoard = null;
	private boolean mFinished = false;
	
	public Game() { }
	
	public Game(String id, int turn, int maxTurns, IHero[] heroes, IBoard board, boolean finished) {
		setId(id);
		setTurn(turn);
		setMaxTurns(maxTurns);
		setHeroes(heroes);
		setBoard(board);
		setFinished(finished);
	}

	public String getId() {
		return mId;
	}

	public void setId(String id) {
		this.mId = id;
	}

	public int getTurn() {
		return mTurn;
	}

	public void setTurn(int turn) {
		this.mTurn = turn;
	}

	public int getMaxTurns() {
		return mMaxTurns;
	}

	public void setMaxTurns(int maxTurns) {
		this.mMaxTurns = maxTurns;
	}

	public IHero[] getHeroes() {
		return mHeroes;
	}

	public void setHeroes(IHero[] heroes) {
		this.mHeroes = heroes;
	}

	public IBoard getBoard() {
		return mBoard;
	}

	public void setBoard(IBoard board) {
		this.mBoard = board;
	}

	public boolean isFinished() {
		return mFinished;
	}

	public void setFinished(boolean finished) {
		this.mFinished = finished;
	}


}
