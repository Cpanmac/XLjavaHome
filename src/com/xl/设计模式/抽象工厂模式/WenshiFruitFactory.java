package com.xl.设计模式.抽象工厂模式;

public class WenshiFruitFactory implements FruitFactory {
    public Fruit getApple() {
        return new WenshiApple();
    }

    public Fruit getBanana() {
        return new WenshiBanana();
    }
}
