package vindinium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import vindinium.client.Response;
import vindinium.client.ResponseParser;
import vindinium.config.IConfig;

public class Client {
	private static final String KEY_KEY = "key";
	private static final String KEY_TURNS = "turns";
	private static final String KEY_MAP = "map";
	private static final String KEY_DIRECTION = "dir";
	
	private final IConfig mConfig;
	private final HttpClient mHttpClient;
	private final String mBaseUrl;
	private final ResponseParser mParser = new ResponseParser();
	private boolean mGameStarted = false;
	private String mNextPlayUrl = null;
	private BufferedWriter mWriter = null;
	
	public Client(IConfig config) throws Exception {
		mConfig = config;
		mHttpClient = HttpClientBuilder.create().build();
		mBaseUrl = String.format("%1$s/%2$s", mConfig.getBaseUrl(), mConfig.getGameMode().toString().toLowerCase());
		
		mWriter = new BufferedWriter(new FileWriter("output.json"));
	}
	
	public Response startGame() throws GameStateException, IOException {
		if( mGameStarted ) {
			throw new GameStateException("Game already in progress");
		}
		
		HttpPost startGameRequest = createStartGameRequest();
		
		try {
			HttpResponse startGameResponse = mHttpClient.execute(startGameRequest);
			
			JSONObject jsonResponse = new JSONObject(EntityUtils.toString(startGameResponse.getEntity()));
			Response response = mParser.parseResponseJson(jsonResponse);
			
			mNextPlayUrl = response.getPlayUrl();
			
			mWriter.write(jsonResponse.toString());
			mWriter.newLine();
			mWriter.newLine();
			
			mGameStarted = true;
			return response;
		} catch (IOException e) {
			System.err.println("Failed to start game");
			throw e;
		}
	}
	
	public Response sendMove(Action action) throws CrashedException, GameStateException, IOException {
		if( !mGameStarted ) {
			throw new GameStateException("Game has not started yet");
		}
		
		mWriter.write(action.toString());
		mWriter.newLine();
		
		HttpPost sendMoveRequest = createSendMoveRequest(action);
		
		try {
			HttpResponse sendMoveResponse = mHttpClient.execute(sendMoveRequest);
			
			JSONObject jsonResponse = new JSONObject(EntityUtils.toString(sendMoveResponse.getEntity()));
			Response response = mParser.parseResponseJson(jsonResponse);
			
			mNextPlayUrl = response.getPlayUrl();
			
			mWriter.write(jsonResponse.toString());
			mWriter.newLine();
			mWriter.newLine();
			
			if( response.getGame().isFinished() ) {
				mWriter.close();
				mGameStarted = false;
			}
			return response;
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
	
	private HttpPost createSendMoveRequest(Action action) throws UnsupportedEncodingException {
		HttpPost startGameRequest = new HttpPost(mNextPlayUrl);
		
		ArrayList<NameValuePair> postParams = new ArrayList<NameValuePair>();
		postParams.add(new BasicNameValuePair(KEY_KEY, mConfig.getKey()));
		postParams.add(new BasicNameValuePair(KEY_DIRECTION, action.toString()));
		
		startGameRequest.setEntity(new UrlEncodedFormEntity(postParams));
		
		return startGameRequest;
	}
}
