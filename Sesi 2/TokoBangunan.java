package praktikum.Tugas;
import java.util.Scanner;
import java.util.ArrayList;

class DataBarang {
    String namaBarang;
    String jenisBarang;
    int hargaBarang;

    public DataBarang(String namaBarang, String jenisBarang, int hargaBarang) {
        this.namaBarang = namaBarang;
        this.jenisBarang = jenisBarang;
        this.hargaBarang = hargaBarang;
    }
}

public class TokoBangunan {
    static Scanner scanner = new Scanner(System.in);
    static final String RESET = "\u001B[0m";
    static final String BOLD = "\u001B[1m";
    static final String NEON_RED = "\u001B[38;2;255;0;0m";
    static final String NEON_GREEN = "\u001B[38;2;57;255;20m";
    static final String LIGHT_BROWN = "\u001B[38;2;210;180;140m";
    static final String GOLD = "\u001B[38;2;255;215;0m";

    static void displayJenisBarang() {
        System.out.println();
        System.out.println(BOLD + "=====[ " + LIGHT_BROWN + "Jenis Barang" + RESET + BOLD + " ]=====" + RESET);
        System.out.println(BOLD + "1" + RESET + ". Material Konstruksi");
        System.out.println(BOLD + "2" + RESET + ". Kayu dan Produk Kayu");
        System.out.println(BOLD + "3" + RESET + ". Perlengkapan Plumbing");
        System.out.println(BOLD + "4" + RESET + ". Perlengkapan Listrik");
        System.out.println(BOLD + "5" + RESET + ". Perlengkapan Finishing");
        System.out.println(BOLD + "6" + RESET + ". Alat Kerja");
    }

    static String getJenisBarang(int choice) {
        switch (choice) {
            case 1:
                return "Material Konstruksi";
            case 2:
                return "Kayu dan Produk Kayu";
            case 3:
                return "Perlengkapan Plumbing";
            case 4:
                return "Perlengkapan Listrik";
            case 5:
                return "Perlengkapan Finishing";
            case 6:
                return "Alat Kerja";
            default:
                return "Jenis tidak valid";
        }
    }

    static void addData(ArrayList<DataBarang> data) {
        System.out.println(BOLD + "\n=====[ " + LIGHT_BROWN + "Input Barang" + RESET + BOLD + " ]=====" + RESET);
        System.out.print(BOLD + "Masukan nama barang : " + RESET);
        String namaBarang = scanner.nextLine();

        displayJenisBarang();
        System.out.print(BOLD + "Masukan pilihan jenis barang (1-6) : " + RESET);
        int jenisChoice = scanner.nextInt();
        scanner.nextLine();
        String jenisBarang = getJenisBarang(jenisChoice);

        System.out.print(BOLD + "Masukan harga : " + RESET);
        int hargaBarang = scanner.nextInt();
        scanner.nextLine();

        if (jenisChoice < 1 || jenisChoice > 6 || hargaBarang <= 0) {
            System.out.println(BOLD + NEON_RED + "\nInput tidak valid! Pastikan jenis barang (1-6) dan harga barang positif." + RESET);
            return;
        }

        data.add(new DataBarang(namaBarang, jenisBarang, hargaBarang));
        System.out.println(BOLD + NEON_GREEN + "\nData berhasil ditambahkan!" + RESET);
    }

    static void displayData(ArrayList<DataBarang> data) {
        if (data.isEmpty()) {
            System.out.println(BOLD + NEON_RED + "\nTidak ada data tersedia!" + RESET);
            return;
        }

        System.out.println(BOLD + "\n======[ " + LIGHT_BROWN + "Data Barang" + RESET + BOLD + " ]======");
        for (int i = 0; i < data.size(); i++) {
            System.out.println("Index: " + (i + 1));
            System.out.println("Nama Barang  : " + data.get(i).namaBarang);
            System.out.println("Jenis Barang : " + data.get(i).jenisBarang);
            System.out.println("Harga Barang : Rp." + data.get(i).hargaBarang);
            System.out.println("-----------------------------");
        }
    }

    static void updateData(ArrayList<DataBarang> data) {
        displayData(data);

        System.out.print(BOLD + "Masukan index data yang ingin diubah: " + RESET);
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > data.size()) {
            System.out.println(BOLD + "\nIndeks tidak valid! Perubahan data gagal." + RESET);
            return;
        }

        System.out.println(BOLD + "========[ " + GOLD + "Data Exchange" + RESET + BOLD + " ]========" + RESET);
        System.out.println(BOLD + "Nama Barang  : " + RESET + data.get(index - 1).namaBarang);
        System.out.println(BOLD + "Jenis Barang : " + RESET + data.get(index - 1).jenisBarang);
        System.out.println(BOLD + "Harga Barang : " + RESET + data.get(index - 1).hargaBarang);

        displayJenisBarang();
        System.out.print(BOLD + "Masukan pilihan jenis barang baru : " + RESET);
        int jenisChoice = scanner.nextInt();
        scanner.nextLine();
        data.get(index - 1).jenisBarang = getJenisBarang(jenisChoice);

        System.out.print(BOLD + "Masukan harga barang baru : " + RESET);
        data.get(index - 1).hargaBarang = scanner.nextInt();
        scanner.nextLine();

        System.out.println(BOLD + NEON_GREEN + "\nData berhasil diubah!" + RESET);
    }

    static void deleteData(ArrayList<DataBarang> data) {
        displayData(data);

        System.out.print("Masukan index data yang ingin dihapus: ");
        int index = scanner.nextInt();

        if (index < 1 || index > data.size()) {
            System.out.println(BOLD + NEON_RED + "\nIndeks tidak valid! Penghapusan data gagal." + RESET);
            return;
        }

        data.remove(index - 1);
        System.out.println(BOLD + NEON_GREEN + "\nData berhasil dihapus!" + RESET);
    }

    public static void main(String[] args) {
        ArrayList<DataBarang> data = new ArrayList<>();
        String username, password;
        final String adminUsername = "zidan";
        final String adminPassword = "123";

        System.out.println(BOLD + "=====[ " + LIGHT_BROWN + "Login" + RESET + BOLD + " ]=====" + RESET);
        System.out.print("Username : ");
        username = scanner.nextLine();
        System.out.print("Password : ");
        password = scanner.nextLine();

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println(BOLD + NEON_GREEN + "\n          Login berhasil!" + RESET);

            while (true) {
                System.out.println(BOLD + "========[ " + LIGHT_BROWN + "TB Jawa Jaya" + RESET + BOLD + " ]========" + RESET);
                System.out.println(BOLD + "\nMenu:");
                System.out.println("1. Tambah data");
                System.out.println("2. Tampilkan data");
                System.out.println("3. Ubah data");
                System.out.println("4. Hapus data");
                System.out.println("5. Keluar");
                System.out.print("Pilihan: " + RESET);

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addData(data);
                        break;
                    case 2:
                        displayData(data);
                        break;
                    case 3:
                        updateData(data);
                        break;
                    case 4:
                        deleteData(data);
                        break;
                    case 5:
                        System.out.println("Terima kasih!");
                        return;
                    default:
                        System.out.println(BOLD + NEON_RED + "\nPilihan tidak valid!" + RESET);
                }
            }
        } else {
            System.out.println(BOLD + NEON_RED + "\nLogin gagal! Username atau password salah." + RESET);
        }
    }
}
