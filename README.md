# PBO-Tugas-1
Pembuatan Program Investasi.java.Investasi Sederhana Berbasis Command Line

![MenuPertama.png](image/MenuPertama.png)

Diawal user menggunakan program investasi ini akan memunculkan menu yang memiliki pilihan
login, registrasi (untuk membuat akun user), dan exit

![gagalLogin.png](image/gagalLogin.png)

Jika user memilih pilihan 1 yakni login, program akan menampilkan username dan password yang
nantinya user akan memasukkan username dan password yang sudah dibuat pada menu registrasi.
Ketika user salah memasukkan username atau password maka user akan gagal melakukan login

![MenuRegist.png](image/MenuRegist.png)

Jika user memilih pilhan 2 yakni register, maka user akan membuat sebuah akun dan diminta 
input beberapa data seperti username dan password. Program akan menampilkan 
"Registrasi berhasil. Silakan login." jika akun berhasil dibuat

![menuPilihan.png](image/menuPilihan.png)

Saat user merhasil melakukan login pada menu login, selanjutnya program akan menampilkan 
beberapa menu investasi seperti beli saham, jual saham, beli sbn, simulasi sbn, portofolio,
dan logout.

![PembelianSaham.png](image/PembelianSaham.png)

Pada menu ini user akan diminta untuk memilih saham apa yang akan dibeli lalu setelah memilih 
saham pada pilihan user akan dimita berapa banyak lembar saham yang nantinya akan dibeli
tanpa terjadi eror atau invalid dalam melakukan pembelian saham

![invalidBeliSaham.png](image/invalidBeliSaham.png)

Pada tampilan ini merupakan ketika user invalid atau salah dalam pembelian saham. Yang dimana
user yang seharusnya input sesua dengan pilihan malah memilih yang tidak ada di dalam pilihan
menu, kemudian program akan meminta user untuk input sesuai dengan apa yang diminta pada program
sampai sesuai dengan apa yang tertera pada program atau sampai valid dalam pembelian saham

![JualSaham.png](image/JualSaham.png)

User pun bisa melakukan penjualan saham, menu ini merupakan menu penjualan saham yang dapat dijual oleh
user. Program pun menampilkan saham apa saja yang dapat dipilih dan dijual, user tidak bisa menjual saham
yang tidak dimiliki dan menjual lebih dari yang dimiliki oleh user

![BeliSBN.png](image/BeliSBN.png)

Jika user memilih pilihan 3 atau beli SBN, user akan diminta untuk memilih SBN apa yang akan 
dibeli lengkap dengan bunganya lalu setelah memilih SBN pada pilihan user akan dimita berapa 
banyak nominal SBN yang nantinya akan dibeli tanpa terjadi eror atau invalid dalam melakukan pembelian SBN

![InvalidSBN.png](image/InvalidSBN.png)

Sama seperti kasus validasi sebelumnya jika user membeli yang bukan atau tidak ada yang ada pada pilihan
maka user akan diminta lagi untuk input pilihan sampai pilihan user ada atau benar

![SimulasiSBN.png](image/SimulasiSBN.png)

Pada menu ini merupakan sebuah simulasi dari jika user ingin membeli SBN. Seperti seberapa besar bunga
yang akan dibayarkan jika user membeli sbn tersebut dan tentunya sudah terdapat validasi input

![Portofolio.png](image/Portofolio.png)

User juga dapat melihat saham dan SNB yang dimiliki dengan memilih menu portofolio. Pada menu ini
program akan menampilkan saham dan SNB yang dimiliki user, nilai pasar dari saham beserta bunga SNB

![Logout.png](image/Logout.png)

Ini merupakan tampilan menu jika user memilih untuk logout, setelah user logout user akan dikembalikan
pada menu pilihan pertama dan user bisa kembali membuat akun, login, ataupun exit.
Jika user memilih untuk exit maka program akan berhenti beroprasi
