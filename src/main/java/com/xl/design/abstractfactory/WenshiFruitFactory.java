package com.xl.design.abstractfactory;

public class WenshiFruitFactory implements FruitFactory {
    @Override
    public Fruit getApple() {
        return new WenshiApple();
    }

    @Override
    public Fruit getBanana() {
        return new WenshiBanana();
    }
}
