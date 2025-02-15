package org.knit.semestr2.lab1.task1;

public class LegalDepartment extends Handler {
    @Override
    public boolean canApprove(Difficulty difficulty) {
        return difficulty.level <= Difficulty.HARD.level;
    }

    @Override
    public void approve(Difficulty difficulty) {
        System.out.println("Юридический отдел смог решить запрос.");
    }
}
