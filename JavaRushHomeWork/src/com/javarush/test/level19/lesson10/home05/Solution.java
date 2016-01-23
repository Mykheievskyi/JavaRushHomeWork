package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));


        while (bufferedReader.ready())
        {
            String text = bufferedReader.readLine();
            String[] wordsLine = text.split(" ");

            for(int i = 0; i < wordsLine.length; i++)
            {
                boolean isTrue = false;
                char[] chars = wordsLine[i].toCharArray();
                for(int m = 0; m < chars.length; m++)
                {
                    if(chars[m] >= '0' && chars[m] <= '9')
                    {
                        isTrue = true;
                    }
                }
                if(isTrue == true)
                {
                    bufferedWriter.write(wordsLine[i] + " ");
                }
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
