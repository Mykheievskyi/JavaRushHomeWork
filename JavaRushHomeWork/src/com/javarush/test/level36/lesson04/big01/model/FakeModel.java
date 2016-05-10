package com.javarush.test.level36.lesson04.big01.model;


import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dima on 10.05.16.
 */
public class FakeModel implements Model
{
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        List<User> useres = new ArrayList<>();

        useres.add(new User("a",1,1));
        useres.add(new User("b",2,1));

        modelData.setUsers(useres);
    }

    @Override
    public void loadDeletedUsers()
    {
        throw new UnsupportedOperationException();
    }
}
