package org.apache.ibatis.mapping;

import javax.sql.DataSource;

import org.apache.ibatis.transaction.TransactionFactory;

/**
 * 环境
 * 决定加载哪种环境(开发环境/生产环境)
 *
 */
public final class Environment {
	
	// 环境ID
	private final String id;
	// 事务工厂
	private final TransactionFactory transactionFactory;
	// 数据源
	private final DataSource dataSource;
	
	public Environment(String id, TransactionFactory transactionFactory, DataSource dataSource) {
		if(id == null) {
			throw new IllegalArgumentException("Parameter 'id' must not be null");
		}
		if(transactionFactory == null) {
			throw new IllegalArgumentException("Parameter 'transactionFactory' must not be null");
		}
		if(dataSource == null) {
			throw new IllegalArgumentException("Parameter 'dataSource' must not be null");
		}
		this.id = id;
		this.transactionFactory = transactionFactory;
		this.dataSource = dataSource;
	}
	
	/**
	 * 静态内部类
	 * 构建器模式
	 * 用法是：new Enviroment.Builder(id).transactionFactory(xx).dataSource(xx).build();
	 *
	 */
	public static class Builder {
		private String id;
		private TransactionFactory transactionFactory;
		private DataSource dataSource;
		
		public Builder(String id) {
			this.id = id;
		}
		
		public Builder transactionFactory(TransactionFactory transactionFactory) {
			this.transactionFactory = transactionFactory;
			return this;
		}
		
		public Builder dataSource(DataSource dataSource) {
			this.dataSource = dataSource;
			return this;
		}
		
		public Environment build() {
			return new Environment(this.id, this.transactionFactory, this.dataSource);
		}
	}

	public String getId() {
		return id;
	}

	public TransactionFactory getTransactionFactory() {
		return transactionFactory;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	
}