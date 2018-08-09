package org.apache.ibatis.mapping;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * 参数映射
 *
 */
public class ParameterMapping {
	
	private Configuration configuration;
	
	// 例子：#{property,javaType=int,jdbcType=NUMERIC}
	// property
	private String property;
	// mode
	private ParameterMode mode;
	// javaType=int
	private Class<?> javaType = Object.class;
	// jdbcType=NUMERIC
	private JdbcType jdbcType;
	// numericScale
	private Integer numericScale;
	private TypeHandler<?> typeHandler;
	private String resultMapId;
	// jdbcType=NUMERIC
	private String jdbcTypeName;
	private String expression;
	
	private ParameterMapping() {
	}
	
	// 静态内部类，建造者模式
	public static class Builder {
		private ParameterMapping parameterMapping = new ParameterMapping();
		
		public Builder(Configuration configuration, String property, TypeHandler<?> typeHandler) {
			parameterMapping.configuration = configuration;
			parameterMapping.property = property;
			parameterMapping.typeHandler = typeHandler;
			parameterMapping.mode = ParameterMode.IN;
		}
		
		public Builder(Configuration configuration, String property, Class<?> javaType) {
			parameterMapping.configuration = configuration;
			parameterMapping.property = property;
			parameterMapping.javaType = javaType;
			parameterMapping.mode = ParameterMode.IN;
    	}
		
	}
	

}