package decorator_pattern_5;

public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        // First, let the wrapped object do its job
        super.send(message);
        // Then, add the new behavior
        System.out.println("Sending SMS: " + message);
    }
}