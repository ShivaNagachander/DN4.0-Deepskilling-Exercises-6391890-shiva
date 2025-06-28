interface PaymentProcessor {
    void processPayment();
}

class PayPal {
    void payViaPayPal() { System.out.println("Paid using PayPal."); }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal = new PayPal();

    public void processPayment() {
        payPal.payViaPayPal();
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PayPalAdapter();
        processor.processPayment();
    }
}
