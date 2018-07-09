package org.apache.ibatis.reflection.property;

import java.util.Iterator;

/**
 * 属性分解为标记，迭代子模式
 * 如person[0].birthdate.year，将依次取得person[0], birthdate, year
 * 
 */
public class PropertyTokenizer implements Iterator<PropertyTokenizer>, Iterable<PropertyTokenizer> {

	@Override
	public Iterator<PropertyTokenizer> iterator() {
		return null;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public PropertyTokenizer next() {
		return null;
	}

	@Override
	public void remove() {
	}

}