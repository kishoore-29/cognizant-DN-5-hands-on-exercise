package observer_pattern_7;

public class WebApp implements Observer {
    private String browserName;

    public WebApp(String browserName) {
        this.browserName = browserName;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println(" -> WebApp (" + browserName + ") Dashboard Updated: " + stockSymbol + " is now $" + price);
    }
}