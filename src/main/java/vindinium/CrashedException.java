package vindinium;

public class CrashedException extends Exception {
	private static final long serialVersionUID = 1L;

	public CrashedException() {
		super("Oh no! You took too long to make a move. You've crashed for this game. You can still win though!");
	}
}
