package com.xl.������ǿ;

public class Eclipse����ʹ�� {
    /*
     * �߰汾��java�������еͰ汾��javac����ĳ��� �Ͱ汾��java�������и߰汾��javac����ĳ���
     */
    public static void main(String[] args) {
        // ����try..finallyģ��
        // 1.window-->preference-->java-->editor-->template
        int x;
        try {
            x = 1;
        } finally {
        }
        // compiler��ѡ�����汾
        // �߰汾��java�������еͰ汾��javac����ĳ���
        // �Ͱ汾��java�������и߰汾��javac����ĳ���
        // ÿһ��С���ڽ���ͼ�� ͸��ͼ�������Ͻǵģ���ʾ�ܶ�С����
        // �ϵ���ԣ�
        // F5:step into
        // F6:step over ����
        // F7:step return
        // drop to frame:������ǰ�����ĵ�һ��
        // resume:������һ���ϵ磨���û����һ������������������
        // DebugF8��һ��
    /*�ϵ�Ҫע�������
     * 1.�ϵ������ɺ�Ҫ��breakpoints��ͼ������жϵ�
	 * 2.�ϵ��ʽ��ɺ�һ��Ҫ�ǵ�ֹͣ����jvm
	 */
        x++;
        System.out.println(x);
        // ���ӿ�add Library�൱�ö�jar����user LibraryȻ�����Ӻܶ�jar��

		/*��ݼ�
		 * ���Ĵ�СдCtrl+Shift+X(��Y)
		 * �鿴��ļ̳й�ϵCtrl+T
		 * Ctrl+Shift+T����ֱ�Ӳ鿴��
		 * CTRL+SHIFT+L�鿴���п�ݼ�
		 */
    }
}

