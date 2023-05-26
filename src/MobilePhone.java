public class MobilePhone extends Product{
    private int memory;
    private int batteryPower;
    private String color;


    public MobilePhone(int discountRate, int amountStoke, String name,
                       Brand brand, int ram, double screenSize, int unitPrice,
                       int memory, int batteryPower, String color) {
        super(discountRate, amountStoke, name, brand, ram, screenSize, unitPrice);
        this.memory=memory;
        this.batteryPower=batteryPower;
        this.color=color;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
