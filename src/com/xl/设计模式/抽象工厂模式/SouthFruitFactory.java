package com.xl.设计模式.抽象工厂模式;

public class SouthFruitFactory implements FruitFactory {
    public Fruit getApple() {
        return new SouthApple();
    }

    public Fruit getBanana() {
        return new SouthBanana();
    }
}
