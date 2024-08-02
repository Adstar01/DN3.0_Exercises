package Week_1_Exercises_Part_2.Exercise4;

public class StripePaymentAdapter implements PaymentProcessor {
    private StripePaymentGateway stripePaymentGateway;

    public StripePaymentAdapter(StripePaymentGateway stripePaymentGateway) {
        this.stripePaymentGateway = stripePaymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripePaymentGateway.pay(amount);
    }
}
