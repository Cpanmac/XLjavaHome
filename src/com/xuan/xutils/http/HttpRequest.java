package com.xuan.xutils.http;

import com.xuan.xutils.http.listener.HttpDownloadListener;

import java.io.File;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Http�������
 *
 * @author xuan
 */
public class HttpRequest {
    /**
     * �����ַ. ����:http://xuanner.com
     */
    private String mUrl;
    /**
     * ��ͨ����
     */
    private Map<String, String> mParamMap;
    /**
     * �ļ�����
     */
    private Map<String, File> mFileParamMap;
    /**
     * ͷ������
     */
    private Map<String, String> mHeaderMap;
    /**
     * ��������Json��ʽ�ύ��Json����
     */
    private String mBodyJson;
    /**
     * �ύ���߻�ȡ�ı��뷽ʽ
     */
    private String mEncode = "utf-8";
    /**
     * ���ӳ�ʱ
     */
    private int mConnectionTimeout = 1000 * 30;
    /**
     * ��ȡ��ʱ
     */
    private int mReadTimeout = 1000 * 30;
    /**
     * ������ػص�,ֻ�������ļ�ʱ�ᱻ����
     */
    private HttpDownloadListener mDownloadListener;
    /**
     * ����ʱ�ļ����·��
     */
    private String mDownloadFileName;

    public HttpRequest() {
        init();
    }

    public int getConnectionTimeout() {
        return mConnectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.mConnectionTimeout = connectionTimeout;
    }

    public String getDownloadFileName() {
        return mDownloadFileName;
    }

    public void setDownloadFileName(String downloadFileName) {
        this.mDownloadFileName = downloadFileName;
    }

    public String getEncode() {
        return mEncode;
    }

    public void setEncode(String encode) {
        this.mEncode = encode;
    }

    public int getReadTimeout() {
        return mReadTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.mReadTimeout = readTimeout;
    }

    public HttpDownloadListener getDownloadListener() {
        return mDownloadListener;
    }

    public void setDownloadListener(HttpDownloadListener downloadListener) {
        this.mDownloadListener = downloadListener;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    /**
     * ����������Json��
     *
     * @param bodyJson
     */
    public void putBodyJson(String bodyJson) {
        if (null != bodyJson) {
            this.mBodyJson = bodyJson;
        }
    }

    /**
     * �����ͨ����
     *
     * @param key
     * @param value
     */
    public void putParam(String key, String value) {
        if (key != null && value != null) {
            mParamMap.put(key, value);
        }
    }

    /**
     * ����ļ�����
     *
     * @param key
     * @param file
     */
    public void putFile(String key, File file) {
        mFileParamMap.put(key, file);
    }

    /**
     * ���ͷ��
     *
     * @param key
     * @param value
     */
    public void putHeader(String key, String value) {
        mHeaderMap.put(key, value);
    }

    /**
     * ɾ����ͨ����
     *
     * @param key
     */
    public void removeParam(String key) {
        mParamMap.remove(key);
    }

    /**
     * ɾ���ļ�����
     *
     * @param key
     */
    public void removeFile(String key) {
        mFileParamMap.remove(key);
    }

    /**
     * ɾ��ͷ��
     *
     * @param key
     */
    public void removeHeader(String key) {
        mHeaderMap.remove(key);
    }

    /**
     * ���ز�����ƴ��
     *
     * @return
     */
    public String getParamsStr() {
        StringBuilder sb = new StringBuilder();
        for (Entry<String, String> entry : mParamMap.entrySet()) {
            sb.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue())).append("&");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * ��ȡGET������
     *
     * @return
     */
    public String getGetUrl() {
        if (!getUrl().contains("?")) {
            return getUrl() + "?" + getParamsStr();
        } else {
            return getUrl() + "&" + getParamsStr();
        }
    }

    public Map<String, String> getParamMap() {
        return mParamMap;
    }

    public Map<String, File> getFileParamMap() {
        return mFileParamMap;
    }

    public Map<String, String> getHeaderMap() {
        return mHeaderMap;
    }

    public String getBodyJson() {
        return mBodyJson;
    }

    // ��ʼ��MAP
    private void init() {
        mParamMap = new ConcurrentHashMap<String, String>();
        mFileParamMap = new ConcurrentHashMap<String, File>();
        mHeaderMap = new ConcurrentHashMap<String, String>();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Entry<String, String> entry : mParamMap.entrySet()) {
            if (result.length() > 0) {
                result.append("&");
            }
            result.append(entry.getKey());
            result.append("=");
            result.append(entry.getValue());
        }
        for (Entry<String, File> entry : mFileParamMap.entrySet()) {
            if (result.length() > 0) {
                result.append("&");
            }
            result.append(entry.getKey());
            result.append("=");
            result.append("FILE");
        }
        if (!getUrl().contains("?")) {
            return getUrl() + "?" + result.toString();
        } else {
            return getUrl() + "&" + result.toString();
        }
    }
}
