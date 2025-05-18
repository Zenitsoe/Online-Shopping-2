import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Product {
    private String name;
    private double price;
    private int productID;
    private LocalDateTime createdAt;

    public Product(String name, double price, int productID) {
        this.name = name;
        this.price = price;
        this.productID = productID;
        this.createdAt = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return name + " - " + String.format("€%.2f", price) + " (Dibuat pada: " + createdAt.format(formatter) + ")";
    }

    public abstract String getCategory();
}
