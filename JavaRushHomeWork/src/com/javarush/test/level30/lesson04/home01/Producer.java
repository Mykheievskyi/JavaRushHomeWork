package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by dima on 06.03.16.
 */
public class Producer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
            for (int i = 1; i <= 9; i++)
            {
                String s = "ShareItem-" + i;
                System.out.format("Элемент 'ShareItem-%d' добавлен",i);
                System.out.println();

                queue.offer(new ShareItem(s, i));

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                if(queue.hasWaitingConsumer())
                {
                    System.out.println("Consumer в ожидании!");
                }
            }

    }
}
