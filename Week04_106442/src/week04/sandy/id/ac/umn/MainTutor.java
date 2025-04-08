package week04.sandy.id.ac.umn;

import java.util.Scanner;

public class MainTutor {
	static MataKuliah[] matkuls = new MataKuliah[9];

	public static void seedData() {
		matkuls[0] = new MataKuliah("IF402", "Pemrograman Berorientasi Objek", 3);
		matkuls[1] = new MataKuliah("IF100", "Dasar-dasar Pemrograman", 3);
		matkuls[2] = new MataKuliah("IF534", "Kecerdasan Buatan", 3);
		matkuls[3] = new MataKuliah("CE121", "Aljabar Linear", 3);
		matkuls[4] = new MataKuliah("CE441", "Jaringan Komputer", 3);
		matkuls[5] = new MataKuliah("CE232", "Sistem Digital", 3);
		matkuls[6] = new MataKuliah("UM162", "Pancasila", 2);
		matkuls[7] = new MataKuliah("UM152", "Agama", 2);
		matkuls[8] = new MataKuliah("UM142", "Bahasa Indonesia", 2);
	}

	public static void mainMenu() {
		System.out.println("-------- Daftar Mata Kuliah --------");
		System.out.println("1. Lihat Semua Mata Kuliah");
		System.out.println("2. Lihat Mata Kuliah Kode IF");
		System.out.println("3. Lihat Mata Kuliah Kode CE");
		System.out.println("4. Lihat Mata Kuliah Kode UM");
	}

	public static void showData() {
		System.out.println("Daftar Mata Kuliah");
		for (MataKuliah matkul : matkuls) {
			System.out.println("----------------------------");
			System.out.println("Kode\t\t: " + matkul.getKode());
			System.out.println("Nama\t\t: " + matkul.getNama());
			System.out.println("Jumlah SKS\t: " + matkul.getSks());
		}
	}

	public static void filterData(String kode) {
		for (MataKuliah matkul : matkuls) {
			if (matkul.getKode().contains(kode)) {
				System.out.println("----------------------------");
				System.out.println("Kode\t\t: " + matkul.getKode());
				System.out.println("Nama\t\t: " + matkul.getNama());
				System.out.println("Jumlah SKS\t: " + matkul.getSks());
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		seedData();
		int menu;
		for (;;) {
			mainMenu();
			System.out.print("Pilihan : ");
			menu = in.nextInt();
			in.nextLine();
			switch (menu) {
			case 1:
				showData();
				System.out.print("Press enter to continue");
				in.nextLine();
				break;
			case 2:
				filterData("IF");
				break;
			case 3:
				filterData("CE");
				break;
			case 4: 
				filterData("UM");
				break;
			default:
				System.out.println("Input Tidak Valid");
			}
		}

	}
}