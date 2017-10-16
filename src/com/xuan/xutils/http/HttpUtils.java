package com.xuan.xutils.http;

import com.xuan.xutils.http.impl.HttpClientUrlConnectionImpl;
import com.xuan.xutils.http.listener.HttpDownloadListener;

import java.io.File;
import java.util.Map;

/**
 * HTTP�����࣬���ڿ����ж���ʵ�ַ�ʽ
 *
 * @author xuan
 */
public abstract class HttpUtils {
    public static final boolean DEBUG = false;

    /**
     * ��ȡһ��HttpClientʾ��,������Լ���ʵ��,�����������滻
     *
     * @return
     */
    public static HttpClient getHttpClient() {
        return new HttpClientUrlConnectionImpl();
    }

    /**
     * POST����,json�ύ
     *
     * @param url
     * @param bodyJson �����������е��ַ���
     * @return
     */
    public static HttpResponse postJson(String url, String bodyJson) {
        HttpClient client = getHttpClient();
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        request.putBodyJson(bodyJson);
        printLog(request);
        return client.postJson(request);
    }

    /**
     * POST����,��ͨ������ʽ�ύ
     *
     * @param url
     * @param paramsMap
     * @return
     */
    public static HttpResponse post(String url, Map<String, String> paramsMap) {
        HttpClient client = getHttpClient();
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        if (null != paramsMap) {
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                request.putParam(entry.getKey(), entry.getValue());
            }
        }
        printLog(request);
        return client.post(request);
    }

    /**
     * GET����
     *
     * @param url
     * @param paramsMap
     * @return
     */
    public static HttpResponse get(String url, Map<String, String> paramsMap) {
        HttpClient client = getHttpClient();
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        if (null != paramsMap) {
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                request.putParam(entry.getKey(), entry.getValue());
            }
        }
        printLog(request);
        return client.get(request);
    }

    /**
     * �ϴ��ļ�
     *
     * @param url
     * @param fileMap
     * @param paramMap
     * @return
     */
    public static HttpResponse upload(String url, Map<String, File> fileMap, Map<String, String> paramMap) {
        HttpClient client = getHttpClient();
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        if (null != fileMap) {
            for (Map.Entry<String, File> entry : fileMap.entrySet()) {
                request.putFile(entry.getKey(), entry.getValue());
            }
        }
        if (null != paramMap) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                request.putParam(entry.getKey(), entry.getValue());
            }
        }
        printLog(request);
        return client.upload(request);
    }

    /**
     * GET�ķ�ʽ����
     *
     * @param url
     * @param paramsMap
     * @param saveFileName
     * @param downloadListener
     * @return
     */
    public static HttpResponse getDowload(String url, Map<String, String> paramsMap, String saveFileName, HttpDownloadListener downloadListener) {
        HttpClient client = getHttpClient();
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        request.setDownloadFileName(saveFileName);
        request.setDownloadListener(downloadListener);
        if (null != paramsMap) {
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                request.putParam(entry.getKey(), entry.getValue());
            }
        }
        printLog(request);
        return client.getDowload(request);
    }

    /**
     * POST�ķ�ʽ����
     *
     * @param url
     * @param paramsMap
     * @param saveFileName
     * @param downloadListener
     * @return
     */
    public static HttpResponse postDowload(String url, Map<String, String> paramsMap, String saveFileName, HttpDownloadListener downloadListener) {
        HttpClient client = getHttpClient();
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        request.setDownloadFileName(saveFileName);
        request.setDownloadListener(downloadListener);
        if (null != paramsMap) {
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                request.putParam(entry.getKey(), entry.getValue());
            }
        }
        printLog(request);
        return client.postDowload(request);
    }

    /**
     * ��ӡ������־
     *
     * @param request
     */
    private static void printLog(HttpRequest request) {
        if (DEBUG) {
            System.out.println(request.toString());
        }
    }
}
