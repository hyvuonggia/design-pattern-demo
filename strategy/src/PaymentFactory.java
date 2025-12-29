import java.util.HashMap;
import java.util.Map;
import payment.CashPayment;
import payment.CreditCardPayment;
import payment.Payment;
import payment.PaypalPayment;

public class PaymentFactory {

    static final Map<String, Payment> paymentMethods = new HashMap<>();
    
    static {

        paymentMethods.put("creditcard", new CreditCardPayment());
        paymentMethods.put("paypal", new PaypalPayment());
        paymentMethods.put("cash", new CashPayment());

    }

    public static Payment createPaymentMethod(String type) {
        return paymentMethods.get(type.toLowerCase());
    }

}
