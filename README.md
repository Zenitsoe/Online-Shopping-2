## Update projek pertama ONLINE SHOPPING

## Mengupdate beberapa Sistem seperti:
- Membuat Interface Discountable dengan metode getDiscountedPrice() untuk menghitung harga diskon, Mendefinisikan interface Discountable dengan metode getDiscountedPrice() untuk menghitung harga diskon
- embuat Enum Size yang di presentasikan ukuran pakaian untuk Clothing,Mendefinisikan enum Size untuk merepresentasikan ukuran pakaian


## Kelas Product.java
- Mengimport java.time.LocalDateTime dan java.time.format.DateTimeFormatter
- Menambahkan CreatedAT bertipe LocalDateTime untuk set otomatis saat objek dibuat
- Penambahan metode abstract  getCategory di kelas product, Atribut dan Metode yang di abstraksi seperti elemen-elemen dalam kelas product yaitu : name,price,productID,getInfo dan getCategory


## Kelas Clothing.java
- Meng implementasikan Interface Discountable untuk menampilkan pakaian yang diberi Diskon
- Mengubah tipe data atribut size menjadi Enum Size
- Meng Implementasikan metode getCategory() untuk mengembalikan "Pakaian".
- Meng implementasikan metode getDiscountedPrice() untuk menghitung harga diskon.
- Memperbarui metode getInfo() untuk menyertakan informasi kategori dan ukuran.


## Kelas Electronics.java
- Meng implementasikan interface Discountable untuk menandakan bahwa elektronik dapat diberi diskon
- Penambahan Inner Class Specification untuk menyimpan informasi berat dan merek produk elektronik
- Menambahkan atribut specification bertipe Specification untuk menyimpan objek spesifikasi
- Memperbarui konstruktor untuk menerima berat dan merek, dan membuat objek Specification
- Menambahkan metode getSpecification() untuk mengakses objek Specification
- Mengimplementasikan metode getCategory() untuk mengembalikan "Elektronik"
- Mengimplementasikan metode getDiscountedPrice() untuk menghitung harga diskon
- Memperbarui metode getInfo() untuk menyertakan informasi kategori, garansi, dan spesifikasi


## MainApp.java
- Membuat objek Electronics dengan berat dan merek.
- Membuat objek Clothing dengan ukuran menggunakan enum Size.
- Mencetak informasi produk yang lebih lengkap, termasuk kategori, harga diskon, dan spesifikasi elektronik.
  

## Update final dari projek Online Shopping

Proyek ini telah diperbarui dengan beberapa fitur baru untuk meningkatkan manajemen produk dan transaksi, serta penanganan kesalahan yang lebih baik.

### Fitur Baru :

- **Manajemen Produk:**
  - `ProductManager`: Sebuah kelas baru untuk mengelola semua produk.
    - `addProduct(Product product)`: Menambahkan produk baru, mencegah duplikasi berdasarkan ID.
    - `getAllProducts()`: Mengembalikan daftar semua produk.
    - `findProductById(int id)`: Mencari produk berdasarkan ID dan akan melemparkan `ProductNotFoundException` jika tidak ditemukan.

- **Manajemen Transaksi:**
  - `TransactionManager`: Sebuah kelas untuk melacak pembelian pelanggan.
    - `addPurchase(String customerName, Product product)`: Mencatat pembelian produk oleh pelanggan.
    - `getCustomerPurchases(String customerName)`: Menampilkan semua produk yang dibeli oleh pelanggan tertentu.

- **Penanganan Kesalahan:**
  - `ProductNotFoundException`: Sebuah *custom exception* yang akan aktif ketika produk yang dicari tidak ada.

- **Pembaruan Aplikasi Utama (`MainApp`):**
  - Mengintegrasikan `ProductManager` dan `TransactionManager` untuk alur kerja yang lebih terstruktur.
  - Menambahkan contoh transaksi pembelian oleh beberapa pelanggan.
  - Mengimplementasikan blok `try-catch` untuk menangani `ProductNotFoundException` saat mencari produk.


## Struktur Projek 

- **`Product.java`**: Kelas abstrak untuk semua produk.
- **`Clothing.java`**: Subkelas untuk produk pakaian.
- **`Electronics.java`**: Subkelas untuk produk elektronik.
- **`Size.java`**: Enum untuk ukuran pakaian.
- **`Discountable.java`**: *Interface* untuk produk yang dapat didiskon.
- **`ProductManager.java`**: Mengelola koleksi produk.
- **`TransactionManager.java`**: Mengelola transaksi pembelian.
- **`ProductNotFoundException.java`**: *Custom exception* untuk produk yang tidak ditemukan.
- **`MainApp.java`**: Kelas utama untuk menjalankan aplikasi.



## Output dari Projek Online Shopping

1.Menunjukkan form **Product Managemen**, yang digunakan untuk menambahkan product baru

![image](https://github.com/user-attachments/assets/8835ed76-74c3-43a6-bbeb-2f593afdd5eb)

2.Menunjukkan form **Search**, yang digunakan untuk mencari sebuah product menggunakan ProductID dan juga menampilkan Discount 

![image](https://github.com/user-attachments/assets/c4de7f66-b63e-44bc-9bb7-0f45815ed530)

3.Menunjukkan form **Transaction**, yang digunakkan untuk menambahkan transaksi dan juga dapat melihat history pembelian

![image](https://github.com/user-attachments/assets/aafb363a-8e6b-45ba-af30-15d894224cb6)

4.Ketika product berhasil ditambahkan

![image](https://github.com/user-attachments/assets/78f4e5a8-4532-4d15-ab40-4b1265c5f299)

5.Ketika berhasil melakukan transaksi dan bisa dilihat di form **Transaction History**

![image](https://github.com/user-attachments/assets/dc3042a9-de2d-47d6-a456-66d0a1eb74f9)

6.Ketika mencari sebuah product, tetapi tidak ditemukan atau product tidak ada

![image](https://github.com/user-attachments/assets/75c9d060-9d1a-4326-aacb-80b05faad88f)


## Anggota Kelompok
- [Rachmat Tri Aji (51424093)]
- [Rafly Nur Hidayat (51424130)]
- [Ananda Ramadhan (50424123)]
- [Muhammad Eka Suryawan ()]
- [Hilmi Samdya ()]
