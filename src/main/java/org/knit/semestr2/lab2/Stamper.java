package org.knit.semestr2.lab2;

import java.util.concurrent.BlockingQueue;

public class Stamper implements Runnable {
    private final BlockingQueue<Detail> stampingQueue;
    private int lastDetailId = 0;

    public Stamper(BlockingQueue<Detail> blockingQueue) {
        this.stampingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (lastDetailId < 3) {
            try {
                stampingQueue.put(new Detail(++lastDetailId));
                System.out.println("Штамповщик сделал заготовку " + lastDetailId);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Штамповщик ушел домой.");
    }
}
