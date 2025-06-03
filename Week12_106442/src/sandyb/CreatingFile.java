package sandyb;

import java.io.File;
import java.io.IOException;

public class CreatingFile {
	public static void main(String[] args) {
		try {
			String currentPath = System.getProperty("user.dir") + "/src/sandyb/";
//			System.out.println(currentPath);
			File Obj = new File(currentPath + "myfile.txt");
			if (Obj.createNewFile()) {
				System.out.println("File has been created: " + Obj.getName());
			} else {
				System.out.println("File already exists!");
			}
		} catch (IOException ioe) {
			System.out.println("An error has occurred! Please try again later");
			ioe.printStackTrace();
		}
	}
}
