package org.apache.ibatis.domain.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})
public class RichType {

	private RichType richType;
	private String richField;
	private String richProperty;
	private Map richMap = new HashMap();
	private List richList = new ArrayList() {
		private static final long serialVersionUID = 2670001121736748890L;
		{
			add("bar");
		}
	};

	public RichType getRichType() {
		return richType;
	}

	public void setRichType(RichType richType) {
		this.richType = richType;
	}

	public String getRichField() {
		return richField;
	}

	public void setRichField(String richField) {
		this.richField = richField;
	}

	public String getRichProperty() {
		return richProperty;
	}

	public void setRichProperty(String richProperty) {
		this.richProperty = richProperty;
	}

	public Map getRichMap() {
		return richMap;
	}

	public void setRichMap(Map richMap) {
		this.richMap = richMap;
	}

	public List getRichList() {
		return richList;
	}

	public void setRichList(List richList) {
		this.richList = richList;
	}

}