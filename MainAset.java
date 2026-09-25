// Tyasastri Hning Kurniasih - L0325034
// Praktikum 4 PBO

package Praktikum4.Tugas;


public class MainAset {
    public static void main(String[] args) {
        // a. instansiasi objek ManajemenAset
        ManajemenAset manajemen = new ManajemenAset();
        
        // b.i. menambah 4 data aset
        manajemen.tambahAset(new AsetIT("A01", "Router", "Ruang 1", "Baik"));
        manajemen.tambahAset(new AsetIT("A02", "Server", "Lab Komputer", "Baik"));
        manajemen.tambahAset(new AsetIT("A03", "Switch", "Ruang 17", "Butuh perbaikan"));
        manajemen.tambahAset(new AsetIT("A04", "PC", "Lab Komputer", "Baik"));
        
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
