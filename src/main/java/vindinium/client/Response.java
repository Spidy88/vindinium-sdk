package vindinium.client;

import vindinium.IHero;
import vindinium.game.IGame;

public class Response {
	private final String mToken;
	private final String mViewUrl;
	private final String mPlayUrl;
	private final IGame mGame;
	private final IHero mHero;
	
	public Response(String token, String viewUrl, String playUrl, IGame game, IHero hero) {
		mToken = token;
		mViewUrl = viewUrl;
		mPlayUrl = playUrl;
		mGame = game;
		mHero = hero;
	}
	
	public String getToken() {
		return mToken;
	}
	public String getViewUrl() {
		return mViewUrl;
	}
	public String getPlayUrl() {
		return mPlayUrl;
	}
	public IGame getGame() {
		return mGame;
	}
	public IHero getHero() {
		return mHero;
	}
}
