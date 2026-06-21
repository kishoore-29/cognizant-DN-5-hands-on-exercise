package observer_pattern_7;

public interface Observer {
    // The method called by the Subject when a change occurs
    void update(String stockSymbol, double price);
}