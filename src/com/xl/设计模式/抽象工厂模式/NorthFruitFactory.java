package com.xl.设计模式.抽象工厂模式;

public class NorthFruitFactory implements FruitFactory {
    public Fruit getApple() {
        return new NorthApple();
    }

    public Fruit getBanana() {
        return new NorthBanana();
    }
}
