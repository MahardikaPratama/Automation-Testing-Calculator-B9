# 📘 **Tugas Kelompok: Pengujian Perangkat Lunak**

## 🧑‍🤝‍🧑 **Anggota Kelompok**
| NIM        | Nama                     |
|------------|--------------------------|
| 221524044  | Mahardika Pratama        |
| 221524052  | Naia Siti Az-Zahra       |
| 221524058  | Salsabil Khoirunisa      |

---

## 💻 **Deskripsi Program**
Proyek ini adalah implementasi **program kalkulator sederhana** yang dikembangkan menggunakan **Java** dan **Maven**. Program ini dirancang untuk mendemonstrasikan pengujian perangkat lunak dengan menerapkan **unit testing otomatis** menggunakan **JUnit 5**.

### ✨ **Fitur Utama**
1. **Operasi Matematika Dasar**:
   - Penjumlahan (`+`)
   - Pengurangan (`-`)
   - Perkalian (`*`)
   - Pembagian (`/`)
2. **Validasi Input**:
   - Input harus berupa angka.
   - Angka harus berada dalam rentang **-32,768** hingga **32,767**.
   - Operator yang valid: `+`, `-`, `*`, `/`.
   - Pembagian tidak boleh dilakukan dengan angka nol.
3. **Interaksi Pengguna**:
   - Menampilkan hasil perhitungan dalam format: `<angka1> <operator> <angka2> = <hasil>`.
   - Menanyakan kepada pengguna apakah ingin melakukan perhitungan lagi.
   - Menampilkan pesan perpisahan saat program selesai.

---

## 🧪 **Pengujian Otomatis**
Proyek ini mencakup **unit testing otomatis** menggunakan framework **JUnit 5**. Berikut adalah cakupan pengujian:

### 🔍 **Cakupan Pengujian**
1. **Validasi Input**:
   - Apakah input berupa angka.
   - Apakah angka berada dalam rentang **-32,768** hingga **32,767**.
   - Apakah operator valid (`+`, `-`, `*`, `/`).
   - Apakah pembagian dilakukan dengan angka nol.
2. **Operasi Matematika**:
   - Penjumlahan, pengurangan, perkalian, pembagian.
   - Kasus angka negatif, nol, dan batas integer.
3. **Simulasi Input Scanner**:
   - Simulasi input menggunakan `System.in`.
   - Penanganan input valid dan tidak valid.

### 📊 **Laporan Pengujian**
Laporan pengujian dihasilkan menggunakan **Allure**. Laporan ini memberikan visualisasi hasil pengujian, termasuk jumlah pengujian yang berhasil, gagal, atau diabaikan.

---

## 📦 **Tools & Dependencies**
- **Java**: Versi 17
- **Maven**: Sistem build untuk manajemen dependensi
- **JUnit 5**: Framework untuk unit testing
- **Allure**: Untuk menghasilkan laporan pengujian

---

## ▶️ **Cara Menjalankan Program**
1. Pastikan Anda telah menginstal **Java 17** dan **Maven**.
2. Jalankan perintah berikut di terminal untuk menjalankan program:
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="com.calculator.MainApp"
   ```

---

## ▶️ **Cara Menjalankan Unit Testing**
1. Jalankan perintah berikut untuk menjalankan semua pengujian:
   ```bash
   mvn test
   ```

---

## ▶️ **Cara Menghasilkan Laporan Pengujian dengan Allure**
1. Jalankan perintah berikut untuk menghasilkan laporan:
   ```bash
   mvn allure:report
   ```
2. Buka laporan di browser dengan membuka file berikut:
   ```
   target/site/allure-maven-plugin/index.html
   ```

---

## 📂 **Struktur Proyek**
```
kalkulator/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/calculator/
│   │   │       ├── MainApp.java
│   │   │       ├── Compute.java
│   │   │       ├── Calculate.java
│   │   │       └── Validate.java
│   └── test/
│       ├── java/
│       │   └── com/calculator/
│       │       ├── MainAppTest.java
│       │       ├── ComputeTest.java
│       │       ├── CalculateTest.java
│       │       └── ValidateTest.java
├── pom.xml
└── README.md
```

---

## 📜 **Lisensi**
Proyek ini dibuat untuk keperluan akademik dan tidak memiliki lisensi resmi. Silakan gunakan dengan bijak.