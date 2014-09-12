package vindinium;

public class GameStateException extends Exception {
	private static final long serialVersionUID = 1L;

	public GameStateException(String error) {
		super(error);
	}
}
