package ilkom.unila.ac.id.museum.Adapters;

/**
 * Created by user on 2/14/2018.
 */

public class List_Object {
    private String id_koleksi, nama_jenis_koleksi, gambar, nama_koleksi, asal_koleksi;

    public String getId_koleksi() {
        return id_koleksi;
    }

    public void setId_koleksi(String id_koleksi) {
        this.id_koleksi = id_koleksi;
    }
//
//    public String getId_jenis() {
//        return id_jenis;
//    }
//
//    public void setId_jenis(String id_jenis) {
//        this.id_jenis = id_jenis;
//    }

    public String getNama_jenis_koleksi() {
        return nama_jenis_koleksi;
    }

    public void setNama_jenis_koleksi(String nama_jenis_koleksi) {
        this.nama_jenis_koleksi = nama_jenis_koleksi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama_koleksi() {
        return nama_koleksi;
    }

    public void setNama_koleksi(String nama_koleksi) {
        this.nama_koleksi = nama_koleksi;
    }

    public String getAsal_koleksi() {
        return asal_koleksi;
    }

    public void setAsal_koleksi(String asal_koleksi) {
        this.asal_koleksi = asal_koleksi;
    }

    public List_Object(String id_koleksi, String nama_jenis_koleksi, String gambar, String nama_koleksi, String asal_koleksi) {
        this.id_koleksi = id_koleksi;
        this.nama_jenis_koleksi = nama_jenis_koleksi;
        this.gambar = gambar;
        this.nama_koleksi = nama_koleksi;
        this.asal_koleksi = asal_koleksi;
    }
}
