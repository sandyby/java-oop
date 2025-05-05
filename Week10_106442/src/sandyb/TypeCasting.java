package sandyb;

public class TypeCasting {
	public static class ImplicitTypeCasting {

		// implicit type casting will be automatically done by java at compile-time
		// and there will be no data loss in a way that the smaller data type will be
		// casted into the higher one,
		// so the properties or any data inside the smaller data type will be saved
		// still

		final int a = 100;
		final long b = 100;

		public int getA() {
			return a;
		}

		public long getB() {
			return b;
		}
	}

	public static class ExplicitTypeCasting {

		// whereas explicit type casting is manually done by the code writer
		// and there might be data loss in a way that the higher data type will be
		// casted into a smaller one,
		// it is done by using the cast operator syntax like this:
		// (data type) value e.g. (int) 10.0

		final double x = 5.67;
		final int y = (int) x;

		public double getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	public static class Main {
		public static void main(String[] args) {
			ImplicitTypeCasting test = new ImplicitTypeCasting();
			System.out.println(test.getA());
			System.out.println(test.getB());
			ExplicitTypeCasting test2 = new ExplicitTypeCasting();
			System.out.println(test2.getX());
			System.out.println(test2.getY());
		}
	}
}
