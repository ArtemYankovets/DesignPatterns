package com.yankovets.hfdp.adapter.adapter1;

public class DuckAdapter implements Turkey {
    Duck duck;

    public DuckAdapter(final Duck duck) {
        this.duck = duck;
    }

    public void gobble() {
        for (int i = 0; i < 5; i++) {
            duck.quack();
        }
    }

    public void fly() {
        duck.fly();
    }
}
