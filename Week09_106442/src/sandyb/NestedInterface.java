package sandyb;

public class NestedInterface {
	/*
	 * interface first_interface { interface second_faceName {
	 * 
	 * } }
	 * 
	 * public static class className { private interface interfaceName {
	 * 
	 * } }
	 */

	public static class Vehicle {
		// nested interface untuk aksi yang bisa dilakukan oleh para objek kendaraan

		interface Action {
			void start();

			void stop();
		}

		private String name;

		public Vehicle(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void displayInfo() {
			System.out.println("Vehicle: " + name);
		}
	}

	public static class Car implements Vehicle.Action {
		private Vehicle vehicle;

		public Car(String name) {
			super();
			this.vehicle = new Vehicle(name);
		}

		@Override
		public void start() {
			System.out.println(vehicle.getName() + " is starting.");
		}

		@Override
		public void stop() {
			System.out.println(vehicle.getName() + " is stopping.");
		}

		public void showVehicleInfo() {
			vehicle.displayInfo();
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Car myCar = new Car("Honda Civic");
			myCar.showVehicleInfo();
			myCar.start();
			myCar.stop();
		}
	}
}
