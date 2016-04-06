package com.javarush.test.level30.lesson06.home01;


import java.util.concurrent.RecursiveTask;

/**
 * Created by dima on 07.03.16.
 */
public class BinaryRepresentationTask extends RecursiveTask<String>
{
    private final int x;
    public BinaryRepresentationTask(int x)
    {
        this.x = x;
    }

    @Override
    protected String compute()
    {
        int a = x % 2;
        int b = x /2;
        String result = String.valueOf(a);
        BinaryRepresentationTask task = new BinaryRepresentationTask(b);

        task.fork();

        if (b > 0) {
            return task.join() + result;
        }

        return result;
    }
}
