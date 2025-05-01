package sandyb;

import sandyb.W04.Person;

public class LatihanUTS {
	private static class Vehicle {
		private String model;
		public String model2;
		public int tes;

		public Vehicle(String model) {
			this.model = model;
			this.model2 = model;
		}

		public String getModel() {
			return model2;
		}
	}

	public static class Car extends Vehicle {
		private int numberOfDoors;

		public Car(String model, int doors) {
			super(model);
			numberOfDoors = doors;
		}

		public void display() {
			System.out.println("Model: " + super.model + ", Doors: " + numberOfDoors);
		}
	}

	public static class Motorcycle extends Vehicle {
		private int enginePower;

		public Motorcycle(String model, int enginePower) {
			super(model);
			this.enginePower = enginePower;
		}

		public void display() {
			System.out.println("Model: " + super.model + ", HP: " + enginePower);
		}
	}

	public static class Calculator {
		int add(int a, int b) {
			return a + b;
		}

		double add(double a, double b) {
			return a + b;
		}
	}

	public static class Counter {
		private static int count;
		static String tes;
		static String[] tes2;
		int count2;

		public Counter() {
		}

		public int getCount() {
			return count;
		}

		public String getTes() {
			return tes;
		}

		public String[] getTes2() {
			return tes2;
		}

		public static void displayCount() {
			System.out.println("Count: " + count);
//			System.out.println("Count: " + count2); // Error
		}

		public void tes() {
			System.out.println(count);
		}
	}

//	public static class Grandparent {
//		public String tes;
//
//		public Grandparent() {
//			this.tes = "tes";
//		}
//	}

	private static class Parent {
		protected String name = "Parent";

		public Parent(String name) {
			this.name = name;
		}

		public void display() {
			System.out.println("Name in Parent: " + name);
		}
	}

	public static class Child extends Parent {
		protected String ability;

		public Child(String name, String ability) {
//			this.name = name;
			super(name);
			this.ability = ability;
		}

		public void showName() {
//			System.out.println("Name in Child: " + Parent.name);
			System.out.println("Name: " + name);
			System.out.println("Name: " + this.name);
			System.out.println("Name: " + super.name);
			display();
		}
	}

	static interface Drawable {
		void draw();
	}

	static class Rectangle implements Drawable {
		public void draw() {
			System.out.println("Drawing a rectangle");
		}
	}

	static class Circle implements Drawable {
		public void draw() {
			System.out.println("Drawing a circle");
		}
	}

	final static class ImmutableClass {
		private String data;
		private int tes;

		public ImmutableClass(String data) {
			this.data = data;
		}

		public String getData() {
			return data;
		}

		public void setData(String newData) { // Potential Error
			this.data = newData;
		}
	}

	interface Flyable {
		void fly();
	}

	interface Swimmable {
		void swim();
	}

	static class Duck implements Flyable, Swimmable {

		public void fly() {
			System.out.println("Duck is flying");
		}

		public void swim() {
			System.out.println("Duck is swimming");
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Car myCar = new Car("Sedan", 4);
			/*
			 * System.out.println(myCar.model); // Error here! Error due to private access
			 * modifier on property 'model'
			 */

			System.out.println(myCar.getModel());
			System.out.println(myCar.model2);
			myCar.display();

			/**/

			Calculator calc = new Calculator();
			System.out.println(calc.add(5, 10));
			System.out.println(calc.add(3.0, 2.0));

			/**/

			Counter c1 = new Counter();
			Counter c2 = new Counter();
			Counter.displayCount();
			Counter c3 = new Counter();
			System.out.println("Tes" + c3.getCount());
			System.out.println("Tes2" + c3.getTes());
			System.out.println("Tes2" + c3.getTes2());

			/**/

			Parent p = new Parent("Tarekh");
			Child c = new Child("Tarekh", "terbang");
			System.out.println(p.name); // Potential Error
			p.display(); // Potential Error
//			Grandparent g = new Grandparent();
//			System.out.println(g.name);
//			g.display();
			c.showName();

			/**/

			Drawable shape1 = new Rectangle(); // Fill in the blank
			Drawable shape2 = new Circle(); // Fill in the blank

			shape1.draw();
			shape2.draw();

			/**/

			ImmutableClass obj = new ImmutableClass("Initial Value");
			obj.setData("New Value");
			System.out.println(obj.getData());

			/**/

			Duck duck = new Duck();
			duck.fly();
			duck.swim();

			Person orang = W04.getPerson();
			System.out.println(orang.getNama());
			orang.setNama("tarekh");
			System.out.println(orang.getNama());

//			Vehicle tes = new Car("tess", 4);
//			Vehicle tes = new Vehicle("sedan");
			Vehicle tes = new Motorcycle("ninja", 1000);
			if (tes instanceof Car) {
				System.out.println("iya ini car");
			} else if (tes instanceof Motorcycle) {
				System.out.println("iya ini motorcycle");
			}
//			} else if (tes instanceof Vehicle) {
//				System.out.println("iya ini vehicle");
//			}
		}
	}
}
