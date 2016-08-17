package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.util.Date;
import java.util.List;

/**
 * Created by dima on 09.07.16.
 */
public class CookedOrderEventDataRow implements EventDataRow
{
    private String tabletName;          //имя планшета
    private String cookName;            //имя повара
    private int cookingTimeSeconds;     //время приготовления заказа в секундах
    private List<Dish> cookingDishs;    //список блюд для приготовления
    private Date currentDate;


    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs)
    {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }
}
