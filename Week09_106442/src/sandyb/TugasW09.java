package sandyb;

public class TugasW09 {
	public static class Device {
		interface Connectivity {
			boolean connectToWiFi(String networkName);

			boolean disconnectFromWiFi();
		}

		String brand;
		String model;

		public void displayInfo() {
			System.out.println("Brand\t: " + this.brand + "\nModel\t: " + this.model);
		}
	}

	interface Power {
		boolean turnOn();

		boolean turnOff();
	}

	interface VolumeControl {
		boolean increaseVolume(int level);

		boolean decreaseVolume(int level);
	}

	public static class SmartPhone implements Power, VolumeControl, Device.Connectivity {
		@Override
		public boolean turnOn() {
			return false;
		}

		@Override
		public boolean turnOff() {
			return false;
		}

		@Override
		public boolean increaseVolume(int level) {
			return false;
		}

		@Override
		public boolean decreaseVolume(int level) {
			return false;
		}

		@Override
		public boolean connectToWiFi(String networkName) {
			return false;
		}

		@Override
		public boolean disconnectFromWiFi() {
			return false;
		}

		int currentVolume;
		String connectedNetwork;

		public SmartPhone(int currentVolume, String connectedNetwork) {
			super();
			this.currentVolume = currentVolume;
			this.connectedNetwork = connectedNetwork;
		}
	}

	public static class Main {
		public static void main(String[] args) {
			SmartPhone smartPhone = new SmartPhone(1, "tes");
//			SmartPhone.di

			// how, kayaknya ada salah

		}
	}
}
