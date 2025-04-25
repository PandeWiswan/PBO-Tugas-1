import java.util.*;

class Saham {
    String kode;
    String namaPerusahaan;
    double harga;

    public Saham(String kode, String namaPerusahaan, double harga) {
        this.kode = kode;
        this.namaPerusahaan = namaPerusahaan;
        this.harga = harga;
    }
}

class SuratBerhargaNegara {
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

class Customer {
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
        } else {
            System.out.println("Gagal: Jumlah saham yang dijual melebihi yang dimiliki.");
        }
    }

    public void beliSBN(SuratBerhargaNegara sbn, double nominal) {
        if (sbn.kuotaNasional >= nominal) {
            sbnDimiliki.put(sbn, sbnDimiliki.getOrDefault(sbn, 0.0) + nominal);
            sbn.kuotaNasional -= nominal;
        } else {
            System.out.println("Gagal: Kuota nasional tidak mencukupi.");
        }
    }

    public void tampilkanPortofolio() {
        System.out.println("Portofolio Saham:");
        for (Map.Entry<Saham, Integer> entry : sahamDimiliki.entrySet()) {
            Saham saham = entry.getKey();
            int jumlah = entry.getValue();
            double totalNominal = saham.harga * jumlah;
            System.out.printf("Saham: %s | Kode: %s | Jumlah: %d | Nilai Pasar: Rp%.2f\n",
                    saham.namaPerusahaan, saham.kode, jumlah, totalNominal);
        }

        System.out.println("\n Portofolio SBN:");
        for (Map.Entry<SuratBerhargaNegara, Double> entry : sbnDimiliki.entrySet()) {
            SuratBerhargaNegara sbn = entry.getKey();
            double nominal = entry.getValue();
            double bungaBulanan = (sbn.bunga / 100 / 12) * 0.9 * nominal;
            System.out.printf("SBN: %s | Nominal: Rp%.2f | Bunga/Bulan: Rp%.2f\n",
                    sbn.nama, nominal, bungaBulanan);
        }
    }
}

public class Investasi {
    static ArrayList<Saham> daftarSaham = new ArrayList<>();
    static ArrayList<SuratBerhargaNegara> daftarSBN = new ArrayList<>();
    static Map<String, String> akunAdmin = new HashMap<>();
    static Map<String, Customer> akunCustomer = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        akunAdmin.put("admin", "admin123");

        daftarSaham.add(new Saham("AAPL", "Apple Inc.", 150.0));
        daftarSaham.add(new Saham("GOOGL", "Alphabet Inc.", 2800.0));
        daftarSBN.add(new SuratBerhargaNegara("SBN1", 5.0, 12, "2026-12-31", 1000000));

        while (true) {
            System.out.println("\n=== Menu Awal ===");
            System.out.println("1. Login");
            System.out.println("2. Register (Customer)");
            System.out.println("3. Exit");
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                login();
            } else if (pilihan == 2) {
                register();
            } else {
                break;
            }
        }
    }

    static void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (akunAdmin.containsKey(username) && akunAdmin.get(username).equals(password)) {
            menuAdmin();
        } else if (akunCustomer.containsKey(username) && akunCustomer.get(username).password.equals(password)) {
            menuCustomer(akunCustomer.get(username));
        } else {
            System.out.println("Login gagal.");
        }
    }

    static void register() {
        System.out.print("Buat Username: ");
        String username = scanner.nextLine();
        if (akunAdmin.containsKey(username) || akunCustomer.containsKey(username)) {
            System.out.println("Username sudah digunakan.");
            return;
        }
        System.out.print("Buat Password: ");
        String password = scanner.nextLine();
        akunCustomer.put(username, new Customer(username, password));
        System.out.println("Registrasi berhasil. Silakan login.");
    }

    static void menuAdmin() {
        while (true) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Saham");
            System.out.println("2. SBN");
            System.out.println("3. Logout");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            if (pilih == 1) menuAdminSaham();
            else if (pilih == 2) menuAdminSBN();
            else break;
        }
    }

    static void menuAdminSaham() {
        while (true) {
            System.out.println("\n=== Admin > Saham ===");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Kembali");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            if (pilih == 1) {
                System.out.print("Kode Saham: ");
                String kode = scanner.nextLine();
                System.out.print("Nama Perusahaan: ");
                String nama = scanner.nextLine();
                System.out.print("Harga: ");
                double harga = scanner.nextDouble();
                scanner.nextLine();
                daftarSaham.add(new Saham(kode, nama, harga));
                System.out.println("Saham berhasil ditambahkan.");
            } else if (pilih == 2) {
                for (int i = 0; i < daftarSaham.size(); i++) {
                    System.out.printf("%d. %s (%s) - Rp%.2f\n", i + 1, daftarSaham.get(i).namaPerusahaan, daftarSaham.get(i).kode, daftarSaham.get(i).harga);
                }
                System.out.print("Pilih nomor saham: ");
                int idx = scanner.nextInt() - 1;
                System.out.print("Harga baru: ");
                double hargaBaru = scanner.nextDouble();
                scanner.nextLine();
                daftarSaham.get(idx).harga = hargaBaru;
                System.out.println("Harga saham berhasil diubah.");
            } else {
                break;
            }
        }
    }

    static void menuAdminSBN() {
        while (true) {
            System.out.println("\n=== Admin > SBN ===");
            System.out.println("1. Tambah SBN");
            System.out.println("2. Kembali");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            if (pilih == 1) {
                System.out.print("Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Bunga (%): ");
                double bunga = scanner.nextDouble();
                System.out.print("Jangka Waktu (bulan): ");
                int waktu = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Tanggal Jatuh Tempo: ");
                String tempo = scanner.nextLine();
                System.out.print("Kuota Nasional: ");
                int kuota = scanner.nextInt();
                scanner.nextLine();

                daftarSBN.add(new SuratBerhargaNegara(nama, bunga, waktu, tempo, kuota));
                System.out.println("SBN berhasil ditambahkan.");
            } else {
                break;
            }
        }
    }

    static void menuCustomer(Customer customer) {
        while (true) {
            System.out.println("\n=== Menu Customer ===");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Portofolio");
            System.out.println("6. Logout");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            if (pilih == 1) {
                for (int i = 0; i < daftarSaham.size(); i++) {
                    Saham s = daftarSaham.get(i);
                    System.out.printf("%d. %s (%s) - Rp%.2f\n", i + 1, s.namaPerusahaan, s.kode, s.harga);
                }
                System.out.print("Pilih saham: ");
                int idx = scanner.nextInt() - 1;
                System.out.print("Jumlah lembar: ");
                int jumlah = scanner.nextInt();
                scanner.nextLine();
                customer.beliSaham(daftarSaham.get(idx), jumlah);
            } else if (pilih == 2) {
                int i = 1;
                for (Saham s : customer.sahamDimiliki.keySet()) {
                    System.out.printf("%d. %s (%s) - Dimiliki: %d\n", i++, s.namaPerusahaan, s.kode, customer.sahamDimiliki.get(s));
                }
                System.out.print("Pilih saham yang ingin dijual: ");
                int idx = scanner.nextInt();
                scanner.nextLine();
                Saham saham = (Saham) customer.sahamDimiliki.keySet().toArray()[idx - 1];
                System.out.print("Jumlah: ");
                int jumlah = scanner.nextInt();
                scanner.nextLine();
                customer.jualSaham(saham, jumlah);
            } else if (pilih == 3) {
                for (int i = 0; i < daftarSBN.size(); i++) {
                    SuratBerhargaNegara sbn = daftarSBN.get(i);
                    System.out.printf("%d. %s - Bunga: %.2f%% - Kuota: %d\n", i + 1, sbn.nama, sbn.bunga, sbn.kuotaNasional);
                }
                System.out.print("Pilih SBN: ");
                int idx = scanner.nextInt() - 1;
                System.out.print("Nominal pembelian: ");
                double nominal = scanner.nextDouble();
                scanner.nextLine();
                customer.beliSBN(daftarSBN.get(idx), nominal);
            } else if (pilih == 4) {
                for (SuratBerhargaNegara sbn : daftarSBN) {
                    System.out.printf("Nama: %s | Bunga: %.2f%%\n", sbn.nama, sbn.bunga);
                    System.out.print("Nominal simulasi: ");
                    double nominal = scanner.nextDouble();
                    scanner.nextLine();
                    double bungaBulanan = (sbn.bunga / 100 / 12) * 0.9 * nominal;
                    System.out.printf("Simulasi bunga per bulan: Rp%.2f\n", bungaBulanan);
                }
            } else if (pilih == 5) {
                customer.tampilkanPortofolio();
            } else {
                break;
            }
        }
    }
}