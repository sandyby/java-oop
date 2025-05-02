package sandyb;

public class Interface {
	interface Animal {
		public void eat();

		public void travel();
	}

	public static class Mammal implements Animal {
		public Mammal() {
		}

		@Override
		public void eat() {
			System.out.println("Mammal eats");
		}

		@Override
		public void travel() {
			System.out.println("Mammal travel");
		}

		public static void main(String[] args) {
			Mammal m = new Mammal();
			m.eat();
			m.travel();
		};
	}
}
