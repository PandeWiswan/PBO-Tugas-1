package Investasi.java;

public class SuratBerhargaNegara {
    String nama;
    double bunga;
    int jangkaWaktu;
    String tanggalJatuhTempo;
    int kuotaNasional;

    public SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, String tanggalJatuhTempo, int kuotaNasional) {
        this.nama = nama;
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.kuotaNasional = kuotaNasional;
    }
}
