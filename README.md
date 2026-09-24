# Praktikum Pemrograman Berorientasi Objek
## Modul 04: Array of Objects, JSF, List, ArrayList, LinkedList, Iterator
### Identitas
**Tyasastri Hning Kurniasih (L0325034)**

#### Detail Program
Untuk memperdalam pemahaman terkait materi praktikum modul 04, dibuat program Manajemen Aset IT. Dibuat beberapa _classes_ dengan rincian: 
#### 1. AsetIT
* Deklarasi _class_ bernama AsetIT di dalam _package_ Tugas yang berada di dalam _package_ Praktikum4 (Praktikum4.Tugas)
```java
package Praktikum4.Tugas;

public class AsetIT {
```
* _Attributes_ berupa String idAset, namaPerangkat, lokasi, dan statusKondisi
``` java
    String idAset;
    String namaPerangkat;
    String lokasi;
    String statusKondisi;
```
* _Parameterized constructor_ yang menerima nilai input _attributes_ saat _object_ dibuat di _public AsetIT(semua attributes)_, dan penggunaan _this.(attribute)_ yang merujuk spesifik ke _attribute_ milik instansi _object_ yang sedang diproses
```java
public AsetIT(String idAset, String namaPerangkat, String lokasi, String statusKondisi) {
        this.idAset = idAset;
        this.namaPerangkat = namaPerangkat;
        this.lokasi = lokasi;
        this.statusKondisi = statusKondisi;
    }
```
* _Method_ berupa _public void tampilkanInfoAset()_ untuk menampilkan informasi spesifikasi aset
```java
 public void tampilkanInfoAset() {
        System.out.println("ID Aset: " + idAset);
        System.out.println("Nama Perangkat: " + namaPerangkat);
        System.out.println("Lokasi: " + lokasi);
        System.out.println("Status Kondisi: " + statusKondisi);
        System.out.println("------------------------------\n");
    }
```


#### 2. ManajemenAset
```java
package Praktikum4.Tugas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManajemenAset {
    // attribute
    private ArrayList<AsetIT> daftarAset;
    
    public ManajemenAset() {
        this.daftarAset = new ArrayList<>();
    }
    
    // objects
    public void tambahAset(AsetIT asetBaru) {
        daftarAset.add(asetBaru);
    }
    
    // for each loop untuk menampilkan data
    public void tampilkanSemuaAset() {
        if(daftarAset.isEmpty()) {
            System.out.println("Tidak ada aset.");
            return;
        }
        for (AsetIT aset : daftarAset) {
            aset.tampilkanInfoAset();
        }
    }
    
    // iterator untuk menghapus aset berdasarkan ID
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

**Struktur _Source Code_**
* _Import library_ berupa struktu data _ArrayList_, antarmuka _List_, dan _Iterator_ dari _utility library Java_
* Deklarasi _attributes collection_ menggunakan _ArrayList<AsetIT>_ untuk menampung _objects_ AsetIT
* _Default constructor_ untuk inisialisasi _objects_ di daftarAset dari _ArrayList_
* _Method_ tambahAset() untuk menambah 4 _objects_ AsetIT ke daftarAset
* _Method_ tampilkanSemuaAset() untuk menampilkan semua data aset yang tersimpan dengan memanfaatkan _for-each looping_
* _Method_ hapusAset() untuk mencari kemudian menghapus data aset menggunakan ID-nya, penerapan mekanisme _iterator_


#### 3. MainAset
```java
package Praktikum4.Tugas;


public class MainAset {
    public static void main(String[] args) {
        // a. instansiasi objek ManajemenAset
        ManajemenAset manajemen = new ManajemenAset();
        
        // b.i. menambah 4 data aset
        manajemen.tambahAset(new AsetIT("A01", "Mouse Kabel 1 meter", "Lab Komputer", "Baik dan kadang menghilang"));
        manajemen.tambahAset(new AsetIT("A02", "Smart TV 50 inch", "Lab Komputer", "Baik dan sedang menghilang"));
        manajemen.tambahAset(new AsetIT("A03", "Proyektor", "Ruang 17", "Baik walau kadang bergetar"));
        manajemen.tambahAset(new AsetIT("A04", "Smart TV 32 inch", "Ruang 19", "Sangat baik"));
        
        //b.ii. tampilkan semua aset
        System.out.println("DAFTAR ASET IT (awal)");
        System.out.println("------------------------------\n");
        manajemen.tampilkanSemuaAset();
        
        // b.iii. hapus salah satu aset menggunakan ID valid
        System.out.println("Menghapus aset dengan ID 'A03'...");
        manajemen.hapusAset("A03");
        
        // b.iv. tampilkan kembali semua aset setelah operasi penghapusan
        System.out.println("DAFTAR ASET IT (setelah dihapus)");
        System.out.println("------------------------------\n");
        manajemen.tampilkanSemuaAset();
    }
}
```
