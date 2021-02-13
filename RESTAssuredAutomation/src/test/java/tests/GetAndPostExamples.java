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

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples
{
    @Test
    public void testGet()
    {

        baseURI = "https://reqres.in/api";

        given().get("/users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George")).body("data.first_name", hasItems("George", "Rachel"));
    }

    @Test
    public void testPost()
    {

        baseURI = "https://reqres.in/api";

        //        Map<String, Object> map = new HashMap<String, Object>();
        //        map.put("name", "Daniel");
        //        map.put("job", "Developer");
        //        System.out.println(map);

        JSONObject request = new JSONObject();
        
        request.put("name", "Daniel");
        request.put("job", "Developer");

        System.out.println(request.toJSONString());
        
        given().
            header("Content-Type", "application/json").
            contentType(ContentType.JSON).accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            post("/users").
        then().
            statusCode(201).
            log().all();
    }
}
