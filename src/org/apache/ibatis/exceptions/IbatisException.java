package org.apache.ibatis.exceptions;

/**
 * Ibatis异常，所有异常的父类，但废弃了
 *
 */
@Deprecated
public class IbatisException extends RuntimeException {

	private static final long serialVersionUID = 5098065590172347265L;
	
	public IbatisException() {
		super();
	}

	public IbatisException(String message) {
		super(message);
	}
	
	public IbatisException(Throwable cause) {
		super(cause);
	}
	
	public IbatisException(String message, Throwable cause) {
		super(message, cause);
	}
}