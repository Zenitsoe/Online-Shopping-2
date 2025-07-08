public class MainApp {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        // Menambahkan produk ke ProductManager
        productManager.addProduct(new Electronics("Laptop ASUS ROG", 1200.00, 201, 24, 2.5, "ASUS"));
        productManager.addProduct(new Clothing("Kemeja Flanel", 35.75, 305, Size.M));
        productManager.addProduct(new Electronics("Smartphone Samsung", 800.00, 202, 12, 0.2, "Samsung"));
        productManager.addProduct(new Clothing("Celana Jeans", 50.00, 306, Size.L));

        TransactionManager transactionManager = new TransactionManager();

        // Melakukan pembelian oleh beberapa pelanggan
        try {
            transactionManager.addPurchase("Alice", productManager.findProductById(201));
            transactionManager.addPurchase("Alice", productManager.findProductById(306));
            transactionManager.addPurchase("Bob", productManager.findProductById(305));
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Menampilkan semua pembelian pelanggan
        System.out.println("--- Semua Transaksi Pelanggan ---");
        transactionManager.getAllTransactions().forEach((customer, products) -> {
            System.out.println("Pelanggan: " + customer);
            products.forEach(product -> System.out.println("  - " + product.getInfo()));
        });
        System.out.println();

        // Menangani pencarian produk dengan try-catch
        System.out.println("--- Pencarian Produk ---");
        try {
            System.out.println("Mencari produk dengan ID 202:");
            Product foundProduct = productManager.findProductById(202);
            System.out.println("Produk ditemukan: " + foundProduct.getInfo());
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nMencari produk dengan ID 999:");
            Product notFoundProduct = productManager.findProductById(999);
            System.out.println("Produk ditemukan: " + notFoundProduct.getInfo());
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
