package com.xl.base;

import java.util.Scanner;

/**
 * 5.�������ܣ�Ҫ���ֻ�����ܣ� �����һ����ĸ�����ֵĺ�����3Ϊ����ĸ����Ӧ��ϵ���£� ���� z -> c a -> d b -> e c -> f
 * ...
 */
public class ��ĸ����3λ���� { // ��Ϊ���ֺ���ĸ�����໥ת����a��Ӧ����97 b��Ӧ����98
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("�����룺");
        String name = input.next();// �ӿ���̨�����ַ���
        int num; // ����num����ת��
        char[] ch = name.toCharArray();// ��������ַ���ת���ַ�
        for (int x = 0; x < ch.length; x++) {
            if (ch[x] >= 'x' && ch[x] <= 'z') { // ������x,С��z��ʱ������ټ�3�ᵼ�³�����ĸ�ķ�Χ��Ҫ�ص�a��b��c��λ�þͼ�ȥ23����26����ĸ��
                num = ch[x] - 23; // 26-3=23�����������ȥ23
                ch[x] = (char) num; // ��numת�����ַ�����ֵ���ַ�����
            } else if (ch[x] >= 'X' && ch[x] <= 'Z') {// �����Ǵ�д��
                num = ch[x] - 24;
                ch[x] = (char) num;
            } else {
                num = ch[x] + 3; // ����������ƶ�3λ
                ch[x] = (char) num;
            }
        }
        for (char c : ch) { // �߼�forѭ����������������Ի�����ͨfor��
            System.out.print(c);
        }
    }
}