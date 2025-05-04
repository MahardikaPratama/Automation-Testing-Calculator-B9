# 📘 **Tugas Kelompok: Pengujian Perangkat Lunak**

## 🧑‍🤝‍🧑 **Anggota Kelompok**
| NIM        | Nama                     |
|------------|--------------------------|
| 221524044  | Mahardika Pratama        |
| 221524052  | Naia Siti Az-zahra       |
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
   - **Validasi Angka**:
     - Apakah input berupa angka.
       - **Test Case**:
         - Input angka positif → **Expected**: `true`.
         - Input angka negatif → **Expected**: `true`.
         - Input huruf non-numerik → **Expected**: `false`.
         - Input campuran angka dan huruf → **Expected**: `false`.
         - Input string kosong → **Expected**: `false`.
     - Apakah angka berada dalam rentang **-32,768** hingga **32,767**.
       - **Test Case**:
         - Input lebih besar dari batas atas → **Expected**: `false`.
         - Input lebih kecil dari batas bawah → **Expected**: `false`.
         - Input dalam rentang valid → **Expected**: `true`.
   - **Validasi Operator**:
     - Apakah operator valid (`+`, `-`, `*`, `/`).
       - **Test Case**:
         - Input operator valid → **Expected**: `true`.
         - Input operator tidak valid → **Expected**: `false`.
     - Apakah pembagian dilakukan dengan angka nol.
       - **Test Case**:
         - Penyebut bukan nol → **Expected**: `true`.
         - Penyebut nol → **Expected**: `false`.

2. **Operasi Matematika**:
   - **Penjumlahan**:
     - Dua bilangan positif → **Expected**: Hasil penjumlahan.
     - Bilangan positif dan negatif → **Expected**: Hasil penjumlahan.
     - Dua bilangan negatif → **Expected**: Hasil penjumlahan.
     - Salah satu bilangan nol → **Expected**: Bilangan lainnya.
     - Dua bilangan nol → **Expected**: `0`.
   - **Pengurangan**:
     - Dua bilangan positif → **Expected**: Hasil pengurangan.
     - Bilangan positif dan negatif → **Expected**: Hasil pengurangan.
     - Dua bilangan negatif → **Expected**: Hasil pengurangan.
     - Salah satu bilangan nol → **Expected**: Bilangan lainnya.
     - Dua bilangan nol → **Expected**: `0`.
   - **Perkalian**:
     - Dua bilangan positif → **Expected**: Hasil perkalian.
     - Bilangan positif dan negatif → **Expected**: Hasil perkalian.
     - Dua bilangan negatif → **Expected**: Hasil perkalian.
     - Salah satu bilangan nol → **Expected**: `0`.
     - Dua bilangan nol → **Expected**: `0`.
   - **Pembagian**:
     - Dua bilangan positif → **Expected**: Hasil pembagian.
     - Bilangan positif dan negatif → **Expected**: Hasil pembagian.
     - Dua bilangan negatif → **Expected**: Hasil pembagian.
     - Pembilang nol → **Expected**: `0.0`.
     - Penyebut nol → **Expected**: Error dengan pesan "Pembagi tidak boleh bernilai nol".
     - Dua bilangan nol → **Expected**: Error dengan pesan "Pembagi tidak boleh bernilai nol".

3. **Interaksi Pengguna**:
   - **Input Angka**:
     - Input valid → **Expected**: Angka diterima.
     - Input tidak valid → **Expected**: Diminta ulang hingga valid.
   - **Input Operator**:
     - Input valid → **Expected**: Operator diterima.
     - Input tidak valid → **Expected**: Diminta ulang hingga valid.
   - **Fungsi Pengulangan Kalkulasi**:
     - Input `y` → **Expected**: Kalkulator mengulang.
     - Input `n` → **Expected**: Kalkulator berhenti.
     - Input tidak valid → **Expected**: Diminta ulang hingga valid.
   - **Output**:
     - Header kalkulator ditampilkan.
     - Hasil perhitungan ditampilkan dalam format `<angka1> <operator> <angka2> = <hasil>`.
     - Pesan perpisahan ditampilkan saat program selesai.

4. **Simulasi Input Scanner**:
   - Simulasi input menggunakan `System.in`.
   - Penanganan input valid dan tidak valid.

### 📊 **Laporan Pengujian**
Laporan pengujian dihasilkan menggunakan **Allure**. Laporan ini memberikan visualisasi hasil pengujian, termasuk jumlah pengujian yang berhasil, gagal, atau diabaikan.

---

## 📈 **Hasil Laporan Pengujian Otomatis (Allure Report)**
Laporan hasil pengujian otomatis dapat diakses melalui tautan berikut:
- [Allure Report](https://mahardikapratama.github.io/Automation-Testing-Calculator-B9/)

---

## 📦 **Tools & Dependencies**
- **Java**: Versi 17
- **Maven**: Sistem build untuk manajemen dependensi
- **JUnit 5**: Framework untuk unit testing
- **Allure**: Untuk menghasilkan laporan pengujian

---

## 📚 **Referensi**
- **JUnit 5 – Dokumentasi Resmi**  
  🔗 [https://junit.org/junit5/docs/current/user-guide/](https://junit.org/junit5/docs/current/user-guide/)
- **Allure Framework (JUnit 5 Integration)**  
  🔗 [https://allurereport.org/docs/junit5/](https://allurereport.org/docs/junit5/)
- **Apache Maven – Build Automation Tool**  
  🔗 [https://maven.apache.org/](https://maven.apache.org/)
- **Java SE 17 Documentation**  
  🔗 [https://docs.oracle.com/en/java/javase/17/](https://docs.oracle.com/en/java/javase/17/)

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
AUTOMATION-TESTING-CALCULATOR-B9/
├── .allure/                      # Direktori untuk laporan Allure
│   ├── allure-2.20.1/
│   │   ├── bin/
│   │   ├── config/
│   │   ├── lib/
│   │   └── plugins/
├── .vscode/                      # Konfigurasi editor Visual Studio Code
│   └── settings.json
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/calculator/
│   │   │       ├── MainApp.java  # Entry point aplikasi
│   │   │       ├── Compute.java  # Logika perhitungan berdasarkan operator
│   │   │       ├── Calculate.java # Operasi matematika dasar
│   │   │       └── Validate.java # Validasi input angka dan operator
│   └── test/
│       ├── java/
│       │   └── com/calculator/
│       │       ├── MainAppTest.java  # Unit test untuk MainApp
│       │       ├── ComputeTest.java  # Unit test untuk Compute
│       │       ├── CalculateTest.java # Unit test untuk Calculate
│       │       └── ValidateTest.java # Unit test untuk Validate
├── target/                       # Direktori hasil build Maven
│   ├── allure-results/           # Hasil pengujian untuk Allure
│   ├── surefire-reports/         # Laporan pengujian Surefire
│   └── site/
│       └── allure-maven-plugin/  # Laporan Allure
├── pom.xml                       # Konfigurasi Maven
├── README.md                     # Dokumentasi proyek
└── LICENSE                       # Informasi lisensi
```

---

## 📜 **Lisensi**
Proyek ini dibuat untuk keperluan akademik dan tidak memiliki lisensi resmi. Silakan gunakan dengan bijak.