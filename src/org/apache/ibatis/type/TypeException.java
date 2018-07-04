package org.apache.ibatis.type;

import org.apache.ibatis.exceptions.PersistenceException;

/**
 * 类型异常
 *
 */
public class TypeException extends PersistenceException {

	private static final long serialVersionUID = -3989561877342081161L;

	public TypeException() {
		super();
	}
	
	public TypeException(String message) {
		super(message);
	}
	
	public TypeException(Throwable cause) {
		super(cause);
	}
	
	public TypeException(String message, Throwable cause) {
		super(message, cause);
	}
	
}