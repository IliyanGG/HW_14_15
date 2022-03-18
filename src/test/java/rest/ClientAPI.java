package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Client;
import dto.SuccessResponse;
import io.restassured.response.Response;

public class ClientAPI {

  private static Gson gson = new GsonBuilder().create();
  private static final String CLIENTS_URL = "/clients";
  private static final String CLIENT_URL = "/client";

  public static Response getAllClients() {
    return HTTPClient.get(CLIENTS_URL);
  }

  public static Response getClient(int id) {
    return HTTPClient.get(CLIENT_URL + "/" + id);
  }

  public static Response createClient(Client client) {
    return HTTPClient.post(CLIENT_URL, gson.toJson(client));
  }

  public static Response updateClient(int id, Client client) {
    return HTTPClient.put(CLIENT_URL + "/" + id, gson.toJson(client));
  }


  public static Response deleteClient(int id) {
    return HTTPClient.delete(CLIENT_URL + "/" + id);
  }


  public static void main(String[] args) {
    Response getAllResp = getAllClients();
    Client clientDto = new Client("Firmata2", "Sofia2", "New address2", true, "new firm mol4", "bulstat4", "vat number4");
    Response createClientResp = createClient(clientDto);
    String clientCreateString = createClientResp.getBody().asString();
    SuccessResponse successResponse = gson.fromJson(clientCreateString, SuccessResponse.class);
    int clientId = successResponse.getSuccess().getId();
    Response getClientResp = getClient(clientId);
   clientDto.setFirm_name("Updated Firm name2");
    clientDto.setFirm_town("Plovdivv");
  Response updateClientResp = updateClient(clientId, clientDto);
  }
}