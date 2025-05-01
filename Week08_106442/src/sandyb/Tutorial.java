package sandyb;

public class Tutorial {
	public static abstract class Payment {
		protected double amount;

		public Payment(double amount) {
			this.amount = amount;
		}

		abstract void processPayment();

		public void paymentDetails() {
			System.out.println("Processing payment of $" + amount);
		}
	}

	public static class CreditCardPayment extends Payment {
		private String cardNumber;

		public CreditCardPayment(double amount, String cardNumber) {
			super(amount);
			this.cardNumber = cardNumber;
		}

		@Override
		void processPayment() {
			System.out.println("Processing credit card payment of $" + amount + " for card number " + cardNumber);
		}
	}

	public static class BankTransferPayment extends Payment {
		private String bankAccount;

		public BankTransferPayment(double amount, String bankAccount) {
			super(amount);
			this.bankAccount = bankAccount;
		}

		@Override
		void processPayment() {
			System.out.println("Processing bank transfer payment of $" + amount + " for bank account " + bankAccount);
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Payment creditCardPayment = new CreditCardPayment(100.0, "!234-5678-9012-3456");
			Payment bankTransferPayment = new BankTransferPayment(300.0, "9876543210");

			creditCardPayment.paymentDetails();
			creditCardPayment.processPayment();

			bankTransferPayment.paymentDetails();
			bankTransferPayment.processPayment();
		}
	}
}
