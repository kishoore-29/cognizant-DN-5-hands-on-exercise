package strategy_pattern_8;

public class StrategyPatternExample {
    public static void main(String[] args) {
        System.out.println("--- E-Commerce Checkout Initialized ---\n");

        double cartTotal = 250.50;

        // 1. User selects Credit Card
        System.out.println("User selected Credit Card for payment.");
        PaymentStrategy creditCard = new CreditCardPayment("Jane Doe", "1234567890128888");
        PaymentContext checkout = new PaymentContext(creditCard);

        // Execute the payment
        checkout.executePayment(cartTotal);

        System.out.println("\n-----------------------------------\n");

        // 2. User changes their mind and selects PayPal instead
        System.out.println("User switched payment method to PayPal.");
        PaymentStrategy payPal = new PayPalPayment("jane.doe@example.com");

        // We swap the strategy dynamically at runtime!
        checkout.setPaymentStrategy(payPal);

        // Execute the payment again
        checkout.executePayment(cartTotal);
    }
}
