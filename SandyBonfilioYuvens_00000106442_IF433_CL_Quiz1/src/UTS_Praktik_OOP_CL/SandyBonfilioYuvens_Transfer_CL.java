package UTS_Praktik_OOP_CL;

public class SandyBonfilioYuvens_Transfer_CL extends SandyBonfilioYuvens_History_CL {
	private int sourceRekening;
	private int toRekening;

	public SandyBonfilioYuvens_Transfer_CL(long nominal, int sourceRekening, int toRekening) {
		super("Transfer", nominal);
		this.sourceRekening = sourceRekening;
		this.toRekening = toRekening;
	}

	public int getSourceRekening() {
		return sourceRekening;
	}

	public int getToRekening() {
		return toRekening;
	}
}
