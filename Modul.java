import java.util.Scanner;

public class Modul{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);



        // Input jumlah siswa

        System.out.print("Masukkan jumlah siswa di kelas: ");

        int jumlahSiswa = input.nextInt();

        input.nextLine(); // membersihkan newline dari input sebelumnya



        String[] namaSiswa = new String[jumlahSiswa];

        int[] kasSiswa = new int[jumlahSiswa];



        System.out.println("Masukkan nama siswa:");

        for (int i = 0; i < jumlahSiswa; i++) {

            System.out.print("Nama siswa ke-" + (i + 1) + ": ");

            namaSiswa[i] = input.nextLine();

        }



        while (true) {

            System.out.println("\n=== Menu Pembayaran Kas ===");

            System.out.println("1. Tambah Pembayaran Kas");

            System.out.println("2. Lihat Total Kas Siswa");

            System.out.println("3. Keluar");

            System.out.print("Pilih opsi: ");

            int opsi = input.nextInt();

            input.nextLine();



            if (opsi == 1) {

                // Menambahkan pembayaran kas

                System.out.print("Masukkan nama siswa: ");

                String nama = input.nextLine();



                // Mencari nama siswa di array

                boolean ditemukan = false;

                for (int i = 0; i < jumlahSiswa; i++) {

                    if (namaSiswa[i].equals(nama)) {

                        System.out.print("Masukkan nominal pembayaran: ");

                        int pembayaran = input.nextInt();

                        input.nextLine(); // membersihkan newline dari input sebelumnya

                        kasSiswa[i] += pembayaran;

                        System.out.println("Pembayaran berhasil ditambahkan.");

                        ditemukan = true;

                        break;

                    }

                }



                if (!ditemukan) {

                    System.out.println("Nama siswa tidak ditemukan.");

                }

            } else if (opsi == 2) {

                // Menampilkan total kas tiap siswa

                System.out.println("\nTotal kas setiap siswa:");

                for (int i = 0; i < jumlahSiswa; i++) {

                    System.out.println("Nama: " + namaSiswa[i] + ", Total Kas: " + kasSiswa[i]);

                    

                }

                System.out.println("Tekan *Enter* untuk kemabli ke Menu");

                input.nextLine();

            } else if (opsi == 3) {

                // Keluar dari program

                System.out.println("Program selesai.");

                break;

            } else {

                System.out.println("Opsi tidak valid. Silakan coba lagi.");

            }

        }



        input.close();

    }

}
