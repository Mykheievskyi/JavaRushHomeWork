package com.javarush.test.level20.lesson10.bonus02;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");

        for(int j = 0; j < a.length; j++)
        {
            for(int i = 0; i < a.length; i++)
            {
                System.out.print(a[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static int getRectangleCount(byte[][] a)
    {
        int countRectangle =0;
        int size = a.length;

        for(int i = 0; i < size; i++)
        {
            boolean itsRectangle = false;

            for(int j = 0; j < size; j++)
            {

                if ((a[i][j] == 1) && (j == (size - 1)))
                {
                    countRectangle++;
                    removeStrip(a,i,j);
                }

                else if(a[i][j] == 1)
                {
                    itsRectangle = true;
                    removeStrip(a,i,j);
                }

                else if(a[i][j] == 0 && itsRectangle)
                {
                    countRectangle++;
                    itsRectangle = false;
                    removeStrip(a,i,j);

                }
            }
        }
        return countRectangle;
    }

    public static void removeStrip (byte [][] a, int i, int j)
    {
        int iterator = i;
        while (a[iterator][j] == 1)
        {
            a[iterator][j] = 0;
            if(iterator < a.length -1)
                iterator++;
        }

    }

}
