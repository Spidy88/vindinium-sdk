package vindinium.map;

public class Tile {
	public static final String AIR_SYMBOL = "  ";
	public static final String WOOD_SYMBOL = "##";
	public static final String TAVERN_SYMBOL = "[]";
	public static final String HERO_SYMBOL = "@-";
	public static final String MINE_SYMBOL = "$-";
	public static final String MineForHero(int hero) {
		return "$" + hero;
	}
}
