package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика
Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        Cat tomCat = new Cat("Tom", 3, 0);
        Dog gavDog = new Dog("Gav", 3, 6);
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Dog
    {
        String name;
        int weight;
        int strenght;

        public Dog(String name, int weight, int strenght)
        {
            this.name = name;
            this.weight = weight;
            this.strenght = strenght;
        }
    }

    public static class Cat
    {
        String name;
        int weight;
        int mimi;

        public Cat(String name, int weight, int mimi)
        {
            this.name = name;
            this.weight = weight;
            this.mimi = mimi;
        }
    }

}
