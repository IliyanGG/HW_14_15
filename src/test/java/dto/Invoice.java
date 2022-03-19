package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Invoice {
    private List<Item> items;
    private String date;

    public static void main(String[] args) {
        Gson gson  = new GsonBuilder().setPrettyPrinting().create();
        List<Item> items = new ArrayList<>();
        Item coffee = new Item("Coffee", "kg.", 20, "BGN", 10);
        Item whiskey = new Item("Whiskey", "lt.", 20, "BGN", 10);
        items.add(coffee);
        items.add(whiskey);
        Invoice invoice = Invoice.builder()
                .date("2022-03-19")
                .items(items)
                .build();
        String invoiceJson = gson.toJson(invoice);
        System.out.println(invoiceJson);
        Invoice deserializedInvoice = gson.fromJson(invoiceJson, Invoice.class);
        System.out.println(deserializedInvoice.items.toString());

    }
}
