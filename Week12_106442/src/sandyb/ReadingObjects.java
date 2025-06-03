package sandyb;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import sandyb.StoringObjects.Person;

public class ReadingObjects {
	public static void main(String[] args) {
		Person person = null;

		try {
			String currentPath = System.getProperty("user.dir") + "/src/sandyb/";
			FileInputStream fileIn = new FileInputStream(currentPath + "person.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			person = (Person) in.readObject();
		} catch (IOException ioe) {
			System.out.println("File doesn't exist");
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("The class Person is not found");
			cnfe.printStackTrace();
		}

		if (person != null) {
			System.out.println("Deserialized Person...");
			System.out.println("Name: " + person.getName());
			System.out.println("Age: " + person.getAge());
			System.out.println("Campus: " + person.getCampus());
		}
	}
}
