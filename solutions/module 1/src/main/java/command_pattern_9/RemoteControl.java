package command_pattern_9;

public class RemoteControl {
    private Command command;

    // Set the command we want the remote to execute
    public void setCommand(Command command) {
        this.command = command;
    }

    // Press the button on the remote
    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command assigned to this button.");
        }
    }
}