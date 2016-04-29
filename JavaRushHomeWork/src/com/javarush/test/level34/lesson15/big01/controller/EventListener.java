package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;

/**
 * Created by dima on 26.04.16.
 */
public interface EventListener
{

    //передвинуть объект в определенном направлении
    void move(Direction direction);

    //начать заново текущий уровень
    void restart();

    //начать следующий уровень
    void startNextLevel();

    //уровень с номером level завершён.
    void levelCompleted(int level);
}
