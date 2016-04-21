package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level32.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;



/**
 * Created by dima on 13.04.16.
 */
public class FileBucket
{
    private Path path;

    public FileBucket() {
        try
        {
            //Инициализировать path временным файлом. Файл должен быть размещен
            //в директории для временных файлов и иметь случайное имя
            path = Files.createTempFile("tmp", null);


        } catch (IOException e) {
            ExceptionHandler.log(e);
        }

        //Обеспечивать удаление файла при выходе из программы.
        path.toFile().deleteOnExit();
    }

    //возвращает размер файла на который указывает path.
    public long getFileSize()
    {
        return path.toFile().length();
    }

    //должен сериализовывать переданный entry в файл
    public void putEntry(Entry entry)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile())))
        {
            oos.writeObject(entry);
        }
        catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }


    public Entry getEntry()
    {
        if (getFileSize() == 0) return null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile())))
        {
            return (Entry) ois.readObject();

        } catch (Exception e) {
                ExceptionHandler.log(e);
        }
        return null;
    }

    //удаляет файл на который указывает path.
    public void remove()
    {
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
