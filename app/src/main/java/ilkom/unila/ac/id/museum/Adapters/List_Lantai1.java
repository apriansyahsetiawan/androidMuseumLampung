package ilkom.unila.ac.id.museum.Adapters;

/**
 * Created by user on 2/13/2018.
 */

public class List_Lantai1 {
    private String id_kategori, id_lantai, nama_kategori;

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getId_lantai() {
        return id_lantai;
    }

    public void setId_lantai(String id_lantai) {
        this.id_lantai = id_lantai;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public List_Lantai1(String id_kategori, String id_lantai, String nama_kategori) {
        this.id_kategori = id_kategori;
        this.id_lantai = id_lantai;
        this.nama_kategori = nama_kategori;
    }
}
