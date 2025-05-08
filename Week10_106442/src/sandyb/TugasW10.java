package sandyb;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;

import Model.Barang;
import Model.Handphone;
import Model.Order;
import Model.Voucher;

public class TugasW10 {
	public static final String BLACK_TEXT = "\u001B[30m";
	public static final String RED_TEXT = "\u001B[31m";
	public static final String GREEN_TEXT = "\u001B[32m";
	public static final String YELLOW_TEXT = "\u001B[33m";
	public static final String BLUE_TEXT = "\u001B[34m";
	public static final String PURPLE_TEXT = "\u001B[35m";
	public static final String CYAN_TEXT = "\u001B[36m";
	public static final String WHITE_TEXT = "\u001B[37m";
	public static final String BLACK_BACKGROUND = "\u001B[40m";
	public static final String RED_BACKGROUND = "\u001B[41m";
	public static final String GREEN_BACKGROUND = "\u001B[42m";
	public static final String YELLOW_BACKGROUND = "\u001B[43m";
	public static final String BLUE_BACKGROUND = "\u001B[44m";
	public static final String PURPLE_BACKGROUND = "\u001B[45m";
	public static final String CYAN_BACKGROUND = "\u001B[46m";
	public static final String WHITE_BACKGROUND = "\u001B[47m";
	public static final String RESET_COLOR = "\u001B[0m";
	public static DecimalFormat rupiahFormat = new DecimalFormat("#,##0.00");

	public static class Main {
		public static Scanner scanner = new Scanner(System.in);
		private static ArrayList<Barang> itemList = new ArrayList<>();
		private static ArrayList<Barang> handphoneList = new ArrayList<>();
		private static ArrayList<Barang> voucherList = new ArrayList<>();
		private static ArrayList<Order> orderHistory = new ArrayList<>();

		public static void initData() {
			addItemToList(new Handphone("H1", "Oppo", 1499999, 10, "Black"));
			addItemToList(new Voucher("V1", "Netflix 'n Chill", 1599999, 5, 1.2));
			addItemToList(new Voucher("V2", "Google Play", 99999, 100, 0.6));
			addItemToList(new Handphone("H2", "Samsung", 1999999, 15, "Blue"));
			addItemToList(new Handphone("H3", "iPhone", 2999999, 50, "Yellow"));
			addItemToList(new Voucher("V3", "Amazon Gift Card", 499999, 50, 0.8));
			addItemToList(new Voucher("V4", "Steam Wallet", 299999, 75, 0.9));
			addItemToList(new Handphone("H4", "Xiaomi", 1799999, 30, "White"));
			addItemToList(new Voucher("V5", "Spotify Premium", 129999, 120, 0.5));
			addItemToList(new Handphone("H5", "Realme", 1599999, 20, "Green"));
			addItemToList(new Voucher("V6", "Disney+ Subscription", 999999, 30, 1.0));
			addItemToList(new Voucher("V7", "Disney+ Subscription", 999999, 30, 1.0));
			addItemToList(new Voucher("V8", "Disney+ Subscription 2", 999999, 30, 1.0));
			addItemToList(new Handphone("H6", "OnePlus", 2499999, 25, "Red"));
			addItemToList(new Handphone("H7", "Sony Xperia", 2699999, 12, "Purple"));
			addItemToList(new Handphone("H8", "Google Pixel", 3299999, 8, "Silver"));
			addItemToList(new Voucher("V9", "PlayStation Plus", 799999, 40, 0.7));
			addItemToList(new Handphone("H9", "Huawei", 9999999.376, 18, "Gold"));
			addItemToList(new Handphone("H10", "Asus ROG", 3999999, 5, "Black"));
			addItemToList(new Handphone("H11", "Nokia", 1299999, 22, "Cyan"));
			addItemToList(new Handphone("H12", "iPhone 25 Pro Max", 199999999999999.3768, 18, "Titanium Blue"));
			addItemToList(new Handphone("H13", "Huawei", 123838383.0000, 18, "Black"));

			itemList.addAll(voucherList);
			itemList.addAll(handphoneList);
		}

		public static boolean compareTo(String a, String... b) {
//			boolean isAnyValid = false;
//			for (int i = 0; i < b.length; i++) {
//				int checks = a.toLowerCase().compareTo(b[i].toLowerCase());
//				if (checks == 0) {
//					isAnyValid = true;
//					break;
//				}
//			}
//			return isAnyValid;

			return Arrays.stream(b).anyMatch(s -> a.equalsIgnoreCase(s));
		}

		public static void showMainMenu() {
			System.out.println("------------sandytopup.com------------");
			System.out.println("1. Order an Item");
			System.out.println("2. Check Past Orders");
			System.out.println("3. Add New Item");
			System.out.print("Choose: ");
		}

		public static void showItemMenu(String itemType, int pageNumber, int pageSize) {
			/* opt 1 */

//			for (Barang i : itemList) {
//				if (itemType.equals("Handphone") && b instanceof Handphone) {
//					Handphone tempHandphone = (Handphone) b;
//					System.out.println("Item ID\t\t: " + tempHandphone.getId() + "\nItem Name\t: "
//							+ tempHandphone.getName() + "\nStock\t\t: " + tempHandphone.getStock() + "\nPrice\t\t: "
//							+ tempHandphone.getPrice() + "\nColor\t\t: " + tempHandphone.getColor()
//							+ "--------------------------------------");
//				} else if (itemType.equals("Voucher") && b instanceof Voucher) {
//					Voucher tempVoucher = (Voucher) b;
//					System.out.println("Item ID\t\t: " + tempVoucher.getId() + "\nItem Name\t: " + tempVoucher.getName()
//							+ "\nStock\t\t: " + tempVoucher.getStock() + "\nPrice\t\t: " + tempVoucher.getPrice()
//							+ "\nTax\t\t: " + tempVoucher.getTax() + "\n--------------------------------------");
//				}
//			}

			/* opt 2 */

//			System.out.println("------------Item List------------");
//			System.out.println("         sandytopup.com");
//			itemList.stream().filter(barang -> {
//				if (itemType.equals("Handphone")) {
//					return barang instanceof Handphone;
//				} else if (itemType.equals("Voucher")) {
//					return barang instanceof Voucher;
//				} else {
//					return false;
//				}
//			}).forEach(b -> {
//				System.out.println("Item ID\t: " + b.getId());
//				System.out.println("Item Name\t: " + b.getName());
//				System.out.println("Stock\t: ");
//				System.out.println("Price\t: ");
//				System.out.println("--------------------------------------");
//			});

//			for (Barang b : itemList) {
//				System.out.println("No.\t: " + itemList.indexOf(b) + 1);
//				System.out.println("Item Name\t: " + b.getName());
//				System.out.println("Stock\t: ");
//				System.out.println("Price\t: ");
//				System.out.println("--------------------------------------");
//			}

			/* opt 3 */

			ArrayList<Barang> itemList = itemType.equals("Handphone") ? handphoneList : voucherList;
			int totalItems = itemList.size() > 0 ? itemList.size() : 1;
			int totalPages = (int) Math.ceil((double) totalItems / pageSize);

			if (pageNumber < 1 || pageNumber > totalPages) {
				System.out.println("Invalid page number.");
				return;
			}

			int startIdx = (pageNumber - 1) * pageSize;
			int endIdx = Math.min(startIdx + pageSize, (itemList.size() > 0 ? itemList.size() : 1));

			int itemIndex = 0;

			if (compareTo(itemType, "handphone") && handphoneList.isEmpty()
					|| compareTo(itemType, "voucher") && voucherList.isEmpty()) {
//				System.out.printf(
//						WHITE_BACKGROUND + RED_TEXT  + "%38s\n%38s\n%13s%-25s\n"
//								+ (compareTo(itemType, "handphone") ? "%14s%-24s" : "%15s%-23s")
//								+ "\n%15s%-23s\n%12s%-26s\n%38s\n%38s\n" + RESET_COLOR,
//						"", "", "", "THERE ARE NO", "", itemType.toUpperCase() + "S", "", "FOR SALE", "",
//						"AT THE MOMENT D:", "", "");
				System.out.printf(
						WHITE_BACKGROUND + RED_TEXT + "%68s\n%68s\n%13s%-55s\n"
								+ (compareTo(itemType, "handphone") ? "%14s%-54s" : "%15s%-53s")
								+ "\n%15s%-53s\n%12s%-56s\n%68s\n%68s\n" + RESET_COLOR,
						"", "", "", "THERE ARE NO", "", itemType.toUpperCase() + "S", "", "FOR SALE", "",
						"AT THE MOMENT D:", "", "");
			} else {
				for (int i = startIdx; i < endIdx; i++) {
					Barang b = itemList.get(i);
					boolean isStockEmpty = b.getStockEmpty();
					boolean isTempStockEmpty = b.getTempStockEmpty();
					if (b.getTempStock() <= 0) {
						b.setStockEmpty(isTempStockEmpty);
						isTempStockEmpty = true;
					} else if (b.getStock() <= 0) {
						b.setStockEmpty(isStockEmpty);
						isStockEmpty = true;
					}
					if (b instanceof Handphone && !handphoneList.isEmpty()) {
						Handphone tempHandphone = (Handphone) b;
//					System.out.printf(WHITE_BACKGROUND + CYAN_TEXT + "Item ID\t\t: " + tempHandphone.getId()
//							+ "\nItem Name\t: " + tempHandphone.getName() + "\nStock\t\t: " + tempHandphone.getStock()
//							+ "\nPrice\t\t: " + tempHandphone.getPrice() + "\nColor\t\t: " + tempHandphone.getColor()
//							+ "\n" + YELLOW_TEXT + "--------------------------------------\n" + RESET_COLOR);
//						System.out.printf(
//								WHITE_BACKGROUND + RED_TEXT + "Item ID\t\t: %-20s\n" + "Item Name\t: %-20s\n"
//										+ "Stock\t\t: %-20s\n" + "Price\t\t: Rp%-70s\n" + "Color\t\t: %-20s\n"
//										+ BLACK_TEXT + "--------------------------------------\n" + RESET_COLOR,
//								tempHandphone.getId(), tempHandphone.getName(), tempHandphone.getStock(),
//								rupiahFormat.format(tempHandphone.getPrice()), tempHandphone.getColor());
						System.out.printf(WHITE_BACKGROUND + RED_TEXT + "Item ID\t\t: %-50s\n" + "Item Name\t: %-50s\n"
								+ "Stock\t\t: %-50s\n" + "Price\t\t: Rp%-48s\n" + "Color\t\t: %-50s\n" + BLACK_TEXT
								+ "--------------------------------------------------------------------\n"
								+ RESET_COLOR, tempHandphone.getId(), tempHandphone.getName(),
								(isStockEmpty
										? YELLOW_TEXT + RED_BACKGROUND + "OUT OF STOCK" + WHITE_BACKGROUND + RED_TEXT
												+ (" ").repeat(38)
										: tempHandphone.getStock()),
								rupiahFormat.format(BigDecimal.valueOf(tempHandphone.getPrice())),
								tempHandphone.getColor());
					} else if (b instanceof Voucher && !voucherList.isEmpty()) {
						Voucher tempVoucher = (Voucher) b;
//					System.out.println(WHITE_BACKGROUND + CYAN_TEXT + "Item ID\t\t: " + tempVoucher.getId()
//							+ "\nItem Name\t: " + tempVoucher.getName() + "\nStock\t\t: " + tempVoucher.getStock()
//							+ "\nPrice\t\t: " + tempVoucher.getPrice() + "\nTax\t\t: " + tempVoucher.getTax() + "\n"
//							+ YELLOW_TEXT + "--------------------------------------" + RESET_COLOR);
//						System.out.printf(
//								WHITE_BACKGROUND + RED_TEXT + "Item ID\t\t: %-20s\n" + "Item Name\t: %-20s\n"
//										+ "Stock\t\t: %-20s\n" + "Price\t\t: %-20s\n" + "Tax\t\t: %-20s\n" + BLACK_TEXT
//										+ "--------------------------------------\n" + RESET_COLOR,
//								tempVoucher.getId(), tempVoucher.getName(), tempVoucher.getStock(),
//								rupiahFormat.format(tempVoucher.getPrice()), tempVoucher.getTax());
						System.out.printf(WHITE_BACKGROUND + RED_TEXT + "Item ID\t\t: %-50s\n" + "Item Name\t: %-50s\n"
								+ "Stock\t\t: %-50s\n" + "Price\t\t: Rp%-48s\n" + "Tax\t\t: %-50s\n" + BLACK_TEXT
								+ "--------------------------------------------------------------------\n"
								+ RESET_COLOR, tempVoucher.getId(), tempVoucher.getName(),
								(isStockEmpty
										? YELLOW_TEXT + RED_BACKGROUND + "OUT OF STOCK" + WHITE_BACKGROUND + RED_TEXT
												+ (" ").repeat(38)
										: tempVoucher.getStock()),
								rupiahFormat.format(tempVoucher.getPrice()), tempVoucher.getTax() * 100 + "%");
					}
				}
			}
//			System.out.printf(
//					RED_BACKGROUND + WHITE_TEXT + "---------------PAGE %d/%d---------------\n\n" + RESET_COLOR,
//					pageNumber, totalPages);
			System.out.printf(RED_BACKGROUND + WHITE_TEXT
					+ "------------------------------PAGE %d/%d------------------------------\n\n" + RESET_COLOR,
					pageNumber, totalPages);
		}

		public static Barang showAddNewItemMenu(String choice) {
//			System.out.print("Voucher / Handphone (V/H): ");
//			String choice = scanner.nextLine().trim();
//			switch (choice) {
//			case "voucher":
//			case "v":
//			case "1":
//			case "handphone":
//			case "hp":
//			case "h":
//			case "2":
			System.out.print("Name\t: ");
			String nama = scanner.nextLine();
			double harga = 0.0;
			boolean isInputValid = true;
			do {
				isInputValid = true;
				System.out.print("Price\t: ");
				harga = scanner.nextDouble();
				scanner.nextLine();
//				System.out.println(harga);
//				System.out.println(rupiahFormat.format(Long.MAX_VALUE));
//				System.out.println(rupiahFormat.format(Double.MAX_VALUE));
//				if (harga < Long.MIN_VALUE || harga > Long.MAX_VALUE) {
//					System.out
//							.println(RED_TEXT + WHITE_BACKGROUND + "Your price has exceeded the limit!" + RESET_COLOR);
//					isInputValid = false;
//				} else if (harga < 0) {
				if (harga <= 0) {
					System.out
							.println(RED_TEXT + WHITE_BACKGROUND + "Price surely can't be free.. right?" + RESET_COLOR);
					isInputValid = false;
				} else if (harga > 100000000000.0) {
					System.out
							.println(RED_TEXT + WHITE_BACKGROUND + "Has inflation gone that high.. huh?" + RESET_COLOR);
					isInputValid = false;
				}
			} while (!isInputValid);

			int stok = 0;
			do {
				isInputValid = true;
				System.out.print("Stock\t: ");
				stok = scanner.nextInt();
				scanner.nextLine();
				if (stok < 0) {
					System.out.println(
							RED_TEXT + WHITE_BACKGROUND + "Your item doesn't exist in real life, huh?" + RESET_COLOR);
					isInputValid = false;
				} else if (stok > 999999999) {
					System.out.println(RED_TEXT + WHITE_BACKGROUND + "Damn.. our storage can't store that many stocks!"
							+ RESET_COLOR);
					isInputValid = false;
				}
			} while (!isInputValid);

			if (compareTo(choice, new String[] { "voucher", "v", "1" })) {
				double ppn;
				do {
					isInputValid = true;
					System.out.print("VAT\t: ");
					ppn = scanner.nextDouble();
					scanner.nextLine();
					if (ppn < 0) {
						ppn = 0;
					} else if (ppn > 1.0) {
						System.out.println(RED_TEXT + WHITE_BACKGROUND
								+ "Very greedy huh? The maximum VAT allowed is only 1.0 (100%)!" + RESET_COLOR);
						isInputValid = false;
					}
				} while (!isInputValid);
				System.out.println(GREEN_TEXT + WHITE_BACKGROUND + "Successfully addded the new voucher, " + nama + "!"
						+ RESET_COLOR);
//				return new Voucher(itemList.size() + 1, nama, harga, stok, ppn);
				return new Voucher("V" + voucherList.size() + 1, nama, harga, stok, ppn);
			} else if (compareTo(choice, new String[] { "handphone", "h", "hp", "2" })) {
				System.out.print("Color\t: ");
				String warna = scanner.nextLine();
				System.out.println(GREEN_TEXT + WHITE_BACKGROUND + "Successfully addded the new handphone, " + nama
						+ "!" + RESET_COLOR);
//				return new Handphone(itemList.size() + 1, nama, harga, stok, warna);
				return new Handphone("H" + handphoneList.size() + 1, nama, harga, stok, warna);
			}
//				break;
//			default:
//				System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please choose a valid option!\n" + RESET_COLOR);
//				scanner.next();
//			}
			System.out.println(
					WHITE_BACKGROUND + RED_TEXT + "Something went wrong! Please try again later" + RESET_COLOR);
			return null;
		}

		public static void showOrderItemMenu(String itemType) {
//			System.out.println(itemType);
//			if (compareTo(itemType, "voucher")) {
//
//			}
//
//			System.out.println(
//					BLUE_TEXT + YELLOW_BACKGROUND + "  Enter 0 at anyime to cancel this order!  " + RESET_COLOR);
//			System.out.print(itemType + "\'s ID\t: ");
//			int itemID = scanner.nextInt();
//
//			if (itemID == 0)
//				System.out.print("Quantity\t: ");
//			int itemQty = scanner.nextInt();
//			System.out.print("Your Payment\t: ");
//			long payment = scanner.nextLong();

			// payment handling

		}

		public static boolean addItemToList(Barang toBeAddedItem) {
			String itemType = toBeAddedItem.getClass().getSimpleName().toLowerCase();

			if (toBeAddedItem.getPrice() > 100000000000.0) {
				System.out.println(RED_TEXT + WHITE_BACKGROUND + "Has inflation gone that high.. huh?" + RESET_COLOR);
				System.out.println(
						RED_TEXT + WHITE_BACKGROUND + "We'll not be adding the item: " + toBeAddedItem.getName() + "#"
								+ toBeAddedItem.getId() + "! Give it a cheaper price" + RESET_COLOR);
				return false;
			}
			if (itemType.equalsIgnoreCase("handphone")) {
				if (handphoneList.stream().filter(h -> h.getName().equalsIgnoreCase(toBeAddedItem.getName()))
						.findFirst().isPresent()) {
					System.out.println(YELLOW_TEXT + "Skipping duplicates handphone: " + toBeAddedItem.getName() + "#"
							+ toBeAddedItem.getId() + RESET_COLOR);
					return false;
				}
//				System.out.println(GREEN_TEXT + "Successfully added the new handphone!" + RESET_COLOR);
				return handphoneList.add((Handphone) toBeAddedItem);
			} else if (itemType.equalsIgnoreCase("voucher")) {
				if (voucherList.stream().filter(v -> v.getName().equalsIgnoreCase(toBeAddedItem.getName())).findFirst()
						.isPresent()) {
					System.out.println(YELLOW_TEXT + "Skipping duplicates voucher: " + toBeAddedItem.getName() + "#"
							+ toBeAddedItem.getId() + RESET_COLOR);
					return false;
				}
//				System.out.println(GREEN_TEXT + "Successfully added the new voucher!" + RESET_COLOR);
				return voucherList.add((Voucher) toBeAddedItem);
			}

			return false;
//			System.out.println("selisih" + toBeAddedItem.getPrice());
//			System.out.println(Long.MAX_VALUE - toBeAddedItem.getPrice());
//			if (new DecimalFormat("#0,00").format(toBeAddedItem.getPrice()).length() > String.valueOf(Long.MAX_VALUE)
//					.length()) {
//				System.out.println(new DecimalFormat("#0.00").format(toBeAddedItem.getPrice()));
//				System.out.println(String.valueOf(toBeAddedItem.getPrice()).length());
//				System.out.println(String.valueOf(Long.MAX_VALUE).length());
//				System.out.println(String.valueOf(toBeAddedItem.getPrice()).length());
//				System.out.println("id " + toBeAddedItem.getId() + "\nname " + toBeAddedItem.getName() + "\nprice "
//						+ toBeAddedItem.getPrice());
//				System.out.println(RED_TEXT + WHITE_BACKGROUND + "Your price has exceeded the limit!" + RESET_COLOR);
//			}
//			System.out.println(toBeAddedItem.getPrice());
		}

		public static void main(String[] args) {
			try {
				int option = -1, continueChoice = -1;
				boolean isInputValid = true;
//				long startTime = System.nanoTime();
				initData();
//				System.out.println(((double) (System.nanoTime() - startTime) / 1000000) + "ms");
				do {
					try {
						isInputValid = true;
						showMainMenu();
						option = scanner.nextInt();
						if (option < 0 || option > 3) {
							isInputValid = false;
							throw new Exception(
									WHITE_BACKGROUND + RED_TEXT + "Please choose a valid option!" + RESET_COLOR);
						}
						scanner.nextLine();
						switch (option) {
						case 1:
							try {
								String[] itemPage = new String[] { "Handphone", "Voucher" };
								int pageNumber = 1;
								int pageSize = 5;
								int currCategoryChoice = 0;
								boolean isOrderSuccessful = true, isKeepBuying = false;
								boolean isListChanged = false, isChoiceValid = false, isPageChanged = false;
								do {
									boolean isOrderValid = true, isUserBuying = false;
									do {
										isUserBuying = false;
										isOrderValid = true;
										isListChanged = false;
										isChoiceValid = true;
										isPageChanged = false;
										isOrderSuccessful = true;
										isKeepBuying = false;
//										System.out.println("--------------Item List---------------\n"
//												+ "            sandytopup.com\n");
										System.out.println(
												"-----------------------------Item List------------------------------\n"
														+ "                           sandytopup.com\n");
//									startTime = System.nanoTime();

										if (currCategoryChoice == 0)
//											System.out.println(WHITE_BACKGROUND + BLACK_TEXT + "============= "
//													+ itemPage[currCategoryChoice] + "s =============" + RESET_COLOR);
											System.out.println(WHITE_BACKGROUND + BLACK_TEXT
													+ "============================ " + itemPage[currCategoryChoice]
													+ "s ============================" + RESET_COLOR);
										else if (currCategoryChoice == 1)
//											System.out.println(WHITE_BACKGROUND + BLACK_TEXT + "============== "
//													+ itemPage[currCategoryChoice] + "s ==============" + RESET_COLOR);
											System.out.println(WHITE_BACKGROUND + BLACK_TEXT
													+ "============================ " + itemPage[currCategoryChoice]
													+ "s ==============================" + RESET_COLOR);

										showItemMenu(itemPage[currCategoryChoice], pageNumber, pageSize);
//									System.out.println(((double) (System.nanoTime() - startTime) / 1000000) + "ms");

										int totalPages = (int) Math.ceil(
												(double) (itemPage[currCategoryChoice].equalsIgnoreCase("handphone")
														? (handphoneList.size() > 0 ? handphoneList.size() : 1)
														: (voucherList.size() > 0 ? voucherList.size() : 1))
														/ pageSize);

										System.out.println("1. Order A " + itemPage[currCategoryChoice]
												+ "\n2. See Available "
												+ (currCategoryChoice == 0 ? itemPage[currCategoryChoice + 1]
														: itemPage[currCategoryChoice - 1])
												+ "s\n"
												+ (pageNumber == 1 && totalPages == 1 ? "3. Back to Menu"
														: (pageNumber == 1 && totalPages > 1
																? "3. Go to Next Page\n4. Back to Menu"
																: (pageNumber > 1 && totalPages > 1
																		&& pageNumber != totalPages
																				? "3. Go to Previous Page\n4. Go to Next Page\n5. Back to Menu"
																				: "3. Go to Previous Page\n4. Back to Menu"))));
										System.out.print("Choose: ");
										int choice = scanner.nextInt();
										if (choice == 1) {
											isUserBuying = true;
										} else if (choice == 2) {
											if (currCategoryChoice == 0) {
												currCategoryChoice = 1;
												isListChanged = true;
												pageNumber = 1;
											} else {
												currCategoryChoice = 0;
												isListChanged = true;
												pageNumber = 1;
											}
										} else if (choice == 3 && pageNumber == 1 && totalPages == 1
												|| choice == 5 && pageNumber > 1 && totalPages > 1
														&& pageNumber != totalPages
												|| choice == 4 && pageNumber == 1 && totalPages > 1
												|| choice == 4 && pageNumber > 1 && pageNumber == totalPages) {
//										System.out.println(
//												"breakkkk " + (choice == 3 && pageNumber == 1 && totalPages == 1) + " "
//														+ (choice == 5 && pageNumber > 1 && totalPages > 1
//																&& pageNumber != totalPages)
//														+ " " + (choice == 4 && pageNumber == 1 && totalPages > 1) + " "
//														+ (choice == 4 && pageNumber > 1 && pageNumber == totalPages));
//											System.out.println("tess brek");
											break;
										} else if (choice == 3 && pageNumber == 1 && totalPages > 1
												|| choice == 4 && pageNumber > 1 && totalPages > 1) {
											pageNumber++;
											isPageChanged = true;
//											System.out.println("tess++");
										} else if (choice == 3 && pageNumber > 1 && totalPages > 1
												|| choice == 3 && pageNumber > 1 && pageNumber == totalPages) {
											pageNumber--;
											isPageChanged = true;
//									} else if (choice == 4) {
//										pageNumber++;
//										isPageChanged = true;
//									} else if (choice == 5) {
//										break;
//											System.out.println("tess-");
										} else {
											isChoiceValid = false;
											System.out.println(WHITE_BACKGROUND + RED_TEXT
													+ "Please Choose A Valid Option!" + RESET_COLOR);
										}

//									System.out.println("outerouter tes " + handphoneList.size());
//									System.out.println("outerouter tes " + voucherList.size());
//									System.out.println("outerouter tes "
//											+ (double) (itemPage[currCategoryChoice].equalsIgnoreCase("handphone")
//													? (handphoneList.size() > 0 ? handphoneList.size() : 1)
//													: (voucherList.size() > 0 ? voucherList.size() : 1)) / pageSize);

										if (pageNumber < 1)
											pageNumber = 1;
										if (pageNumber > totalPages)
											pageNumber = totalPages;

									} while (isListChanged || !isChoiceValid || isPageChanged || !isOrderValid);

									if (!isUserBuying)
										break;

									Order currOrder = new Order("O");
//									Order currOrder = new Order("O" + curr orderHistory.size() + 1);

									String itemType = itemPage[currCategoryChoice];

									try {
										Optional<Barang> selectedItemQuery = null;
										Barang selectedItem = null;
										boolean isOrderPaymentValid = true, isOrderCancelled = false,
												isStockEmpty = false;
										do {
											isOrderPaymentValid = true;
											isOrderCancelled = false;
											isStockEmpty = false;
											System.out.println(BLUE_TEXT + YELLOW_BACKGROUND
													+ "Enter 0 at anyime to cancel this order!" + RESET_COLOR);
											System.out.print(itemType + "\'s ID\t: ");
//											int itemID = scanner.nextInt();
											String itemID = scanner.next();

											if (itemID == null || itemID.isEmpty()) {
												System.out.println(RED_TEXT + WHITE_BACKGROUND
														+ "Make sure you gave a valid and existing ID!" + RESET_COLOR);
												isOrderPaymentValid = false;
												break;
											}

											if (itemID.matches("^0$")) {
												System.out.println(GREEN_TEXT + WHITE_BACKGROUND
														+ "Order successfully cancelled!" + RESET_COLOR);
												isOrderCancelled = true;
												break;
											}

											if (handphoneList.stream()
													.noneMatch(id -> id.getId().equalsIgnoreCase(itemID))
													&& compareTo(itemType, "handphone")
													|| voucherList.stream().noneMatch(id -> id.getId() == itemID)
															&& compareTo(itemType, "voucher")) {
												System.out.println(RED_TEXT + WHITE_BACKGROUND + itemType
														+ " with an ID of " + itemID + " is not found!" + RESET_COLOR);
//											System.out.println("ga ada woi itemnya " + itemID);
												isOrderPaymentValid = false;
												continue;
//										} else {
//											System.out.println("ada woi itemnya " + itemID);
//										}
											}

//											System.out.println("ada woi itemnya " + itemID);

//											startTime = System.nanoTime();
											ArrayList<Barang> tempList = (compareTo(itemType, "handphone")
													? handphoneList
													: voucherList);
//										System.out.println(tempList.toString());
//										System.out.println(handphoneList.toString());

											selectedItemQuery = tempList.stream()
													.filter(i -> i.getId().equalsIgnoreCase(itemID)).findFirst();

//											System.out.println(
//													((double) (System.nanoTime() - startTime) / 1000000) + "ms");
//
//											System.out.println(selectedItemQuery);

											if (selectedItemQuery.isEmpty()) {
												System.out.println(RED_TEXT + WHITE_BACKGROUND
														+ "Sorry, we can't find your desired item at the moment!\nPlease try again later"
														+ RESET_COLOR);
												isOrderSuccessful = false;
												break;
											}

											selectedItem = selectedItemQuery.get();

											if (selectedItem.getStockEmpty()) {
												isStockEmpty = true;
												System.out.println(RED_TEXT + WHITE_BACKGROUND
														+ "Chill.. chill, we will restock it ASAP!" + RESET_COLOR);
											}

//											System.out.print(selectedItem);

										} while (!isOrderPaymentValid && !isOrderCancelled || isStockEmpty);

										if (isOrderCancelled || !isOrderSuccessful)
											break;

										int itemQty;
										do {
											isOrderPaymentValid = true;
											isOrderCancelled = false;
											System.out.print("Quantity\t: ");
											itemQty = scanner.nextInt();

											// if (cancelPaymentHandler(itemQty))
//											break;

											Voucher tempVoucher = null;
											if (compareTo(itemType, "voucher")) {
												tempVoucher = (Voucher) selectedItem;
											}

											if (itemQty == 0) {
												System.out.println(GREEN_TEXT + WHITE_BACKGROUND
														+ "Order successfully cancelled!" + RESET_COLOR);
												isOrderCancelled = true;
												break;
											} else if (itemQty > selectedItem.getStock()) {
												System.out.println(RED_TEXT + WHITE_BACKGROUND
														+ "Sorry.. Our stock is not enough!" + RESET_COLOR);
												isOrderPaymentValid = false;
												continue;
											} else if ((compareTo(itemType, "voucher")
													&& (tempVoucher.getSellingPrice(itemQty)) > 1000000000000.0)
													|| (compareTo(itemType, "handphone") && (itemQty
															* selectedItem.getPrice() * itemQty) > 1000000000000.0)) {
												System.out.println(RED_TEXT + WHITE_BACKGROUND
														+ "Sorry.. you aren't allowed to buy this many stocks at once!\nWe're too lazy to count that much amount of money!"
														+ RESET_COLOR);
												isOrderPaymentValid = false;
												continue;
											}
											boolean isTempStokUpdated = (selectedItem.minusTempStock(itemQty)) ? true
													: false;
//											System.out.println(istemp);
											if (!isTempStokUpdated)
												isOrderPaymentValid = false;
										} while (!isOrderPaymentValid && !isOrderCancelled);

										if (isOrderCancelled)
											break;

										double totalPrice = 0.0;
//										BigDecimal totalPrice = BigDecimal.ZERO;
//										if (compareTo(itemType, "voucher")) {
//											Voucher tempItem = (Voucher) selectedItem;
										////											totalPrice = tempItem.getSellingPrice(itemQty);
//											totalPrice = BigDecimal.valueOf(tempItem.getSellingPrice(itemQty));
//										} else if (compareTo(itemType, "handphone")) {
//											Handphone tempItem = (Handphone) selectedItem;
//											totalPrice = BigDecimal.valueOf(tempItem.getPrice())
//													.multiply(BigDecimal.valueOf(itemQty))
//													.setScale(2, RoundingMode.HALF_UP);
										////											totalPrice = (double) (selectedItem.getPrice() * itemQty);
//										}
										if (compareTo(itemType, "voucher")) {
											Voucher tempItem = (Voucher) selectedItem;
//											totalPrice = tempItem.getSellingPrice(itemQty);
											System.out.println(tempItem.getPrice());
											totalPrice = tempItem.getSellingPrice(itemQty);
										} else if (compareTo(itemType, "handphone")) {
											Handphone tempItem = (Handphone) selectedItem;
//											System.out.println("tes" + tempItem.getPrice());
											System.out.println(tempItem.getPrice());
											totalPrice = (double) (tempItem.getPrice() * itemQty);
//											totalPrice = (double) (selectedItem.getPrice() * itemQty);
										}

										currOrder.addBarangToList(selectedItem, itemQty);
										double totalPriceBeforeTax = currOrder
												.calculateTotalPriceBeforeTax(currOrder.getBarangList());
										System.out.println(selectedItem.getPrice());
										System.out.println(totalPrice);

//										rupiahFormat.setDecimalSeparator('.');
//										rupiahFormat.setGroupingSeparator(',');
										System.out.println(itemQty + " @ " + selectedItem.getName() + "\t@1 / Rp"
												+ (rupiahFormat).format(selectedItem.getPrice()) + "\n\t\t\tRp"
//												+ rupiahFormat.format((totalPrice)));
												+ rupiahFormat.format((totalPriceBeforeTax)));
//														.replace(".", 0));
//												+ (selectedItem.getPrice() * itemQty).toLocaleString("in_ID"));
//												.format((selectedItem.getPrice() * itemQty))).replace(".", 0));
										System.out.println("SUBTOTAL\tRp" + rupiahFormat.format(totalPriceBeforeTax)
												+ (compareTo(itemType, "voucher")
														? "\nSERVICE CHARGE\tRp"
																+ rupiahFormat.format(totalPrice - totalPriceBeforeTax)
														: "")
												+ "\nGRAND TOTAL\tRp" + rupiahFormat.format(totalPrice));
										System.out.println("-------------------------");
//										System.out.println(
//												"PAYMENT TOTAL\tRp" + 
//										System.out.println(itemQty);
//										System.out.println(selectedItem.getPrice());
//										System.out.println(selectedItem.getPrice() * itemQty);
//										System.out.println(selectedItem.getPrice() * (double) itemQty);

										double payment = -1;
										do {
											isOrderPaymentValid = true;
											isOrderCancelled = false;
											System.out.print("Your Payment\t: ");
											payment = scanner.nextDouble();

											if (payment == 0) {
												System.out.println(GREEN_TEXT + WHITE_BACKGROUND
														+ "Order successfully cancelled!" + RESET_COLOR);
												isOrderCancelled = true;
												break;
											} else if (payment > 1000000000000.0) {
												System.out.println(RED_TEXT + WHITE_BACKGROUND
														+ "Okay rich boi, no need to show off! I don't have that much of a change."
														+ RESET_COLOR);
												isOrderPaymentValid = false;
											} else if (payment < totalPrice) {
												System.out.println(RED_TEXT + WHITE_BACKGROUND
														+ "You're too poor... huh?" + RESET_COLOR);
												isOrderPaymentValid = false;
												continue;
											}
										} while (!isOrderPaymentValid && !isOrderCancelled);

										currOrder.setUangBayaran(payment);
										double totalChange = payment - totalPrice;
										System.out.println(GREEN_TEXT + WHITE_BACKGROUND + "Your return change is Rp"
												+ rupiahFormat.format(totalChange) + RESET_COLOR);

										LocalDateTime dateTimeLocal = LocalDateTime.now();
										DateTimeFormatter dateTimeFormat = DateTimeFormatter
												.ofPattern("dd-MM-yyyy HH:mm:ss");
//										System.out.println(dateTimeLocal.format(dateTimeFormat));
										System.out.println(
												"Your order is successful! Please wait for it to be processed... 😁🙏🙏😎");
										currOrder.setTanggalPemesanan(dateTimeLocal.format(dateTimeFormat));

										currOrder.setPaymentDone(true);
										for (Entry<Barang, Integer> b : currOrder.getBarangList().entrySet()) {
											b.getKey().minusRealStock();
											currOrder.setJumlahBarang();
										}
										orderHistory.add(currOrder);
//										System.out.println(currOrder);
										isOrderSuccessful = true;

										do {
											try {
												isInputValid = true;
												System.out.print("Do you still want to do another transaction? ");
												continueChoice = scanner.nextInt();
												if (continueChoice != 0) {
													isKeepBuying = true;
												}
											} catch (InputMismatchException ime) {
												isInputValid = false;
//												System.out.println(WHITE_BACKGROUND + RED_TEXT + ime.getMessage() + RESET_COLOR);
												System.out.println(WHITE_BACKGROUND + RED_TEXT
														+ "Please enter a valid number instead!" + RESET_COLOR);
												scanner.next();
											} catch (Exception e) {
												isInputValid = false;
												System.out.println(RED_TEXT + WHITE_BACKGROUND
														+ "Something went wrong! Make sure you entered the correct option!"
														+ RESET_COLOR);
											}
										} while (!isInputValid);
									} catch (InputMismatchException ime) {
										isOrderSuccessful = false;
//										System.out.println(WHITE_BACKGROUND + RED_TEXT + ime.getMessage() + RESET_COLOR);
										System.out.println(WHITE_BACKGROUND + RED_TEXT
												+ "The value you entered might not be valid or isn't in the valid range!"
												+ RESET_COLOR);
										scanner.next();
									} catch (Exception e) {
										isOrderSuccessful = false;
										System.out.println(RED_TEXT + WHITE_BACKGROUND + e.getMessage() + RESET_COLOR);
									}
								} while (!isOrderSuccessful || isKeepBuying);

							} catch (InputMismatchException ime) {
								isInputValid = false;
//								System.out.println(WHITE_BACKGROUND + RED_TEXT + ime.getMessage() + RESET_COLOR);
								System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please enter a valid number instead!"
										+ RESET_COLOR);
								scanner.next();
							} catch (IllegalArgumentException iae) {
								isInputValid = false;
//								System.out.println(WHITE_BACKGROUND + RED_TEXT + iae.getMessage() + RESET_COLOR);
								System.out.println(
										WHITE_BACKGROUND + RED_TEXT + "Please enter a valid ID!" + RESET_COLOR);
							} catch (Exception e) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT
										+ "An error occured! Please try again later" + RESET_COLOR);
//								System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
							}
							break;
						case 2:
							try {
								if (orderHistory.isEmpty())
									System.out.println(RED_TEXT + WHITE_BACKGROUND + "There are no orders made yet!"
											+ RESET_COLOR);
								for (Order o : orderHistory) {
//									System.out.println(o.toString());
									o.orderDisplay();
								}
							} catch (InputMismatchException ime) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please enter a valid number instead!"
										+ RESET_COLOR);
								scanner.next();
							} catch (IllegalArgumentException iae) {
								isInputValid = false;
//								System.out.println(WHITE_BACKGROUND + RED_TEXT + iae.getMessage() + RESET_COLOR);
								System.out.println(WHITE_BACKGROUND + RED_TEXT
										+ "Please enter a value within the valid range!" + RESET_COLOR);
							} catch (Exception e) {
								isInputValid = false;
//								System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
								System.out.println(WHITE_BACKGROUND + RED_TEXT
										+ "An error occured! Please try again later" + RESET_COLOR);
							}
							break;
						case 3:
							try {
								Barang toBeAddedItem = null;
								do {
									System.out.print("Voucher / Handphone (V/H): ");
									String choice = scanner.nextLine().trim();
									switch (choice.toLowerCase()) {
									case "voucher":
									case "v":
									case "1":
									case "handphone":
									case "hp":
									case "h":
									case "2":
										toBeAddedItem = showAddNewItemMenu(choice);
										break;
									default:
										System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please choose a valid option!"
												+ RESET_COLOR);
										break;
									}
								} while (toBeAddedItem == null);
								addItemToList(toBeAddedItem);
							} catch (InputMismatchException ime) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please enter a valid number instead!"
										+ RESET_COLOR);
								scanner.next();
							} catch (IllegalArgumentException iae) {
								isInputValid = false;
//								System.out.println(WHITE_BACKGROUND + RED_TEXT + iae.getMessage() + RESET_COLOR);
								System.out.println(WHITE_BACKGROUND + RED_TEXT
										+ "Please enter a value within the valid range!" + RESET_COLOR);
							} catch (Exception e) {
								isInputValid = false;
								System.out.println(WHITE_BACKGROUND + RED_TEXT
										+ "An error occured! Please try again later" + RESET_COLOR);
//								System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
							}
							break;
						case 0:
							System.out.println("Exiting program...");
							Thread.sleep(2000);
							System.out.println("Thank you for visiting sandytopup.com!");
						default:
							break;
						}
					} catch (InputMismatchException ime) {
						System.out.println(
								WHITE_BACKGROUND + RED_TEXT + "Please enter a valid number instead!" + RESET_COLOR);
//						System.out.println(WHITE_BACKGROUND + RED_TEXT + ime.getMessage() + RESET_COLOR);
						scanner.next();
						isInputValid = false;
					} catch (Exception e) {
						System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please choose a valid option!" + RESET_COLOR);
//						System.out.println(WHITE_BACKGROUND + RED_TEXT + e.getMessage() + RESET_COLOR);
						isInputValid = false;
					}
				} while (option != 0 || !isInputValid);
			} catch (InputMismatchException ime) {
				System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please enter a valid number instead!" + RESET_COLOR);
//				System.out.println(WHITE_BACKGROUND + RED_TEXT + ime.getMessage() + RESET_COLOR);
				scanner.next();
			} catch (Exception e) {
				System.out.println(WHITE_BACKGROUND + RED_TEXT + "Please choose a valid option!" + RESET_COLOR);
				System.out.println(WHITE_BACKGROUND + RED_TEXT + e + RESET_COLOR);
			} finally {
				scanner.close();
				System.exit(0);
			}
		}
	}
}
