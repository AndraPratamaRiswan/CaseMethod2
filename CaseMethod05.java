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

    static void tampilkanData() {
        
        if (jumlahData < 1) {
            System.out.println("Belum ada pendaftar");
            return;
        }  
            System.out.printf("%-4s %-15s %-12s %-20s %-18s %-10s %-10s\n",
                "No", "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "Status");

            int no = 1;
            for (int i = 0; i < jumlahData; i++) {
                System.out.printf("%-4s %-15s %-12s %-20s %-18s %-10s %-10s\n",
                (i+1), data[i][0],data[i][1] ,data[i][2] ,data[i][3] ,data[i][4] ,data[i][5]  );
            }
    }

    static void hitungStatus() {
        int diterima = 0, menunggu = 0, ditolak = 0;

        for (int i = 0; i < jumlahData; i++) {
            String status = data[i][5];
            if (status.equalsIgnoreCase("Diterima")) {
                diterima++;
            } else if (status.equalsIgnoreCase("Menunggu")) {
                menunggu++;
            } else if (status.equalsIgnoreCase("Ditolak")) {
                ditolak++;
            }    
        }
        
    }
}

