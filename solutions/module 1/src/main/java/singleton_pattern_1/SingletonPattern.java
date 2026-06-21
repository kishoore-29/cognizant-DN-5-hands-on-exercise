package singleton_pattern_1;

public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("User successfully logged in.");
        logger2.log("Database connection established.");
        System.out.println("\n--- Verification ---");
        if (logger1 == logger2) {
            System.out.println("SUCCESS: logger1 and logger2 are the exact same instance!");
        } else {
            System.out.println("FAILURE: Multiple instances of Logger were created.");
        }
    }
}
