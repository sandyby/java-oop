package UTS_Praktik_OOP_CL;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SandyBonfilioYuvens_Main_CL {
	static final String BLACK_TEXT = "\u001B[30m";
	static final String RED_TEXT = "\u001B[31m";
	static final String GREEN_TEXT = "\u001B[32m";
	static final String YELLOW_TEXT = "\u001B[33m";
	static final String BLUE_TEXT = "\u001B[34m";
	static final String PURPLE_TEXT = "\u001B[35m";
	static final String CYAN_TEXT = "\u001B[36m";
	static final String WHITE_TEXT = "\u001B[37m";
	static final String BLACK_BACKGROUND = "\u001B[40m";
	static final String RED_BACKGROUND = "\u001B[41m";
	static final String GREEN_BACKGROUND = "\u001B[42m";
	static final String YELLOW_BACKGROUND = "\u001B[43m";
	static final String BLUE_BACKGROUND = "\u001B[44m";
	static final String PURPLE_BACKGROUND = "\u001B[45m";
	static final String CYAN_BACKGROUND = "\u001B[46m";
	static final String WHITE_BACKGROUND = "\u001B[47m";
	static final String RESET_COLOR = "\u001B[0m";
	static final String FULL_NAME_PATTERN_REGEX = "^[a-zA-Z]+( [a-zA-Z]+)*$";
	static final String DIGITS_PATTERN_REGEX = "^[0-9]*$";
	static final Pattern ALPHABETS_PATTERN = Pattern.compile("[a-zA-Z]", Pattern.CASE_INSENSITIVE);
	static final Pattern DIGITS_PATTERN = Pattern.compile("[0-9]");
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<SandyBonfilioYuvens_User_CL> users = new ArrayList<>();
	static SandyBonfilioYuvens_User_CL currentUser = null;

	public static void showAddUserMenu() {
		boolean isInputValid = true;
		try {
			System.out.println("=============== Add User Menu ===============");
			String nama;
			do {
				isInputValid = true;
				System.out.print("Enter Your Full Name: ");
				nama = scanner.nextLine().trim();

				nama = nama.replaceAll("\\s+", " ");
				if (!nama.matches(FULL_NAME_PATTERN_REGEX)) {
					isInputValid = false;
					System.out.println(
							RED_TEXT + WHITE_BACKGROUND + "Please enter a valid full name format!" + RESET_COLOR);
					continue;
				} else if (nama.length() > 85) {
					isInputValid = false;
					System.out.println(
							RED_TEXT + WHITE_BACKGROUND + "Sorry, the maximum character limit is 85!" + RESET_COLOR);
					continue;
				} else if (nama.length() <= 4) {
					isInputValid = false;
					System.out.println(RED_TEXT + WHITE_BACKGROUND + "Please give your full name!" + RESET_COLOR);
					continue;
				}

				System.out.println(nama);
			} while (!isInputValid);
			long noRekening = -1;
			do {
				try {
					isInputValid = true;
					System.out.print("Enter Your Account Number: ");
					long noRekeningQuery = scanner.nextLong();
//					scanner.nextLine();

					if (noRekening <= 0) {
						isInputValid = false;
						System.out.println(
								WHITE_BACKGROUND + RED_TEXT + "Please enter a valid account number!" + RESET_COLOR);
					} else if (users.stream().filter(u -> (u.getNoRekening() == noRekeningQuery)).findFirst() != null) {
						isInputValid = false;
						System.out.println(WHITE_BACKGROUND + RED_TEXT
								+ "Account number already exists! Please create a different one" + RESET_COLOR);
					} else if (noRekening > 999999999) {
						isInputValid = false;
						System.out.println(WHITE_BACKGROUND + RED_TEXT
								+ "Account number can only be up to 9 digits long!" + RESET_COLOR);
					}
				} catch (InputMismatchException ime) {
					isInputValid = false;
					System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please enter a number instead!" + RESET_COLOR);
//					System.out.println(WHITE_BACKGROUND + RED_TEXT + ime + RESET_COLOR);
					scanner.next();
				} catch (IllegalArgumentException iae) {
					isInputValid = false;
//					System.out.println(WHITE_BACKGROUND + RED_TEXT + iae.getMessage() + RESET_COLOR);
					System.out.println(
							WHITE_BACKGROUND + RED_TEXT + "Please enter a valid account number!" + RESET_COLOR);
				} catch (Exception e) {
					isInputValid = false;
					System.out.println(
							WHITE_BACKGROUND + RED_TEXT + "An error occured! Please try again later" + RESET_COLOR);
//					System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
				}
			} while (!isInputValid);

			SandyBonfilioYuvens_User_CL tempUser = new SandyBonfilioYuvens_User_CL(nama, (int) noRekening);
			if (!createUser(tempUser)) {
				System.out.println(RED_TEXT + WHITE_BACKGROUND
						+ "Something went wrong while trying to create the new user!" + RESET_COLOR);
				return;
			}
			System.out.println(GREEN_TEXT + WHITE_BACKGROUND + "Successfully created user!" + RESET_COLOR);
		} catch (

		Exception e) {
//			System.out.println(WHITE_BACKGROUND + RED_TEXT + "An error occured! Please try again later" + RESET_COLOR);
			System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
		}
	}

	public static void initUsers() {
//		users.stream().peek(System.out::println).map(u -> u);
//		System.out.println("Tes");
		createUser(new SandyBonfilioYuvens_User_CL("Sandy Bonfilio", 106442));
		createUser(new SandyBonfilioYuvens_User_CL("Sandy Yuvens", 106442));
		createUser(new SandyBonfilioYuvens_User_CL("Sandy Bonfilio", new Random().nextInt(999999999 + 1)));
		createUser(new SandyBonfilioYuvens_User_CL("Bonfilio Yuvens", new Random().nextInt(999999999 + 1)));
//		users.stream().map(u -> u).forEach(System.out::println);
//		System.out.println("Tes");
	}

	public static boolean createUser(SandyBonfilioYuvens_User_CL user) {
		if (users.stream().filter(u -> (u.getNoRekening() == user.getNoRekening())).findFirst().isPresent()) {
			System.err.println(RED_TEXT + WHITE_BACKGROUND + "An account with the number " + user.getNoRekening()
					+ " already exists!\nIt will not be made" + RESET_COLOR);
			return false;
		}
		return users.add(user);
	}

	public static void showUsersList() {
		if (users.isEmpty()) {
			System.out.println(YELLOW_TEXT + "There are currently no users!" + RESET_COLOR);
			return;
		}

		int cellLength = 50;
		for (int i = 0; i < users.size(); i++) {
			SandyBonfilioYuvens_User_CL tempUser = users.get(i);
			if (tempUser.getNama().length() > cellLength)
				cellLength = tempUser.getNama().length() + 1;
//				cellLength = (tempUser.getNama().length() < 50 ? 50 : tempUser.getNama().length());
		}

		for (int i = 0; i < users.size(); i++) {
			if (i == 0)
				System.out.printf(WHITE_TEXT + RED_BACKGROUND + "%-" + (cellLength + 9) / 2 + "sUSERS LIST%-"
						+ (cellLength + 8) / 2 + "s\n" + RESET_COLOR, "", "");
			SandyBonfilioYuvens_User_CL tempUser = users.get(i);
			System.out.printf(
					RED_TEXT + WHITE_BACKGROUND + "%-4s Full Name\t: %-" + cellLength + "s" + "\n%5sAccount #\t: %-"
							+ cellLength + "s\n" + BLACK_TEXT + "%-" + (cellLength + 16) + "s\n" + RESET_COLOR,
					i + 1 + ".", tempUser.getNama(), "", tempUser.getNoRekening(), ("-").repeat(cellLength + 18));
		}
	}

	public static void showUsersList(int noRekeningToBeExcluded) {
		if (users.isEmpty()) {
			System.out.println(YELLOW_TEXT + "There are currently no users!" + RESET_COLOR);
			return;
		}

		int cellLength = 50;
		for (int i = 0; i < users.size(); i++) {
			SandyBonfilioYuvens_User_CL tempUser = users.get(i);
			if (tempUser.getNama().length() > cellLength && tempUser.getNoRekening() != noRekeningToBeExcluded)
				cellLength = tempUser.getNama().length() + 1;
//				cellLength = (tempUser.getNama().length() < 50 ? 50 : tempUser.getNama().length());
		}

		for (int i = 0; i < users.size(); i++) {
			if (i == 0)
				System.out.printf(WHITE_TEXT + RED_BACKGROUND + "%-" + (cellLength + 9) / 2 + "sUSERS LIST%-"
						+ (cellLength + 8) / 2 + "s\n" + RESET_COLOR, "", "");
			SandyBonfilioYuvens_User_CL tempUser = users.get(i);
			if (tempUser.getNoRekening() == noRekeningToBeExcluded)
				continue;
			System.out.printf(
					RED_TEXT + WHITE_BACKGROUND + "%-4s Full Name\t: %-" + cellLength + "s" + "\n%5sAccount #\t: %-"
							+ cellLength + "s\n" + BLACK_TEXT + "%-" + (cellLength + 16) + "s\n" + RESET_COLOR,
					i + 1 + ".", tempUser.getNama(), "", tempUser.getNoRekening(), ("-").repeat(cellLength + 18));
		}
	}

	public static boolean containsPattern(Pattern pattern, String stringToBeMatched) {
		return pattern.matcher(stringToBeMatched).find();
	}

	public static void handleDeposit() {
		boolean isTransactionInputValid = true;
		boolean isTransactionValid = true;
		long nominal;
		System.out.println("=============== Deposit/Save Up Menu ===============");
		do {
			isTransactionInputValid = true;
			try {
				System.out.print("Enter a nominal: ");
				nominal = scanner.nextLong();
				scanner.nextLine();

				if (nominal <= 0) {
					isTransactionInputValid = false;
					System.out.println(WHITE_BACKGROUND + RED_TEXT + "Are you really that bored...?" + RESET_COLOR);
					continue;
				}
			} catch (InputMismatchException ime) {
				isTransactionInputValid = false;
				System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please enter a number instead!" + RESET_COLOR);
				scanner.next();
//					System.out.println(WHITE_BACKGROUND + RED_TEXT + ime + RESET_COLOR);
				continue;
			}

			if (!currentUser.menabung(nominal)) {
				System.out.println(WHITE_BACKGROUND + RED_TEXT
						+ "Something went wrong when trying to deposit the money\ninto your account! Please try again later!"
						+ RESET_COLOR);
				isTransactionValid = false;
				break;
			}

			System.out.println(GREEN_TEXT + "Successfully deposited Rp" + nominal + " to " + currentUser.getNama() + "#"
					+ currentUser.getNoRekening() + RESET_COLOR);
		} while (!isTransactionInputValid);
	}

	public static void handleWithdrawal() {
		boolean isTransactionInputValid = true;
		boolean isTransactionValid = true;
		long nominal;
		System.out.println("=============== Withdrawal Menu ===============");
		do {
			isTransactionInputValid = true;
			try {
				System.out.print("Enter a nominal: ");
				nominal = scanner.nextLong();
				scanner.nextLine();

				if (nominal <= 0) {
					isTransactionInputValid = false;
					System.out.println(WHITE_BACKGROUND + RED_TEXT + "Are you really that bored...?" + RESET_COLOR);
					continue;
				} else if (nominal > currentUser.getSaldo()) {
					isTransactionInputValid = false;
					System.out.println(
							WHITE_BACKGROUND + RED_TEXT + "Unsufficient balance! Get to work bro." + RESET_COLOR);
					continue;
				}
			} catch (InputMismatchException ime) {
				isTransactionInputValid = false;
				System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please enter a number instead!" + RESET_COLOR);
				scanner.next();
//					System.out.println(WHITE_BACKGROUND + RED_TEXT + ime + RESET_COLOR);
				continue;
			}

			if (!currentUser.menarik(nominal)) {
				System.out.println(WHITE_BACKGROUND + RED_TEXT
						+ "Something went wrong when trying to withdraw your money!\nPlease try again later"
						+ RESET_COLOR);
				isTransactionValid = false;
				break;
			}

			System.out
					.println(GREEN_TEXT + "Successfully withdrawed Rp" + nominal + " from your account!" + RESET_COLOR);
		} while (!isTransactionInputValid);
	}

	public static void handleTransfer() {
		boolean isTransactionInputValid = true;
		boolean isTransactionValid = true;
		long nominal;
		System.out.println("=============== Transfer Menu ===============");
		showUsersList(currentUser.getNoRekening());
		do {
			int toRekening;
			isTransactionInputValid = true;
			try {
				System.out.print("Select destination account: ");
				toRekening = scanner.nextInt();
				scanner.nextLine();

				if (toRekening <= 0) {
					isTransactionInputValid = false;
					System.out.println(
							WHITE_BACKGROUND + RED_TEXT + "Please enter a valid account number!" + RESET_COLOR);
				} else if (users.stream().filter(u -> (u.getNoRekening() == toRekening)).findFirst().isEmpty()) {
					isTransactionInputValid = false;
					System.out.println(WHITE_BACKGROUND + RED_TEXT
							+ "Can't find an account with that number! Please make sure you have entered the correct one"
							+ RESET_COLOR);
				} else if (toRekening > 999999999) {
					isTransactionInputValid = false;
					System.out.println(WHITE_BACKGROUND + RED_TEXT + "Account number can only be up to 9 digits long!"
							+ RESET_COLOR);
				}

				System.out.print("Enter a nominal to be transferred from your account: ");
				nominal = scanner.nextLong();
				scanner.nextLine();

				if (nominal <= 0) {
					isTransactionInputValid = false;
					System.out.println(WHITE_BACKGROUND + RED_TEXT + "Are you really that bored...?" + RESET_COLOR);
					continue;
				} else if (nominal > currentUser.getSaldo()) {
					isTransactionInputValid = false;
					System.out.println(
							WHITE_BACKGROUND + RED_TEXT + "Unsufficient balance! Get to work bro." + RESET_COLOR);
					continue;
				}
			} catch (InputMismatchException ime) {
				isTransactionInputValid = false;
				System.out.println(
						WHITE_BACKGROUND + RED_TEXT + "Please enter a valid account number instead!" + RESET_COLOR);
				scanner.next();
//					System.out.println(WHITE_BACKGROUND + RED_TEXT + ime + RESET_COLOR);
				continue;
			}

			if (!currentUser.transfer(nominal, toRekening)) {
				System.out.println(WHITE_BACKGROUND + RED_TEXT
						+ "Something went wrong when trying to withdraw your money!\nPlease try again later"
						+ RESET_COLOR);
				isTransactionValid = false;
				break;
			}

			System.out.println(GREEN_TEXT + "Successfully transferred Rp" + nominal + "!" + RESET_COLOR);
		} while (!isTransactionInputValid);
	}

	public static void handleGetHistory() {
		currentUser.getHistory();
	}

	public static void main(String[] args) {
		initUsers();
		boolean isInputValid = true;
		int choice = 0;
		do {
			try {
				isInputValid = true;
				System.out.println("Hello! Welcome to Bank-U\n1. Add User\n2. Users List\n3. Transaction\n0. Exit");
				System.out.print("What do you want to do? ");
				choice = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException ime) {
				isInputValid = false;
				System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please enter a number instead!" + RESET_COLOR);
				scanner.next();
//					System.out.println(WHITE_BACKGROUND + RED_TEXT + ime + RESET_COLOR);
				continue;
			}

			switch (choice) {
			case 1:
				showAddUserMenu();
//				String c = LocalDateTime.now().toString();
//				System.out.println(c.toString());
//				System.out.println(LocalDateTime.parse(c));
				break;
			case 2:
				showUsersList();
				break;
			case 3:
				if (users.size() == 0) {
					System.out
							.println(YELLOW_TEXT + "There are no users yet! Are you being delusional??" + RESET_COLOR);
					break;
				}
				try {
					boolean doesUserExist = true;
					boolean isAlphabetsOnly = true;
					boolean isDigitsOnly = true;
					Optional<SandyBonfilioYuvens_User_CL> selectedUserQuery = Optional.empty();
					do {
						isInputValid = true;
						doesUserExist = true;
						isAlphabetsOnly = false;
						isDigitsOnly = false;
						showUsersList();
						System.out.print("Please select a user: ");
						String selectedUser = scanner.nextLine().trim().toLowerCase();
						if (selectedUser.isEmpty()) {
							isInputValid = false;
							System.out.println(
									RED_TEXT + WHITE_BACKGROUND + "Please choose an existing user!" + RESET_COLOR);
							continue;
						}

						// System.out.println(selectedUser);
//						System.out.println(ALPHABETS_PATTERN.matcher(selectedUser).find());
//						System.out.println(DIGITS_PATTERN.matcher(selectedUser).find());
						if (containsPattern(ALPHABETS_PATTERN, selectedUser)
								&& containsPattern(DIGITS_PATTERN, selectedUser)) {
							isInputValid = false;
							System.out.println(
									RED_TEXT + WHITE_BACKGROUND + "Make sure you entered a valid name!" + RESET_COLOR);
							continue;
						} else if (selectedUser.matches(DIGITS_PATTERN_REGEX)
								&& Integer.parseInt(selectedUser) > users.size()) {
							isInputValid = false;
							System.out.println(RED_TEXT + WHITE_BACKGROUND + "There is no user with an ID of "
									+ selectedUser + RESET_COLOR);
							continue;
						} else if (selectedUser.matches(FULL_NAME_PATTERN_REGEX)) {
							// } else if (selectedUser.matches(FULL_NAME_PATTERN)) {
							isAlphabetsOnly = true;
						} else if (selectedUser.matches(DIGITS_PATTERN_REGEX)) {
							isDigitsOnly = true;
						}

						try {
							currentUser = null;
							if (isAlphabetsOnly) {
								String selectedUserCleaned = selectedUser.replaceAll("\\s+", " ");
								// System.out.println(users.get(0).getNama().toLowerCase());
//								System.out.println(selectedUser);
//								System.out.println(users.stream());
//								System.out.println(users.stream()
//										.filter(u -> (u.getNama().toLowerCase().equals(selectedUserCleaned))));
//								selectedUserQuery = users.stream()
//										.filter(u -> (u.getNama().toLowerCase() == selectedUser)).findFirst();
//								System.out.println(selectedUserQuery);
								if (!selectedUserQuery.isPresent()) {
									currentUser = selectedUserQuery.get();
								}
							} else if (isDigitsOnly) {
								String selectedUserCleaned = selectedUser.replaceAll("\\s+", "");
								currentUser = users.get(Integer.parseInt(selectedUserCleaned) - 1);
							}

							if (currentUser == null) {
								doesUserExist = false;
								System.out.println(YELLOW_TEXT
										+ "We can't find the user you entered! Please make sure you entered a correct one"
										+ RESET_COLOR);
								continue;
							}

							if (currentUser.getNoRekening() == -1) {
								System.out.println(RED_TEXT + WHITE_BACKGROUND
										+ "An error occured while trying to do a transaction!\nPlease try again later"
										+ RESET_COLOR);
								break;
							}

							int transactionChoice = -1;
							boolean isTransactionInputValid = true;
							boolean isTransactionValid = true;
							do {
								try {
									isTransactionInputValid = true;
									isTransactionValid = true;
									System.out.print(
											"Available Transactions:\n1. Deposit/Save Up\n2. Withdrawal\n3. Transfer to Another Account\n4. See Pasts Transaction(s)\n5. Show Balance\nChoose a Transaction: ");
									transactionChoice = scanner.nextInt();
									scanner.nextLine();
								} catch (InputMismatchException ime) {
									isTransactionInputValid = false;
									System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please enter a number instead!"
											+ RESET_COLOR);
									scanner.next();
//										System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
									continue;
								}

								switch (transactionChoice) {
								case 1:
									try {
//										System.out.println("=============== Deposit/Save Up Menu ===============");
//										long nominal;
//										do {
//											isTransactionInputValid = true;
//											try {
//												System.out.print("Enter a nominal: ");
//												nominal = scanner.nextLong();
//												scanner.nextLine();
//
//												if (nominal <= 0) {
//													isTransactionInputValid = false;
//													System.out.println(WHITE_BACKGROUND + RED_TEXT
//															+ "Are you really that bored...?" + RESET_COLOR);
//													continue;
//												}
//											} catch (InputMismatchException ime) {
//												isTransactionInputValid = false;
//												System.out.println(WHITE_BACKGROUND + RED_TEXT
//														+ "Please enter a number instead!" + RESET_COLOR);
//												scanner.next();
										////												System.out.println(WHITE_BACKGROUND + RED_TEXT + ime + RESET_COLOR);
//												continue;
//											}
//
//											if (!currentUser.menabung(nominal)) {
//												System.out.println(WHITE_BACKGROUND + RED_TEXT
//														+ "Please enter a number instead!" + RESET_COLOR);
//												isTransactionValid = false;
//												break;
//											}
//
//											System.out.println(GREEN_TEXT + "Successfully deposited/saved up Rp"
//													+ nominal + " to " + currentUser.getNama() + "#"
//													+ currentUser.getNoRekening() + RESET_COLOR);
//										} while (!isTransactionInputValid);

										handleDeposit();
									} catch (Exception e) {
										System.out.println(WHITE_BACKGROUND + RED_TEXT
												+ "Something went wrong! Please try again later" + RESET_COLOR);
//										System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
										break;
									}
									break;
								case 2:
									try {
										handleWithdrawal();
									} catch (Exception e) {
										System.out.println(WHITE_BACKGROUND + RED_TEXT
												+ "Something went wrong! Please try again later" + RESET_COLOR);
//									System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
										break;
									}
									break;
								case 3:
									if (users.size() == 1) {
										System.out.println(
												WHITE_BACKGROUND + RED_TEXT + "There's only 1 user currently..\n"
														+ "Do you really want to transfer back and forth with yourself?"
														+ RESET_COLOR);
										break;
									}

									try {
										handleTransfer();
									} catch (Exception e) {
										System.out.println(WHITE_BACKGROUND + RED_TEXT
												+ "Something went wrong! Please try again later" + RESET_COLOR);
//									System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
										break;
									}
									break;
								case 4:
//									try {
									handleGetHistory();
//									} catch (Exception e) {
//										System.out.println(WHITE_BACKGROUND + RED_TEXT
//												+ "Something went wrong! Please try again later" + RESET_COLOR);
								////									System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
//										break;
//									}
									break;
								case 5:
									System.out.println(YELLOW_TEXT + "Your current balance is Rp"
											+ currentUser.getSaldo() + RESET_COLOR);
									break;
								case 0:
									break;
								default:
									System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please choose a valid action!"
											+ RESET_COLOR);
									break;
								}
							} while (transactionChoice != 0 || !isTransactionInputValid || !isTransactionValid);

						} catch (NumberFormatException ne) {
							System.out.println(WHITE_BACKGROUND + RED_TEXT
									+ "Please make sure you chose a valid account!" + RESET_COLOR);
							System.out.println(WHITE_BACKGROUND + RED_TEXT + ne + RESET_COLOR);
							break;
						} catch (IndexOutOfBoundsException ioobe) {
							System.out.println(WHITE_BACKGROUND + RED_TEXT
									+ "The user you tried to find doesn't exist! Please make sure it's the correct one"
									+ RESET_COLOR);
//							System.out.println(WHITE_BACKGROUND + RED_TEXT + ioobe + RESET_COLOR);
							break;
						} catch (Exception e) {
							System.out.println(WHITE_BACKGROUND + RED_TEXT
									+ "Something went wrong! Please try again later" + RESET_COLOR);
//							System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
							break;
						}
					} while (!doesUserExist || !isInputValid || selectedUserQuery == null);
				} catch (

				InputMismatchException ime) {
					System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please enter a number instead!" + RESET_COLOR);
					// System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
					scanner.next();
				} catch (IllegalArgumentException iae) {
					System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please enter a valid action!" + RESET_COLOR);
					// System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
				} catch (Exception e) {
					System.out.println(
							WHITE_BACKGROUND + RED_TEXT + "An error occured! Please try again later" + RESET_COLOR);
					// System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
				}
				break;
			case 0:
				try {
					long startTime;
					startTime = new Date().getTime();
					System.out.print("Exiting");
					while (new Date().getTime() - startTime < 1000) {
						System.out.print(".");
						Thread.sleep(250);
//						Thread.currentThread().interrupt();
					}
					System.out.println("\nThank You For Transacting in Bank-U! 😁🙏");
					System.exit(0);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
					System.out.println(WHITE_BACKGROUND + RED_TEXT + "\nSomething went wrong! Please try again later"
							+ RESET_COLOR);
//						System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
				} catch (Exception e) {
					System.out.println(
							WHITE_BACKGROUND + RED_TEXT + "An error occured! Please try again later" + RESET_COLOR);
//						System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
				}
				break;
			default:
				System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please choose a valid action!" + RESET_COLOR);
				break;
			}
		} while (choice != 0 || !isInputValid || Thread.currentThread().isInterrupted());
	}
}
