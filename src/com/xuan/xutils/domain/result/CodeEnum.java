package com.xuan.xutils.domain.result;

/**
 * ���״̬���ö��
 * <p>
 * Created by xuan on 17/8/2.
 */
public enum CodeEnum {
    ERROR(0, "����"), SUCCESS(1, "�ɹ�");
    private int code;
    private String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * �ж��Ƿ����
     *
     * @param code
     * @return
     */
    public static boolean isContain(int code) {
        for (CodeEnum codeEnum : CodeEnum.values()) {
            if (codeEnum.getCode() == code) {
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

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * �ж��Ƿ���ͬ
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

    /**
     * ����code��ȡö��,�����ȡ����,����null
     *
     * @param code
     * @return
     */
    public CodeEnum codeOf(int code) {
        for (CodeEnum codeEnum : CodeEnum.values()) {
            if (codeEnum.getCode() == code) {
                return codeEnum;
            }
        }
        return null;
    }
}
