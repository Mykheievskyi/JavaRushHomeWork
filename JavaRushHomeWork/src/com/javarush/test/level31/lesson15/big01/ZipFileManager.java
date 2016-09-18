package com.javarush.test.level31.lesson15.big01;


import java.io.FileOutputStream;
import java.io.InputStream;
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
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile.toFile())))
        {
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zos.putNextEntry(zipEntry);
            try (InputStream is = Files.newInputStream(source))
            {
                byte[] buffer = new byte[1024];
                int readBytes;
                while ((readBytes = is.read(buffer)) > 0)
                {
                    zos.write(buffer, 0, readBytes);
                }
            }
            zos.closeEntry();
        }
    }
}
