package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by dima on 13.04.16.
 */
public class Entry<key, value> implements Serializable
{
    final int hash;
    final Long key;
    String value;
    Entry<key, value> next;


    public Entry(int hash, Long key, String value, Entry next)
    {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Long getKey()
    {
        return key;
    }

    public Entry getNext()
    {
        return next;
    }

    public String getValue()
    {
        return value;
    }

    public int hashCode()
    {
         return hash ^ Objects.hashCode(value);
    }
    public String toString()
    {
        return key + "=" + value;
    }
}
