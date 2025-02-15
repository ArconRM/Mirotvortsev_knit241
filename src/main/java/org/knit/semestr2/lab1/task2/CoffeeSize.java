package org.knit.semestr2.lab1.task2;

public enum CoffeeSize {
    SMALL(0),
    MEDIUM(50),
    LARGE(100);

    public final int addedPrice;

    CoffeeSize(int addedPrice) {
        this.addedPrice = addedPrice;
    }
}
