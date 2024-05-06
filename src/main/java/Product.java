public class Product {
    private int id;
    private static int sharedID = 1;
    private String name;
    private Size size;
    private double price;
    private int inventory;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Product(String name, Size size, double price, int inventory){
        this.name = name;
        this.size = size;
        this.price = price;
        this.inventory = inventory;
        this.id = sharedID++;

    }
}
