//**********************************************************************
// Copyright (c) 2021 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TestsExamples
{
    @Test
    public void test_1() {
        
        Response response = get("https://reqres.in/api/users?page=2");
        
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        
        int statusCode = response.getStatusCode();
        
        Assert.assertEquals(statusCode, 200);
    }
    
    @Test
    public void test_2() {
        
        baseURI = "https://reqres.in/api";
        
        given().
            get("/users?page=2").
        then().
            statusCode(200).
            body("data[1].id", equalTo(8));
    }
}
