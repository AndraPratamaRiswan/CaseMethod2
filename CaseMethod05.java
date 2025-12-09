import java.util.Scanner;

public class CaseMethod05 {

    static Scanner sc = new Scanner(System.in);
    static String[][] data = new String [100][6];
    static int jumlahData = 0;


    public static void main(String[] args) {
        int pilihan;

        do {
            menu();
            pilihan = Integer.parseInt(sc.nextLine());
            switch (pilihan) {
                case 1: tambahData(); break;
                case 2: tampilkanData(); break;
                case 3: cariByProdi(); break;
                case 4: hitungStatus(); break;
                case 5: System.out.println("Keluar dari program."); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }
}
