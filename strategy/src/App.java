import payment.Payment;


public class App {
    public static void main(String[] args) throws Exception {
        Order order = new Order(100);


        Payment creditCardPayment = PaymentFactory.createPaymentMethod("creditcard");
        order.setPaymentMethod(creditCardPayment);
        order.processOrder();

        System.out.println("Switching payment method...");


        // Set payment method to Cash using PaymentFactory
        Payment cashPayment = PaymentFactory.createPaymentMethod("cash");
        order.setPaymentMethod(cashPayment);
        order.processOrder();

    }
}
