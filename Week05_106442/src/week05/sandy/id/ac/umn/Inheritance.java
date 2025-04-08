package week05.sandy.id.ac.umn;

public class Inheritance {
	public static class Animal {
		public Animal() {

		}

		public void eat() {
			System.out.println("eating....");
		}
	}

	public static class Dog extends Animal {
		public Dog() {

		}

		public void bark() {
			System.out.println("barking....");
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Dog d = new Dog();
			d.bark();
			d.eat();
		}
	}
}
