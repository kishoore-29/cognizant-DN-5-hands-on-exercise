package factory_pattern_2;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document. Loading spreadsheets...");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document with .xlsx extension.");
    }
}