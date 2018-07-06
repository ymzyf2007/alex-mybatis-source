package org.apache.ibatis.io;

import java.io.InputStream;
import java.net.URL;

public class ClassLoaderWrapper {
	
	// defaultClassLoader没地方初始化啊?
	ClassLoader defaultClassLoader;
	ClassLoader systemClassLoader;
	
	ClassLoaderWrapper() {
		try {
			systemClassLoader = ClassLoader.getSystemClassLoader();
	    } catch (SecurityException ignored) {
	    	// AccessControlException on Google App Engine   
	    }
	}

	// 一共5个类加载器
	ClassLoader[] getClassLoaders(ClassLoader classLoader) {
		return new ClassLoader[] { 
			classLoader, 
			defaultClassLoader, 
			Thread.currentThread().getContextClassLoader(),
			getClass().getClassLoader(), 
			systemClassLoader 
		};
	}
	
	
	/** 
	 * Get a resource as a URL using the current class path
	 *
	 * @param resource - the resource to locate
	 * @return the resource or null
	 */
	public URL getResourceAsURL(String resource) {
		return getResourceAsURL(resource, getClassLoaders(null));
	}

	/** 
	 * Get a resource from the classpath, starting with a specific class loader
	 *
	 * @param resource    - the resource to find
	 * @param classLoader - the first classloader to try
	 * @return the stream or null
	 */
	public URL getResourceAsURL(String resource, ClassLoader classLoader) {
		return getResourceAsURL(resource, getClassLoaders(classLoader));
	}
	
	/**
	 * Get a resource as a URL using the current class path
	 * 用5个类加载器一个个查找资源，只要其中任何一个找到，就返回
	 * @param resource
	 * @param classLoader
	 * @return
	 */
	URL getResourceAsURL(String resource, ClassLoader[] classLoader) {
		URL url;
		for(ClassLoader cl : classLoader) {
			if(null != cl) {
				// look for the resource as passed in...
				url = cl.getResource(resource);
				// ...but some class loaders want this leading "/", so we'll add it and try again if we didn't find the resource
				if(null == url) {
					url = cl.getResource("/" + resource);
				}
				// "It's always in the last place I look for it!"
				// ... because only an idiot would keep looking for it after finding it, so stop looking already.
				if(null != url) {
					return url;
				}
			}
		}
		// didn't find it anywhere.
		return null;
	}
	
	public InputStream getResourceAsStream(String resource) {
		return getResourceAsStream(resource, getClassLoaders(null));
	}

	public InputStream getResourceAsStream(String resource, ClassLoader classLoader) {
		return getResourceAsStream(resource, getClassLoaders(classLoader));
	}
	
	/** 
	 * Try to get a resource from a group of classloaders
	 * 用5个类加载器一个个查找资源，只要其中任何一个找到，就返回
	 *
	 * @param resource    - the resource to get
	 * @param classLoader - the classloaders to examine
	 * @return the resource or null
	 */
	InputStream getResourceAsStream(String resource, ClassLoader[] classLoader) {
		for(ClassLoader cl : classLoader) {
			if(null != cl) {
				// try to find the resource as passed
				InputStream returnValue = cl.getResourceAsStream(resource);
				// now, some class loaders want this leading "/", so we'll add it and try again if we didn't find the resource
				if(null == returnValue) {
					returnValue = cl.getResourceAsStream("/" + resource);
				}
				if(null != returnValue) {
					return returnValue;
				}
			}
		}
		return null;
	}
	
	/** 
	 * Find a class on the classpath (or die trying)
	 *
	 * @param name - the class to look for
	 * @return - the class
	 * @throws ClassNotFoundException Duh.
	 */
	public Class<?> classForName(String name) throws ClassNotFoundException {
		return classForName(name, getClassLoaders(null));
	}

	/** 
	 * Find a class on the classpath, starting with a specific classloader (or die trying)
	 *
	 * @param name        - the class to look for
	 * @param classLoader - the first classloader to try
	 * @return - the class
	 * @throws ClassNotFoundException Duh.
	 */
	public Class<?> classForName(String name, ClassLoader classLoader) throws ClassNotFoundException {
		return classForName(name, getClassLoaders(classLoader));
	}

	/** 
	 * Attempt to load a class from a group of classloaders
	 * 用5个类加载器一个个调用Class.forName(加载类)，只要其中任何一个加载成功，就返回
	 *
	 * @param name        - the class to load
	 * @param classLoader - the group of classloaders to examine
	 * @return the class
	 * @throws ClassNotFoundException - Remember the wisdom of Judge Smails: Well, the world needs ditch diggers, too.
	 */
	Class<?> classForName(String name, ClassLoader[] classLoader) throws ClassNotFoundException {
		for(ClassLoader cl : classLoader) {
			if(null != cl) {
				try {
					Class<?> c = Class.forName(name, true, cl);
					if(null != c) {
						return c;
					}
				} catch (ClassNotFoundException e) {
					// we'll ignore this until all classloaders fail to locate the class
				}
			}
	    }
	    throw new ClassNotFoundException("Cannot find class: " + name);
	}
	
}