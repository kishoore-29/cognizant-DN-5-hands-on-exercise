package adapter_pattern_4;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Translate the double amount into the String format PayPal expects
        String amountString = String.valueOf(amount);
        payPalGateway.makePayment(amountString);
    }
}