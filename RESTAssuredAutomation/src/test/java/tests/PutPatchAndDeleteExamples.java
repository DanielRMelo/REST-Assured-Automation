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

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchAndDeleteExamples
{
    @Test
    public void testPut()
    {
        baseURI = "https://reqres.in/api";

        JSONObject request = new JSONObject();
        
        request.put("name", "Daniel");
        request.put("job", "Developer");

        System.out.println(request.toJSONString());
        
        given().
            header("Content-Type", "application/json").
            contentType(ContentType.JSON).accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            put("/users/2").
        then().
            statusCode(200).
            log().all();
    }
    
    @Test
    public void testPatch()
    {
        baseURI = "https://reqres.in/api";

        JSONObject request = new JSONObject();
        
        request.put("name", "Daniel");
        request.put("job", "Developer");

        System.out.println(request.toJSONString());
        
        given().
            header("Content-Type", "application/json").
            contentType(ContentType.JSON).accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            patch("/users/2").
        then().
            statusCode(200).
            log().all();
    }
    
    @Test
    public void testDelete()
    {
        baseURI = "https://reqres.in/api";

        when().
            delete("/users/2").
        then().
            statusCode(204).
            log().all();
    }
}
