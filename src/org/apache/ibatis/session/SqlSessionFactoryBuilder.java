package org.apache.ibatis.session;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/*
 * Builds {@link SqlSession} instances.
 * 构建SqlSessionFactory的工厂.工厂模式
 *
 */
public class SqlSessionFactoryBuilder {
	
	// SqlSessionFactoryBuilder有9个build()方法
	
	// 以下3个方法都是调用下面第4种方法
	public SqlSessionFactory build(Reader reader) {
		return build(reader, null, null);
	}

	public SqlSessionFactory build(Reader reader, String environment) {
		return build(reader, environment, null);
	}

	public SqlSessionFactory build(Reader reader, Properties properties) {
		return build(reader, null, properties);
	}

	// 第4种方法是最常用的，它使用了一个参照了XML文档或更特定的SqlMapConfig.xml文件的Reader实例。
	// 可选的参数是environment和properties。Environment决定加载哪种环境(开发环境/生产环境)，包括数据源和事务管理器。
	// 如果使用properties，那么就会加载那些properties（属性配置文件），那些属性可以用${propName}语法形式多次用在配置文件中。和Spring很像，一个思想？
	public SqlSessionFactory build(Reader reader, String environment, Properties properties) {
		try {
			// 委托XMLConfigBuilder来解析xml文件，并构建
			XMLConfigBuilder parser = new XMLConfigBuilder(reader, environment, properties);
			return build(parser.parse());
	    } catch (Exception e) {
	    	// 这里是捕获异常，包装成自己的异常并抛出的idiom？，最后还要reset ErrorContext
	    	throw ExceptionFactory.wrapException("Error building SqlSession.", e);
	    } finally {
	    	ErrorContext.instance().reset();
	    	try {
	    		reader.close();
	    	} catch (IOException e) {
	    		// Intentionally ignore. Prefer previous error.
	    	}
	    }
	}

}