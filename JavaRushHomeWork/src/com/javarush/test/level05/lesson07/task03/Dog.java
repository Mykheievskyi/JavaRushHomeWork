package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    String name;
    int lenght;
    String color;

    public void initialize(String name)
    {
        this.name = name;
    }

    public void initialize(String name, int lenght)
    {
        this.name = name;
        this.lenght = lenght;
    }

    public void initialize(String name, int lenght, String color)
    {
        this.name = name;
        this.lenght = lenght;
        this.color = color;
    }
}
