import payment.Payment;

public class Order {
    
    int amount;
    Payment paymentMethod;


    public Order(int amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processOrder() {
        paymentMethod.pay(amount);
    }

    
}