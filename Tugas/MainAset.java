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
