package rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Client {

     static     RequestSpecification baseRequest = RestAssured.given()
                .baseUri("https://test7667.inv.bg")
                .basePath("RESTapi")
                .auth()
                .basic("korpens@gmail.com", "vDnrmgc7GFcc4!e")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .when();

    public static void main(String[] args) {
        Response getItemsResponse = baseRequest.get("items")
                .prettyPeek();

        Response getClientsResponse = baseRequest.get("clients")
                .prettyPeek();

        Response getAllInvoices = baseRequest.get("invoices")
                .prettyPeek();


    }

    }





