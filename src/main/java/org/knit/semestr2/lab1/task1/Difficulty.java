package org.knit.semestr2.lab1.task1;

public enum Difficulty {
    EASY(1),
    MEDIUM(2),
    HARD(3),
    TOTALLY_FUCKED(4);

    public final int level;

    Difficulty(int level) {
        this.level = level;
    }

    public String getName() {
        switch (this) {
            case EASY:
                return "Легкий";
            case MEDIUM:
                return "Средний";
            case HARD:
                return "Сложный";
            case TOTALLY_FUCKED:
                return "*****";
        }
        return "Неопознанный";
    }
}
