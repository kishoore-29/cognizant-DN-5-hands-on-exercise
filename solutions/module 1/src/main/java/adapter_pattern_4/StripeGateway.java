package adapter_pattern_4;

public class StripeGateway {
    // Stripe expects a double, a currency code, and uses the method "charge"
    public void charge(double amount, String currency) {
        System.out.println("Charging " + amount + " " + currency + " via Stripe.");
    }
}