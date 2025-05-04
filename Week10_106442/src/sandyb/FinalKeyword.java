package sandyb;

public class FinalKeyword {

	/*
	 * overview
	 * final on variable: constant, can't change the value after initialized/instantiated
	 * final on method: can't be overriden
	 * final on class: can't be extended/inherited
	 */

	public static class a {
		final double pi = 3.14;

		final void method1() {
			System.out.println("This is a final method");
		}
	}

	public final static class b extends a {
		// error, because we can't override a final method
		void method1() {
			System.out.println("Beep Boop");
		}

		void setPi(double newValue) {
			// error, because the value of a final variable can't be reassigned/changed
			// after initialization/instantiation
			this.pi = 3.141;
		}
	}

	public static class c extends b {
		// error, because we can't extends/inherit a final class
	}
}
