package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Item;
import dto.Success;
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
        Item item = Item.builder().name("Poison")
                .quantity_unit("kg")
                .price_for_quantity(10).build();
        Gson gson = new GsonBuilder().create();
        Response response = baseRequest.body(gson.toJson(item))
                .post("/item")
                .prettyPeek();
        String clientResponse = response.getBody().asString();
        Success success = gson.fromJson(clientResponse, Success.class);
        baseRequest.get("/item" + "/" + success.getId());
   /*     baseRequest.get("items").prettyPeek();
        baseRequest.get("clients").prettyPeek();
        baseRequest.get("invoices").prettyPeek();
        baseRequest.get("settings/bankaccounts").prettyPeek();*/
         }
    }





