package sandyb;

import java.io.File;
import java.util.Scanner;

public class DeleteFile {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String currentPath = System.getProperty("user.dir") + "/src/sandyb/";
		String fileName = null;
		String option = null;
		boolean isOptionValid = true;
		do {
			isOptionValid = true;
			System.out.println("1. myfile.txt");
			System.out.println("2. person.ser");
			System.out.print("Choose which file to be deleted? ");
			option = scanner.next();
			scanner.nextLine();

			switch (option) {
			case "0":
				System.out.println("Exiting..\nThank you!");
				System.exit(0);
			case "1":
				fileName = "myfile.txt";
				break;
			case "2":
				fileName = "person.ser";
				break;
			default:
				isOptionValid = false;
				System.out.println("Please choose a valid option!");
				break;
			}
		} while (fileName == null || !isOptionValid);
		File Obj = new File(currentPath + fileName);
		if (Obj.delete()) {
			System.out.println("The deleted file is: " + Obj.getName());
		} else {
			System.out.println("Failed in deleting the file");
		}
	}
}
