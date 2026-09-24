// Tyasastri Hning Kurniasih - L0325034
// Praktikum 4 PBO

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
