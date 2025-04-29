# PBO-Tugas-1
Pembuatan Program Investasi Sederhana Berbasis Command Line

![alt text](MenuPertama.png)
 Diawal user menggunakan program investasi ini akan memunculkan menu yang memiliki pilihan
 login, registrasi (untuk membuat akun), dan exit.

![alt text](gagalLogin.png)
 Jika user memilih pilihan 1 yakni login, program akan menampilkan username dan password yang
 nantinya user akan memasukkan username dan password yang sudah dibuat pada menu registrasi.
 Ketika user salah memasukkan username atau password maka user akan gagal melakukan login

![alt text](MenuRegist.png)
 Jika user memilih pilhan 2 yakni register, maka user akan membuat sebuah akun dan diminta 
 input beberapa data seperti username dan password. Program akan menampilkan 
 "Registrasi berhasil. Silakan login." jika akun berhasil dibuat

![alt text](menuPilihan.png)
Saat user merhasil melakukan login pada menu login, selanjutnya program akan menampilkan 
beberapa menu investasi seperti beli saham, jual saham, beli sbn, simulasi sbn, portofolio,
dan logout.

![alt text](PembelianSaham.png)
Pada menu ini user akan diminta untuk memilih saham apa yang akan dibeli lalu setelah memilih 
saham pada pilihan user akan dimita berapa banyak lembar saham yang nantinya akan dibeli
tanpa terjadi eror atau invalid dalam melakukan pembelian saham

![alt text](invalidBeliSaham.png)
Pada tampilan ini merupakan ketika user invalid atau salah dalam pembelian saham. Yang dimana
user yang seharusnya input sesua dengan pilihan malah memilih yang tidak ada di dalam pilihan
menu, kemudian program akan meminta user untuk input sesuai dengan apa yang diminta pada program
sampai sesuai dengan apa yang tertera pada program atau sampai valid dalam pembelian saham

![alt text](JualSaham-2.png)
User pun bisa melakukan penjualan saham, menu ini merupakan menu penjualan saham yang dapat dijual oleh
user. Program pun menampilkan saham apa saja yang dapat dipilih dan dijual, user tidak bisa menjual saham
yang tidak dimiliki dan menjual lebih dari yang dimiliki oleh user

![alt text](BeliSBN.png)
Jika user memilih pilihan 3 atau beli SBN, user akan diminta untuk memilih SBN apa yang akan 
dibeli lengkap dengan bunganya lalu setelah memilih SBN pada pilihan user akan dimita berapa 
banyak nominal SBN yang nantinya akan dibeli tanpa terjadi eror atau invalid dalam melakukan pembelian SBN

![alt text](InvalidSBN.png)
Sama seperti kasus validasi sebelumnya jika user membeli yang bukan atau tidak ada yang ada pada pilihan
maka user akan diminta lagi untuk input pilihan sampai pilihan user ada atau benar




=== Menu Customer ===
1. Beli Saham
2. Jual Saham
3. Beli SBN
4. Simulasi SBN
5. Portofolio
6. Logout
Pilih: 2
1. Alphabet Inc. (GOOGL) - Dimiliki: 10000
Pilih saham yang ingin dijual: 1
Jumlah: 5000

=== Menu Customer ===
1. Beli Saham
2. Jual Saham
3. Beli SBN
4. Simulasi SBN
5. Portofolio
6. Logout
Pilih: 5
Portofolio Saham:
Saham: Alphabet Inc. | Kode: GOOGL | Jumlah: 5000 | Nilai Pasar: Rp14000000,00

Portofolio SBN:

=== Menu Customer ===
1. Beli Saham
2. Jual Saham
3. Beli SBN
4. Simulasi SBN
5. Portofolio
6. Logout
Pilih: 3
1. SBN1 - Bunga: 5,00% - Kuota: 1000000
Pilih SBN: 1
Nominal pembelian: 10000

=== Menu Customer ===
1. Beli Saham
2. Jual Saham
3. Beli SBN
4. Simulasi SBN
5. Portofolio
6. Logout
Pilih: 5
Portofolio Saham:
Saham: Alphabet Inc. | Kode: GOOGL | Jumlah: 5000 | Nilai Pasar: Rp14000000,00

 Portofolio SBN:
SBN: SBN1 | Nominal: Rp10000,00 | Bunga/Bulan: Rp37,50

=== Menu Customer ===
1. Beli Saham
2. Jual Saham
3. Beli SBN
4. Simulasi SBN
5. Portofolio
6. Logout
Pilih: 4
Nama: SBN1 | Bunga: 5,00%
Nominal simulasi: 1000
Simulasi bunga per bulan: Rp3,75

=== Menu Customer ===
1. Beli Saham
2. Jual Saham
3. Beli SBN
4. Simulasi SBN
5. Portofolio
6. Logout
Pilih: 6

=== Menu Awal ===
1. Login
2. Register (Customer)
3. Exit
Pilih: 