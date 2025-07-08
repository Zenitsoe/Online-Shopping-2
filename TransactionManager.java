import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransactionManager {
    private Map<String, Set<Product>> transactions = new HashMap<>();

    public void addPurchase(String customerName, Product product) {
        transactions.computeIfAbsent(customerName, k -> new HashSet<>()).add(product);
    }

    public Set<Product> getCustomerPurchases(String customerName) {
        return transactions.getOrDefault(customerName, new HashSet<>());
    }
    
    public Map<String, Set<Product>> getAllTransactions() {
        return transactions;
    }
}
