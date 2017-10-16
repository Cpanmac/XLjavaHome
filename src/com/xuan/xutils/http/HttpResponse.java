package com.xuan.xutils.http;

import java.io.File;

/**
 * Http��Ӧ����
 *
 * @author xuan
 */
public class HttpResponse {
    /**
     * �ɹ���״̬��
     */
    public static final int STATUS_CODE_SUCCESS = 200;
    /**
     * ʧ�ܵ�״̬��
     */
    public static final int STATUS_CODE_FAIL = -1;
    /**
     * ����״̬�룻�ɹ�200
     */
    private int statusCode;
    /**
     * ����״̬����
     */
    private String reasonPhrase;
    /**
     * ���ؽ�������������ַ���ʱ����
     */
    private String resultStr;
    /**
     * ���ؽ�������������ļ�ʱ����
     */
    private File resultFile;

    public HttpResponse() {
        this(STATUS_CODE_FAIL, null);
    }

    public HttpResponse(int statusCode) {
        this(statusCode, null);
    }

    public HttpResponse(int statusCode, String reasonPhrase) {
        this.statusCode = statusCode;
        this.reasonPhrase = reasonPhrase;
    }

    /**
     * �ж������Ƿ񷵻������������룽200
     *
     * @return
     */
    public boolean isStatusOk() {
        return STATUS_CODE_SUCCESS == statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public String getResultStr() {
        return resultStr;
    }

    public void setResultStr(String resultStr) {
        this.resultStr = resultStr;
    }

    public File getResultFile() {
        return resultFile;
    }

    public void setResultFile(File resultFile) {
        this.resultFile = resultFile;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("statusCode[" + statusCode + "]");
        sb.append("reasonPhrase[" + reasonPhrase + "]");
        sb.append("resultStr[" + resultStr + "]");
        return sb.toString();
    }
}
