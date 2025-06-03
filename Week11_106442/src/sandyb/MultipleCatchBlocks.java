package sandyb;

import java.util.Scanner;

public class MultipleCatchBlocks {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			int n = Integer.parseInt(scanner.nextLine());
			int result = 18 / n;
			System.out.println(result);
		} catch (ArithmeticException ae) {
			System.out.println("ArithmeticException: " + ae.getMessage());
		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: " + nfe.getMessage());
		}
	}
}
