package com.javarush.test.level36.lesson04.big01.controller;

import com.javarush.test.level36.lesson04.big01.model.Model;
import com.javarush.test.level36.lesson04.big01.view.UsersView;

/**
 * Created by dima on 10.05.16.
 */

//Этот класс будет получать запрос от клиента, оповещать Модель об этом, а Модель, в свою очередь, будет обновлять ModelData-у.
public class Controller
{
    private Model model;
    private UsersView usersView;

    public void setModel(Model model) {
        this.model = model;
    }

    //обращается к моделе и инициирует загрузку юзеров.
    public void onShowAllUsers()
    {
        model.loadUsers();

        //Вью сама не умеет себя обновлять. Это делает Контроллер. Пойди в контроллер и добавь обновление данных во Вью.
        usersView.refresh(model.getModelData());
    }

    public void setUsersView(UsersView usersView)
    {
        this.usersView = usersView;
    }

    public void onShowAllDeletedUsers()
    {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

}
