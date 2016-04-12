package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;


import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;


/**
 * Created by dima on 12.04.16.
 */
public class TextEditMenuListener implements MenuListener
{
    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }

    public void menuSelected(MenuEvent menuEvent)
    {
        //Из переданного параметра получать объект, над которым было совершено действие
        JMenu jMenu = (JMenu) menuEvent.getSource();

        //У полученного меню получать список компонентов (пунктов меню)
        Component[] components = jMenu.getMenuComponents();

        //Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра
        //результат вызова метода isHtmlTabSelected() из представления.
        for (Component component : components)
        {
            component.setEnabled(view.isHtmlTabSelected());
        }

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
