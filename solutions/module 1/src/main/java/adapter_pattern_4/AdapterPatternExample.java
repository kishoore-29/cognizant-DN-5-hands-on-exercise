package adapter_pattern_4;

public class AdapterPatternExample {
    public static void main(String[] args) {
        System.out.println("--- E-Commerce Checkout Initialized ---\n");
        PayPalGateway payPalAPI = new PayPalGateway();
        StripeGateway stripeAPI = new StripeGateway();

        // Wrap them in our Adapters
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalAPI);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeAPI);

        // Process payments uniformly
        System.out.println("Customer 1 is paying with PayPal...");
        payPalProcessor.processPayment(150.00);

        System.out.println("\nCustomer 2 is paying with Stripe...");
        stripeProcessor.processPayment(299.99);
    }
}