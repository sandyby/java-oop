package week04.sandy.id.ac.umn;

public class Barang {
	private int id;
	private int stok;
	private int harga;
	private String nama;
	private int tempStok;
	private boolean isStokEmpty;
	private boolean isTempStokEmpty;

	public Barang() {
	}

	public Barang(int id, int stok, int harga, String nama, int tempStok, boolean isStokEmpty,
			boolean isTempStokEmpty) {
		this.id = id;
		this.stok = stok;
		this.harga = harga;
		this.nama = nama;
		this.tempStok = tempStok;
		this.isStokEmpty = isStokEmpty;
		this.isTempStokEmpty = isTempStokEmpty;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStock(int stok) {
		this.stok = stok;
		this.tempStok = stok;
	}

	public void setPrice(int harga) {
		this.harga = harga;
	}

	public void setName(String nama) {
		this.nama = nama;
	}

	public void setTempStock(int tempStok) {
		this.tempStok = tempStok;
	}

	public void setStockEmpty(boolean isStokEmpty) {
		this.isStokEmpty = isStokEmpty;
	}

	public void setTempStockEmpty(boolean isTempStokEmpty) {
		this.isTempStokEmpty = isTempStokEmpty;
	}

	public int getId() {
		return id;
	}

	public int getStock() {
		return stok;
	}

	public int getPrice() {
		return harga;
	}

	public String getName() {
		return nama;
	}

	public int getTempStock() {
		return tempStok;
	}

	public boolean getStockEmpty() {
		if (stok <= 0) {
			setStockEmpty(true);
			return true;
		} else {
			setStockEmpty(false);
		}
		return false;
	}

	public boolean getTempStockEmpty() {
		if (tempStok <= 0) {
			setTempStockEmpty(true);
			return true;
		} else {
			setTempStockEmpty(false);
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
		return "Barang{" + "ID=" + id + ", Nama= " + nama + ", Sisa Stok= " + stok + ", Harga= Rp" + harga + '}';
	}
}