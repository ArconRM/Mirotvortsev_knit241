package org.knit.semestr2.lab1.task1;

public abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract boolean canApprove(Difficulty difficulty);
    public abstract void approve(Difficulty difficulty);

    public void processRequest(Difficulty difficulty) {
        if (canApprove(difficulty)) {
            approve(difficulty);
        } else if (nextHandler != null) {
            nextHandler.processRequest(difficulty); // Передача запроса дальше
        } else {
            System.out.println("Запрос уровня " + difficulty + " никто не смог обработать");
        }
    }
}
