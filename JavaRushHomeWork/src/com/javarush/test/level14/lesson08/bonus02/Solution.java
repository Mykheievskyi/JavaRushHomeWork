package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());



        System.out.println(gcd(num1,num2));
    }

    public static int gcd(int x, int y)
    {

        int r = 0, a ,b;
        a = (x > y) ? x : y;
        b = (x > y) ? y : x;

        r = b;

        while ( a % b != 0)
        {
            r = a % b;
            a = b;
            b = r;
        }

        return r;
    }


}
