package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;
import com.javarush.test.level34.lesson15.big01.model.GameObjects;
import com.javarush.test.level34.lesson15.big01.model.Model;
import com.javarush.test.level34.lesson15.big01.view.View;

/**
 * Created by dima on 26.04.16.
 */
public class Controller implements EventListener
{
    private View view;
    private Model model;

    public Controller()
    {
        model = new Model();
        view = new View(this);
        view.init();
        model.restart();
        model.setEventListener(this);
        view.setEventListener(this);
    }

    public static void main(String[] args) {

        new Controller();
    }

    @Override
    public void move(Direction direction)
    {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart()
    {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel()
    {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);
    }

    public GameObjects getGameObjects()
    {
        return model.getGameObjects();
    }
}
