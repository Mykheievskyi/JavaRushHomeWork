package com.javarush.test.level31.lesson15.big01;


import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by dima on 25.03.16.
 */
public class ZipFileManager
{
    private Path zipFile;

    public ZipFileManager(Path zipFile)
    {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception
    {
        ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));

        ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());

        zipOutputStream.putNextEntry(zipEntry);



    }
}
