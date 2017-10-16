package com.xuan.xutils.domain.result;

import java.text.MessageFormat;

/**
 * bizCode�����붨��淶
 * <p>
 * Created by xuan on 17/8/2.
 */
public enum BizCodeEnum {
    /**
     * bizCode�ĸ�ʽһ�����Ƕ���Ϊ: ҵ����Χǰ׺ + ����
     * һЩͨ����ʾ���ʹ��MessageFormat.format����,�����ڷ���ʱ�����ٶ���һЩֵ
     */
    PARAM_IS_EMPTY("common_001", "����[{0}]����Ϊ��."), DATABASE_OPERATE_FAIL("common_002", "���ݿ����ʧ��,��ʾ[{0}]."),;
    /**
     * bizCode
     */
    private String bizCode;
    /**
     * bizCode��ʾ˵��
     */
    private String msg;

    BizCodeEnum(String bizCode, String msg) {
        this.bizCode = bizCode;
        this.msg = msg;
    }

    public String getBizCode() {
        return bizCode;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * ����һ���Ѻ���ʾ,�����������msg�Ķ���
     *
     * @param params
     * @return
     */
    public String buildMsg(Object... params) {
        if (params != null) {
            return MessageFormat.format(msg, params);
        }
        return msg;
    }
}
