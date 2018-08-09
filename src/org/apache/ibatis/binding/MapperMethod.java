package org.apache.ibatis.binding;

import java.lang.reflect.Method;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.Configuration;

/**
 * 映射器方法
 *
 */
public class MapperMethod {
	
	private final SqlCommand command;
	
	// sql命令，静态内部类
	public static class SqlCommand {
		private final String name;
		private final SqlCommandType type;
		
		public SqlCommand(Configuration configuration, Class<?> mapperInterface, Method method) {
			String statementName = mapperInterface.getName() + "." + method.getName();
			MappedStatement ms = null;
		}
	}

}