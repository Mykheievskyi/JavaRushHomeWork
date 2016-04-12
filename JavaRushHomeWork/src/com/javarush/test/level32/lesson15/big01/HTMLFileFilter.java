package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by dima on 12.04.16.
 */

//
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File f)
    {
        if (f.isDirectory()) {
            return true;
        }
        else if (!f.isDirectory())
        {
            String file = f.getName().toLowerCase();
            return file.endsWith(".html") || file.endsWith(".htm");
        }

        return false;
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
