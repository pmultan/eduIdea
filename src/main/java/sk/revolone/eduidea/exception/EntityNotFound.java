package sk.revolone.eduidea.exception;

public class EntityNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFound(String message) {
        super("Entity not found : " + message);
	}
}
