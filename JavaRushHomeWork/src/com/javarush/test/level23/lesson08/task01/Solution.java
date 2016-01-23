package com.javarush.test.level23.lesson08.task01;

/* Напряги извилины!
Метод printName должен выводить свое собственное имя, т.е. "sout"
Сделайте минимум изменений.
*/
public class Solution
{
    static String name; //private поменял на static

    Solution(String name) {
        this.name = name;
    }

    static String getName() { //private поменял на static
        return name;
    }

    private void sout()
    {
        new Solution("sout")
        {
            void printName()
            {
                System.out.println(getName());  //но не понятно почему здесь если поставить  super.getName не проходит
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("main").sout();
    }
}
