package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dima on 05.02.16.
 */
public class MyThread extends Thread
{
    private static AtomicInteger currentPriorety = new AtomicInteger(0);

    private void init()
    {
        currentPriorety.incrementAndGet();
        currentPriorety.compareAndSet(11,1);

        int newPriority = currentPriorety.get();

        if (getThreadGroup() != null)
        {
            if (newPriority > getThreadGroup().getMaxPriority())
            {
                newPriority = getThreadGroup().getMaxPriority();
            }
        }

        setPriority(newPriority);
    }

    public MyThread() { init();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        init();
    }

    public MyThread(String name) {
        super(name);
        init();
    }

    public MyThread(Runnable target) {
        super(target);
        init();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        init();
    }
}
