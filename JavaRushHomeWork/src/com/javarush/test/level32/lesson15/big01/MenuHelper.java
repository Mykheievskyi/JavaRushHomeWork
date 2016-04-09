package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import java.awt.event.ActionListener;


/**
 * Created by dima on 09.04.16.
 */

//Это будет вспомогательный класс для инициализации и настройки меню.
public class MenuHelper
{
    //parent - меню в которое мы добавляем пункт
    //text - текст добавляемого пункта
    //actionListener - слушатель действий добавляемого пункта меню

    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener)
    {
        //Создаем новый пункт меню JMenuItem, используя text.
        JMenuItem menuItem = new JMenuItem(text);

        //Устанавливать этому пункту слушателя действий
        menuItem.addActionListener(actionListener);

        //Добавляем в parent созданный пункт меню.
        parent.add(menuItem);

        return  menuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, Action action)
    {
        JMenuItem menuItem = new JMenuItem(action);

        parent.add(menuItem);

        return menuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, String text, Action action)
    {
        JMenuItem menuItem = addMenuItem(parent,action);

        menuItem.setText(text);

        return menuItem;
    }

    //инициализация меню помощи
    public static void initHelpMenu(View view, JMenuBar menuBar)
    {
        //TODO
    }

    //инициализация меню выбора
    public static void initFontMenu(View view, JMenuBar menuBar)
    {
        //TODO
    }

    //инициализация меню выбора цвета
    public  static void initColorMenu(View view, JMenuBar menuBar)
    {
        //TODO
    }

    //инициализация меню выравнивания
    public static void initAlignMenu(View view, JMenuBar menuBar)
    {
        //TODO
    }

    //инициализация меню выбора стиля текста
    public static void initStyleMenu(View view, JMenuBar menuBar)
    {
        //TODO
    }

    //инициализация меню редактирования текста.
    public static void initEditMenu(View view, JMenuBar menuBar)
    {
        //TODO
    }

    //инициализация меню Файл
    public static void initFileMenu(View view, JMenuBar menuBar)
    {
        //TODO
    }
}
