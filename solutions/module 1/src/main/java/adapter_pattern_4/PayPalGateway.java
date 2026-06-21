package adapter_pattern_4;

public class PayPalGateway {
    // PayPal expects a String and uses the method "makePayment"
    public void makePayment(String amountInDollars) {
        System.out.println("Processing $" + amountInDollars + " via PayPal.");
    }
}