package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    String name;
    int lenght;
    String color;

    public Dog(String name)
    {
        this.name = name;
    }

    public Dog(String name, int lenght)
    {
        this.name = name;
        this.lenght = lenght;
    }

    public Dog(String name, int lenght, String color)
    {
        this.name = name;
        this.lenght = lenght;
        this.color = color;
    }

}
