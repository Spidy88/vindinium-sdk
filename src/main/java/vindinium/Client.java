package vindinium;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import vindinium.config.IConfig;
import vindinium.game.GameResponseParser;
import vindinium.map.IMap;

public class Client {
	private static final String KEY_KEY = "key";
	private static final String KEY_TURNS = "turns";
	private static final String KEY_MAP = "map";
	
	private final IConfig mConfig;
	private final HttpClient mHttpClient;
	private final String mBaseUrl;
	private final GameResponseParser mParser = new GameResponseParser();
	private boolean mGameStarted = false;
	
	public Client(IConfig config) {
		mConfig = config;
		mHttpClient = HttpClientBuilder.create().build();
		mBaseUrl = String.format("%1$s/%2$s", mConfig.getBaseUrl(), mConfig.getGameMode().toString());
	}
	
	public IMap startGame() throws GameStateException, IOException {
		if( mGameStarted ) {
			throw new GameStateException("Game already in progress");
		}
		
		HttpPost startGameRequest = createStartGameRequest();
		
		try {
			HttpResponse startGameResponse = mHttpClient.execute(startGameRequest);
			
			JSONObject jsonResponse = new JSONObject(EntityUtils.toString(startGameResponse.getEntity()));
			
			
			mGameStarted = true;
			return null;
		} catch (IOException e) {
			System.err.println("Failed to start game");
			throw e;
		}
	}
	
	public IMap sendMove(Action action) throws CrashedException, GameStateException, IOException {
		if( !mGameStarted ) {
			throw new GameStateException("Game has not started yet");
		}
		
		HttpGet sendMoveRequest = new HttpGet(mBaseUrl);
		try {
			HttpResponse sendMoveResponse = mHttpClient.execute(sendMoveRequest);
			
			
			return null;
		} catch (IOException e) {
			System.err.println("Failed to start game");
			throw e;
		}
	}
	
	private HttpPost createStartGameRequest() throws UnsupportedEncodingException {
		HttpPost startGameRequest = new HttpPost(mBaseUrl);
		
		ArrayList<NameValuePair> postParams = new ArrayList<NameValuePair>();
		postParams.add(new BasicNameValuePair(KEY_KEY, mConfig.getKey()));
		
		Integer turns = mConfig.getTurns();
		if( turns != null && turns > 0 ) {
			postParams.add(new BasicNameValuePair(KEY_TURNS, turns.toString()));
		}
		
		String mapId = mConfig.getMapId();
		if( mapId != null ) {
			postParams.add(new BasicNameValuePair(KEY_MAP, mConfig.getMapId()));
		}
		
		startGameRequest.setEntity(new UrlEncodedFormEntity(postParams));
		
		return startGameRequest;
	}
}
