package org.knit.semestr2.lab1.task1;

public class Manager extends Handler {
    @Override
    public boolean canApprove(Difficulty difficulty) {
        return difficulty.level <= Difficulty.MEDIUM.level;
    }

    @Override
    public void approve(Difficulty difficulty) {
        System.out.println("Менеджер смог решить запрос.");
    }
}
