package sandyb;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;

import sandyb.CustomizedExceptions.AuthenticationException;
import sandyb.CustomizedExceptions.ExcessiveFailedLogInException;

public class TugasW11 {
	public static class User {
		private String firstName;
		private String lastName;
		private Character gender;
		private String address;
		private String userName;
		private String password;
		private MessageDigest digest;

		private static final int MaxLoginAttempts = 3;
		private static int LoginAttempts;
//		private static String previousUsernameAttempt = null;

		private String hash(String strToHash) {
			try {
				digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(strToHash.getBytes(StandardCharsets.UTF_8));
				StringBuilder sb = new StringBuilder();
				for (byte b : hash)
					sb.append(String.format("%02x", b));
				return sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		}

		public User(String firstName, String lastName, Character gender, String address, String userName,
				String password) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.address = address;
			this.userName = userName;
			this.password = hash(password);
		}

		public boolean login(String userName, String password) throws ExcessiveFailedLogInException {
			if (this.userName.equals(userName)) {
//				LoginAttempts++;
//				System.out.println("logina: " + LoginAttempts);
//				System.out.println("maxlogina: " + MaxLoginAttempts);
				if (this.password.equals(hash(password))) {
					LoginAttempts = 0;
					return true;
				} else {
					LoginAttempts++;
					System.out.println("Username/Password yang Anda masukkan salah!");
					if (LoginAttempts >= MaxLoginAttempts) {
						throw new ExcessiveFailedLogInException("Anda telah mencapai batas login!");
					}
					System.out.println(
							"Kesempatan Anda login tersisa " + (MaxLoginAttempts - LoginAttempts) + " kali lagi!");
//					previousUsernameAttempt = userName;
					return false;
				}
			}
//			previousUsernameAttempt = userName;
			return false;
		}

		public String greeting() {
			String greet = "Selamat Datang!";
			switch (gender) {
			case 'L':
				greet += " Tuan ";
				break;
			case 'P':
				greet += " Nona ";
				break;
			}
			greet += this.firstName + " " + this.lastName;
			return greet;
		}

		public String getUserName() {
			return userName;
		}

		public String getFullName() {
			return firstName + (lastName != null ? " " + lastName : "");
		}
	}

	public static class Main {
		private static Scanner scanner = new Scanner(System.in);
		private static ArrayList<User> listOfUsers = new ArrayList<>();

		public static void initialize() {
			listOfUsers.add(new User("John", "Doe", 'L', "Jl. Merpati No. 1 RT 1 RW 1, Banten", "admin", "admin"));
			listOfUsers.add(new User("John", "Thor", 'L', "Jl. Suka Suka, Banten", "jojon12", "jojon12"));
		}

		public static boolean handleLogIn(String username, String password)
				throws AuthenticationException, ExcessiveFailedLogInException {

			boolean isUserFound = false;
			for (User user : listOfUsers) {
				if (user.getUserName().equals(username)) {
					isUserFound = true;
					try {
						if (user.login(username, password)) {
							System.out.println(user.greeting());
							return true;
						}
					} catch (ExcessiveFailedLogInException eflie) {
						throw eflie;
					}
				}
			}
			if (!isUserFound)
				throw new AuthenticationException("Kredensial tidak valid! Silakan coba lagi");
			return false;
		}

		public static boolean handleSignUp() {
			System.out.print("Nama Depan: ");
			String firstName = scanner.nextLine();
			System.out.print("Nama Belakang: ");
			String lastName = scanner.nextLine();

			Character gender = null;
			boolean isInputValid;
			do {
				isInputValid = true;
				System.out.print("Jenis Kelamin (L/P): ");
				String jenisKelamin = scanner.nextLine().toLowerCase();
				switch (jenisKelamin) {
				case "l":
				case "laki":
				case "laki-laki":
				case "pria":
					gender = 'L';
					break;
				case "p":
				case "perempuan":
				case "wanita":
					gender = 'P';
					break;
				default:
					System.out.println("Jenis kelamin tidak valid! Hanya L atau P");
					isInputValid = false;
					break;
				}
			} while (!isInputValid);

			System.out.print("Alamat: ");
			String address = scanner.nextLine();

			String username = null;
			do {
				isInputValid = true;
				System.out.print("Username: ");
				username = scanner.nextLine();

				if (username.length() <= 8) {
					isInputValid = false;
					System.out.println("Username harus lebih dari 8 karakter");
				} else {
					for (User user : listOfUsers) {
						if (user.getUserName().equals(username)) {
							isInputValid = false;
							System.out.println("Username sudah digunakan!");
							break;
						}
					}
				}
			} while (!isInputValid);

			String password = null;
			do {
				isInputValid = true;
				System.out.print("Password: ");
				password = scanner.nextLine();

				if (password.length() < 6 || password.length() > 16 || !password.matches(".*[A-Z].*")
						|| !password.matches(".*[0-9].*")) {
					isInputValid = false;
					System.out.println(
							"Password harus mengandung huruf besar, angka, minimum 6 karakter dan maksimum 16 karakter");
				}
			} while (!isInputValid);

			listOfUsers.add(new User(firstName, lastName, gender, address, username, password));
			System.out.println("User berhasil didaftarkan");
			return true;
		}

		public static void displayMainMenu() {
			System.out.print("1. Login\n2. Sign Up\nPilihan: ");
		}

		public static void displayLogInMenu() {
			boolean isLoggedIn = false;
			do {
				System.out.print("Username: ");
				String username = scanner.nextLine();
				System.out.print("Password: ");
				String password = scanner.nextLine();
				try {
					isLoggedIn = handleLogIn(username, password);
				} catch (AuthenticationException ae) {
					System.out.println(ae.getMessage());
				} catch (ExcessiveFailedLogInException eflie) {
					System.out.println(eflie.getMessage());
				}
			} while (User.LoginAttempts < User.MaxLoginAttempts && !isLoggedIn);
		}

		public static void displaySignUpMenu() {
			handleSignUp();
		}

		public static void main(String[] args) {
			initialize();
			while (true) {
				displayMainMenu();
				String choice = scanner.nextLine();
				switch (choice) {
				case "1":
					displayLogInMenu();
					break;
				case "2":
					displaySignUpMenu();
					break;
				default:
					System.out.println("Pilihan tidak valid!");
					break;
				}
			}
		}
	}
}
