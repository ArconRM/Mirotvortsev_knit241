package org.knit.semestr2.lab1.task1;

public class CallCenter extends Handler {
    @Override
    public boolean canApprove(Difficulty difficulty) {
        return difficulty.level <= Difficulty.EASY.level;
    }

    @Override
    public void approve(Difficulty difficulty) {
        System.out.println("Колл центр смог решить запрос.");
    }
}
