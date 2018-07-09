package org.apache.ibatis.reflection;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.domain.misc.RichType;
import org.apache.ibatis.domain.misc.generics.GenericConcrete;
import org.junit.Test;

public class MetaClassTest {
	
	private RichType rich = new RichType();
	@SuppressWarnings("serial")
	Map<String, RichType> map = new HashMap<String, RichType>() {
	    {
	    	put("richType", rich);
	    }
	};

	public MetaClassTest() {
		rich.setRichType(new RichType());
	}
	
	@Test
	public void shouldTestDataTypeOfGenericMethod() {
	    MetaClass meta = MetaClass.forClass(GenericConcrete.class);
	    assertEquals(Long.class, meta.getGetterType("id"));
	    assertEquals(Long.class, meta.getSetterType("id"));
	}

}