package sandyb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StoringObjects {
	public static class Person implements Serializable {
		private static final long serialVersionUID = 1L;
		private String name;
		private int age;
		private String campus;

		public Person(String name, int age, String campus) {
			super();
			this.setName(name);
			this.setAge(age);
			this.setCampus(campus);
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public void setCampus(String campus) {
			this.campus = campus;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public String getCampus() {
			return campus;
		}

		@Override
		public String toString() {
			return "Person{name='" + getName() + "', age" + getAge() + ", campus = '" + getCampus() + "'}";
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Person person = new Person("John Doe", 22, "Universitas Multimedia Nusantara");
			try {
				String currentPath = System.getProperty("user.dir") + "/src/sandyb/";
				FileOutputStream fileOut = new FileOutputStream(currentPath + "person.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(person);
				System.out.println("Serialized data is saved in person.ser");
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
