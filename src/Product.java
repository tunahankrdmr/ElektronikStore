import java.util.List;

public class  Product {
    private static int secondID=1;
    private int id;
    private int discountRate;
    private int amountStoke;
    private String name;
    private Brand brand;
    private int ram;
    private double screenSize;
    private int unitPrice;

    public Product(int discountRate, int amountStoke, String name, Brand brand, int ram, double screenSize, int unitPrice) {
        this.id = secondID;
        secondID++;
        this.discountRate = discountRate;
        this.amountStoke = amountStoke;
        this.name = name;
        this.brand = brand;
        this.ram = ram;
        this.screenSize = screenSize;
        this.unitPrice=unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getAmountStoke() {
        return amountStoke;
    }

    public void setAmountStoke(int amountStoke) {
        this.amountStoke = amountStoke;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
