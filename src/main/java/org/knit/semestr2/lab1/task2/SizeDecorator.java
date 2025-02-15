package org.knit.semestr2.lab1.task2;

public class SizeDecorator extends CoffeeDecorator {
    protected CoffeeSize size;

    public SizeDecorator(Coffee coffee, CoffeeSize size) {
        super(coffee);
        this.size = size;
    }

    @Override
    public int getCost() {
        return super.getCost() + size.addedPrice;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", размера " + size.toString().toLowerCase();
    }
}
