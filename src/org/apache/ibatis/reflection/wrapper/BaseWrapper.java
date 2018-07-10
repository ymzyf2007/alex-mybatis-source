package org.apache.ibatis.reflection.wrapper;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * 对象包装器的基类
 * 什么方法都没实现，只提供了一些util方法
 * 
 */
public abstract class BaseWrapper implements ObjectWrapper {

	protected static final Object[] NO_ARGUMENTS = new Object[0];
	protected MetaObject metaObject;

	protected BaseWrapper(MetaObject metaObject) {
	    this.metaObject = metaObject;
	}

	// 解析集合
	protected Object resolveCollection(PropertyTokenizer prop, Object object) {
	    if ("".equals(prop.getName())) {
	    	return object;
	    } else {
	    	return metaObject.getValue(prop.getName());
	    }
	}

}