package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dima on 22.02.16.
 */
public class Controller
{
    private Provider[] providers;
    private Model model;

    public Controller (Provider... providers)
    {
        if (providers.length == 0)
        {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    @Override
    public String toString()
    {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan()
    {
        try
        {

            ArrayList<Vacancy> listVacancy = new ArrayList<Vacancy>();

            for (Provider provider : providers) {

                listVacancy.addAll(provider.getJavaVacancies("java киев"));
            }

            System.out.println(listVacancy.size());
        } catch (NullPointerException e){ System.out.println(0);}

    }
}
