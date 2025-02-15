package org.knit.semestr2.lab1.task2;

public class Espresso implements Coffee {
    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "Приготовлен путем прохождения горячей воды под давлением через фильтр с молотым кофе";
    }
}
