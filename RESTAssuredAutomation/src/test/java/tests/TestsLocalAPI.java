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

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestsLocalAPI
{

    @BeforeTest
    public void beforeTest()
    {
        JSONObject request = new JSONObject();

        request.put("firstName", "Harlequin");
        request.put("lastName", "Demon");
        request.put("subjectId", "6");
        request.put("id", 6);

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }

    //    @Test
    public void test()
    {
        baseURI = "http://localhost:3000";

        given().get("/users").then().statusCode(200).log().all(true);
    }

    @Test
    public void post()
    {
        JSONObject request = new JSONObject();

        request.put("firstName", "Harlequin");
        request.put("lastName", "Demon");
        request.put("subjectId", "2");

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }

    //    @Test
    public void put()
    {
        JSONObject request = new JSONObject();

        request.put("firstName", "Big");
        request.put("lastName", "Witch");
        request.put("subjectId", "1");

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/users/6")
                .then()
                .statusCode(200).log().all();
    }

    //    @Test
    public void patch()
    {
        JSONObject request = new JSONObject();

        request.put("firstName", "Small");

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("/users/6")
                .then()
                .statusCode(200).log().all();
    }

    @Test
    public void delete()
    {
        baseURI = "http://localhost:3000";

        when()
                .delete("/users/6")
                .then()
                .statusCode(200).log().all();
    }
}
