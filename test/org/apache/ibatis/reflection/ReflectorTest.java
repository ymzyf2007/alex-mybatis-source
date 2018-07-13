package org.apache.ibatis.reflection;

import org.junit.Assert;
import org.junit.Test;

public class ReflectorTest {
	
	@Test
	public void testGetSetterType() throws Exception {
	    Reflector reflector = Reflector.forClass(Section.class);
	    Assert.assertEquals(Long.class, reflector.getSetterType("id"));
	}
	
	static interface Entity<T> {
		T getId();
		void setId(T id);
	}
	
	static abstract class AbstractEntity implements Entity<Long> {
	    private Long id;

	    public Long getId() {
	    	return id;
	    }
	    
	    public void setId(Long id) {
	    	this.id = id;
	    }
	}

	static class Section extends AbstractEntity implements Entity<Long> {
	}

}