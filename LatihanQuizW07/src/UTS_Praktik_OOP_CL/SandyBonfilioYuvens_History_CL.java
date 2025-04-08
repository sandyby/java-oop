package UTS_Praktik_OOP_CL;

import java.time.LocalDateTime;

public abstract class SandyBonfilioYuvens_History_CL {
	private String tanggal;
	private String jenis;
	private long nominal;

	public SandyBonfilioYuvens_History_CL(String jenis, long nominal) {
		this.tanggal = null;
		this.jenis = jenis;
		this.nominal = nominal;
	}

	public void setTanggal() {
		this.tanggal = LocalDateTime.now().toString();
	}

	public String getTanggal() {
		return tanggal;
	}

	public String getJenis() {
		return jenis;
	}

	public long getNominal() {
		return nominal;
	}
}
