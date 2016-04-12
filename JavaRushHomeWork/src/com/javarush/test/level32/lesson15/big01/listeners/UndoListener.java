package com.javarush.test.level32.lesson15.big01.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Created by dima on 12.04.16.
 */

//Этот класс будет следить за правками, которые можно отменить или вернуть.
public class UndoListener implements UndoableEditListener
{
    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }


    @Override
    public void undoableEditHappened(UndoableEditEvent e)
    {
        //из переданного события получать правку и добавлять ее в undoManager
        undoManager.addEdit(e.getEdit());
    }
}
