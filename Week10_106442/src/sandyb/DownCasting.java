package sandyb;

import sandyb.UpCasting.Pekerja;

public class DownCasting {
	public static class CEO extends Pekerja {
		public CEO() {
		}

		public void tanyaIdentitas() {
			System.out.println("Saya seorang CEO!");
		}

		public void tanyaPendapatan() {
			System.out.println("Pendapatan saya 100 juta per bulan!");
		}
	}

	public static class Main {
		public static void main(String[] args) {
			// an example of down casting,
			// where we cast an instance of CEO that is
			// stored inside a Pekerja data type,

			CEO c = new CEO();
			Pekerja p = new CEO();
			// p.tanyaPendapatan();

			// gives an error, even though p is storing an instance of CEO,
			// we can't access the method inside the CEO, unless we casted/stored
			// it inside a CEO data type
			c = (CEO) p;
			c.tanyaPendapatan();
		}
	}
	
	/*
	 * Output:
	 * Pendapatan saya 100 juta per bulan!
	 */
}
