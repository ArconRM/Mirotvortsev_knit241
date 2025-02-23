package org.knit.semestr2.lab2;

import java.util.concurrent.Semaphore;

public class GasStation {
    private final Semaphore semaphore;

    public GasStation(int count) {
        this.semaphore = new Semaphore(count);
    }

    public void Refuel(String carName) {
        try {
            System.out.println(carName + " ждет заправки");
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(carName + " заправилась и уехала");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}
