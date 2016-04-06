package com.javarush.test.level32.lesson04.home01;

import java.io.*;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException
    {
        StringWriter sw = new StringWriter();

        if (is != null)
        {
            InputStreamReader inputStreamReader = new InputStreamReader(is);

            char[] buffer = new char[1024];
            int count;

            while (inputStreamReader.ready())
            {
                count = inputStreamReader.read(buffer);
                sw.write(buffer,0,count);
            }

            inputStreamReader.close();
        }
        return sw;
    }
}
