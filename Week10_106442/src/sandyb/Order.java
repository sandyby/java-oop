package sandyb;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import Model.Barang;

public class Order {
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

	private String id;

	private int jumlahBarang;
	public static int total;

	public HashMap<Barang, Integer> barangList;
	private String tanggalPemesanan;
	private boolean isPaymentDone;
	private double uangBayaran;

	public Order() {
	}

	public Order(String id, HashMap<Barang, Integer> barangList) {
		this.id = id;
		this.jumlahBarang = 0;
		this.barangList = barangList;
		this.tanggalPemesanan = null;
		this.isPaymentDone = false;
	}

	public Order(String id) {
		this.id = id;
		this.jumlahBarang = 0;
		this.barangList = new HashMap<Barang, Integer>();
		this.tanggalPemesanan = null;
		this.isPaymentDone = false;
	}

	public Order(String id, Voucher voucher, int jumlah) {
		this.id = id;
		this.jumlahBarang = 0;
		this.barangList = new HashMap<Barang, Integer>();
		this.tanggalPemesanan = null;
		this.isPaymentDone = false;
	}

	public void setJumlahBarang() {
		this.jumlahBarang += 1;
	}

	public void setPaymentDone(boolean isPaymentDone) {
		this.isPaymentDone = isPaymentDone;
	}

	public void setBarangList(HashMap<Barang, Integer> barangList) {
		System.out.println(barangList.getOrDefault(barangList, 0));
//			setTotalQuantityBarang();
		this.barangList = barangList;
	}

	public void setTanggalPemesanan(String tanggalPemesanan) {
		this.tanggalPemesanan = tanggalPemesanan;
	}

	public void setUangBayaran(double uangBayaran) {
		this.uangBayaran = uangBayaran;
	}

	public String getId() {
		return id;
	}

	public int getJumlahBarang() {
		return jumlahBarang;
	}

	public boolean getPaymentDone() {
		return isPaymentDone;
	}

	public HashMap<Barang, Integer> getBarangList() {
		return barangList;
	}

	public String getTanggalPemesanan() {
		return tanggalPemesanan;
	}

	public boolean addBarangToList(Barang barang, int qty) {
		if (this.getBarangList().put(barang, qty) != null) {
			return true;
		}
		return false;
	}

	public double calculateTotalPriceBeforeTax(HashMap<Barang, Integer> barangList) {
		double totalPriceBeforeTax = 0;
		for (Entry<Barang, Integer> b : barangList.entrySet()) {
			totalPriceBeforeTax += (b.getValue() * b.getKey().getPrice());
//				System.out.println("debug");
//				System.out.println(b.getValue());
//				System.out.println(b.getKey().getPrice());

		}
//			System.out.println("Tes");
//			System.out.println(totalPriceBeforeTax);
//			System.out.println(rupiahFormat.format(totalPriceBeforeTax));
		/* katanya better performance */

//			double totalPriceBeforeTax = 0;
//			double temp;
//			barangList.forEach((barang, qty) -> {
//				BeforeTax += (barang.getPrice() * qty);
//			});

		return totalPriceBeforeTax;
	}

	public boolean cancelOrder(Order order) {
		String orderID = order.getId();

		return false;
	}

	@Override
	public String toString() {
		return "Order{" + "ID=" + id + ", Barang= " + getBarangList() + ", Tipe Barang= " + getBarangList()
				+ ", Tanggal Pemesanan= " + (tanggalPemesanan != null ? tanggalPemesanan : "Belum ditentukan")
				+ ", Total Quantity Barang= " + jumlahBarang + ", " + (isPaymentDone ? "Sudah Bayar" : "Belum Bayar")
				+ '}';
	}

	public void orderDisplay() {
		boolean isVoucher = false;
		double tax = 0;
		Random rand = new Random();
		long randomID = Math.abs(rand.nextLong());
		HashMap<Barang, Integer> currItem = getBarangList();
		System.out.println(String.format(
				"\t\tsandytopup.com\t\t\n\t      Jl. Jl. Di Hati Mu\n---------- Order %s ----------\n\t      %s\n",
				randomID, getTanggalPemesanan()));
		for (Entry<Barang, Integer> b : currItem.entrySet()) {
			isVoucher = b.getKey().getIsVoucher();
			if (isVoucher) {
				Voucher tempVoucher = (Voucher) b.getKey();
				tax = tempVoucher.getTax();
			}
			System.out.println(b.getValue() + " @ " + b.getKey().getName() + "\t@1 / Rp"
					+ rupiahFormat.format(b.getKey().getPrice()) + "\n\t\t\tRp"
					+ rupiahFormat.format((b.getKey().getPrice() * b.getValue())));
		}
		double totalHargaSebelumTax = calculateTotalPriceBeforeTax(currItem);
		double totalHargaSetelahTax = totalHargaSebelumTax + (totalHargaSebelumTax * tax);
		System.out.println("SUBTOTAL\tRp" + rupiahFormat.format(totalHargaSebelumTax) + "\nSERVICE CHARGE\t"
				+ YELLOW_TEXT + "Rp" + rupiahFormat.format(totalHargaSetelahTax - totalHargaSebelumTax) + " ("
				+ tax * 100 + "%)" + RESET_COLOR + "\nGRAND TOTAL\tRp" + rupiahFormat.format(totalHargaSetelahTax));
		System.out.println("-------------------------");
		System.out.println("PAYMENT TOTAL\t" + RED_TEXT + "Rp" + rupiahFormat.format(uangBayaran) + RESET_COLOR
				+ "\nRETURN CHANGE\t" + GREEN_TEXT + "Rp" + rupiahFormat.format((uangBayaran - totalHargaSetelahTax))
				+ RESET_COLOR);
		System.out.println("-----------------------------------------------\n");
	}
}
