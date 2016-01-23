package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution
{

    public static void main(String[] argc) throws Exception
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws Exception
    {
        if(string == null) {throw new TooShortStringException();}

        if (string.equals("")) {throw new TooShortStringException();}

        int firstSpace = string.indexOf(" ");
        if(firstSpace == -1)
        {
            throw  new TooShortStringException();
        }
        int secondSpace = string.indexOf(" ", firstSpace + 1);
        if(secondSpace == -1)
        {
            throw  new TooShortStringException();
        }
        int thirdSpace = string.indexOf(" ", secondSpace + 1);
        if(thirdSpace == -1)
        {
            throw  new TooShortStringException();
        }
        int fourthSpace = string.indexOf(" ", thirdSpace + 1);
        if(fourthSpace == -1)
        {
            throw  new TooShortStringException();
        }
        int fiveSpace = string.indexOf(" ", fourthSpace + 1);
        if(fiveSpace == -1)
        {
            throw  new TooShortStringException();
        }


        return string.substring(firstSpace + 1, fiveSpace);
    }

    public static class TooShortStringException extends Exception
    {

    }
}
