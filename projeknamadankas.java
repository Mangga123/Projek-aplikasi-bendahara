import javax.swing.JOptionPane;

public class projeknamadankas {
    private static String[] namaSiswa;
    private static int[] kasSiswa;
    private static int jumlahSiswa;

    public static void main(String[] args) {
        inputJumlahSiswa();
        inputNamaSiswa();
        menuPembayaran();
    }

    private static void inputJumlahSiswa() {
        String jumlah = JOptionPane.showInputDialog("Masukkan jumlah siswa di kelas:");
        jumlahSiswa = Integer.parseInt(jumlah);
        namaSiswa = new String[jumlahSiswa];
        kasSiswa = new int[jumlahSiswa];
    }

    private static void inputNamaSiswa() {
        for (int i = 0; i < jumlahSiswa; i++) {
            namaSiswa[i] = JOptionPane.showInputDialog("Masukkan nama siswa ke-" + (i + 1) + ":");
        }
    }

    private static void menuPembayaran() {
        while (true) {
            String opsi = JOptionPane.showInputDialog(null,
                "=== Menu Pembayaran Kas ===\n" +
                "1. Tambah Pembayaran Kas\n" +
                "2. Lihat Total Kas Siswa\n" +
                "3. Keluar\n" +
                "Pilih opsi:", 
                "Menu Pembayaran Kas", 
                JOptionPane.QUESTION_MESSAGE);
            
            if (opsi == null) break; // Tutup dialog jika tekan cancel

            switch (opsi) {
                case "1":
                    tambahPembayaran();
                    break;
                case "2":
                    lihatTotalKas();
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Program selesai.");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tambahPembayaran() {
        String nama = JOptionPane.showInputDialog("Masukkan nama siswa:");
        if (nama == null) return; // Tutup dialog jika tekan cancel

        boolean ditemukan = false;
        for (int i = 0; i < jumlahSiswa; i++) {
            if (namaSiswa[i].equalsIgnoreCase(nama)) {
                String pembayaran = JOptionPane.showInputDialog("Masukkan nominal pembayaran:");
                if (pembayaran == null) return;
                kasSiswa[i] += Integer.parseInt(pembayaran);
                JOptionPane.showMessageDialog(null, "Pembayaran berhasil ditambahkan.");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            JOptionPane.showMessageDialog(null, "Nama siswa tidak ditemukan.");
        }
    }

    private static void lihatTotalKas() {
        StringBuilder message = new StringBuilder("Total kas setiap siswa:\n");
        for (int i = 0; i < jumlahSiswa; i++) {
            message.append("Nama: ").append(namaSiswa[i]).append(", Total Kas: ").append(kasSiswa[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString(), "Total Kas Siswa", JOptionPane.INFORMATION_MESSAGE);
    }
}
