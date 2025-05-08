package Model;

import java.text.DecimalFormat;

public class Barang {
	protected String id;
	protected double harga;
	protected String nama;
	protected int stok;
	protected int tempStok;
	protected boolean isStokEmpty;
	protected boolean isTempStokEmpty;
	protected boolean isVoucher;
	public static DecimalFormat rupiahFormat = new DecimalFormat("#,##0.00");

	public Barang() {
	}

	public Barang(String id, int stok, double harga, String nama, boolean isStokEmpty, boolean isTempStokEmpty,
			int tempStok) {
		this.id = id;
		this.stok = stok;
		this.harga = harga;
		this.nama = nama;
		this.tempStok = tempStok;
		this.isStokEmpty = isStokEmpty;
		this.isTempStokEmpty = isTempStokEmpty;
	}

	public void setStockEmpty(boolean isStokEmpty) {
		this.isStokEmpty = isStokEmpty;
	}

	public void setTempStockEmpty(boolean isTempStokEmpty) {
		this.isTempStokEmpty = isTempStokEmpty;
	}

	public void setStock(int stok) {
		this.stok = stok;
		this.tempStok = stok;
	}

	public void setTempStock(int tempStok) {
		this.tempStok = tempStok;
	}

	public void setIsVoucher(boolean isVoucher) {
		this.isVoucher = isVoucher;
	}

	public boolean getIsVoucher() {
		return isVoucher;
	}

	public String getId() {
		return id;
	}

	public int getStock() {
		return stok;
	}

	public double getPrice() {
//			System.out.println((Math.round((harga * 100.00)) / 100.00));
//			System.out.println(new DecimalFormat("#0.00").format(harga));
//			return (Math.round((harga * 100.00)) / 100.00);
//			return new DecimalFormat("#0.00").format(harga);
//			System.out.println(harga);
		String formattedPrice = rupiahFormat.format(harga).replaceAll(",", "");
//			System.out.println(formattedPrice);
//			System.out.println(Double.parseDouble(formattedPrice));
//			System.out.println("tes");
		return Double.parseDouble(formattedPrice);
	}

	public String getName() {
		return nama;
	}

	public int getTempStock() {
		return tempStok;
	}

	public boolean getStockEmpty() {
		if (stok <= 0) {
			this.isStokEmpty = true;
			return true;
		} else {
			this.isStokEmpty = false;
		}
		return false;
	}

	public boolean getTempStockEmpty() {
		if (tempStok <= 0) {
			this.isTempStokEmpty = true;
			return true;
		} else {
			this.isTempStokEmpty = false;
		}
		return false;
	}

	public void minusRealStock() {
		stok = tempStok;
	}

	public boolean minusTempStock(int qty) {
		if (tempStok >= qty) {
			tempStok -= qty;
			return true;
		}
		return false;
	}

	public void increaseTempStock(int qty) {
		tempStok += qty;
	}

	@Override
	public String toString() {
		return "Barang{" + "ID=" + id + ", Nama= " + nama + ", Sisa Stok= " + stok + ", Harga= Rp" + harga + "}\n";
	}
}
