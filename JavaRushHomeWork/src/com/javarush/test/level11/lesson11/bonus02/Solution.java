package com.javarush.test.level11.lesson11.bonus02;

/* Нужно добавить в программу новую функциональность
Добавь общий базовый класс к классам-фигур:  (фигуры из шахмат).
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public  class CheesItem
    {
        int x;
        int y;
        int worth;
    }
    public class King extends CheesItem
    {
    }

    public class Queen extends CheesItem
    {
    }

    public class Rook extends CheesItem
    {
    }

    public class Knight extends CheesItem
    {
    }

    public class Bishop extends CheesItem
    {
    }

    public class Pawn extends CheesItem
    {
    }
}
