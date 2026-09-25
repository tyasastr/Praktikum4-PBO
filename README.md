# Praktikum Pemrograman Berorientasi Objek
## Modul 04: Array of Objects, JSF, List, ArrayList, LinkedList, Iterator
### Identitas
**Tyasastri Hning Kurniasih (L0325034)**

---
### Diagram _Class_
```text
src/
└── Praktikum4/
|    └── Tugas/
|       ├── AsetIT.java        # Class model untuk entitas Aset IT
|       ├── ManajemenAset.java # Class controller (mengelola List)
|       └── MainAset.java      # Main class untuk menjalankan program
└─README.md
```
---

### Detail Program
#### 1. `AsetIT`
* Deklarasi _class_ bernama `AsetIT` di dalam _package_ `Tugas` yang berada di dalam _package_ `Praktikum4`
```java
package Praktikum4.Tugas;

public class AsetIT {
```
* _Attributes_ berupa `String idAset`, `String namaPerangkat`, `String lokasi`, dan `String statusKondisi`
``` java
    String idAset;
    String namaPerangkat;
    String lokasi;
    String statusKondisi;
```
* _Parameterized constructor_ yang menerima nilai input _attributes_ saat _object_ dibuat di `public AsetIT(String idAset, String namaPerangkat, String lokasi, String statusKondisi)`, dan penggunaan `this.(nama attribute)` yang merujuk spesifik ke _attribute_ milik instansi _object_ yang sedang diproses
```java
public AsetIT(String idAset, String namaPerangkat, String lokasi, String statusKondisi) {
        this.idAset = idAset;
        this.namaPerangkat = namaPerangkat;
        this.lokasi = lokasi;
        this.statusKondisi = statusKondisi;
    }
```
* _Method_ berupa `public void tampilkanInfoAset()` untuk menampilkan informasi spesifikasi aset
```java
 public void tampilkanInfoAset() {
        System.out.println("ID Aset: " + idAset);
        System.out.println("Nama Perangkat: " + namaPerangkat);
        System.out.println("Lokasi: " + lokasi);
        System.out.println("Status Kondisi: " + statusKondisi);
        System.out.println("------------------------------\n");
    }
}
```
---

#### 2. `ManajemenAset`
* _Import library_ berupa struktu data _ArrayList_, antarmuka _List_, dan _Iterator_ dari _utility library Java_
```java
package Praktikum4.Tugas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
```
* Deklarasi _class_ `ManajemenAset` dan _attributes collection_ menggunakan `ArrayList<AsetIT>` untuk menampung _objects_ `AsetIT`
```java
public class ManajemenAset {
    ArrayList<AsetIT> daftarAset;
```
* _Default constructor_ untuk inisialisasi _objects_ di `daftarAset` dari _ArrayList_
```java
public ManajemenAset() {
        this.daftarAset = new ArrayList<>();
    }
```
* _Method_ `tambahAset()` untuk menambah 4 _objects_ `AsetIT` ke `daftarAset`
```java
public void tambahAset(AsetIT asetBaru) {
        daftarAset.add(asetBaru);
    }
```
* _Method_ `tampilkanSemuaAset()` untuk menampilkan semua data aset yang tersimpan dengan memanfaatkan _for-each looping_
```java
public void tampilkanSemuaAset() {
        if(daftarAset.isEmpty()) {
            System.out.println("Tidak ada aset.");
            return;
        }
        for (AsetIT aset : daftarAset) {
            aset.tampilkanInfoAset();
        }
    }
```
* _Method_ `hapusAset()` untuk mencari kemudian menghapus data aset menggunakan ID-nya, penerapan mekanisme _iterator_, yaitu:
   `Iterator<AsetIT> iterator = daftarAset.iterator()` untuk inisialisasi _iterator_
   `iterator.hasNext()` untuk memeriksa ketersediaan elemen berikutnya
   `iterator.next()` untuk mengambil referensi elemen yang sedang diakses
   `equalsIgnoreCase()` untuk membandingkan ID tanpa pengaruh kapitalisasi huruf
   `iterator.remove()` untuk menghapus elemen
```java
public void hapusAset(String idAset) {
        Iterator<AsetIT> iterator = daftarAset.iterator();
        boolean ditemukan = false;
        
        while (iterator.hasNext()) {
            AsetIT aset = iterator.next();
            if (aset.getIDAset().equalsIgnoreCase(idAset)) {
                iterator.remove();
                ditemukan = true;
                System.out.println("Aset dengan ID '" + idAset + "' telah dihapus.\n");
                break;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Aset dengan ID '" + idAset + "'tidak ditemukan!\n");
        }
    }
}
```
---

#### 3. `MainAset`
* Deklarasi _class_ `MainAser` dan _main method_ `dalam _package_ `Praktikum4.Tugas`
```java
package Praktikum4.Tugas;

public class MainAset {
    public static void main(String[] args) {
```
* Instansiasi _objects_ ManajemenAset
```java
ManajemenAset manajemen = new ManajemenAset();
```
* Penambahan data aset
```java
manajemen.tambahAset(new AsetIT("A01", "Mouse Kabel 1 meter", "Lab Komputer", "Baik dan kadang menghilang"));
        manajemen.tambahAset(new AsetIT("A02", "Smart TV 50 inch", "Lab Komputer", "Baik dan sedang menghilang"));
        manajemen.tambahAset(new AsetIT("A03", "Proyektor", "Ruang 17", "Baik walau kadang bergetar"));
        manajemen.tambahAset(new AsetIT("A04", "Smart TV 32 inch", "Ruang 19", "Sangat baik"));
```
* Menampilkan data aset awal
```java
System.out.println("DAFTAR ASET IT (awal)");
        System.out.println("------------------------------\n");
        manajemen.tampilkanSemuaAset();
```
* Menghapus data aset
```java
System.out.println("Menghapus aset dengan ID 'A03'...");
        manajemen.hapusAset("A03");
```
* Menampilkan kembali data setelah penghapusan salah satu data aset
```java
System.out.println("DAFTAR ASET IT (setelah dihapus)");
        System.out.println("------------------------------\n");
        manajemen.tampilkanSemuaAset();
    }
}
```
---

### _Output_ Program
```text
DAFTAR ASET IT (awal)
------------------------------

ID Aset: A01
Nama Perangkat: Mouse Kabel 1 meter
Lokasi: Lab Komputer
Status Kondisi: Baik dan kadang menghilang
------------------------------

ID Aset: A02
Nama Perangkat: Smart TV 50 inch
Lokasi: Lab Komputer
Status Kondisi: Baik dan sedang menghilang
------------------------------

ID Aset: A03
Nama Perangkat: Proyektor
Lokasi: Ruang 17
Status Kondisi: Baik walau kadang bergetar
------------------------------

ID Aset: A04
Nama Perangkat: Smart TV 32 inch
Lokasi: Ruang 19
Status Kondisi: Sangat baik
------------------------------

Menghapus aset dengan ID 'A03'...
Aset dengan ID 'A03' telah dihapus.

DAFTAR ASET IT (setelah dihapus)
------------------------------

ID Aset: A01
Nama Perangkat: Mouse Kabel 1 meter
Lokasi: Lab Komputer
Status Kondisi: Baik dan kadang menghilang
------------------------------

ID Aset: A02
Nama Perangkat: Smart TV 50 inch
Lokasi: Lab Komputer
Status Kondisi: Baik dan sedang menghilang
------------------------------

ID Aset: A04
Nama Perangkat: Smart TV 32 inch
Lokasi: Ruang 19
Status Kondisi: Sangat baik
------------------------------
```
