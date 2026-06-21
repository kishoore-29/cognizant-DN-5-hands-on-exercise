package observer_pattern_7;

public interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}
