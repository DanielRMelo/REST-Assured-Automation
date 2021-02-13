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

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

public class TestsSoapXMLRequest
{
    @Test
    public void validateSoapXML() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(new File("./SoapRequests/Add.xml"));
        
        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
        
        baseURI = "http://www.dneonline.com/";
        
        given().contentType("text/xml").
            accept(ContentType.XML).
            body(requestBody).
        when().
            post("/calculator.asmx").
        then().
            statusCode(200).
        log().all().and().body("//*:AddResult.text()", equalTo("5"));
        
    }
}
