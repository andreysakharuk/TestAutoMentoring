package com.epam.cdp.api.facade;

import com.epam.cdp.api.model.User;
import io.restassured.response.Response;

public class UserWsFacade extends AbstractWsFacade {

    private static final String RELATIVE_PATH = "/users";
    private static final String ID_PATH = "/?id=";

    public Response get(){
        return get(RELATIVE_PATH);
    }

    public User[] getUsers() {
        Response response = get(RELATIVE_PATH);
        User[] users = response.as(User[].class);
        return users;
    }

    public User getUserById(int userId) {
        Response response = get(RELATIVE_PATH + ID_PATH + userId);
        User[] users = response.as(User[].class);
        return users[0];
    }

}
