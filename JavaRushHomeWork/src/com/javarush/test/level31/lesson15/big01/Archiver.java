package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Created by dima on 25.03.16.
 */
public class Archiver
{
    public static void main(String[] args)
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            System.out.println("Введите полный путь к архиву");

            String zipPath =  reader.readLine();


            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(zipPath));

            System.out.println("Введите полный путь к файлу, который будем архивировать");
            String filePath = reader.readLine();

            zipFileManager.createZip(Paths.get(filePath));
        } catch (Exception e){}

    }
}
