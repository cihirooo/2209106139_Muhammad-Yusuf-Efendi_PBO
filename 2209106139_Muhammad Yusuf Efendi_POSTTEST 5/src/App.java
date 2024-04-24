import java.util.ArrayList;
import java.util.Scanner;

abstract class MieInstan {
    private final String nama;
    protected int stok;
    public final int harga;

    public MieInstan(String nama, int stok, int harga) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    protected void setStok(int stok) {
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    // Metode abstrak untuk kelas abstrak
    public abstract void tampilkanInfo();
}

class MieInstanRasaAyam extends MieInstan {
    public MieInstanRasaAyam(String nama, int stok, int harga) {
        super(nama, stok, harga);
    }

    // Implementasi metode abstrak dari kelas induk
    @Override
    public void tampilkanInfo() {
        System.out.println("Mie Instan Rasa Ayam");
        System.out.println("Nama: " + getNama());
        System.out.println("Stok: " + stok);
        System.out.println("Harga: " + harga);
    }
}

class MieInstanRasaSoto extends MieInstan {
    public MieInstanRasaSoto(String nama, int stok, int harga) {
        super(nama, stok, harga);
    }

    // Implementasi metode abstrak dari kelas induk
    @Override
    public void tampilkanInfo() {
        System.out.println("Mie Instan Rasa Soto");
        System.out.println("Nama: " + getNama());
        System.out.println("Stok: " + stok);
        System.out.println("Harga: " + harga);
    }
}
public class App {
    private static final ArrayList<MieInstan> dataMie = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║      Selamat datang di SISTEM Warung Mie Indomie!         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Menu CRUD");
            System.out.println("2. Keluar dari program");
            System.out.println("");
            System.out.print("Pilih menu: ");
            int menuUtama = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi karakter newline

            switch (menuUtama) {
                case 1:
                    menuCRUD();
                    break;
                case 2:
                    exit = true;
                    clearScreen(); // Membersihkan layar
                    System.out.println("");
                    System.out.println("\t\t\t----------------------------------");
                    System.out.println("\t\t\tTerima Kasih dan Sampai Jumpa^_^");
                    System.out.println("\t\t\t----------------------------------");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
                    break;
            }
        }
    }

    private static void menuCRUD() {
        boolean exitCRUD = false;
        while (!exitCRUD) {
            clearScreen(); // Membersihkan layar
            System.out.println("╔══════════════════╗");
            System.out.println("║       CRUD       ║");
            System.out.println("╚══════════════════╝");
            System.out.println("1. Tambah Mie Instan");
            System.out.println("2. Tampilkan Semua Mie Instan");
            System.out.println("3. Ubah Mie Instan");
            System.out.println("4. Hapus Mie Instan");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            int menuCRUD = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi karakter newline
            switch (menuCRUD) {
                case 1:
                    tambahMieInstan();
                    break;
                case 2:
                    tampilkanSemuaMieInstan();
                    break;
                case 3:
                    ubahMieInstan();
                    break;
                case 4:
                    hapusMieInstan();
                    break;
                case 5:
                    exitCRUD = true;
                    clearScreen(); // Membersihkan layar
                    break;
                default:
                    System.out.println("Menu tidak valid.");
                    break;
            }
        }
    }
    private static void tambahMieInstan() {
        System.out.println("Pilih jenis mie instan yang ingin ditambahkan:");
        System.out.println("1. Mie Instan Rasa Ayam");
        System.out.println("2. Mie Instan Rasa Soto");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Mengonsumsi karakter newline
        System.out.print("Masukkan nama mie instan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan stok: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan harga: ");
        int harga = scanner.nextInt();
        switch (pilihan) {
            case 1:
                MieInstanRasaAyam mieAyamBaru = new MieInstanRasaAyam(nama, stok, harga);
                dataMie.add(mieAyamBaru);
                break;
            case 2:
                MieInstanRasaSoto mieSotoBaru = new MieInstanRasaSoto(nama, stok, harga);
                dataMie.add(mieSotoBaru);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
        System.out.println("Mie instan berhasil ditambahkan.");
        scanner.nextLine(); // Mengonsumsi karakter newline
        System.out.println("Tekan Enter untuk kembali ke menu.");
        scanner.nextLine(); // Menunggu tekanan tombol Enter
    }

    private static void tampilkanSemuaMieInstan() {
        System.out.println("\t\t ╔══════════════════╗");
        System.out.println("\t\t ║    DATA MENU     ║");
        System.out.println("\t\t ╚══════════════════╝");
        System.out.println("\n╔═════════════════════════════════════════════════════════╗");
        System.out.println("║ NO       ║ Nama               ║ Stok         ║ Harga      ║ ");
        System.out.println("╚═════════════════════════════════════════════════════════╝");
        if (dataMie.isEmpty()) {
            System.out.println("Tidak ada data.");
        } else {
            int jumlahData = dataMie.size();
            int maksimumBarisPerTampilan = 10; // Misalnya, maksimum 10 baris per tampilan
            for (int i = 0; i < jumlahData; i++) {
                MieInstan mie = dataMie.get(i);
                System.out.printf("║%-8d ║ %-20s║ %-8d║ %-8d ║\n", i + 1, mie.getNama(), mie.stok, mie.getHarga());
                if ((i + 1) % maksimumBarisPerTampilan == 0 || i == jumlahData - 1) {
                    System.out.println("");
                    System.out.println("Tekan Enter untuk melanjutkan..");
                    System.out.println("-------------------------------");
                    scanner.nextLine(); // Tunggu pengguna menekan Enter
                }
            }
        }
    }

    private static void ubahMieInstan() {
        tampilkanSemuaMieInstan();
        System.out.print("Masukkan nomor mie instan yang ingin diubah: ");
        int nomor = scanner.nextInt();
        scanner.nextLine(); // Mengonsumsi karakter newline
        if (nomor < 1 || nomor > dataMie.size()) {
            System.out.println("Nomor mie instan tidak valid.");
            return;
        }
        MieInstan mie = dataMie.get(nomor - 1);
        if (mie instanceof MieInstanRasaAyam) {
            MieInstanRasaAyam mieAyam = (MieInstanRasaAyam) mie;
            System.out.print("Masukkan stok baru: ");
            int stok = scanner.nextInt();
            mieAyam.setStok(stok);
        } else if (mie instanceof MieInstanRasaSoto) {
            MieInstanRasaSoto mieSoto = (MieInstanRasaSoto) mie;
            System.out.print("Masukkan stok baru: ");
            int stok = scanner.nextInt();
            mieSoto.setStok(stok);
        }
        
        System.out.println("Data berhasil diubah.");
        scanner.nextLine(); // Mengonsumsi karakter newline
        System.out.println("Tekan Enter untuk kembali ke menu.");
        scanner.nextLine(); // Menunggu tekanan tombol Enter
    }

    private static void hapusMieInstan() {
        tampilkanSemuaMieInstan();
        System.out.print("Masukkan nomor mie instan yang ingin dihapus: ");
        int nomor = scanner.nextInt();
        scanner.nextLine(); // Mengonsumsi karakter newline
        if (nomor < 1 || nomor > dataMie.size()) {
            System.out.println("Nomor mie instan tidak valid.");
            return;
        }
        dataMie.remove(nomor - 1);
        System.out.println("Data berhasil dihapus.");
        scanner.nextLine(); // Mengonsumsi karakter newline
        System.out.println("Tekan Enter untuk kembali ke menu.");
        scanner.nextLine(); // Menunggu tekanan tombol Enter
    }

    // Method untuk membersihkan layar
    private static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
