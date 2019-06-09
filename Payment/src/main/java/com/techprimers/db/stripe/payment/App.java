package com.techprimers.db.stripe.payment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws StripeException
    {
        Stripe.apiKey="sk_test_pX7KwrP5dO6a07OZZnwsnC9800uGwzZjkY";
        Customer newCustomer = Customer.retrieve("cus_FDswTT5DCNDqBb");

        Map<String,Object> chargeParameter = new HashMap<String,Object>();

        chargeParameter.put("amount","2000");
        chargeParameter.put("currency","usd");
        chargeParameter.put("customer", newCustomer.getId());
        chargeParameter.put("source","card_1EjRTcFBXbV3SFA16Ya9E7KK");

        Charge charge=Charge.create(chargeParameter);

        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(charge));
        /*Map<String,Object> cardParameter = new HashMap<String,Object>();
        cardParameter.put("number","4111111111111111");
        cardParameter.put("exp_month","11");
        cardParameter.put("exp_year","2025");
        cardParameter.put("cvc","123");

        Map<String,Object> tokenParameter = new HashMap<String,Object>();
        tokenParameter.put("card",cardParameter);

        Token token = Token.create(tokenParameter);

        Map<String,Object> source = new HashMap<String,Object>();
        source.put("source",token.getId());

        newCustomer.getSources().create(source);*/

       /* */
        /*Map<String,Object> customerParameter = new HashMap<String,Object>();
        customerParameter.put("email","d@gmail.com");
        Customer newCustomer = Customer.create(customerParameter);

        Map<String,Object> cardParameter = new HashMap<String,Object>();
        cardParameter.put("number","4242424242424242");
        cardParameter.put("exp_month","11");
        cardParameter.put("exp_year","2024");
        cardParameter.put("cvc","123");

        Map<String,Object> tokenParameter = new HashMap<String,Object>();
        tokenParameter.put("card",cardParameter);

        Token token = Token.create(tokenParameter);

        Map<String,Object> source = new HashMap<String,Object>();
        source.put("source",token.getId());

        newCustomer.getSources().create(source);*/

        /*Map<String,Object> customerParameter = new HashMap<String,Object>();
        customerParameter.put("email","c@gmail.com");
        Customer newCustomer = Customer.create(customerParameter);*/

        /*Customer a = Customer.retrieve("cus_FDrNEdi44BbAh9");

        Map<String,Object> cardParameter = new HashMap<String,Object>();
        cardParameter.put("number","4242424242424242");
        cardParameter.put("exp_month","11");
        cardParameter.put("exp_year","2024");
        cardParameter.put("cvc","123");

        Map<String,Object> tokenParameter = new HashMap<String,Object>();
        tokenParameter.put("card",cardParameter);

        Token token = Token.create(tokenParameter);

        Map<String,Object> source = new HashMap<String,Object>();
        source.put("source",token.getId());

        a.getSources().create(source);
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(token));*/

        /*
        Map<String,Object> cardParameter = new HashMap<String,Object>();
        Customer a = Customer.retrieve("cus_FDrQZLQPbZcHLp");
        cardParameter.put("number","4242424242424242");
        cardParameter.put("exp_month","11");
        cardParameter.put("exp_year","2022");
        cardParameter.put("cvc","123");

        Map<String,Object> tokenParameter = new HashMap<String,Object>();
        tokenParameter.put("card",cardParameter);

        Token token = Token.create(tokenParameter);

        Map<String,Object> source = new HashMap<String,Object>();
        source.put("source",token.getId());

        a.getSources().create(source);*/
    }
}
