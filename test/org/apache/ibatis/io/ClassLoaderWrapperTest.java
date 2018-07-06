package org.apache.ibatis.io;

import org.apache.ibatis.BaseDataTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClassLoaderWrapperTest extends BaseDataTest {
	
	ClassLoaderWrapper wrapper;
	ClassLoader loader;
	private final String RESOURCE_NOT_FOUND = "some_resource_that_does_not_exist.properties";
	private final String CLASS_NOT_FOUND = "some.random.class.that.does.not.Exist";
	private final String CLASS_FOUND = "java.lang.Object";

	@Before
	public void beforeClassLoaderWrapperTest() {
		wrapper = new ClassLoaderWrapper();
		loader = getClass().getClassLoader();
	}

	@Test
	public void classForName() throws ClassNotFoundException {
		Assert.assertNotNull(wrapper.classForName(CLASS_FOUND));
	}
	
	@Test(expected = ClassNotFoundException.class)
	public void classForNameNotFound() throws ClassNotFoundException {
		Assert.assertNotNull(wrapper.classForName(CLASS_NOT_FOUND));
	}
	
	@Test
	public void classForNameWithClassLoader() throws ClassNotFoundException {
		Assert.assertNotNull(wrapper.classForName(CLASS_FOUND, loader));
	}
	
	@Test
	public void getResourceAsURL() {
		Assert.assertNotNull(wrapper.getResourceAsURL(JPETSTORE_PROPERTIES));
	}
	
	@Test
	public void getResourceAsURLNotFound() {
		Assert.assertNull(wrapper.getResourceAsURL(RESOURCE_NOT_FOUND));
	}
	
	@Test
	public void getResourceAsURLWithClassLoader() {
		Assert.assertNotNull(wrapper.getResourceAsURL(JPETSTORE_PROPERTIES, loader));
	}

	@Test
	public void getResourceAsStream() {
		Assert.assertNotNull(wrapper.getResourceAsStream(JPETSTORE_PROPERTIES));
	}

	@Test
	public void getResourceAsStreamNotFound() {
		Assert.assertNull(wrapper.getResourceAsStream(RESOURCE_NOT_FOUND));
	}

	@Test
	public void getResourceAsStreamWithClassLoader() {
		Assert.assertNotNull(wrapper.getResourceAsStream(JPETSTORE_PROPERTIES, loader));
	}

}