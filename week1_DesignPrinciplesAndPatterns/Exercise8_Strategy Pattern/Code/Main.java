interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid " + amount + " via Credit Card."); }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid " + amount + " via PayPal."); }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void payAmount(int amount) {
        strategy.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment());
        context.payAmount(100);
    }
}
