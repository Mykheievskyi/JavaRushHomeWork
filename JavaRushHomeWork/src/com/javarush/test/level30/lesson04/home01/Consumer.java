package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created by dima on 06.03.16.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignore) {
            }
            while (true) {
                try {
                    System.out.println("Processing " + queue.take().toString());
                } catch (InterruptedException ignore) {
                }
            }
        }
    }
}
