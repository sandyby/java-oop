package week04.sandy.id.ac.umn;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

public class Order {
	private int id;
	private int jumlahBarang;
	public HashMap<Barang, Integer> barangList;
	private String tanggalPemesanan;
	public int totalQuantityBarang;
	private boolean isPaymentDone;
	private long uangBayaran;

	public Order() {
	}

	public Order(int id, HashMap<Barang, Integer> barangList) {
		this.id = id;
		this.jumlahBarang = 0;
		this.barangList = barangList;
		this.tanggalPemesanan = null;
		this.totalQuantityBarang = 0;
		this.isPaymentDone = false;
	}

	public Order(int id) {
		this.id = id;
		this.jumlahBarang = 0;
		this.barangList = new HashMap<Barang, Integer>();
		this.tanggalPemesanan = null;
		this.totalQuantityBarang = 0;
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
//		setTotalQuantityBarang();
		this.barangList = barangList;
	}

	public void setTanggalPemesanan(String tanggalPemesanan) {
		this.tanggalPemesanan = tanggalPemesanan;
	}

	public void setUangBayaran(long uangBayaran) {
		this.uangBayaran = uangBayaran;
	}

	public int getId() {
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

	public int calculateTotalPriceBeforeTax(HashMap<Barang, Integer> barangList) {
		int totalPriceBeforeTax = 0;
		for (Entry<Barang, Integer> b : barangList.entrySet()) {
			totalPriceBeforeTax += (int) (b.getValue() * b.getKey().getPrice());
//			System.out.println("debug");
//			System.out.println(b.getValue());
//			System.out.println(b.getKey().getPrice());
		}
		return totalPriceBeforeTax;
	}

	public void setTotalQuantityBarang(int qty) {
		this.totalQuantityBarang += qty;
	}

	public boolean cancelOrder(Order order) {
		int orderID = order.getId();

		return false;
	}

	@Override
	public String toString() {
		return "Order{" + "ID=" + id + ", Jumlah Barang Dalam 1 Order= " + jumlahBarang + ", Barang= " + getBarangList()
				+ ", Tanggal Pemesanan= " + (tanggalPemesanan != null ? tanggalPemesanan : "Belum ditentukan")
				+ ", Total Quantity Barang= " + totalQuantityBarang + ", "
				+ (isPaymentDone ? "Sudah Bayar" : "Belum Bayar") + '}';
	}

	public void orderDisplay() {
		Random rand = new Random();
		long randomID = Math.abs(rand.nextLong());
		HashMap<Barang, Integer> currBarang = getBarangList();
//		for (Barang barang : currBarang.keySet()) {
//			System.out.println(barang.getName());ks
//		}
		System.out.println(
				String.format("\t\tSHIO PI\t\t\n\tJl. Medang Lestari No. 2\n---------- Order %s ----------\n\t%s\n",
						randomID, getTanggalPemesanan()));
		for (Entry<Barang, Integer> b : currBarang.entrySet()) {
			System.out.println(b.getValue() + " @ " + b.getKey().getName() + "\t@1 / Rp" + b.getKey().getPrice()
					+ "\n\t\t\tRp" + (b.getKey().getPrice() * b.getValue()));
		}
		long totalHargaSebelumTax = calculateTotalPriceBeforeTax(currBarang);
		long tax = (long) (totalHargaSebelumTax * 0.1);
		long totalHargaSetelahTax = totalHargaSebelumTax + tax;
		System.out.println("SUBTOTAL\tRp" + totalHargaSebelumTax + "\nSERVICE CHARGE\tRp" + tax + "\nGRAND TOTAL\tRp"
				+ totalHargaSetelahTax);
		System.out.println("-------------------------");
		System.out.println(
				"PAYMENT TOTAL\tRp" + uangBayaran + "\nRETURN CHANGE\tRp" + (uangBayaran - totalHargaSetelahTax));

		System.out.println("-----------------------------------------------");
	}
}
