package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 26.02.16.
 */
public class Model
{
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers)
    {
        if(providers.length == 0 || view == null || providers == null)
            throw new IllegalArgumentException();

        this.providers = providers;
        this.view = view;
    }

    public void selectCity(String city)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        for(Provider provider : providers)
            vacancies.addAll(provider.getJavaVacancies(city));

        view.update(vacancies);
    }
}