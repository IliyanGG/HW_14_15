package core;

import dto.LoginCredentials;
import org.junit.jupiter.api.BeforeAll;
import rest.API;
import rest.LoginAPI;

public class BaseAPITest {
    private static final String EMAIL = System.getProperty("email","korpens@gmail.com");
    private static final String PASSWORD = System.getProperty("password", "vDnrmgc7GFcc4!e");
    private static final String DOMAIN = System.getProperty("domain", "test7667");
    private static final String BASE_URI = System.getProperty("baseUri", "https://api.inv.bg");
    private static final String BASE_PATH = System.getProperty("basePath","v3");
    protected  static API api;

    @BeforeAll
    static void beforeAll(){
        //Obtain token
        LoginAPI loginAPI = new LoginAPI(BASE_URI, BASE_PATH, "");
        LoginCredentials loginToken = new LoginCredentials(EMAIL, PASSWORD, DOMAIN);
        String bearerToken  = loginAPI.getToken(loginToken);
        //Configure all API classes
        //Provide access for all tests to the api classes
        api = new API(BASE_URI, BASE_PATH, bearerToken);
    }
}
