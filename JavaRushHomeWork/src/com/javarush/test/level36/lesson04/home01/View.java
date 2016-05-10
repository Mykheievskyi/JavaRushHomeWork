package com.javarush.test.level36.lesson04.home01;

/**
 * Created by dima on 10.05.16.
 */
public class View
{
    private Controller controller = new Controller();

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }
}
