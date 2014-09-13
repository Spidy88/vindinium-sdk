package vindinium.bot;

import vindinium.Action;
import vindinium.client.Response;

public abstract class Bot {
	private final String mKey;
	private final String mName;
	
	public Bot(String key, String name) {
		this.mKey = key;
		this.mName = name;
	}
	
	public String getKey() {
		return mKey;
	}
	public String getName() {
		return mName;
	}
	
	public abstract Action getAction(Response response);
}
