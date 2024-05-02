import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

interface PengelolaanData {
    void prosesData(int nomor);
}

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

public class App implements PengelolaanData {
    private static final ArrayList<MieInstan> dataMie = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║      Selamat datang di APLIKASI Warung Mie Indomie! ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Menu Pengelolaan Data");
            System.out.println("2. Keluar dari program");
            System.out.println("");
            System.out.print("Pilih menu: ");
            int menuUtama = getInputInteger();
            scanner.nextLine(); // Mengonsumsi karakter newline

            switch (menuUtama) {
                case 1:
                    menuPengelolaanData();
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

    // Implementasi dari interface PengelolaanData
    @Override
    public void prosesData(int nomor) {
        if (nomor < 1 || nomor > dataMie.size()) {
            System.out.println("Data tidak valid.");
        } else {
            // Implementasi proses pengelolaan data
            System.out.println("Data berhasil diproses.");
        }
    }

    private static void menuPengelolaanData() {
        boolean exitCRUD = false;
        while (!exitCRUD) {
            clearScreen(); // Membersihkan layar
            System.out.println("╔══════════════════╗");
            System.out.println("║  Menu Pengelolaan Data  ║");
            System.out.println("╚══════════════════╝");
            System.out.println("1. Tambah Data Mie Instan");
            System.out.println("2. Tampilkan Semua Data Mie Instan");
            System.out.println("3. Ubah Data Mie Instan");
            System.out.println("4. Hapus Data Mie Instan");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            int menuCRUD = getInputInteger();
            scanner.nextLine(); // Mengonsumsi karakter newline
            switch (menuCRUD) {
                case 1:
                    tambahDataMieInstan();
                    break;
                case 2:
                    tampilkanSemuaDataMieInstan();
                    break;
                case 3:
                    ubahDataMieInstan();
                    break;
                case 4:
                    hapusDataMieInstan();
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

    private static void tambahDataMieInstan() {
        System.out.println("Pilih jenis mie instan yang ingin ditambahkan:");
        System.out.println("1. Kuah");
        System.out.println("2. Goreng");
        System.out.print("Masukkan pilihan: ");
        int pilihan = getInputInteger();
        scanner.nextLine(); // Mengonsumsi karakter newline
        if (pilihan < 1 || pilihan > 2) {
            System.out.println("Pilihan tidak valid.");
            return;
        }
        System.out.print("Masukkan nama mie instan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan stok: ");
        int stok = getInputInteger();
        scanner.nextLine(); // Mengonsumsi karakter newline
        System.out.print("Masukkan harga: ");
        int harga = getInputInteger();
        scanner.nextLine(); // Mengonsumsi karakter newline
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
        System.out.println("Data mie instan berhasil ditambahkan.");
        scanner.nextLine(); // Mengonsumsi karakter newline
        System.out.println("Tekan Enter untuk kembali ke menu.");
        scanner.nextLine(); // Menunggu tekanan tombol Enter
    }

    private static void tampilkanSemuaDataMieInstan() {
        System.out.println("\t\t ╔══════════════════╗");
        System.out.println("\t\t ║   SEMUA DATA MENU ║");
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

    private static void ubahDataMieInstan() {
        tampilkanSemuaDataMieInstan();
        System.out.print("Masukkan nomor data mie instan yang ingin diubah: ");
        int nomor = getInputInteger();
        scanner.nextLine(); // Mengonsumsi karakter newline
        if (nomor < 1 || nomor > dataMie.size()) {
            System.out.println("Nomor data mie instan tidak valid.");
            return;
        }
        MieInstan mie = dataMie.get(nomor - 1);
        System.out.print("Masukkan stok baru: ");
        int stok = getInputInteger();
        scanner.nextLine(); // Mengonsumsi karakter newline
        mie.setStok(stok);

        System.out.println("Data berhasil diubah.");
        scanner.nextLine(); // Mengonsumsi karakter newline
        System.out.println("Tekan Enter untuk kembali ke menu.");
        scanner.nextLine(); // Menunggu tekanan tombol Enter
    }

    private static void hapusDataMieInstan() {
        tampilkanSemuaDataMieInstan();
        System.out.print("Masukkan nomor data mie instan yang ingin dihapus: ");
        int nomor = getInputInteger();
        scanner.nextLine(); // Mengonsumsi karakter newline
        if (nomor < 1 || nomor > dataMie.size()) {
            System.out.println("Nomor data mie instan tidak valid.");
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
            handleException(e);
        }
    }

    // Metode static untuk penanganan kesalahan
    public static void handleException(Exception e) {
        System.out.println("Terjadi kesalahan: " + e.getMessage());
    }

    // Method untuk mendapatkan input integer yang valid
    private static int getInputInteger() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                System.out.print("Silakan masukkan kembali: ");
            }
        }
    }
}
