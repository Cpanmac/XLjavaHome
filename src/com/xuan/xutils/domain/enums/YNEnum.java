package com.xuan.xutils.domain.enums;

/**
 * һ��ͨ�õ����ֶԴ��ö��
 * <p>
 * Created by xuan on 17/8/2.
 */
public enum YNEnum {
    Y(true, 1, "��"), N(false, 0, "��");
    private boolean value;
    private int code;
    private String msg;

    YNEnum(boolean value, int code, String msg) {
        this.value = value;
        this.code = code;
        this.msg = msg;
    }

    /**
     * ����code��ȡ��YNEnum,ȡ��������null
     *
     * @param code
     * @return
     */
    public static YNEnum codeOf(int code) {
        for (YNEnum ynEnum : YNEnum.values()) {
            if (ynEnum.code == code) {
                return ynEnum;
            }
        }
        return null;
    }

    public boolean isValue() {
        return value;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
