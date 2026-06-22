package command_pattern_9;

public class CommandPatternExample {
    public static void main(String[] args) {
        System.out.println("--- Home Automation System Initialized ---\n");

        // 1. Create the Receiver
        Light livingRoomLight = new Light();

        // 2. Create the Commands (passing the receiver to them)
        Command turnOn = new LightOnCommand(livingRoomLight);
        Command turnOff = new LightOffCommand(livingRoomLight);

        // 3. Create the Invoker
        RemoteControl remote = new RemoteControl();

        // 4. Test turning the light ON
        System.out.println("Programming remote to turn light ON...");
        remote.setCommand(turnOn);
        remote.pressButton();

        System.out.println("\nProgramming remote to turn light OFF...");
        // 5. Test turning the light OFF
        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
