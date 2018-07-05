package org.apache.ibatis.parsing;

/**
 * 记号处理器
 *
 */
public interface TokenHandler {
	
	/**
	 * 处理记号
	 * @param content
	 * @return
	 */
	String handleToken(String content);

}