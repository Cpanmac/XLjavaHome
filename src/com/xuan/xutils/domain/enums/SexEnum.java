package com.xuan.xutils.domain.enums;

/**
 * �Ա�ö��
 * <p>
 * Created by xuan on 17/8/2.
 */
public enum SexEnum {
    MAN(1, "��"), WOMAN(2, "Ů");
    private int code;
    private String msg;

    SexEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * ����code��ȡ��SexEnum,ȡ��������null
     *
     * @param code
     * @return
     */
    public static SexEnum codeOf(int code) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getCode() == code) {
                return sexEnum;
            }
        }
        return null;
    }

    /**
     * �ж����code�Ƿ����
     *
     * @param code
     * @return
     */
    public static boolean isContain(int code) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    /**
     * isContainȡ��
     *
     * @param code
     * @return
     */
    public static boolean isNotContain(int code) {
        return !isContain(code);
    }

    /**
     * �ж������Ƿ���ͬ
     *
     * @param code
     * @return
     */
    public boolean isEq(int code) {
        return this.code == code;
    }

    /**
     * isEqȡ��
     *
     * @param code
     * @return
     */
    public boolean isNotEq(int code) {
        return !isEq(code);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
