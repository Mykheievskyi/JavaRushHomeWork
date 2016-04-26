package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by dima on 26.04.16.
 */
public class Advertisement
{
    private Object content;     //видео
    private String name;        //имя/название
    private long initialAmount; //начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private int hits;           //количество оплаченных показов
    private int duration;       //продолжительность в секундах
    private long amountPerOneDisplaying = 0;


    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits == 0)
            amountPerOneDisplaying = 0;
        else
            amountPerOneDisplaying = initialAmount / hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if (hits <= 0)
            throw new UnsupportedOperationException();
        hits--;
    }
}
