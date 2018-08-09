package org.apache.ibatis.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存实现类
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class CacheManager<K, V> {
	
	private final Map<K, CacheEntry> cacheEntryMap = new ConcurrentHashMap<K, CacheEntry>();
	private volatile boolean clearExpireCacheEnable = true;	// 是否开启清除失效缓存
	private long cacheTimeout = 12 * 60 * 60 * 1000L;	// 缓存默认失效时间
	
	private CacheManager() {
	}
	
	public static CacheManager getInstance() {
		return CacheManagerFactory.CACHE_MANAGER;
	}
	
	private static class CacheManagerFactory {
		private static final CacheManager CACHE_MANAGER = new CacheManager();
	}
	
	private void init() {
		init(cacheTimeout);
	}
	
	/**
	 * 自定义缓存失效时间
	 * @param cacheTimes
	 */
	private void init(long cacheTimes) {
		this.cacheTimeout = cacheTimes;
		initClearTask();
	}
	
	/**
	 * 启动清除失效缓存数据
	 */
	private void initClearTask() {
		if(clearExpireCacheEnable) {
			new ClearCacheTask().start();
		}
	}
	
	private class ClearCacheTask extends Thread {
		ClearCacheTask() {
			super.setName("clear cache task start...");
		}

		@Override
		public void run() {
			while(clearExpireCacheEnable) {
				try {
					long now = System.currentTimeMillis();
					for(Map.Entry<K, CacheEntry> entry : cacheEntryMap.entrySet()) {
						CacheEntry cacheEntry = entry.getValue();
						if(now - cacheEntry.lastTouchTime >= cacheTimeout) {
							cacheEntryMap.remove(entry.getKey());
						}
					}
					Thread.sleep(cacheTimeout);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@SuppressWarnings("hiding")
	private class CacheEntry<V> {
		V value;
		long lastTouchTime;
		
		CacheEntry(V value) {
			this.value = value;
			this.lastTouchTime = System.currentTimeMillis();
		}

		public void setLastTouchTime(long lastTouchTime) {
			this.lastTouchTime = lastTouchTime;
		}
	}
	
	/**
	 * 设置值到缓存
	 * @param key
	 * @param value
	 * @return
	 */
	public V put(K key, V value) {
		CacheEntry entry = new CacheEntry<V>(value);
		cacheEntryMap.put(key, entry);
		return value;
	}
	
	/**
	 * 根据key获取value
	 * @param key
	 * @return
	 */
	public V get(K key) {
		CacheEntry entry = cacheEntryMap.get(key);
		touchCache(entry);
		return entry == null ? null : (V) entry.value;
	}
	
	/**
	 * 重新设置最近访问缓存时间
	 * @param entry
	 */
	public void touchCache(CacheEntry<V> entry) {
		entry.setLastTouchTime(System.currentTimeMillis());
	}
	
	/**
	 * 清空缓存
	 */
	public void clear() {
		cacheEntryMap.clear();
	}
	
	public static void main(String[] args) throws InterruptedException {
		CacheManager<String, String> cacheManager = CacheManager.getInstance();
		cacheManager.init();
		cacheManager.put("test", "admin");
        Thread.sleep(5000l);
        System.out.println(cacheManager.get("test"));
	}

}