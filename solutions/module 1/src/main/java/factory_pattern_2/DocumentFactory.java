package factory_pattern_2;

public abstract class DocumentFactory {
    public abstract Document createDocument();
    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
    }
}
