package sandyb;

public class CustomizedExceptions {
	public static class CustomException {
		public static void main(String[] args) {
			try {
				int[] arr = new int[4];
				int i = arr[4];
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static class AuthenticationException extends Exception {
		public AuthenticationException() {
			super("Anda telah mencapai jumlah batas login");
		}

		public AuthenticationException(String msg) {
			super(msg);
		}
	}

	public static class InvalidPropertyException extends Exception {
		public InvalidPropertyException() {
			super("Input data tidak valid!");
		}

		public InvalidPropertyException(String msg) {
			super(msg);
		}
	}

	public static class ExcessiveFailedLogInException extends Exception {
		public ExcessiveFailedLogInException() {
			super("Anda telah mencapai jumlah batas login!");
		}

		public ExcessiveFailedLogInException(String msg) {
			super(msg);
		}
	}

	public static class Main {

	}
}
