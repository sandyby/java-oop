package sandyb;

public class LatihanUTS {
	public static class Vehicle {
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

	public static class Calculator {
		int add(int a, int b) {
			return a + b;
		}

		double add(double a, double b) {
			return a + b;
		}
	}

	public static class Counter {
		static int count = 0;
		int count2 = 0;

		public Counter() {
			count++;
			count2++;
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

	public static class Parent {
		protected String name = "Parent";

		public Parent() {
		}

		protected void display() {
			System.out.println("Name in Parent: " + name);
		}
	}

	public static class Child extends Parent {
		public void showName() {
			System.out.println("Name in Child: " + name);
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
			c3.displayCount();

			/**/

			Parent p = new Parent();
			System.out.println(p.name); // Potential Error
			p.display(); // Potential Error
//			Grandparent g = new Grandparent();
//			System.out.println(g.name);
//			g.display();

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
		}
	}
}
