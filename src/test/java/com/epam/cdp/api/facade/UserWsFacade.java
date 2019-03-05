package com.epam.cdp.api.facade;

import com.epam.cdp.api.model.User;
import io.restassured.response.Response;

public class UserWsFacade extends AbstractWsFacade{

    public User[] getUsers(){
        Response response = getResponse("/users");
        User[] users = response.as(User[].class);
        return users;
    }

    public User getUser(String userIdPath){
        Response response = getResponse("/users" + userIdPath);
        User[] users = response.as(User[].class);
        return  users[0];
    }

}
