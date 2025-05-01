package sandyb;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 * pake hashmap dan handle semua user input pake itu kalo nanti niat/sempet
 * belajar aja dlu ygy
*/

public class TugasW08 {
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

	public static class Item {
		private String name;
		private String type;
		private int price;

		public Item(String name, String type, int price) {
			super();
			this.name = name;
			this.type = type;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public void displayInfo() {
			System.out.println("Nama\t: " + this.getName());
			System.out.println("Tipe\t: " + this.getType());
			System.out.println("Harga\t: " + this.getPrice());
		}
	}

	public static abstract class Payment {
		protected boolean isPaidOff;
		protected Item item;

		public abstract int pay();

		public abstract String getClassName();

		public Payment() {
			this.isPaidOff = false;
			this.item = null;
		}

		public Payment(Item item) {
			this.isPaidOff = false;
			this.item = item;
		}

		public boolean isPaidOff() {
			return isPaidOff;
		}

		public Item getItem() {
			return item;
		}

		public String getItemName() {
			return item.getName();
		}

		public String getStatus() {
			if (isPaidOff)
				return "FINISHED";
			return "ON PROGRESS";
		}

		public int getRemainingAmount() {
			if (isPaidOff)
				return 0;
			return item.getPrice();
		}

		public void displayInfo() {
			System.out.println("Nama\t\t: " + this.item.getName());
			System.out.println("Tipe\t\t: " + this.item.getType());
			System.out.println("Status\t\t: " + this.getStatus());
			System.out.println("Pembayaran\t: " + (this.getClassName().equalsIgnoreCase("cash") ? "Tunai" : "Kredit"));
			System.out.printf(
					(this.getRemainingAmount() > 0 ? "Sisa Pembayaran\t: " + this.getRemainingAmount()
							: WHITE_BACKGROUND + GREEN_TEXT + "%11sLunas" + (" ").repeat(12)) + "\n" + RESET_COLOR,
					" ");
		}

//		public void displayInfo() {
//			System.out.println("Nama\t: " + this.item.getName());
//			System.out.println("Tipe\t: " + this.item.getType());
//			System.out.println("Status\t: " + this.getStatus());
//			System.out.println("Sisa Pembayaran\t: " + this.getRemainingAmount());
//		}
	}

	public static class Cash extends Payment {
		public Cash(Item item) {
			super(item);
		}

		@Override
		public int pay() {
			if (isPaidOff)
				return 0;
			isPaidOff = true;
			return this.item.getPrice();
		}

		@Override
		public String getClassName() {
			return "CASH";
		}
	}

	public static class Credit extends Payment {
		private int installment;
		private int maxInstallmentAmount;

		public Credit(Item item, int maxInstallmentAmount) {
			super(item);
			this.installment = 0;
			this.maxInstallmentAmount = maxInstallmentAmount;
		}

		@Override
		public int pay() {
			if (isPaidOff)
				return 0;
			return this.item.getPrice() / this.maxInstallmentAmount;
		}

		@Override
		public int getRemainingAmount() {
			int currentInstallmentPaid = this.installment * (this.item.getPrice() / this.maxInstallmentAmount);
//			System.out.println(currentInstallmentPaid);
			if (isPaidOff || currentInstallmentPaid >= this.item.getPrice()) {
				isPaidOff = true;
				return 0;
			}
//			System.out.println(this.item.getPrice());
//			System.out.println(this.item.getPrice() - currentInstallmentPaid);
			return this.item.getPrice() - currentInstallmentPaid;
		}

		@Override
		public String getClassName() {
			return "CREDIT";
		}
	}

	public static class Main {
		static ArrayList<Item> ListOfItems = new ArrayList<>();
		static ArrayList<Payment> ListOfPayments = new ArrayList<>();
		static Scanner scanner = new Scanner(System.in);

		public static record PaymentResult(boolean isPaymentDone, boolean isPaymentCancelled) {
		}

		public static void seedData() {
			ListOfItems.add(new Item("Kulkas", "Elektronik", 3200000));
			ListOfItems.add(new Item("TV", "Elektronik", 4800000));
			ListOfItems.add(new Item("Laptop", "Komputer", 8700000));
			ListOfItems.add(new Item("PC", "Komputer", 13400000));
			ListOfItems.add(new Item("PC Bekas", "Komputer", 6000000));
		}

		public static void listItems() {
			System.out.println("----Daftar Barang----");
			for (int i = 0; i < ListOfItems.size(); i++) {
				System.out.println("No\t: " + (i + 1));
				ListOfItems.get(i).displayInfo();
				System.out.println("----------------------------");
			}
		}

		public static void listPayments() {
			System.out.println("----Riwayat Pesanan----");
			for (int i = 0; i < ListOfPayments.size(); i++) {
				System.out.println("No\t\t: " + (i + 1));
				ListOfPayments.get(i).displayInfo();
				System.out.println("----------------------------");
			}
		}

		public static Item handleItemSearch(String itemNameToBeSearched, boolean isDigit) {
			if (isDigit) {
				int indexToBeSearched = Integer.valueOf(itemNameToBeSearched);
				if (indexToBeSearched > 0 && indexToBeSearched <= ListOfItems.size()) {
					return ListOfItems.get(indexToBeSearched - 1);
				}
			}
			for (Item item : ListOfItems) {
				if (item.getName().equalsIgnoreCase(itemNameToBeSearched)) {
					return item;
				}
			}
			return null;
		}

		public static Payment handlePaymentSearch(String paymentIndexToBeSearched) {
			int indexToBeSearched = Integer.valueOf(paymentIndexToBeSearched);
			if (indexToBeSearched > 0 && indexToBeSearched <= ListOfPayments.size()) {
				return ListOfPayments.get(indexToBeSearched - 1);
			}
			for (Payment payment : ListOfPayments) {
				if (payment.item.getName().equalsIgnoreCase(paymentIndexToBeSearched)) {
					return payment;
				}
			}
			return null;
		}

		public static PaymentResult handlePayment(Payment payment, int paymentMethod, Item itemBought) {
			boolean continueLooping = false;
			boolean isPaymentProcessValid = true;
			boolean isPaymentCancelled = false;
			if (paymentMethod == 1 && payment == null) {
				Cash tempCashPayment = new Cash(itemBought);
				do {
					isPaymentProcessValid = true;
					isPaymentCancelled = false;
					continueLooping = false;
					System.out.print("Apakah Anda ingin langsung melakukan pembayaran (Y/N)? ");
					String paymentChoice = scanner.next();

					switch (paymentChoice.toLowerCase()) {
					case "0":
						isPaymentCancelled = true;
						System.out.println(YELLOW_TEXT + "Membatalkan pesanan..." + RESET_COLOR);
						continue;
					case "y":
					case "ya":
					case "yes":
						do {
							isPaymentProcessValid = true;
							System.out.println("Harga Pembayaran: " + itemBought.getPrice());
							System.out.print("Bayar: ");
							if (!scanner.hasNextInt()) {
								scanner.nextLine();
								System.out.println(RED_TEXT + WHITE_BACKGROUND + "Masukkan jumlah bayar yang valid!"
										+ RESET_COLOR);
								isPaymentProcessValid = false;
								continue;
							}

							int jumlahUangPembayaran = scanner.nextInt();
							scanner.nextLine();
							if (jumlahUangPembayaran < itemBought.price || jumlahUangPembayaran > 999999999) {
								System.out.println(RED_TEXT + WHITE_BACKGROUND
										+ "Pastikan uang Anda cukup dan tidak mencapai 1 miliar atau lebih!"
										+ RESET_COLOR);
								isPaymentProcessValid = false;
								continue;
							}

							int uangKembalian = jumlahUangPembayaran - itemBought.getPrice() > 0
									? jumlahUangPembayaran - itemBought.getPrice()
									: 0;

							if (uangKembalian > 0) {
								System.out.println(
										YELLOW_TEXT + "Sisa kembalian Anda sejumlah: " + uangKembalian + RESET_COLOR);
							}

							System.out.println(GREEN_TEXT + "Pesanan telah dibayar lunas! Terima kasih" + RESET_COLOR);
							tempCashPayment.isPaidOff = true;
						} while (!isPaymentProcessValid);

						break;
//						ListOfPayments.add(tempCashPayment);
//						return new PaymentResult(isPaymentProcessValid, isPaymentCancelled);
					case "n":
					case "tidak":
					case "no":
						System.out.println(YELLOW_TEXT
								+ "Pesanan berhasil disimpan!\nAnda dapat menyelesaikan transaksi ini kapan saja melalui menu Lihat Pesanan"
								+ RESET_COLOR);
//						ListOfPayments.add(tempCashPayment);
						break;
					default:
						System.out
								.println(RED_TEXT + WHITE_BACKGROUND + "Silakan pilih opsi yang valid!" + RESET_COLOR);
						continueLooping = true;
						continue;
					}
				} while (continueLooping && !isPaymentCancelled);

				if (isPaymentProcessValid && !isPaymentCancelled)
					ListOfPayments.add(tempCashPayment);

//				return new PaymentResult(isPaymentProcessValid, isPaymentCancelled);
			} else if (paymentMethod == 2 && payment == null) {
				Credit tempCreditPayment = null;
				int maxInstallmentAmount = 0;
				do {
					isPaymentCancelled = false;
					isPaymentProcessValid = true;
					continueLooping = false;
					System.out.print("Pilih Lama Cicilan (3/6/9/12 Bulan): ");
					String paymentChoice = scanner.nextLine();
					switch (paymentChoice.toLowerCase()) {
					case "0":
						isPaymentCancelled = true;
						System.out.println(YELLOW_TEXT + "Membatalkan pesanan..." + RESET_COLOR);
						continue;
					case "3":
					case "3 bulan":
					case "tiga":
					case "tiga bulan":
						maxInstallmentAmount = 3;
						break;
					case "6":
					case "6 bulan":
					case "enam":
					case "enam bulan":
						maxInstallmentAmount = 6;
						break;
					case "9":
					case "9 bulan":
					case "sembilan":
					case "sembilan bulan":
						maxInstallmentAmount = 9;
						break;
					case "12":
					case "12 bulan":
					case "dua belas":
					case "dua belas bulan":
						maxInstallmentAmount = 12;
						break;
					default:
						System.out
								.println(RED_TEXT + WHITE_BACKGROUND + "Silakan pilih opsi yang valid!" + RESET_COLOR);
						continueLooping = true;
						continue;
					}
				} while (continueLooping && !isPaymentCancelled);

//				maxInstallmentAmount = 0;

				if (isPaymentCancelled) {
//					System.out.println(isPaymentProcessValid + "  1212 " + isPaymentCancelled);
					return new PaymentResult(isPaymentProcessValid, isPaymentCancelled);
				}

				if (maxInstallmentAmount == 0) {
					isPaymentProcessValid = false;
//					System.out.println(isPaymentProcessValid + "  kawkw " + isPaymentCancelled);
					return new PaymentResult(isPaymentProcessValid, isPaymentCancelled);
				}

				tempCreditPayment = new Credit(itemBought, maxInstallmentAmount);

				do {
					isPaymentProcessValid = true;
					System.out.println("Harga Pembayaran Minimum Bulan Ini: " + tempCreditPayment.pay());
					System.out.print("Bayar: ");
					if (!scanner.hasNextInt()) {
						if (scanner.hasNext()) {
							scanner.nextLine();
						}
						System.out.println(RED_TEXT + WHITE_BACKGROUND
								+ "Masukkan jumlah bayar yang valid & tidak mencapai 1 miliar atau lebih!"
								+ RESET_COLOR);
						isPaymentProcessValid = false;
						continue;
					}
					int jumlahBayarCicilan = 0;
					long tempJumlahBayarCicilan = scanner.nextLong();
					scanner.nextLine();
					int uangKembalian = 0;
					if (tempJumlahBayarCicilan < tempCreditPayment.pay() || tempJumlahBayarCicilan > 999999999) {
						System.out.println(RED_TEXT + WHITE_BACKGROUND
								+ "Pastikan uang Anda cukup dan tidak mencapai 1 miliar atau lebih!" + RESET_COLOR);
						isPaymentProcessValid = false;
						continue;
					}
					jumlahBayarCicilan = (int) tempJumlahBayarCicilan;
					if (jumlahBayarCicilan > tempCreditPayment.pay()
							&& jumlahBayarCicilan / tempCreditPayment.pay() >= 2
							&& tempCreditPayment.getRemainingAmount() > 0) {
						do {
							continueLooping = false;
							int cicilBulanDepan = (jumlahBayarCicilan
									/ tempCreditPayment.pay() > tempCreditPayment.maxInstallmentAmount
											? (tempCreditPayment.maxInstallmentAmount - 1)
											: (jumlahBayarCicilan / tempCreditPayment.pay() - 1));
							if (jumlahBayarCicilan / tempCreditPayment.pay() > 1 && jumlahBayarCicilan
									/ tempCreditPayment.pay() >= tempCreditPayment.maxInstallmentAmount)
								cicilBulanDepan = tempCreditPayment.maxInstallmentAmount;

							if (cicilBulanDepan == 0) {
								continueLooping = true;
								continue;
							}

							System.out.print(YELLOW_TEXT
									+ "Anda membayar lebih dari yang seharusnya!\nApakah sisa tersebut ingin Anda bayar untuk cicilan "
									+ cicilBulanDepan + " bulan berikutnya juga (Y/N)? " + RESET_COLOR);

							String forwardInstallment = scanner.nextLine();
							switch (forwardInstallment.toLowerCase()) {
							case "y":
							case "ya":
							case "yes":
								tempCreditPayment.installment += 1;
								if (cicilBulanDepan
										+ tempCreditPayment.installment >= tempCreditPayment.maxInstallmentAmount) {
									System.out.println(GREEN_TEXT + "Cicilan Anda telah lunas!" + RESET_COLOR);
									uangKembalian = jumlahBayarCicilan - itemBought.getPrice();
									if (uangKembalian > 0)
										System.out.println(YELLOW_TEXT + "Sisa kembalian Anda sejumlah: "
												+ uangKembalian + RESET_COLOR);
									tempCreditPayment.isPaidOff = true;
								} else {
									tempCreditPayment.installment += cicilBulanDepan;
									System.out.println(GREEN_TEXT + "Berhasil membayar cicilan sampai bulan ke-"
											+ tempCreditPayment.installment + "!" + RESET_COLOR
											+ "\nSisa cicilan Anda:\n" + tempCreditPayment.getRemainingAmount()
											+ " dalam tempo "
											+ (tempCreditPayment.maxInstallmentAmount - tempCreditPayment.installment)
											+ " bulan kedepan!");
									uangKembalian = jumlahBayarCicilan
											- (tempCreditPayment.installment * tempCreditPayment.pay());
									if (uangKembalian > 0)
										System.out.println(YELLOW_TEXT + "Sisa kembalian Anda sejumlah: "
												+ uangKembalian + RESET_COLOR);
								}
//								if (jumlahBayarCicilan % tempCreditPayment.pay() > 0)
//									System.out.println(YELLOW_TEXT + "Sisa kembalian Anda sejumlah: "
//											+ jumlahBayarCicilan % tempCreditPayment.pay() + RESET_TEXT);
//								ListOfPayments.add(tempCreditPayment);
								break;
							case "n":
							case "tidak":
							case "no":
								tempCreditPayment.installment += 1;
								System.out.println(
										YELLOW_TEXT + "Sisa kembalian Anda sejumlah: " + uangKembalian + RESET_COLOR);
								System.out.println(GREEN_TEXT + "Berhasil membayar cicilan untuk bulan ke-"
										+ tempCreditPayment.installment + "!" + RESET_COLOR + "\nSisa cicilan Anda:\n"
										+ tempCreditPayment.getRemainingAmount() + " dalam tempo "
										+ (tempCreditPayment.maxInstallmentAmount - tempCreditPayment.installment)
										+ " bulan kedepan!");
								uangKembalian = jumlahBayarCicilan - itemBought.getPrice();
								System.out.println(YELLOW_TEXT
										+ "Pesanan telah tersimpan!\nPastikan Anda membayar cicilan berikutnya sebelum tenggat berakhir!"
										+ RESET_COLOR);
								break;
							default:
								System.out.println(
										RED_TEXT + WHITE_BACKGROUND + "Silakan pilih opsi yang valid!" + RESET_COLOR);
								continueLooping = true;
								continue;
							}
						} while (continueLooping);
					} else if (jumlahBayarCicilan > tempCreditPayment.pay()
							&& tempCreditPayment.getRemainingAmount() > 0) {
						tempCreditPayment.installment += 1;
						uangKembalian = jumlahBayarCicilan - tempCreditPayment.pay();
						System.out.println(YELLOW_TEXT + "Sisa kembalian Anda sejumlah " + uangKembalian + RESET_COLOR);
						System.out.println(YELLOW_TEXT
								+ "Pesanan telah tersimpan!\nPastikan Anda membayar cicilan berikutnya sebelum tenggat berakhir!"
								+ RESET_COLOR);
					} else {
						tempCreditPayment.installment += 1;
						System.out.println(GREEN_TEXT + "Berhasil membayar cicilan untuk bulan ke-"
								+ tempCreditPayment.installment + "!" + RESET_COLOR + "\nSisa cicilan Anda:\n"
								+ tempCreditPayment.getRemainingAmount() + " dalam tempo "
								+ (tempCreditPayment.maxInstallmentAmount - tempCreditPayment.installment)
								+ " bulan kedepan!");
						System.out.println(YELLOW_TEXT
								+ "Pesanan telah tersimpan!\nPastikan Anda membayar cicilan berikutnya sebelum tenggat berakhir!"
								+ RESET_COLOR);
					}
				} while (!isPaymentProcessValid);
				ListOfPayments.add(tempCreditPayment);
//				System.out.println("berhasil ditambahkan ke list");
			} else if (paymentMethod == 1 && payment != null) {
				Cash tempCashPayment = (Cash) payment;
				if (tempCashPayment.getRemainingAmount() <= 0) {
					System.out.println(GREEN_TEXT + "Transaksi Anda sudah lunas!\nKecuali Anda ingin bersedekah 😁🙏"
							+ RESET_COLOR);
//					System.out.println(isPaymentProcessValid + " kiwkiw " + isPaymentCancelled);
					return new PaymentResult(isPaymentProcessValid, isPaymentCancelled);
				}
				do {
					isPaymentProcessValid = true;
					isPaymentCancelled = false;
					continueLooping = false;
					System.out.print("Apakah Anda ingin melanjutkan pembayaran (Y/N)? ");
					String paymentChoice = scanner.next();

					switch (paymentChoice.toLowerCase()) {
					case "0":
						isPaymentCancelled = true;
						System.out.println(YELLOW_TEXT + "Membatalkan transaksi..." + RESET_COLOR);
						continue;
					case "y":
					case "ya":
					case "yes":
						do {
							isPaymentProcessValid = true;
							System.out.println("Harga Pembayaran: " + itemBought.getPrice());
							System.out.print("Bayar: ");
							if (!scanner.hasNextInt()) {
								scanner.nextLine();
								System.out.println(RED_TEXT + WHITE_BACKGROUND + "Masukkan jumlah bayar yang valid!"
										+ RESET_COLOR);
								isPaymentProcessValid = false;
								continue;
							}

							// handle int input agak rumit & susah tanpa try-catch

							int jumlahUangPembayaran = scanner.nextInt();
							scanner.nextLine();
							if (jumlahUangPembayaran < itemBought.price || jumlahUangPembayaran > 999999999) {
								System.out.println(RED_TEXT + WHITE_BACKGROUND
										+ "Pastikan uang Anda cukup dan tidak mencapai 1 miliar atau lebih!"
										+ RESET_COLOR);
								isPaymentProcessValid = false;
								continue;
							}

							int uangKembalian = jumlahUangPembayaran - itemBought.getPrice() > 0
									? jumlahUangPembayaran - itemBought.getPrice()
									: 0;

							if (uangKembalian > 0) {
								System.out.println(
										YELLOW_TEXT + "Sisa kembalian Anda sejumlah: " + uangKembalian + RESET_COLOR);
							}

							System.out
									.println(GREEN_TEXT + "Transaksi telah dibayar lunas! Terima kasih" + RESET_COLOR);
							tempCashPayment.isPaidOff = true;
						} while (!isPaymentProcessValid);
//						ListOfPayments.add(tempCashPayment);
//						return new PaymentResult(isPaymentProcessValid, isPaymentCancelled);
						break;
					case "n":
					case "tidak":
					case "no":
						System.out.println(YELLOW_TEXT
								+ "Transaksi berhasil ditunda!\nAnda dapat menyelesaikan transaksi ini kapan saja melalui menu Lihat Pesanan"
								+ RESET_COLOR);
//						ListOfPayments.add(tempCashPayment);
						break;
					default:
						System.out
								.println(RED_TEXT + WHITE_BACKGROUND + "Silakan pilih opsi yang valid!" + RESET_COLOR);
						continueLooping = true;
						continue;
					}
				} while (continueLooping);
			} else if (paymentMethod == 2 && payment != null) {
				Credit tempCreditPayment = (Credit) payment;
				if (tempCreditPayment.getRemainingAmount() <= 0) {
					System.out.println(
							GREEN_TEXT + "Cicilan Anda sudah lunas!\nKecuali Anda ingin bersedekah 😁🙏" + RESET_COLOR);
					System.out.println(isPaymentProcessValid + " wakwak " + isPaymentCancelled);
					return new PaymentResult(isPaymentProcessValid, isPaymentCancelled);
				}

				int maxInstallmentAmount = tempCreditPayment.maxInstallmentAmount;
				if (maxInstallmentAmount == 0) {
					isPaymentProcessValid = false;
					System.out.println(isPaymentProcessValid + "  piwpiw " + isPaymentCancelled);
					return new PaymentResult(isPaymentProcessValid, isPaymentCancelled);
				}

				do {
					isPaymentProcessValid = true;
					System.out.println("Harga Pembayaran Minimum Bulan Ini: " + tempCreditPayment.pay());
					System.out.print("Bayar: ");
					if (!scanner.hasNextInt()) {
						if (scanner.hasNext()) {
							scanner.nextLine();
						}
						System.out.println(RED_TEXT + WHITE_BACKGROUND
								+ "Masukkan jumlah bayar yang valid & tidak mencapai 1 miliar atau lebih!"
								+ RESET_COLOR);
						isPaymentProcessValid = false;
						continue;
					}
					int jumlahBayarCicilan = 0;
					long tempJumlahBayarCicilan = scanner.nextLong();
					scanner.nextLine();
					int uangKembalian = 0;
					if (tempJumlahBayarCicilan < tempCreditPayment.pay() || tempJumlahBayarCicilan > 999999999) {
						System.out.println(RED_TEXT + WHITE_BACKGROUND
								+ "Pastikan uang Anda cukup dan tidak mencapai 1 miliar atau lebih!" + RESET_COLOR);
						isPaymentProcessValid = false;
						continue;
					}
					jumlahBayarCicilan = (int) tempJumlahBayarCicilan;
					if (jumlahBayarCicilan > tempCreditPayment.pay()
							&& jumlahBayarCicilan / tempCreditPayment.pay() >= 2
							&& tempCreditPayment.getRemainingAmount() > 0) {
						do {
							continueLooping = false;
							int cicilBulanDepan = (jumlahBayarCicilan / tempCreditPayment
									.pay() > (tempCreditPayment.maxInstallmentAmount - tempCreditPayment.installment)
											? ((tempCreditPayment.maxInstallmentAmount - tempCreditPayment.installment)
													- 1)
											: (jumlahBayarCicilan / tempCreditPayment.pay() - 1));
							if (jumlahBayarCicilan / tempCreditPayment.pay() > 1 && jumlahBayarCicilan
									/ tempCreditPayment.pay() >= (tempCreditPayment.maxInstallmentAmount
											- tempCreditPayment.installment))
								cicilBulanDepan = (tempCreditPayment.maxInstallmentAmount
										- tempCreditPayment.installment) - 1;

							if (cicilBulanDepan == 0) {
								continueLooping = true;
								continue;
							}

							System.out.print(YELLOW_TEXT
									+ "Anda membayar lebih dari yang seharusnya!\nApakah sisa tersebut ingin Anda bayar untuk cicilan "
									+ cicilBulanDepan + " bulan berikutnya juga (Y/N)? " + RESET_COLOR);

							String forwardInstallment = scanner.nextLine();
							switch (forwardInstallment.toLowerCase()) {
							case "y":
							case "ya":
							case "yes":
								tempCreditPayment.installment += 1;
//								System.out.println("tcp i " + tempCreditPayment.installment);
//								System.out.println("cbd " + cicilBulanDepan);
								if (cicilBulanDepan
										+ tempCreditPayment.installment >= tempCreditPayment.maxInstallmentAmount) {
									System.out.println(GREEN_TEXT + "Cicilan Anda telah lunas!" + RESET_COLOR);
									uangKembalian = jumlahBayarCicilan - itemBought.getPrice();
									if (uangKembalian > 0)
										System.out.println(YELLOW_TEXT + "Sisa kembalian Anda sejumlah: "
												+ uangKembalian + RESET_COLOR);
									tempCreditPayment.isPaidOff = true;
								} else {
									tempCreditPayment.installment += cicilBulanDepan;
									System.out.println(GREEN_TEXT + "Berhasil membayar cicilan sampai bulan ke-"
											+ tempCreditPayment.installment + "!" + RESET_COLOR
											+ "\nSisa cicilan Anda:\n" + tempCreditPayment.getRemainingAmount()
											+ " dalam tempo "
											+ (tempCreditPayment.maxInstallmentAmount - tempCreditPayment.installment)
											+ " bulan kedepan!");
									uangKembalian = jumlahBayarCicilan
											- (tempCreditPayment.installment * tempCreditPayment.pay());
									if (uangKembalian > 0)
										System.out.println(YELLOW_TEXT + "Sisa kembalian Anda sejumlah: "
												+ uangKembalian + RESET_COLOR);
								}
//								if (jumlahBayarCicilan % tempCreditPayment.pay() > 0)
//									System.out.println(YELLOW_TEXT + "Sisa kembalian Anda sejumlah: "
//											+ jumlahBayarCicilan % tempCreditPayment.pay() + RESET_TEXT);
//								ListOfPayments.add(tempCreditPayment);
								break;
							case "n":
							case "tidak":
							case "no":
								tempCreditPayment.installment += 1;
								System.out.println(
										YELLOW_TEXT + "Sisa kembalian Anda sejumlah: " + uangKembalian + RESET_COLOR);
								System.out.println(GREEN_TEXT + "Berhasil membayar cicilan untuk bulan ke-"
										+ tempCreditPayment.installment + "!" + RESET_COLOR + "\nSisa cicilan Anda:\n"
										+ tempCreditPayment.getRemainingAmount() + " dalam tempo "
										+ (tempCreditPayment.maxInstallmentAmount - tempCreditPayment.installment)
										+ " bulan kedepan!");
								uangKembalian = jumlahBayarCicilan - itemBought.getPrice();
								System.out.println(YELLOW_TEXT
										+ "Transaksi berhasil!\nPastikan Anda membayar cicilan berikutnya sebelum tenggat berakhir!"
										+ RESET_COLOR);
								break;
							default:
								System.out.println(
										RED_TEXT + WHITE_BACKGROUND + "Silakan pilih opsi yang valid!" + RESET_COLOR);
								continueLooping = true;
								continue;
							}
						} while (continueLooping);
					} else if (jumlahBayarCicilan > tempCreditPayment.pay()
							&& tempCreditPayment.getRemainingAmount() > 0) {
						tempCreditPayment.installment += 1;
						uangKembalian = jumlahBayarCicilan - tempCreditPayment.pay();
						System.out.println(YELLOW_TEXT + "Sisa kembalian Anda sejumlah " + uangKembalian + RESET_COLOR);
						System.out.println(GREEN_TEXT + "Berhasil membayar cicilan untuk bulan ke-"
								+ tempCreditPayment.installment + "!" + RESET_COLOR + "\nSisa cicilan Anda:\n"
								+ tempCreditPayment.getRemainingAmount() + " dalam tempo "
								+ (tempCreditPayment.maxInstallmentAmount - tempCreditPayment.installment)
								+ " bulan kedepan!");
						System.out.println(YELLOW_TEXT
								+ "Pesanan telah tersimpan!\nPastikan Anda membayar cicilan berikutnya sebelum tenggat berakhir!"
								+ RESET_COLOR);
					} else {
						tempCreditPayment.installment += 1;
						System.out.println(GREEN_TEXT + "Berhasil membayar cicilan untuk bulan ke-"
								+ tempCreditPayment.installment + "!" + RESET_COLOR + "\nSisa cicilan Anda:\n"
								+ tempCreditPayment.getRemainingAmount() + " dalam tempo "
								+ (tempCreditPayment.maxInstallmentAmount - tempCreditPayment.installment)
								+ " bulan kedepan!");
						System.out.println(YELLOW_TEXT
								+ "Pesanan telah tersimpan!\nPastikan Anda membayar cicilan berikutnya sebelum tenggat berakhir!"
								+ RESET_COLOR);
					}
				} while (!isPaymentProcessValid);
			} else {
				isPaymentProcessValid = false;
//				System.out.println(
//						RED_TEXT + "Terjadi masalah saat memproses pembayaran!\nSilakan coba lagi nanti" + RESET_COLOR);
//				System.out.println(isPaymentProcessValid + " " + isPaymentCancelled);
//				return new PaymentResult(isPaymentProcessValid, isPaymentCancelled);
			}
//			System.out.println(isPaymentProcessValid + "   adadad  " + isPaymentCancelled);
			return new PaymentResult(isPaymentProcessValid, isPaymentCancelled);
		}

		public static void main(String[] args) {
			int opt = 0;
			boolean continueLooping = false;
			boolean isCancelled = false;
			seedData();
			do {
				continueLooping = false;
				System.out.println("---Program Toko Elektronik---");
				System.out.println("1. Pesan Barang");
				System.out.println("2. Lihat Pesanan");
				System.out.println("0. Keluar");
				System.out.print("Pilih: ");
				if (!scanner.hasNextInt()) {
					scanner.nextLine();
					System.out.println(RED_TEXT + WHITE_BACKGROUND + "Silakan pilih opsi yang valid!" + RESET_COLOR);
					continueLooping = true;
					continue;
				}
				opt = scanner.nextInt();
				scanner.nextLine();
				if (opt == 1) {
					Item tempItem = null;

					listItems();

//					System.out.println("----Daftar Barang----");
//					for (int i = 0; i < ListOfItems.size(); i++) {
//						System.out.println("No\t\t: " + (i + 1));
//						ListOfItems.get(i).displayInfo();
//						System.out.println("----------------------------");
//					}

					do {
						boolean isDigit = false;
						continueLooping = false;
						isCancelled = false;
						String itemSearch = null;

						System.out.print("Pilih: ");

						while ((itemSearch = scanner.nextLine().trim()).isEmpty()) {
						}

						isDigit = itemSearch.matches("\\d+");
						if (!isDigit)
							itemSearch = itemSearch.replaceAll("\s+", " ");

						if (itemSearch.equalsIgnoreCase("0")) {
							System.out.println(YELLOW_TEXT + "Membatalkan pesanan..." + RESET_COLOR);
							isCancelled = true;
							break;
						}

						tempItem = handleItemSearch(itemSearch, isDigit);

						if (tempItem == null) {
							System.out.println(RED_TEXT + WHITE_BACKGROUND
									+ "Barang tidak ditemukan!\nPastikan Anda telah memasukkan nomor/nama barang yang benar!"
									+ RESET_COLOR);
							continueLooping = true;
						}
					} while (continueLooping && !isCancelled);

					if (isCancelled)
						continue;

					int tipePembayaran = -1;

					do {
						final int TOTAL_PAYMENT_METHODS = 2;
						continueLooping = false;
						tempItem.displayInfo();
						System.out.println("----Tipe Pembayaran----");
						System.out.println("1. Cash");
						System.out.println("2. Credit");
						System.out.print("Pilih: ");
						if (!scanner.hasNextInt()) {
							scanner.nextLine();
							System.out.println(RED_TEXT + WHITE_BACKGROUND
									+ "Silakan pilih metode pembayaran yang valid!" + RESET_COLOR);
							continueLooping = true;
							continue;
						}
						tipePembayaran = scanner.nextInt();
						scanner.nextLine();

						if (tipePembayaran == 0) {
							System.out.println(YELLOW_TEXT + "Membatalkan pesanan..." + RESET_COLOR);
							isCancelled = true;
							break;
						}

						if (tipePembayaran < 0 || tipePembayaran > TOTAL_PAYMENT_METHODS) {
							System.out.println(RED_TEXT + WHITE_BACKGROUND + "Pilihlah metode pembayaran yang tersedia!"
									+ RESET_COLOR);
							continueLooping = true;
							continue;
						}
					} while (continueLooping);

					if (isCancelled)
						continue;

					PaymentResult paymentResult = handlePayment(null, tipePembayaran, tempItem);
					if (paymentResult.isPaymentCancelled)
						System.out.println(YELLOW_TEXT + "Pesanan berhasil dibatalkan!" + RESET_COLOR);
					else if (!paymentResult.isPaymentDone)
						System.out.println(RED_TEXT + WHITE_BACKGROUND
								+ "Gagal membuat pesanan! Silakan coba lagi nanti" + RESET_COLOR);
				} else if (opt == 2) {
					Payment tempPayment = null;

					if (ListOfPayments.isEmpty()) {
						System.out.println(YELLOW_TEXT + "Belum ada transaksi yang dilakukan!" + RESET_COLOR);
						continue;
					}

					listPayments();

					do {
						continueLooping = false;
						isCancelled = false;
						String paymentSearch = null;

						System.out.print("Pilih: ");

						while ((paymentSearch = scanner.nextLine().trim()).isEmpty()) {
						}

						if (!paymentSearch.matches("[\\d]+")) {
							System.out.println(RED_TEXT + WHITE_BACKGROUND
									+ "Silakan masukkan nomor transaksi yang valid!" + RESET_COLOR);
							continueLooping = true;
							continue;
						}

						if (paymentSearch.equalsIgnoreCase("0")) {
							System.out.println(YELLOW_TEXT + "Kembali Ke Menu Utama..." + RESET_COLOR);
							isCancelled = true;
							break;
						}

						tempPayment = handlePaymentSearch(paymentSearch);

						if (tempPayment == null) {
							System.out.println(RED_TEXT + WHITE_BACKGROUND
									+ "Pesanan/transaksi tidak ditemukan!\nPastikan Anda telah memasukkan nomor transaksi yang benar!"
									+ RESET_COLOR);
							continueLooping = true;
						}
					} while (continueLooping && !isCancelled);

					if (isCancelled)
						continue;

					String paymentClassName = tempPayment.getClassName() != null ? tempPayment.getClassName() : null;
//
					if (paymentClassName == null) {
						System.out.println(RED_TEXT
								+ "Terjadi kesalahan saat mencoba melakukan transaksi!\nSilakan coba lagi nanti"
								+ RESET_COLOR);
						continue;
					}

					tempPayment.displayInfo();

					PaymentResult paymentResult = null;
					if (paymentClassName.equalsIgnoreCase("cash")) {
						paymentResult = handlePayment(tempPayment, 1, tempPayment.item);
					} else if (paymentClassName.equalsIgnoreCase("credit")) {
						paymentResult = handlePayment(tempPayment, 2, tempPayment.item);
					}

					if (paymentResult.isPaymentCancelled)
						System.out.println(YELLOW_TEXT + "Transaksi berhasil dibatalkan!" + RESET_COLOR);
					else if (!paymentResult.isPaymentDone || paymentResult == null)
						System.out.println(RED_TEXT + WHITE_BACKGROUND
								+ "Gagal melakukan transaksi! Silakan coba lagi nanti" + RESET_COLOR);
				} else if (opt == 0) {
					System.out.println("Terima Kasih :)");
				} else {
					System.out.println(RED_TEXT + WHITE_BACKGROUND + "Silakan pilih aksi yang valid!" + RESET_COLOR);
				}
			} while (opt != 0 || continueLooping);
		}
	}
}
