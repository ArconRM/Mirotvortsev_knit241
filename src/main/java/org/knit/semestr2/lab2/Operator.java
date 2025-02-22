package org.knit.semestr2.lab2;

import java.util.concurrent.BlockingQueue;

public class Operator implements Runnable {
    private final BlockingQueue<Detail> assemblingQueue;
    private final BlockingQueue<Detail> warehouseQueue;

    public Operator(BlockingQueue<Detail> assemblingQueue, BlockingQueue<Detail> warehouseQueue) {
        this.assemblingQueue = assemblingQueue;
        this.warehouseQueue = warehouseQueue;
    }

    @Override
    public void run() {
        while (warehouseQueue.size() < 10) {
            try {
                Detail detail = assemblingQueue.take();
                Thread.sleep(2000);
                warehouseQueue.put(detail);
                System.out.println("Проверил деталь " + detail.getId() + " и отправил ее на склад");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
