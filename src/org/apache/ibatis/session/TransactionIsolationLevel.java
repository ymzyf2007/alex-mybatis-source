package org.apache.ibatis.session;

import java.sql.Connection;

/**
 * 事务隔离级别，是一个枚举类型
 *
 */
public enum TransactionIsolationLevel {
	// 包括JDBC支持的5个级别
	NONE(Connection.TRANSACTION_NONE),
	// 读未提交
	READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
	// 读已提交
	READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
	// 可重复读[即是事务A第一次读取字段A值是t1,期间事务B修改了字段A值为t2,则事务A再次读字段A时,如果隔离级别是可重复读的读取结果是t1,读已提交的读取的值是t2]
	REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
	// 序列化
	SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);
	
	private final int level;
	
	private TransactionIsolationLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
}