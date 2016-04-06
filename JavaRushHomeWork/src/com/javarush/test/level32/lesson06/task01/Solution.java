package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args)
    {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword()
    {
        Random random = new Random();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


        byteArrayOutputStream.write(48 + random.nextInt(10)); //цифры
        byteArrayOutputStream.write(65 + random.nextInt(26)); //мелкие буквы
        byteArrayOutputStream.write(97 + random.nextInt(26)); //большие буквы

        for (int i = 0; i < 5; i++)
        {
            int x = (int) (Math.random() * 3);

            switch (x)
            {
                case 0: byteArrayOutputStream.write(48 + random.nextInt(10)); //цифры
                    break;
                case 1: byteArrayOutputStream.write(65 + random.nextInt(26)); //мелкие буквы
                    break;
                case 2: byteArrayOutputStream.write(97 + random.nextInt(26)); //большие буквы
                    break;
            }
        }

        return byteArrayOutputStream;
    }
}
