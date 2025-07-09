import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;

public class OnlineShopGUI extends JFrame {
    private ProductManager productManager;
    private TransactionManager transactionManager;
    
    // Components
    private JTabbedPane tabbedPane;
    private JTable productTable;
    private JTable transactionTable;
    private DefaultTableModel productTableModel;
    private DefaultTableModel transactionTableModel;
    
    // Product form components
    private JTextField nameField;
    private JTextField priceField;
    private JTextField idField;
    private JComboBox categoryCombo;
    private JComboBox sizeCombo;
    private JTextField warrantyField;
    private JTextField weightField;
    private JTextField brandField;
    
    // Transaction components
    private JTextField customerNameField;
    private JTextField productIdField;
    private JTextField searchIdField;
    private JTextArea resultArea;
    
    public OnlineShopGUI() {
        productManager = new ProductManager();
        transactionManager = new TransactionManager();
        
        initializeComponents();
        setupLayout();
        loadSampleData();
        refreshProductTable();
        
        setTitle("Online Shop Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
    }
    
    private void initializeComponents() {
        tabbedPane = new JTabbedPane();
        
        // Product table
        String[] productColumns = {"ID", "Name", "Price", "Category", "Details"};
        productTableModel = new DefaultTableModel(productColumns, 0);
        productTable = new JTable(productTableModel);
        
        // Transaction table
        String[] transactionColumns = {"Customer", "Product ID", "Product Name", "Price", "Category"};
        transactionTableModel = new DefaultTableModel(transactionColumns, 0);
        transactionTable = new JTable(transactionTableModel);
        
        // Form components
        nameField = new JTextField(20);
        priceField = new JTextField(20);
        idField = new JTextField(20);
        categoryCombo = new JComboBox(new String[]{"Electronics", "Clothing"});
        sizeCombo = new JComboBox(Size.values());
        warrantyField = new JTextField(20);
        weightField = new JTextField(20);
        brandField = new JTextField(20);
        
        customerNameField = new JTextField(20);
        productIdField = new JTextField(20);
        searchIdField = new JTextField(20);
        resultArea = new JTextArea(20, 60);
        resultArea.setEditable(false);
        
        // Add listeners
        categoryCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleFormFields();
            }
        });
        
        toggleFormFields(); // Initial setup
    }
    
    private void setupLayout() {
        // Product Management Panel
        JPanel productPanel = createProductPanel();
        tabbedPane.addTab("Product Management", productPanel);
        
        // Transaction Panel
        JPanel transactionPanel = createTransactionPanel();
        tabbedPane.addTab("Transactions", transactionPanel);
        
        // Search Panel
        JPanel searchPanel = createSearchPanel();
        tabbedPane.addTab("Search", searchPanel);
        
        add(tabbedPane);
    }
    
    private JPanel createProductPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(9, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add New Product"));
        
        formPanel.add(new JLabel("Product ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Price:"));
        formPanel.add(priceField);
        formPanel.add(new JLabel("Category:"));
        formPanel.add(categoryCombo);
        formPanel.add(new JLabel("Size:"));
        formPanel.add(sizeCombo);
        formPanel.add(new JLabel("Warranty (months):"));
        formPanel.add(warrantyField);
        formPanel.add(new JLabel("Weight (kg):"));
        formPanel.add(weightField);
        formPanel.add(new JLabel("Brand:"));
        formPanel.add(brandField);
        
        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Product");
        JButton clearButton = new JButton("Clear");
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });
        
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
        
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        formPanel.add(buttonPanel);
        
        // Table Panel
        JScrollPane tableScrollPane = new JScrollPane(productTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Product List"));
        
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(tableScrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createTransactionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Transaction form
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add Transaction"));
        
        formPanel.add(new JLabel("Customer Name:"));
        formPanel.add(customerNameField);
        formPanel.add(new JLabel("Product ID:"));
        formPanel.add(productIdField);
        
        JButton addTransactionButton = new JButton("Add Transaction");
        addTransactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTransaction();
            }
        });
        
        formPanel.add(addTransactionButton);
        
        // Transaction table
        JScrollPane transactionScrollPane = new JScrollPane(transactionTable);
        transactionScrollPane.setBorder(BorderFactory.createTitledBorder("Transaction History"));
        
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(transactionScrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createSearchPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Search form
        JPanel searchForm = new JPanel(new FlowLayout());
        searchForm.setBorder(BorderFactory.createTitledBorder("Search Product"));
        
        searchForm.add(new JLabel("Product ID:"));
        searchForm.add(searchIdField);
        
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchProduct();
            }
        });
        searchForm.add(searchButton);
        
        // Result area
        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        resultScrollPane.setBorder(BorderFactory.createTitledBorder("Search Results"));
        
        panel.add(searchForm, BorderLayout.NORTH);
        panel.add(resultScrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void toggleFormFields() {
        boolean isElectronics = "Electronics".equals(categoryCombo.getSelectedItem());
        
        sizeCombo.setEnabled(!isElectronics);
        warrantyField.setEnabled(isElectronics);
        weightField.setEnabled(isElectronics);
        brandField.setEnabled(isElectronics);
    }
    
    private void addProduct() {
        try {
            String name = nameField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());
            int id = Integer.parseInt(idField.getText().trim());
            
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter product name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Product product;
            if ("Electronics".equals(categoryCombo.getSelectedItem())) {
                int warranty = Integer.parseInt(warrantyField.getText().trim());
                double weight = Double.parseDouble(weightField.getText().trim());
                String brand = brandField.getText().trim();
                
                if (brand.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter brand for electronics.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                product = new Electronics(name, price, id, warranty, weight, brand);
            } else {
                Size size = (Size) sizeCombo.getSelectedItem();
                product = new Clothing(name, price, id, size);
            }
            
            productManager.addProduct(product);
            refreshProductTable();
            clearForm();
            JOptionPane.showMessageDialog(this, "Product added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearForm() {
        nameField.setText("");
        priceField.setText("");
        idField.setText("");
        categoryCombo.setSelectedIndex(0);
        sizeCombo.setSelectedIndex(0);
        warrantyField.setText("");
        weightField.setText("");
        brandField.setText("");
    }
    
    private void addTransaction() {
        try {
            String customerName = customerNameField.getText().trim();
            int productId = Integer.parseInt(productIdField.getText().trim());
            
            if (customerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter customer name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Product product = productManager.findProductById(productId);
            transactionManager.addPurchase(customerName, product);
            
            customerNameField.setText("");
            productIdField.setText("");
            
            refreshTransactionTable();
            JOptionPane.showMessageDialog(this, "Transaction added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid product ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ProductNotFoundException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void searchProduct() {
        try {
            int id = Integer.parseInt(searchIdField.getText().trim());
            Product product = productManager.findProductById(id);
            resultArea.setText("Product Found:\n" + product.getInfo());
            
            // Show discount calculation if product is discountable
            if (product instanceof Discountable) {
                Discountable discountable = (Discountable) product;
                resultArea.append("\n\nDiscount Calculations:");
                resultArea.append("\n10% discount: €" + String.format("%.2f", discountable.getDiscountedPrice(10)));
                resultArea.append("\n20% discount: €" + String.format("%.2f", discountable.getDiscountedPrice(20)));
                resultArea.append("\n30% discount: €" + String.format("%.2f", discountable.getDiscountedPrice(30)));
            }
        } catch (NumberFormatException ex) {
            resultArea.setText("Error: Please enter a valid product ID.");
        } catch (ProductNotFoundException ex) {
            resultArea.setText("Error: " + ex.getMessage());
        }
    }
    
    private void refreshProductTable() {
        productTableModel.setRowCount(0);
        
        for (Product product : productManager.getAllProducts()) {
            String details = "";
            if (product instanceof Electronics) {
                Electronics electronics = (Electronics) product;
                details = "Warranty: " + electronics.getWarrantyMonths() + " months, " + 
                         electronics.getSpecification().getSpecs();
            } else if (product instanceof Clothing) {
                Clothing clothing = (Clothing) product;
                details = "Size: " + clothing.getSize();
            }
            
            productTableModel.addRow(new Object[]{
                product.getProductID(),
                product.getName(),
                String.format("€%.2f", product.getPrice()),
                product.getCategory(),
                details
            });
        }
    }
    
    private void refreshTransactionTable() {
        transactionTableModel.setRowCount(0);
        
        Map<String, Set<Product>> transactions = transactionManager.getAllTransactions();
        for (Map.Entry<String, Set<Product>> entry : transactions.entrySet()) {
            String customer = entry.getKey();
            for (Product product : entry.getValue()) {
                transactionTableModel.addRow(new Object[]{
                    customer,
                    product.getProductID(),
                    product.getName(),
                    String.format("€%.2f", product.getPrice()),
                    product.getCategory()
                });
            }
        }
    }
    
    private void loadSampleData() {
        // Add sample products
        productManager.addProduct(new Electronics("Laptop ASUS ROG", 1200.00, 201, 24, 2.5, "ASUS"));
        productManager.addProduct(new Clothing("Kemeja Flanel", 35.75, 305, Size.M));
        productManager.addProduct(new Electronics("Smartphone Samsung", 800.00, 202, 12, 0.2, "Samsung"));
        productManager.addProduct(new Clothing("Celana Jeans", 50.00, 306, Size.L));
        
        // Add sample transactions
        try {
            transactionManager.addPurchase("Alice", productManager.findProductById(201));
            transactionManager.addPurchase("Alice", productManager.findProductById(306));
            transactionManager.addPurchase("Bob", productManager.findProductById(305));
            refreshTransactionTable();
        } catch (ProductNotFoundException e) {
            System.err.println("Error loading sample data: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OnlineShopGUI().setVisible(true);
            }
        });
    }
}