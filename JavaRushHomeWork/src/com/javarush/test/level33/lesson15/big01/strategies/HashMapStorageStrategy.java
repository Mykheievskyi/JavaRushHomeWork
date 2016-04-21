package com.javarush.test.level33.lesson15.big01.strategies;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dima on 13.04.16.
 */
public class HashMapStorageStrategy implements StorageStrategy
{
    //В этом поле будут храниться наши данные.
    private HashMap<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key)
    {
        for (Map.Entry<Long, String> pair : data.entrySet())
        {
            if (pair.getKey().equals(key))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(String value)
    {
        for (Map.Entry<Long, String> pair : data.entrySet())
        {
            if (pair.getValue().equals(value))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value)
    {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value)
    {
        for (Map.Entry<Long, String> pair : data.entrySet())
        {
            if (pair.getValue().equals(value))
            {
                return pair.getKey();
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key)
    {
        for (Map.Entry<Long, String> pair : data.entrySet())
        {
            if (pair.getKey().equals(key))
            {
                return pair.getValue();
            }
        }
        return null;
    }
}
