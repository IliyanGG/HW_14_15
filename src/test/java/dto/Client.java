package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.lang.String;

@AllArgsConstructor
@Builder
@Data

public class Client {

  private String firm_name;
  private String firm_town;
  private String firm_addr;
  private boolean firm_is_reg_vat;
  private String firm_mol;
  private String firm_bulstat;
  private String firm_vat_number;

  public static void main(String[] args) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Client client = new ClientBuilder().build();
    client.setFirm_name("Effortel");
    client.setFirm_town("Sofia");
    client.setFirm_addr("Adress");
    client.setFirm_is_reg_vat(true);
    client.setFirm_mol("Mol na firmata");
    client.setFirm_bulstat("firmbulstat");
    client.setFirm_vat_number("firmVatnumber");
    System.out.println(gson.toJson(client));
    String jsonString =
        "{\n"
            + "    \"firm_name\": \"Фирма v7c\",\n"
            + "    \"firm_town\": \"София1234\",\n"
            + "    \"firm_addr\": \"Адрес 3\",\n"
            + "    \"firm_bulstat\": \"bulstat\",\n"
            + "    \"firm_is_reg_vat\": true,\n"
            + "    \"firm_vat_number\": \"84\",\n"
            + "    \"firm_mol\": \"firm_mol\"\n"
            + "}";
    Client client2 = gson.fromJson(jsonString, Client.class);
    System.out.println(client2.getFirm_name());
  }
}
