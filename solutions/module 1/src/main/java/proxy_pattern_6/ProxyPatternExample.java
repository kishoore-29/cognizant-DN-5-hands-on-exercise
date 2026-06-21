package proxy_pattern_6;

public class ProxyPatternExample {
    public static void main(String[] args) {
        System.out.println("--- Image Viewer Application Initialized ---\n");

        // The image object is created, but no network call is made yet.
        Image image1 = new ProxyImage("high_res_sunset.png");

        System.out.println("User is scrolling through the gallery...");
        System.out.println("User clicked on 'high_res_sunset.png'.");

        // The first time display is called, it must download from the server.
        System.out.println("\n--- First Call ---");
        image1.display();

        System.out.println("\nUser navigated away, and then clicked the image again.");

        // The second time, the proxy uses the cached RealImage. No download occurs.
        System.out.println("\n--- Second Call ---");
        image1.display();
    }
}