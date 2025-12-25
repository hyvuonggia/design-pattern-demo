
import payment.CashPayment;
import payment.CreditCardPayment;

public class App {
    public static void main(String[] args) throws Exception {
        Order order = new Order(100);

        // Set payment method to Credit Card
        order.setPaymentMethod(new CreditCardPayment());
        order.processOrder();

        System.out.println("Switching payment method...");

        // Set payment method to Cash
        order.setPaymentMethod(new CashPayment());
        order.processOrder();

    }
}
