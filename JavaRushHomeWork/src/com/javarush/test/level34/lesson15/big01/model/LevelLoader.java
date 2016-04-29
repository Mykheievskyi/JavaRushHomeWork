package com.javarush.test.level34.lesson15.big01.model;

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
        Set<Wall> walls = new HashSet<>();
        walls.add(new Wall(200, 200));
        walls.add(new Wall(180, 180));
        walls.add(new Wall(220, 220));

        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(240, 240));

        Set<Home> homes = new HashSet<>();
        homes.add(new Home(80, 80));

        return new GameObjects(walls, boxes, homes, new Player(40, 40));
    }
}
