package com.xl.设计模式.抽象工厂模式;

public interface FruitFactory {
    //实例化Apple
    public Fruit getApple();

    //实例化Banana
    public Fruit getBanana();
}
