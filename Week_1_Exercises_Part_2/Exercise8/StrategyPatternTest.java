package Week_1_Exercises_Part_2.Exercise8;

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCard = new CreditCardPayment("John Doe", "1234567890123456", "123", "12/23");
        context.setPaymentStrategy(creditCard);
        context.pay(250.75);
        System.out.println("");

        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com", "password");
        context.setPaymentStrategy(payPal);
        context.pay(89.99);
    }
}
