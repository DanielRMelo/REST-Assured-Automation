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
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class TestJSONSchemaValidator
{
    
    @Test
    public void testGet()
    {

        baseURI = "https://reqres.in/api";

        given().
            get("/users?page=2").
        then().
            assertThat().body(matchesJsonSchemaInClasspath("Schema.json")).
            statusCode(200).
            body("data[4].first_name", equalTo("George")).
            body("data.first_name", hasItems("George", "Rachel")).log().all();
    }

}
