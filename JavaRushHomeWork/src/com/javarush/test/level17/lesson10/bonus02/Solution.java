package com.javarush.test.level17.lesson10.bonus02;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            //добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
            if (args[0].equals("-c")) {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 3) {
                        Person person = null;
                        String name = args[i];
                        String sex = args[i + 1];
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        Date date = format.parse(args[i + 2]);
                        person = sex.equals("м") ? Person.createMale(name, date) : Person.createFemale(name, date);
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
            }

            //обновляет соответствующие данные людей с заданными id
            if (args[0].equals("-u")) {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) {
                        int id = Integer.parseInt(args[i]);
                        String name = args[i + 1];
                        String sex = args[i + 2];
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        Date date = format.parse(args[i + 3]);
                        for (int j = 0; j < allPeople.size(); j++) {
                            if (id == j) {
                                allPeople.get(j).setName(name);
                                allPeople.get(j).setSex("м".equals(sex) ? Sex.MALE : Sex.FEMALE);
                                allPeople.get(j).setBirthDay(date);
                            }
                        }
                    }
                }
            }

            //производит логическое удаление всех людей с заданными id
            if (args[0].equals("-d")) {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                    }
                }
            }

            //выводит на экран информацию о всех людях с заданными id: name sex bd
            if (args[0].equals("-i")) {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        System.out.println(allPeople.get(id).getName() + " ");
                        System.out.println(allPeople.get(id).getSex().equals(Sex.MALE) ? "м " : "ж ");
                        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        System.out.println(format.format(allPeople.get(id).getBirthDay()));

                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}