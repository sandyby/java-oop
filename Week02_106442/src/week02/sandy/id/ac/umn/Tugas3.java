package week02.sandy.id.ac.umn;

import java.util.Scanner;

public class Tugas3 {
	public static void main(String[] args) {
		long sum = 0L;
		boolean flag;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a minimum number: ");
		long minNumber = scanner.nextLong();
		System.out.print("Enter a maximum number: ");
		long maxNumber = scanner.nextLong();
		scanner.close();
		if (minNumber > maxNumber) {
			System.out.println("Please enter the correct numbers!\n\n@sandyb________");
			System.exit(0);
		}
		if (minNumber < 2 && maxNumber < 2) {
			System.out.println("The sum of all prime numbers from " + minNumber + " until " + maxNumber
					+ " is 0\n\n@sandyb________");
			System.exit(0);
		}
		long i = (minNumber < 2) ? 2 : minNumber;
		for (; i <= maxNumber; i++) {
			flag = true;
//			System.out.println(Math.sqrt(i) + 1);
			if (i == 2) {
				sum += i;
				continue;
			}
			for (long j = 2L; j <= Math.sqrt(i); j++) {
//				System.out.print("i = " + i + " j = " + j + "\n");
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				sum += i;
//				System.out.print(sum + "\n");
			}
		}
		System.out.println("The sum of all prime numbers from " + minNumber + " until " + maxNumber + " is " + sum
				+ "\n\n@sandyb________");
	}
}
