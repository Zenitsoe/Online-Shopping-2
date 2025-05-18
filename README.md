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


## Anggota Kelompok
- [Rachmat Tri Aji (51424093)]
- [Rafly Nur Hidayat (51424130)]
- [Ananda Ramadhan (50424123)]
- [Muhammad Eka Suryawan ()]
- [Hilmi Samdya ()]


