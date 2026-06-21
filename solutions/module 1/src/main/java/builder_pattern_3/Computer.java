package builder_pattern_3;

public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public boolean isGraphicsCardEnabled() { return isGraphicsCardEnabled; }
    public boolean isBluetoothEnabled() { return isBluetoothEnabled; }
    @Override
    public String toString() {
        return "Computer [CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage
                + ", GraphicsCard=" + isGraphicsCardEnabled + ", Bluetooth=" + isBluetoothEnabled + "]";
    }
    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;
        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }
        public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }
        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }
}