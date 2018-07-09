package org.apache.ibatis.reflection.wrapper;

import org.apache.ibatis.reflection.MetaObject;

/**
 * 对象包装器工厂
 *
 */
public interface ObjectWrapperFactory {
	
	/**
	 * 有没有包装器
	 * @param object
	 * @return
	 */
	boolean hasWrapperFor(Object object);
	
	/**
	 * 得到包装器
	 * @param metaObject
	 * @param object
	 * @return
	 */
	ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);
	
}