package Model;

public class Voucher extends Barang {
	private double pajak;
	public static int total;

	public Voucher(String id, String nama, double harga, int stok, double pajak) {
		this.id = id;
		this.harga = harga;
		this.nama = nama;
		this.stok = stok;
		this.pajak = (pajak * 100) / 100;
		super.setStockEmpty(false);
		super.setTempStockEmpty(false);
		if (stok <= 0) {
			super.setStock(0);
			super.setStockEmpty(true);
		} else {
			super.setStock(stok);
		}
		super.setTempStock(super.getStock());
		super.setTempStockEmpty(super.getTempStockEmpty());
		super.setIsVoucher(true);
	}

	public double getTax() {
		return pajak;
	}

	public double getSellingPrice(int qty) {
		double totalPriceBeforeTax = harga * qty;
		System.out.println(rupiahFormat.format(totalPriceBeforeTax));
		System.out.println(rupiahFormat.format((totalPriceBeforeTax * pajak)));
		System.out.println(rupiahFormat.format(totalPriceBeforeTax + (totalPriceBeforeTax * pajak)));
		return totalPriceBeforeTax + (totalPriceBeforeTax * pajak);
	}
}
