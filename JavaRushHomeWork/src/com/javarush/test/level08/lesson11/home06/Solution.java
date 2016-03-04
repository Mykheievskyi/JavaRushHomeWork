package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код

        Human children1 = new Human("children1", true, 2, new ArrayList<Human>());
        Human children2 = new Human("children2", false, 3, new ArrayList<Human>());
        Human children3 = new Human("children3", false, 4, new ArrayList<Human>());

        ArrayList<Human> children = new ArrayList<>();

        children.add(children1);
        children.add(children2);
        children.add(children3);

        Human mother = new Human("mother", false, 21, children);
        Human father = new Human("father", true,22, children);

        ArrayList<Human> parents = new ArrayList<>();
        parents.add(mother);
        ArrayList<Human> par = new ArrayList<>();
        par.add(father);

        Human grandmother = new Human("grandmother", false, 34, par);
        Human grandfather = new Human("grandfather", true, 35, par);

        Human grandmother1 = new Human("grandmother1", false, 34, parents);
        Human grandfather1 = new Human("grandfather1", true, 35, parents);

        System.out.println(children1.toString());
        System.out.println(children2.toString());
        System.out.println(children3.toString());
        System.out.println(mother.toString());
        System.out.println(father.toString());
        System.out.println(grandfather.toString());
        System.out.println(grandmother.toString());
        System.out.println(grandfather1.toString());
        System.out.println(grandmother1.toString());
    }

    public static class Human
    {
        //напишите тут ваш код

        String name;
        boolean sex;
        int age;

        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
