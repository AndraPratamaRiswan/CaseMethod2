import java.util.Scanner;

public class CaseMethod05 {

    static Scanner sc = new Scanner(System.in);
    static String[][] data = new String [100][6];
    static int jumlahData = 0;
    static void menu() {
        System.out.println("=== Sistem Pendaftaran Magang Mahasiswa ===");
        System.out.println("1. Tambah Data Magang");
        System.out.println("2. Tampilkan Data Pendaftaran Magang");
        System.out.println("3. Cari Pendaftar berdasarkan Program Studi");
        System.out.println("4. Hitung Jumlah Pendaftar untuk Setiap Status");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
    }

    static void tambahData(int mahasiswa){
        System.out.print("Nama Mahasiswa: ");
        data[mahasiswa][0] =  sc.nextLine();
        System.out.print("NIM: ");
        data[mahasiswa][1] =  sc.nextLine();
        System.out.print("Program Studi: ");
        data[mahasiswa][2] =  sc.nextLine();
        System.out.print("Perusahaan Tujuan Magang: ");
        data[mahasiswa][3] =  sc.nextLine();
        System.out.print("Semester pengambilan barang: ");
        data[mahasiswa][4] =  sc.nextLine();
        System.out.print("Status Magang (Diterima/Menunggu/Ditolak: ");
        data[mahasiswa][5] =  sc.nextLine();
        System.out.print("Data pendaftaran magang berhasil ditambahkan. Total pendaftar" + "1");
       
    }

    static void cariByProdi(){
        System.out.print("Masukkan Program Studi: ");
        String programStudi = sc.nextLine();
        for(int i = 0; i < 100; i++){
           if (data[i][2].equalsIgnoreCase(programStudi)) {

    System.out.printf("%-4s %-20s %-12s %-25s %-15s %-10s %-10s\n",
            "No", "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "Status");

    System.out.printf("%-4s %-20s %-12s %-25s %-15s %-10s %-10s\n",
            (i + 1),
            data[i][0],
            data[i][1],
            data[i][2],
            data[i][3],
            data[i][4]
    );
}

            }
        }
    

    public static void main(String[] args) {
        int pilihan;
        int mahasiswa = 0;

        do {
            menu();
            pilihan = Integer.parseInt(sc.nextLine());
            switch (pilihan) {
                case 1: tambahData(mahasiswa); mahasiswa++; break;
                
                case 3: cariByProdi(); break;
                
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

