package com.xuan.xutils.http;

import com.xuan.xutils.http.listener.HttpDownloadListener;
import org.junit.Test;

/**
 * Httpģ�����
 * <p>
 * Created by xuan on 17/8/1.
 */
public class HttpTest {
    @Test
    public void testGet() {
        HttpResponse httpResponse = HttpUtils.get("http://www.baidu.com", null);
        if (httpResponse.isStatusOk()) {
            System.out.println("����ɹ�");
        }
        System.out.println("++++++++++httpResponse:" + httpResponse);
    }

    @Test
    public void testGetDowload() {
        HttpResponse httpResponse = HttpUtils.getDowload("http://www.baidu.com", null, "/Users/xuan/Desktop/haha", new HttpDownloadListener() {
            @Override
            public void callBack(long count, long current, boolean isFinish) {
                System.out.println("++++++++++����:count[" + count + "]current[" + current + "]isFinish[" + isFinish + "]");
            }
        });
        if (httpResponse.isStatusOk()) {
            System.out.println("���سɹ�");
        }
        System.out.println("++++++++++httpResponse:" + httpResponse);
    }
}
