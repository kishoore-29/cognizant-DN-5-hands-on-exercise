package decorator_pattern_5;

public class DecoratorPatternExample {
    public static void main(String[] args) {
        System.out.println("--- Notification System Initialized ---\n");

        String alertMessage = "CRITICAL: Server CPU at 99%!";


        System.out.println("Scenario 1: Standard Alert");
        Notifier standardNotifier = new EmailNotifier();
        standardNotifier.send(alertMessage);

        System.out.println("\n-----------------------------------\n");
        System.out.println("Scenario 2: Urgent Alert");
        Notifier urgentNotifier = new SMSNotifierDecorator(new EmailNotifier());
        urgentNotifier.send(alertMessage);

        System.out.println("\n-----------------------------------\n");

        // 3. System Meltdown Notification (Email + SMS + Slack)
        // We can stack as many wrappers as we want!
        System.out.println("Scenario 3: System Meltdown Alert");
        Notifier panicNotifier = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier()
                )
        );
        panicNotifier.send(alertMessage);
    }
}