package dto;

import lombok.Builder;

@Builder

public class BankAccount {
  private String bank_en;
    private String alias;
     private String bank;
       private String iban;
      private String bic;
        private String currency;
          private String address;

}

//TODO: Homework
//https://api.inv.bg/v3/swagger-ui/#/bank/postBankAccount
//Next week will be skipped
//21.03 Last lecture