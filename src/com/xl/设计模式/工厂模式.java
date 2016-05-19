package com.xl.���ģʽ;

interface fruit {
    public abstract void eat();
}

public class ����ģʽ {
    public static void main(String[] a) {
        fruit f = Factory.getInstance("Orange");
        f.eat();
    }
}

class Apple implements fruit {
    public void eat() {
        System.out.println("Apple");
    }
}

class Orange implements fruit {
    public void eat() {
        System.out.println("Orange");
    }
}

// ���칤����
// Ҳ����˵�Ժ�������������������ʵ����ʱ��ֻ��Ҫ�޸Ĺ����������
class Factory {
    public static fruit getInstance(String fruitName) {
        fruit f = null;
        if ("Apple".equals(fruitName)) {
            f = new Apple();
        }
        if ("Orange".equals(fruitName)) {
            f = new Orange();
        }
        return f;
    }
}
// �����������������һ�������ʱ�򣬾���Ҫ�޸Ĺ������ˡ�����������̫��������ʱ�򣬸ĵľͻ�ܶࡣ
// �������ǿ������÷�����ƣ�