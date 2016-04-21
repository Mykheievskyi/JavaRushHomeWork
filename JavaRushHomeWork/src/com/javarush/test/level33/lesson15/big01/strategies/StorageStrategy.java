package com.javarush.test.level33.lesson15.big01.strategies;

/**
 * Created by dima on 13.04.16.
 */

//Все стратегии будут наследоваться от этого интерфейса
public interface StorageStrategy
{
    //возвращает  true, если хранилище содержит переданный ключ.
    boolean containsKey(Long key);

    //возвращает  true, если хранилище содержит переданое значение
    boolean containsValue(String value);

    //добавляет в хранилище новую пару ключ – значение
    void put(Long key, String value);

    //возвращает ключ для переданного значения
    Long getKey(String value);

    //возвращает значение для переданного ключа
    String getValue(Long key);
}
