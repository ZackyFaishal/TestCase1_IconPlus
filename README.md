# TestCase1_IconPlus
Test Case Number 1 for PLN Icon Plus Recruitment

# 🔢 TestCase1 – Number to Words REST API (Icon Plus)

## 📖 Deskripsi Proyek
**TestCase1_IconPlus** adalah proyek backend sederhana berbasis **Spring Boot (Java)** yang dibuat untuk menyelesaikan **Case 1 – Tes Rekrutmen PLN Icon Plus**  
Tujuan utama aplikasi ini adalah untuk menerima **input angka** melalui API dan mengonversinya menjadi **teks (terbilang)** 

Data angka yang dikirim disimpan sementara di memori aplikasi, dan dapat diambil kembali melalui endpoint lain dalam format JSON.

---

## ⚙️ Teknologi yang Digunakan
- **Java 17**
- **Spring Boot 3.x**
- **Spring Web (REST API)**
- **Maven**
- **Lombok**

---

## 🚀 Fitur Utama
| Fitur | Deskripsi |
|--------|------------|
| `POST /number` | Menerima input angka dan menyimpannya sementara di memori |
| `GET /number` | Menampilkan semua angka yang sudah dikirim beserta hasil konversi ke huruf |
| Validasi Input | Hanya menerima data numerik, error `400` jika input tidak valid |
| Data Persistence | Data disimpan sementara di dalam aplikasi (tanpa database) |
| Konversi Terbilang | Implementasi manual tanpa library eksternal |
| Empty State Handling | Menampilkan pesan `{"error": "Belum ada data yang diinput."}` jika belum ada data |

---

## 🧩 Spesifikasi Endpoint

### 🔹 POST `/number`
Menerima angka dalam format JSON dan menyimpannya di memori.

#### 🧾 Contoh Request
```json
{
  "value": 123
}
```

### 🔹 GET `/number`
Mengambil dan menampilkan kalimat yang di inputkan 
```json
{
  "angka": 123,
  "terbilang": "seratus dua puluh tiga"
}
```
