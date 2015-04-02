package sk.revolone.eduidea.exception;

public class NewsNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NewsNotFound(String message) {
        super("News not found : " + message);
    }
}
