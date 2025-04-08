package week03.sandy.id.ac.umn;

public class PreludeString {
	public static void main(String[] args) {
		String pbo1 = "Pemrograman Berorientasi Objek";
		String pbo2 = new String("Pemrograman Berorientasi Objek");

		System.out.println(pbo1);
		System.out.println(pbo2);
		System.out.println(pbo1.length());
		System.out.println(pbo1.charAt(12));
		System.out.println(pbo1.substring(24));
		System.out.println(pbo1.substring(12, 24));

		String kode = "IF402 - ";
		String out = kode.concat(pbo1);
		System.out.print(out);
	}
}
