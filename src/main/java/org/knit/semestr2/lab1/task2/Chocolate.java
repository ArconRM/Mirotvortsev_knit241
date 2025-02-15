package org.knit.semestr2.lab1.task2;

public class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 100;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", добавлен шоколадъ";
    }
}
