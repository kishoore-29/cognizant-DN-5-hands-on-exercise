package factory_pattern_2;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document in read-only mode...");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document. Compressing assets...");
    }
}