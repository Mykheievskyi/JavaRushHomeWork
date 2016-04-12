package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dima on 08.04.16.
 */
public class View extends JFrame implements ActionListener
{
    private Controller controller;
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);


    //это будет панель с двумя вкладками
    private JTabbedPane tabbedPane = new JTabbedPane();

    //это будет компонент для визуального редактирования html
    private JTextPane htmlTextPane = new JTextPane();

    //это будет компонент для редактирования html в виде
    //текста, он будет отображать код html (теги и их содержимое)
    private JEditorPane plainTextPane = new JEditorPane();

    public View()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String command = actionEvent.getActionCommand();

        if(command.equals("Новый"))
        {
            controller.createNewDocument();
        }
        else if (command.equals("Открыть"))
        {
            controller.openDocument();
        }
        else if (command.equals("Сохранить"))
        {
            controller.saveDocument();
        }
        else if (command.equals("Сохранить как..."))
        {
            controller.saveDocumentAs();
        }
        else if (command.equals("Выход"))
        {
            controller.exit();
        }
        else if (command.equals("О программе"))
        {
            this.showAbout();
        }
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

    public void initMenuBar()
    {
        //Создавать новый объект типа JMenuBar. Это и будет наша панель меню
        JMenuBar jMenuBar = new JMenuBar();

        //С помощью MenuHelper инициализировать меню в следующем порядке:
        MenuHelper.initFileMenu(this, jMenuBar);  //Файл
        MenuHelper.initEditMenu(this, jMenuBar);  //Редактировать
        MenuHelper.initStyleMenu(this, jMenuBar); // Стиль
        MenuHelper.initAlignMenu(this, jMenuBar); // Выравнивание
        MenuHelper.initColorMenu(this, jMenuBar); // Цвет
        MenuHelper.initFontMenu(this, jMenuBar); // Шрифт
        MenuHelper.initHelpMenu(this, jMenuBar); // Помощь

        //Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню
        getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }

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

        //Добавлять по центру панели контента текущего фрейма нашу панель с вкладками
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    public boolean isHtmlTabSelected()
    {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void initGui()
    {
        //инициализация меню
        initMenuBar();

        //инициализация редактора
        initEditor();

        pack(); //реализацию которого мы унаследовали от класса JFrame
    }

    //Этот метод вызывается, когда произошла смена выбранной вкладки
    public void selectedTabChanged()
    {
        ////Метод должен проверить, какая вкладка сейчас оказалась выбранной
        switch (tabbedPane.getSelectedIndex())
        {
           case 0:

               //получаем текст из plainTextPane и установить его в контроллер с помощью метода setPlainText
               controller.setPlainText(plainTextPane.getText());
               break;
           case 1:

               //получаем текст у контроллера с помощью метода getPlainText() и установить его в панель plainTextPane
               plainTextPane.setText(controller.getPlainText());
               break;
        }

        //сбрасываем правки
        this.resetUndo();
    }

    public boolean canUndo()
    {
        return undoManager.canUndo();
    }

    public boolean canRedo()
    {
        return undoManager.canRedo() ;
    }

    public void undo()
    {
        try
        {
            undoManager.undo();
        } catch (CannotUndoException e)
        {ExceptionHandler.log(e);}

    }

    public void redo()
    {
        try
        {
            undoManager.redo();
        } catch (CannotUndoException e)
        {ExceptionHandler.log(e);}
    }

    //сбрасывает все правки в менеджере undoManager
    public void resetUndo()
    {
        undoManager.discardAllEdits();
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void selectHtmlTab()
    {
        //Выбираем html вкладку (переключаться на нее)
        tabbedPane.setSelectedIndex(0);

        //Сбрасываем все правки
        resetUndo();
    }

    public void update()
    {
        //получаем документ у контроллера и устанавливаем его в панель редактирования htmlTextPane.
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout()
    {
        JOptionPane.showMessageDialog(this,"HTML Editor","About", JOptionPane.INFORMATION_MESSAGE);
    }
}
