package org.example.patterns;

abstract class Drink {

    // Template Method
    public final void prepare() {
        prepareCup();
        prepareBase();
        addIngredients();
        serve();
    }

    private void prepareCup() {
        System.out.println("Подготовить стакан");
    }

    protected abstract void prepareBase();

    protected abstract void addIngredients();

    private void serve() {
        System.out.println("Подать напиток");
    }
}

class Coffee extends Drink {

    @Override
    protected void prepareBase() {
        System.out.println("Приготовить эспрессо");
    }

    @Override
    protected void addIngredients() {
        System.out.println("Добавить молоко и сахар");
    }
}

class Lemonade extends Drink {

    @Override
    protected void prepareBase() {
        System.out.println("Налить холодную воду");
    }

    @Override
    protected void addIngredients() {
        System.out.println("Добавить лимон, мяту и лёд");
    }
}

public class TemplateMethodExample {

    public static void main(String[] args) {

        System.out.println("=== Кофе ===");

        Drink coffee = new Coffee();
        coffee.prepare();

        System.out.println();

        System.out.println("=== Лимонад ===");

        Drink lemonade = new Lemonade();
        lemonade.prepare();
    }
}