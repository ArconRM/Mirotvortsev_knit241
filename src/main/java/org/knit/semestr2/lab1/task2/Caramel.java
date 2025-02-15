package org.knit.semestr2.lab1.task2;

public class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 150;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", добавлена карамель";
    }
}
