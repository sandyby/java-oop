package sandyb;

public class AbstractClass {
	public static abstract class Bike {
		public Bike() {
			System.out.println("Bike is created");
		}

		abstract void run();

		void changeGear() {
			System.out.println("Gear changed");
		}
	}

	public static class Honda extends Bike {
		public Honda() {

		}

		@Override
		void run() {
			System.out.println("Running safely...");
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Bike bike = new Honda();
			bike.run();
			bike.changeGear();
		}
	}
}
