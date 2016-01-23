package com.javarush.test.level03.lesson04.task02;

/* 4 скобки
Расставить правильно (по другому) скобки, чтобы на экран вывелось число 850
*/

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class Solution
{
    public static void main(String[] args)
    {


        ArrayList<Integer> testList = new ArrayList<Integer>();
        Collections.addAll(testList, 0, 4, 5, 9, 1, 7, 6, 3, 2, 8);

        Stack stack = new Stack();
        int m = 1;
        stack.push(0);


            for (int i = 0; i < testList.size();)
            {
                while (!stack.empty())
                {
                    if ((Integer) stack.peek() == testList.get(i))
                    {
                        stack.pop();
                        i++;
                    }
                    else if (m <= testList.size() - 1)
                    {
                        stack.push(m);
                        m++;
                    }
                    else {break;}

                }
                if (stack.empty() && (m <= testList.size() - 1))
                {
                    stack.push(m);
                    m++;
                }
                else
                {
                    i = testList.size();
                }
            }

        if (stack.empty())
            System.out.println("правильная последовательность");
        else
        {
            System.out.println("не правильная последовательность");
        }

        System.out.println(stack);
        System.out.print(testList);
    }
}

