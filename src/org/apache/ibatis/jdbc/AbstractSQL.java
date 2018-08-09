package org.apache.ibatis.jdbc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 * 测试参考SQLTest
 *
 * @param <T>
 */
public abstract class AbstractSQL<T> {
	
	private static final String AND = ") \nAND (";
	private static final String OR = ") \nOR (";
	
	private SQLStatement sql = new SQLStatement();
	
	public abstract T getSelf();
	
	/**
	 * 安全的Appendable
	 *
	 */
	private static class SafeAppendable {
		private final Appendable a;
		private boolean empty = true;
		
		public SafeAppendable(Appendable a) {
			super();
			this.a = a;
		}
		
		public SafeAppendable append(CharSequence s) {
			try {
				if(empty && s.length() > 0) {
					empty = false;
				}
				a.append(s);
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
			return this;
		}
		
		public boolean isEmpty() {
			return empty;
		}
	}
	
	/**
	 * SQL语句 
	 *
	 */
	private static class SQLStatement {
		
		// 4钟语句类型
		public enum StatementType {
			DELETE, INSERT, SELECT, UPDATE
		}
		
		StatementType statementType;
		List<String> sets = new ArrayList<String>();
	    List<String> select = new ArrayList<String>();
	    List<String> tables = new ArrayList<String>();
	    List<String> join = new ArrayList<String>();
	    List<String> innerJoin = new ArrayList<String>();
	    List<String> outerJoin = new ArrayList<String>();
	    List<String> leftOuterJoin = new ArrayList<String>();
	    List<String> rightOuterJoin = new ArrayList<String>();
	    List<String> where = new ArrayList<String>();
	    List<String> having = new ArrayList<String>();
	    List<String> groupBy = new ArrayList<String>();
	    List<String> orderBy = new ArrayList<String>();
	    // 标记最后一个list
	    List<String> lastList = new ArrayList<String>();
	    List<String> columns = new ArrayList<String>();
	    List<String> values = new ArrayList<String>();
	    boolean distinct;
	    
	    public SQLStatement() {
	    }
	    
	    private void sqlClause()
		
	}

}