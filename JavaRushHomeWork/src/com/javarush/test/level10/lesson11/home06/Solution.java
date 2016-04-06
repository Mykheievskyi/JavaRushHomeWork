package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы

        String name;
        boolean isMan;
        int age;
        double waight;
        double height;
        boolean isMarried;

        public Human()
        {
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean isMan) {
            this.name = name;
            this.age = age;
            this.isMan = isMan;
        }

        public Human(String name, int age, boolean isMan, double height) {
            this.name = name;
            this.age = age;
            this.isMan = isMan;
            this.height = height;
        }

        public Human(String name, int age, boolean isMan, double height, double waight) {
            this.name = name;
            this.age = age;
            this.isMan = isMan;
            this.height = height;
            this.waight = waight;
        }

        public Human(String name, int age, boolean isMan, double height, double waight, boolean isMarried) {
            this.name = name;
            this.age = age;
            this.isMan = isMan;
            this.height = height;
            this.waight = waight;
            this.isMarried = isMarried;
        }

        public Human(String name, int age, double height, double waight) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.waight = waight;
        }

        public Human(String name, boolean isMan, boolean isMarried) {
            this.name = name;
            this.isMan = isMan;
            this.isMarried = isMarried;
        }

        public Human(String name, double height, double waight) {
            this.name = name;
            this.height = height;
            this.waight = waight;
        }
    }
}
