public class Notebook extends Product{
    private int storage;

    public Notebook(int discountRate, int amountStoke, String name,
                    Brand brand, int ram, double screenSize, int unitPrice, int storage) {
        super(discountRate, amountStoke, name, brand, ram, screenSize, unitPrice);
        this.storage=storage;
    }

    public void addProduct(){

    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

}
