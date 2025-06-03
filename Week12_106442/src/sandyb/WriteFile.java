package sandyb;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	public static void main(String[] args) {
		try {
			String currentPath = System.getProperty("user.dir") + "/src/sandyb/";
			FileWriter Writer = new FileWriter(currentPath + "myfile.txt");
			Writer.write("Nama saya Sandy Bonfilio Yuvens\n");
			Writer.write("Saya dari Universitas Multimedia Nusantara");
			Writer.close();
			System.out.println("Successfully written into the file!");
		} catch (IOException ioe) {
			System.out.println("An error has occured!");
			ioe.printStackTrace();
		}
	}
}
