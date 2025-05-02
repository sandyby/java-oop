package sandyb;

public class MultipleInheritance {
	/*
	 * error, incorrect way
	 * 
	 * public static class a { void displayA() { System.out.println("Display A"); }
	 * };
	 * 
	 * public static class b { void displayB() { System.out.println("Display B"); }
	 * };
	 * 
	 * 
	 * public static class c extends a, b {
	 * 
	 * }
	 */

	// correct way

	interface a {
		void displayA();
	}

	interface b {
		void displayB();
	}

	public static class c implements a, b {
		@Override
		public void displayA() {
			System.out.println("Display A");
		}

		@Override
		public void displayB() {
			System.out.println("Display B");
		}
	}

	public static class Main {
		public static void main(String[] args) {
			c c = new c();
			c.displayA();
			c.displayB();
		}
	}
}
