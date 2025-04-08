package week02.sandy.id.ac.umn;

import java.util.Scanner;

public class Tutorial1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] matkulIF = { "Matematika Diskrit", "Dasar-dasar Pemrograman", "Pemrograman Berorientasi Objek" };
		String[] matkulCE = { "Riset Operasi", "Jaringan Komputer", "Aljabar Linear" };
		String[] matkulIS = { "Sistem Database", "Administrasi Database" };
		System.out.println("Pilih Kategori Mata Kuliah: ");
		System.out.println("1. Informatika\n2. Computer Engineering\n3. Informative System");
		System.out.print("Pilih: ");
		int input = scanner.nextInt();
		switch (input) {
		case 1:
			System.out.println("Daftar Mata Kuliah: ");
			show(matkulIF);
			break;
		case 2:
			System.out.println("Daftar Mata Kuliah: ");
			show(matkulCE);
			break;
		case 3:
			System.out.println("Daftar Mata Kuliah: ");
			show(matkulIS);
			break;
		default:
			System.out.println("Pilihan Tidak Valid");
		}
		scanner.close();
	}

	private static void show(String[] matkul) {
		for (int i = 0; i < matkul.length; i++) {
			System.out.println("- " + matkul[i]);
		}
	}
}