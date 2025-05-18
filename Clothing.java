public class Clothing extends Product implements Discountable {
    private Size size;

    public Clothing(String name, double price, int productID, Size size) {
        super(name, price, productID);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String getCategory() {
        return "Pakaian";
    }

    @Override
    public double getDiscountedPrice(double discountPercentage) {
        return getPrice() * (1 - (discountPercentage / 100));
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Kategori: " + getCategory() + ", Ukuran: " + size;
    }
}
