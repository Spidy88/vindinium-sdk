package vindinium.game;

import vindinium.IHero;
import vindinium.map.IMap;

public class Game implements IGame {
	private String mId = null;
	private int mTurn = -1;
	private int mMaxTurns = -1;
	private IHero[] mHeroes = null;
	private IMap mMap = null;
	private boolean mIsFinished = false;
	
	public Game() { }
	
	public Game(String id, int turn, int maxTurns, IHero[] heroes, IMap map, boolean isFinished) {
		setId(id);
		setTurn(turn);
		setMaxTurns(maxTurns);
		setHeroes(heroes);
		setMap(map);
		setIsFinished(isFinished);
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

	public IMap getMap() {
		return mMap;
	}

	public void setMap(IMap map) {
		this.mMap = map;
	}

	public boolean isFinished() {
		return mIsFinished;
	}

	public void setIsFinished(boolean isFinished) {
		this.mIsFinished = isFinished;
	}


}
