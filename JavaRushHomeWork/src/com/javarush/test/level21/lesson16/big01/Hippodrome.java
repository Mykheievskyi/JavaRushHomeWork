package com.javarush.test.level21.lesson16.big01;


import java.util.ArrayList;

/**
 * Created by dima on 02.12.15.
 */
public class Hippodrome
{
    public static Hippodrome game = new Hippodrome();
    public static ArrayList<Horse> horses = new ArrayList<Horse>();

    public static void main (String[] args) throws InterruptedException
    {
        Hippodrome game = new Hippodrome();

        horses.add(new Horse("Sleven", 3, 0));
        horses.add(new Horse("Lucky", 3, 0));
        horses.add(new Horse("Gomer", 3, 0));

        game.run();
        game.printWinner();
    }

    public void move()
    {
        for(Horse horse: getHorses())
        {
            horse.move();
        }
    }

    public void run() throws InterruptedException
    {
        for(int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public  void print()
    {
        for(Horse horse : getHorses())
        {
            horse.print();
            System.out.println("");
            System.out.println("");
        }


    }



    public Horse getWinner()
    {
        Horse winerHorse = horses.get(0);

        for( Horse horse : horses)
        {
            if(horse.getDistance() > winerHorse.getDistance());
            {
                winerHorse = horse;
            }
        }

        return winerHorse;
    }

    public void printWinner()
    {
            System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
}
