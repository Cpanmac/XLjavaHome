package com.xl.enumdemo;

public enum Grade {
    // 1.
    // A,B,C,D,E;;
    // //��Ϊ�����вεĹ��캯�����������汨��
    // private Grade(){
    //
    // }
    //
    // 2.��ζ���ö�ٵĹ��캯�����������ֶΣ�ȥ��װ�������Ϣ
    // A("100-90"),B("89-80"),C("70-79"),D("60-69"),E("0-59");
    // 3.�����󷽷���ö��.ϣ�����þ͵õ���Ӧ�ĵȼ����š���..)
    A("100-90") {
        public String localeValue() {
            return "��";
        }
    }, B("89-80") {
        @Override
        public String localeValue() {
            return "����";
        }
    }, C("70-79") {
        @Override
        public String localeValue() {
            return "һ��";
        }
    }, D("60-69") {
        @Override
        public String localeValue() {
            return "��";
        }
    }, E("0-59") {
        @Override
        public String localeValue() {
            return "������";
        }
    };
    // ϣ���õ�����Ϳ��Զ�Ӧ�ķ���
    private String value;

    Grade(String value) {
        this.value = value;
    }

    public abstract String localeValue();

    public String getValue() {
        return this.value;
    }
}
