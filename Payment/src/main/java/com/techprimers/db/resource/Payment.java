package com.techprimers.db.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.techprimers.db.service.StripeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.CustomMetric;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

//@RequestMapping(value = "/rest/payment")
public class Payment {
    public static void main(String[] args) throws StripeException {
        Stripe.apiKey="sk_test_pX7KwrP5dO6a07OZZnwsnC9800uGwzZjkY";
        Customer c= Customer.retrieve("cus_FDqWz3wte0a86R");

        Map<String,Object> chargeParams = new HashMap<String,Object>();
        chargeParams.put("amount","10000");
        chargeParams.put("currency","usd");
        chargeParams.put("customer",c.getId());

        Charge.create(chargeParams);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
    }
    /*@Value("${stripe.keys.public}")
    private String API_PUBLIC_KEY;

    private StripeService stripeService;

    public Payment(StripeService stripeService){
        this.stripeService=stripeService;
    }

    @PostMapping(value="/createCharge/{amount}")
    public @ResponseBody
    ResponseEntity<?> createCharge(String email, String token, @PathVariable Integer amount){
        if(token==null){
            Map<String,Object> message = new HashMap<String,Object>();
            message.put("MESSAGE","ne mere halali");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        String chargeId=stripeService.createCharge(email,token,amount);
        if(chargeId==null){
            Map<String,Object> message = new HashMap<String,Object>();
            message.put("MESSAGE","ne mere halali");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        Map<String,Object> message = new HashMap<String,Object>();
        message.put("MESSAGE","PROSLO AM DALJE");
        return new ResponseEntity<>(message,HttpStatus.OK);

    }*/
}


