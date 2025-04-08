package week02.sandy.id.ac.umn;

import java.util.Scanner;

public class Tugas2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		Long number = scanner.nextLong();
		if (number <= 1) {
			System.out.println(number + " is not a prime number\n\n@sandyb________");
			System.exit(0);
		}
		for (int i = 2; i < (Math.sqrt(number) + 1); i++) {
			if (number % i == 0) {
				System.out.println(number + " is not a prime number\n\n@sandyb________");
				System.exit(0);
			}
		}
		System.out.println(number + " is a prime number\n\n@sandyb________");
		scanner.close();
	}
}
