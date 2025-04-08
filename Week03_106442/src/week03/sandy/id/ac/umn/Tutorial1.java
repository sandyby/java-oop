package week03.sandy.id.ac.umn;

import java.util.Scanner;

public class Tutorial1 {
	public static void main(String[] args) {
		int input;
		Scanner scanner = new Scanner(System.in);

		String[] matkulIF = { "Matematika Diskrit", "Dasar-dasar Pemrograman", "Pemrograman Berorientasi Objek" };

		String[] matkulCE = { "Riset Operasi", "Jaringan Komputer", "Aljabar Linear" };

		String[] matkulIS = { "Sistem Database", "Administrasi Datbase" };

		System.out.println("Pilih Kategori Mata Kuliah: ");
		System.out.println("1. Informatics\n2. Computer Engineering\n3. Information System");
		System.out.print("Pilih: ");
		input = scanner.nextInt();
		scanner.close();

		switch (input) {
		case 1: {
			System.out.println("Daftar Mata Kuliah IF : ");
			show(matkulIF);
			break;
		}
		case 2: {
			System.out.println("Daftar Mata Kuliah CE : ");
			show(matkulCE);
			break;
		}
		case 3: {
			System.out.println("Daftar Mata Kuliah IS : ");
			show(matkulIS);
			break;
		}
		default:
			System.out.println("Pilihan Tidak Valid");
		}
	}

	public static void show(String[] matkul) {
		for (String eachMatkul : matkul) {
			System.out.println("- " + eachMatkul);
		}
	}
}
