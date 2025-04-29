import java.util.*;

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
            int pilihan = inputAngka(1, 3);

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
            int pilih = inputAngka(1, 3);

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
            int pilih = inputAngka(1, 3);

            if (pilih == 1) {
                System.out.print("Kode Saham: ");
                String kode = scanner.nextLine();
                System.out.print("Nama Perusahaan: ");
                String nama = scanner.nextLine();
                System.out.print("Harga: ");
                double harga = inputDouble();
                daftarSaham.add(new Saham(kode, nama, harga));
                System.out.println("Saham berhasil ditambahkan.");
            } else if (pilih == 2) {
                for (int i = 0; i < daftarSaham.size(); i++) {
                    System.out.printf("%d. %s (%s) - Rp%.2f\n", i + 1, daftarSaham.get(i).namaPerusahaan, daftarSaham.get(i).kode, daftarSaham.get(i).harga);
                }
                System.out.print("Pilih nomor saham: ");
                int idx = inputAngka(1, daftarSaham.size()) - 1;
                System.out.print("Harga baru: ");
                double hargaBaru = inputDouble();
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
            int pilih = inputAngka(1, 2);

            if (pilih == 1) {
                System.out.print("Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Bunga (%): ");
                double bunga = inputDouble();
                System.out.print("Jangka Waktu (bulan): ");
                int waktu = inputAngka(1, 1200);
                System.out.print("Tanggal Jatuh Tempo: ");
                String tempo = scanner.nextLine();
                System.out.print("Kuota Nasional: ");
                int kuota = inputAngka(1, Integer.MAX_VALUE);
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
            int pilih = inputAngka(1, 6);

            if (pilih == 1) {
                if (daftarSaham.isEmpty()) {
                    System.out.println("Tidak ada saham tersedia.");
                    continue;
                }
                for (int i = 0; i < daftarSaham.size(); i++) {
                    Saham s = daftarSaham.get(i);
                    System.out.printf("%d. %s (%s) - Rp%.2f\n", i + 1, s.namaPerusahaan, s.kode, s.harga);
                }
                System.out.print("Pilih saham: ");
                int idx = inputAngka(1, daftarSaham.size()) - 1;
                System.out.print("Jumlah lembar: ");
                int jumlah = inputAngka(1, Integer.MAX_VALUE);
                customer.beliSaham(daftarSaham.get(idx), jumlah);
            } else if (pilih == 2) {
                if (customer.sahamDimiliki.isEmpty()) {
                    System.out.println("Anda tidak memiliki saham.");
                    continue;
                }
                int i = 1;
                List<Saham> daftarSahamDimiliki = new ArrayList<>(customer.sahamDimiliki.keySet());
                for (Saham s : daftarSahamDimiliki) {
                    System.out.printf("%d. %s (%s) - Dimiliki: %d\n", i++, s.namaPerusahaan, s.kode, customer.sahamDimiliki.get(s));
                }
                int idx = inputAngka(1, daftarSahamDimiliki.size()) - 1;
                Saham saham = daftarSahamDimiliki.get(idx);
                System.out.print("Jumlah saham yang ingin dijual: ");
                int jumlah = inputAngka(1, Integer.MAX_VALUE);
                customer.jualSaham(saham, jumlah);
            } else if (pilih == 3) {
                if (daftarSBN.isEmpty()) {
                    System.out.println("Tidak ada SBN tersedia.");
                    continue;
                }
                for (int i = 0; i < daftarSBN.size(); i++) {
                    SuratBerhargaNegara sbn = daftarSBN.get(i);
                    System.out.printf("%d. %s - Bunga: %.2f%% - Kuota: %d\n", i + 1, sbn.nama, sbn.bunga, sbn.kuotaNasional);
                }
                System.out.print("Pilih SBN: ");
                int idx = inputAngka(1, daftarSBN.size()) - 1;
                System.out.print("Nominal pembelian: ");
                double nominal = inputDouble();
                customer.beliSBN(daftarSBN.get(idx), nominal);
            } else if (pilih == 4) {
                for (SuratBerhargaNegara sbn : daftarSBN) {
                    System.out.printf("Nama: %s | Bunga: %.2f%%\n", sbn.nama, sbn.bunga);
                    System.out.print("Nominal simulasi: ");
                    double nominal = inputDouble();
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

    static int inputAngka(int min, int max) {
        int angka;
        while (true) {
            try {
                angka = scanner.nextInt();
                scanner.nextLine();
                if (angka >= min && angka <= max) {
                    return angka;
                } else {
                    System.out.print("Input harus antara " + min + " dan " + max + ". Coba lagi: ");
                }
            } catch (Exception e) {
                System.out.print("Input harus angka. Coba lagi: ");
                scanner.nextLine();
            }
        }
    }

    static double inputDouble() {
        double angka;
        while (true) {
            try {
                angka = scanner.nextDouble();
                scanner.nextLine();
                return angka;
            } catch (Exception e) {
                System.out.print("Input harus angka desimal. Coba lagi: ");
                scanner.nextLine();
            }
        }
    }
}
