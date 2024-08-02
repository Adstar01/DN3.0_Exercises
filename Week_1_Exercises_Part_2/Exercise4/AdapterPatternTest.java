package Week_1_Exercises_Part_2.Exercise4;

public class AdapterPatternTest {
    public static void main(String[] args) {
        PayPalPaymentGateway payPalGateway = new PayPalPaymentGateway();
        PaymentProcessor payPalAdapter = new PayPalPaymentAdapter(payPalGateway);
        payPalAdapter.processPayment(100.0);

        StripePaymentGateway stripeGateway = new StripePaymentGateway();
        PaymentProcessor stripeAdapter = new StripePaymentAdapter(stripeGateway);
        stripeAdapter.processPayment(200.0);
    }
}

