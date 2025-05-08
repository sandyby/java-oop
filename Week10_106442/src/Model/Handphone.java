package Model;

public class Handphone extends Barang {
	private String warna;
	public static int total;

	public Handphone(String id, String nama, double harga, int stok, String warna) {
		this.id = id;
		this.harga = harga;
		this.nama = nama;
		this.stok = stok;
		this.warna = warna;
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
		super.setIsVoucher(false);
	}

	public String getColor() {
		return warna;
	}
}
