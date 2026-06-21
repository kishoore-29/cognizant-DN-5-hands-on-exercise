package observer_pattern_7;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockSymbol;
    private double price;

    public StockMarket(String stockSymbol) {
        this.observers = new ArrayList<>();
        this.stockSymbol = stockSymbol;
    }

    // When the price changes, we update our internal state and notify everyone
    public void setPrice(double price) {
        this.price = price;
        System.out.println("\n[MARKET UPDATE] " + stockSymbol + " price changed to $" + price);
        notifyObservers();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
        System.out.println("A new observer has been registered.");
    }

    @Override
    public void deregister(Observer o) {
        observers.remove(o);
        System.out.println("An observer has been deregistered.");
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, price);
        }
    }
}