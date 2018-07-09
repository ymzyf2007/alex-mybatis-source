package org.apache.ibatis.builder;

import org.apache.ibatis.session.Configuration;

/**
 * 构建器的基类，建造者模式
 *
 */
public abstract class BaseBuilder {
	
	// 需要配置，类型别名注册，类型处理器注册3个东西
	protected final Configuration configuration;
	protected final TypeAliasRegistry typeAliasRegistry;
	protected final TypeHandlerRegistry typeHandlerRegistry;

}