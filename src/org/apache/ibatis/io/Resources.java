package org.apache.ibatis.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * A class to simplify access to resources through the classloader.
 * 通过类加载器获得resource的辅助类
 *
 */
public class Resources {
	
	// 大多数方法都是委托给ClassLoaderWrapper，再去做真正的事
	private static ClassLoaderWrapper classLoaderWrapper = new ClassLoaderWrapper();
	
	/**
	 * Charset to use when calling getResourceAsReader.
	 * null means use the system default.
	 */
	private static Charset charset;
	
	Resources() {
	}
	
	/** 
	 * Returns the default classloader (may be null).
	 *
	 * @return The default classloader
	 */
	public static ClassLoader getDefaultClassLoader() {
		return classLoaderWrapper.defaultClassLoader;
	}
	
	/** 
	 * Sets the default classloader
	 *
	 * @param defaultClassLoader - the new default ClassLoader
	 */
	public static void setDefaultClassLoader(ClassLoader defaultClassLoader) {
		classLoaderWrapper.defaultClassLoader = defaultClassLoader;
	}
	
	/** 
	 * Returns the URL of the resource on the classpath
	 * 
	 * @param resource The resource to find
	 * @return The resource
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static URL getResourceURL(String resource) throws IOException {
		// issue #625
		return getResourceURL(null, resource);
	}
	
	/**
	 * Returns the URL of the resource on the classpath
	 *
	 * @param loader   The classloader used to fetch the resource
	 * @param resource The resource to find
	 * @return The resource
	 * @throws java.io.IOException If the resource cannot be found or read
	 */
	public static URL getResourceURL(ClassLoader loader, String resource) throws IOException {
		URL url = classLoaderWrapper.getResourceAsURL(resource, loader);
	    if(url == null) {
	    	throw new IOException("Could not find resource " + resource);
	    }
	    return url;
	}
	
	public static InputStream getUrlAsStream(String urlString) throws IOException {
		URL url = new URL(urlString);
	    URLConnection conn = url.openConnection();
	    return conn.getInputStream();
	}
	
	public static InputStream getResourceAsStream(String resource) throws IOException {
		return getResourceAsStream(null, resource);
	}

	public static InputStream getResourceAsStream(ClassLoader loader, String resource) throws IOException {
		InputStream in = classLoaderWrapper.getResourceAsStream(resource, loader);
	    if(in == null) {
	    	throw new IOException("Could not find resource " + resource);
	    }
	    return in;
	}

}