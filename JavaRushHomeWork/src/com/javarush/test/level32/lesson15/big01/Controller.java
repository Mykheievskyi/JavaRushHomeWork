package com.javarush.test.level32.lesson15.big01;


import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by dima on 08.04.16.
 */
public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public static void main(String[] args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init(){ createNewDocument();}

    public void exit()
    {
        System.exit(0);
    }

    public void resetDocument()
    {
        if (document != null)
        {
           document.removeUndoableEditListener(view.getUndoListener());
        }

        //Создаем новый документ по умолчанию и присваивать его полю document.
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();

        //Добавляем новому документу слушателя правок.
        document.addUndoableEditListener(view.getUndoListener());

        //Вызываем у представления метод update()
        view.update();
    }

    public void setPlainText(String text)
    {
        resetDocument();

        StringReader stringReader = new StringReader(text);

        try
        {
            //Вызываем метод read() из класса HTMLEditorKit, который вычитает данные из реадера в документ documen
            new HTMLEditorKit().read(stringReader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText()
    {
        StringWriter stringWriter = new StringWriter();

        try
        {
            //Переписываем все содержимое из документа document в созданный объект с помощью метода write класса HTMLEditorKit.
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

        return stringWriter.toString();
    }

    public void createNewDocument()
    {
        //Выбирать html вкладку у представления
        view.selectHtmlTab();

        //Сбрасывать текущий документ
        resetDocument();

        // Устанавливаем новый заголовок окна
        view.setTitle("HTML редактор");

        //Сбрасываем правки в Undo менеджере
        view.resetUndo();

        //Обнуляем переменную currentFile.
        currentFile = null;
    }

    public void openDocument()
    {
        //Переключаем представление на html вкладку
        view.selectHtmlTab();

        //Создавем новый объект для выбора файла JFileChooser
        JFileChooser jFileChooser = new JFileChooser();

        //Устанавливаем ему в качестве фильтра объект HTMLFileFilter..
        jFileChooser.setFileFilter(new HTMLFileFilter());

        //Показываем диалоговое окно "Save File" для выбора файла
        int n = jFileChooser.showOpenDialog(view);

        //Если пользователь подтвердит выбор файла
        if( n == jFileChooser.APPROVE_OPTION)
        {
            //Сохраняем выбранный файл в поле currentFile.
            currentFile = jFileChooser.getSelectedFile();

            //Сбрасываем докумен
            resetDocument();

            //Устанавливаем имя файла в качестве заголовка окна представления.
            view.setTitle(currentFile.getName());

            try (FileReader fileReader = new FileReader(currentFile))
            {
                new HTMLEditorKit().read(fileReader, document, 0);

                view.resetUndo();
            }catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument()
    {
        if (currentFile == null)
        {
            saveDocumentAs();
        }
        else
        {
            view.selectHtmlTab();

            try (FileWriter fileWrite = new FileWriter(currentFile))
            {
                new HTMLEditorKit().write(fileWrite, document, 0, document.getLength());
            } catch (Exception e)
            {
                ExceptionHandler.log(e);
            }

        }
    }

    public void saveDocumentAs()
    {
        //Переключаем представление на html вкладку
        view.selectHtmlTab();

        //Создавем новый объект для выбора файла JFileChooser
        JFileChooser jFileChooser = new JFileChooser();

        //Устанавливаем ему в качестве фильтра объект HTMLFileFilter..
        jFileChooser.setFileFilter(new HTMLFileFilter());

        //Показываем диалоговое окно "Save File" для выбора файла
        int n = jFileChooser.showSaveDialog(view);

        //Если пользователь подтвердит выбор файла
        if( n == jFileChooser.APPROVE_OPTION)
        {
            //Сохраняем выбранный файл в поле currentFile.
            currentFile = jFileChooser.getSelectedFile();

            //Устанавливаем имя файла в качестве заголовка окна представления.
            view.setTitle(currentFile.getName());

            try (FileWriter fileWrite = new FileWriter(currentFile))
            {
                new HTMLEditorKit().write(fileWrite, document, 0 , document.getLength());
            }catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }
}
