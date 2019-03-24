package ctrl;

import servisi.StripeClient;
import com.stripe.model.Charge;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentCtrl {

	    private servisi.StripeClient stripeClient;

	    @Autowired
	    PaymentCtrl(StripeClient stripeClient) {
	        this.stripeClient = stripeClient;
	    }

	    @PostMapping("/charge")
	    public Charge chargeCard(HttpServletRequest request) throws Exception {
	        String token = request.getHeader("token");
	        Double amount = Double.parseDouble(request.getHeader("amount"));
	        return this.stripeClient.chargeNewCard(token, amount);
	    }
}
