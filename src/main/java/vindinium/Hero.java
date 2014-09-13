package vindinium;

public class Hero implements IHero {
	private int mId = -1;
	private String mName = null;
	private String mUserId = null;
	private int mELO = 0;
	private Position mPosition = null;
	private int mLife = 0;
	private int mGold = 0;
	private int mMineCount = 0;
	private Position mSpawnPosition = null;
	private boolean mCrashed = false;
	
	public Hero() { }
	
	public void setId(int id) {
		mId = id;
	}
	
	public int getId() {
		return mId;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		this.mName = name;
	}

	public String getUserId() {
		return mUserId;
	}

	public void setUserId(String userId) {
		this.mUserId = userId;
	}

	public int getELO() {
		return mELO;
	}

	public void setELO(int elo) {
		this.mELO = elo;
	}

	public Position getPosition() {
		return mPosition;
	}

	public void setPosition(Position position) {
		this.mPosition = position;
	}

	public int getLife() {
		return mLife;
	}

	public void setLife(int life) {
		this.mLife = life;
	}

	public int getGold() {
		return mGold;
	}

	public void setGold(int gold) {
		this.mGold = gold;
	}

	public int getMineCount() {
		return mMineCount;
	}

	public void setMineCount(int mineCount) {
		this.mMineCount = mineCount;
	}

	public Position getSpawnPosition() {
		return mSpawnPosition;
	}

	public void setSpawnPosition(Position spawnPosition) {
		this.mSpawnPosition = spawnPosition;
	}

	public boolean isCrashed() {
		return mCrashed;
	}

	public void setCrashed(boolean crashed) {
		this.mCrashed = crashed;
	}
}
