package org.knit.semestr2.lab2;

import java.util.concurrent.BlockingQueue;

public class Assembler implements Runnable {
    private final BlockingQueue<Detail> stampingQueue;
    private final BlockingQueue<Detail> assemblingQueue;
    private int lastDetailId = 0;

    public Assembler(BlockingQueue<Detail> stampingQueue, BlockingQueue<Detail> assemblingQueue) {
        this.stampingQueue = stampingQueue;
        this.assemblingQueue = assemblingQueue;
    }

    @Override
    public void run() {
        while (lastDetailId < 10) {
            try {
                Detail detail = stampingQueue.take();
                Thread.sleep(1500);
                assemblingQueue.put(detail);
                System.out.println("Сборщик собрал деталь " + detail.getId());
                lastDetailId ++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
