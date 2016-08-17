package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by dima on 26.04.16.
 */

public class LevelLoader
{
    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

    public GameObjects getLevel(int level)
    {
        while(level > 60){
            level = level - 60;
        }

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        try{
            BufferedReader br = new BufferedReader(new FileReader(levels.toString()));

            while(true)
            {
                String lev = br.readLine();
                if(lev.equals("Maze: " + level))
                {
                    break;
                }
            }

            br.readLine();

            String [] sizeX = br.readLine().split(" ");
            String [] sizeY = br.readLine().split(" ");

            int weight = Integer.parseInt(sizeX[2]);
            int height = Integer.parseInt(sizeY[2]);

            br.readLine();
            br.readLine();
            br.readLine();

            for(int y = 0; y < height; y++){

                String line = br.readLine();
                char [] chars = line.toCharArray();

                for(int x = 0; x < weight; x++){
                    char aChar = chars[x];

                    switch(aChar){

                        case ' ' : break;
                        case 'X' : walls.add(new Wall(x*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2, y*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2));
                            break;
                        case '*' :
                            boxes.add(new Box(x * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, y * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
                            break;
                        case '.':
                            homes.add(new Home(x * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, y * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
                            break;
                        case '&' :
                            boxes.add(new Box(x * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, y * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
                            homes.add(new Home(x * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, y * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
                            break;
                        case '@' :
                            player = new Player(x*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2,y*Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE/2);
                            break;
                    }

                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return new GameObjects(walls,boxes,homes,player);
    }
}