package Task_ms;

public class TaskManager {

    // Inner class to represent a Node in the linked list
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head; // Points to the first node in the list

    public TaskManager() {
        this.head = null;
    }

    // Add a task to the end of the list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode; // List is empty, new node becomes the head
            System.out.println("Added task: " + task.getTaskName());
            return;
        }

        // Traverse to the very end of the list
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode; // Link the last node to the new node
        System.out.println("Added task: " + task.getTaskName());
    }

    // Search for a task by its ID
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task; // Found the task
            }
            current = current.next; // Move to the next node
        }
        return null; // Task not found
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        System.out.println("--- Task List ---");
        Node current = head;
        while (current != null) {
            System.out.println(current.task.toString());
            current = current.next;
        }
    }

    // Delete a task by its ID
    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Task list is empty, nothing to delete.");
            return;
        }

        // Case 1: The task to delete is the head
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next; // Bypass the head
            System.out.println("Task " + taskId + " deleted successfully.");
            return;
        }

        // Case 2: The task is somewhere in the middle or end
        Node current = head;
        // Look ahead to the next node so we can bypass it if it matches
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next; // Bypass the target node
            System.out.println("Task " + taskId + " deleted successfully.");
        } else {
            System.out.println("Task " + taskId + " not found.");
        }
    }

    // Example Usage
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task("T01", "Design Database", "In Progress"));
        manager.addTask(new Task("T02", "Write API", "Pending"));
        manager.addTask(new Task("T03", "Test Frontend", "Not Started"));

        manager.traverseTasks();

        System.out.println("\nSearching for T02:");
        System.out.println(manager.searchTask("T02"));

        System.out.println("\nDeleting T02...");
        manager.deleteTask("T02");

        manager.traverseTasks();
    }
}