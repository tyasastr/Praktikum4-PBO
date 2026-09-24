# Praktikum Pemrograman Berorientasi Objek
## Modul 04: Array of Objects, JSF, List, ArrayList, LinkedList, Iterator
### Identitas
### Nama: Tyasastri Hning Kurniasih
### NIM: L0325034
---
#### Source Code Java yang Digunakan:
1. AsetIT.java
'''java
// Tyasastri Hning Kurniasih - L0325034
// Praktikum 4 PBO

package Praktikum4.Tugas;

public class AsetIT {
    // a. attributes
    String idAset;
    String namaPerangkat;
    String lokasi;
    String statusKondisi;
    
    // b. parameterized constructor
    public AsetIT(String idAset, String namaPerangkat, String lokasi, String statusKondisi) {
        this.idAset = idAset;
        this.namaPerangkat = namaPerangkat;
        this.lokasi = lokasi;
        this.statusKondisi = statusKondisi;
    }
    
    // getter
    public String getIDAset() {
        return idAset;
    }
    
    // c. method untuk mencetak data
    public void tampilkanInfoAset() {
        System.out.println("ID Aset: " + idAset);
        System.out.println("Nama Perangkat: " + namaPerangkat);
        System.out.println("Lokasi: " + lokasi);
        System.out.println("Status Kondisi: " + statusKondisi);
        System.out.println("------------------------------\n");
    }
}

2. ManajemenAset.java
'''java
// Tyasastri Hning Kurniasih - L0325034
// Praktikum 4 PBO

package Praktikum4.Tugas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManajemenAset {
    // attribute
    private List<AsetIT> daftarAset;
    
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

3. MainAset.java
'''java
// Tyasastri Hning Kurniasih - L0325034
// Praktikum 4 PBO

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

