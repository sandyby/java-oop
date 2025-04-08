package week05.sandy.id.ac.umn;

public class Polymorphism {
	public static class Circle {
		private double radius;

		public Circle(double radius) {
			this.radius = radius;
		}

		public double getRadius() {
			return radius;
		}

		public double getArea() {
			return Math.PI * radius * radius;
		}

		public String toString() {
			return "Circle[radius=" + radius + "]";
		}
	}

	public static class Cylinder extends Circle {
		public double height;

		public Cylinder(double height, double radius) {
			super(radius);
			this.height = height;
		}

		public double getHeight() {
			return this.height;
		}

		public double getVolume() {
			return super.getArea() * height;
		}

		@Override
		public double getArea() {
			return 2.0 * Math.PI * getRadius() * height;
		}

		@Override
		public String toString() {
			return "Cylinder[height=" + height + "," + super.toString() + "]";
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Circle circle1 = new Circle(10);
			Cylinder cylinder1 = new Cylinder(14, 10);
			System.out.println(circle1.getArea());
			System.out.println(circle1.getRadius());
			System.out.println(circle1.toString());
			System.out.println(cylinder1.getArea());
			System.out.println(cylinder1.getRadius());
			System.out.println(cylinder1.getHeight());
			System.out.println(cylinder1.getVolume());
			System.out.println(cylinder1.toString());
		}
	}
}
