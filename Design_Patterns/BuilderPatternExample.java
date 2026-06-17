public class BuilderPatternExample {

    public static void main(String[] args) {

        Computer gamingPC =
                new Computer.Builder()
                        .setCPU("Intel i9")
                        .setRAM("32GB")
                        .setStorage("2TB SSD")
                        .setGraphicsCard(true)
                        .setBluetooth(true)
                        .setWifi(true)
                        .build();

        Computer officePC =
                new Computer.Builder()
                        .setCPU("Intel i5")
                        .setRAM("8GB")
                        .setStorage("512GB SSD")
                        .build();

        System.out.println("Gaming PC");
        gamingPC.display();

        System.out.println();

        System.out.println("Office PC");
        officePC.display();
    }
}

/* =========================
   PRODUCT CLASS
   ========================= */

class Computer {

    private String cpu;
    private String ram;
    private String storage;
    private boolean graphicsCard;
    private boolean bluetooth;
    private boolean wifi;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.bluetooth = builder.bluetooth;
        this.wifi = builder.wifi;
    }

    public void display() {

        System.out.println("CPU : " + cpu);
        System.out.println("RAM : " + ram);
        System.out.println("Storage : " + storage);
        System.out.println("Graphics Card : " + graphicsCard);
        System.out.println("Bluetooth : " + bluetooth);
        System.out.println("WiFi : " + wifi);
    }

    /* =========================
       BUILDER CLASS
       ========================= */

    public static class Builder {

        private String cpu;
        private String ram;
        private String storage;
        private boolean graphicsCard;
        private boolean bluetooth;
        private boolean wifi;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(boolean graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public Builder setWifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
