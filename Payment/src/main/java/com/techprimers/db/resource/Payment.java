package com.techprimers.db.resource;

import com.techprimers.db.service.StripeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/rest/payment")
public class Payment {
    @Value("${stripe.keys.public}")
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

    }
}

