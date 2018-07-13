package org.apache.ibatis.reflection.invoker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.ibatis.reflection.invoker.Invoker;

/**
 * getter调用者
 * 
 */
public class GetFieldInvoker implements Invoker {
	
	private Field field;
	
	public GetFieldInvoker(Field field) {
		this.field = field;
	}

	/**
	 * 就是调用Field.get
	 */
	@Override
	public Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException {
		return field.get(target);
	}

	@Override
	public Class<?> getType() {
		return field.getType();
	}

}