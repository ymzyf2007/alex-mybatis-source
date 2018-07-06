package org.apache.ibatis.builder;

import org.apache.ibatis.exceptions.PersistenceException;

/**
 * 构建异常,继承PersistenceException，语义分类
 *
 */
public class BuilderException extends PersistenceException {

	private static final long serialVersionUID = -6477069265386582429L;
	
	public BuilderException() {
		super();
	}
	
	public BuilderException(String message) {
		super(message);
	}
	
	public BuilderException(Throwable cause) {
		super(cause);
	}
	
	public BuilderException(String message, Throwable cause) {
		super(message, cause);
	}

}