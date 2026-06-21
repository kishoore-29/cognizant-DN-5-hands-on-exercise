package decorator_pattern_5;

public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    // The constructor takes the Notifier we want to wrap/decorate
    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        // Delegate the core behavior to the wrapped object
        wrappedNotifier.send(message);
    }
}
