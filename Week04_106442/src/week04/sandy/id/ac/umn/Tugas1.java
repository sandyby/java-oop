package week04.sandy.id.ac.umn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Tugas1 {
	private static ArrayList<Barang> barangList = new ArrayList<>();
	private static ArrayList<Order> orderHistory = new ArrayList<>();
	private static ArrayList<Order> shoppingCart = new ArrayList<>();
	private static int jumlahBarang = 0;
	public static final String RED_TEXT = "\u001B[31m";
	public static final String GREEN_TEXT = "\u001B[32m";
	public static final String YELLOW_TEXT = "\u001B[33m";
	public static final String WHITE_BACKGROUND = "\u001B[47m";
	public static final String BLACK_BACKGROUND = "\u001B[40m";
	public static final String YELLOW_BACKGROUND = "\u001B[43m";
	public static final String RED_BACKGROUND = "\u001B[41m";
	public static final String RESET_COLOR = "\u001B[0m";
	public static Scanner scanner = new Scanner(System.in);
	public static Random random = new Random();

	public static void main(String[] args) {
		int mainMenuChoice = -1, continueChoice = -1;
		boolean cont = false, isOptionValid = true;
		initBarang();
//		initOrder();
		do {
			try {
				cont = false;
				countItemInList();
				showMenu();
				System.out.print("Pilihan : ");
				mainMenuChoice = scanner.nextInt();
				Barang barangPilihan = null;
				switch (mainMenuChoice) {
				case 1:
					if (barangList.isEmpty()) {
						System.out.println(
								"Saat ini tidak ada barang yang tersedia untuk dipesan!\nSilakan coba lagi nanti");
						cont = true;
						break;
					}
					HashMap<Barang, Integer> currentList = null;
					Order currentPesanan = new Order(orderHistory.size() + 1);
					int barangPesanan = -1, jumlahPesanan = -1, jumlahBarang = -1;
					boolean isPesananValid = true;
					boolean addBarang = false;
					boolean isPesananCancelled = false;
					boolean isPaymentDone = false;
					do {
						addBarang = false;
						isPesananValid = true;
						isPesananCancelled = false;
						isPaymentDone = false;
						showOrderMenu();
						System.out.println("Ketik 0 untuk batal!");
						System.out.print("Pesan Barang : ");
						try {
							barangPesanan = scanner.nextInt();
							if (barangPesanan == 0) {

								/* implementasi add to shopping cart? */

								isPesananCancelled = true;
								System.out.print("Pesanan berhasil dibatalkan!"
										+ "\nApakah Anda masih ingin melakukan pemesanan barang lain? ");
								continueChoice = scanner.nextInt();
								if (continueChoice != 0) {
									cont = true;
								}
								break;
							}

							if (barangPesanan < 0 || barangPesanan > barangList.size()) {
								isPesananValid = false;
								System.out.println(RED_TEXT + WHITE_BACKGROUND + "Silakan pilih barang yang tersedia!"
										+ RESET_COLOR);
								continue;
							}

							barangPilihan = barangList.get(barangPesanan - 1);

							if (barangPilihan.getStockEmpty()) {
								isPesananValid = false;
								System.out.println(
										RED_TEXT + WHITE_BACKGROUND + "Barang sedang habis! Tunggu yaa" + RESET_COLOR);
								continue;
							}

							do {
								isPesananValid = true;
								int jumlahTempStok = barangPilihan.getTempStock();
								int jumlahStokDiKeranjang = barangPilihan.getStock() - barangPilihan.getTempStock();
								System.out.println(
										"--------------------" + barangPilihan.getName() + "--------------------");
								System.out.println("Stok\t: " + barangPilihan.getStock());
//								System.out.println("Temp Stok\t: " + barangPilihan.getTempStock());
								System.out.println("Harga\t: Rp" + barangPilihan.getPrice());
								if (jumlahTempStok < barangPilihan.getStock()) {
									System.out.println(YELLOW_TEXT + WHITE_BACKGROUND + "(" + (jumlahStokDiKeranjang)
											+ ") barang yang sama sudah ada di shopping cart " + RESET_COLOR);
								}
								System.out.println("--------------------"
										+ barangPilihan.getName().replace(barangPilihan.getName(),
												("-").repeat(barangPilihan.getName().length()))
										+ "--------------------");
								System.out.print("Masukkan Jumlah Pesanan: ");
								jumlahPesanan = scanner.nextInt();
								if (jumlahPesanan < 1 || jumlahPesanan > barangPilihan.getStock()) {
									isPesananValid = false;
									System.out.println(RED_TEXT + WHITE_BACKGROUND
											+ "Silakan masukkan jumlah pemesanan sesuai stok yang tersedia!"
											+ RESET_COLOR);
									continue;
								} else if (jumlahPesanan > barangPilihan.getTempStock()
										|| jumlahPesanan > barangPilihan.getStock()
										|| (jumlahPesanan + (barangPilihan.getStock()
												- barangPilihan.getTempStock())) > barangPilihan.getStock()) {
									isPesananValid = false;
									System.out.println(RED_TEXT + WHITE_BACKGROUND + "Anda sudah memasukkan "
											+ jumlahStokDiKeranjang
											+ " barang ke dalam shopping\n cart! Anda tidak dapat menaruh melebihi stok\n yang tersedia!"
											+ RESET_COLOR);
									break;

									/* kalo niat & keburu, implemen sleep & opsi utk user change amount */
								}

								boolean isTempStokUpdated = (barangPilihan.minusTempStock(jumlahPesanan)) ? true
										: false;
								if (!isTempStokUpdated)
									isPesananValid = false;

//								System.out.println(!isPesananValid);
//								System.out.println(isTempStokUpdated);

								if (!isPesananValid && isTempStokUpdated) {
									barangPilihan.increaseTempStock(jumlahPesanan);
									break;
								}

//								System.out.println("tes111111111");
								currentList = currentPesanan.getBarangList();

								// setQuantityBarang total jangan lupa

								int oldQuantity = currentList.getOrDefault(barangPilihan, 0);
								currentList.put(barangPilihan, jumlahPesanan + oldQuantity);
//								System.out.println("333333");

//								for (Entry<Barang, Integer> b : currentList.entrySet()) {
//									System.out.println("tes111111111");
//									System.out.println(b);
//								}

//								System.out.println("tes2222222");
								System.out.println(
										"Berhasil menambahkan " + barangPilihan.getName() + " ke shopping cart!");
								System.out.print("Apakah Anda ingin menambah barang lain? ");
								int addMore = scanner.nextInt();
								if (addMore == 1) {
									addBarang = true;
									break;
								}
							} while (!isPesananValid);
						} catch (InputMismatchException i) {
							System.out.println(
									RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan input yang benar!" + RESET_COLOR);
							scanner.next();
							isPesananValid = false;
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println(
									RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan angka yang valid!" + RESET_COLOR);
							scanner.next();
							isPesananValid = false;
						} finally {
//							System.out.println(isPesananValid);
//							System.out.println(addBarang);
//							System.out.println(isPesananCancelled);
						}
					} while ((!isPesananValid || addBarang) && !isPesananCancelled);

					if (isPesananCancelled) {
						for (Entry<Barang, Integer> curr : currentList.entrySet()) {
							Barang barang = curr.getKey();
							Integer qty = curr.getValue();
//								System.out.println(barang);
//								System.out.println(qty);
//								System.out.println(barang.getStock());
//								System.out.println(barang.getTempStock());
							barang.increaseTempStock(qty);
//								System.out.println(barang.getStock());
//								System.out.println(barang.getTempStock());
						}
						break;
					}

					boolean isUangCukup = true;
					boolean isPembayaranValid = true;
					long totalHargaSebelumTax = currentPesanan.calculateTotalPriceBeforeTax(currentList);
					long tax = (long) (totalHargaSebelumTax * 0.1);
					long totalHargaSetelahTax = totalHargaSebelumTax + tax;
//					System.out.print(totalHargaSebelumTax);
//					System.out.print(totalHargaSetelahTax);
					long jumlahUangPembayaran = -1, jumlahUangKembalian = -1;
					do {
						try {
							for (Entry<Barang, Integer> b : currentList.entrySet()) {
								currentPesanan.setTotalQuantityBarang(b.getValue());
								// System.out.println("tes111111111");
								// System.out.println(b.getValue());
								// System.out.println(b.getKey());
								System.out.println(b.getValue() + " @ " + b.getKey().getName() + "\t@1 / Rp"
										+ b.getKey().getPrice() + "\n\t\t\tRp"
										+ (b.getKey().getPrice() * b.getValue()));
							}
							// System.out.println(jumlahPesanan + " @ " + barangPilihan.getName()
							// + " dengan harga:\nSUBTOTAL\tRp" + totalHargaSebelumTax + "\nSERVICE
							// CHARGE\tRp" + tax
							// + "\nGRAND TOTALRp\t" + totalHargaSebelumTax);
							isPembayaranValid = true;
							System.out.println("SUBTOTAL\tRp" + totalHargaSebelumTax + "\nSERVICE CHARGE\tRp" + tax
									+ "\nGRAND TOTAL\tRp" + totalHargaSetelahTax);
							System.out.print("Masukkan jumlah uang pembayaran: ");
							jumlahUangPembayaran = scanner.nextLong();
							isUangCukup = true;
							if (jumlahUangPembayaran < totalHargaSetelahTax) {
								isUangCukup = false;
								System.out.println(RED_TEXT + WHITE_BACKGROUND + "Jumlah uang Anda tidak mencukupi!"
										+ RESET_COLOR);
								continue;
							}
							currentPesanan.setUangBayaran(jumlahUangPembayaran);
						} catch (InputMismatchException i) {
							System.out.println(
									RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan input yang benar!" + RESET_COLOR);
							scanner.next();
							isPembayaranValid = false;

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println(
									RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan angka yang valid!" + RESET_COLOR);
							scanner.next();
							isPembayaranValid = false;
						} finally {
//							System.out.println(isUangCukup);
//							System.out.println(isPembayaranValid);
						}
					} while (!isUangCukup || !isPembayaranValid);
//					System.out.println("tasdaksjdkadjaskdjkasd");
					jumlahUangKembalian = jumlahUangPembayaran - totalHargaSetelahTax;
					System.out.println(
							GREEN_TEXT + WHITE_BACKGROUND + "Kembalian Anda: Rp" + jumlahUangKembalian + RESET_COLOR);
					LocalDateTime dateTimeLocal = LocalDateTime.now();
					DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//					System.out.println(dateTimeLocal.format(dateTimeFormat));
					System.out.println("Berhasil memesan! Silakan tunggu paket Anda diantar yaa 😁🙏🙏🙏🙏🙏😎");
					currentPesanan.setTanggalPemesanan(dateTimeLocal.format(dateTimeFormat));
					isPaymentDone = true;

					if (isPaymentDone) {
						currentPesanan.setPaymentDone(isPaymentDone);
						for (Entry<Barang, Integer> b : currentPesanan.getBarangList().entrySet()) {
							b.getKey().minusRealStock();
							currentPesanan.setJumlahBarang();
						}
						orderHistory.add(currentPesanan);
//						for (Order o : shoppingCart) {
//							System.out.println(o.toString());
//						}
//						for (Order o2 : orderHistory) {
//							System.out.println(o2.toString());
//						}
					}
					isPesananValid = true;
					do {
						try {
							System.out.print("Apakah Anda masih ingin melakukan transaksi lain? ");
							continueChoice = scanner.nextInt();
							if (continueChoice != 0) {
								cont = true;
							}
							isOptionValid = true;
						} catch (InputMismatchException i) {
							isOptionValid = false;
//							i.printStackTrace();
							System.out.println(
									RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan input yang benar!" + RESET_COLOR);
							scanner.next();
						} catch (Exception e) {
							System.out.println(
									RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan angka yang valid!" + RESET_COLOR);
							scanner.next();
						}
					} while (!isOptionValid);
					break;
				case 2:
					for (Order o : orderHistory) {
//						System.out.println(o.toString());
						o.orderDisplay();
					}
					do {
						try {
							System.out.print("Apakah Anda masih ingin melakukan transaksi lain? ");
							continueChoice = scanner.nextInt();
							if (continueChoice != 0) {
								cont = true;
							}
							isOptionValid = true;
						} catch (InputMismatchException i) {
							isOptionValid = false;
//							i.printStackTrace();
							System.out.println(
									RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan input yang benar!" + RESET_COLOR);
							scanner.next();
						} catch (Exception e) {
							System.out.println(
									RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan angka yang valid!" + RESET_COLOR);
							scanner.next();
						}
					} while (!isOptionValid);
					break;
				case 3:
					do {
						addBarang();
						System.out.println("Apakah Anda masih ingin menambahkan barang lain? ");
						continueChoice = scanner.nextInt();
					} while (continueChoice == 1);
					break;
				case -1:
					System.out.println("Terima Kasih Sudah Berbelanja di Shio Pi");
					System.exit(0);
				default:
					System.out
							.println(RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan input yang valid!" + RESET_COLOR);
					break;
				}
			} catch (InputMismatchException i) {
				System.out.println(RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan input yang benar!" + RESET_COLOR);
				scanner.next();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan angka yang valid!" + RESET_COLOR);
				scanner.next();
			}
		} while (cont || mainMenuChoice < 1 || mainMenuChoice > 2);
		System.out.println("Terima Kasih Sudah Berbelanja di Shio Pi");
		System.exit(0);
	}

	public static void showMenu() {
		System.out.println("------------Menu Toko Multiguna------------");
		System.out.println("1. Pesan Barang");
		System.out.println("2. Lihat Pesanan");
	}

	public static void showOrderMenu() {
		System.out.println("Daftar Barang Toko Multiguna");
		for (Barang b : barangList) {
			boolean isStokEmpty = b.getStockEmpty();
			boolean isTempStokEmpty = b.getTempStockEmpty();
			if (b.getTempStock() <= 0) {
				b.setStockEmpty(isTempStokEmpty);
				isTempStokEmpty = true;
			} else if (b.getStock() <= 0) {
				b.setStockEmpty(isStokEmpty);
				isStokEmpty = true;
			}
			System.out.println("ID\t: " + b.getId());
			System.out.println("Nama\t: " + b.getName());
			if (isStokEmpty)
				System.out.println("Stok\t: \t" + YELLOW_TEXT + RED_BACKGROUND + "HABIS" + RESET_COLOR);
			else
				System.out.println("Stok\t: " + b.getStock());
			System.out.println("Harga\t: Rp" + b.getPrice());
			System.out.println("----------------------------------------");
		}
	}

	public static void countItemInList() {
		jumlahBarang = barangList.size();
		System.out.println("Jumlah barang di list: " + jumlahBarang);
	}

	public static void addBarang() {
		System.out.println("Tambah Barang");
		int id = barangList.size() + 1;
		System.out.println("ID\t: " + id);
		System.out.print("Nama\t: ");
		scanner.nextLine();
		String nama = scanner.nextLine();
		System.out.print("Stok\t: ");
		int stok = scanner.nextInt();
		int harga = -1;
		do {
			try {
				System.out.print("Harga\t: ");
				harga = scanner.nextInt();
				if (harga < 0)
					System.out.println(RED_TEXT + WHITE_BACKGROUND + "Harga masa mines mas broo" + RESET_COLOR);
			} catch (Exception e) {
				System.out.println(RED_TEXT + WHITE_BACKGROUND + "Silakan masukkan harga yang valid!" + RESET_COLOR);
				scanner.next();
			}
		} while (harga < 0);

		/*
		 * Barang tempBarang = new Barang(id, nama, stok, harga); bisa constructor jg
		 */

		Barang tempBarang = new Barang();
		tempBarang.setId(id);
		tempBarang.setName(nama);
		tempBarang.setPrice(harga);
		tempBarang.setStockEmpty(false);
		tempBarang.setTempStockEmpty(false);
		if (stok <= 0) {
			tempBarang.setStock(0);
			tempBarang.setStockEmpty(true);
		} else {
			tempBarang.setStock(stok);
		}
		tempBarang.setTempStock(tempBarang.getStock());
		tempBarang.setTempStockEmpty(tempBarang.getTempStockEmpty());

		barangList.add(tempBarang);
		System.out.println("Berhasil menambah barang " + tempBarang.getName() + "!");
		jumlahBarang++;
	}

	public static void initBarang() {
//		int id, int stok, int harga, String nama, int tempStok, boolean isStokEmpty,
//		boolean isTempStokEmpty
		barangList.add(new Barang(1, 2000, 1000000, "Sabu", 2000, false, false));
		barangList.add(new Barang(2, 200, 2000, "Sabun", 200, false, false));
	}

	public static void initOrder() {
		orderHistory.add(new Order(1));
	}
}
