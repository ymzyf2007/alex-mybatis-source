package org.apache.ibatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务，包装了一个Connection，包含commit，rollback，close方法
 * 在 MyBatis 中有两种事务管理器类型(也就是type="[JDBC|MANAGED]")
 *
 */
public interface Transaction {
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws SQLException
	 */
	Connection getConnection() throws SQLException;
	
	/**
	 * 提交事务
	 * @throws SQLException
	 */
	void commit() throws SQLException;
	
	/**
	 * 回滚事务
	 * @throws SQLException
	 */
	void rollback() throws SQLException;
	
	/**
	 * 关闭数据库连接
	 * @throws SQLException
	 */
	void close() throws SQLException;

}