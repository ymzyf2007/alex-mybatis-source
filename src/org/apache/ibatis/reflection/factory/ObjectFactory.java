package org.apache.ibatis.reflection.factory;

import java.util.List;
import java.util.Properties;

/**
 * 对象工厂，所有对象都要由工厂来产生
 *
 */
public interface ObjectFactory {
	
	/**
	 * 设置属性
	 * @param properties
	 */
	void setProperties(Properties properties);
	
	/**
	 * Creates a new object with default constructor. 
	 * 生产对象，用默认的构造函数
	 * @param type
	 * @return
	 */
	<T> T create(Class<T> type);
	
	/**
	 * Creates a new object with the specified constructor and params.
	 * 生产对象，使用指定的构造函数和构造函数参数
	 * @param type
	 * @param constructorArgTypes
	 * @param constructorArgs
	 * @return
	 */
	<T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs);
	
	/**
	 * Returns true if this object can have a set of other objects.
	 * It's main purpose is to support non-java.util.Collection objects like Scala collections.
	 * 返回这个对象是否是集合，为了支持Scala collections？
	 * @param type
	 * @return
	 */
	<T> boolean isCollection(Class<T> type);

}