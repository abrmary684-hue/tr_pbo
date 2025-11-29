import java.util.List;
import java.util.Scanner;

public class UserHasilStudi {
    private List<Mahasiswa> mahasiswaList; // Asumsi ini dari sistem utama
    private Scanner scanner;

    public UserHasilStudi(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        this.scanner = new Scanner(System.in);
    }

    // Menu untuk Mahasiswa melihat hasil studi
    public void menuUserHasilStudi() {
        System.out.print("Masukkan NIM Anda: ");
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