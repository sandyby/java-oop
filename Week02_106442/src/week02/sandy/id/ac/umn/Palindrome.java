package week02.sandy.id.ac.umn;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter A String: ");
		String string = scanner.nextLine();
		scanner.close();
		long startTime = System.nanoTime();
		for (int i = 0; i <= (string.length() / 2) - 1; i++) {
//		for (int i = 0; i < string.length(); i++) {
			System.out.println(string.charAt(i));
			if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
				System.out.println("Not A Palindrome");
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.println(totalTime);
				System.exit(0);
			}
		}
		System.out.println("A Palindrome");
		long endTime = System.nanoTime();
		long totalTime = (endTime - startTime);
		System.out.println(totalTime);
	}
}

/*
 * 
 * 11-1-0 = 10 11-1-1 = 9 i++ KASUR RUSAK 012345678910 SANDY 01234 RATTAR 012345
 */