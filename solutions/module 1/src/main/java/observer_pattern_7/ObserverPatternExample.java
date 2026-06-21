package observer_pattern_7;

public class ObserverPatternExample {
    public static void main(String[] args) {
        System.out.println("--- Stock Market Monitoring System Initialized ---\n");

        // Create the subject
        StockMarket appleStock = new StockMarket("AAPL");

        // Create the observers
        Observer user1Mobile = new MobileApp("iPhone 14");
        Observer user2Web = new WebApp("Google Chrome");

        // Register the observers to the stock
        appleStock.register(user1Mobile);
        appleStock.register(user2Web);

        // Simulate market changes
        appleStock.setPrice(150.00);
        appleStock.setPrice(152.50);

        // Deregister an observer (User 1 uninstalls the app or turns off notifications)
        System.out.println("\nUser 1 turned off notifications.");
        appleStock.deregister(user1Mobile);

        // Simulate another market change
        appleStock.setPrice(149.99);
    }
}