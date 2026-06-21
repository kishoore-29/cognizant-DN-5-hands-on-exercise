package builder_pattern_3;

public class BuilderPatternExample {
    public static void main(String[] args) {
        System.out.println("--- PC Build Shop Initialized ---\n");
        Computer officeComputer = new Computer.Builder("Intel Core i3", "8GB")
                .setStorage("256GB SSD")
                .build();

        System.out.println("Basic Office PC:");
        System.out.println(officeComputer);
        System.out.println();
        Computer gamingComputer = new Computer.Builder("AMD Ryzen 9", "32GB")
                .setStorage("2TB NVMe SSD")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();
        System.out.println("High-End Gaming PC:");
        System.out.println(gamingComputer);
    }
}