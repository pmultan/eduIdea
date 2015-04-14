package sk.revolone.eduidea.exception;

public class UsernameTaken extends Exception {
	private static final long serialVersionUID = 1L;

	public UsernameTaken(String message) {
		super("Username is already taken" + message);
	}
}
