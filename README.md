# BMI Calculator App

Link GitHub : https://github.com/andresaputra26/BMIApp.git

BMI Calculator App adalah aplikasi Android sederhana yang menghitung Body Mass Index (BMI) berdasarkan berat dan tinggi badan yang dimasukkan oleh pengguna. Aplikasi ini mendukung dua sistem satuan, yaitu sistem metrik (kg & cm) dan USC (lbs & in).

Fitur Aplikasi
- Input berat badan dalam kilogram atau pound
- Input tinggi badan dalam sentimeter atau inci
- Menampilkan hasil BMI dengan kategori: Underweight, Normal weight, Overweight, atau Obesity
- Tombol pengalih untuk memilih antara sistem metrik dan USC

Teknologi yang Digunakan
- Kotlin: Bahasa pemrograman utama
- Jetpack Compose: Untuk membuat antarmuka pengguna yang modern
- Material 3: Library Material Design untuk komponen UI

Cara Menjalankan Aplikasi
1. Buka Android Studio dan pastikan SDK yang diperlukan sudah terinstal
2. Impor proyek ini di Android Studio
3. Hubungkan perangkat Android via USB atau gunakan Emulator Android
4. Klik tombol Run di toolbar atau tekan Shift + F10. Android Studio akan membangun aplikasi dan menginstalnya pada perangkat atau emulator

Cara Menggunakan Aplikasi
1. Masukkan berat badan pada kolom yang disediakan
2. Masukkan tinggi badan pada kolom yang disediakan
3. Pilih sistem satuan (USC atau Metrik) dengan menekan tombol pengalih
4. Klik tombol Calculate BMI untuk menghitung BMI
5. Hasil BMI beserta kategori akan ditampilkan

Struktur File
- MainActivity.kt: Berisi MainActivity dan logika utama untuk menghitung BMI
- build.gradle.kts: File konfigurasi Gradle yang mengatur plugin, dependensi, dan SDK versi

Fungsi Utama
- calculateBMI: Fungsi untuk menghitung BMI berdasarkan berat, tinggi, dan sistem satuan
- getBMICategory: Fungsi untuk menentukan kategori BMI berdasarkan nilai BMI yang dihitung

Contoh Rumus Perhitungan
- Sistem USC: BMI dihitung menggunakan rumus  BMI = 703 x (berat / tinggi^2)
- Sistem Metrik: BMI dihitung menggunakan rumus BMI = berat / (tinggi / 100)^2

Dependensi
- AndroidX dan Jetpack Compose untuk komponen dan fungsi UI
- Material3 untuk desain antarmuka yang lebih modern
