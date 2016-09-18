package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Алла on 13.11.2014.
 */
public class Advertisement
{
    private Object content;                     //видео
    private String name;                        //имя-название
    private long initialAmount;                 //начальная сумма, стоимость рекламы в копейках
    private int hits;                           //количество оплаченных показов
    private int duration;                       //продолжительность в секундах
    private long amountPerOneDisplaying;        //должно равняться стоимости одного показа рекламного объявления в копейках
    private long balance;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount / hits;
        balance = initialAmount;


    }

    public String getName()
    {
        return name;
    }

    public int getDuration()
    {
        return duration;
    }

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if(hits <= 0)
            throw new UnsupportedOperationException();
        balance -= amountPerOneDisplaying;
        hits--;
        if(hits != 0)
            amountPerOneDisplaying = balance / hits;
    }

    public int getHits()
    {
        return hits;
    }
}