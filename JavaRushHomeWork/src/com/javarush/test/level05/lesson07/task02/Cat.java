package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать
какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени
может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name;
    private int weight = 5;
    private int age = 5;
    private String color;
    private String adress;

    public void initialize(String name)
    {
        this.name = name;
    }

    public void initialize(String name, int weight, int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public void initialize(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void initialize(int weight, String color)
    {
        this.weight = weight;
        this.color = color;
    }

    public void initialize(int weight, String color, String adress)
    {
        this.adress = adress;
        this.weight = weight;
        this.color = color;
    }

}
