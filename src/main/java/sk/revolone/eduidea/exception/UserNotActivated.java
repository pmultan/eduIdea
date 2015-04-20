package sk.revolone.eduidea.exception;

public class UserNotActivated extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotActivated(String message) {
		super("User is not yet activated" + message);
	}
}
