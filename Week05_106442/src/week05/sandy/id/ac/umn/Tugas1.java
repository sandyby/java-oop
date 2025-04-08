package week05.sandy.id.ac.umn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Tugas1 {
	public static class Shape {
		private ArrayList<String> colorList = new ArrayList<>(Arrays.asList("Black", "Gray", "White", "Red", "Orange",
				"Yellow", "Green", "Blue", "Pink", "Purple", "Indigo", "Violet", "Brown"));
		private String color;

		public Shape() {
			this.color = colorList.get(new Random().nextInt(colorList.size()));
		}

		public Shape(String color) {
			this.color = color;
		}

		public String getColor() {
			return color;
		}

		public double getArea() {
			return 0;
		}

		public double getCircumference() {
			return 0;
		}

		public double getPerimeter() {
			return 0;
		}
	}

	public static class Circle extends Shape {
		private double radius;

		public Circle() {
			this.radius = 0;
		}

		public Circle(double radius) {
			this.radius = radius;
		}

		public double getCircumference() {
			return Math.PI * radius * 2;
		}

		public double getArea() {
			return Math.PI * radius * radius;
		}

		public double getRadius() {
			return radius;
		}
	}

	public static class Square extends Shape {
		private double side;

		public Square() {
			this.side = 0;
		}

		public Square(double side) {
			this.side = side;
		}

		public double getSide() {
			return side;
		}

		public double getArea() {
			return side * side;
		}

		public double getPerimeter() {
			return side * 4;
		}
	}

	public static class Rectangle extends Shape {
		private double length, wide, height;

		public Rectangle() {
			this.length = 0;
			this.wide = 0;
		}

		public Rectangle(double length, double wide) {
			this.length = length;
			this.wide = wide;
		}

		public double getLength() {
			return length;
		}

		public double getWide() {
			return wide;
		}

		public double getArea() {
			return length * wide;
		}

		public double getPerimeter() {
			return 2 * (length + wide);
		}
	}

	public static class RightTriangle extends Shape {
		private double base, height;

		public RightTriangle() {
			this.base = 0;
			this.height = 0;
		}

		public RightTriangle(double base, double height) {
			this.base = base;
			this.height = height;
		}

		public double getBase() {
			return base;
		}

		public double getHeight() {
			return height;
		}

		public double getArea() {
			return 0.5 * base * height;
		}

		public double getHypotenuse() {
			return Math.sqrt(Math.pow(base, base) + Math.pow(height, height));
		}

		public double getPerimeter() {
			return base + height + getHypotenuse();
		}
	}

	public static class Main {
		public static final String RED_TEXT = "\u001B[31m";
		public static final String GREEN_TEXT = "\u001B[32m";
		public static final String YELLOW_TEXT = "\u001B[33m";
		public static final String WHITE_BACKGROUND = "\u001B[47m";
		public static final String BLACK_BACKGROUND = "\u001B[40m";
		public static final String YELLOW_BACKGROUND = "\u001B[43m";
		public static final String RED_BACKGROUND = "\u001B[41m";
		public static final String RESET_COLOR = "\u001B[0m";
		static Scanner scanner = new Scanner(System.in);

		public static void main(String[] args) {
			try {
				int option = -1;
				boolean isInputValid = true;
				do {
					try {
						isInputValid = true;
						printMenu();
						option = scanner.nextInt();
						if (option < 1 || option > 5) {
							isInputValid = false;
							throw new Exception("Please choose a valid option!");
						}

						switch (option) {
						case 1:
							try {
								circle();
							} catch (InputMismatchException ime) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT + ime.getMessage() + RESET_COLOR);
								scanner.next();
							} catch (IllegalArgumentException iae) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT + iae.getMessage() + RESET_COLOR);
							} catch (Exception e) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT
										+ "An error occured! Please try again later" + RESET_COLOR);
							}
							break;
						case 2:
							try {
								square();
							} catch (InputMismatchException ime) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT + ime.getMessage() + RESET_COLOR);
								scanner.next();
							} catch (IllegalArgumentException iae) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT + iae.getMessage() + RESET_COLOR);
							} catch (Exception e) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT
										+ "An error occured! Please try again later" + RESET_COLOR);
							}
							break;
						case 3:
							try {
								rectangle();
							} catch (InputMismatchException ime) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT + ime.getMessage() + RESET_COLOR);
								scanner.next();
							} catch (IllegalArgumentException iae) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT + iae.getMessage() + RESET_COLOR);
							} catch (Exception e) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT
										+ "An error occured! Please try again later" + RESET_COLOR);
							}
							break;
						case 4:
							try {
								rightTriangle();
							} catch (InputMismatchException ime) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT + ime.getMessage() + RESET_COLOR);
								scanner.next();
							} catch (IllegalArgumentException iae) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT + iae.getMessage() + RESET_COLOR);
							} catch (Exception e) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT
										+ "An error occured! Please try again later" + RESET_COLOR);
							}
							break;
						case 5:
							System.out.println("Exiting program...");
							Thread.sleep(2000);
							System.out.println("Thank you for trying out NUMPIE!");
						default:
							break;
						}
					} catch (InputMismatchException ime) {
						System.out.println(WHITE_BACKGROUND + RED_TEXT + ime.getMessage() + RESET_COLOR);
						scanner.next();
					} catch (Exception e) {
//						System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please choose a valid option!" + RESET_COLOR);
						System.out.println(WHITE_BACKGROUND + RED_TEXT + e.getMessage() + RESET_COLOR);
					}
				} while (option != 5);
			} catch (InputMismatchException ime) {
				System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please enter a number instead!" + RESET_COLOR);
				scanner.next();
			} catch (Exception e) {
				System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please choose a valid option!" + RESET_COLOR);
			} finally {
				scanner.close();
				System.exit(0);
			}
		}

		public static void printMenu() {
			System.out.println("--------NumPie🥧--------");
			System.out.println("1. Circle");
			System.out.println("2. Square");
			System.out.println("3. Rectangle");
			System.out.println("4. Right Triangle");
			System.out.println("5. Exit");
			System.out.print("Choose: ");
		}

		public static void circle() throws IllegalArgumentException, IllegalArgumentException {
			System.out.println("--------Circle--------");
			System.out.print("Enter a Radius: ");
			if (!scanner.hasNextDouble()) {
				throw new InputMismatchException("Please enter a number instead!");
			}
			double radius = scanner.nextDouble();
			if (radius < 0) {
				throw new IllegalArgumentException("It can't be negative.. duh?");
			}
			Circle tempCircle = new Circle(radius);
			System.out.println("Color\t\t: " + tempCircle.getColor());
			System.out.println("Radius\t\t: " + new DecimalFormat("0.##").format(tempCircle.getRadius()) + " cm");
//					+ (tempCircle.getRadius() % 1 == 0 ? new DecimalFormat("0.##").format(tempCircle.getRadius())
//							: tempCircle.getRadius()) + " cm");
			System.out.println("Diameter\t: " + new DecimalFormat("0.##").format(tempCircle.getRadius() * 2) + " cm");
//					+ (tempCircle.getRadius() % 1 == 0 ? new DecimalFormat("0.##").format(tempCircle.getRadius() * 2)
//							: tempCircle.getRadius() * 2) + " cm");
			System.out.println(
					"Circumference\t: " + new DecimalFormat("0.##").format(tempCircle.getCircumference()) + " cm");
			System.out.println("Area\t\t: " + new DecimalFormat("0.##").format(tempCircle.getArea()) + " cm\u00b2");
		}

		public static void square() throws InputMismatchException, IllegalArgumentException {
			System.out.println("--------Square--------");
			System.out.print("Enter a Side: ");
			if (!scanner.hasNextDouble()) {
				throw new InputMismatchException("Please enter a number instead!");
			}
			double side = scanner.nextDouble();
			if (side < 0) {
				throw new IllegalArgumentException("It can't be negative.. duh?");
			}
			Square tempSquare = new Square(side);
			System.out.println("Color\t\t: " + tempSquare.getColor());
			System.out.println("Side\t\t: " + new DecimalFormat("0.##").format(tempSquare.getSide()) + " cm");
//					+ (tempSquare.getSide() % 1 == 0 ? new DecimalFormat("0.##").format(tempSquare.getSide())
//							: tempSquare.getSide()) + " cm");
			System.out.println("Perimeter\t: " + new DecimalFormat("0.##").format(tempSquare.getPerimeter()) + " cm");
			System.out.println("Area\t\t: " + new DecimalFormat("0.##").format(tempSquare.getArea()) + " cm\u00b2");
		}

		public static void rectangle() throws InputMismatchException, IllegalArgumentException {
			System.out.println("--------Rectangle--------");
			System.out.print("Enter a Length: ");
			if (!scanner.hasNextDouble()) {
				throw new InputMismatchException("Please enter a number instead!");
			}
			double length = scanner.nextDouble();
			if (length < 0) {
				throw new IllegalArgumentException("It can't be negative.. duh?");
			}
			System.out.print("Enter a Wide: ");
			if (!scanner.hasNextDouble()) {
				throw new InputMismatchException("Please enter a number instead!");
			}
			double wide = scanner.nextDouble();
			if (wide < 0) {
				throw new IllegalArgumentException("It can't be negative.. duh?");
			}
			Rectangle tempRectangle = new Rectangle(length, wide);
			System.out.println("Color\t\t: " + tempRectangle.getColor());
			System.out.println("Length\t\t: " + new DecimalFormat("0.##").format(tempRectangle.getLength()) + " cm");
//					+ (tempRectangle.getLength() % 1 == 0 ? new DecimalFormat("0.##").format(tempRectangle.getLength())
//							: tempRectangle.getLength()) + " cm");
			System.out.println("Wide\t\t: " + new DecimalFormat("0.##").format(tempRectangle.getWide()) + " cm");
//					+ (tempRectangle.getWide() % 1 == 0 ? new DecimalFormat("0.##").format(tempRectangle.getWide())
//							: tempRectangle.getWide()) + " cm");
			System.out
					.println("Perimeter\t: " + new DecimalFormat("0.##").format(tempRectangle.getPerimeter()) + " cm");
			System.out.println("Area\t\t: " + new DecimalFormat("0.##").format(tempRectangle.getArea()) + " cm\u00b2");
		}

		public static void rightTriangle() throws InputMismatchException, IllegalArgumentException {
			System.out.println("--------Right Triangle--------");
			System.out.print("Enter a Base: ");
			if (!scanner.hasNextDouble()) {
				throw new InputMismatchException("Please enter a number instead!");
			}
			double base = scanner.nextDouble();
			if (base < 0) {
				throw new IllegalArgumentException("It can't be negative.. duh?");
			}
			System.out.print("Enter a Height: ");
			if (!scanner.hasNextDouble()) {
				throw new InputMismatchException("Please enter a number instead!");
			}
			double height = scanner.nextDouble();
			if (height < 0) {
				throw new IllegalArgumentException("It can't be negative.. duh?");
			}
			RightTriangle tempRightTriangle = new RightTriangle(base, height);
			System.out.println("Color\t\t: " + tempRightTriangle.getColor());
			System.out.println("Base\t\t: " + new DecimalFormat("0.##").format(tempRightTriangle.getBase()) + " cm");
//					+ (tempRightTriangle.getBase() % 1 == 0 ? new DecimalFormat("0.##").format(tempRightTriangle.getBase())
//							: tempRightTriangle.getBase()) + " cm");
			System.out
					.println("Height\t\t: " + new DecimalFormat("0.##").format(tempRightTriangle.getHeight()) + " cm");
//					+ (tempRightTriangle.getHeight() % 1 == 0 ? new DecimalFormat("0.##").format(tempRightTriangle.getHeight())
//							: tempRightTriangle.getHeight()) + " cm");
			System.out.println(
					"Perimeter\t: " + new DecimalFormat("0.##").format(tempRightTriangle.getPerimeter()) + " cm");
			System.out.println(
					"Area\t\t: " + new DecimalFormat("0.##").format(tempRightTriangle.getArea()) + " cm\u00b2");
		}
	}
}
