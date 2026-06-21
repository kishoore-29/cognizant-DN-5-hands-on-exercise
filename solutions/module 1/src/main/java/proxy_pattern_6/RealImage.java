package proxy_pattern_6;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer(filename);
    }

    private void loadFromRemoteServer(String filename) {
        System.out.println("Downloading [" + filename + "] from remote server... (This takes time)");
        // In a real application, network/thread sleeping logic would go here
    }

    @Override
    public void display() {
        System.out.println("Rendering " + filename + " on screen.");
    }
}