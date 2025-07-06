import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransactionManager {
    private Map<String, Set<Product>> transactions;
    
    public TransactionManager() {
        this.transactions = new HashMap<>();
    }
    
    public void addPurchase(String customerName, Product product) {

        if (!transactions.containsKey(customerName)) {
            transactions.put(customerName, new HashSet<>());
        }
        
        Set<Product> customerProducts = transactions.get(customerName);
        boolean added = customerProducts.add(product);
        
        if (added) {
            System.out.println("Pembelian berhasil! " + customerName + " membeli " + product.getName());
        } else {
            System.out.println("Produk " + product.getName() + " sudah ada dalam keranjang " + customerName);
        }
    }
    
    public Set<Product> getCustomerPurchases(String customerName) {
        return transactions.getOrDefault(customerName, new HashSet<>());
    }

    public void displayCustomerPurchases(String customerName) {
        Set<Product> purchases = getCustomerPurchases(customerName);
        
        System.out.println("=== PEMBELIAN " + customerName.toUpperCase() + " ===");
        if (purchases.isEmpty()) {
            System.out.println("Belum ada pembelian untuk pelanggan ini.");
        } else {
            double totalSpent = 0;
            for (Product product : purchases) {
                System.out.println("- " + product.getInfo());
                totalSpent += product.getPrice();
            }
            System.out.println("Total Pembelian: €" + String.format("%.2f", totalSpent));
        }
        System.out.println();
    }
    
    public void displayAllTransactions() {
        System.out.println("=== SEMUA TRANSAKSI ===");
        if (transactions.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (Map.Entry<String, Set<Product>> entry : transactions.entrySet()) {
                String customerName = entry.getKey();
                Set<Product> products = entry.getValue();
                
                System.out.println("Pelanggan: " + customerName);
                System.out.println("Jumlah Produk: " + products.size());
                
                double totalSpent = 0;
                for (Product product : products) {
                    totalSpent += product.getPrice();
                }
                System.out.println("Total Belanja: €" + String.format("%.2f", totalSpent));
                System.out.println("---");
            }
        }
        System.out.println();
    }
    

    public int getTotalCustomers() {
        return transactions.size();
    }
    
    public int getTotalProductsSold() {
        int total = 0;
        for (Set<Product> products : transactions.values()) {
            total += products.size();
        }
        return total;
    }
}
