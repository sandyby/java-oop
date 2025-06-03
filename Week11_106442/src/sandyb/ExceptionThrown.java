package sandyb;

public class ExceptionThrown {
	static int divideByZero(int a, int b) {
		int i = a / b;
		return i;
	}

	static int computeDivision(int a, int b) {
		int res = 0;
		try {
			res = divideByZero(a, b);
		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException occurred!");
		}
		return res;
	}

	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		try {
			int i = computeDivision(a, b);
			System.out.println(i);
			b = 0;
			int e = computeDivision(a, b);
			System.out.println(e);
		} catch (ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
	}
}
