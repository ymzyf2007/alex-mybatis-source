package org.apache.ibatis.mapping;

import org.apache.ibatis.session.Configuration;

/**
 * 映射的语句
 * @author Administrator
 *
 */
public final class MappedStatement {
	
	private String resource;
	private Configuration configuration;
	private String id;
	private Integer fetchSize;
	private Integer timeout;
	private StatementType statementType;
	private ResultSetType resultSetType;

}