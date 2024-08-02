package Week_1_Exercises_Part_2.Exercise3;

public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder()
            .setCPU("Intel i5")
            .setRAM("8GB")
            .setStorage("256GB SSD")
            .build();

        System.out.println("Basic Computer Configuration:");
        System.out.println("CPU: " + basicComputer.getCPU());
        System.out.println("RAM: " + basicComputer.getRAM());
        System.out.println("Storage: " + basicComputer.getStorage());

        Computer highEndComputer = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 3080")
            .setPowerSupply("850W")
            .setMotherboard("Asus ROG")
            .build();

        System.out.println("\nHigh-End Computer Configuration:");
        System.out.println("CPU: " + highEndComputer.getCPU());
        System.out.println("RAM: " + highEndComputer.getRAM());
        System.out.println("Storage: " + highEndComputer.getStorage());
        System.out.println("Graphics Card: " + highEndComputer.getGraphicsCard());
        System.out.println("Power Supply: " + highEndComputer.getPowerSupply());
        System.out.println("Motherboard: " + highEndComputer.getMotherboard());
    }
}

