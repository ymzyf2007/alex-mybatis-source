package org.apache.ibatis.reflection.wrapper;

import java.util.List;

import org.apache.ibatis.reflection.MetaClass;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * Bean包装器
 * 
 */
public class BeanWrapper extends BaseWrapper {
	
	// 原来的对象
	private Object object;
	// 元类
	private MetaClass metaClass;

	@Override
	public Object get(PropertyTokenizer prop) {
		return null;
	}

	@Override
	public void set(PropertyTokenizer prop, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String findProperty(String name, boolean useCamelCaseMapping) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getGetterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getSetterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getSetterType(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getGetterType(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasSetter(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasGetter(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCollection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public <E> void addAll(List<E> element) {
		// TODO Auto-generated method stub

	}

}
