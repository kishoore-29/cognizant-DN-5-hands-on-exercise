package proxy_pattern_6;

public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        // Lazy Initialization and Caching:
        // We only create the RealImage if it doesn't exist yet.
        if (realImage == null) {
            realImage = new RealImage(filename);
        }

        // Delegate the actual display work to the RealImage
        realImage.display();
    }
}