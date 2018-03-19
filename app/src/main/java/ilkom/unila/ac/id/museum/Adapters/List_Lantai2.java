package ilkom.unila.ac.id.museum.Adapters;

/**
 * Created by user on 2/14/2018.
 */

public class List_Lantai2 {
    private String id_kategori2;
    private String id_lantai2;

    public String getId_kategori2() {
        return id_kategori2;
    }

    public void setId_kategori2(String id_kategori2) {
        this.id_kategori2 = id_kategori2;
    }

    public String getId_lantai2() {
        return id_lantai2;
    }

    public void setId_lantai2(String id_lantai2) {
        this.id_lantai2 = id_lantai2;
    }

    public String getNama_kategori2() {
        return nama_kategori2;
    }

    public void setNama_kategori2(String nama_kategori2) {
        this.nama_kategori2 = nama_kategori2;
    }

    public List_Lantai2(String id_kategori2, String id_lantai2, String nama_kategori2) {

        this.id_kategori2 = id_kategori2;
        this.id_lantai2 = id_lantai2;
        this.nama_kategori2 = nama_kategori2;
    }

    private String nama_kategori2;

}
