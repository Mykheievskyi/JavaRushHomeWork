package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

/**
 * Created by dima on 13.04.16.
 */
public class Shortener {

    //Это поле будет отвечать за последнее значение идентификатора, которое было использовано при добавлении
    // новой строки в хранилище
    private Long lastId = 0L;

    //тут будет храниться стратегия хранения данных
    private StorageStrategy storageStrategy;



    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }


    //будет возвращать идентификатор id для заданной строки
    public synchronized Long getId(String string)
    {

        //Проверить есть ли переданное значение в хранилище, если есть – вернуть его ключ
        if (storageStrategy.containsValue(string))
        {
            return storageStrategy.getKey(string);
        }
        else
        {
            //Увеличить значение lastId
            lastId ++;

            //Добавить в хранилище новую пару ключ-значение (новое значение lastId и переданную строку)
            storageStrategy.put(lastId, string);

            //Вернуть новое значение lastId
            return lastId;
        }
    }

    //будет возвращать строку для заданного идентификатора или null, если передан неверный идентификатор
    public synchronized String getString(Long id)
    {

        if (storageStrategy.containsKey(id)) {
            return storageStrategy.getValue(id);
        }
        else {
            return null;
        }
    }
}