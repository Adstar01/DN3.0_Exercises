package Week_1_Exercises_Part_2.Exercise4;

public class PayPalPaymentAdapter implements PaymentProcessor {
    private PayPalPaymentGateway payPalPaymentGateway;

    public PayPalPaymentAdapter(PayPalPaymentGateway payPalPaymentGateway) {
        this.payPalPaymentGateway = payPalPaymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalPaymentGateway.makePayment(amount);
    }
}
