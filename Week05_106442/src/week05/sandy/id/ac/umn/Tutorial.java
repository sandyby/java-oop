package week05.sandy.id.ac.umn;

import java.util.Scanner;

public class Tutorial {
	public static class Shape {
		private String color;

		public Shape() {
		}

		public Shape(String color) {
			this.color = color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getColor() {
			return color;
		}

		public double getArea() {
			return 0;
		}

		public double getPerimeter() {
			return 0;
		}
	}

	public static class Circle extends Shape {
		private double radius;

		public Circle() {

		}

		public Circle(double radius, String color) {
			super(color);
			this.radius = radius;
		}

		public double getRadius() {
			return radius;
		}

		public double getArea() {
			return Math.PI * radius * radius;
		}

		public double getPerimeter() {
			return Math.PI * 2 * radius;
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Masukkan jari-jari lingkaran: ");
			double radius = scanner.nextDouble();
			System.out.print("Masukkan warna: ");
			String color = scanner.next();
			Circle circle = new Circle(radius, color);
			System.out.println("------------Circle------------");
			System.out.println("Warna: " + circle.getColor());
			System.out.println("Jari-jari: " + circle.getRadius());
			System.out.println("Keliling Lingkaran: " + circle.getPerimeter());
			System.out.println("Luas Lingkaran: " + circle.getArea());
			scanner.close();
		}
	}
}
