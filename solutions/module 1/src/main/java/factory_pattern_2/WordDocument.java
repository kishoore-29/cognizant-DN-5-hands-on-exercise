package factory_pattern_2;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document. Ready for text editing...");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document with .docx extension.");
    }
}