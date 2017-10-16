package com.xuan.xutils.cache.provider;

import com.xuan.xutils.cache.Cache;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Ĭ�ϵļ򵥻���ʵ����
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:44:23 $
 */
public class SimpleCache implements Cache<String, Object> {
    /**
     * �ڲ� map �ĸ��������� key �� hash �� moduleSize ȡģ����λ�������ĳһ���ڲ��� map�������������������
     */
    private static final int MODULE_SIZE = 10;
    /**
     * ����ʱ����ķ������е�ʱ������Ĭ�� 10 ����
     */
    private static final int EXPIRY_INTERVAL = 10;
    /**
     * �����������
     */
    private final String CACHE_NAME = SimpleCache.class.getName();
    /**
     * �����Ż���� map ����
     */
    private final ConcurrentMap<String, Object>[] cacheMaps;
    /**
     * ��Ż��泬ʱʱ��� map
     */
    private final Map<String, Long> cacheTimeMap;
    /**
     * ����ʱ����ķ���
     */
    private final ScheduledExecutorService executorService;

    @SuppressWarnings("unchecked")
    public SimpleCache() {
        cacheMaps = new ConcurrentMap[MODULE_SIZE];
        for (int i = 0; i < MODULE_SIZE; i++) {
            ConcurrentMap<String, Object> cacheMap = new ConcurrentHashMap<String, Object>();
            cacheMaps[i] = cacheMap;
        }
        cacheTimeMap = new ConcurrentHashMap<String, Long>();
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(new CacheExpiryTask(), 0, EXPIRY_INTERVAL, TimeUnit.MINUTES);
        System.out.println(CACHE_NAME + " initialized");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void destroy() {
        for (Map<String, Object> cacheMap : cacheMaps) {
            cacheMap.clear();
        }
        cacheTimeMap.clear();
        if (executorService.isShutdown()) {
            System.out.println(CACHE_NAME + " already destroyed");
        } else {
            executorService.shutdown();
            System.out.println(CACHE_NAME + " destroyed");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object get(String key) {
        verifyCache(key);
        return getCacheMap(key).get(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(String key, Object value) {
        verifyCache(key);
        boolean success = false;
        Object previous = getCacheMap(key).putIfAbsent(key, value);
        if (previous == null) {
            cacheTimeMap.put(key, -1L);
            success = true;
        }
        return success;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(String key, Object value, Date expiry) {
        verifyCache(key);
        boolean success = false;
        Object previous = getCacheMap(key).putIfAbsent(key, value);
        if (previous == null) {
            cacheTimeMap.put(key, expiry.getTime());
            success = true;
        }
        return success;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(String key, Object value, long expiry, TimeUnit unit) {
        verifyCache(key);
        boolean success = false;
        Object previous = getCacheMap(key).putIfAbsent(key, value);
        if (previous == null) {
            long _expiry = (expiry == -1L) ? -1L : System.currentTimeMillis() + unit.toMillis(expiry);
            cacheTimeMap.put(key, _expiry);
            success = true;
        }
        return success;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void put(String key, Object value) {
        if (value == null) {
            return;
        }
        getCacheMap(key).put(key, value);
        cacheTimeMap.put(key, -1L);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void put(String key, Object value, Date expiry) {
        if (value == null) {
            return;
        }
        getCacheMap(key).put(key, value);
        cacheTimeMap.put(key, expiry.getTime());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void put(String key, Object value, long expiry, TimeUnit unit) {
        if (value == null) {
            return;
        }
        getCacheMap(key).put(key, value);
        long _expiry = (expiry == -1L) ? -1L : System.currentTimeMillis() + unit.toMillis(expiry);
        cacheTimeMap.put(key, _expiry);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(String key) {
        getCacheMap(key).remove(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long decr(String key, long delta) {
        return decr(key, delta, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long decr(String key, long delta, long initValue) {
        return incr(key, -delta, initValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long incr(String key, long delta) {
        return incr(key, delta, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long incr(String key, long delta, long initValue) {
        long countValue = 0;
        AtomicLong counter = (AtomicLong) get(key);
        if (counter == null) {
            // ��ʾ��������û�д��ڣ��������������������
            AtomicLong newCounter = new AtomicLong(initValue);
            counter = (AtomicLong) getCacheMap(key).putIfAbsent(key, newCounter);
            if (counter == null) {
                // ��ʾ��������ӳɹ��������µļ�����
                counter = newCounter;
                cacheTimeMap.put(key, -1L);// �������ݱ��Ϊ��������
            }
        }
        countValue = counter.addAndGet(delta);
        if (countValue >= 0) {
            return countValue;
        } else {
            counter.compareAndSet(countValue, 0);
            return 0;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void flushAll() {
        for (Map<String, Object> cacheMap : cacheMaps) {
            cacheMap.clear();
        }
        cacheTimeMap.clear();
        System.out.println(CACHE_NAME + " flushed");
    }

    public Set<String> keySet() {
        verifyAllCaches();
        return cacheTimeMap.keySet();
    }

    public boolean containsKey(String key) {
        verifyCache(key);
        return getCacheMap(key).containsKey(key);
    }

    public int size() {
        verifyAllCaches();
        return cacheTimeMap.size();
    }

    private ConcurrentMap<String, Object> getCacheMap(String key) {
        if (key == null) {
            throw new IllegalArgumentException("key is required");
        }
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % MODULE_SIZE;
        return cacheMaps[index];
    }

    private void verifyCache(String key) {
        Long expiry = cacheTimeMap.get(key);
        if (isTimeExpiry(expiry)) {
            Map<String, Object> cacheMap = getCacheMap(key);
            cacheMap.remove(key);
            cacheTimeMap.remove(key);
            System.out.println("Cache(key=" + key + ") is expiry");
        }
    }

    private void verifyAllCaches() {
        Set<String> keys = cacheTimeMap.keySet();
        for (String key : keys) {
            verifyCache(key);
        }
    }

    private boolean isTimeExpiry(Long time) {
        return time != null && time > 0 && time <= System.currentTimeMillis();
    }

    /**
     * �����ȡ���������
     */
    private class CacheExpiryTask implements Runnable {
        @Override
        public void run() {
            verifyAllCaches();
            System.out.println("Cache expiry task executed");
        }
    }
}
