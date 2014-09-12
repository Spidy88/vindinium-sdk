package vindinium;

import javax.swing.text.Position;

public interface IHero {
	public int getId();
	public String getName();
	public String getUserId();
	public int getELO();
	public Position getPosition();
	public int getLife();
	public int getGold();
	public int getMineCount();
	public Position getSpawnPosition();
	public boolean isCrashed();
}
