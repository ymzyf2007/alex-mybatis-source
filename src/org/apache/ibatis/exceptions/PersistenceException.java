package org.apache.ibatis.exceptions;

@SuppressWarnings("deprecation")
public class PersistenceException extends IbatisException {

	private static final long serialVersionUID = 3858034812836756396L;

	public PersistenceException() {
		super();
	}
	
	public PersistenceException(String message) {
		super(message);
	}
	
	public PersistenceException(Throwable cause) {
		super(cause);
	}
	
	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}
	
}