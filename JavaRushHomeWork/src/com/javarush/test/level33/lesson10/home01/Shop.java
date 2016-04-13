package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

/**
 * Created by dima on 13.04.16.
 */

@XmlType(name = "shop")
@XmlRootElement
public class Shop
{
    @XmlElementWrapper(name="goods", nillable = true)
    public ArrayList<String> names = new ArrayList<>();
    public int count = 12;
    public String profit = "123.4";
    public ArrayList<String> secretData = new ArrayList<>();
}
