public class Electronics extends Product implements Discountable {
    private int warrantyMonths;

    // Inner class Specification
    public class Specification {
        private double weight;
        private String brand;

        public Specification(double weight, String brand) {
            this.weight = weight;
            this.brand = brand;
        }

        public double getWeight() {
            return weight;
        }

        public String getBrand() {
            return brand;
        }

        public String getSpecs() {
            return "Berat: " + weight + " kg, Merek: " + brand;
        }
    }

    private Specification specification;

    public Electronics(String name, double price, int productID, int warrantyMonths, double weight, String brand) {
        super(name, price, productID);
        this.warrantyMonths = warrantyMonths;
        this.specification = new Specification(weight, brand);
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public Specification getSpecification() {
        return specification;
    }

    @Override
    public String getCategory() {
        return "Elektronik";
    }

    @Override
    public double getDiscountedPrice(double discountPercentage) {
        return getPrice() * (1 - (discountPercentage / 100));
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Kategori: " + getCategory() + ", Garansi: " + warrantyMonths + " bulan, " + specification.getSpecs();
    }
}
