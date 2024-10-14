import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Menampilkan menu operasi
        System.out.println("\033[1mPilih operasi:\033[0m");
        System.out.println("1. \033[1mPenjumlahan\033[0m");
        System.out.println("2. \033[1mPengurangan\033[0m");
        System.out.println("3. \033[1mPerkalian\033[0m");
        System.out.println("4. \033[1mPembagian\033[0m");

        // Memilih operasi
        System.out.print("\033[1mMasukkan pilihan (1-4): \033[0m");
        int pilihan = input.nextInt();

        // Memasukkan dua angka
        System.out.print("\033[1mMasukkan angka pertama: \033[0m");
        double angka1 = input.nextDouble();
        System.out.print("\033[1mMasukkan angka kedua: \033[0m");
        double angka2 = input.nextDouble();

        // Variabel hasil
        double hasil = 0;

        // Melakukan operasi berdasarkan pilihan
        switch (pilihan) {
            case 1:
                hasil = angka1 + angka2;
                System.out.println("\033[1mHasil Penjumlahan: \033[0m" + hasil);
                break;
            case 2:
                hasil = angka1 - angka2;
                System.out.println("\033[1mHasil Pengurangan: \033[0m" + hasil);
                break;
            case 3:
                hasil = angka1 * angka2;
                System.out.println("\033[1mHasil Perkalian: \033[0m" + hasil);
                break;
            case 4:
                if (angka2 != 0) {
                    hasil = angka1 / angka2;
                    System.out.println("\033[1mHasil Pembagian: \033[0m" + hasil);
                } else {
                    System.out.println("\033[1mError: Pembagian dengan nol tidak diperbolehkan.\033[0m");
                }
                break;
            default:
                System.out.println("\033[1mPilihan tidak valid.\033[0m");
        }

        input.close();
    }
}
