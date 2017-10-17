package com.xl.design;

interface fruit {
    void eat();
}

public class FactoryDemo {
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

// 构造工厂类
// 也就是说以后如果我们在添加其他的实例的时候只需要修改工厂类就行了
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
// 这样，当我们在添加一个子类的时候，就需要修改工厂类了。如果我们添加太多的子类的时候，改的就会很多。
// 现在我们看看利用反射机制：
