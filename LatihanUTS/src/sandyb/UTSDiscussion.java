package sandyb;

public class UTSDiscussion {
	public static class A {
		public void m1(A a) {
			System.out.println("ini dari class A");
		}
	}

	public static class B extends A {
		public final void m1(A a) {
			System.out.println("ini dari class B");
		}
	}

	public static class Demo {
		public Demo(int i) {
			System.out.println("int");
		}

		public void Demo(short s) {
			System.out.println("short");
		}
	}

	public static class Vehicle {
		public String drive() {
			return "Driving Vehicle";
		}
	}

	public static class Car extends Vehicle {
		@Override
		public String drive() {
			return "Driving Autombile";
		}
	}

//	public static class Main extends Car {
	public static class Main {
//		@Override
//		public final String drive() {
		////			return super.drive();
//			return "Driving Automobile";
//		}

		public static void main(String[] args) {
//			Main main = new Main();
//			System.out.println(main.drive());

//			short s = 10;
//			Demo demo = new Demo(s);

			A a = new A();
			a.m1(a);
			a.m1(new B());
		}
	}
}
