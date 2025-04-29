package Investasi.java;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    String username;
    String password;
    Map<Saham, Integer> sahamDimiliki = new HashMap<>();
    Map<SuratBerhargaNegara, Double> sbnDimiliki = new HashMap<>();

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void beliSaham(Saham saham, int jumlah) {
        sahamDimiliki.put(saham, sahamDimiliki.getOrDefault(saham, 0) + jumlah);
    }

    public void jualSaham(Saham saham, int jumlah) {
        int saatIni = sahamDimiliki.getOrDefault(saham, 0);
        if (saatIni >= jumlah) {
            sahamDimiliki.put(saham, saatIni - jumlah);
            System.out.println("Transaksi sukses: Penjualan saham berhasil.");
        } else {
            System.out.println("Gagal: Jumlah saham yang dijual melebihi yang dimiliki.");
        }
    }

    public void beliSBN(SuratBerhargaNegara sbn, double nominal) {
        if (sbn.kuotaNasional >= nominal) {
            sbnDimiliki.put(sbn, sbnDimiliki.getOrDefault(sbn, 0.0) + nominal);
            sbn.kuotaNasional -= nominal;
            System.out.println("Transaksi sukses: Pembelian SBN berhasil.");
        } else {
            System.out.println("Gagal: Kuota nasional tidak mencukupi.");
        }
    }

    public void tampilkanPortofolio() {
        System.out.println("\nPortofolio Saham:");
        for (Map.Entry<Saham, Integer> entry : sahamDimiliki.entrySet()) {
            Saham saham = entry.getKey();
            int jumlah = entry.getValue();
            double totalNominal = saham.harga * jumlah;
            System.out.printf("Saham: %s | Kode: %s | Jumlah: %d | Nilai Pasar: Rp%.2f\n",
                    saham.namaPerusahaan, saham.kode, jumlah, totalNominal);
        }

        System.out.println("\nPortofolio SBN:");
        for (Map.Entry<SuratBerhargaNegara, Double> entry : sbnDimiliki.entrySet()) {
            SuratBerhargaNegara sbn = entry.getKey();
            double nominal = entry.getValue();
            double bungaBulanan = (sbn.bunga / 100 / 12) * 0.9 * nominal;
            System.out.printf("SBN: %s | Nominal: Rp%.2f | Bunga/Bulan: Rp%.2f\n",
                    sbn.nama, nominal, bungaBulanan);
        }
    }
}
