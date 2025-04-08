package UTS_Praktik_OOP_CL;

import java.util.ArrayList;

public class SandyBonfilioYuvens_User_CL implements SandyBonfilioYuvens_Transaction_CL {
	private String nama;
	private int noRekening = -1;
	private long saldo;
	private ArrayList<SandyBonfilioYuvens_History_CL> transactionsList = new ArrayList<>();

	public SandyBonfilioYuvens_User_CL() {
		this.saldo = 50000;
	}

	public SandyBonfilioYuvens_User_CL(String nama, int noRekening) {
		this.nama = nama;
		this.noRekening = noRekening;
		this.saldo = 50000;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public void setNoRekening(int noRekening) {
		this.noRekening = noRekening;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}

	public String getNama() {
		return nama;
	}

	public int getNoRekening() {
		return noRekening;
	}

	public long getSaldo() {
		return saldo;
	}

	@Override
	public boolean menabung(long nominal) {
		saldo += nominal;
		SandyBonfilioYuvens_Menabung_CL tempMenabung = new SandyBonfilioYuvens_Menabung_CL(nominal);
		tempMenabung.setTanggal();
		return transactionsList.add(tempMenabung);
	}

	@Override
	public boolean menarik(long nominal) {
		saldo -= nominal;
		SandyBonfilioYuvens_Menarik_CL tempMenarik = new SandyBonfilioYuvens_Menarik_CL(nominal);
		tempMenarik.setTanggal();
		return transactionsList.add(tempMenarik);
	}

	@Override
	public boolean transfer(long nominal, int rekeningTujuan) {
		if (saldo >= nominal) {
			saldo -= nominal;
		}
		SandyBonfilioYuvens_Transfer_CL tempTransfer = new SandyBonfilioYuvens_Transfer_CL(nominal, noRekening,
				rekeningTujuan);
		tempTransfer.setTanggal();
		return transactionsList.add(tempTransfer);
	}

	@Override
	public ArrayList<SandyBonfilioYuvens_History_CL> getHistory() {
		for (SandyBonfilioYuvens_History_CL transaction : transactionsList) {
			if (transaction.getJenis().equals("Menabung") || transaction.getJenis().equals("Menarik")) {
				System.out.println(
						transaction.getTanggal() + "-" + transaction.getJenis() + "-Rp" + transaction.getNominal());
			} else {
				SandyBonfilioYuvens_Transfer_CL tempTransfer = (SandyBonfilioYuvens_Transfer_CL) transaction;
				System.out.println(tempTransfer.getTanggal() + "-" + tempTransfer.getJenis() + "-Rp"
						+ tempTransfer.getNominal() + "-" + tempTransfer.getToRekening());
			}
		}
		return transactionsList;
	}
}
