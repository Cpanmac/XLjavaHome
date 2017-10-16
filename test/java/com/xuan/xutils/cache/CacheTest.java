package com.xuan.xutils.cache;

import com.xuan.xutils.cache.provider.SimpleCache;
import org.junit.Assert;
import org.junit.Test;

/**
 * �������
 * <p>
 * Created by xuan on 17/7/31.
 */
public class CacheTest {
    @Test
    public void testAdd() {
        //�������������,��ʽ��������������Spring�е�ʹ��,�����ȿ�
        CacheManager cacheManager = new DefaultCacheManager();
        cacheManager.addCache("test", new SimpleCache());
        //δ���뻺��ȡ����
        Object v = cacheManager.getCache("test").get("testKey");
        Assert.assertNull(v);
        //���뻺��
        cacheManager.getCache("test").add("testKey", "xuan");
        //ȡ�����ֵ
        v = (String) cacheManager.getCache("test").get("testKey");
        Assert.assertNotNull(v);
        Assert.assertTrue("xuan".equals(v));
        System.out.println("++++++++++v:" + v);
    }
}
