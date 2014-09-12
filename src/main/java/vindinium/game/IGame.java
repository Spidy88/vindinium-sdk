package vindinium.game;

import vindinium.IHero;
import vindinium.map.IMap;

public interface IGame {
	public String getId();
	public int getTurn();
	public int getMaxTurns();
	public IHero[] getHeroes();
	public IMap getMap();
	public boolean isFinished();
}
