package org.apache.ibatis.reflection;

import org.apache.ibatis.domain.misc.RichType;
import org.junit.Assert;
import org.junit.Test;

public class MetaObjectTest {
	
	@Test
	public void shouldGetAndSetField() {
		RichType rich = new RichType();
	    MetaObject meta = SystemMetaObject.forObject(rich);
	    meta.setValue("richField", "foo");
	    Assert.assertEquals("foo", meta.getValue("richField"));
	}

}