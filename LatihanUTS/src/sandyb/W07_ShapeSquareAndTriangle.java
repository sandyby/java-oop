package sandyb;

public class W07_ShapeSquareAndTriangle {
	public static class Shape {
		protected int length;
		protected int width;

		public Shape(int length, int width) {
			this.length = length;
			this.width = width;
		}

		public int area() {
			return length * width;
		}

		public void getVolume(int height) {
			System.out.println("Volume: " + length * width * height + " cm3");
		}
	}

	public static class Square extends Shape {
		public Square(int length, int width) {
			super(length, width);
		}

		@Override
		public int area() {
			return super.area();
		}

		public void getVolume() {
			System.out.println("Volume: " + this.area() * width + " cm3");
		}
	}

	public static class Triangle extends Shape {
		public Triangle(int length, int width) {
			super(length, width);
		}

		@Override
		public int area() {
			return super.area() / 2;
		}

		@Override
		public void getVolume(int height) {
			System.out.println("Volume: " + 0.33 * this.area() * height + " cm3");
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Square square = new Square(5, 5);
			Triangle triangle = new Triangle(6, 4);

			System.out.println("Square Area: " + square.area() + " cm2");
			System.out.println("Triangle Area: " + triangle.area() + " cm2");

			square.getVolume();
			triangle.getVolume(5);
		}
	}
}
