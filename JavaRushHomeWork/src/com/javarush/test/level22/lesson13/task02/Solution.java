package com.javarush.test.level22.lesson13.task02;



import java.io.*;


/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException
    {
        FileInputStream is = new FileInputStream(args[0]);
        FileOutputStream os = new FileOutputStream(args[1]);
        byte[] buff=new byte[is.available()];
        is.read(buff);
        String s= new String(buff, "UTF-8");
        os.write(s.getBytes("Windows-1251"));

        is.close();
        os.close();
    }
}
