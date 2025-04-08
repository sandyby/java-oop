package week02.sandy.id.ac.umn;

import java.util.Scanner;

public class Armstrong {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number: ");
		int number = (int) scanner.nextInt();
		scanner.close();
		int len = String.valueOf(number).length();
		int total = 0, oriVal = number;
		for (int i = 0; i < len; i++) {
			total += Math.pow(number % 10, len);
			number /= 10;
		}
		if (total == oriVal) {
			System.out.println("Armstrong Number");
		} else {
			System.out.println("Not An Armstrong Number");			
		}
	}
}
