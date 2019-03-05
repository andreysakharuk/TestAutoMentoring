package com.epam.cdp.api.facade;

import com.epam.cdp.base.ConfigProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.when;

abstract class AbstractWsFacade {

    public Response getResponse(String path){
        RestAssured.baseURI = new ConfigProvider().getBaseUri();
        Response rp = when().get(path).andReturn();
        return rp;
    }

}
