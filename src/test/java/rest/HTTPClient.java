package rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTPClient {
    static RequestSpecification baseRequest = RestAssured.given()
            .baseUri("https://test7667.inv.bg")
            .basePath("/RESTapi")
            .auth()
            .basic("korpens@gmail.com", "vDnrmgc7GFcc4!e")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .log().all()
            .when();

    public static Response get(String url){
        return baseRequest.get(url)
                .prettyPeek();
    }

    public static Response post(String url, String body){
        return baseRequest.body(body)
                .post(url)
                .prettyPeek();
    }

    public static Response delete(String url){
        return baseRequest.delete(url)
                .prettyPeek();
    }

    public static Response put(String url, String body){
        return baseRequest.body(body)
                .put(url)
                .prettyPeek();
    }
}
