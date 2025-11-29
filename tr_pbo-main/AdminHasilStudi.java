import java.util.List;
import java.util.Scanner;

public class AdminHasilStudi {
    private List<Mahasiswa> mahasiswaList; // Asumsi ini dari sistem utama
    private Scanner scanner;

    public AdminHasilStudi(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        this.scanner = new Scanner(System.in);
    }

    // Menu untuk Admin mengelola hasil studi
    public void menuAdminHasilStudi() {
        while (true) {
            System.out.println("\n=== Menu Admin - Hasil Studi ===");
            System.out.println("1. Tambah Mata Kuliah ke Mahasiswa (dengan nilai)");
            System.out.println("2. Lihat Hasil Studi Mahasiswa");
            System.out.println("3. Kembali");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahMataKuliahDenganNilai();
                    break;
                case 2:
                    lihatHasilStudiMahasiswa();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Tambah mata kuliah dengan nilai ke mahasiswa
    private void tambahMataKuliahDenganNilai() {
        System.out.print("NIM Mahasiswa: ");
        String nim = scanner.nextLine();
        for (Mahasiswa m : mahasiswaList) {
            if (m.getNim().equals(nim)) {
                System.out.print("Kode Mata Kuliah: ");
                String kode = scanner.nextLine();
                System.out.print("Nama Mata Kuliah: ");
                String namaMk = scanner.nextLine();
                System.out.print("Kredit: ");
                int kredit = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nilai Huruf: ");
                String nilai = scanner.nextLine();
                m.tambahMataKuliah(kode, namaMk, kredit, nilai);
                System.out.println("Mata kuliah berhasil ditambahkan ke hasil studi mahasiswa " + m.getNama());
                return;
            }
        }
        System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
    }

    // Lihat hasil studi mahasiswa (untuk verifikasi admin)
    private void lihatHasilStudiMahasiswa() {
        System.out.print("NIM Mahasiswa: ");
        String nim = scanner.nextLine();
        for (Mahasiswa m : mahasiswaList) {
            if (m.getNim().equals(nim)) {
                m.cetakHasilStudi();
                return;
            }
        }
        System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
    }
}