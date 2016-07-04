package com.yankovets.hfdp.adapter.adapter1;

public class TurkeyTestDrive {
    public static void main(String[] args) {
        WildTurkey turkey = new WildTurkey();

        MallarDuck duck = new MallarDuck();
        Turkey duckAdapter = new DuckAdapter(duck);

        System.out.println("The Duck says...");
        duck.quack();
        duck.fly();

        System.out.println("\nThe Turkey says...");
        testTurkey(turkey);

        System.out.println("\nThe DuckAdapter says...");
        testTurkey(duckAdapter);
    }

    private static void testTurkey(Turkey turkey) {
        turkey.gobble();
        turkey.fly();
    }
}
