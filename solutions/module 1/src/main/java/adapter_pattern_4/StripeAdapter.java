package adapter_pattern_4;

public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Translate the call by providing the extra "currency" parameter Stripe expects
        stripeGateway.charge(amount, "USD");
    }
}