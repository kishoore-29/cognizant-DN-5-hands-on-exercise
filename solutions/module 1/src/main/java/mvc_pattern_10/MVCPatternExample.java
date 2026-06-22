package mvc_pattern_10;

public class MVCPatternExample {
    public static void main(String[] args) {
        System.out.println("--- Student Management System Initialized ---\n");

        // 1. Fetch student record based on his ID from the database (Simulated)
        Student studentModel = retrieveStudentFromDatabase();

        // 2. Create a view to write student details on console
        StudentView studentView = new StudentView();

        // 3. Create the controller, passing in the model and the view
        StudentController controller = new StudentController(studentModel, studentView);

        // 4. Display the initial data
        System.out.println("Initial Record:");
        controller.updateView();

        // 5. Update the model data using the controller
        System.out.println("Updating student's grade...\n");
        controller.setStudentGrade("A+");

        // 6. Display the updated data
        System.out.println("Updated Record:");
        controller.updateView();
    }

    // A simple mock method to simulate fetching data from a database
    private static Student retrieveStudentFromDatabase() {
        return new Student("S101", "John Doe", "B");
    }
}