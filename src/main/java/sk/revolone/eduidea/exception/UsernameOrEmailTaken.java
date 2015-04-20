package sk.revolone.eduidea.exception;

public class UsernameOrEmailTaken extends Exception {
	private static final long serialVersionUID = 1L;

	public UsernameOrEmailTaken(String message) {
		super("Username or email is already taken : " + message);
	}
}
