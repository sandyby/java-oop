package sandyb;

public class TugasW09 {
	static final String RED_TEXT = "\u001B[31m";
	static final String GREEN_TEXT = "\u001B[32m";
	static final String YELLOW_TEXT = "\u001B[33m";
	static final String WHITE_TEXT = "\u001B[37m";
	static final String RED_BACKGROUND = "\u001B[41m";
	static final String GREEN_BACKGROUND = "\u001B[42m";
	static final String YELLOW_BACKGROUND = "\u001B[43m";
	static final String WHITE_BACKGROUND = "\u001B[47m";
	static final String RESET_COLOR = "\u001B[0m";

	public static class Device {
		interface Connectivity {
			boolean connectToWiFi(String networkName);

			boolean disconnectFromWiFi();
		}

		String brand;
		String model;

		public void displayInfo() {
			System.out.println("Device Info\nBrand: " + this.brand + "\nModel: " + this.model);
		}

		public Device(String brand, String model) {
			super();
			this.brand = brand;
			this.model = model;
		}
	}

	interface Power {
		void turnOn();

		void turnOff();
	}

	interface VolumeControl {
		boolean increaseVolume(int level);

		boolean decreaseVolume(int level);
	}

	public static class SmartPhone extends Device implements Power, VolumeControl, Device.Connectivity {
		@Override
		public void turnOn() {
			System.out.println("Turning on the device...");
		}

		@Override
		public void turnOff() {
			System.out.println("Turning off the device...");
		}

		@Override
		public boolean increaseVolume(int level) {
			if (level <= 0) {
				System.out.println(RED_TEXT + WHITE_BACKGROUND
						+ "You can only increase the volume if it's more than 0.. right?" + RESET_COLOR);
				return false;
			}

			int increasedTo = (getCurrentVolume() + level) > 100 ? 100 : (getCurrentVolume() + level);

			if (getCurrentVolume() == 100 && increasedTo == 100) {
				return true;
			}

			System.out.println("Increasing volume from " + getCurrentVolume() + " to " + increasedTo);
			setCurrentVolume(increasedTo);
			System.out.println(GREEN_TEXT + "Successfully increased the volume to " + getCurrentVolume() + RESET_COLOR);
			return true;
		}

		@Override
		public boolean decreaseVolume(int level) {
			int decreaseValue = level;
			if (decreaseValue < 0) {
				decreaseValue *= -1;
			}

			if (decreaseValue == 0) {
				System.out.println(
						RED_TEXT + WHITE_BACKGROUND + "You are too bored, huh? 0 won't change anything!" + RESET_COLOR);
				return false;
			}

			int decreasedTo = (getCurrentVolume() - decreaseValue) < 0 ? 0 : (getCurrentVolume() - decreaseValue);

			if (getCurrentVolume() == 0 && decreasedTo == 0) {
				return true;
			}

			System.out.println("Decreasing volume from " + getCurrentVolume() + " to " + decreasedTo);
			setCurrentVolume(decreasedTo);
			System.out.println(GREEN_TEXT + "Successfully decreased the volume to " + getCurrentVolume() + RESET_COLOR);
			return true;
		}

		@Override
		public boolean connectToWiFi(String networkName) {
			if (networkName == null || networkName.isEmpty()) {
				System.out.println(RED_TEXT + WHITE_BACKGROUND
						+ "Unable to identify the network!\nMake sure you gave the correct name" + RESET_COLOR);
				return false;
			} else if (networkName.equals(this.getConnectedNetwork())) {
				System.out.println(YELLOW_TEXT + "You are already connected to that network!" + RESET_COLOR);
				return true;
			} else if (getConnectedNetwork() != null && !getConnectedNetwork().isEmpty()) {
				System.out.println(RED_TEXT + WHITE_BACKGROUND
						+ "You are already connected to a network!\nPlease disconnect first" + RESET_COLOR);
				return false;
			} else if (networkName != null && !networkName.isEmpty()
					&& (getConnectedNetwork() == null || getConnectedNetwork().isEmpty())) {
				System.out.println("Connecting to WiFi: " + networkName + "...");
				setConnectedNetwork(networkName);
				System.out
						.println(GREEN_TEXT + "Successfully connected to WiFi: " + getConnectedNetwork() + RESET_COLOR);
				return true;
			}
			System.out.println(RED_TEXT + WHITE_BACKGROUND
					+ "Something went wrong while trying to connect to the WiFi!\nPlease try again later"
					+ RESET_COLOR);
			return false;
		}

		@Override
		public boolean disconnectFromWiFi() {
			if (getConnectedNetwork() != null && !getConnectedNetwork().isEmpty()) {
				System.out.println("Disconnecting from WiFi " + getConnectedNetwork() + "...");
				return true;
			}
			System.out.println(RED_TEXT + WHITE_BACKGROUND + "You are not connected to any network!" + RESET_COLOR);
			return false;
		}

		public boolean disconnectFromWiFi(String networkName) {
			if (getConnectedNetwork() == null || getConnectedNetwork().isEmpty()) {
				System.out.println(RED_TEXT + WHITE_BACKGROUND + "You are not connected to any network!" + RESET_COLOR);
				return false;
			} else if (networkName == null || networkName.isEmpty()) {
				System.out.println(RED_TEXT + WHITE_BACKGROUND
						+ "Unable to identify the network!\nMake sure you gave the correct name" + RESET_COLOR);
				return false;
			} else if ((getConnectedNetwork() != null || !getConnectedNetwork().isEmpty())
					&& networkName.equals(getConnectedNetwork())) {
				System.out.println("Disconnecting from WiFi: " + getConnectedNetwork() + "...");
				setConnectedNetwork(null);
				System.out.println(GREEN_TEXT + "Successfully disconnected from WiFi: " + networkName + RESET_COLOR);
				return true;
			} else if (getConnectedNetwork() != networkName) {
				System.out.println(YELLOW_TEXT + "Make sure you gave the correct WiFi name!" + RESET_COLOR);
				return false;
			}
			System.out.println(RED_TEXT + WHITE_BACKGROUND
					+ "Something went wrong while trying to disconnect from the WiFi!\nPlease try again later"
					+ RESET_COLOR);
			return false;
		}

		int currentVolume;
		String connectedNetwork;

		public SmartPhone(String brand, String model) {
			super(brand, model);
			setCurrentVolume(30);
			setConnectedNetwork(null);
		}

		public void setCurrentVolume(int currentVolume) {
			this.currentVolume = currentVolume;
		}

		public void setConnectedNetwork(String connectedNetwork) {
			this.connectedNetwork = connectedNetwork;
		}

		public int getCurrentVolume() {
			return currentVolume;
		}

		public String getConnectedNetwork() {
			return connectedNetwork;
		}
	}

	public static class Main {
		public static void main(String[] args) {
			SmartPhone phone = new SmartPhone("Samsung", "Galaxy S21");
			phone.displayInfo();
			phone.turnOn();
			phone.increaseVolume(0);
			phone.increaseVolume(-5);
			phone.increaseVolume(5);
			phone.decreaseVolume(0);
			phone.decreaseVolume(-5);
			phone.decreaseVolume(2);
			phone.increaseVolume(150);
			phone.increaseVolume(5); // langsung direturn, krn udh 100
			phone.increaseVolume(2); // langsung direturn, krn udh 100
			phone.increaseVolume(1); // langsung direturn, krn udh 100
			phone.decreaseVolume(80);
			phone.decreaseVolume(50); // langsung direturn, krn udh 0
			phone.decreaseVolume(40); // langsung direturn, krn udh 0
			phone.decreaseVolume(20); // langsung direturn, krn udh 0
			phone.decreaseVolume(1); // langsung direturn, krn udh 0
			phone.disconnectFromWiFi();
			phone.disconnectFromWiFi("");
			phone.connectToWiFi("");
			phone.connectToWiFi("HomeNetwork");
			phone.connectToWiFi("HomeNetwork");
			phone.connectToWiFi("Homenetwork");
			phone.disconnectFromWiFi("Homenetwork");
			phone.disconnectFromWiFi("HomeNetwork");
			phone.connectToWiFi("HomeNetwork2");
			phone.disconnectFromWiFi();
			phone.turnOff();
		}

		/*
		 * Output:
		 * 
		 * Device Info
		 * Brand: Samsung
		 * Model: Galaxy S21
		 * Turning on the device...
		 * You can only increase the volume if it's more than 0.. right?
		 * You can only increase the volume if it's more than 0.. right?
		 * Increasing volume from 30 to 35
		 * Successfully increased the volume to 35
		 * You are too bored, huh? 0 won't change anything!
		 * Decreasing volume from 35 to 30
		 * Successfully decreased the volume to 30
		 * Decreasing volume from 30 to 28
		 * Successfully decreased the volume to 28
		 * Increasing volume from 28 to 100
		 * Successfully increased the volume to 100
		 * Decreasing volume from 100 to 20
		 * Successfully decreased the volume to 20
		 * Decreasing volume from 20 to 0
		 * Successfully decreased the volume to 0
		 * You are not connected to any network!
		 * You are not connected to any network!
		 * Unable to identify the network! Make sure you gave the correct name
		 * Connecting to WiFi: HomeNetwork...
		 * Successfully connected to WiFi: HomeNetwork
		 * You are already connected to that network!
		 * You are already connected to a network!
		 * Please disconnect first
		 * Make sure you gave the correct WiFi name!
		 * Disconnecting from WiFi: HomeNetwork...
		 * Successfully disconnected from WiFi: HomeNetwork
		 * Connecting to WiFi: HomeNetwork2...
		 * Successfully connected to WiFi: HomeNetwork2
		 * Disconnecting from WiFi HomeNetwork2...
		 * Turning off the device...
		 */
	}
}
