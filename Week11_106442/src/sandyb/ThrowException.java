package sandyb;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;

import sandyb.CustomizedExceptions.AuthenticationException;
import sandyb.CustomizedExceptions.ExcessiveFailedLogInException;

public class ThrowException {
	private static final String RED_TEXT = "\u001B[31m";
	private static final String GREEN_TEXT = "\u001B[32m";
	private static final String YELLOW_TEXT = "\u001B[33m";
	private static final String WHITE_BACKGROUND = "\u001B[47m";
	private static final String RESET_COLOR = "\u001B[0m";
	private static Scanner scanner = new Scanner(System.in);

	public static class User {
		private String firstName;
		private String lastName;
		private Character gender;
		private String address;
		private String username;
		private String password;
		private MessageDigest digest;

		private static final int maxLoginAttempts = 3;
		private static int LoginAttemps;

		private String hash(String stringToBeHashed) {
			try {
				digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(stringToBeHashed.getBytes(StandardCharsets.UTF_8));
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
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.address = address;
			this.username = userName;
			this.password = password;
		}

		public boolean login(String username, String password) throws ExcessiveFailedLogInException {
			if (this.username.equals(username)) {
				if (LoginAttemps == maxLoginAttempts) {
					LoginAttemps++;
					throw new ExcessiveFailedLogInException();
				} else if (LoginAttemps > maxLoginAttempts) {
					throw new ExcessiveFailedLogInException("Anda telah mencapai batas login");
				}

				if (this.password.equals(hash(password))) {
					LoginAttemps = 0; // di-reset lagi login attemptsnya karena berhasil
					return true;
				} else {
					System.out.println("Password yang Anda masukkan salah!");
					System.out.println("Kesempatan Anda login tersisa " + (maxLoginAttempts - LoginAttemps) + " lagi!");
					LoginAttemps++;
				}
			}
			return false;
		}

		public String greeting() {
			String greet = "Selamat Datang!";
			switch (gender) {
			case 'L':
				greet += " Tuan ";
				break;
			case 'P':
				greet += " Nyonya ";
				break;
			default:
				throw new IllegalArgumentException("Gender tidak diketahui!");
			}

			greet += this.firstName + " " + this.lastName;
			return greet;
		}

		public String getUserName() {
			return this.username;
		}
	}

	public static class Main {
		private static ArrayList userList = new ArrayList<>();

		boolean handleLogin() throws AuthenticationException {

			return false;
		}

		boolean handleSignUp() {
			return false;
		}

		public static void main(String[] args) {
			User manusia = new User("John", "Doe", 'L', "Jl. Jl. Ke Puncak Gunung", "admin", "admin123");

			boolean isInputValid = true;
			do {
				isInputValid = true;
				System.out.print("1. Login\n2. Sign Up\nPilihan: ");
				String mainMenuChoice = scanner.next();
				scanner.nextLine(); // ngehapus input buffer buat handle new line characters
				if (!mainMenuChoice.matches("1|2")) {
					System.out.println(RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan opsi yang valid!" + RESET_COLOR);
					isInputValid = false;
				}
				if (mainMenuChoice.equals("1")) {
					System.out.println("Username: ");
					String usernameInput = scanner.next();
				}
			} while (!isInputValid);
		}
	}
}

/*
 * import java.util.Timer; import java.util.TimerTask;
 * 
 * public class LoginController { private int loginAttempts = 0; private final
 * int maxAttempts = 3; private Timer resetTimer = new Timer();
 * 
 * public void login() { if (loginAttempts >= maxAttempts) {
 * System.out.println("Maximum login attempts exceeded. Please try again later."
 * ); resetTimer.schedule(new ResetAttemptsTask(), 30000); // 30 seconds reset
 * timer return; } // Proceed with login logic // Example: authenticate user
 * boolean isAuthenticated = authenticateUser(); if (!isAuthenticated) {
 * loginAttempts++; } else { loginAttempts = 0; // Reset attempts on successful
 * login } }
 * 
 * private class ResetAttemptsTask extends TimerTask { public void run() {
 * loginAttempts = 0; // Reset attempts after timer expires
 * System.out.println("Login attempts reset."); } }
 * 
 * private boolean authenticateUser() { // Implementation of user authentication
 * logic return false; // Example: always return false for simplicity } }
 */
