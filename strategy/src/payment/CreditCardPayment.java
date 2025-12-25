package payment;

public class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        // Logic to process credit card payment
        System.out.println("Paid " + amount + " using Credit Card.");
    }
    
}
