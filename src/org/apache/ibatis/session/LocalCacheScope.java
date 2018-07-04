package org.apache.ibatis.session;

/**
 * 本地缓存机制(Local Cache)防止循环引用(circular references)和加速重复嵌套查询
 * 默认值为SESSION，这种情况会缓存一个会话中执行的所有查询
 * 若设置为STATEMENT，本地会话仅用在语句执行上，对相同SqlSession的不同调用将不会共享数据。
 *
 */
public enum LocalCacheScope {
	SESSION, STATEMENT
}
