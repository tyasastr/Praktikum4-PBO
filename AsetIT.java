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
