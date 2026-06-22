package strategy_pattern_8;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // We can set the strategy via the constructor...
    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // ...or we can change it dynamically at runtime using a setter!
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // The context delegates the actual work to the active strategy
    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}
