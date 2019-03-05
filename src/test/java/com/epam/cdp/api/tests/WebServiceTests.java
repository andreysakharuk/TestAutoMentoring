package com.epam.cdp.api.tests;

import com.epam.cdp.api.facade.UserWsFacade;
import com.epam.cdp.api.model.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class WebServiceTests {


    @Test(description = "Check response code of GET method")
    public void checkResponseCode() {
        Response response = new UserWsFacade().getResponse("/users");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Check content-type value of response header of GET method")
    public void checkResponseHeader() {
        Response response = new UserWsFacade().getResponse("/users");
        Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
    }

    @Test(description = "Check number of users in response body")
    public void checkNumberOfUsers() {
        User[] users = new UserWsFacade().getUsers();
        Assert.assertEquals(users.length, 10);
    }

    @Test(description = "Check emails contain @")
    public void checkEmails() {
        User[] users = new UserWsFacade().getUsers();
        for (User user : users) {
            assertThat(user.getEmail(), containsString("@"));
        }
    }

    @Test(description = "Check username is not empty")
    public void checkUsername() {
        User[] users = new UserWsFacade().getUsers();
        for (User user : users) {
            assertThat(user.getUsername(), is(not("")));
        }
    }

    @Test(description = "Check city name")
    public void checkCity() {
        User user = new UserWsFacade().getUser("/?id=2");
        assertThat(user.getAddress().getCity(), is("Wisokyburgh"));
    }
}






