import java.time.format.DateTimeFormatter;

public class MainApp {
    public static void main(String[] args) {
        // Membuat objek Electronics
        Electronics laptop = new Electronics("Laptop ASUS ROG", 1200.00, 201, 24, 2.5, "ASUS");

        // Membuat objek Clothing
        Clothing shirt = new Clothing("Kemeja Flanel", 35.75, 305, Size.M);

        // Mencetak informasi produk Electronics
        System.out.println("Informasi Produk Elektronik:");
        System.out.println(laptop.getInfo());
        System.out.println("Kategori: " + laptop.getCategory());
        System.out.println("Harga setelah diskon 10%: €" + String.format("%.2f", laptop.getDiscountedPrice(10)));
        System.out.println("Spesifikasi: " + laptop.getSpecification().getSpecs());
        System.out.println();

        // Mencetak informasi produk Clothing
        System.out.println("Informasi Produk Pakaian:");
        System.out.println(shirt.getInfo());
        System.out.println("Kategori: " + shirt.getCategory());
        System.out.println("Harga setelah diskon 10%: €" + String.format("%.2f", shirt.getDiscountedPrice(10)));
        System.out.println();
    }
}
