package com.xuan.xutils.domain.result;

import com.xuan.xutils.domain.BaseDO;

import java.util.Date;

/**
 * һ��RPC���û���HTTP�ӿڷ���,���ǻ�ͳһ��װ���������Result����
 * <p>
 * Created by xuan on 17/8/2.
 */
public class BaseResult extends BaseDO {
    private static final long serialVersionUID = 1L;
    /**
     * ���״̬��,һ��������ʾ��ε����Ƿ�ɹ�,
     * �ο�ö��: CodeEnum
     */
    private int code;
    /**
     * ʱ���
     */
    private long serverTime = new Date().getTime();
    /**
     * ������һ�ִ�����ʱ,����Ҫ����message������Ϣ,���������һ��bizCode,���÷����Ը������bizCode������Ӧ��ҵ����
     * �ο�ö��: BizCodeEnum
     */
    private String bizCode;
    /**
     * �ɹ�����ʧ����ʾ��Ϣ
     */
    private String message;
    /**
     * ���صĽ������
     */
    private Object result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }
}
