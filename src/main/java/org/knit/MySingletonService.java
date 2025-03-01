package org.knit;

public class MySingletonService {

    private static volatile MySingletonService instance;

    private MySingletonService() {

    }

    public static MySingletonService getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                if (instance == null) {
                    instance = new MySingletonService();
                }
            }
        }
        return instance;
    }
}

enum MySingletonServiceEnum {
    INSTANCE;
}
