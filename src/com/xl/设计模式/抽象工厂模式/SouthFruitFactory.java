package com.xl.���ģʽ.���󹤳�ģʽ;

public class SouthFruitFactory implements FruitFactory {
    public Fruit getApple() {
        return new SouthApple();
    }

    public Fruit getBanana() {
        return new SouthBanana();
    }
}
