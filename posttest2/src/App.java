import java.util.ArrayList;
import java.util.Scanner;

class MieInstan {
    private String nama; // menggunakan access modifier private
    protected int stok; // Menggunakan access modifier protected
    public int harga; // Menggunakan access modifier public

    public MieInstan(String nama, int stok, int harga) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    // Getter dan setter untuk variabel nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan setter untuk variabel stok
    protected int getStok() {
        return stok;
    }

    protected void setStok(int stok) {
        this.stok = stok;
    }

    // Getter dan setter untuk variabel harga
    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}

public class App {
    private static ArrayList<MieInstan> dataMie = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Program dimulai di sini
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║        Selamat datang di SISTEM Warung Mie Indomie!       ║");
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
                    System.out.println("\t\t\tTerima Kasih dan Sampai Jumpa ^_^");
                    System.out.println("\t\t\t----------------------------------");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
                    break;
            }
        }
        // Program berakhir di sini
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
        System.out.print("Masukkan nama mie instan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan stok: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan harga: ");
        int harga = scanner.nextInt();

        MieInstan mieBaru = new MieInstan(nama, stok, harga);
        dataMie.add(mieBaru);
        System.out.println("Mie instan berhasil ditambahkan.");
        scanner.nextLine(); // Mengonsumsi karakter newline
        System.out.println("Tekan Enter untuk kembali ke menu.");
        scanner.nextLine(); // Menunggu tekanan tombol Enter
    }

    private static void tampilkanSemuaMieInstan() {
        System.out.println("\t\t  ╔══════════════════╗");
        System.out.println("\t\t  ║     DATA MENU    ║");
        System.out.println("\t\t  ╚══════════════════╝");
        System.out.println("\n╔═════════════════════════════════════════════════════╗");
        System.out.println("║   NO    ║        Nama         ║   Stok  ║   Harga   ║ ");
        System.out.println("╚═════════════════════════════════════════════════════╝");
        if (dataMie.isEmpty()) {
            System.out.println("Tidak ada data.");
        } else {
            int jumlahData = dataMie.size();
            int maksimumBarisPerTampilan = 10; // Misalnya, maksimum 10 baris per tampilan
            for (int i = 0; i < jumlahData; i++) {
                MieInstan mie = dataMie.get(i);
                System.out.printf("║%-8d ║ %-20s║ %-8d║ %-8d  ║\n", i + 1, mie.getNama(), mie.getStok(), mie.getHarga());
    
                // Jika sudah mencapai batas maksimum baris per tampilan atau sudah mencapai akhir data, tampilkan pesan dan tunggu pengguna menekan Enter
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
        System.out.print("Masukkan stok baru: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan harga baru: ");
        int harga = scanner.nextInt();
        mie.setStok(stok);
        mie.setHarga(harga);
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
