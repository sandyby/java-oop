package week03.sandy.id.ac.umn;

import java.util.Scanner;

public class Tugas2 {

	public static void main(String[] args) {
		String continues, string, contains;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Enter Your String: ");
			string = (String) scanner.nextLine();
//			scanner.nextLine();
			int length = string.length();
			boolean flag1 = false, flag2 = false;
			int choice = 0;
			do {
				System.out.println("----------------------------------");
				System.out.println("Your String: " + string);
				System.out.println("1. charAt\t\t2. length");
				System.out.println("3. substring(n)\t\t4. substring(m,n)");
				System.out.println("5. contains\t\t6. concat");
				System.out.println("7. replace\t\t8. split");
				System.out.println("9. lowerCase\t\t10. upperCase");
				System.out.println("11. Exit");
				System.out.print("Choose A Method: ");
				if (scanner.hasNextInt()) {
					choice = scanner.nextInt();
				} else {
					System.out.println("Invalid method! Please try again!");
					scanner.next();
				}
				switch (choice) {
				case 1: {
//					System.out.println(length);
					do {
						System.out.print("-----charAt-----\nString: " + string + "\nIndex: ");
						choice = scanner.nextInt();
						if (choice >= length || choice < 0) {
							flag1 = true;
							System.out.println("Index out of bounds! Please give a valid one!");
						} else
							flag1 = false;
					} while (flag1);
					System.out
							.println("Result: " + (string.charAt(choice) == 32 ? "whitespace" : string.charAt(choice)));
					break;
				}
				case 2: {
					System.out.println("-----length-----\nString: " + string + "\nLength: " + string.length()
							+ (string.length() > 1 ? " characters" : " character"));
					break;
				}
				case 3: {
//					System.out.println(length);
					do {
						System.out.print("-----substring(n)-----\nString: " + string + "\nIndex: ");
						choice = scanner.nextInt();
						if (choice >= length || choice < 0) {
							flag1 = true;
							System.out.println("Index out of bounds! Please give a valid one!");
						} else
							flag1 = false;
					} while (flag1);
					System.out.println("Result: " + (string.substring(choice)));
					break;
				}
				case 4: {
//					System.out.println(length);
					int sIndex = 0, eIndex = 0;
					do {
						System.out.print("-----substring(m,n)-----\nString: " + string + "\nStarting Index: ");
						sIndex = scanner.nextInt();
						System.out.print("Ending Index: ");
						eIndex = scanner.nextInt();
						if (sIndex >= length || eIndex >= length || sIndex < 0 || eIndex < 0) {
							flag1 = true;
							System.out.println("Index out of bounds! Please give a valid one!");
						} else if (sIndex > eIndex) {
							flag1 = true;
							System.out.println("Indexes are invalid! Please think again, bruh!");
						} else
							flag1 = false;
					} while (flag1);
					System.out.println("Result: " + string.substring(sIndex, eIndex));
					break;
				}
				case 5: {
//					System.out.println(length);
					System.out.print("-----contains-----\nString: " + string + "\nInput: ");
					contains = scanner.next();
					scanner.nextLine();
					System.out.println("Result: " + string.contains(contains));
					break;
				}
				case 6: {
					System.out.print("-----concat-----\nString: " + string + "\nInput: ");
					contains = (String) scanner.next();
					scanner.nextLine();
					System.out.println("Result: " + string.concat(contains));
					break;
				}
				case 7: {
					String toBeReplaced = null, replacedWith = null;
					do {
						System.out.print("-----replace-----\nString: " + string + "\nWord(s) to be replaced: ");
						contains = (String) scanner.next();
						scanner.nextLine();
						toBeReplaced = contains;
						if (!string.contains(toBeReplaced)) {
							flag1 = true;
							System.out.println("The string \"" + toBeReplaced
									+ "\" is not in the string to be replaced!\nPlease try again!");
						} else {
							flag1 = false;
							System.out.print("Replacing word(s): ");
							contains = (String) scanner.next();
							scanner.nextLine();
							replacedWith = contains;
						}
					} while (flag1);
					System.out.println("Result: " + string.replace(toBeReplaced, replacedWith));
					break;
				}
				case 8: {
					System.out.print("-----split-----\nString: " + string + "\nInput: ");
					contains = (String) scanner.next();
					scanner.nextLine();
					String[] splitResult = string.split(contains);
					for (String s : splitResult) {
						System.out.println("Result: " + s);
					}
					break;
				}
				case 9: {
					System.out.println("-----lowerCase-----\nString: " + string + "\nResult: " + string.toLowerCase());
					break;
				}
				case 10: {
					System.out.println("-----upperCase-----\nString: " + string + "\nResult: " + string.toUpperCase());
					break;
				}
				case 11: {
					System.out.println("Thank You For Trying Out! :)");
					System.exit(0);
				}
				default:
					System.out.println("Please Enter An Available Method!");
					break;
				}
			} while (choice < 1 || choice > 11);
			System.out.print("Would you like to try again? (1 for yes) ");
			continues = scanner.next();
			scanner.nextLine();
		} while (continues.equals("1"));
		scanner.close();
		System.out.println("Thank You For Trying Out! :)");
		System.exit(0);
	}
}
