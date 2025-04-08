package UTS_Praktik_OOP_CL;

import java.util.ArrayList;

public interface SandyBonfilioYuvens_Transaction_CL {
	boolean menabung(long nominal);

	boolean menarik(long nominal);

	boolean transfer(long nominal, int rekeningTujuan);

	ArrayList<SandyBonfilioYuvens_History_CL> getHistory();
}