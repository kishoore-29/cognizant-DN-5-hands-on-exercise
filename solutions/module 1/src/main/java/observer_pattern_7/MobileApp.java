package observer_pattern_7;

public class MobileApp implements Observer {
    private String deviceName;

    public MobileApp(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println(" -> MobileApp (" + deviceName + ") Alert: " + stockSymbol + " is now $" + price);
    }
}