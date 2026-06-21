package decorator_pattern_5;

public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        // First, let the wrapped object do its job
        super.send(message);
        // Then, add the new behavior
        System.out.println("Sending Slack message: " + message);
    }
}
