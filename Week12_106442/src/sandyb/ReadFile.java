package sandyb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) {
		try {
			String currentPath = System.getProperty("user.dir") + "/src/sandyb/";
			File Obj = new File(currentPath + "myfile.txt");
//			System.out.println(Obj.getAbsolutePath());
			Scanner Reader = new Scanner(Obj);
			while (Reader.hasNextLine()) {
				String data = Reader.nextLine();
				System.out.println(data);
			}
			Reader.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("An error has occured!");
			fnfe.printStackTrace();
		}
	}
}
