import java.util.Scanner;

public class CaseMethod05 {

    static Scanner sc = new Scanner(System.in);
    static String[][] data = new String[100][6];
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

    static void tambahData() {
        System.out.print("Nama: ");
        String nama = sc.nextLine();
        System.out.print("NIM: ");
        String nim = sc.nextLine();
        System.out.print("Program Studi: ");
        String prodi = sc.nextLine();
        System.out.print("Perusahaan Tujuan Magang: ");
        String tujuan = sc.nextLine();

        String semester;
        while (true) {
            System.out.print("Semester pengambilan magang(6 atau 7): ");
            semester = sc.nextLine();
            if (semester.equals("6") || semester.equals("7")) {
                break;
            } else {
                System.out.println("Input semester tidak valid! hanya boleh 6 atau 7.");
            }
        }

        String status;
        while (true) {
            System.out.print("Status magang (Diterima/Menunggu/Ditolak): ");
            status = sc.nextLine();
            if (status.equalsIgnoreCase("Diterima") ||
                    status.equalsIgnoreCase("Menunggu") ||
                    status.equalsIgnoreCase("Ditolak")) {
                break;
            } else {
                System.out.println("Input status tidak valid! pilihan: Diterima/Menunggu/Ditolak");
            }
        }
        data[jumlahData][0] = nama;
        data[jumlahData][1] = nim;
        data[jumlahData][2] = prodi;
        data[jumlahData][3] = tujuan;
        data[jumlahData][4] = semester;
        data[jumlahData][5] = status;

        jumlahData++;
        System.out.println("Data pendaftaran magang berhasil ditambahkan. Total pendaftar: " + jumlahData);

    }

    static void cariByProdi() {
        System.out.print("Masukkan Program Studi: ");
        String programStudi = sc.nextLine();
        for (int i = 0; i < jumlahData; i++) {
            if (data[i][2].equalsIgnoreCase(programStudi)) {
                System.out.printf("%-4s %-20s %-12s %-25s %-15s %-10s %-10s\n",
                        "No", "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "Status");

                System.out.printf("%-4s %-20s %-12s %-25s %-15s %-10s %-10s\n",
                        (i + 1),
                        data[i][0],
                        data[i][1],
                        data[i][2],
                        data[i][3],
                        data[i][4],
                        data[i][5]);
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
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilkanData();
                    break;
                case 3:
                    cariByProdi();
                    break;
                case 4:
                    hitungStatus();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
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
                    (i + 1), data[i][0], data[i][1], data[i][2], data[i][3], data[i][4], data[i][5]);
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
        System.out.println("Diterima: " + diterima);
        System.out.println("Menunggu: " + menunggu);
        System.out.println("Ditolak: " + ditolak);

    }
}
