package org.apache.ibatis.reflection.invoker;

import java.lang.reflect.InvocationTargetException;

/**
 * 调用者
 * 
 */
public interface Invoker {
	
	/**
	 * 调用
	 * @param target
	 * @param args
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException;

	/**
	 * 取得类型
	 * @return
	 */
	Class<?> getType();

}
