import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        for (Product p : products) {
            if (p.getProductID() == product.getProductID()) {
                System.out.println("Error: Produk dengan ID " + product.getProductID() + " sudah ada.");
                return;
            }
        }
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public Product findProductById(int id) throws ProductNotFoundException {
        for (Product p : products) {
            if (p.getProductID() == id) {
                return p;
            }
        }
        throw new ProductNotFoundException("Produk dengan ID " + id + " tidak ditemukan.");
    }
}
