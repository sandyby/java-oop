package sandyb;

public class UpCasting {
	public static class Pekerja {
		public Pekerja() {
		}

		public void tanyaIdentitas() {
			System.out.println("Saya pekerja biasa!");
		}
	}

	public static class CEO extends Pekerja {
		public CEO() {
		}

		public void tanyaIdentitas() {
			System.out.println("Saya seorang CEO!");
		}
	}

	public static class Karyawan extends Pekerja {
		public Karyawan() {
		}

		public void tanyaIdentitas() {
			System.out.println("Saya seorang karyawan!");
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Pekerja pekerja = new Pekerja();
			pekerja.tanyaIdentitas();

			// here is an example of up casting, where we
			// assign an object/instance of CEO to Pekerja
			pekerja = new CEO();
			pekerja.tanyaIdentitas();

			// another example, we can cast Karyawan as a Pekerja
			Karyawan karyawan = new Karyawan();
			pekerja = (Pekerja) karyawan;
			pekerja.tanyaIdentitas();
		}
	}

	/*
	 * Outputs: Saya pekerja biasa!
	 * Saya seorang CEO!
	 * Saya seorang karyawan!
	 */
}
