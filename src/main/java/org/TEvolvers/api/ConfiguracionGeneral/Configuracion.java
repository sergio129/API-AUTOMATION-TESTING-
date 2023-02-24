package org.TEvolvers.api.ConfiguracionGeneral;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class Configuracion {
    public static final String UrlBase="https://restful-booker.herokuapp.com";
    public void Conf(){
        RestAssured.baseURI=UrlBase;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
}
