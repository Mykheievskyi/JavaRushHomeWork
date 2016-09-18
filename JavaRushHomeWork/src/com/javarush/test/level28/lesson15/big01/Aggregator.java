package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;




/**
 * Created by dima on 22.02.16.
 */
public class Aggregator
{
    public static void main(String[] args)
    {

        HtmlView view = new HtmlView();
        Provider providerHH = new Provider(new HHStrategy());
        Provider providerMK = new Provider(new MoikrugStrategy());
        Model model = new Model(view, new Provider[] {providerHH, providerMK});

        view.setController(new Controller(model));
        view.userCitySelectEmulationMethod("java kiev");

    }

}
