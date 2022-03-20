package rest;

import dto.Client;
import io.restassured.response.Response;

public class BankAccountAPI extends HTTPClient {

    private static final String BANK_ACCOUNT_URL = "/bank/accounts";
    private static final String BANK_TRANSACTIONS_URL = "/bank/transactions";


    public ClientAPI(String baseUri, String basePath, String token) {
        super(baseUri, basePath, token);
    }

    public Response createClient(Client client){
        return post(CLIENT_URL, GSON.toJson(client));
    }

    public Response updateClient(String id, Client client){
        return put(CLIENT_URL + "/" + id, GSON.toJson(client));
    }

    public Response deleteClient(String id){
        return delete(CLIENT_URL + "/" + id);
    }

    public Response getClient(String id){
        return get(CLIENT_URL + "/" + id);
    }

    public Response getAllClients(){
        return get(CLIENT_URL);
    }

    public BankAccountAPI(String baseUri, String basePath, String token) {
        super(baseUri, basePath, token);
    }
}


//TODO: Homework
//Docs: https://api.inv.bg/v3/swagger-ui/#/bank/postBankAccount
//ytyrtytryrtyryrt