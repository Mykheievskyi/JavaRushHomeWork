package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dima on 08.04.16.
 */
public class View extends JFrame implements ActionListener
{
    private Controller controller;

    //это будет панель с двумя вкладками
    private JTabbedPane tabbedPane = new JTabbedPane();

    //это будет компонент для визуального редактирования html
    private JTextPane htmlTextPane = new JTextPane();

    //это будет компонент для редактирования html в виде
    //текста, он будет отображать код html (теги и их содержимое)
    private JEditorPane plainTextPane = new JEditorPane();

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void init()
    {
        //Вызов инициализации графического интерфейса
        initGui();

        //Добавлять слушателя событий нашего окна
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);

        //Показывать наше окно
        setVisible(true);

    }

    public void exit()
    {
        controller.exit();
    }

    public void initMenuBar(){}

    public void initEditor()
    {
        //Устанавливать значение "text/html" в качестве типа контента для компонента htmlTextPane
        htmlTextPane.setContentType("text/html" );

        //Создавать новый локальный компонент JScrollPane на базе htmlTextPane.
        //Добавлять вкладку в панель tabbedPane с именем "HTML" и компонентом из предыдущего пункта.
        tabbedPane.add("HTML", new JScrollPane(htmlTextPane));

        //Создавать новый локальный компонент JScrollPane на базе plainTextPane.
        // Добавлять еще одну вкладку в tabbedPane с именем "Текст" и компонентом из предыдущего пункта.
        tabbedPane.add("Текст", new JScrollPane(plainTextPane));

        //Устанавливать предпочтительный размер панели tabbedPane.
        tabbedPane.setPreferredSize(new Dimension(800,600));

        //Создавать объект класса TabbedPaneChangeListener и устанавливать его в качестве
        //слушателя изменений в tabbedPane.
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        //Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    public void initGui()
    {
        //инициализация меню
        initMenuBar();

        //инициализация редактора
        initEditor();

        pack(); //реализацию которого мы унаследовали от класса JFrame
    }

    public void selectedTabChanged()
    {
        //TODO
    }
}
